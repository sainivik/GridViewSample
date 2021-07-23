package com.sainivik.gridviewsample.model;

public class MyData {
    private boolean isSelected;
    private String name;

    public boolean isSelected() {
        return isSelected;
    }

    public void setSelected(boolean selected) {
        isSelected = selected;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public MyData(boolean isSelected, String name) {
        this.isSelected = isSelected;
        this.name = name;
    }
}
