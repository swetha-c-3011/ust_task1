package com.task1.manager.model;

//import com.fasterxml.jackson.annotation.JsonProperty;

public class updateData {
    //@JsonProperty("eid")
    private int eId;
    //@JsonProperty("mid")
    private int mId;
    private String mName;
    public updateData() {
    }
    public updateData(int eId, int mId, String mName) {
        this.eId = eId;
        this.mId = mId;
        this.mName = mName;
    }
    public int geteId() {
        return eId;
    }
    public void seteId(int eId) {
        this.eId = eId;
    }
    public int getmId() {
        return mId;
    }
    public void setmId(int mId) {
        this.mId = mId;
    }
    public String getmName() {
        return mName;
    }
    public void setmName(String mName) {
        this.mName = mName;
    }
    
    
}
