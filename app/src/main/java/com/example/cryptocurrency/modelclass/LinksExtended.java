package com.example.cryptocurrency.modelclass;

import com.google.gson.annotations.SerializedName;

public class LinksExtended {
    private String url;
    private String type;

    @SerializedName("stats")
    private Stats Stats;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public com.example.cryptocurrency.modelclass.Stats getStats() {
        return Stats;
    }

    public void setStats(com.example.cryptocurrency.modelclass.Stats stats) {
        Stats = stats;
    }


}
