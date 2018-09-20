package com.carobar.somnology;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

public class webPage extends AppCompatActivity {
    WebView wpBrowser;
    ProgressBar progressBar;

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        // Check if the key event was the Back button and if there's history
        if ((keyCode == KeyEvent.KEYCODE_BACK) && wpBrowser.canGoBack()) {
            wpBrowser.goBack();
            return true;
        }
        // If it wasn't the Back key or there's no web page history, bubble up to the default
        // system behavior (probably exit the activity)
        return super.onKeyDown(keyCode, event);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_page);
        View headerView = findViewById(R.id.wpIncludedHeader);
        final TextView screeText = headerView.findViewById(R.id.headerViewScreenText);
        String screenName = getIntent().getStringExtra("screenName");
        screeText.setText(screenName);


        if(screenName != null && screenName.equalsIgnoreCase("Plex")){
            //Bottom Navigation View
            View btmBarView = findViewById(R.id.webViewIncludeFooter);
            btmBarView.setVisibility(View.VISIBLE);

            final bottomNavigation bottomNavigationView = new bottomNavigation();
            bottomNavigationView.ctxt = this;

            BottomNavigationView btmNavigationLeft = btmBarView.findViewById(R.id.navigationView);
            btmNavigationLeft.setOnNavigationItemSelectedListener(bottomNavigationView.mOnNavigationItemSelectedListener);

            BottomNavigationView btmNavigationRight = btmBarView.findViewById(R.id.navigationViewRight);
            btmNavigationRight.setOnNavigationItemSelectedListener(bottomNavigationView.mOnNavigationItemSelectedListener);

        }

        Button backButton = headerView.findViewById(R.id.back);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goBack(view);
            }
        });

        progressBar = findViewById(R.id.webViewProgressbar);

        final Activity activity = this;

        final String url = getIntent().getStringExtra("URL");
        wpBrowser = (WebView) findViewById(R.id.wpWebView);
        wpBrowser.setWebViewClient(new WpBrowser() );
        wpBrowser.getSettings().setJavaScriptEnabled(true);
        wpBrowser.setWebChromeClient(new WebChromeClient(){
            public void onProgressChanged(WebView view, int progress) {
                activity.setTitle("Loading...");
                activity.setProgress(progress * 100);

                if(progress == 100)
                    activity.setTitle(R.string.app_name);
            }
        });
        wpBrowser.loadUrl(url);

    }
    public void goBack(View view){
        //Intent intent = new Intent(this, Settings.class);
        //startActivity(this.getParentActivityIntent());
        this.finish();
    }
    private class WpBrowser extends WebViewClient {
        @Override
        public void onPageStarted(WebView view, String url, Bitmap favicon) {
            super.onPageStarted(view, url, favicon);
        }

        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            progressBar.setVisibility(View.VISIBLE);
            view.loadUrl(url);
            return false;
        }
        @Override
        public void onPageFinished(WebView view, String url) {

            super.onPageFinished(view, url);
            progressBar.setVisibility(View.GONE);
        }

    }
}
