package services;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import mapper.Mapper;
import models.ConferenceDTO;

public class ServiceConference {
    private static final String BASE_URL = "http://localhost:8083/api/conferences"; // {{PATH}}/conferences
    private final HttpClient httpClient;

    public ServiceConference() {
        this.httpClient = HttpClient.newHttpClient();
    }

    // Listar todas las conferencias
    public String getAllConferences(String token) throws Exception {
        HttpRequest request = HttpRequest.newBuilder()
            .uri(URI.create(BASE_URL))
            .header("Authorization", "Bearer " + token)
            .GET()
            .build();

        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
        if (response.statusCode() == 200) {
            return response.body();
        } else {
            throw new RuntimeException("Failed to fetch conferences: " + response.body());
        }
    }

    // Listar conferencias de un organizador
    public String getConferencesByOrganizer(String token, String idOrganizer) throws Exception {
        String url = BASE_URL + "/organizer/" + idOrganizer;
        HttpRequest request = HttpRequest.newBuilder()
            .uri(URI.create(url))
            .header("Authorization", "Bearer " + token)
            .GET()
            .build();

        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
        if (response.statusCode() == 200) {
            return response.body();
        } else {
            throw new RuntimeException("Failed to fetch conferences by organizer: " + response.body());
        }
    }

    // Crear una conferencia
    public String createConference(String token, ConferenceDTO conference) throws Exception {
        // Convertir ConferenceDTO a JSON manualmente
        String conferenceJson = Mapper.conferenceDTOToJson(conference);

        HttpRequest request = HttpRequest.newBuilder()
            .uri(URI.create(BASE_URL))
            .header("Authorization", "Bearer " + token)
            .header("Content-Type", "application/json")
            .POST(HttpRequest.BodyPublishers.ofString(conferenceJson))
            .build();

        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
        if (response.statusCode() == 201) {
            return response.body();
        } else {
            throw new RuntimeException("Failed to create conference: " + response.body());
        }
    }

    // Actualizar una conferencia
    public String updateConference(String token, String idConference, ConferenceDTO conference) throws Exception {
        // Convertir ConferenceDTO a JSON manualmente
        String conferenceJson = Mapper.conferenceDTOToJson(conference);

        String url = BASE_URL + "/" + idConference;
        HttpRequest request = HttpRequest.newBuilder()
            .uri(URI.create(url))
            .header("Authorization", "Bearer " + token)
            .header("Content-Type", "application/json")
            .PUT(HttpRequest.BodyPublishers.ofString(conferenceJson))
            .build();

        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
        if (response.statusCode() == 200) {
            return response.body();
        } else {
            throw new RuntimeException("Failed to update conference: " + response.body());
        }
    }

    // Eliminar una conferencia
    public String deleteConference(String token, String idConference) throws Exception {
        String url = BASE_URL + "/" + idConference;
        HttpRequest request = HttpRequest.newBuilder()
            .uri(URI.create(url))
            .header("Authorization", "Bearer " + token)
            .DELETE()
            .build();

        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
        if (response.statusCode() == 200) {
            return response.body();
        } else {
            throw new RuntimeException("Failed to delete conference: " + response.body());
        }
    }
}
