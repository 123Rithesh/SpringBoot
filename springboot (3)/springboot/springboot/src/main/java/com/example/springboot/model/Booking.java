package com.example.springboot.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;

@Entity
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int bookingId; 
    private String bookingDetails; 

    @ManyToOne
    @JoinColumn(name = "user_id")
    @JsonIgnore
    private User user;

    public Booking() {
    }

    public Booking(String bookingDetails) { 
        this.bookingDetails = bookingDetails;
    }

    public int getBookingId() { 
        return bookingId;
    }

    public void setBookingId(int bookingId) { 
        this.bookingId = bookingId;
    }

    public String getBookingDetails() { 
        return bookingDetails;
    }

    public void setBookingDetails(String bookingDetails) { 
        this.bookingDetails = bookingDetails;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
