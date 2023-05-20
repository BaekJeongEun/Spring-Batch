package com.fastcampus.hellospringbatch.config.simple;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Slf4j
@Configuration
@AllArgsConstructor
class HiBatchJobConfiguration {

    private final JobBuilderFactory jobBuilderFactory;
    private final StepBuilderFactory stepBuilderFactory;

    public static final String JOB_NAME = "helloJob";
    public static final String STEP_1_NAME = "helloStep";
    public static final String MESSAGE = "Hello, Spring Batch!!";


    @Bean
    public Job helloJob() {
        return this.jobBuilderFactory.get(JOB_NAME).start(helloStep()).build();
    }

    @Bean
    public Step helloStep() {
        return this.stepBuilderFactory.get(STEP_1_NAME)
            .tasklet((contribution, chunkContext) -> {
                log.info("This is HelloStep, {}", MESSAGE);
                return RepeatStatus.FINISHED;
            }).build();
    }

}