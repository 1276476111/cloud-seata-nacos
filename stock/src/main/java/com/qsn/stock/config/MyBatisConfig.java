package com.qsn.stock.config;

//import com.alibaba.druid.pool.DruidDataSource;
//import io.seata.rm.datasource.DataSourceProxy;
//import org.apache.ibatis.session.SqlSessionFactory;
//import org.mybatis.spring.SqlSessionFactoryBean;
//import org.mybatis.spring.SqlSessionTemplate;
//import org.mybatis.spring.transaction.SpringManagedTransactionFactory;
//import org.springframework.boot.context.properties.ConfigurationProperties;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.Primary;
//import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
//
//import javax.sql.DataSource;
//
//@Configuration
//public class MyBatisConfig {
//
//    @Bean
//    @ConfigurationProperties(prefix = "spring.datasource")
//    public DataSource druidDataSource(){
//        DruidDataSource druidDataSource = new DruidDataSource();
//        return druidDataSource;
//    }
//
//    /**
//     * 创建DataSourceProxy
//     */
//    @Primary
//    @Bean("dataSource")
//    public DataSourceProxy dataSourceProxy(DataSource druidDataSource){
//        return new DataSourceProxy(druidDataSource);
//    }
//
//    /**
//     * 将原有的DataSource对象替换为DataSourceProxy
//     */
//    @Bean
//    public SqlSessionFactory sqlSessionFactory(DataSourceProxy dataSourceProxy)throws Exception{
//        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
//        sqlSessionFactoryBean.setDataSource(dataSourceProxy);
//        sqlSessionFactoryBean.setMapperLocations(new PathMatchingResourcePatternResolver()
//                .getResources("classpath*:/mapper/*.xml"));
//        sqlSessionFactoryBean.setTransactionFactory(new SpringManagedTransactionFactory());
//        return sqlSessionFactoryBean.getObject();
//    }
//}