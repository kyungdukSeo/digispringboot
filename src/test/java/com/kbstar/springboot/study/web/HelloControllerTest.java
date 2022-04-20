package com.kbstar.springboot.study.web;

import com.kbstar.springboot.study.web.HelloController;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

// 03. 아래 import는 처음 한번 직접 타이핑(Alt + Enter) 에서 없는 녀석 추가
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;


@ExtendWith(SpringExtension.class)
@WebMvcTest(controllers = HelloController.class)

public class HelloControllerTest
{
    @Autowired
    private MockMvc mvc;

    @Test
    public void helloReturnTest() throws Exception
    {
        String hello = "hello";

    }
}
