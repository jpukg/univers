package com.kimseak.repository.student;

import com.kimseak.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by kimseak on 5/27/17.
 */

@Repository
public interface  StudentRepository extends JpaRepository<Student, Integer> {

    @Query("select s from Student s order by s.firstName")
    List<Student> getAllStudents( );



}
