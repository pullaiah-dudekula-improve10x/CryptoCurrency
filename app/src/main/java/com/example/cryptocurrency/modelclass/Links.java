package com.example.cryptocurrency.modelclass;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class Links {

    private ArrayList<String> explorer;

    private ArrayList<String> facebook;

    private ArrayList<String> reddit;

    @SerializedName("source_code")
    private ArrayList<String> sourceCode;

    private ArrayList<String> website;

    private ArrayList<String> youtube;

    public ArrayList<String> getExplorer() {
        return explorer;
    }

    public void setExplorer(ArrayList<String> explorer) {
        this.explorer = explorer;
    }

    public ArrayList<String> getFacebook() {
        return facebook;
    }

    public void setFacebook(ArrayList<String> facebook) {
        this.facebook = facebook;
    }

    public ArrayList<String> getReddit() {
        return reddit;
    }

    public void setReddit(ArrayList<String> reddit) {
        this.reddit = reddit;
    }

    public ArrayList<String> getSourceCode() {
        return sourceCode;
    }

    public void setSourceCode(ArrayList<String> sourceCode) {
        this.sourceCode = sourceCode;
    }

    public ArrayList<String> getWebsite() {
        return website;
    }

    public void setWebsite(ArrayList<String> website) {
        this.website = website;
    }

    public ArrayList<String> getYoutube() {
        return youtube;
    }

    public void setYoutube(ArrayList<String> youtube) {
        this.youtube = youtube;
    }



}


