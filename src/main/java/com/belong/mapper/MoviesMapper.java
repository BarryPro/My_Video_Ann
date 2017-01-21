package com.belong.mapper;

import com.belong.model.Article;
import com.belong.model.Movies;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.StatementType;
import org.apache.ibatis.type.JdbcType;

import java.util.ArrayList;
import java.util.Map;

public interface MoviesMapper {
    @Select({
            "SELECT Vsrc",
            "FROM movies",
            "WHERE Vid = #{vid,jdbcType=INTEGER}"
    })
    @Results({
            @Result(column="Vsrc", property="vsrc", jdbcType=JdbcType.LONGVARBINARY)
    })
    Movies getPath(Map map);

    @Select({
            "SELECT Vpic",
            "FROM movies",
            "WHERE Vid = #{vid,jdbcType=INTEGER}"
    })
    @Results({
            @Result(column="Vpic", property="vpic", jdbcType=JdbcType.LONGVARBINARY)
    })
    Movies getPic(Map map);

    @Update({
            "UPDATE movies",
            "SET views = views + 1",
            "WHERE Vid = #{vid,jdbcType=INTEGER}"
    })
    int views(Map map);


    @Select("call pro_pagenum1( " +
            " #{Vtype , mode=IN ,jdbcType=INTEGER}, " +
            " #{cur_page ,mode=IN ,jdbcType=INTEGER}, " +
            " #{Uid,  mode=IN ,jdbcType=INTEGER}, " +
            " #{row_num , mode=OUT ,jdbcType=INTEGER}, " +
            " #{row_total ,mode=OUT ,jdbcType=INTEGER}, " +
            " #{page_total,  mode=OUT ,jdbcType=INTEGER})")
    @Options(statementType = StatementType.CALLABLE)
    @Results({
            @Result(column="Vid", property="vid", jdbcType=JdbcType.INTEGER, id=true),
            @Result(column="Vdate", property="vdate", jdbcType=JdbcType.DATE),
            @Result(column="id", property="id", jdbcType=JdbcType.INTEGER),
            @Result(column="views", property="views", jdbcType=JdbcType.DECIMAL),
            @Result(column="Vname", property="vname", jdbcType=JdbcType.LONGVARCHAR),
            @Result(column="Vinfo", property="vinfo", jdbcType=JdbcType.LONGVARCHAR),
            @Result(column="Vpic", property="vpic", jdbcType=JdbcType.LONGVARBINARY),
            @Result(column="Vsrc", property="vsrc", jdbcType=JdbcType.LONGVARCHAR)
    })
    ArrayList<Movies> getInfo(Map map);

    @Select("call pro_pagenum2( " +
            " #{txt , mode=IN ,jdbcType=VARCHAR}, " +
            " #{cur_page ,mode=IN ,jdbcType=INTEGER}, " +
            " #{Uid,  mode=IN ,jdbcType=INTEGER}, " +
            " #{row_num , mode=OUT ,jdbcType=INTEGER}, " +
            " #{row_total ,mode=OUT ,jdbcType=INTEGER}, " +
            " #{page_total,  mode=OUT ,jdbcType=INTEGER} " +
            " )")
    @Options(statementType = StatementType.CALLABLE)
    @Results({
            @Result(column="Vid", property="vid", jdbcType=JdbcType.INTEGER, id=true),
            @Result(column="Vdate", property="vdate", jdbcType=JdbcType.DATE),
            @Result(column="id", property="id", jdbcType=JdbcType.INTEGER),
            @Result(column="views", property="views", jdbcType=JdbcType.DECIMAL),
            @Result(column="Vname", property="vname", jdbcType=JdbcType.LONGVARCHAR),
            @Result(column="Vinfo", property="vinfo", jdbcType=JdbcType.LONGVARCHAR),
            @Result(column="Vpic", property="vpic", jdbcType=JdbcType.LONGVARBINARY),
            @Result(column="Vsrc", property="vsrc", jdbcType=JdbcType.LONGVARCHAR)
    })
    ArrayList<Movies> search(Map map);

    @Insert("call pro_upload_movies( " +
            " #{_Vname , mode=IN ,jdbcType=LONGVARCHAR}, " +
            " #{_Vinfo ,mode=IN ,jdbcType=LONGVARCHAR}, " +
            " #{_Vpic,  mode=IN ,jdbcType=LONGVARBINARY}, " +
            " #{_Vsrc , mode=IN ,jdbcType=LONGVARCHAR}, " +
            " #{_id ,mode=IN ,jdbcType=INTEGER}, " +
            " #{_mytype,  mode=IN ,jdbcType=VARCHAR}, " +
            " #{_Vdirector ,mode=IN ,jdbcType=LONGVARCHAR}, " +
            " #{_Vactor,  mode=IN ,jdbcType=LONGVARCHAR} " +
            " )")
    @Options(statementType = StatementType.CALLABLE)
    int upload(Map map);

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
            @Result(column="Uid", property="uid", jdbcType=JdbcType.INTEGER),
            @Result(column="Agree", property="agree", jdbcType=JdbcType.INTEGER),
            @Result(column="Adate", property="adate", jdbcType=JdbcType.DATE),
            @Result(column="Vid", property="vid", jdbcType=JdbcType.INTEGER),
            @Result(column="Disagree", property="disagree", jdbcType=JdbcType.INTEGER),
            @Result(column="Acontent", property="acontent", jdbcType=JdbcType.LONGVARCHAR)
    })
    ArrayList<Article> query(Map map);
}
