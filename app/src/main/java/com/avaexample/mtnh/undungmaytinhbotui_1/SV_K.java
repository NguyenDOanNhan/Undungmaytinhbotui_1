package com.avaexample.mtnh.undungmaytinhbotui_1;

public class SV_K {
    private  String mName ;
    private  String mAddress;

    public SV_K(String mName, String mAddress) {

        this.mName = mName;
        this.mAddress = mAddress;
    }

    public String getmName() {
        return mName;
    }

    public void setmName(String mName) {
        this.mName = mName;
    }

    public String getmAddress() {
        return mAddress;
    }

    public void setmAddress(String mAddress) {
        this.mAddress = mAddress;
    }

    @Override
    public String toString() {
        return "SV_K{" +
                "mName='" + mName + '\'' +
                ", mAddress='" + mAddress + '\'' +
                '}';
    }
}
