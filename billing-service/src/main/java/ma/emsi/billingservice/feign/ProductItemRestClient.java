package ma.emsi.billingservice.feign;

import ma.emsi.billingservice.model.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.hateoas.PagedModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "INVENTORY-SERVICE")
public interface ProductItemRestClient {
    @GetMapping("/products")
    PagedModel<Product> pageProducts();

    @GetMapping("/products/{id}")
    Product getProductById(@PathVariable("id") Long id);
}
