package com.booking.demo.controller;
import com.booking.demo.entites.Ticket;
import com.booking.demo.entites.Train;
import com.booking.demo.entites.User;
import com.booking.demo.service.TrainService;
import com.booking.demo.service.UserService;
import com.booking.demo.util.LoginClass;
import com.booking.demo.util.LoginStatus;
import com.booking.demo.util.TicketStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ApplicationController {
    @Autowired
    private UserService userService;
    @Autowired
    private TrainService trainService;

    @PostMapping("/login")
    public LoginStatus login(@RequestBody LoginClass loginClass){
        return userService.login(loginClass);
    }
    @GetMapping("/trainsFromTo/{from-to}")
    public List<Train> fromTo(@PathVariable("from-to") String fromTo){
        String fromtoArray[]=fromTo.split("-");
        System.out.println(fromtoArray[0]+" "+ fromtoArray[1]);
        return trainService.fromTo(fromTo);
    }
    @PostMapping("/savetrains")
    public Train saveTrains(@RequestBody Train train){
        return trainService.saveTrain(train);
    }
    @PostMapping("/ticketBooking")
    public TicketStatus ticketBooking(@RequestBody Ticket ticket){
        return userService.ticketBooking(ticket);
    }
    @PostMapping("/signup")
    public String signUpMethod(@RequestBody User user){
        Boolean userDoneOrNot=userService.signUp(user);
        if(userDoneOrNot)
            return "user signedUp";
        return "user alredy excited";
    }
}
