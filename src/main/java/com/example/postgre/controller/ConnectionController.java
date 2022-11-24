package com.example.postgre.controller;

import com.example.postgre.service.ConnectionService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
@RequiredArgsConstructor
@RestController
@RequestMapping("/connection")
public class ConnectionController {

    ConnectionService connectionService;

    @PostMapping
    public void createConnection() {
        connectionService.connect();
    }

}
