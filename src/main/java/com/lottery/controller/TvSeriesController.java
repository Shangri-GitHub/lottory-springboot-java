package com.lottery.controller;

import com.lottery.entity.User;
import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.*;


@RestController
@RequestMapping("/tvseries")
public class TvSeriesController {

    private static final Logger logger = LoggerFactory.getLogger(TvSeriesController.class);

    @GetMapping()
    public Map <String, Object> sayHello() {
        Map <String, Object> result = new HashMap <>();
        result.put("message", "hello,world");
        return result;
    }


    @RequestMapping("/tvlist")
    public List <User> getAll() {
        List <User> list = new ArrayList <>();
        Date day = new Date();
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        list.add(new User("jack", "123456", df.format(day)));
        list.add(new User("jackon", "123456", df.format(day)));
        return list;
    }

    @RequestMapping("/{id}")
    public String getUserOne(@PathVariable int id) {
        if (id == 1) {
            return "第一集";
        } else if (id == 2) {
            return "第二集";
        } else {
            return "无";
        }
    }


    @PostMapping
    public User insert(@RequestBody User user) {
        logger.debug("" + user);
        return user;
    }

    /**
     * 文件的上传
     */

    @PostMapping(value = "/{id}/photos", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public void addPhoto(@PathVariable int id, @RequestParam("photo") MultipartFile multipartFile) throws Exception {
        logger.debug("" + id + "image" + multipartFile.getOriginalFilename());
        // 保存文件
        FileOutputStream fos = new FileOutputStream("target/" + multipartFile.getOriginalFilename());
        IOUtils.copy(multipartFile.getInputStream(), fos);
        fos.close();
    }

    /**
     * 文件的查看
     */
    @GetMapping(value = "/{id}/image", produces = MediaType.IMAGE_JPEG_VALUE)
    public byte[] getImage(@PathVariable int id) throws Exception {
        logger.debug("id" + id);
        String imageSrc = "src/test/1.png";
        InputStream is = new FileInputStream(imageSrc);
        return IOUtils.toByteArray(is);
    }


}
