package maven_test.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

// 데이터베이스 설정
@Configuration
@EnableTransactionManagement
public class ContextDataSource {

//	@Bean
//	public DataSourceTransactionManager transactionManager() {
//		return new DataSourceTransactionManager(dataSource());
//	}

}
