package com.carobar.somnology.core;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

import com.carobar.somnology.R;

import java.util.ArrayList;
import java.util.HashMap;

import de.halfbit.pinnedsection.PinnedSectionListView;


/**
 * Created by pradeep on 2/1/18.
 */


public class StickyAdapter extends ArrayAdapter<StickyAdapter.Item> implements PinnedSectionListView.PinnedSectionListAdapter{
    private Activity activity;
    private ArrayList<Item> resourceList;
    private LayoutInflater inflater = null;

    public StickyAdapter(Context context, int resource, int textViewResourceId) {
        super(context, resource, textViewResourceId);
        this.resourceList = generateResources();
    }
    public String[] getPopList(String listId){
        HashMap popListMap = new HashMap();
        String[] gudNightSleep = new String[]{
                "Keep a regular routine as well as bedtime and wake-up time.This helps your brain give you the right stages of sleep at the right part of the night!",
                "Stop using technology like computers, cell phones, and television.",
                "Relax with a warm bath, light reading, soothing music, stretching.",
                "De-clutter your mind by writing down your to-do list and worries, so you don’t mentally write these down when you are trying to sleep.",
                "Keep your bedroom cool and dark.",
                "Eat a small snack or drink a glass of warm milk before bed. Avoid caffeine!"
        };
        popListMap.put("gudNightSleep",gudNightSleep);

        String[] StimulusControlTherapy = new String[]{
                "Go to bed when feeling sleepy",
                "Get out of bed when not sleeping for more than about 15-20 mins",
                "Avoid naps",
                "Use bed and bedroom for sleep only",
                "Maintain regular waking schedule \n(weekdays, weekends and holidays)"
        };
        popListMap.put("StimulusControlTherapy",StimulusControlTherapy);

        String[] SleepRestrictionTherapy = new String[]{
                "Sleep Restriction Therapy (SRT) is the next level of behavioral therapy for insomnia. SRT uses controlled sleep deprivation. Sleep deprivation is used as a tool to help you fall and stay asleep.",
                "SRT begins with setting your desired wake-up time and then MobileSleepDoc assigns a bedtime for you that is 7 hours before your wake-up time. You are reminded to wind down an hour before bedtime so that you will be calm and not over-stimulated when you try to go to sleep.",
                "When you regularly sleep for the majority of the time you are in bed, MobileSleepDoc will ask you to go to bed earlier and earlier. SRT is completed when you feel refreshed when you wake up. If you do not feel refreshed after completing SRT, please see your doctor.",
        };
        popListMap.put("SleepRestrictionTherapy",SleepRestrictionTherapy);

        String[] StopBang = new String[]{
                "The STOP BANG questionnaire was adapted from Chung F. Yegneswaran B, Liao P. et al. STOP questionnaire: a tool to screen patients for obstructive sleep apnea. Anesthesiology 2008;108 (5) 812-821, and is used by permission form the author (F. Chung). Copyright owned by the American Society of Anesthesiology (ASA). A copy of the full text can be obtained from the ASA, 520 N. Northwest Highway, Park Ridge, Illinois 60068-2573"
        };
        popListMap.put("StopBang",StopBang);

        String[] EpworthSleepinessScale = new String[]{
                "The Epworth Sleepiness Scale was developed by Dr. Murray Johns (Johns, M.W. A new method for measuring daytime sleepiness: the Epworth Sleepiness Scale, Sleep, 1991; 14 (6): 540-545.) The ESS is used by permission. For more information please contact PROinformation@mapi-trust.org."
        };
        popListMap.put("EpworthSleepinessScale",EpworthSleepinessScale);

        String[] AboutMobileSleepDoc = new String[]{
                "© 2014 MobileSleepDoc, and its affiliates and assigns and licensors.All rights reserved.\n\nMobileSleepDoc is a simple, affordable tool for people suffering from poor sleep which is extremely common and life-altering.\n\nMobileSleepDoc is the first available sleep diagnosis and therapy application created by a sleep specialist, based on medical evidence but designed to be user friendly.\n\nUse MobileSleepDoc to sleep better tonight."
        };
        popListMap.put("AboutMobileSleepDoc",AboutMobileSleepDoc);

        String[] MusicianBios = new String[]{
                "Diana Stork\n\nhttp://harpdancer.com/\n\nHarpist, recording artist, and beloved teacher Diana Stork is well known in the international harp world for her eclectic style that incorporates ethnic, classical, and contemporary harp traditions. She has performed for diverse groups, such as Line’s Contemporary Ballet, the Maihar Orchestra of Maestro Ali Akbar Khan, and the Peace Ceremony of Thich Nhat Hahn at Grace Cathedral. Diana has toured Europe and the US performing world music and original compositions since 1987. Her large repertoire consists of Celtic, Latin and other world music styles, Hindustani ragas, European Classical, Medieval and Renaissance, and some popular tunes. She has generously recorded meditative and soothing pieces here exclusively for MobileSleepDoc.\n\nKarma Moffett\n\nhttp://karmamoffett.com/\n\nMusician and artist Karma Moffett has been playing ceremonial, handmade Tibetan temple bowls since 1974. He has accumulated 24 different bells carefully chosen for clarity and purity of sound, sustained resonance, and harmonic blending or pairing with other bowls within the set. He has created music for meditations, museums, yoga, tai chi, and special celebrations of all kinds. He added the Longhorn Native American flute and Conch shells to his music, which, along with the Tibetan bells, create harmonic vibrations that gently penetrate the body of the listener to guide them into a relaxed and meditative state. He has a gallery in San Francisco, CA and has played his music all over the world."
        };
        popListMap.put("MusicianBios",MusicianBios);






        return (String[])popListMap.get(listId);
    }
    public ArrayList<Item> generateResources(){
        String[] emptyList = new String[0];
        StickyAdapter.Item[] resources = new StickyAdapter.Item[]{
                createItem(1, "Follow Us", "", "section", emptyList,""),
                createItem(0, "Facebook", "https://www.facebook.com/somnology","http", emptyList,""),
                createItem(0, "Twitter", "https://twitter.com/somnologymd","http", emptyList,""),
                createItem(0, "Tumblr", "http://www.mobilesleepdoc.tumblr.com/", "http", emptyList,""),
                createItem(0, "YouTube", "https://www.youtube.com/channel/UCsOqJdrEa9bBUhDNSF25mIQ","http", emptyList,""),
                createItem(0, "Sleep Talk Blog", "https://www.somnologymd.com/sleeptalk-blog/","http", emptyList,""),

                //Tips
                createItem(1, "Tips", "","section", emptyList,""),
                createItem(0, "Tips for a Good Night's Sleep", "", "pop", getPopList("gudNightSleep"),""),
                createItem(0, "Stimulus Control Therapy", "", "pop", getPopList("StimulusControlTherapy"),"Stimulus Control Therapy or SCT is used to treat insomnia. One of the goals of SCT is to help associate your bed and bedroom with sleep rather than the inability to sleep. Another is to help you break habits that keep the vicious cycle of insomnia going such as staying in bed half the day to try to “catch up” on lost sleep. SCT helps you create new, healthy habits and encourages you to maintain a regular sleep/wake cycle.\\n\\nThere are 5 main principles:"),
                createItem(0, "Sleep Restriction Therapy", "", "pop", getPopList("SleepRestrictionTherapy"),""),

                //Find nearby doctor
                createItem(1, "Find Nearby Doctor or Sleep Center", "","section", emptyList,""),
                createItem(0, "View Map", "", "map", emptyList,""),

                //References
                createItem(1, "References", "","section", emptyList,""),
                createItem(0, "Sleep Metrics", "http://sleepmetrics.com","http", emptyList,""),
                createItem(0, "Australian Sleep Association", "http://www.sleep.org.au","http", emptyList,""),
                createItem(0, "British Sleep Society", "http://www.sleepsociety.org.uk","http", emptyList,""),
                createItem(0, "Canadian Sleep Society", "http://www.canadiansleepsociety.ca/","http", emptyList,""),
                createItem(0, "European Sleep Research Society", "http://www.esrs.eu/","http", emptyList,""),
                createItem(0, "National Center on Sleep Disorders Research", "https://www.nhlbi.nih.gov/about/ncsdr/","http", emptyList,""),
                createItem(0, "Sleep Research Society", "http://www.sleepresearchsociety.org/","http", emptyList,""),

                //Credits and copyright
                createItem(1, "Credits and Copyrights", "","section", emptyList,""),
                createItem(0, "Stop Bang", "","pop", getPopList("StopBang"),""),
                createItem(0, "Epworth Sleepiness Scale", "","pop", getPopList("EpworthSleepinessScale"),""),
                createItem(0, "About MobileSleepDoc", "","pop", getPopList("AboutMobileSleepDoc"),""),
                createItem(0, "Musician Bios", "","pop", getPopList("MusicianBios"),""),
        };
        final ArrayList<StickyAdapter.Item> resourceList = new ArrayList<StickyAdapter.Item>();
        for (StickyAdapter.Item item:resources) {
            resourceList.add(item);
        }
        return resourceList;
    }
    public StickyAdapter.Item createItem(int type, String text, String url, String dataType, String[] popValues, String shortDesc){
        StickyAdapter.Item item = new StickyAdapter.Item(type, text, url, dataType, popValues, shortDesc);
        return item;
    }
    @Override
    public int getCount(){
        return resourceList.size();
    }
    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public boolean hasStableIds() {
        return true;
    }
    @Override
    public Item getItem(int position){
        Item item = resourceList.get(position);
        return item;
    }
    public class ViewHolder {
        public TextView display_name;
        public TextView display_number;
        public Button rowButton;
    }
    @Override
    public  int getViewTypeCount(){
        return 2;
    }
    @Override
    public int getItemViewType(int position) {
        return getItem(position).type;
    }
    @Override
    public boolean isItemViewTypePinned(int viewType) {
        return viewType == Item.SECTION;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        TextView view = (TextView) super.getView(position, convertView, parent);
        view.setTextColor(Color.WHITE);
        view.setTag("" + position);
        Item item = getItem(position);
        if (item.type == Item.SECTION) {
            view.setBackgroundColor(parent.getResources().getColor(R.color.settingsButtonColor));
            view.setTextColor(parent.getResources().getColor(R.color.colorOrange));
        }
        return view;
    }

    public static class Item {

        public static final int ITEM = 0;
        public static final int SECTION = 1;

        public final int type;
        public final String text;
        public final String itemUrl;
        public final String dataType;
        public final String[] popList;
        public final String shortDesc;

        public int sectionPosition;
        public int listPosition;

        public Item(int type, String text, String url, String dataType, String[] popValues, String shortDesc) {
            this.type = type;
            this.text = text;
            this.itemUrl = url;
            this.dataType = dataType;
            this.popList = popValues;
            this.shortDesc = shortDesc;
        }
        public String getName(){
            return this.text;
        }
        public int getType(){
            return this.type;
        }
        public String getUrl(){
            return this.itemUrl;
        }
        public String[] getPopList() {return this.popList;}
        public String getShortDesc(){return this.shortDesc;}
        @Override
        public String toString() {
            return this.text;
        }

    }
}

