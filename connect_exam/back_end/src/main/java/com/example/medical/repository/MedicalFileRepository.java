package com.example.medical.repository;

import com.example.medical.model.MedicalFile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;

public interface MedicalRepository extends JpaRepository<MedicalFile, Integer> {

    @Query(value = "select * from medical_file", nativeQuery = true)
    List<MedicalFile> getAll();

    @Transactional
    @Modifying
    @Query(value = "insert into medical_file (medical_file_code,patient_code,patient_id,start_day,end_day,reason,treatment,doctor) " +
            "values (:medicalFileCode,:patientCode,:patient,:startDay,:endDay,:reason,:treatment,:doctor", nativeQuery = true)
    void save(@Param("medicalFileCode") String medicalFileCode, @Param("patientCode") String patientCode,
              @Param("patient") String patient, @Param("startDay") String startDay, @Param("endDay") String endDay,
              @Param("reason") String reason, @Param("treatment") String treatment, @Param("doctor") String doctor);

    @Transactional
    @Modifying
    @Query(value = "update medical_file set patient_id=:patient, " +
            "start_day=:startDay,end_day=:endDay,reason=:reason,treatment=:treatment,doctor=:doctor where id=:id", nativeQuery = true)
    void update(@Param("codePatient") String codePatient, @Param("codePeoplePatient") String codePeoplePatient,
                @Param("patient") String namePeoplePatient, @Param("startDay") String startDay, @Param("endDay") String endDay,
                @Param("reason") String reason, @Param("treatment") String method, @Param("doctor") String doctor, @Param("id") int id);

    @Query(value = "select * from medical_file  where id=:id", nativeQuery = true)
    MedicalFile findById(@Param("id") int id);

    @Query(value = "select * from medical_file where patient_id like :name", nativeQuery = true)
    List<MedicalFile> findByName(@Param("name") String name);

    @Transactional
    @Modifying
    @Query(value = "delete from medical_file where id=:id", nativeQuery = true)
    void delete(@Param("id") int id);
}
