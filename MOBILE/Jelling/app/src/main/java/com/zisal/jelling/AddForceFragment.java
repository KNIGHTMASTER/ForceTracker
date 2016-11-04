package com.zisal.jelling;

import android.app.Dialog;
import android.content.Context;
import android.widget.EditText;
import android.widget.Toast;

import com.tripoin.tripoin_component.ui.fragment.impl.ANavigationDrawerFragment;
import com.tripoin.tripoin_component.ui.handler.login.ALoginHandler;
import com.tripoin.tripoin_rest.bgp.impl.BGPUserTracking;
import com.tripoin.tripoin_rest.dto.request.DTOUserTracking;
import com.tripoin.tripoin_rest.post.IPostUserTracking;
import com.tripoin.tripoin_rest.util.TRIPOINHUDProgressDialog;

import butterknife.InjectView;
import butterknife.OnClick;
import retrofit.RetrofitError;


public class AddForceFragment extends ANavigationDrawerFragment implements IPostUserTracking{

    @InjectView(R.id.txtName)
    EditText txtName;

    @InjectView(R.id.txtImei)
    EditText txtImei;

    @Override
    public String getFragmentTitle() {
        return "Add Force";
    }

    @Override
    public void initWidget() {

    }

    @Override
    public int getViewLayoutId() {
        return R.layout.fragment_add_force;
    }

    @OnClick(R.id.btSaveForce)
    public void saveForce(){
        String name = txtName.getText().toString().trim();
        String imei = txtImei.getText().toString();
        if (name != null){
            if (imei != null){
                final DTOUserTracking dtoUserTracking = new DTOUserTracking();
                dtoUserTracking.setImsi(imei);
                dtoUserTracking.setName(name);
                final TRIPOINHUDProgressDialog tripoinhudProgressDialog = TRIPOINHUDProgressDialog.show(
                        getContext(),
                        getContext().getResources().getString(com.tripoin.tripoin_component.R.string.login_pd_message),
                        false,
                        null);
                new BGPUserTracking() {

                    @Override
                    public Context getContext() {
                        return getActivity();
                    }

                    @Override
                    public DTOUserTracking dtoUserTracking() {
                        return dtoUserTracking;
                    }

                    @Override
                    public IPostUserTracking postUserTracking() {
                        return AddForceFragment.this;
                    }

                    @Override
                    public Dialog getProgressDialog() {
                        return tripoinhudProgressDialog;
                    }

                }.execute();
            }else{
                Toast.makeText(getActivity(), "Imei can not be empty", Toast.LENGTH_LONG).show();
            }
        }else{
            Toast.makeText(getActivity(), "Name can not be empty", Toast.LENGTH_LONG).show();
        }
    }

    @Override
    public void onPostSuccessUserTracking(Integer data) {
        Toast.makeText(getActivity(), "Success Add Force", Toast.LENGTH_LONG).show();
        txtImei.setText("");
        txtName.setText("");
    }

    @Override
    public void onPostFailureUserTracking(RetrofitError error) {
        Toast.makeText(getActivity(), "Failed to Add Force", Toast.LENGTH_LONG).show();
    }
}
