package com.example.springproject_ch3_01.controller;

import com.example.springproject_ch3_01.dto.request.ScheduleCreateRequest;
import com.example.springproject_ch3_01.dto.request.ScheduleUpdateRequest;
import com.example.springproject_ch3_01.dto.response.ScheduleCreateResponse;
import com.example.springproject_ch3_01.service.ScheduleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class ScheduleController {

    private final ScheduleService scheduleService;

    /**
     * 일정 생성
     */
    @PostMapping("/schedules")
    public ResponseEntity<ScheduleCreateResponse> createSchedule(@RequestBody ScheduleCreateRequest request) {
        ScheduleCreateResponse response = scheduleService.createSchedule(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    /**
     * 일정 전체 조회
     */
    @GetMapping("/schedules")
    public ResponseEntity<List<ScheduleCreateResponse>> getSchedules() {
        List<ScheduleCreateResponse> responses = scheduleService.getSchedules();
        return ResponseEntity.ok(responses);
    }

    /**
     * 일정 단건 조회
     */
    @GetMapping("/schedules/{id}")
    public ResponseEntity<ScheduleCreateResponse> getSchedule(@PathVariable Long id) {
        ScheduleCreateResponse response = scheduleService.getSchedule(id);
        return ResponseEntity.ok(response);
    }

    /**
     * 일정 삭제
     */
    @DeleteMapping("/schedules/{id}")
    public ResponseEntity<Void> deleteSchedule(@PathVariable Long id) {
        scheduleService.deleteSchedule(id);
        return ResponseEntity.noContent().build();
    }

    /**
     * 일정 수정
     */
    @PatchMapping("/schedules/{id}")
    public ResponseEntity<ScheduleCreateResponse> updateSchedule(@PathVariable Long id, @RequestBody ScheduleUpdateRequest request) {
        ScheduleCreateResponse response = scheduleService.updateSchedule(id, request);
        return ResponseEntity.ok(response);
    }

}
