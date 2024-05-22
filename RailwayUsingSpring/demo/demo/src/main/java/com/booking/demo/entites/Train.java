package com.booking.demo.entites;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

@Document(collection = "train")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Train {
    @Id
    private Long trainId;
    private String trainName;
    private List<TrainBogies>trainBogies;
    private Map<String , LocalDateTime>stationsTimings;
    private List<String>stations;
}
