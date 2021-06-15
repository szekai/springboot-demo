package com.example.demo.batchprocessing;

import com.example.demo.models.CustomerTrx;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.database.BeanPropertyItemSqlParameterSourceProvider;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.batch.item.database.builder.JdbcBatchItemWriterBuilder;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

import javax.sql.DataSource;
import java.beans.PropertyEditor;
import java.util.HashMap;
import java.util.Map;


@Configuration
@EnableBatchProcessing
public class BatchConfiguration {

	@Autowired
	public JobBuilderFactory jobBuilderFactory;

	@Autowired
	public StepBuilderFactory stepBuilderFactory;

	@Bean
	public FlatFileItemReader<CustomerTrx> reader() {
		FlatFileItemReader<CustomerTrx> reader = new FlatFileItemReader<>();
		reader.setResource(new ClassPathResource("dataSource.txt"));
		Map<Class<String>, PropertyEditor> customEditors = new HashMap<>();
		reader.setLineMapper(new DefaultLineMapper<>() {{
			setLineTokenizer(new DelimitedLineTokenizer() {{
				setNames("accNumber", "trxAmount", "description", "trxDate", "trxTime", "custId");
				setDelimiter("|");
			}});
			setFieldSetMapper(new BeanWrapperFieldSetMapper<>() {{
				setTargetType(CustomerTrx.class);
			}});
		}});
		reader.setLinesToSkip(1);
		return reader;
	}

	@Bean
	public CustItemProcessor processor() {
		return new CustItemProcessor();
	}

	@Bean
	public JdbcBatchItemWriter<CustomerTrx> writer(DataSource dataSource) {
		return new JdbcBatchItemWriterBuilder<CustomerTrx>()
			.itemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<>())
			.sql("INSERT INTO cust_trx (acc_number, trx_amount, description, trx_date, trx_time, cust_id) VALUES (:accNumber, :trxAmount, :description, :trxDate, :trxTime, :custId)")
			.dataSource(dataSource)
			.build();
	}

	@Bean
	public Job importUserJob(JobCompletionNotificationListener listener, Step step1) {
		return jobBuilderFactory.get("importUserJob")
			.incrementer(new RunIdIncrementer())
			.listener(listener)
			.flow(step1)
			.end()
			.build();
	}

	@Bean
	public Step step1(JdbcBatchItemWriter<CustomerTrx> writer) {
		return stepBuilderFactory.get("step1")
			.<CustomerTrx, CustomerTrx> chunk(10)
			.reader(reader())
			.processor(processor())
			.writer(writer)
			.build();
	}
}
