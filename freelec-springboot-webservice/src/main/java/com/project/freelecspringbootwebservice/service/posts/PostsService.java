package com.project.freelecspringbootwebservice.service.posts;

import com.project.freelecspringbootwebservice.domain.posts.Posts;
import com.project.freelecspringbootwebservice.domain.posts.PostsRepository;
import com.project.freelecspringbootwebservice.web.dto.PostSaveRequestDto;
import com.project.freelecspringbootwebservice.web.dto.PostsUpdateRequestDto;
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

    @Transactional
    public Long update(Long id, PostsUpdateRequestDto requestDto){
        Posts posts = postsRepository.findById(id)
                .orElseThrow(() -> new IllegalAccessError("해당 게시글이 없습니다. id="+id));

        posts.update(requestDto.getTitle(), requestDto.getContent());

        return id;
    }


}
