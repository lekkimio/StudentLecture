package com.example.studentlecture.controller;


import com.example.studentlecture.service.ClassRoomService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/classrooms")
public class ClassRoomController {

    private final ClassRoomService classRoomService;


    @GetMapping("/{id}")
    public void getClassRoomById(@PathVariable Long id) {
        classRoomService.getClassRoomById(id);
    }

    @PostMapping
    public void addClassRoom() {
        classRoomService.addClassRoom();
    }

    @PutMapping("/{classRoomId}/students/{studentId}")
    public void addStudentToClassRoom(@PathVariable Long classRoomId, @PathVariable Long studentId) {
        classRoomService.addStudentToClassRoom(classRoomId, studentId);
    }


}
