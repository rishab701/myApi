package com.rp.demo.entity;

public class Doctor {

    private String doctorName;
    private String doctorAddress;

    public Doctor(){

    }


    public Doctor(String doctorName, String doctorAddress) {
        this.doctorName = doctorName;
        this.doctorAddress=doctorAddress;
    }


    public String getDoctorAddress() {
        return doctorAddress;
    }

    public String getDoctorName() {
        return doctorName;
    }

    public void setDoctorAddress(String doctorAddress) {
        this.doctorAddress = doctorAddress;
    }

    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName;
    }
}
