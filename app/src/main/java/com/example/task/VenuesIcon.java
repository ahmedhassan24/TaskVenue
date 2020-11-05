package com.example.task;

import com.google.gson.annotations.SerializedName;

public class VenuesIcon {
    @SerializedName("prefix")
    String prefix;
    @SerializedName("suffix")
    String suffix;

    public String getPrefix() {
        return prefix;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    public String getSuffix() {
        return suffix;
    }

    public void setSuffix(String suffix) {
        this.suffix = suffix;
    }
    public String getIcon(){
        return this.prefix + "bg_32" + this.suffix;
    }
}
