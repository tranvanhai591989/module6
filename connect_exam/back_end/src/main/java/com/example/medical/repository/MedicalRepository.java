package com.example.medical.repository;

import com.example.medical.model.Medical;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;

public interface MedicalRepository extends JpaRepository<Medical, Integer> {

    @Query(value = "select * from medical", nativeQuery = true)
    List<Medical> getAll();

    @Transactional
    @Modifying
    @Query(value = "insert into medical (code_patient,code_people_id,name_people_patient,day_start,day_end,reason,method,doctor) " +
            "values (:codePatient,:codePeoplePatient,:namePeoplePatient,:dayStart,:dayEnd,:reason,:method,:doctor", nativeQuery = true)
    void save(@Param("codePatient") String codePatient, @Param("codePeoplePatient") String codePeoplePatient,
              @Param("namePeoplePatient") String namePeoplePatient, @Param("dayStart") String dayStart, @Param("dayEnd") String dayEnd,
              @Param("reason") String reason, @Param("method") String method, @Param("doctor") String doctor);

    @Transactional
    @Modifying
    @Query(value = "update medical set code_patient=:codePatient,code_people_id=:codePeoplePatient,name_people_patient=:namePeoplePatient," +
            "day_start=:dayStart,day_end=:dayEnd,reason=:reason,method=:method,doctor=:doctor where id=:id", nativeQuery = true)
    void update(@Param("codePatient") String codePatient, @Param("codePeoplePatient") String codePeoplePatient,
                @Param("namePeoplePatient") String namePeoplePatient, @Param("dayStart") String dayStart, @Param("dayEnd") String dayEnd,
                @Param("reason") String reason, @Param("method") String method, @Param("doctor") String doctor, @Param("id") int id);

    @Query(value = "select * from medical  where id=:id", nativeQuery = true)
    Medical findById(@Param("id") int id);

    @Query(value = "select * from medical where name_people_patient like :name", nativeQuery = true)
    List<Medical> findByName(@Param("name") String name);

    @Transactional
    @Modifying
    @Query(value = "delete from medical where id=:id", nativeQuery = true)
    void delete(@Param("id") int id);
}
