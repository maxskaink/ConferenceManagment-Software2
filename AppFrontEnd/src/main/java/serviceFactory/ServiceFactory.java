/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */package serviceFactory;

import services.ServiceArticle;
import services.ServiceAuth;
import services.ServiceConference;
import services.ServiceEvaluator;

public class ServiceFactory implements IServiceFactory {
    private static ServiceFactory instance;

    private final ServiceConference conferenceService;
    private final ServiceArticle articleService;
    private final ServiceAuth authService;
    private final ServiceEvaluator evaluatorService;

    // Constructor privado para implementar Singleton
    private ServiceFactory() {
        this.conferenceService = new ServiceConference();
        this.articleService = new ServiceArticle();
        this.authService = new ServiceAuth();
        this.evaluatorService = new ServiceEvaluator();
    }

    // Método para obtener la instancia única de ServiceFactory
    public static ServiceFactory getInstance() {
        if (instance == null) {
            synchronized (ServiceFactory.class) {
                if (instance == null) {
                    instance = new ServiceFactory();
                }
            }
        }
        return instance;
    }
    @Override
    public ServiceArticle getServiceArticle() {
        return this.articleService;
    }

    @Override
    public ServiceConference getServiceConference() {
        return this.conferenceService;
    }

    @Override
    public ServiceAuth getServiceAuth() {
        return this.authService;
    }
    
    @Override
    public ServiceEvaluator getServiceEvaluator() {
        return this.evaluatorService;
    }
}

