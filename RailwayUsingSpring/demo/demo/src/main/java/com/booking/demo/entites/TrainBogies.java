package com.booking.demo.entites;

import lombok.Getter;
import lombok.Setter;
import org.springframework.context.annotation.Scope;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.stereotype.Component;

import java.util.List;

@Document(collection = "TrainBogies")
@Component
@Setter
@Getter
public class TrainBogies {
    private List<Boolean> seats;
}
