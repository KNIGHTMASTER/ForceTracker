package com.zisal.jelling.rest.backgroundprocess.post;

import retrofit.RetrofitError;

/**
 * Created on 6/5/2015 : 2:15 PM.
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
public interface IPostUserTracking {

    void onPostSuccessUserTracking(Integer data);

    void onPostFailureUserTracking(RetrofitError error);
}
