package club.ouka.config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
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
@MapperScan(basePackages = "club.ouka.test02.mapper",sqlSessionFactoryRef = "db2SqlSessionFactory")
public class Db2DataSourceConfig {

    @Bean(name = "db2Datasource")
    @ConfigurationProperties(prefix = "spring.datasource.druid.db2")
    @Primary
    public DataSource db1Datasource(){

        return DataSourceBuilder.create().build();
    }


    @Bean(name = "db2SqlSessionFactory")
    @Primary
    public SqlSessionFactory db1SqlSessionFactory(@Qualifier("db2Datasource")DataSource db2Datasource) throws Exception{
        SqlSessionFactoryBean fb = new SqlSessionFactoryBean();
        fb.setDataSource(db2Datasource);
//        fb.setTypeAliasesPackage("com.xc.boot.datasource");
        fb.setMapperLocations(
                new PathMatchingResourcePatternResolver().getResources("classpath:/mapper/db2/*.xml")
        );
        return fb.getObject();
    }


    @Bean(name="db2TransactionManager")
    @Primary
    public DataSourceTransactionManager vxTransactionManager(@Qualifier("db2Datasource")DataSource db2Datasource) throws Exception{
        return new DataSourceTransactionManager(db2Datasource);
    }


    @Bean(name = "db2SqlSessionTemplate")
    public SqlSessionTemplate db1SqlSessionTemplate(@Qualifier("db2SqlSessionFactory")SqlSessionFactory sqlSessionFactory){
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
