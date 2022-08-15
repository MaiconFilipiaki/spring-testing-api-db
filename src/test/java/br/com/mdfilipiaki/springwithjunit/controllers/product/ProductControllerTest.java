package br.com.mdfilipiaki.springwithjunit.controllers.product;

import br.com.mdfilipiaki.springwithjunit.controllers.product.dto.ProductDTO;
import br.com.mdfilipiaki.springwithjunit.models.Product;
import br.com.mdfilipiaki.springwithjunit.repositories.ProductRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
class ProductControllerTest {

    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;
    @Autowired
    private ProductRepository productRepository;


    @Test
    void registrationProductWithSuccess() throws Exception {
        ProductDTO productDTO = new ProductDTO("tv", 100.0);

        mockMvc.perform(post("/product").contentType("application/json")
                .content(objectMapper.writeValueAsString(productDTO)))
                .andExpect(status().isOk());

        Product product = productRepository.findByName("tv");
        assertThat(product.getName()).isEqualTo(productDTO.getName());
        assertThat(product.getPrice()).isEqualTo(productDTO.getPrice());
    }
}