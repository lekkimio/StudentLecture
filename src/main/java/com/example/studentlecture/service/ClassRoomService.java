package com.example.studentlecture.service;

import com.example.studentlecture.repo.ClassRoomRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ClassRoomService {

    private final ClassRoomRepository classRoomRepository;

    public void addClassRoom() {
    }

    public void addStudentToClassRoom(Long classRoomId, Long studentId) {
    }
}
