package com.cocoball.springp.sample;

import lombok.RequiredArgsConstructor;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@ToString
@RequiredArgsConstructor
public class SampleService {

    /* @Autowired // 필드 주입
    private SampleDAO sampleDAO; */

    // 생성자 주입
    private final SampleDAO sampleDAO;
}
