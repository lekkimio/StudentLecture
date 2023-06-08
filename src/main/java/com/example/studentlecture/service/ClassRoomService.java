package com.example.studentlecture.service;

import com.example.studentlecture.model.ClassRoom;
import com.example.studentlecture.repo.ClassRoomRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ClassRoomService {

    private final ClassRoomRepository classRoomRepository;
    private final StudentService studentService;

    public ClassRoom addClassRoom() {
        ClassRoom classRoom = new ClassRoom();
        return classRoomRepository.save(classRoom);
    }

    public ClassRoom getClassRoomById(Long id){
        return classRoomRepository.findById(id).orElseThrow(()-> new RuntimeException("ClassRoom not found"));
    }

    public void addStudentToClassRoom(Long classRoomId, Long studentId) {

        ClassRoom classRoom = getClassRoomById(classRoomId);

        classRoom.getStudents().add(studentService.getStudentById(studentId));

        classRoomRepository.save(classRoom);

    }

    public void deleteClassRoomById(Long classRoomId) {
        classRoomRepository.deleteById(classRoomId);
    }

    public void deleteStudentFromClassRoom(Long classRoomId, Long studentId) {
        ClassRoom classRoom = getClassRoomById(classRoomId);

        classRoom.getStudents().remove(studentService.getStudentById(studentId));

        classRoomRepository.save(classRoom);
    }
}
