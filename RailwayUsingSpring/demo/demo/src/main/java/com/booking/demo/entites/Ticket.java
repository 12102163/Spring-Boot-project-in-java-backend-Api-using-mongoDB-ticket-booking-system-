package com.booking.demo.entites;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document(collection = "Ticket")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Ticket {
    @Id
    private Long ticketId;
    private Long userId;
    private String source;
    private String destination;
    @Length(max=32)
    private Integer seatPrefrnce;
    private Train ticketsTrain;
    private LocalDateTime trainTimeDate;
}
