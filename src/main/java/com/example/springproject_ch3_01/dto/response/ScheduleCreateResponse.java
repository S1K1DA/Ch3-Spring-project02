package com.example.springproject_ch3_01.dto.response;

import com.example.springproject_ch3_01.entity.Schedule;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@Builder
public class ScheduleCreateResponse {

    private Long id;
    private String author;
    private String title;
    private String content;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public static ScheduleCreateResponse from(Schedule schedule) {
        return ScheduleCreateResponse.builder()
                .id(schedule.getId())
                .author(schedule.getAuthor())
                .title(schedule.getTitle())
                .content(schedule.getContent())
                .createdAt(schedule.getCreatedAt())
                .updatedAt(schedule.getUpdatedAt())
                .build();
    }
}
