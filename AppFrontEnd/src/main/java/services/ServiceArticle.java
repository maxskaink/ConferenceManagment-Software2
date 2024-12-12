package services;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import mapper.Mapper;
import models.ArticleDTO;
import models.ListArticleConferencesDTO;

public class ServiceArticle {

    private static final String BASE_URL = "http://localhost:8083/api/articles"; // {{PATH}}/articles
    private final HttpClient httpClient;
    
    private ArticleDTO article;
    private ListArticleConferencesDTO articlesList;

    public ServiceArticle() {
        this.httpClient = HttpClient.newHttpClient();
    }

    // Listar artículos de una conferencia
    public ListArticleConferencesDTO getArticlesByConference(String token, String idConference) throws Exception {
        String url = BASE_URL + "/conferences/" + idConference;
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .header("Authorization", "Bearer " + token)
                .GET()
                .build();

        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
        if (response.statusCode() == 200) {
            articlesList = Mapper.jsonToListArticleConferencesDTO(response.body());
            return articlesList;
        } else {
            throw new RuntimeException("Failed to fetch articles by conference: " + response.body());
        }
    }

    // Listar artículos de un autor
    public ListArticleConferencesDTO getArticlesByAuthor(String token, String idAuthor) throws Exception {
        String url = BASE_URL + "/author/" + idAuthor;
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .header("Authorization", "Bearer " + token)
                .GET()
                .build();

        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
        if (response.statusCode() == 200) {
            articlesList = Mapper.jsonToListArticleConferencesDTO(response.body());
            return articlesList;
        } else {
            throw new RuntimeException("Failed to fetch articles by author: " + response.body());
        }
    }

    // Crear un artículo dentro de una conferencia
    public ArticleDTO createArticle(String token, ArticleDTO article) throws Exception {
        // Convertir el ArticleDTO a JSON manualmente
        String articleJson = """
    {
        "name": "%s",
        "idAuthor": "%s",
        "keyWords": "%s",
        "publishDate": {
            "day": %d,
            "month": %d,
            "year": %d
        }
    }
    """.formatted(
                article.getName(), article.getIdAuthor(), article.getKeyWords(),
                article.getPublishDate().getDay(), article.getPublishDate().getMonth(), article.getPublishDate().getYear()
        );

        // Ajustar la URL para incluir el idConference
        String url = BASE_URL + "/conferences/" + article.getIdConference();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .header("Authorization", "Bearer " + token)
                .header("Content-Type", "application/json")
                .POST(HttpRequest.BodyPublishers.ofString(articleJson))
                .build();

        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
        if (response.statusCode() == 201) {
            article = Mapper.jsonToArticleDTO(response.body());
            return article;
        } else {
            throw new RuntimeException("Failed to create article: " + response.body());
        }
    }

    // Actualizar un artículo
    public String updateArticle(String token, ArticleDTO article) throws Exception {
        // Convertir el ArticleDTO a JSON manualmente
        String articleJson = """
    {
        "name": "%s",
        "idAuthor": "%s",
        "keyWords": "%s",
        "publishDate": {
            "day": %d,
            "month": %d,
            "year": %d
        }
    }
    """.formatted(
                article.getName(), article.getIdAuthor(), article.getKeyWords(),
                article.getPublishDate().getDay(), article.getPublishDate().getMonth(), article.getPublishDate().getYear()
        );
        String url = BASE_URL + "/" + article.getId();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .header("Authorization", "Bearer " + token)
                .header("Content-Type", "application/json")
                .PUT(HttpRequest.BodyPublishers.ofString(articleJson))
                .build();

        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
        if (response.statusCode() == 200) {
            return response.body();
        } else {
            throw new RuntimeException("Failed to update article: " + response.body());
        }
    }

    // Eliminar un artículo
    public String deleteArticle(String token, String idArticle) throws Exception {
        String url = BASE_URL + "/" + idArticle;
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .header("Authorization", "Bearer " + token)
                .DELETE()
                .build();

        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
        if (response.statusCode() == 200) {
            return response.body();
        } else {
            throw new RuntimeException("Failed to delete article: " + response.body());
        }
    }
}
