package spring.plantshop.configuration;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableAutoConfiguration
@EntityScan(basePackages = {"spring.plantshop.domain"})
@EnableJpaRepositories(basePackages = {"spring.plantshop.repositories"})
@EnableTransactionManagement
public class RepositoryConfiguration {
}
