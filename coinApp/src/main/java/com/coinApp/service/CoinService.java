package com.coinApp.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class CoinService {
    @Value("${coinmarketcap.api.url}")
    private String apiUrl;

    @Value("${coinmarketcap.api.key}")
    private String apiKey;

    public String getCoinData(String symbols) {
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.set("X-CMC_PRO_API_KEY", apiKey);
        HttpEntity<String> entity = new HttpEntity<>(headers);
        ResponseEntity<String> response = restTemplate.exchange(
                apiUrl + "?symbol=" + symbols,
                HttpMethod.GET,
                entity,
                String.class
        );
        return response.getBody();
    }
}
