package br.com.mdfilipiaki.springwithjunit.controllers.product.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ProductDTO {

    @NotEmpty
    @NotBlank
    @NotNull
    @Size(min = 2, message = "name is required")
    @Schema(description = "Name of product", example = "TV", required = true)
    private String name;

    @NotNull
    @Schema(description = "price of product", example = "100.00", required = true)
    @Digits(integer = 10, fraction = 2)
    private Double price;

}
