package com.example.arch.ddd.board.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BoardCreateResponse {

    private Long seq;

    private String title;

    private String content;
}
