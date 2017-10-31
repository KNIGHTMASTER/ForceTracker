package com.zisal.jelling.rest.backgroundprocess.bgp;

import android.os.AsyncTask;

import com.zisal.jelling.rest.backgroundprocess.callback.CallBackUserTracking;
import com.zisal.jelling.rest.backgroundprocess.post.IPostUserTracking;
import com.zisal.jelling.rest.dto.request.impl.usertracking.DTOUserTracking;
import com.zisal.jelling.rest.endpoints.EPUserTracking;
import com.zisal.jelling.rest.engine.RestGenerator;

/**
 * Created on 6/1/2015 : 2:12 PM.
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
public abstract class BGPUserTracking extends AsyncTask {
    @Override
    protected Object doInBackground(Object[] params) {
        EPUserTracking epUserTracking = RestGenerator.createService(EPUserTracking.class);
        epUserTracking.trackUser(dtoUserTracking(), new CallBackUserTracking(postUserTracking()));
        return null;
    }

    public abstract DTOUserTracking dtoUserTracking();

    public abstract IPostUserTracking postUserTracking();
}
