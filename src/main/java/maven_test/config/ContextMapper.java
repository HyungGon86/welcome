package maven_test.config;

import java.io.IOException;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

@Configuration
@MapperScan(basePackages = "maven_test")
public class ContextMapper {

	@Bean
	public SqlSessionFactoryBean sqlSession(DataSource dataSource) throws IOException {
		SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
		PathMatchingResourcePatternResolver pmrpr = new PathMatchingResourcePatternResolver();
		sqlSessionFactoryBean.setDataSource(dataSource);
		sqlSessionFactoryBean
				.setConfigLocation(pmrpr.getResource("classpath:/egovframework/sqlmap/example/sql-mapper-config.xml"));
		sqlSessionFactoryBean
				.setMapperLocations(pmrpr.getResources("classpath:/egovframework/sqlmap/example/mappers/*.xml"));
		return sqlSessionFactoryBean;
	}

	@Bean
	public SqlSessionTemplate sqlSession(SqlSessionFactory sqlSessionFactory) {
		return new SqlSessionTemplate(sqlSessionFactory);
	}

}
