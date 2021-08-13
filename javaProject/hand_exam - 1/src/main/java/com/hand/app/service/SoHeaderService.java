package com.hand.app.service;

import com.hand.domain.entity.SoHeader;
import org.springframework.http.ResponseEntity;

import java.security.Principal;


public interface SoHeaderService {
    public ResponseEntity<String> updateStatus(SoHeader soHeader, Principal principal,String status);
}
