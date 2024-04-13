package com.example.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.springboot.model.Train;
import com.example.springboot.service.TrainService;

import java.util.List;

@RestController
@RequestMapping("/api/train")
public class TrainController {

    @Autowired
    private TrainService trainService;

    @PostMapping
    public ResponseEntity<Train> addTrain(@RequestBody Train train) {
        Train newTrain = trainService.create(train);
        return new ResponseEntity<>(newTrain, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Train>> getAllTrains() {
        List<Train> trains = trainService.getAllTrains();
        return new ResponseEntity<>(trains, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Train> getTrainById(@PathVariable("id") int id) {
        Train train = trainService.getTrainById(id).orElse(null);
        if (train != null) {
            return new ResponseEntity<>(train, HttpStatus.OK);
        }
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Train> updateTrain(@PathVariable("id") int id, @RequestBody Train train) {
        if (trainService.updateTrain(id, train)) {
            return new ResponseEntity<>(train, HttpStatus.OK);
        }
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deleteTrain(@PathVariable("id") int id) {
        if (trainService.deleteTrain(id)) {
            return new ResponseEntity<>(true, HttpStatus.OK);
        }
        return new ResponseEntity<>(false, HttpStatus.NOT_FOUND);
    }

    @GetMapping("/sorted")
    public ResponseEntity<List<Train>> getAllTrainsSorted(@RequestParam String sortBy) {
        List<Train> trains = trainService.getAllTrainsSortedBy(sortBy);
        return new ResponseEntity<>(trains, HttpStatus.OK);
    }

    @GetMapping("/page")
    public ResponseEntity<Page<Train>> getAllTrainsPaginated(@RequestParam int pageNo, @RequestParam int pageSize) {
        Page<Train> trainsPage = trainService.getAllTrainsPaginated(pageNo, pageSize);
        return new ResponseEntity<>(trainsPage, HttpStatus.OK);
    }
    
    @GetMapping("/name/{trainName}")
    public ResponseEntity<List<Train>> getTrainsByTrainName(@PathVariable String trainName) {
        List<Train> trains = trainService.findByTrainName(trainName);
        return new ResponseEntity<>(trains, HttpStatus.OK);
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Train>> getTrainsByUserId(@PathVariable int userId) {
        List<Train> trains = trainService.findByUserId(userId);
        return new ResponseEntity<>(trains, HttpStatus.OK);
    }
}
