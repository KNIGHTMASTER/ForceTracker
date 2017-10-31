package com.zisal.jelling;

import android.content.Context;

import com.tripoin.tripoin_component.app.base.ATRIPOINApplication;

/**
 * Created on 11/29/2015 : 7:03 PM.
 *
 * @author <a href="fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
public class JellingApplication extends ATRIPOINApplication {
    @Override
    public Context getContext() {
        return JellingApplication.this;
    }
}
