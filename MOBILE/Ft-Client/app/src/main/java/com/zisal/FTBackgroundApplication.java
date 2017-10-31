package com.zisal;

import android.app.Application;

import com.zisal.jelling.bgtesting.postprocess.DynamicTestConfig;
import com.zisal.jelling.persistence.dao.DAOHelper;
import com.zisal.jelling.persistence.model.ModelUser;
import com.zisal.jelling.persistence.tbmanager.TBManagerUser;
import id.co.telkomsigma.mforce.mqa.common.component.GeneralConstant;
import id.co.telkomsigma.mforce.mqa.common.component.util.property.impl.PropertyManager;

/**
 * Created on 6/9/2015 : 4:00 PM.
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>Achmad Fauzi</a>
 */
public class FTBackgroundApplication extends Application {

    private DAOHelper daoHelper;

    @Override
    public void onCreate() {
        super.onCreate();
        initBaseApplicationComponents();
        new DynamicTestConfig().generateDummyConfiguration(this);
    }

    private void initBaseApplicationComponents(){
        daoHelper = new DAOHelper(getApplicationContext());
        daoHelper.getWritableDatabase();

        try{
            TBManagerUser.init(this);
            if(TBManagerUser.getInstance().getAllData().get(0) == null){
                initializeDefaultUser();
            }
        }catch (Exception e){
            initializeDefaultUser();
        }


        PropertyManager propertyManager = new PropertyManager(
                GeneralConstant.ApplicationProperty.PROPERTY_FILE_NAME,
                getApplicationContext()
        );

        if(!propertyManager.isFileExist()){
            propertyManager.createIfNotExist();
        }
    }

    private void initializeDefaultUser(){
        ModelUser modelUser = new ModelUser();
        modelUser.setIsActive(GeneralConstant.BinaryValue.ZERO);
        modelUser.setLoginStatus(GeneralConstant.BinaryValue.ZERO);
        modelUser.setUserName("UNREGISTERED_USER");
        TBManagerUser.getInstance().insertEntity(modelUser);
    }


    @Override
    public void onTerminate() {
        super.onTerminate();
        if (daoHelper != null) {
            daoHelper.close();
        }
    }
}
