package com.example.springbootdemo1.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class User {
    private String userID;
    private String userName;
    private String email;

    public User(String userID, String userName, String email) {
        this.userID=userID;
        this.userName=userName;
        this.email=email;
    }
}
