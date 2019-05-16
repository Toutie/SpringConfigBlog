package com.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.github.pagehelper.PageInterceptor;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.MyBatisSystemException;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.Properties;

/**
 * @author wang
 */

@Configuration
@ComponentScan(basePackages = {"com.config", "com.controller", "com.service"},
        includeFilters = {@ComponentScan.Filter(type = FilterType.ANNOTATION,
                classes = {Service.class, Repository.class})})
@PropertySource(value = "classpath:dataSource.properties")
public class RootConfig {

    @Value("${jdbc_driverClassName}")
    public static String jdbcDriver;
    @Value("${jdbc_url}")
    public static String jdbcUrl;
    @Value("${jdbc_userName}")
    public static String jdbcUserName;
    @Value("${jdbc_password}")
    public static String jdbcPassword;
    /**
     * 初始化大小
     * ，最小，最大
     */

    @Value("${jdbc_initialSize}")
    public static int initialSize;

    @Value("${jdbc_minIdle}")
    public static int minIdle;

    @Value("${jdbc_maxActive}")
    public static int maxActive;
    /**
     * 配置获取连接等待超时的时间
     */
    @Value("${jdbc_maxWait}")
    public static long maxWait;
    /**
     * 配置间隔多久才进行一次检测，检测需要关闭的空闲连接，单位是毫秒
     */
    @Value("${jdbc_timeBetweenEvictionRunsMillis}")
    public static long timeBetweenEvictionRunsMillis;
    /**
     * 配置一个连接在池中最小生存的时间，单位是毫秒
     */
    @Value("${jdbc_minEvictableIdleTimeMillis}")
    public static long minEvictableIdleTimeMillis;


    @Bean
    public DruidDataSource dataSource() {
        DruidDataSource druidDataSource = new DruidDataSource();
        druidDataSource.setDriverClassName(jdbcDriver);
        druidDataSource.setUrl(jdbcUrl);
        druidDataSource.setUsername(jdbcUserName);
        druidDataSource.setPassword(jdbcPassword);
        druidDataSource.setInitialSize(initialSize);
        druidDataSource.setMinIdle(minIdle);
        druidDataSource.setMaxActive(maxActive);
        druidDataSource.setMaxWait(maxWait);
        druidDataSource.setTimeBetweenEvictionRunsMillis(timeBetweenEvictionRunsMillis);
        druidDataSource.setMinEvictableIdleTimeMillis(minEvictableIdleTimeMillis);
        return druidDataSource;

    }


    @Bean
    public SqlSessionFactoryBean sessionFactory(DruidDataSource dataSource){
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dataSource);
        GenericApplicationContext context = new GenericApplicationContext();
        try {
            Resource[] resource = context.getResources("classpath:mapper/*.xml");
            sqlSessionFactoryBean.setMapperLocations(resource);
            sqlSessionFactoryBean.setTypeAliasesPackage("com.bean");
            
        }catch (Exception e){
            e.printStackTrace();
        }

        return sqlSessionFactoryBean;
    }


    @Bean
    public PageInterceptor pageInterceptor() {
        PageInterceptor pageInterceptor = new PageInterceptor();
        Properties properties = new Properties();
        properties.setProperty("reasonable", "true");
        pageInterceptor.setProperties(properties);
        return pageInterceptor;
    }


}
