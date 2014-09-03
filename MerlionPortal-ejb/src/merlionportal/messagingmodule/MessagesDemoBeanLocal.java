package merlionportal.messagingmodule;

import javax.ejb.Local;

@Local
public interface MessagesDemoBeanLocal {
    public String createMessage(String title, String re, String content);
}
