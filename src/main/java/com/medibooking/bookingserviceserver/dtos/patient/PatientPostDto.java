package com.medibooking.bookingserviceserver.dtos.patient;

import lombok.Data;

@Data
public class PatientPostDto {
    private int age;
    private String gender;
    private String firstName;
    private String lastName;
}
