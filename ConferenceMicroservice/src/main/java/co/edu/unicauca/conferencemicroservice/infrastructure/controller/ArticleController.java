package co.edu.unicauca.conferencemicroservice.infrastructure.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import co.edu.unicauca.conferencemicroservice.application.dto.ArticleDTO;
import co.edu.unicauca.conferencemicroservice.application.dto.ListArticleAuthorDTO;
import co.edu.unicauca.conferencemicroservice.application.dto.ListArticleConferenceDTO;
import co.edu.unicauca.conferencemicroservice.application.mapper.MapperArticle;
import co.edu.unicauca.conferencemicroservice.application.mapper.MapperConference;
import co.edu.unicauca.conferencemicroservice.application.port.in.IArticleService;
import co.edu.unicauca.conferencemicroservice.application.port.in.IConferenceService;
import co.edu.unicauca.conferencemicroservice.domain.model.Article;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/articles")
public class ArticleController {
    private final IArticleService articleService;
    private final IConferenceService conferenceService;

    @Autowired
    public ArticleController(
            IArticleService articleService,
            IConferenceService conferenceService
    ){
        this.articleService = articleService;
        this.conferenceService = conferenceService;
    }

    @PostMapping("/conferences/{idConference}")
    public ResponseEntity<ArticleDTO> createArticleInConference(
            @RequestBody ArticleDTO articleDTO,
            @PathVariable String idConference
    ){
        // Assuming who try to it is an author
        articleDTO.setIdConference(idConference);
        Article articleCreated = articleService.save(articleDTO);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body( MapperArticle.toArticleDTO(articleCreated) );
    }

    @GetMapping("/conferences/{idConference}")
    public ResponseEntity<ListArticleConferenceDTO> getListArticlesConferences(@PathVariable String idConference){
        ListArticleConferenceDTO response = new ListArticleConferenceDTO();

        response.setConference(
                MapperConference.toConferenceDTO( conferenceService.findConferenceById(idConference) )
        );

        List<Article> articles = articleService.findArticleByConference(idConference);
        List<ArticleDTO> articlesDTO = new ArrayList<>();

        for(Article article: articles)
            articlesDTO.add(MapperArticle.toArticleDTO(article));

        response.setArticles( articlesDTO );
        response.setCantArticles(articlesDTO.size());

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(response);
    }

    @GetMapping("/author/{idAuthor}")
    public ResponseEntity<ListArticleAuthorDTO> getListArticleByAuthor(@PathVariable String idAuthor){
        ListArticleAuthorDTO response = new ListArticleAuthorDTO();

        response.setAuthor( idAuthor );

        List<Article> articles = articleService.findArticleByAuthor(idAuthor);
        List<ArticleDTO> articlesDTO = new ArrayList<>();

        for(Article article: articles)
            articlesDTO.add(MapperArticle.toArticleDTO(article));

        response.setArticles(articlesDTO);
        response.setTotalArticles(articlesDTO.size());

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(response);

    }

    @PutMapping("/{idArticle}")
    public ResponseEntity<ArticleDTO> updateArticle(
            @RequestBody ArticleDTO article,
            @PathVariable String idArticle
    ){
        //Assuming the user is an author
        ArticleDTO articleUpdated = MapperArticle.toArticleDTO(
                articleService.update(idArticle, article)
        );
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(articleUpdated);
    }

    @DeleteMapping("/{idArticle}")
    public ResponseEntity<ArticleDTO> deleteArticle(@PathVariable String idArticle){
        ArticleDTO articleDeleted = MapperArticle.toArticleDTO(
                articleService.delete(idArticle)
        );
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(articleDeleted);
    }

}
