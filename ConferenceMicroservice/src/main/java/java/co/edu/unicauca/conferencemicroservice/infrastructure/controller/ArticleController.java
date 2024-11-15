package java.co.edu.unicauca.conferencemicroservice.infrastructure.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.co.edu.unicauca.conferencemicroservice.application.dto.ArticleDTO;
import java.co.edu.unicauca.conferencemicroservice.application.dto.ListArticleConferenceDTO;
import java.co.edu.unicauca.conferencemicroservice.application.port.in.IArticleService;
import java.co.edu.unicauca.conferencemicroservice.application.port.in.IConferenceService;
import java.co.edu.unicauca.conferencemicroservice.domain.model.Article;
import java.co.edu.unicauca.conferencemicroservice.domain.model.Conference;
import java.util.List;

@RestController
@RequestMapping("/api/articles")
public class ArticleController {
    private final IArticleService articleService;
    private final IConferenceService conferenceService;

    @Autowired
    public ArticleController(IArticleService articleService, IConferenceService conferenceService){
        this.articleService = articleService;
        this.conferenceService = conferenceService;
    }

    @PostMapping("/conference/{idConference}")
    public ResponseEntity<Article> createArticleInConference(
            @RequestBody ArticleDTO articleDTO,
            @PathVariable String idConference
    ){
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body( articleService.save(articleDTO) );
    }

    @GetMapping("/conferences/{idConference}")
    public ResponseEntity<ListArticleConferenceDTO> getListArticlesConferences(@PathVariable String idConference){
        ListArticleConferenceDTO response = new ListArticleConferenceDTO();
        return null;
    }
}
