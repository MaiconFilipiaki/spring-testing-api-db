package br.com.mdfilipiaki.springwithjunit.services;

import br.com.mdfilipiaki.springwithjunit.controllers.product.dto.ProductDTO;
import br.com.mdfilipiaki.springwithjunit.models.Product;
import br.com.mdfilipiaki.springwithjunit.repositories.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class ProductService {

    private final ProductRepository productRepository;

    public Product createProduct(Product product) {
        return this.productRepository.save(product);
    }

}
