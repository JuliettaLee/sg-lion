
package merlionportal.messagingmodule;

import entity.Messagedemo;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class MessagesDemoBean implements MessagesDemoBeanLocal {

    @PersistenceContext
    EntityManager em;
    
    @Override
    public String createMessage(String title, String re, String content) {
        String result = "";
        Messagedemo messageDemo = new Messagedemo();
        messageDemo.setTitle(title);
        messageDemo.setReceipent(re);
        messageDemo.setContent(content);
        
        em.persist(messageDemo);
        result = "Success!";
        
        return result;
    }
}
