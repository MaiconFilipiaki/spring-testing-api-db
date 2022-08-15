package br.com.mdfilipiaki.springwithjunit.controllers.product;

import br.com.mdfilipiaki.springwithjunit.controllers.product.dto.ProductDTO;
import br.com.mdfilipiaki.springwithjunit.controllers.product.dto.ProductMapper;
import br.com.mdfilipiaki.springwithjunit.models.Product;
import br.com.mdfilipiaki.springwithjunit.services.ProductService;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@AllArgsConstructor
@RestController
@RequestMapping("/product")
public class ProductController {

    private final ProductService productService;

    @GetMapping
    public String getProduct() {
        return "Opa";
    }

    @PostMapping
    @ApiResponse(
            responseCode = "201",
            description = "Created"
    )
    public ProductDTO createProduct(@Valid @RequestBody ProductDTO productDTO) {
        return ProductMapper.convertToDTO(this.productService.createProduct(
                    ProductMapper.convertToEntity(productDTO)
                )
        );
    }

    private Product convertToEntity(ProductDTO productDTO) {
        return new Product(productDTO.getName(), productDTO.getPrice());
    }

}
