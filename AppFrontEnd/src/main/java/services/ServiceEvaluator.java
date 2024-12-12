package services;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import models.EvaluatorDTO;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;
import models.ArticleDTO;

public class ServiceEvaluator {
    private static final String BASE_URL = "http://localhost:8085/review"; 
    private final HttpClient httpClient;
    private final ObjectMapper objectMapper;

    public ServiceEvaluator() {
        this.httpClient = HttpClient.newHttpClient();
        this.objectMapper = new ObjectMapper();
    }

    // POST "/evaluator" - Crear un evaluador
    public EvaluatorDTO createEvaluator(EvaluatorDTO evaluator) throws Exception {
        String requestBody = objectMapper.writeValueAsString(evaluator);

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(BASE_URL + "/evaluator"))
                .header("Content-Type", "application/json")
                .POST(HttpRequest.BodyPublishers.ofString(requestBody))
                .build();

        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

        if (response.statusCode() == 200) {
            return objectMapper.readValue(response.body(), EvaluatorDTO.class);
        } else {
            throw new RuntimeException("Error al crear evaluador: " + response.body());
        }
    }

    // GET "/evaluator" - Listar todos los evaluadores
    public List<EvaluatorDTO> getAllEvaluators() throws Exception {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(BASE_URL + "/evaluator"))
                .GET()
                .build();

        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

        if (response.statusCode() == 200) {
            return objectMapper.readValue(response.body(), new TypeReference<List<EvaluatorDTO>>() {});
        } else {
            throw new RuntimeException("Error al listar evaluadores: " + response.body());
        }
    }

    // GET "/evaluator/disponibles" - Listar evaluadores disponibles
    public List<EvaluatorDTO> getAvailableEvaluators() throws Exception {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(BASE_URL + "/evaluator/disponibles"))
                .GET()
                .build();

        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

        if (response.statusCode() == 200) {
            return objectMapper.readValue(response.body(), new TypeReference<List<EvaluatorDTO>>() {});
        } else {
            throw new RuntimeException("Error al listar evaluadores disponibles: " + response.body());
        }
    }

    // GET "/evaluator/{id}" - Obtener información de un evaluador
    public EvaluatorDTO getEvaluatorById(String evaluatorId) throws Exception {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(BASE_URL + "/evaluator/" + evaluatorId))
                .GET()
                .build();

        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

        if (response.statusCode() == 200) {
            return objectMapper.readValue(response.body(), EvaluatorDTO.class);
        } else {
            throw new RuntimeException("Error al obtener evaluador: " + response.body());
        }
    }

    // GET "/evaluator/{id}/articles" - Listar artículos de un evaluador
    public List<ArticleDTO> getArticlesByEvaluator(String evaluatorId) throws Exception {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(BASE_URL + "/evaluator/" + evaluatorId + "/articles"))
                .GET()
                .build();

        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

        if (response.statusCode() == 200) {
            return objectMapper.readValue(response.body(), new TypeReference<List<ArticleDTO>>() {});
        } else {
            throw new RuntimeException("Error al obtener artículos de evaluador: " + response.body());
        }
    }

    // POST "/article/{articleId}/asignar-evaluadores" - Asignar evaluadores a un artículo
    public String assignEvaluatorsToArticle(String articleId, List<EvaluatorDTO> evaluators) throws Exception {
        String requestBody = objectMapper.writeValueAsString(evaluators);

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(BASE_URL + "/article/" + articleId + "/asignar-evaluadores"))
                .header("Content-Type", "application/json")
                .POST(HttpRequest.BodyPublishers.ofString(requestBody))
                .build();

        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

        if (response.statusCode() == 200) {
            return response.body();
        } else {
            throw new RuntimeException("Error al asignar evaluadores: " + response.body());
        }
    }
    
    public List<EvaluatorDTO> getEvaluatorsByArticle(String authToken, String articleId) throws Exception {
        List<EvaluatorDTO> allEvaluators = getAllEvaluators(); // Obtener evaluadores
        List<EvaluatorDTO> assignedEvaluators = new ArrayList<>();

        for (EvaluatorDTO evaluator : allEvaluators) {
            List<ArticleDTO> articles = getArticlesByEvaluator(evaluator.getId());
            for (ArticleDTO article : articles) {
                if (article.getId().equals(articleId)) {
                    assignedEvaluators.add(evaluator);
                    break;
                }
            }
        }
        return assignedEvaluators;
    }

}
