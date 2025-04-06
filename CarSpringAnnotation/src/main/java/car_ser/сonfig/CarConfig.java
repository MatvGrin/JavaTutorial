package car_ser.сonfig;


import car_ser.CarDemo;
import car_ser.repo.CarRepo;
import car_ser.repo.CarRepoJdbcSpring;
import car_ser.service.CarServiceImpl;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
@ComponentScan(basePackages = "car_ser")
public class CarConfig {

    @Bean
    public DriverManagerDataSource dataSource() {
        DriverManagerDataSource ds = new DriverManagerDataSource();
        ds.setUrl("jdbc:mysql://127.0.0.1:3306/car_ser?useSSL=true&characterEncoding=utf8");
        ds.setUsername("root");
        ds.setPassword("root");
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

}
