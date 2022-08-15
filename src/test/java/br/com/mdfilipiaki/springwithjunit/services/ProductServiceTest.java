package br.com.mdfilipiaki.springwithjunit.services;

import br.com.mdfilipiaki.springwithjunit.models.Product;
import br.com.mdfilipiaki.springwithjunit.repositories.ProductRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@AutoConfigureMockMvc
class ProductServiceTest {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ProductService productService;

    @Test
    void registrationProduct() {
        Product product = new Product("TV", 100.0);

        Product productSave = this.productRepository.save(product);

        assertThat(product.getName()).isEqualTo(productSave.getName());
        assertThat(product.getPrice()).isEqualTo(productSave.getPrice());
        assertThat(product.getId()).isNotNull();
    }

    @Test
    void registerProductFromService() {
        Product product = new Product("TV", 100.0);

        var productSave = this.productService.createProduct(product);

        assertThat(product.getName()).isEqualTo(productSave.getName());
        assertThat(product.getPrice()).isEqualTo(productSave.getPrice());
        assertThat(product.getId()).isNotNull();
    }

}