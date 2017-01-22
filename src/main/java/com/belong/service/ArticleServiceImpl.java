package com.belong.service;

import com.belong.mapper.ArticleMapper;
import com.belong.model.Article;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Map;

/**
 * Created by belong on 2017/1/10.
 */
@Service
public class ArticleServiceImpl implements IArticleService{
    @Autowired
    private ArticleMapper dao;

    @Override
    public int addArticle(Map map) {
        return dao.addArticle(map);
    }

    @Override
    public ArrayList<Article> queryArticle(Map map) {
        return dao.query(map);
    }

    @Override
    public int deleteArticle(Map map) {
        return dao.deleteArticle(map);
    }

    @Override
    public int updateArticle(Map map) {
        return dao.updateArticle(map);
    }

    @Override
    public Article queryArticleByAid(Map map) {
        return dao.queryArticleByAid(map);
    }

    @Override
    public int updateAgree(Map map) {
        return dao.updataAgree(map);
    }

    @Override
    public int updataDisagree(Map map) {
        return dao.updataDisagree(map);
    }

}
