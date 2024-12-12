package services;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ServiceAuth {
    private static final String SERVER_URL = "http://localhost:9090";
    private static final String REALM = "ConferenceMaster";
    private static final String CLIENT_ID = "Microservice-API";
    private static final String CLIENT_SECRET = "**********";

    public String login(String username, String password) throws Exception {
        String tokenUrl = SERVER_URL + "/realms/" + REALM + "/protocol/openid-connect/token";

        String body = "client_id=" + CLIENT_ID +
                      "&client_secret=" + CLIENT_SECRET +
                      "&grant_type=password" +
                      "&username=" + username +
                      "&password=" + password;

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
            .uri(URI.create(tokenUrl))
            .header("Content-Type", "application/x-www-form-urlencoded")
            .POST(HttpRequest.BodyPublishers.ofString(body))
            .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        if (response.statusCode() == 200) {
            return response.body();
        } else {
            throw new RuntimeException("Failed to authenticate: " + response.body());
        }
    }
}
