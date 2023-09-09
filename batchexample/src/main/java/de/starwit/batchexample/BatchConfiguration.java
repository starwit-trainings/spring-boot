package de.starwit.batchexample;

import javax.sql.DataSource;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.item.database.BeanPropertyItemSqlParameterSourceProvider;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.batch.item.database.builder.JdbcBatchItemWriterBuilder;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.FileSystemResource;
import org.springframework.transaction.PlatformTransactionManager;

@Configuration
public class BatchConfiguration {

    @Value("${batch.filename}")
    private String importFilename;

    @Bean
    public FlatFileItemReader<Article> reader() {
        return new FlatFileItemReaderBuilder<Article>()
                .name("articleItemReader")
                .resource(new FileSystemResource(importFilename))
                .delimited().delimiter(";")
                .names(new String[] { "name", "price", "weight", "color" })
                .fieldSetMapper(new BeanWrapperFieldSetMapper<Article>() {
                    {
                        setTargetType(Article.class);
                    }
                })
                .linesToSkip(1) // ignore header
                .build();
    }

    @Bean
    public ArticleItemProcessor processor() {
        return new ArticleItemProcessor();
    }

    @Bean
    public JdbcBatchItemWriter<Article> writer(DataSource dataSource) {
        return new JdbcBatchItemWriterBuilder<Article>()
                .itemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<>())
                .sql("INSERT INTO ARTICLE (name, price, weight, color) VALUES (:name, :price, :weight, :color)")
                .dataSource(dataSource)
                .build();
    }

    @Bean
    public Job importUserJob(JobRepository jobRepository,
        JobCompletionNotificationListener listener, Step step1) {
    return new JobBuilder("importUserJob", jobRepository)
        .incrementer(new RunIdIncrementer())
        .listener(listener)
        .flow(step1)
        .end()
        .build();
    }

    @Bean
    public Step step1(JobRepository jobRepository,
        PlatformTransactionManager transactionManager, JdbcBatchItemWriter<Article> writer) {

    return new StepBuilder("step1", jobRepository)
        .<Article, Article> chunk(10, transactionManager)
        .reader(reader())
        .processor(processor())
        .writer(writer)
        .build();
    }    
}
