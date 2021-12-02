package ma.emsi.customerservice;

import ma.emsi.customerservice.entities.Customer;
import ma.emsi.customerservice.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

@SpringBootApplication
public class CustomerServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(CustomerServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner start(CustomerRepository customerRepository,
                            RepositoryRestConfiguration restConfiguration){
        restConfiguration.exposeIdsFor(Customer.class);
        return args -> {
            customerRepository.save(new Customer(null, "Othman", "othman@gmail.com"));
            customerRepository.save(new Customer(null, "Hamid", "hamid@gmail.com"));
            customerRepository.save(new Customer(null, "Asmae", "asmae@gmail.com"));
            customerRepository.findAll().forEach(customer -> {
                System.out.println(customer);
            });
        };
    }
}
