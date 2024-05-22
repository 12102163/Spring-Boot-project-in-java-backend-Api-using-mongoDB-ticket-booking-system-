package com.booking.demo.repostory;

import com.booking.demo.entites.Ticket;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TicketRepostory extends MongoRepository<Ticket, Long> {

}
