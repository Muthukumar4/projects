package com.example.Course.registration.Repository;

import com.example.Course.registration.model.courseRegitery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Registeryrepo extends JpaRepository<courseRegitery,Integer> {

}
