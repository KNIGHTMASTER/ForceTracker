package com.zisal.jelling;

import android.app.Dialog;
import android.content.Context;
import android.widget.ListView;
import android.widget.Toast;

import com.tripoin.tripoin_component.ui.fragment.impl.ANavigationDrawerFragment;
import com.tripoin.tripoin_rest.bgp.impl.BGPLocation;
import com.tripoin.tripoin_rest.dto.response.location.DTOResponseLocation;
import com.tripoin.tripoin_rest.post.IGenericPost;

import java.util.List;

import butterknife.InjectView;
import retrofit.RetrofitError;

public class ManageForceFragment extends ANavigationDrawerFragment implements IGenericPost<List<DTOResponseLocation>> {

    @InjectView(R.id.lvTracker)
    ListView listView;

    @Override
    public String getFragmentTitle() {
        return "Manage Force";
    }

    @Override
    public void initWidget() {
        new BGPLocation(ManageForceFragment.this) {
            @Override
            public Context getContext() {
                return getActivity();
            }

            @Override
            public Dialog getProgressDialog() {
                return new Dialog(getActivity());
            }
        }.execute();
    }

    @Override
    public int getViewLayoutId() {
        return R.layout.fragment_manage_force;
    }


    @Override
    public void onPostSuccess(List<DTOResponseLocation> dtoResponseLocations) {
        ForceAdapter forceAdapter = new ForceAdapter(getActivity(), dtoResponseLocations);
        listView.setAdapter(forceAdapter);
    }

    @Override
    public void onPostFailure(RetrofitError retrofitError) {
        Toast.makeText(getActivity(), "Failed to display list of Forces",Toast.LENGTH_SHORT).show();
    }
}
