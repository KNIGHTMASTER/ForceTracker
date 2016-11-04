package com.zisal.jelling.rest.backgroundprocess.callback;

import com.zisal.jelling.rest.backgroundprocess.post.IPostUserTracking;
import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

/**
 * Created on 6/1/2015 : 1:14 PM.
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
public class CallBackUserTracking implements Callback<Integer> {

    private IPostUserTracking iPostUserTracking;

    public CallBackUserTracking(IPostUserTracking iPostUserTracking) {
        this.iPostUserTracking = iPostUserTracking;
    }


    @Override
    public void success(Integer integer, Response response) {
        iPostUserTracking.onPostSuccessUserTracking(integer);
    }

    @Override
    public void failure(RetrofitError error) {
        iPostUserTracking.onPostFailureUserTracking(error);
    }
}
