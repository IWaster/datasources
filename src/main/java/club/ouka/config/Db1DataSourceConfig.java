package club.ouka.config;

import club.ouka.annotation.Db1Dao;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
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
 * Date: 2020-02-28
 * Time: 9:16
 */
@Configuration
@MapperScan(basePackages = "club.ouka.test01.mapper",sqlSessionFactoryRef = "db1SqlSessionFactory")
public class Db1DataSourceConfig {

    @Bean(name = "db1Datasource")
    @ConfigurationProperties(prefix = "spring.datasource.druid.db1")
    public DataSource db1Datasource(){

        return DataSourceBuilder.create().build();
    }


    @Bean(name = "db1SqlSessionFactory")
    public SqlSessionFactory db1SqlSessionFactory(@Qualifier("db1Datasource")DataSource db1Datasource) throws Exception{
        SqlSessionFactoryBean fb = new SqlSessionFactoryBean();
        fb.setDataSource(db1Datasource);
//        fb.setTypeAliasesPackage("com.xc.boot.datasource");
        fb.setMapperLocations(
                new PathMatchingResourcePatternResolver().getResources("classpath:/mapper/db1/*.xml")
        );
        return fb.getObject();
    }


    @Bean(name="db1TransactionManager")
    public DataSourceTransactionManager vxTransactionManager(@Qualifier("db1Datasource")DataSource db1Datasource) throws Exception{
        return new DataSourceTransactionManager(db1Datasource);
    }

    @Bean(name = "db1SqlSessionTemplate")
    public SqlSessionTemplate db1SqlSessionTemplate(@Qualifier("db1SqlSessionFactory")SqlSessionFactory sqlSessionFactory){
        return new SqlSessionTemplate(sqlSessionFactory);
    }

    //此处使用分包
    /*@Bean(name="db1MapperScannerConfigurer")
    @Primary
    public MapperScannerConfigurer vxMapperScannerConfigurer(){
        MapperScannerConfigurer configurer = new MapperScannerConfigurer();
        configurer.setSqlSessionFactoryBeanName("db1SqlSessionFactory");
//        configurer.setBasePackage("com.xc.boot.datasource");
        configurer.setAnnotationClass(Db1Dao.class);
        return configurer;
    }*/
}
