package com.coinApp.controller;

import com.coinApp.service.CoinService;
import com.coinApp.util.databaseUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/coins")
public class CoinController {
    @Autowired
    private CoinService coinService;

//    @GetMapping("/data")
//    public ResponseEntity<?> getCoinData(@RequestParam String symbols, Authentication authentication) {
//        return ResponseEntity.ok(coinService.getCoinData(symbols));
//    }
    @GetMapping("/data")
    public ResponseEntity<?> getCoinData(@RequestParam String symbols, Authentication authentication) throws SQLException {
        String token = authentication.getCredentials().toString();
        System.out.println(token);
        Connection conn = databaseUtil.connab();
        String sql = "INSERT INTO responses (timestamp, response) VALUES (?, ?)";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        String res1=coinService.getCoinData(symbols);
        pstmt.setTimestamp(1, new Timestamp(System.currentTimeMillis()));
        pstmt.setString(2, res1);

        pstmt.executeUpdate();
        return ResponseEntity.ok(coinService.getCoinData(symbols));
    }
   
}
