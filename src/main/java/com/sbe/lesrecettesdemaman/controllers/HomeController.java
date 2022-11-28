package com.sbe.lesrecettesdemaman.controllers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/")
public class HomeController
{
    @Value("${application.version}")
    private String appVersion;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public Map getStatus()
    {
        Map map = new HashMap();
        map.put("app-version", appVersion);
        return map;
    }
}