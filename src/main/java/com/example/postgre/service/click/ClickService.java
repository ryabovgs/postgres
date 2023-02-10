package com.example.postgre.service.click;

import com.example.postgre.entity.Click;
import com.example.postgre.enums.ClickType;
import reactor.core.publisher.Mono;

public interface ClickService {

    Mono<Click> add(ClickType clickType);
}
