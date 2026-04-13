package com.example.hospitalManagement.service;

import com.example.hospitalManagement.entity.Patient;
import com.example.hospitalManagement.repository.PatientRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * in the transactional annotations we have dont have to save explicitly , it
 * can we done implicitly only cause there . it see is there are any changes
 * , if there any changes it only to perform it .
 */
@Service
@RequiredArgsConstructor
public class PatientService {
    private final PatientRepository patientRepository;

    @Transactional
    public Patient getPatientById(Long id) {
        Patient p1= patientRepository.findById(id).orElseThrow();
        Patient p2= patientRepository.findById(id).orElseThrow();

        p1.setName("Yoyo");
        return p1;
    }
}
