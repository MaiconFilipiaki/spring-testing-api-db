package br.com.mdfilipiaki.springwithjunit.apis;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class ResponsePokemonApi {

    private int count;
    private String next;
    private String previous;
    private List<ContentPokemon> results;

}
