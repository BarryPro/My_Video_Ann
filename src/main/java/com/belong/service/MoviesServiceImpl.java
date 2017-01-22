package com.belong.service;

import com.belong.mapper.MoviesMapper;
import com.belong.mapper.ReviewMapper;
import com.belong.model.Movies;
import com.belong.model.Review;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Map;

/**
 * Created by belong on 16-11-6.
 */
@Service
public class MoviesServiceImpl implements IMoviesService{

    @Autowired
    private MoviesMapper dao;

    @Autowired
    private ReviewMapper rdao;

    @Override
    public Movies getPath(Map map) {
        return dao.getPath(map);
    }


    @Override
    public Movies getPic(Map map) {
        return dao.getPic(map);
    }

    @Override
    public ArrayList<Movies> search(Map map) {
        return dao.search(map);
    }

    @Override
    public int views(Map map) {
        return dao.views(map);
    }

    @Override
    public int upload(Map map) {
        return dao.upload(map);
    }

    @Override
    public Review review(Map map) {
        return rdao.review(map);
    }


    @Override
    public ArrayList<Movies> getInfo(Map map) {
        return dao.getInfo(map);
    }

}


