package com.example.arch.mvc.dto.response;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
//@NoArgsConstructor
public class MvcCreateResponse {

    private Long seq;

    private String title;

    private String content;

    public MvcCreateResponse() {
    }
}
