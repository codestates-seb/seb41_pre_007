package com.pre007.server.dtoUtils;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class SingleResponseDto<T> {
    private T data;
}

/*
SingleResponseDto
: Json type 으로 응답을 제공할 때, http message 외의 응답 정보를 data 라는 하나의 묶음으로 묶어 제공하기 위함.
 */