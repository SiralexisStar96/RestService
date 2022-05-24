package com.example.payroll;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.client.AutoConfigureWebClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.web.client.RestTemplate;

import static org.junit.jupiter.api.Assertions.*;

//Para lanzar pruebas a un puerto random que sea diferente
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
//Le autoconfiguramos un web test Client
    @AutoConfigureWebClient
class EmployeeControllerTest {

    //Utilizamos un web cliente para realizar peticiones http
    @Autowired
    private WebTestClient webTestClient;

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void all(){
        webTestClient.get()
                .uri("/employees")
                .exchange()
                .expectStatus().isOk()
                .expectHeader().valueEquals("Content-Type","application/hal+json")
                .expectBody()
                .jsonPath("$.length()").isEqualTo(2);

    }

    @Test
    void one(){

    }
}