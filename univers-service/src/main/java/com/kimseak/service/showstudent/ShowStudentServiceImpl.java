package com.kimseak.service.showstudent;

import com.kimseak.entity.Student;
import com.kimseak.repository.student.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by kimseak on 5/28/17.
 */
@Service
public class ShowStudentServiceImpl implements ShowStudentService {

    @Autowired
    private StudentRepository studentRepository;

    public List<Student> getAllStudents() {
        return studentRepository.getAllStudents();
    }
}
