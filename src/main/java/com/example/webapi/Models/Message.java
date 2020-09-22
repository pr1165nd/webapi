package com.example.webapi.Models;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Component
public class Message {
    String status;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
    //nothing to add here 
    
    //something's good
}
