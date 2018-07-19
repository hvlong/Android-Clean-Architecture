package com.sst.template.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * @author LongHV.
 */

public class MovieListResponse {

    @Expose
    public int id;
    @Expose
    public int page;
    @Expose
    public int total_pages;
    @Expose
    public int total_results;
    @SerializedName("results")
    public List<Movie> movieList;

}
