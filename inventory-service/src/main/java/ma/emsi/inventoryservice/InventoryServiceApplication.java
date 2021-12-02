package ma.emsi.inventoryservice;

import ma.emsi.inventoryservice.entities.Product;
import ma.emsi.inventoryservice.repository.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

@Configuration
@SpringBootApplication
public class InventoryServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(InventoryServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner start(ProductRepository productRepository,
                            RepositoryRestConfiguration restConfiguration){
        restConfiguration.exposeIdsFor(Product.class);
        return args -> {
            productRepository.save(new Product(null,"ordinateur", 5000, 20));
            productRepository.save(new Product(null,"ecran", 2300, 20));
            productRepository.save(new Product(null,"souris", 2300, 20));
            productRepository.save(new Product(null,"clavier", 2300, 20));
            productRepository.findAll().forEach(product -> {
                System.out.println(product);
            });
        };

    }
}
