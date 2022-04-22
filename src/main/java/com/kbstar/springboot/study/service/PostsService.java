package com.kbstar.springboot.study.service;


import com.kbstar.springboot.study.domain.posts.PostsRepository;
import com.kbstar.springboot.study.web.dto.PostsSaveRequestDto;
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

}
