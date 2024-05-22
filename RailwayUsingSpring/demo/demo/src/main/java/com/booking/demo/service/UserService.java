package com.booking.demo.service;

import com.booking.demo.entites.Ticket;
import com.booking.demo.entites.User;
import com.booking.demo.util.LoginClass;
import com.booking.demo.util.LoginStatus;
import com.booking.demo.util.TicketStatus;
import org.springframework.stereotype.Service;

@Service
public interface UserService {

    Boolean signUp(User user);

    LoginStatus login(LoginClass loginClass);

    TicketStatus ticketBooking(Ticket ticket);
}
