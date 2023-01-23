package com.project.freelecspringbootwebservice.service.posts;

import com.project.freelecspringbootwebservice.domain.posts.PostsRepository;
import com.project.freelecspringbootwebservice.web.dto.PostSaveRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@RequiredArgsConstructor
@Service
public class PostsService {

    private final PostsRepository postsRepository;

    @Transactional
    public Long save(PostSaveRequestDto requestDto){
        return postsRepository.save(requestDto.toEntity()).getId();
    }
}