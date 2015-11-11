/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package droolspurchasescheme;

import dataModel.PaymentMethods;
import dataModel.Purchase;
import org.drools.io.ResourceFactory;
import org.kie.api.KieBase;
import org.kie.api.KieBaseConfiguration;
import org.kie.api.KieServices;
import org.kie.api.builder.KieBuilder;
import org.kie.api.builder.KieFileSystem;
import org.kie.api.builder.ReleaseId;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.kie.api.runtime.KieSessionConfiguration;
import org.kie.internal.utils.KieService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author wainwetun
 */
public class DroolsPurchaseScheme {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        KieServices ks = KieServices.Factory.get(); // in-memory file system
        KieContainer kcontainer = createKContainer(ks, "discountRules.drl","potentialCustomer1.drl");
        
        KieBaseConfiguration kbConfiguration = ks.newKieBaseConfiguration();
        KieBase kBase = kcontainer.getKieBase(); // Knowledge Base
        
        KieSessionConfiguration ksConfiguration = ks.newKieSessionConfiguration();
        KieSession session = kBase.newKieSession(ksConfiguration,null);
        
        Logger logger = LoggerFactory.getLogger(DroolsPurchaseScheme.class);
        session.setGlobal("logger", logger);
        
        Purchase cashPurchaseLow = new Purchase("john", 250, PaymentMethods.CASH);
        
        session.insert(cashPurchaseLow);
        logger.info("**************firing all rules********************");
        session.fireAllRules();
        
        
        
    }
    
    public static KieContainer createKContainer(KieServices ks, String... drlResourcePaths){
        KieFileSystem kfs = ks.newKieFileSystem();
        for(String path: drlResourcePaths){
            kfs.write(ResourceFactory.newClassPathResource(path, DroolsPurchaseScheme.class));
        }
        KieBuilder kb =  ks.newKieBuilder(kfs);
        kb.buildAll();
        
        ReleaseId rId = kb.getKieModule().getReleaseId();
        return ks.newKieContainer(rId);
    }
    
}
