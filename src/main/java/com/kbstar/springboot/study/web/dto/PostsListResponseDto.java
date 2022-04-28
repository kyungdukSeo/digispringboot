package com.kbstar.springboot.study.web.dto;

import com.kbstar.springboot.study.domain.posts.Posts;

import java.time.LocalDateTime;

public class PostsListResponseDto
{
    private Long id;            // idx 처럼 auto_increment 되는 것들은 Long 타입으로 선언한다
    private String title;
    private String content;     // 가져는 오지만 목록보기에서 사용하지 않을 예정
    private String author;
    private int view;
    private int rec;
    private LocalDateTime createDate;
    private String modifiedDate;

    public PostsListResponseDto(Posts entity)
    {
        // new PostsResponseDto
        this.id = entity.getId();
        this.title = entity.getTitle();
        this.author = entity.getAuthor();
        this.view = entity.getView();
        this.rec = entity.getRec();
        this.modifiedDate = entity.getModifiedDate();

    }

}
