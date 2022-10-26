//
//package com.issues.demo;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Configuration;
//
//@Configuration
//public class EntityManagerFactoriesConfiguration {
//    @Autowired
//    private DataSource dataSource;
//
//    @Bean(name = "entityManagerFactory")
//    public LocalContainerEntityManagerFactoryBean emf() {
//        LocalContainerEntityManagerFactoryBean emf = ...
//        emf.setDataSource(dataSource);
//        emf.setPackagesToScan(new String[] {"your.package"});
//        emf.setJpaVendorAdapter(
//        new HibernateJpaVendorAdapter());
//        return emf;
//   }
//}