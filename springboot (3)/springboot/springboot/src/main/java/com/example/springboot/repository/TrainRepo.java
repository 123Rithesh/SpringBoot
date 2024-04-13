package com.example.springboot.repository;

import com.example.springboot.model.Train;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TrainRepo extends JpaRepository<Train, Integer> {

    @Query("SELECT t FROM Train t WHERE t.trainName = ?1")
    List<Train> findByTrainName(String trainName); // Updated from "findByToyName"
    
    @Query("SELECT t FROM Train t WHERE t.trainId IN (SELECT DISTINCT t.trainId FROM Train t INNER JOIN t.users u WHERE u.userId = ?1)")
    List<Train> findByUserId(int userId); // Updated from "findByUserId"
}
