package com.example.springproject_ch3_01.dto.response;

import com.example.springproject_ch3_01.entity.Schedule;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@Builder
public class SchedulePageResponse {

    private Long id;
    private String title;
    private String content;
    private int commentCount;
    private String userName;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public static SchedulePageResponse from(Schedule schedule) {
        return SchedulePageResponse.builder()
                .id(schedule.getId())
                .title(schedule.getTitle())
                .content(schedule.getContent())
                .commentCount(schedule.getComments().size())
                .userName(schedule.getUser().getUserName())
                .createdAt(schedule.getCreatedAt())
                .updatedAt(schedule.getUpdatedAt())
                .build();
    }
}
