package com.sainivik.gridviewsample.model;

public class MyModel {
    private int type;
    private String headerName;

    public MyModel(int type, String headerName) {
        this.type = type;
        this.headerName = headerName;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getHeaderName() {
        return headerName;
    }

    public void setHeaderName(String headerName) {
        this.headerName = headerName;
    }
}
