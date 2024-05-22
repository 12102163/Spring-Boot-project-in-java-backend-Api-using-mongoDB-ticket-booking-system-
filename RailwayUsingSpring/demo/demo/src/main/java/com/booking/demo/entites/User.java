package com.booking.demo.entites;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.UniqueElements;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Document(collection = "User")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
        @Id
        private Long userId;
        private String userName;
        @Email
        private String userEmail;
        @NotBlank
        @Length(min=5)
        private String password;
        private String hashPassword;
        private List<Ticket>ticketsBooked=new ArrayList<>();
}
