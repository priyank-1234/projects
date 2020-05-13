package com.mindtree.college.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mindtree.college.entity.Teacher;

public interface TeacherRepository extends JpaRepository<Teacher, Integer> {

}
