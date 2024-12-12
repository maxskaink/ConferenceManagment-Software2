package co.edu.unicauca.Microservicio.de.evaluacion.broker.consumer;

import co.edu.unicauca.Microservicio.de.evaluacion.dao.IArticleRepository;
import co.edu.unicauca.Microservicio.de.evaluacion.domain.Article;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class MessageConsumer {

    private IArticleRepository articleRepository;

    @Autowired
    public MessageConsumer(IArticleRepository articleRepository) {
        this.articleRepository = articleRepository;
    }

    @RabbitListener(queues = "articleQueue")
    public void receiveMessage(Article obArticle) {
        obArticle.setEvaluadores( new ArrayList<>());
        System.out.println("Se ha recibido nuevo articulo por broker");

        articleRepository.save(obArticle);
    }
}
