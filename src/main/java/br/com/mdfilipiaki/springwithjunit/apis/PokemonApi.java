package br.com.mdfilipiaki.springwithjunit.apis;

import lombok.AllArgsConstructor;
import org.springframework.web.reactive.function.client.WebClient;

@AllArgsConstructor
public class PokemonApi {

    private WebClient webClient;

    public ResponsePokemonApi getPokemonList() {
        var response = this.webClient
                .get()
                .uri("https://pokeapi.co/api/v2/pokemon")
                .retrieve()
                .bodyToFlux(ResponsePokemonApi.class)
                .single()
                .block();
        return response;
    }

}
