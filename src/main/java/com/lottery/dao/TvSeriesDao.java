package com.lottery.dao;


import com.lottery.entity.TvSeries;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TvSeriesDao {
    @Select("select * from user")
    public List<TvSeries> getAll();
}
