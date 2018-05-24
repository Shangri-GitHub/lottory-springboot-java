package com.lottery;

import com.lottery.entity.TvSeries;
import com.lottery.service.TvSeriesService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest

public class TvSeriesServiceTest {
    @Autowired
    TvSeriesService tvSeriesService;


    @Test
    public void contextload(){
        List<TvSeries> list = tvSeriesService.getAllTvServies();
        Assert.assertTrue(list.size()>0);
    }
}
