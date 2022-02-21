package net.xdclass.xdvideo.controller;

import net.xdclass.xdvideo.config.WeChatConfig;
import net.xdclass.xdvideo.domain.JsonData;
import net.xdclass.xdvideo.mapper.VideoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author jinxm
 * @date 2022-02-18
 * @description
 */
@RestController
public class TestController {

    @RequestMapping("test")
    public String test() {
        return "hello net.xdclass5555";
    }

    @Autowired
    private WeChatConfig weChatConfig;

    @RequestMapping("test_config")
    public JsonData testConfig() {
        System.out.println(weChatConfig.getAppId());
        return JsonData.buildSuccess(weChatConfig.getAppId());
    }

    @Autowired
    private VideoMapper videoMapper;

    @RequestMapping("test_db")
    public Object testDB() {
        return videoMapper.findAll();
    }
}
