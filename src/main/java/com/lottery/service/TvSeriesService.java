package com.lottery.service;

import com.lottery.dao.TvSeriesDao;
import com.lottery.entity.TvSeries;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TvSeriesService {

    @Autowired TvSeriesDao tvSeriesDao;

    public List<TvSeries> getAllTvServies(){
        return tvSeriesDao.getAll();
    }


}
