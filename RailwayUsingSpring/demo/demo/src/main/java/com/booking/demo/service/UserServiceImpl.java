package com.booking.demo.service;
import com.booking.demo.entites.Ticket;
import com.booking.demo.entites.Train;
import com.booking.demo.entites.TrainBogies;
import com.booking.demo.entites.User;
import com.booking.demo.repostory.TrainRepostory;
import com.booking.demo.repostory.UserRepostory;
import com.booking.demo.util.HashingPaswords;
import com.booking.demo.util.LoginClass;
import com.booking.demo.util.LoginStatus;
import com.booking.demo.util.TicketStatus;
import org.apache.commons.logging.LogFactory;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.*;


@Component
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepostory userRepostory;
    @Autowired
    private TrainRepostory trainRepostory;
    @Override
    public LoginStatus login(LoginClass loginClass) {
        User user=userRepostory.findByUserEmail(loginClass.getUserEmail());
        System.out.println(user);
        if(Objects.isNull(user))return LoginStatus.Email_is_Wrong;
        String email=user.getUserEmail();
        if(Objects.isNull(email))return LoginStatus.Email_is_Wrong;
        if(Objects.nonNull(email) && !loginClass.getUserEmail().equals(email))return LoginStatus.Email_is_Wrong;
//        String hashpassword=HashingPaswords.hashPasswords(loginClass.getPassword());
        if(!HashingPaswords.checkPassword(loginClass.getPassword(),user.getHashPassword()))return LoginStatus.Password_Wrong;
        return LoginStatus.User_Succsefully_logined;
    }

    @Override
    public TicketStatus ticketBooking(Ticket ticket) {
        Long userId=ticket.getUserId();

        User user=userRepostory.findById(userId).get();
        if(Objects.isNull(user))return TicketStatus.UserNull;
        List<Train> listOfTrain=trainRepostory.findAll();
        Boolean ticketBooked=false;
        for(Train train:listOfTrain){
//            checking if station are present are not and also checking there time
            if (!train.getStationsTimings().containsKey(ticket.getSource())
                    || train.getStationsTimings().get(ticket.getSource()).isBefore(ticket.getTrainTimeDate())
                    || (train.getStations().indexOf(ticket.getSource()) >= train.getStations().indexOf(ticket.getDestination()))) {
                continue;
            }

            List<TrainBogies>trainBogies=train.getTrainBogies();
            A:
            for(TrainBogies trainBogie:trainBogies){
                List<Boolean>seats=trainBogie.getSeats();
                if(ticket.getSeatPrefrnce()==-1){
//                    no prefrence seat just booking empty seat
                    for(int i=0;i<seats.size();i++){
                        if(!seats.get(i)) {
                            seats.set(i, true);
                            ticketBooked=true;
                            break A;
                        }
                    }
                }
                if(seats.get(ticket.getSeatPrefrnce()))return TicketStatus.Not_Avalable_seat_Acording_to_user_prefrence;
                else{
                    seats.set(ticket.getSeatPrefrnce(), true);
                    ticketBooked=true;
                    break A;
                }
            }
        }
        if(!ticketBooked && ticket.getSeatPrefrnce()==-1)return TicketStatus.Sorry_Tickets_Are_over;
        if(ticketBooked) {
            trainRepostory.saveAll(listOfTrain);
            user.getTicketsBooked().add(ticket);
            userRepostory.save(user);
            return TicketStatus.Ticket_Booked_Sucssefull;
        }
        return TicketStatus.Sorouce_And_Destination_trains_Are_not_there;
    }



    @Override
    public Boolean signUp(User user) {

       if((userRepostory.findById(user.getUserId())).isPresent()
       || Objects.nonNull(userRepostory.findByUserEmail(user.getUserEmail())))return false;
       String passwordTobeHashed=user.getPassword();
        user.setHashPassword(HashingPaswords.hashPasswords(passwordTobeHashed));
        user.setPassword(null);
        userRepostory.save(user);
        return true;
    }
}
