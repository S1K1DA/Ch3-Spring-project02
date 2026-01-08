package com.example.springproject_ch3_01.dto.request;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ScheduleCreateRequest {

    private String author;
    private String title;
    private String content;
}
