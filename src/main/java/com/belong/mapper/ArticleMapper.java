package com.belong.mapper;

import com.belong.model.Article;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.StatementType;
import org.apache.ibatis.type.JdbcType;

import java.util.ArrayList;
import java.util.Map;

public interface ArticleMapper {
    @Insert({
            "INSERT INTO article(Acontent,Uid,Adate,Vid) ",
            "VALUES (#{article.acontent,jdbcType=LONGVARCHAR}, ",
            "#{article.uid,jdbcType=INTEGER}, ",
            "now(), ",
            "#{article.vid,jdbcType=INTEGER}) "
    })
    int addArticle(Map map);

    @Delete({
            " DELETE FROM article WHERE Aid = #{aid,jdbcType = INTEGER}"
    })
    int deleteArticle(Map map);

    @Update({
            "UPDATE article SET Acontent = #{article.acontent,jdbcType=LONGVARCHAR}"
    })
    int updateArticle(Map map);

    @Select({
            "SELECT * FROM article WHERE Aid = #{article.aid,jdbcType=INTEGER}"
    })
    @Results({
            @Result(column="Aid", property="aid", jdbcType=JdbcType.INTEGER, id=true),
            @Result(column="Uid", property="uid", jdbcType=JdbcType.INTEGER),
            @Result(column="Agree", property="agree", jdbcType=JdbcType.INTEGER),
            @Result(column="Adate", property="adate", jdbcType=JdbcType.DATE),
            @Result(column="Vid", property="vid", jdbcType=JdbcType.INTEGER),
            @Result(column="Disagree", property="disagree", jdbcType=JdbcType.INTEGER),
            @Result(column="Acontent", property="acontent", jdbcType=JdbcType.LONGVARCHAR)
    })
    Article queryArticleByAid(Map map);

    @Update({
            "UPDATE article SET Agree = Agree + 1 WHERE Aid = #{aid,jdbcType = INTEGER}"
    })
    int updataAgree(Map map);

    @Update({
            "UPDATE article SET Disagree = Disagree + 1 WHERE Aid = #{aid,jdbcType = INTEGER}"
    })
    int updataDisagree(Map map);

    @Select("call pro_pagenum3( " +
            " #{Uid , mode=IN ,jdbcType=INTEGER}, " +
            " #{a_Vid ,mode=IN ,jdbcType=INTEGER}, " +
            " #{cur_page,  mode=IN ,jdbcType=INTEGER}, " +
            " #{page_total , mode=OUT ,jdbcType=INTEGER}, " +
            " #{row_total ,mode=OUT ,jdbcType=INTEGER}, " +
            " #{a_pagenum,  mode=OUT ,jdbcType=INTEGER} " +
            " )")
    @Options(statementType = StatementType.CALLABLE)
    @Results({
            @Result(column="Aid", property="aid", jdbcType=JdbcType.INTEGER, id=true),
            @Result(column="Uid", property="user", jdbcType=JdbcType.INTEGER,
                    one = @One(select = "com.belong.mapper.UserMapper.queryUserById")),
            @Result(column="Agree", property="agree", jdbcType=JdbcType.INTEGER),
            @Result(column="Adate", property="adate", jdbcType=JdbcType.DATE),
            @Result(column="Vid", property="vid", jdbcType=JdbcType.INTEGER),
            @Result(column="Disagree", property="disagree", jdbcType=JdbcType.INTEGER),
            @Result(column="Acontent", property="acontent", jdbcType=JdbcType.LONGVARCHAR)
    })
    ArrayList<Article> query(Map map);




}
