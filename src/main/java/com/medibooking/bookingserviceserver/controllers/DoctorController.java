package com.medibooking.bookingserviceserver.controllers;

import com.medibooking.bookingserviceserver.dtos.doctor.DoctorGetDto;
import com.medibooking.bookingserviceserver.dtos.doctor.DoctorPostDto;
import com.medibooking.bookingserviceserver.dtos.doctor.DoctorPutDto;
import com.medibooking.bookingserviceserver.entities.Doctor;
import com.medibooking.bookingserviceserver.services.DoctorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/doctors")
public class DoctorController {

    private final DoctorService doctorService;

    @PostMapping
    public ResponseEntity<Object> add(@RequestBody DoctorPostDto doctorPostDto) {
        DoctorGetDto doctorGetDto = doctorService.create(doctorPostDto);
        return ResponseEntity.ok(doctorGetDto);
    }

    @GetMapping
    public ResponseEntity<List<Doctor>> find() {
        List<Doctor> list = doctorService.getAllDoctors();
        return ResponseEntity.ok(list);
    }

    @GetMapping("/{doctorId}")
    public ResponseEntity<DoctorGetDto> findById(@PathVariable Long doctorId) {
        return ResponseEntity.ok(doctorService.findDoctorById(doctorId));
    }

    @GetMapping("search")
    public ResponseEntity<DoctorGetDto> findByUserName(@RequestParam Long doctorId) {
        return ResponseEntity.ok(doctorService.findDoctorById(doctorId));
    }

    @PutMapping("/{doctorId}")
    public ResponseEntity<DoctorGetDto> update(@PathVariable Long doctorId, @RequestBody DoctorPutDto doctorPutDto) {
        return ResponseEntity.ok(doctorService.modify(doctorId, doctorPutDto));
    }

    @DeleteMapping("/{doctorId}")
    public ResponseEntity delete(@PathVariable Long doctorId) {
        doctorService.delete(doctorId);
        return ResponseEntity.ok().build();
    }
}
