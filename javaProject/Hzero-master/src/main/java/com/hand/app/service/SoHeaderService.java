package com.hand.app.service;

import com.hand.domain.entity.SoHeader;
import org.springframework.http.ResponseEntity;

import java.security.Principal;

/**
 * 应用服务
 *
 * @author sh1101315853@163.com 2020-07-27 15:21:08
 */
public interface SoHeaderService {
    public ResponseEntity<String> updateStatus(SoHeader soHeader, Principal principal);
}
