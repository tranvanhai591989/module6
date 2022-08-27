package com.example.medical.controller;

import com.example.medical.model.Medical;
import com.example.medical.model.Patient;
import com.example.medical.service.MedicalServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("api/medical")
public class MedicalController {
    @Autowired
    private MedicalServiceImpl medicalService;

    //Hiển thị
    @GetMapping("/list")
    public ResponseEntity<List<Medical>> getList() {
        List<Medical> patientList = medicalService.getAll();
        if (patientList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(patientList, HttpStatus.OK);
    }

    //Tìm theo id
    @GetMapping("find/{id}")
    public ResponseEntity<Medical> findById(@PathVariable("id") int id) {
        Medical medical = medicalService.findById(id);
        if (medical == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(medical, HttpStatus.OK);
    }

    //Thêm mới
    @PostMapping("/create")
    public ResponseEntity<Medical> create(@RequestBody Medical medical) {
        medicalService.save(medical);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    //Chỉnh Sửa
    @PutMapping("update/{id}")
    public ResponseEntity<Medical> update(@PathVariable("id") int id, @RequestBody Medical medical) {
        if (medical == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        medicalService.save(medical);
        return new ResponseEntity<>(medical, HttpStatus.OK);
    }

    //Xóa
    @DeleteMapping("delete/{id}")
    public ResponseEntity<Patient> delete(@PathVariable("id") int id) {
        Medical medical = medicalService.findById(id);
        if (medical == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        medicalService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @GetMapping("search/{name}")
    public ResponseEntity<List<Medical>> search(@PathVariable("name") String name) {
        List<Medical> medicalList = medicalService.findByName(name);
        List<Medical> medicalLists = medicalService.getAll();
        if (medicalList == null) {
            return new ResponseEntity<>(medicalLists, HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(medicalList, HttpStatus.OK);
    }

}
