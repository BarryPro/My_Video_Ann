package com.belong.mapper;

import com.belong.model.Article;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

import java.util.List;
import java.util.Map;

public interface ArticleMapper {

    @Results({
        @Result(column="Aid", property="aid", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="Uid", property="uid", jdbcType=JdbcType.INTEGER),
        @Result(column="Agree", property="agree", jdbcType=JdbcType.INTEGER),
        @Result(column="Adate", property="adate", jdbcType=JdbcType.DATE),
        @Result(column="Vid", property="vid", jdbcType=JdbcType.INTEGER),
        @Result(column="Disagree", property="disagree", jdbcType=JdbcType.INTEGER),
        @Result(column="Acontent", property="acontent", jdbcType=JdbcType.LONGVARCHAR)
    })
    List<Article> selectByExampleWithBLOBs(Map map);

}
