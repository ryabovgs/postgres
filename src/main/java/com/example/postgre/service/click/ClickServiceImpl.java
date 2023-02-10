package com.example.postgre.service.click;

import com.example.postgre.dto.ClickDto;
import com.example.postgre.entity.Click;
import com.example.postgre.enums.ClickType;
import com.example.postgre.mapper.ClickMapper;
import com.example.postgre.repository.ClickRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
@RequiredArgsConstructor
@Service
public class ClickServiceImpl implements ClickService {

    ClickMapper clickMapper;
    ClickRepository clickRepository;

    @Override
    public Mono<Click> add(ClickType clickType) {
        var clickDto = ClickDto.builder().clickType(clickType).build();
        return clickRepository.save(clickMapper.fromDto(clickDto));
    }
}
