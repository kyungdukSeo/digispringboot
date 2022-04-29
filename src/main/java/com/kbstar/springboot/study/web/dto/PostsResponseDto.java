package com.kbstar.springboot.study.web.dto;

import com.kbstar.springboot.study.domain.posts.Posts;
import lombok.Getter;

import java.time.LocalDateTime;

/*
    23. Request에 대한 응답 데이터 만들기

    1
            DTO(4)
    2
            Entity(5)
    3

    -> 5를 이용해 4를 만듬

 */

@Getter
public class PostsResponseDto
{
    private Long id;            // idx 처럼 auto_increment 되는 것들은 Long 타입으로 선언한다
    private String title;
    private String content;     // 가져는 오지만 목록보기에서 사용하지 않을 예정
    private String author;
    private int view;
    private int rec;

    public PostsResponseDto(Posts entity)
    {
        // new PostsResponseDto
        this.id = entity.getId();
        this.title = entity.getTitle();
        this.content = entity.getContent(); //.replace("\n", "<br />");
        this.author = entity.getAuthor();
        this.view = entity.getView();
        this.rec = entity.getRec();
    }

}
