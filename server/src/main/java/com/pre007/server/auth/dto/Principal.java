package com.pre007.server.auth.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Principal {
    private String email;
    private Long memberId;

}
