package com.cos.security1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller  // View를 리턴하겠다
public class IndexController {

    @GetMapping({"","/"})
    public String index() {

        // mustache 기본 폴더 : src/main/resources
        // view resolver 설정 : templates (prefix) , .mustache(suffix) : 기본 설정값

        return "index";  // src/main/resources/templates/index.mustache 찾아감
    }

}
