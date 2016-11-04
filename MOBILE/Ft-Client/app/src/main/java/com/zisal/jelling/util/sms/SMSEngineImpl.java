package com.zisal.jelling.util.sms;

import android.telephony.SmsManager;

/**
 * Created on 2/25/2016 : 10:56 AM.
 *
 * @author <a href="fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
public class SMSEngineImpl implements ISMSEngine {

    @Override
    public void send(String targetNumber, String content) {
        SmsManager sms = SmsManager.getDefault();
        sms.sendTextMessage(targetNumber, null, content, null, null);
    }

}
