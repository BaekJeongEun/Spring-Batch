package com.fastcampus.hellospringbatch;

import lombok.AllArgsConstructor;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@AllArgsConstructor
public class HelloSpringBatchConfiguration {

    private final JobBuilderFactory jobBuilderFactory;
    private final StepBuilderFactory stepBuilderFactory;

    public static final String STEP_1_NAME = "step1";
    public static final String JOB_NAME = "job";

    @Bean
    public Step step() {
        return this.stepBuilderFactory.get(STEP_1_NAME)
            .tasklet((contribution, chunkContext) -> {
                System.out.println("Hello, Spring Batch!!!");
                return RepeatStatus.FINISHED;
            }).build();
    }

    @Bean
    public Job job() {
        return this.jobBuilderFactory.get(JOB_NAME).start(step()).build();
    }
}
