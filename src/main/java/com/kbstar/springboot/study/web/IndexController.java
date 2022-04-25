package com.kbstar.springboot.study.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/*
    34. IndexController.java
    http://kbstar.com/
    query가 없으면 index를 리턴한다
        index.mustache 파일이 있으면 이 파일이 index파일을 대체한다.

    header, tail 분리해서, 구조를 단순화 시키기
    resources/templates/layout 폴더
                               /header.mustache
 */
@Controller
public class IndexController
{
    @GetMapping("/")
    public String index()
    {
        return "index";
    }
}
