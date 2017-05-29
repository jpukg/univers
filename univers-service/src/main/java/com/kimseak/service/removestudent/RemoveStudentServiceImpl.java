package com.kimseak.service.removestudent;

import com.kimseak.entity.Student;
import com.kimseak.repository.student.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by kimseak on 5/28/17.
 */

@Service
public class RemoveStudentServiceImpl implements RemoveStudentService {

    @Autowired
    StudentRepository studentRepository;

    public void removeStudent(Student student) {
        studentRepository.delete(student);
    }
}
