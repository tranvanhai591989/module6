package com.example.medical.repository;

import com.example.medical.model.MedicalFile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;

public interface MedicalFileRepository extends JpaRepository<MedicalFile, Integer> {

    @Query(value = "select * from medical_file", nativeQuery = true)
    List<MedicalFile> getAll();

    @Transactional
    @Modifying
    @Query(value = "insert into medical_file (medical_file_code,patient_code,patient_id,start_day,end_day,reason,treatment,doctor) " +
            "values (:medicalFileCode,:patientCode,:patient,:startDay,:endDay,:reason,:treatment,:doctor)", nativeQuery = true)
    void saveMedicalFile(@Param("medicalFileCode") String medicalFileCode, @Param("patientCode") String patientCode,
                         @Param("patient") int patient, @Param("startDay") String startDay, @Param("endDay") String endDay,
                         @Param("reason") String reason, @Param("treatment") String treatment, @Param("doctor") String doctor);

    @Transactional
    @Modifying
    @Query(value = "update medical_file set patient_id=:patientId," +
            " start_day=:startDay,end_day=:endDay,reason=:reason,treatment=:treatment,doctor=:doctor where id=:id", nativeQuery = true)
    void update(@Param("patientId") int patientId, @Param("startDay") String startDay, @Param("endDay") String endDay,
                @Param("reason") String reason, @Param("treatment") String treatment, @Param("doctor") String doctor, @Param("id") int id);

    @Query(value = "select * from medical_file  where id=:id", nativeQuery = true)
    MedicalFile findById(@Param("id") int id);

    @Query(value = "select  medical_file.* from medical_file " +
            "join patient on patient.id = medical_file.patient_id " +
            "where patient_code like :patientCode and medical_file_code like :medicalFileCode and patient.id like :patientName", nativeQuery = true)
    List<MedicalFile> findByName(@Param("patientCode") String patientCode, @Param("medicalFileCode") String medicalFileCode, @Param("patientName")String patientName);

    @Transactional
    @Modifying
    @Query(value = "delete from medical_file where id=:id", nativeQuery = true)
    void delete(@Param("id") int id);
}
