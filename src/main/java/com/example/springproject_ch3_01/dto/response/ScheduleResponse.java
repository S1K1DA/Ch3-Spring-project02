package com.example.springproject_ch3_01.dto.response;

import com.example.springproject_ch3_01.entity.Schedule;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@Builder
public class ScheduleResponse {

    private Long id;
    private Long userId;
    private String userName;
    private String title;
    private String content;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public static ScheduleResponse from(Schedule schedule) {
        return ScheduleResponse.builder()
                .id(schedule.getId())
                .userId(schedule.getUser().getId())
                .userName(schedule.getUser().getUserName())
                .title(schedule.getTitle())
                .content(schedule.getContent())
                .createdAt(schedule.getCreatedAt())
                .updatedAt(schedule.getUpdatedAt())
                .build();
    }
}

