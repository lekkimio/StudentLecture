package com.example.studentlecture.controller;


import com.example.studentlecture.model.ClassRoom;
import com.example.studentlecture.service.ClassRoomService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/classrooms")
public class ClassRoomController {

    private final ClassRoomService classRoomService;


    @GetMapping("/{id}")
    public ClassRoom getClassRoomById(@PathVariable Long id) {
        return classRoomService.getClassRoomById(id);
    }

    @PostMapping
    public ClassRoom addClassRoom() {
        return classRoomService.addClassRoom();
    }

    @PutMapping("/{classRoomId}/students/{studentId}")
    public void addStudentToClassRoom(@PathVariable Long classRoomId, @PathVariable Long studentId) {
        classRoomService.addStudentToClassRoom(classRoomId, studentId);
    }

    @DeleteMapping("/{classRoomId}")
    public void deleteClassRoomById(@PathVariable Long classRoomId) {
        classRoomService.deleteClassRoomById(classRoomId);
    }

    @DeleteMapping("/{classRoomId}/students/{studentId}")
    public void deleteStudentFromClassRoom(@PathVariable Long classRoomId, @PathVariable Long studentId) {
        classRoomService.deleteStudentFromClassRoom(classRoomId, studentId);
    }


}
