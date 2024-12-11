package mapper;

import com.fasterxml.jackson.databind.ObjectMapper;
import models.Article;
import models.ArticleDTO;
import models.BasicDate;
import models.ConferenceDTO;
import models.Conference;
import models.ListConferencesDTO;
import models.ListArticleConferencesDTO;
import models.ListConferencesOrganizerDTO;

public class Mapper {
    // Convertir JSON a ConferenceDTO
    public static ConferenceDTO jsonToConferenceDTO(String json) {
        ConferenceDTO conferenceDTO = new ConferenceDTO();
        
        // Extraer manualmente cada campo del JSON
        conferenceDTO.setId(getValueFromJson(json, "id"));
        conferenceDTO.setName(getValueFromJson(json, "name"));
        conferenceDTO.setPlace(getValueFromJson(json, "place"));
        conferenceDTO.setTopic(getValueFromJson(json, "topic"));
        conferenceDTO.setIdOrganizer(getValueFromJson(json, "idOrganizer"));
        conferenceDTO.setDescription(getValueFromJson(json, "description"));
        
        // Extraer fechas anidadas
        BasicDate startDate = new BasicDate(
            Integer.parseInt(getValueFromJson(json, "startDate.day")),
            Integer.parseInt(getValueFromJson(json, "startDate.month")),
            Integer.parseInt(getValueFromJson(json, "startDate.year"))
        );
        conferenceDTO.setStartDate(startDate);

        BasicDate finishDate = new BasicDate(
            Integer.parseInt(getValueFromJson(json, "finishDate.day")),
            Integer.parseInt(getValueFromJson(json, "finishDate.month")),
            Integer.parseInt(getValueFromJson(json, "finishDate.year"))
        );
        conferenceDTO.setFinishDate(finishDate);

        return conferenceDTO;
    }    
    
    public static ListConferencesDTO jsonToListConferencesDTO(String json) throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(json, ListConferencesDTO.class);
    }
    
    public static ListConferencesOrganizerDTO jsonToListConferencesOrganizerDTO(String json) throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(json, ListConferencesOrganizerDTO.class);
    }
    
    public static ListArticleConferencesDTO jsonToListArticleConferencesDTO(String json) throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(json, ListArticleConferencesDTO.class);
    }

    // Convertir ConferenceDTO a JSON
    public static String conferenceDTOToJson(ConferenceDTO conferenceDTO) {
    return """
    {
        "name": "%s",
        "startDate": {
            "day": %d,
            "month": %d,
            "year": %d
        },
        "finishDate": {
            "day": %d,
            "month": %d,
            "year": %d
        },
        "place": "%s",
        "topic": "%s",
        "idOrganizer": "%s",
        "description": "%s"
    }
    """.formatted(
        conferenceDTO.getName(),
        conferenceDTO.getStartDate().getDay(),
        conferenceDTO.getStartDate().getMonth(),
        conferenceDTO.getStartDate().getYear(),
        conferenceDTO.getFinishDate().getDay(),
        conferenceDTO.getFinishDate().getMonth(),
        conferenceDTO.getFinishDate().getYear(),
        conferenceDTO.getPlace(),
        conferenceDTO.getTopic(),
        conferenceDTO.getIdOrganizer(),
        conferenceDTO.getDescription()
    );
}


    // Convertir JSON a ArticleDTO
    public static ArticleDTO jsonToArticleDTO(String json) {
        ArticleDTO articleDTO = new ArticleDTO();
        
        // Extraer manualmente cada campo del JSON
        articleDTO.setId(getValueFromJson(json, "id"));
        articleDTO.setName(getValueFromJson(json, "name"));
        articleDTO.setIdAuthor(getValueFromJson(json, "idAuthor"));
        articleDTO.setKeyWords(getValueFromJson(json, "keyWords"));
        articleDTO.setIdConference(getValueFromJson(json, "idConference"));

        // Extraer fecha anidada
        BasicDate publishDate = new BasicDate(
            Integer.parseInt(getValueFromJson(json, "publishDate.day")),
            Integer.parseInt(getValueFromJson(json, "publishDate.month")),
            Integer.parseInt(getValueFromJson(json, "publishDate.year"))
        );
        articleDTO.setPublishDate(publishDate);

        return articleDTO;
    }

    // Convertir ArticleDTO a JSON
    public static String articleDTOToJson(ArticleDTO articleDTO) {
        return """
        {
            "id": "%s",
            "name": "%s",
            "idAuthor": "%s",
            "keyWords": "%s",
            "publishDate": {
                "day": %d,
                "month": %d,
                "year": %d
            },
            "idConference": "%s"
        }
        """.formatted(
            articleDTO.getId(),
            articleDTO.getName(),
            articleDTO.getIdAuthor(),
            articleDTO.getKeyWords(),
            articleDTO.getPublishDate().getDay(),
            articleDTO.getPublishDate().getMonth(),
            articleDTO.getPublishDate().getYear(),
            articleDTO.getIdConference()
        );
    }

    // Helper para extraer valores del JSON manualmente
    private static String getValueFromJson(String json, String key) {
        String[] parts = key.split("\\.");
        String currentJson = json;
        for (String part : parts) {
            int start = currentJson.indexOf("\"" + part + "\":");
            if (start == -1) {
                throw new RuntimeException("Key not found in JSON: " + key);
            }
            start += part.length() + 3; // Length of key + '":'
            int end;
            if (currentJson.charAt(start) == '{') {
                // Handle nested objects
                end = currentJson.indexOf("}", start) + 1;
            } else if (currentJson.charAt(start) == '"') {
                // Handle strings
                start += 1; // Skip opening quote
                end = currentJson.indexOf("\"", start);
            } else {
                // Handle numbers
                end = currentJson.indexOf(",", start);
                if (end == -1) {
                    end = currentJson.indexOf("}", start);
                }
            }
            currentJson = currentJson.substring(start, end).trim();
        }
        return currentJson.replace("\"", "");
    }

    public static ConferenceDTO conferenceToDTO(Conference conference) {
        return new ConferenceDTO(
                conference.getId(), // ID de la conferencia
                conference.getName(), // Nombre de la conferencia
                conference.getStartDate(), // Fecha de inicio
                conference.getFinishDate(), // Fecha de finalización
                conference.getPlace(), // Lugar
                conference.getTopic(), // Tema
                conference.getIdOrganizer(), // ID del organizador
                conference.getDescription() // Descripción
        );
    }

    public static Conference DTOToConference(ConferenceDTO dto) {
        return new Conference(
                dto.getId(), // ID de la conferencia
                dto.getName(), // Nombre de la conferencia
                dto.getStartDate(), // Fecha de inicio
                dto.getFinishDate(), // Fecha de finalización
                dto.getPlace(), // Lugar
                dto.getTopic(), // Tema
                dto.getIdOrganizer(), // ID del organizador
                dto.getDescription() // Descripción
        );
    }

    public static ArticleDTO articleToDTO(Article article) {
        return new ArticleDTO(
                article.getId(), // ID del artículo
                article.getName(), // Nombre del artículo
                article.getIdAuthor(), // ID del autor
                article.getKeyWords(), // Palabras clave
                article.getPublishDate(), // Fecha de publicación
                article.getIdConference() // ID de la conferencia
        );
    }

    public static Article DTOToArticle(ArticleDTO dto) {
        return new Article(
                dto.getId(), // ID del artículo
                dto.getName(), // Nombre del artículo
                dto.getIdAuthor(), // ID del autor
                dto.getKeyWords(), // Palabras clave
                dto.getPublishDate(), // Fecha de publicación
                dto.getIdConference() // ID de la conferencia
        );
    }

}
