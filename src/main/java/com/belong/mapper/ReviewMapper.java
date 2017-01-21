package com.belong.mapper;

import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.type.JdbcType;

import java.util.Map;

public interface ReviewMapper {

    @Select({
        "select",
        "Vid, Vamount, Vdirector, Vactor",
        "from review",
        "where Vid = #{vid,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="Vid", property="vid", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="Vamount", property="vamount", jdbcType=JdbcType.VARCHAR),
        @Result(column="Vdirector", property="vdirector", jdbcType=JdbcType.LONGVARCHAR),
        @Result(column="Vactor", property="vactor", jdbcType=JdbcType.LONGVARCHAR)
    })
    int selectByPrimaryKey(Map map);

}
