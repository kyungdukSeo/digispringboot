package web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

// REST vs. 이전 http://localhost/main.php?cmd=test&idx=3
// http://localhost/hello
// JSON(JavaScript Object Notation)를 매핑해준다
// Method의 종류 : GET, POST, PUT, DELETE

@RestController
public class HelloController
{

    @GetMapping("/hello")
    public String hello()
    {
        return "hello";
    }
}
