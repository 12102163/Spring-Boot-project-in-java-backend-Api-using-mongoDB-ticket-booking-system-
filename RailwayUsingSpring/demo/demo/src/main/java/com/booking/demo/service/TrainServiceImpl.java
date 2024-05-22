package com.booking.demo.service;

import com.booking.demo.entites.Train;
import com.booking.demo.entites.TrainBogies;
import com.booking.demo.repostory.TrainRepostory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
public class TrainServiceImpl implements TrainService{
    @Autowired
    TrainRepostory trainRepostory;


    @Override
    public Train saveTrain(Train train) {
        return trainRepostory.save(train);
    }

    @Override
    public List<Train> fromTo(String fromTo) {
        String fromtoArray[]=fromTo.split("-");
        System.out.println(fromtoArray[0]+" "+ fromtoArray[1]);
        List<Train>listOftrains=trainRepostory.findAllByStationFromTo(fromtoArray[0], fromtoArray[1]);
        return listOftrains;
    }


}
