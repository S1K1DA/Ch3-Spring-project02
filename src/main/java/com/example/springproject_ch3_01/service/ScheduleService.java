package com.example.springproject_ch3_01.service;

import com.example.springproject_ch3_01.dto.request.ScheduleCreateRequest;
import com.example.springproject_ch3_01.dto.request.ScheduleUpdateRequest;
import com.example.springproject_ch3_01.dto.response.ScheduleCreateResponse;
import com.example.springproject_ch3_01.dto.response.ScheduleResponse;
import com.example.springproject_ch3_01.entity.Schedule;
import com.example.springproject_ch3_01.repository.ScheduleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ScheduleService {

    private final ScheduleRepository scheduleRepository;

    /**
     * 일정 생성
     */
    @Transactional
    public ScheduleCreateResponse createSchedule(ScheduleCreateRequest request) {
        // Request Dto -> Entity
        Schedule schedule = new Schedule(
                request.getAuthor(),
                request.getTitle(),
                request.getContent()
        );

        // DB 저장
        Schedule savedSchedule = scheduleRepository.save(schedule);

        // Entity -> Response DTO 변환
        return ScheduleCreateResponse.from(savedSchedule);
    }

    /**
     * 일정 전체 조회
     */
    @Transactional(readOnly = true)
    public List<ScheduleResponse> getSchedules() {
        return scheduleRepository.findAll()
                .stream()
                .map(ScheduleResponse::from)
                .toList();
    }

    /**
     * 일정 단건 조회
     */
    @Transactional(readOnly = true)
    public ScheduleResponse getSchedule(Long id) {
        Schedule schedule = scheduleRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 일정이 존재하지 않습니다."));
        return ScheduleResponse.from(schedule);
    }

    /**
     * 일정 삭제
     */
    @Transactional
    public void deleteSchedule(Long id) {
        Schedule schedule = scheduleRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 일정이 존재하지 않습니다."));
        scheduleRepository.delete(schedule);
    }

    /**
     * 일정 수정
     */
    @Transactional
    public ScheduleResponse updateSchedule(Long id, ScheduleUpdateRequest request) {

        Schedule schedule = scheduleRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 일정이 존재하지 않습니다."));

        schedule.update(request.getTitle(), request.getContent());

        return ScheduleResponse.from(schedule);
    }


}
