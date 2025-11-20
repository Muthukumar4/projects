package com.example.Course.registration.service;

import com.example.Course.registration.Repository.Registeryrepo;
import com.example.Course.registration.Repository.corsrepo;
import com.example.Course.registration.model.Course;
import com.example.Course.registration.model.courseRegitery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class courseservice {
    @Autowired
    corsrepo repo;

    @Autowired
    Registeryrepo resrepo;


    public List<Course> availablecrs() {
        return repo.findAll();
    }

    public List<courseRegitery> enrooledcrs() {
        return resrepo.findAll();
    }

    public void registercrs(String name, String emailId, String corsNmae) {
        courseRegitery crsreg=new courseRegitery(name,emailId,corsNmae);
        resrepo.save(crsreg);
    }
}
