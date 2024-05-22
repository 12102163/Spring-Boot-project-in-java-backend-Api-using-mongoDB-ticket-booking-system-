package com.booking.demo.repostory;

import com.booking.demo.entites.Train;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TrainRepostory extends MongoRepository<Train, Long> {

    @Query("{'stations': { $all: [ ?0, ?1 ] } }")
    List<Train> findAllByStationFromTo(String s, String s1);
}
