package com.booking.demo.service;

import com.booking.demo.entites.Train;
import com.booking.demo.entites.TrainBogies;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TrainService {
    Train saveTrain(Train train);

    List<Train> fromTo(String fromTo);

}
