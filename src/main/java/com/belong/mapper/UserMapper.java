package com.belong.mapper;

import com.belong.model.User;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

import java.util.Map;

public interface UserMapper {

    @Select({
            "SELECT * ",
            "FROM user ",
            "WHERE username=#{user.username,jdbcType=VARCHAR} and ",
            "password=#{user.password,jdbcType=VARCHAR}"
    })
    @Results({
            @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
            @Result(column="username", property="username", jdbcType=JdbcType.VARCHAR),
            @Result(column="password", property="password", jdbcType=JdbcType.VARCHAR),
            @Result(column="pagenum", property="pagenum", jdbcType=JdbcType.INTEGER),
            @Result(column="pic", property="pic", jdbcType=JdbcType.LONGVARBINARY)
    })
    User login(Map map);

    @Select({
            "SELECT pic ",
            "FROM user ",
            "WHERE id = #{id,jdbcType=INTEGER}"
    })
    @Results({
            @Result(column="pic", property="pic", jdbcType=JdbcType.LONGVARBINARY)
    })
    User getPic(Map map);

    @Insert({
            "insert into user (username, ",
            "password ,pic) ",
            "values (",
            "#{user.username,jdbcType=VARCHAR}, ",
            "#{user.password,jdbcType=VARCHAR}, ",
            "#{user.pic,jdbcType=LONGVARBINARY})"
    })
    int register(Map map);

    @Update({
            "UPDATE user ",
            "SET pagenum = #{pagenum,jdbcType=INTEGER} ",
            "WHERE id = #{id,jdbcType=INTEGER} "
    })
    int updateVideoNumber(Map map);
}
