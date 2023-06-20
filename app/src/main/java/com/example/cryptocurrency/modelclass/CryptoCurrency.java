package com.example.cryptocurrency.modelclass;

import com.google.gson.annotations.SerializedName;

public class CryptoCurrency {
    private String id;
    private String name;
    private String symbol;
    private Integer rank;
    @SerializedName("is_new")
    private boolean isNew;
    @SerializedName("is_active")
    private boolean isActive;
    private String type;
}
