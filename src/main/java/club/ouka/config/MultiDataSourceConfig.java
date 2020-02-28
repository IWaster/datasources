package club.ouka.config;

import club.ouka.annotation.Db1Dao;
import club.ouka.annotation.Db2Dao;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

/**
 * Description:
 * User: Ouka
 * Date: 2020-02-27
 * Time: 21:20
 */
@Configuration
@Slf4j
public class MultiDataSourceConfig {
//
//    @Bean
//    @Primary
//    @ConfigurationProperties(prefix = "spring.datasource.druid.db1")
//    public DataSource db1Datasource(){
//
//        return DataSourceBuilder.create().build();
//    }
//
//    @Bean
//    @ConfigurationProperties(prefix = "spring.datasource.druid.db2")
//    public DataSource db2Datasource() {
//
//        return DataSourceBuilder.create().build();
//    }
//
//    @Bean
//    @Primary
//    public SqlSessionFactory db1SqlSessionFactory(@Qualifier("db1Datasource")DataSource vxDataSource) throws Exception{
//        SqlSessionFactoryBean fb = new SqlSessionFactoryBean();
//        fb.setDataSource(vxDataSource);
////        fb.setTypeAliasesPackage("com.xc.boot.datasource");
//        fb.setMapperLocations(
//                new PathMatchingResourcePatternResolver().getResources("classpath:/mapper/db2/*.xml")
//        );
//        return fb.getObject();
//    }
//
//    @Bean
//    public SqlSessionFactory db2SqlSessionFactory(@Qualifier("db2Datasource")DataSource crawlerDataSource) throws Exception{
//        SqlSessionFactoryBean fb = new SqlSessionFactoryBean();
//        fb.setDataSource(crawlerDataSource);
////        fb.setTypeAliasesPackage("com.xc.boot.datasource");
//        fb.setMapperLocations(
//                new PathMatchingResourcePatternResolver().getResources("classpath:/mapper/db1/*.xml")
//        );
//        return fb.getObject();
//
//    }
//
//    @Bean(name="db1TransactionManager")
//    @Primary
//    public DataSourceTransactionManager vxTransactionManager(@Qualifier("db1Datasource")DataSource vxDataSource) throws Exception{
//        return new DataSourceTransactionManager(vxDataSource);
//    }
//
//    @Bean(name="db2TransactionManager")
//    public DataSourceTransactionManager crawlerTransactionManager(@Qualifier("db2Datasource")DataSource crawlerDataSource) throws Exception{
//        return new DataSourceTransactionManager(crawlerDataSource);
//    }
//
//
//    @Bean(name="db1MapperScannerConfigurer")
//    @Primary
//    public MapperScannerConfigurer vxMapperScannerConfigurer(){
//        MapperScannerConfigurer configurer = new MapperScannerConfigurer();
//        configurer.setSqlSessionFactoryBeanName("db1SqlSessionFactory");
////        configurer.setBasePackage("com.xc.boot.datasource");
//        configurer.setAnnotationClass(Db1Dao.class);
//        return configurer;
//    }
//
//    @Bean(name="db2MapperScannerConfigurer")
//    public MapperScannerConfigurer crwalerMapperScannerConfigurer(){
//        MapperScannerConfigurer configurer = new MapperScannerConfigurer();
//        configurer.setSqlSessionFactoryBeanName("db2SqlSessionFactory");
////        configurer.setBasePackage("com.xc.boot.datasource");
//        configurer.setAnnotationClass(Db2Dao.class);
//        return configurer;
//    }
}
