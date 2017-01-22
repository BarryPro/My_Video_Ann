package com.belong.mapper;

import com.belong.model.Review;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.type.JdbcType;

import java.util.Map;

public interface ReviewMapper {
    @Select({
            "SELECT * ",
            "FROM review r ",
            "JOIN movies m ON (r.Vid = m.Vid) ",
            "WHERE r.Vid = #{vid,jdbcType=INTEGER} "
    })
    @Results({
            @Result(column="Vid", property="video", jdbcType=JdbcType.INTEGER, id=true,
                    one = @One(select = "com.belong.mapper.MoviesMapper.queryMoviesByVid")),
            @Result(column="Vamount", property="vamount", jdbcType=JdbcType.VARCHAR),
            @Result(column="Vdirector", property="vdirector", jdbcType=JdbcType.LONGVARCHAR),
            @Result(column="Vactor", property="vactor", jdbcType=JdbcType.LONGVARCHAR)
    })
    Review review(Map map);

}
