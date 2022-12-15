package com.ducktem.web.controller;

import com.ducktem.web.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TagController {

    @Autowired
    private TagService tagService;

    @GetMapping("/tag")
    public String tag() {
        tagService.get();


        return "/product";
    }
}
