package com.example.postgre.repository;

import com.example.postgre.dto.ClickReport;
import com.example.postgre.entity.Click;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import reactor.core.publisher.Flux;

public interface ClickRepository extends R2dbcRepository<Click, Long> {

    @Query("SELECT click_type, count(*), DATE(creation_date) FROM click GROUP BY click_type, DATE(creation_date) " +
            "having DATE(creation_date) = NOW()::DATE LIMIT 10")
    Flux<ClickReport> findTop10();
}
