package com.example.springboot.model;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class Train {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int trainId; 
    private String trainName; 

    @OneToMany(mappedBy = "train", cascade = CascadeType.ALL)
    private List<User> users;

    public Train() {
    }

    public Train(String trainName) { 
        this.trainName = trainName;
    }

    public int getTrainId() { 
        return trainId;
    }

    public void setTrainId(int trainId) { 
        this.trainId = trainId;
    }

    public String getTrainName() { 
        return trainName;
    }

    public void setTrainName(String trainName) { 
        this.trainName = trainName;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
}
