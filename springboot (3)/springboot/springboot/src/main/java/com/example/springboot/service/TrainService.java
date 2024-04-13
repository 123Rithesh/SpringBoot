package com.example.springboot.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.springboot.model.Train;
import com.example.springboot.repository.TrainRepo;

@Service
public class TrainService {

    @Autowired
    TrainRepo trainRepository;

    public Train create(Train train) {
        return trainRepository.save(train);
    }

    public List<Train> getAllTrains() {
        return trainRepository.findAll();
    }

    public Optional<Train> getTrainById(int id) {
        return trainRepository.findById(id);
    }

    public boolean updateTrain(int id, Train train) {
        if (!trainRepository.existsById(id)) {
            return false;
        }
        train.setTrainId(id);
        trainRepository.save(train);
        return true;
    }

    public boolean deleteTrain(int id) {
        if (!trainRepository.existsById(id)) {
            return false;
        }
        trainRepository.deleteById(id);
        return true;
    }

    public List<Train> getAllTrainsSortedBy(String sortBy) {
        return trainRepository.findAll(Sort.by(sortBy));
    }

    public Page<Train> getAllTrainsPaginated(int pageNo, int pageSize) {
        Pageable pageable = PageRequest.of(pageNo, pageSize);
        return trainRepository.findAll(pageable);
    }

    public List<Train> findByTrainName(String trainName) {
        return trainRepository.findByTrainName(trainName);
    }

    public List<Train> findByUserId(int userId) {
        return trainRepository.findByUserId(userId);
    }
}
