package com.eloqua.demo.controller;

import com.eloqua.demo.entity.AuthenticationFields;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.PostConstruct;
import java.util.logging.Logger;


public class EloquaIndexController {
    public static final Logger LOGGER = Logger.getLogger(AuthenticationFields.class.getName());

    public void eloquaAuthenticate() {
        String accessToken = ""; //base-64(companyName+username+password)
        String url = "https://intentsg/companyName/{companyName}/username/{username}/password/{password}";
        String requestJson = "{companyName: name," +
                                "username:user," +
                                "password:pass}";

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("Authorization", "Bearer " + accessToken);
        HttpEntity<String> httpEntity = new HttpEntity<>(requestJson, headers);
        RestTemplate restTemplate = new RestTemplate();
        AuthenticationFields AuthenticationFields = restTemplate.getForObject(url,AuthenticationFields.class, httpEntity);

        LOGGER.info("-----------"+AuthenticationFields.toString());
    }

}
