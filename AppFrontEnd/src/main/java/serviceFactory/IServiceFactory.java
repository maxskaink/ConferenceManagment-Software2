/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package serviceFactory;

import services.ServiceAuth;
import services.ServiceArticle;
import services.ServiceConference;
import services.ServiceEvaluator;
/**
 *
 * @author isabe
 */
public interface IServiceFactory {
    public ServiceArticle getServiceArticle();
    public ServiceConference getServiceConference();
    public ServiceAuth getServiceAuth();
    public ServiceEvaluator getServiceEvaluator();
}
