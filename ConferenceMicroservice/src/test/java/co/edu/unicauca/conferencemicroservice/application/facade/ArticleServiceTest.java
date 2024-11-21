package co.edu.unicauca.conferencemicroservice.application.facade;

import co.edu.unicauca.conferencemicroservice.infrastructure.dto.ArticleDTO;
import co.edu.unicauca.conferencemicroservice.application.port.out.IArticleRepository;
import co.edu.unicauca.conferencemicroservice.application.port.out.IConferenceRepository;
import co.edu.unicauca.conferencemicroservice.application.port.out.IEventsHandler;
import co.edu.unicauca.conferencemicroservice.domain.useCase.ArticleService;
import co.edu.unicauca.conferencemicroservice.domain.exception.InvalidValue;
import co.edu.unicauca.conferencemicroservice.domain.model.Article;
import co.edu.unicauca.conferencemicroservice.domain.model.valueObjects.BasicDate;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class ArticleServiceTest {
    @Mock
    private IArticleRepository articleRepository;

    @Mock
    private IConferenceRepository conferenceRepository;

    @Mock
    private IEventsHandler eventsHandler;

    @InjectMocks
    private ArticleService articleService;

    private Article article;
    private ArticleDTO articleDTO;

    @BeforeEach
    void setUp() {
        article = new Article("1", "Test Title", "1", "Author1", "11", new BasicDate(16,8,2004));
        articleDTO = new ArticleDTO("1", "Test Title", "1", "Authro1", new BasicDate(16,8,2004),"11");
    }

    @Test
    void save_ShouldThrowInvalidValueException_WhenArticleDTOIsNull() {
        // Act & Assert
        assertThrows(InvalidValue.class, () -> articleService.save(null));
    }

    @Test
    void findArticleByConference_ShouldThrowInvalidValueException_WhenIdIsNull() {
        // Act & Assert
        assertThrows(InvalidValue.class, () -> articleService.findArticleByConference(null));
    }
}