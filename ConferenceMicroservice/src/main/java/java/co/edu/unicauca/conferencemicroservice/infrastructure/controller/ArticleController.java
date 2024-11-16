package java.co.edu.unicauca.conferencemicroservice.infrastructure.controller;

import org.apache.catalina.mapper.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.co.edu.unicauca.conferencemicroservice.application.dto.ArticleDTO;
import java.co.edu.unicauca.conferencemicroservice.application.dto.ListArticleAuthorDTO;
import java.co.edu.unicauca.conferencemicroservice.application.dto.ListArticleConferenceDTO;
import java.co.edu.unicauca.conferencemicroservice.application.mapper.MapperArticle;
import java.co.edu.unicauca.conferencemicroservice.application.mapper.MapperConference;
import java.co.edu.unicauca.conferencemicroservice.application.port.in.IArticleService;
import java.co.edu.unicauca.conferencemicroservice.application.port.in.IAuthorService;
import java.co.edu.unicauca.conferencemicroservice.application.port.in.IConferenceService;
import java.co.edu.unicauca.conferencemicroservice.domain.model.Article;
import java.co.edu.unicauca.conferencemicroservice.domain.model.Conference;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/articles")
public class ArticleController {
    private final IArticleService articleService;
    private final IConferenceService conferenceService;
    private final IAuthorService authorService;

    @Autowired
    public ArticleController(IArticleService articleService, IConferenceService conferenceService, IAuthorService authorService){
        this.articleService = articleService;
        this.conferenceService = conferenceService;
        this.authorService = authorService;
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

        response.setConferenceOutDTO(
                MapperConference.toConferenceDTO( conferenceService.findConferenceById(idConference) )
        );

        List<Article> articles = articleService.findArticleByConference(idConference);
        List<ArticleDTO> articlesDTO = new ArrayList<>();

        for(Article article: articles)
            articlesDTO.add(MapperArticle.toArticleDTO(article));

        response.setArticles( articlesDTO );
        response.setCantArticles(articlesDTO.size());

        return ResponseEntity
                .status(HttpStatus.ACCEPTED)
                .body(response);
    }

    @GetMapping("/author/{idAuthor}")
    public ResponseEntity<ListArticleAuthorDTO> getListArticleByAuthor(@PathVariable String idAuthor){
        ListArticleAuthorDTO response = new ListArticleAuthorDTO();

        response.setAuthor(
            authorService.findById(idAuthor).getName()
        );

        List<Article> articles = articleService.findArticleByAuthor(idAuthor);
        List<ArticleDTO> articlesDTO = new ArrayList<>();

        for(Article article: articles)
            articlesDTO.add(MapperArticle.toArticleDTO(article));

        response.setArticles(articlesDTO);
        response.setTotalArticles(articlesDTO.size());

        return ResponseEntity
                .status(HttpStatus.ACCEPTED)
                .body(response);

    }

    @PutMapping("/{idArticle}")
    public ResponseEntity<ArticleDTO> updateArticle(
            @RequestBody ArticleDTO article,
            @PathVariable String idArticle
    ){
        ArticleDTO articleUpdated = MapperArticle.toArticleDTO(
                articleService.update(idArticle, article)
        );
        return ResponseEntity
                .status(HttpStatus.ACCEPTED)
                .body(articleUpdated);
    }

    @DeleteMapping("/{idArticle}")
    public ResponseEntity<ArticleDTO> deleteArticle(@PathVariable String idArticle){
        ArticleDTO articleDeleted = MapperArticle.toArticleDTO(
                articleService.delete(idArticle)
        );
        return ResponseEntity
                .status(HttpStatus.ACCEPTED)
                .body(articleDeleted);
    }

}
