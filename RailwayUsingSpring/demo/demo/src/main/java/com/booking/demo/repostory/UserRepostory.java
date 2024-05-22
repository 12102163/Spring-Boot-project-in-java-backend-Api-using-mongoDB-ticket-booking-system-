package com.booking.demo.repostory;

import com.booking.demo.entites.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepostory extends MongoRepository<User, Long> {

    User findByUserEmail(String userEmail);
}
