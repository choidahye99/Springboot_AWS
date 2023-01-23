package com.project.freelecspringbootwebservice.web.dto;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class HelloResponseDtoTest {

    @Test
    public void lombok(){
        String name = "test";
        int amount = 1000;

        HelloResponseDto dto = new HelloResponseDto(name, amount);

        //assertThat : assertj라는 테스트검증 라이브러리 검증 메소드
            //검증하고 싶은 대상을 메소드 인자로 받음
        //isEqualTo : assertThat에 있는 값과 isEqualTo의 값을 비교해서 같을 때만 성공
        assertThat(dto.getName()).isEqualTo(name);
    }


}
