package com.sst.template.models;

import com.google.gson.annotations.Expose;

/**
 * @author LongHV.
 */

public class Movie {

    @Expose
    public String poster_path;
    @Expose
    public boolean adult;
    @Expose
    public String overview;
    @Expose
    public String release_date;
    @Expose
    public int id;
    @Expose
    public String vote_average;
    @Expose
    public String title;
    @Expose
    public String original_title;

}