package com.example.mytradingapp.Shared.Transferobjects;

public class Item {

    private int type;
    private Object object;


    public Item(int type, Object object) {
        this.type = type;
        this.object = object;
    }


    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public Object getObject() {
        return object;
    }

    public void setObject(Object object) {
        this.object = object;
    }
}
