package com.rp.demo.rest;

import com.rp.demo.entity.Doctor;
import jakarta.annotation.PostConstruct;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class HospitalRestController {

    private List<Doctor> theDoctors;

    // Define @PostConstruct to load the student data .... only once
    @PostConstruct
    public void loadData(){

        theDoctors =new ArrayList<>();

        theDoctors.add(new Doctor("Dr. Sarita Rani Jaiswal","Dharamshila Narayana Superspeciality Hospital,New Delhi"));
        theDoctors.add(new Doctor(" Dr J.S. Guleria","Sitaram Bhartia Institute Of Science & Research, Qutab Institutional Area, Delhi"));
        theDoctors.add(new Doctor("Dr Navneet Kaur","Apollo Spectra Hospitals Chirag Enclave"));
        theDoctors.add(new Doctor("Dr. Sachin Bansal","Pitampura Delhi"));
        theDoctors.add(new Doctor(" Dr Ved Prakash ","Sir Ganga Ram Hospital, Old Rajendra Nagar, Delhi"));
        theDoctors.add(new Doctor("Dr J.N. Pande","Sitaram Bhartia Institute Of Science & Research, Qutab Institutional Area, Delhi"));
        theDoctors.add(new Doctor("Dr Satish Kumar Parashar ","Metro Hospitals & Heart Institute, Lajpat Nagar, Delhi"));
        theDoctors.add(new Doctor("Dr M.P. Sharma","Rockland Hospital, Qutab Institutional Area, Delhi"));
        theDoctors.add(new Doctor("Dr Yash Pal Munjal","Banarasi Das Chandiwal Institute Of Medical Sciences, Kalkaji, Delhi"));
        theDoctors.add(new Doctor("Dr M.M. Bhattacharya","Sunil Memorial Clinic in Dwarka, Delhi"));

    }

    // Define a endpoint "/students/ - return a list of students

    @GetMapping("/doctors")

    public List<Doctor> getStudent(){

        return theDoctors;
    }

    // Define endpoint or "/students/{studentId}" - return student at index

    @GetMapping("/students/{studentId}")

    public Doctor getStudent(@PathVariable int doctorId){

        //Check the student id

        if(doctorId >= theDoctors.size() || doctorId < 0){
            throw new doctorNotFoundException("Student id not found :- " + doctorId);
        }

        //Just index into the list and return

        return theDoctors.get(doctorId);

    }

    // Add an exception handler using @Exception handler

    @ExceptionHandler
    public ResponseEntity<CustomErrorResponse> handleException(doctorNotFoundException exc){

        //Create CustomErrorResponse

        CustomErrorResponse customErrorResponse=new CustomErrorResponse();

        customErrorResponse.setStatus(HttpStatus.NOT_FOUND.value());
        customErrorResponse.setMessage(exc.getMessage());
        customErrorResponse.setTimestamp(System.currentTimeMillis());

        //Return responseEntity

        return new ResponseEntity<>(customErrorResponse,HttpStatus.NOT_FOUND);
    }

    // Add a new exception handler for "jdjdjdnj" some random index and that is a string. Catch a;;

    @ExceptionHandler
    public ResponseEntity<CustomErrorResponse> handleException(Exception exc){

        //Create CustomErrorResponse

        CustomErrorResponse customErrorResponse=new CustomErrorResponse();

        customErrorResponse.setStatus(HttpStatus.BAD_REQUEST.value());
        customErrorResponse.setMessage(exc.getMessage());
        customErrorResponse.setTimestamp(System.currentTimeMillis());

        //Return responseEntity

        return new ResponseEntity<>(customErrorResponse,HttpStatus.BAD_REQUEST);
    }
}
