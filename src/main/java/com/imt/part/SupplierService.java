package com.imt.part;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.HashMap;

@Service
public class SupplierService {

    private final String API_URL = "https://jsonplaceholder.typicode.com";

    public PartEntity getCurrentWeather() {
        PartEntity partEntity = new PartEntity();
        partEntity.setName("Weather Statics");
        partEntity.setSupplierCode("WEATHER_API");

        int jsonId = (int) (Math.random() * 100);

        WebClient client = WebClient.create(API_URL);

        Mono<ResponseEntity<Object>> response = client.get()
                .uri("/todos/" + jsonId).accept(org.springframework.http.MediaType.APPLICATION_JSON)
                .retrieve().toEntity(Object.class);

        Object body = response.block().getBody();
        String title = ((HashMap) body).get("title").toString();

        partEntity.setDescription(title);
        return partEntity;
    }
}
