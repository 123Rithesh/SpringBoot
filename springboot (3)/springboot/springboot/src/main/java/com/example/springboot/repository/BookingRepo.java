package com.example.springboot.repository;

import com.example.springboot.model.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BookingRepo extends JpaRepository<Booking, Integer> {

    @Query("SELECT b FROM Booking b WHERE b.user.id = ?1")
    List<Booking> findByUserId(int userId);
}
