package com.sparta.rhabbitbackend.tasklets;

import com.sparta.rhabbitbackend.model.Cards;
import com.sparta.rhabbitbackend.model.CardsDetail;
import com.sparta.rhabbitbackend.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.JobScope;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.database.JpaPagingItemReader;
import org.springframework.batch.item.database.builder.JpaPagingItemReaderBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.persistence.EntityManagerFactory;
import javax.smartcardio.Card;
import java.awt.print.Book;
import java.util.HashMap;
import java.util.Map;

//@Configuration
@RequiredArgsConstructor
public class ConfigTutorial {

   /* private final JobBuilderFactory jobBuilderFactory; // Job 빌더 생성용
    private final StepBuilderFactory stepBuilderFactory; // Step 빌더 생성용
    private final EntityManagerFactory entityManagerFactory;
    // JobBuilderFactory를 통해서 tutorialJob을 생성
    @Bean
    public Job tutorialJob() {
        return jobBuilderFactory.get("exampleJob")
                .start(newStep())  // Step 설정
                .build();
    }

     //StepBuilderFactory를 통해서 tutorialStep을 생성
    @Bean
    public Step newStep() {
        return stepBuilderFactory.get("Step")
                .<User, User>chunk(10)
                .reader(reader())
                .processor(process())
                .writer(writer())
                .build();
    }

    @Bean
    public ItemReader<User> reader(){
        JpaPagingItemReader<User> reader = new JpaPagingItemReader<>();
        reader.setQueryString("select u from User u");
        reader.setEntityManagerFactory(entityManagerFactory);
        reader.setPageSize(10);
        try {
            reader.afterPropertiesSet();
        } catch (Exception e) {
            e.printStackTrace();
        }
        reader.setSaveState(true);
        return reader;
    }

    public class processor implements ItemProcessor<Cards, CardsDetail>{
        @Override
        public CardsDetail process(final Cards cards){
            CardsDetail cardsDetail = new CardsDetail();
            return cardsDetail;
        }
    }*/
}

//모든 유저에게 00시를 기점으로 카드 하나씩 생성 ==> 어떻게구현?
//daily check가 하나라도 true인 카드가 있는 사용자는 새 카드를 만들 때 해당 항목으로 list 생성
//daily check가 없는 사용자는 임의의 form 생성