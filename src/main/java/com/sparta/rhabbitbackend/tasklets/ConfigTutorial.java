package com.sparta.rhabbitbackend.tasklets;

import com.sparta.rhabbitbackend.model.Cards;
import com.sparta.rhabbitbackend.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.JobScope;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.item.database.JpaPagingItemReader;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.persistence.EntityManagerFactory;
import java.util.HashMap;
import java.util.Map;

//@Configuration
@RequiredArgsConstructor
public class ConfigTutorial {

    //private final JobBuilderFactory jobBuilderFactory; // Job 빌더 생성용
    //private final StepBuilderFactory stepBuilderFactory; // Step 빌더 생성용
   // private final EntityManagerFactory entityManagerFactory;
    // JobBuilderFactory를 통해서 tutorialJob을 생성
//    @Bean
//    public Job tutorialJob() {
//        return jobBuilderFactory.get("exampleJob")
//                .start(newStep())  // Step 설정
//                .build();
//    }

    // StepBuilderFactory를 통해서 tutorialStep을 생성
//    @Bean
//    @JobScope
//    public Step newStep() {
//        return stepBuilderFactory.get("Step")
//                .<Cards, Cards>chunk(10)
//                .reader(reader())
//                .processor(processor())
//                .writer(writer())
//                .build();
//    }
//
//    @Bean
//    @StepScope
//    public JpaPagingItemReader<User> reader(){
//
//        Map<String, Object> parameterValues = new HashMap<>();
//        parameterValues.put("")
//    }
}