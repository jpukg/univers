package com.kimseak.service.addstudent;

import com.kimseak.entity.Student;
import com.kimseak.repository.student.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by kimseak on 5/27/17.
 */

@Service
public class AddStudentServiceImpl implements AddStudentService {

    @Autowired
    private StudentRepository studentRepository;

    public void saveStudent(Student studentDAO) {

        Student student = new Student();

        student.setFirstName(studentDAO.getFirstName());
        student.setLastName(studentDAO.getLastName());
        student.setAge(studentDAO.getAge());
        student.setGender(studentDAO.getGender());

        studentRepository.save(student);


    }
}
