package br.com.mdfilipiaki.springwithjunit.controllers.product.dto;

import br.com.mdfilipiaki.springwithjunit.models.Product;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;

public class ProductMapper {

    static public Product convertToEntity(final ProductDTO productDTO) {
        return new Product(productDTO.getName(), productDTO.getPrice());
    }

    static public ProductDTO convertToDTO(
            final Product product
    ) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(product, ProductDTO.class);
    }
}
