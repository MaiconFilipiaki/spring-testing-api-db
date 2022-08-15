package br.com.mdfilipiaki.springwithjunit.graphql;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Data
public class ProductInput {

    private String name;
    private Double price;

}
