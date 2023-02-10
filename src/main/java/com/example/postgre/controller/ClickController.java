package com.example.postgre.controller;

import com.example.postgre.entity.Click;
import com.example.postgre.enums.ClickType;
import com.example.postgre.service.click.ClickService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
@RequiredArgsConstructor
@RestController
@RequestMapping("/clicks")
public class ClickController {

    ClickService clickService;

    @PostMapping
    public Mono<Click> add(@RequestParam("clickType") ClickType clickType) {
        return clickService.add(clickType);
    }
}
