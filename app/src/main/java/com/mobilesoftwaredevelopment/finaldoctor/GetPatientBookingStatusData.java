package com.mobilesoftwaredevelopment.finaldoctor;

public class GetPatientBookingStatusData {

    String patient_name,health_issue,mobile_no,date,time,bookedStatus;


    public GetPatientBookingStatusData(String patient_name, String health_issue, String mobile_no,String date,String time,String bookedStatus) {
        this.patient_name = patient_name;
        this.health_issue = health_issue;
        this.mobile_no = mobile_no;
        this.date = date;
        this.time = time;
        this.bookedStatus = bookedStatus;
    }

    public String getBookedStatus() {
        return bookedStatus;
    }

    public void setBookedStatus(String bookedStatus) {
        this.bookedStatus = bookedStatus;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getPatient_name() {
        return patient_name;
    }

    public void setPatient_name(String patient_name) {
        this.patient_name = patient_name;
    }

    public String getHealth_issue() {
        return health_issue;
    }

    public void setHealth_issue(String health_issue) {
        this.health_issue = health_issue;
    }

    public String getMobile_no() {
        return mobile_no;
    }

    public void setMobile_no(String mobile_no) {
        this.mobile_no = mobile_no;
    }
}
