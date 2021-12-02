package ma.emsi.billingservice.controller;

import ma.emsi.billingservice.entities.Bill;
import ma.emsi.billingservice.feign.CustomerRestClient;
import ma.emsi.billingservice.feign.ProductItemRestClient;
import ma.emsi.billingservice.model.Product;
import ma.emsi.billingservice.repository.BillRepository;
import ma.emsi.billingservice.repository.ProductItemRepository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


@CrossOrigin("*")
@RestController
public class BillRestController {

    private BillRepository billRepository;
    private ProductItemRepository productItemRepository;
    private CustomerRestClient customerRestClient;
    private ProductItemRestClient productItemRestClient;

    public BillRestController(BillRepository billRepository, ProductItemRepository productItemRepository, CustomerRestClient customerRestClient, ProductItemRestClient productItemRestClient) {
        this.billRepository = billRepository;
        this.productItemRepository = productItemRepository;
        this.customerRestClient = customerRestClient;
        this.productItemRestClient = productItemRestClient;
    }

    @GetMapping("/fullBill/{id}")
    public Bill getBill(@PathVariable Long id) {
        Bill bill = billRepository.findById(id).get();
        bill.setCustomer(customerRestClient.getCustomerById(bill.getCustomerID()));
        bill.getProductItems().forEach(productItem -> {
            Product product = productItemRestClient.getProductById(productItem.getProductId());
            productItem.setProduct(product);
        });
        return bill;
    }
}
