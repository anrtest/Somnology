package com.carobar.somnology.shankit;

public class HourSelectionModel {
    private boolean isSelected = false;
    private String text = "";

    public HourSelectionModel(boolean isSelected, String text) {
        this.isSelected = isSelected;
        this.text = text;
    }

    public boolean isSelected() {
        return isSelected;
    }

    public void setSelected(boolean selected) {
        isSelected = selected;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
