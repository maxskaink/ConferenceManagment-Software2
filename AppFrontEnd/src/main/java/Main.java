import models.ArticleDTO;
import models.ConferenceDTO;
import models.BasicDate;
import services.ServiceArticle;
import services.ServiceAuth;
import services.ServiceConference;
public class Main {
    public static void main(String[] args) {
        try {
            // Instancia del servicio de conferencias
            ServiceConference serviceConference = new ServiceConference();
            ServiceAuth authService = new ServiceAuth();

            // Login del usuario y obtener el token
            String username = "pablo";
            String password = "1234";
            String tokenResponse = authService.login(username, password);

            // Extraer el access_token del JSON de respuesta
            String accessToken = tokenResponse.substring(tokenResponse.indexOf("access_token\":\"") + 15);
            accessToken = accessToken.substring(0, accessToken.indexOf("\""));

            System.out.println("Token de acceso obtenido: " + accessToken);

            // 1. Listar todas las conferencias
            System.out.println("\n[1] Listar todas las conferencias:");
            String allConferences = serviceConference.getAllConferences(accessToken);
            System.out.println(allConferences);

            // 2. Crear una nueva conferencia
            System.out.println("\n[2] Crear una nueva conferencia:");            
            BasicDate startDate = new BasicDate(1, 1, 2020);
            BasicDate finishDate = new BasicDate(1, 2, 2020);
            ConferenceDTO conference = new ConferenceDTO("name", startDate, finishDate, "lugar", "tema", "55555", "descripcion");
            String createdConference = serviceConference.createConference(accessToken, conference);
            System.out.println(createdConference);

            // 3. Listar conferencias por organizador
            System.out.println("\n[3] Listar conferencias de un organizador:");
            String idOrganizer = "12345"; // Debe ser un organizador válido en el sistema
            String organizerConferences = serviceConference.getConferencesByOrganizer(accessToken, idOrganizer);
            System.out.println(organizerConferences);

            // 4. Actualizar una conferencia
            System.out.println("\n[4] Actualizar una conferencia:");
            String updatedConference = serviceConference.updateConference(accessToken, "9876", conference);
            System.out.println(updatedConference);

            // 5. Eliminar una conferencia
            System.out.println("\n[5] Eliminar una conferencia:");
            String idConference = "67890"; // Cambiar por el ID real de una conferencia existente
            String deletedConference = serviceConference.deleteConference(accessToken, idConference);
            System.out.println(deletedConference);

        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
