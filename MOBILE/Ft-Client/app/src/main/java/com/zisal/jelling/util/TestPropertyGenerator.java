package com.zisal.jelling.util;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.zisal.jelling.ApplicationConstant;
import com.zisal.jelling.persistence.model.ModelDynamicTestConfiguration;
import com.zisal.jelling.persistence.model.impl.ModelPhoneNetwork;
import com.zisal.jelling.persistence.tbmanager.TBManagerPhoneNetwork;
import com.zisal.jelling.persistence.tbmanager.TBManagerTestConfiguration;
import com.zisal.jelling.rest.dto.request.impl.usertracking.DTOUserTracking;

import java.util.Date;

import id.co.telkomsigma.arium.mforce.mqa.component.phonenetwork.dto.DTOPhoneNetwork;
import id.co.telkomsigma.arium.mforce.mqa.component.phonenetwork.listener.MQAPhoneStateListener;
import id.co.telkomsigma.arium.mforce.mqa.component.phonenetwork.phonenetwork.BatchPhoneNetwork;
import id.co.telkomsigma.arium.mforce.mqa.component.phonenetwork.phonenetwork.BatchPhoneNetworkParam;
import id.co.telkomsigma.arium.mforce.mqa.component.phonenetwork.phonenetwork.PhoneNetwork;
import id.co.telkomsigma.arium.mforce.mqa.component.phonenetwork.phonenetwork.PhoneNetworkParam;
import id.co.telkomsigma.mforce.mqa.common.component.GeneralConverter;

/**
 * Created on 6/22/2015 : 3:15 PM.
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
public class TestPropertyGenerator {

    private GeneralConverter generalConverter = new GeneralConverter();

    public String generateTestId(Date date, String deviceId){
        String result;
        GeneralConverter generalConverter = new GeneralConverter();
        if( date == null ){
            result = deviceId.concat( generalConverter.getDateToFormatTestId(new Date()) );
        }else{
            result = deviceId.concat(generalConverter.getDateToFormatTestId(date));
        }
        return result;
    }

    public DTOPhoneNetwork provideDTOPhoneNetwork(Context context, MQAPhoneStateListener mqaPhoneStateListener){
        PhoneNetworkParam phoneNetworkParam = new PhoneNetworkParam();
        phoneNetworkParam.setContext(context);

        PhoneNetwork phoneNetwork = new PhoneNetwork();
        phoneNetwork.setParameter(phoneNetworkParam);

        BatchPhoneNetworkParam batchPhoneNetworkParam = new BatchPhoneNetworkParam();
        batchPhoneNetworkParam.setMqaPhoneStateListener(mqaPhoneStateListener);
        batchPhoneNetworkParam.setPhoneNetwork(phoneNetwork);

        BatchPhoneNetwork batchPhoneNetwork = new BatchPhoneNetwork();
        batchPhoneNetwork.setParameter(batchPhoneNetworkParam);

        batchPhoneNetwork.process();
        DTOPhoneNetwork dtoPhoneNetwork = batchPhoneNetwork.getTestResult();

        Log.d("PHONE NETWORK", dtoPhoneNetwork.toString());
        return dtoPhoneNetwork;
    }

    public BatchPhoneNetwork provideBatchPhoneNetwork(Context context){
        PhoneNetworkParam phoneNetworkParam = new PhoneNetworkParam();
        phoneNetworkParam.setContext(context);

        PhoneNetwork phoneNetwork = new PhoneNetwork();
        phoneNetwork.setParameter(phoneNetworkParam);

        BatchPhoneNetworkParam batchPhoneNetworkParam = new BatchPhoneNetworkParam();
        batchPhoneNetworkParam.setMqaPhoneStateListener(new MQAPhoneStateListener());
        batchPhoneNetworkParam.setPhoneNetwork(phoneNetwork);

        BatchPhoneNetwork batchPhoneNetwork = new BatchPhoneNetwork();
        batchPhoneNetwork.setParameter(batchPhoneNetworkParam);
        return batchPhoneNetwork;
    }

    public void mergeModelPhoneNetwork(DTOPhoneNetwork dtoPhoneNetwork, Context context){
        ModelPhoneNetwork modelPhoneNetwork = new ModelPhoneNetwork();
        modelPhoneNetwork.setLatitude(dtoPhoneNetwork.getLatitude());
        modelPhoneNetwork.setLongitude(dtoPhoneNetwork.getLongitude());
        modelPhoneNetwork.setAccuracy(dtoPhoneNetwork.getAccuracy());
        modelPhoneNetwork.setDeviceId(dtoPhoneNetwork.getDeviceId());
        modelPhoneNetwork.setSubscriberId(dtoPhoneNetwork.getSubscriberId());
        modelPhoneNetwork.setPhoneType(dtoPhoneNetwork.getPhoneType());
        modelPhoneNetwork.setSoftwareVersion(dtoPhoneNetwork.getSoftwareVersion());
        modelPhoneNetwork.setSimOperatorName(dtoPhoneNetwork.getSimOperatorName());
        modelPhoneNetwork.setSimSerial(dtoPhoneNetwork.getSimSerial());
        modelPhoneNetwork.setMcc(dtoPhoneNetwork.getMcc());
        modelPhoneNetwork.setMnc(dtoPhoneNetwork.getMnc());
        modelPhoneNetwork.setLineNumber(dtoPhoneNetwork.getLineNumber());
        modelPhoneNetwork.setLocality(dtoPhoneNetwork.getLocality());
        modelPhoneNetwork.setBatteryLevel(dtoPhoneNetwork.getBatteryLevel());
        modelPhoneNetwork.setAddress(dtoPhoneNetwork.getAddress());
        modelPhoneNetwork.setRxLevel(dtoPhoneNetwork.getRxLevel());
        modelPhoneNetwork.setRxQuality(dtoPhoneNetwork.getRxQuality());
        modelPhoneNetwork.setNetworkType(dtoPhoneNetwork.getNetworkType());
        modelPhoneNetwork.setLac(dtoPhoneNetwork.getLac());
        modelPhoneNetwork.setCellId(dtoPhoneNetwork.getCellId());
        modelPhoneNetwork.setConnectionStatus(dtoPhoneNetwork.getConnectionStatus());
        modelPhoneNetwork.setServiceState(dtoPhoneNetwork.getServiceState());
        modelPhoneNetwork.setIpAddress(dtoPhoneNetwork.getIpAddress());
        modelPhoneNetwork.setWifiName(dtoPhoneNetwork.getWifiName());
        modelPhoneNetwork.setApnName(dtoPhoneNetwork.getApnName());
        ModelPhoneNetwork prevModel;
        TBManagerPhoneNetwork.init(context);
        try{
            prevModel = TBManagerPhoneNetwork.getInstance().getAllData().get(0);
            TBManagerPhoneNetwork.getInstance().updateEntity(prevModel);
        }catch (Exception e){
            TBManagerPhoneNetwork.getInstance().insertEntity(modelPhoneNetwork);
        }
    }

    public DTOPhoneNetwork getLatestDTOPhoneNetwork(){
        DTOPhoneNetwork dtoPhoneNetwork = new DTOPhoneNetwork();
        try {
            Log.e(ApplicationConstant.LogTag.MQA_INFO, "retrieve latest phone network");
            ModelPhoneNetwork modelPhoneNetwork = TBManagerPhoneNetwork.getInstance().getAllData().get(0);
            dtoPhoneNetwork.setLatitude(modelPhoneNetwork.getLatitude());
            dtoPhoneNetwork.setLongitude(modelPhoneNetwork.getLongitude());
            dtoPhoneNetwork.setAccuracy((float) modelPhoneNetwork.getAccuracy());
            dtoPhoneNetwork.setDeviceId(modelPhoneNetwork.getDeviceId());
            dtoPhoneNetwork.setSubscriberId(modelPhoneNetwork.getSubscriberId());
            dtoPhoneNetwork.setPhoneType(modelPhoneNetwork.getPhoneType());
            dtoPhoneNetwork.setSoftwareVersion(modelPhoneNetwork.getSoftwareVersion());
            dtoPhoneNetwork.setSimOperatorName(modelPhoneNetwork.getSimOperatorName());
            dtoPhoneNetwork.setSimSerial(modelPhoneNetwork.getSimSerial());
            dtoPhoneNetwork.setMcc(modelPhoneNetwork.getMcc());
            dtoPhoneNetwork.setMnc(modelPhoneNetwork.getMnc());
            dtoPhoneNetwork.setLineNumber(modelPhoneNetwork.getLineNumber());
            dtoPhoneNetwork.setLocality(modelPhoneNetwork.getLocality());
            dtoPhoneNetwork.setBatteryLevel(modelPhoneNetwork.getBatteryLevel());
            dtoPhoneNetwork.setAddress(modelPhoneNetwork.getAddress());
            dtoPhoneNetwork.setRxLevel(modelPhoneNetwork.getRxLevel());
            dtoPhoneNetwork.setRxQuality(modelPhoneNetwork.getRxQuality());
            dtoPhoneNetwork.setNetworkType(modelPhoneNetwork.getNetworkType());
            dtoPhoneNetwork.setLac(modelPhoneNetwork.getLac());
            dtoPhoneNetwork.setCellId(modelPhoneNetwork.getCellId());
            dtoPhoneNetwork.setConnectionStatus(modelPhoneNetwork.getConnectionStatus());
            dtoPhoneNetwork.setServiceState(modelPhoneNetwork.getServiceState());
            dtoPhoneNetwork.setIpAddress(modelPhoneNetwork.getIpAddress());
            dtoPhoneNetwork.setWifiName(modelPhoneNetwork.getWifiName());
            dtoPhoneNetwork.setApnName(modelPhoneNetwork.getApnName());
            Log.e(ApplicationConstant.LogTag.MQA_INFO, "retrieve latest phone network success");
        }catch (Exception e){
            e.printStackTrace();
        }
        return dtoPhoneNetwork;
    }

    public DTOUserTracking generateDTOUserTracking(DTOPhoneNetwork dtoPhoneNetwork){
        DTOUserTracking dtoUserTracking = new DTOUserTracking();
        dtoUserTracking.setLatitude(String.valueOf(dtoPhoneNetwork.getLatitude()));
        dtoUserTracking.setLongitude(String.valueOf(dtoPhoneNetwork.getLongitude()));
        dtoUserTracking.setImei(dtoPhoneNetwork.getSimSerial());
        dtoUserTracking.setImsi(dtoPhoneNetwork.getDeviceId());
        try{
            dtoUserTracking.setAddress(dtoPhoneNetwork.getLocality().concat(" ").concat(dtoPhoneNetwork.getAddress()));
        }catch (Exception e){
            e.printStackTrace();
        }
        return dtoUserTracking;
    }

    private String getStoredPhoneNumber(){
        ModelDynamicTestConfiguration modelDynamicTestConfiguration;
        try{
            modelDynamicTestConfiguration = TBManagerTestConfiguration.getInstance().getAllData().get(0);
            Log.d(ApplicationConstant.LogTag.MQA_INFO, "Stored Phone Number : ".concat(modelDynamicTestConfiguration.getPhoneNumber()));
            return modelDynamicTestConfiguration.getPhoneNumber();
        }catch (Exception e){
            Log.d(ApplicationConstant.LogTag.MQA_ERROR, "can not select ModelDynamicTestConfiguration : ".concat(e.getMessage()));
            return "";
        }
    }

}
