package com.mobilesoftwaredevelopment.finaldoctor;

public class GetDoctorCompletedOpStatusData {
    String patient_name,health_issue,mobile_no;


    public GetDoctorCompletedOpStatusData(String patient_name, String health_issue, String mobile_no) {
        this.patient_name = patient_name;
        this.health_issue = health_issue;
        this.mobile_no = mobile_no;
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
