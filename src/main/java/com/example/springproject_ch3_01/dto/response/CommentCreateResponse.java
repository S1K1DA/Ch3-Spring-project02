package com.example.springproject_ch3_01.dto.response;

import com.example.springproject_ch3_01.entity.Comment;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@Builder
public class CommentCreateResponse {

    private Long id;
    private String content;
    private Long userId;
    private String userName;
    private Long scheduleId;
    private LocalDateTime createdAt;

    public static CommentCreateResponse from(Comment comment) {
        return CommentCreateResponse.builder()
                .id(comment.getId())
                .content(comment.getContent())
                .userId(comment.getUser().getId())
                .userName(comment.getUser().getUserName())
                .scheduleId(comment.getSchedule().getId())
                .createdAt(comment.getCreatedAt())
                .build();
    }
}