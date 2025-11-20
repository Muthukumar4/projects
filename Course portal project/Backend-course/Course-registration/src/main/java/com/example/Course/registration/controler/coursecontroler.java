package com.example.Course.registration.controler;

import com.example.Course.registration.model.Course;
import com.example.Course.registration.model.courseRegitery;
import com.example.Course.registration.service.courseservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController

@CrossOrigin(origins = "http://localhost:5500")
public class coursecontroler {

    @Autowired
    courseservice crssrv;


    @GetMapping("/course")
    public List<Course> availablecrus(){
        return crssrv.availablecrs();
    }

    @GetMapping("/enrolled")
    public List<courseRegitery> enrolledcres(){
        return crssrv.enrooledcrs();
    }

    @PostMapping("/course/register")
    public String enrollcrus(@RequestParam("name") String name,@RequestParam("emailId") String emailId,@RequestParam("corsName") String corsName){
       crssrv.registercrs(name,emailId,corsName);
       return "Congratulation! "+name+" Enrollement Successful for "+corsName;
    }


}
