package com.zisal.jelling.util.sms;

/**
 * Created on 2/25/2016 : 10:55 AM.
 *
 * @author <a href="fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
public interface ISMSEngine {

    void send(String targetNumber, String content);

}
