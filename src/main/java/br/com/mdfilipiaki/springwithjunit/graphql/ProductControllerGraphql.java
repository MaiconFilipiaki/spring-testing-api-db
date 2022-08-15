package br.com.mdfilipiaki.springwithjunit.graphql;

import br.com.mdfilipiaki.springwithjunit.models.Product;
import br.com.mdfilipiaki.springwithjunit.repositories.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.Optional;

@Controller
@AllArgsConstructor
public class ProductControllerGraphql {

   private final ProductRepository productRepository;

   @QueryMapping
   Iterable<Product> products() {
      return this.productRepository.findAll();
   }

   @QueryMapping
   Optional<Product> productById(@Argument Long id) {
      return this.productRepository.findById(id);
   }

   @MutationMapping()
   Product addProduct(@Argument ProductInput product) {
      Product p = new Product(product.getName(), product.getPrice());
      return this.productRepository.save(p);
   }

}
