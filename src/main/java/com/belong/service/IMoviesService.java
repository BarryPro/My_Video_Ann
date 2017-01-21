package com.belong.service;

import com.belong.model.Movies;
import com.belong.model.Review;

import java.util.ArrayList;
import java.util.Map;

/**
 * Created by belong on 16-11-6.
 */
public interface IMoviesService{
    Movies getPath(Map map);
    Movies getPic(Map map);
    ArrayList<Movies> search(Map map);
    int views(Map map);
    int upload(Map map);
    Review review(Map map);
    ArrayList<Movies> getInfo(Map map);
}
