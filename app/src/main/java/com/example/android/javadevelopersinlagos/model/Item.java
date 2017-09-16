package com.example.android.javadevelopersinlagos.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Maro on 9/16/2017.
 */

public class Item {
    @SerializedName("login")
    @Expose
    private String login;
    @SerializedName("avatar_url")
    @Expose
    private String avatar_url;
    @SerializedName("html_url")
    @Expose
    private String html_url;

    public Item(String login, String avatar, String htmlurl) {
        this.login = login;
        this.avatar_url = avatar;
        this.html_url = htmlurl;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getAvatar_url() {
        return avatar_url;
    }

    public void setAvatar_url(String avatar_url) {
        this.avatar_url = avatar_url;
    }

    public String getHtml_url() {
        return html_url;
    }

    public void setHtml_url(String html_url) {
        this.html_url = html_url;
    }
}
