package com.example.Course.registration.Repository;

import com.example.Course.registration.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface corsrepo extends JpaRepository<Course,String> {


}
