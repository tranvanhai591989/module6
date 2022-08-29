package com.example.medical.controller;

import com.example.medical.dto.MedicalFileDto;
import com.example.medical.model.MedicalFile;
import com.example.medical.model.Patient;
import com.example.medical.service.impl.MedicalFileServiceImpl;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("api/medicalFile/")
public class MedicalFileController {
    @Autowired
    private MedicalFileServiceImpl medicalFileService;

    @GetMapping("/list")
    public ResponseEntity<List<MedicalFile>> getList() {
        List<MedicalFile> patientList = medicalFileService.getAll();
        if (patientList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(patientList, HttpStatus.OK);
    }

    //Tìm theo id
    @GetMapping("find/{id}")
    public ResponseEntity<MedicalFile> findById(@PathVariable("id") int id) {
        MedicalFile medical = medicalFileService.findById(id);
        if (medical == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(medical, HttpStatus.OK);
    }

    //Thêm mới
    @PostMapping("/create")
    public ResponseEntity<Void> create(@Validated @RequestBody MedicalFileDto medicalFileDto, BindingResult bindingResult) {

        MedicalFile medicalFile = new MedicalFile();

        BeanUtils.copyProperties(medicalFileDto, medicalFile);

//        medicalFile.setPatient(medicalFileDto.getPatient());
//
//        medicalFile.setStartDay(LocalDate.parse(medicalFileDto.getDayIn()));
//
//        medicalFile.setEndDay(LocalDate.parse(medicalFileDto.getDayOut()));

        medicalFileService.save(medicalFile);

        return new ResponseEntity(HttpStatus.OK);
    }


    @PutMapping("edit/{id}")
    public ResponseEntity<MedicalFile> update(@PathVariable("id") int id, @RequestBody MedicalFile medical) {
        if (medical == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        medicalFileService.save(medical);
        return new ResponseEntity<>(medical, HttpStatus.OK);
    }

    //Xóa
    @DeleteMapping("delete/{id}")
    public ResponseEntity<Patient> delete(@PathVariable("id") int id) {
        MedicalFile medical = medicalFileService.findById(id);
        if (medical == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        medicalFileService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/search")
    public ResponseEntity<List<MedicalFile>> search(@RequestParam String patientCode,String medicalFileCode, String patient) {
        List<MedicalFile> medicalList = medicalFileService.findByName(patientCode, medicalFileCode,patient);
        if (medicalList == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(medicalList, HttpStatus.OK);
    }

}
