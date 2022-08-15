package br.com.mdfilipiaki.springwithjunit.services;

import br.com.mdfilipiaki.springwithjunit.apis.PokemonApi;
import org.junit.jupiter.api.Test;
import org.springframework.util.Assert;
import org.springframework.web.reactive.function.client.WebClient;

import javax.validation.constraints.AssertTrue;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class PokemonApiTest {

    private PokemonApi pokemonApi = new PokemonApi(WebClient.create());

    @Test
    void getPokemonListWithSuccess() {
        var pokemons = this.pokemonApi.getPokemonList();
        System.out.println(pokemons);
        assertTrue(pokemons.getResults().size()>0);
    }

}
