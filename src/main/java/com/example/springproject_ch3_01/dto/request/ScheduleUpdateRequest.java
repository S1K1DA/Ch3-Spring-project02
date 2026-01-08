package com.example.springproject_ch3_01.dto.request;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ScheduleUpdateRequest {

    private String title;
    private String content;
}
