package com.kbstar.springboot.study.web.dto;

import com.kbstar.springboot.study.domain.posts.Posts;
import lombok.Getter;

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
    private String content;
    private String author;

    public PostsResponseDto(Posts entity)
    {
        // new PostsResponseDto
        this.id = entity.getId();
        this.title = entity.getTitle();
        this.content = entity.getContent();
        this.author = entity.getAuthor();

    }
}
