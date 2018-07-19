package com.sst.template.models;

import com.google.gson.annotations.Expose;

/**
 * @author LongHV.
 */

public class Movie {

    @Expose
    public String description;
    @Expose
    public int favorite_count;
    @Expose
    public int id;
    @Expose
    public String item_count;
    @Expose
    public String iso_639_1;
    @Expose
    public String list_type;
    @Expose
    public String name;
    @Expose
    public String poster_path;

}