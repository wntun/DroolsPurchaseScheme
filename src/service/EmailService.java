/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;


import dataModel.PotentialCustomer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author wainwetun
 */
public class EmailService {
    private Logger logger = LoggerFactory.getLogger(EmailService.class);
    private static EmailService instance = new EmailService();
    
    private EmailService()
    {
    }
    
    public static EmailService getInstance(){
        return instance;
    }
    
    public void sendCreditCardOffer(PotentialCustomer pc){
        logger.info("****..Sending Credit Card Offer..****");
        logger.info("**** To: " + pc.getCustomerName() );
        logger.info("**** Credit limit: " + pc.getCreditLimit());
        logger.info("**** ..email sent..****");
    }
}
