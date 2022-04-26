package com.mobilesoftwaredevelopment.finaldoctor;

public class GetDoctorBookingInfo {
    String name,categories,specialization,experience;

    public GetDoctorBookingInfo(String name, String categories, String specialization, String experience) {
        this.name = name;
        this.categories = categories;
        this.specialization = specialization;
        this.experience = experience;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategories() {
        return categories;
    }

    public void setCategories(String categories) {
        this.categories = categories;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    public String getExperience() {
        return experience;
    }

    public void setExperience(String experience) {
        this.experience = experience;
    }
}
