package com.kbstar.springboot.study.service;


import com.kbstar.springboot.study.domain.posts.Posts;
import com.kbstar.springboot.study.domain.posts.PostsRepository;
import com.kbstar.springboot.study.web.dto.PostsResponseDto;
import com.kbstar.springboot.study.web.dto.PostsSaveRequestDto;
import com.kbstar.springboot.study.web.dto.PostsUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

/*
    19. Service 등록

    자동으로 만들어지는 생성자
    public PostsService(PostsRepository postsRepository)
    {
        this.postsRepository=postsRepository;
    }

    Transaction : All or Nothing (전부다 성공하거나, 전부 실패)

 */

@RequiredArgsConstructor
@Service
public class PostsService
{
    private final PostsRepository postsRepository;

    @Transactional
    public Long save(PostsSaveRequestDto requestDto)
    {
        System.out.println("------------------------Post Service---------------------------- title = " + requestDto.getTitle());
        return postsRepository.save(requestDto.toEntity()).getId();

    }

    /*
        25. 업데이트를 위한 매핑(객체랑 DB)

        등록 : /api/v1/posts      <-- 새글 등록
        수정 : /api/v1/posts/3    <-- 3번글을 수정

        1) DTO -> Service -> Controller

     */

    @Transactional
    public Long update(Long id, PostsUpdateRequestDto requestDto)
    {
        Posts posts = postsRepository.findById(id).orElseThrow(()-> new IllegalArgumentException("No id for Post findById(id).orElseThrow : " + id));

        posts.update(requestDto.getTitle(), requestDto.getContent());

        return id;
    }

    public PostsResponseDto findById(Long id)
    {
        Posts posts = postsRepository.findById(id).orElseThrow(()-> new IllegalArgumentException("No id for Post findById(id).orElseThrow : " + id));
        return new PostsResponseDto(posts);
    }
}