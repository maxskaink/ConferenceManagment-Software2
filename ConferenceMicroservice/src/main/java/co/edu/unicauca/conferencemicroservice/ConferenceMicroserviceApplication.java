package co.edu.unicauca.conferencemicroservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class ConferenceMicroserviceApplication {

    public static void main(String[] args) {
        SpringApplication.run(ConferenceMicroserviceApplication.class, args);
    }

}
