package com.example.springproject_ch3_01.repository;

import com.example.springproject_ch3_01.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Long> {

    // 일정 하나의 달린 댓글 전체 조회
    List<Comment> findByScheduleIdOrderByCreatedAtAsc(Long scheduleId);
}
