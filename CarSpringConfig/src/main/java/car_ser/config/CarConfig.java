package car_ser.config;

import car_ser.CarDemo;
import car_ser.repo.CarRepo;
import car_ser.repo.CarRepoJdbcSpring;
import car_ser.service.CarServiceImpl;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
@PropertySource("classpath:application.properties")
public class CarConfig {

    @Value("${jdbc.url}")
    private String url;
    @Value("${jdbc.username}")
    private String userName;
    @Value("${jdbc.password}")
    private String pwd;

    @Bean
    public DriverManagerDataSource dataSource() {
        DriverManagerDataSource ds = new DriverManagerDataSource();
        ds.setUrl(url);
        ds.setUsername(userName);
        ds.setPassword(pwd);
        return ds;
    }

    @Bean
    public JdbcTemplate jdbcTemplate(DriverManagerDataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }

    @Bean
    public CarRepo carRepo(JdbcTemplate jdbcTemplate) {
        return new CarRepoJdbcSpring(jdbcTemplate);
    }

    @Bean
    public CarServiceImpl carServiceImpl(CarRepo carRepo) {
        CarServiceImpl carService = new CarServiceImpl();
        carService.setCarRepo(carRepo);
        return carService;
    }

    @Bean
    public CarDemo carDemo(CarServiceImpl carServiceImpl) {
        return new CarDemo(carServiceImpl);
    }

}
