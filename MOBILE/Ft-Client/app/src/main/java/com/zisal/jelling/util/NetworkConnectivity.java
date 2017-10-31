package com.zisal.jelling.util;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiManager;
import android.util.Log;

import com.zisal.jelling.ApplicationConstant;

/**
 * Created on 6/22/2015 : 9:34 AM.
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
public class NetworkConnectivity {

    private Context context;
    private ConnectivityManager connectivityManager;

    public NetworkConnectivity(Context context) {
        this.context = context;
        connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
    }

    /**
     * Check network connectivity whether device is connected or not
     * @return boolean
     * true if connected to network
     */
    public boolean isConnected(){
        boolean enabled = true;
        NetworkInfo info = connectivityManager.getActiveNetworkInfo();
        if ((info == null || !info.isConnected() || !info.isAvailable())){
            enabled = false;
        }
        return enabled;
    }

    /**
     * Check network connectivity whether device is connected on Mobile Data or Not
     * @return boolean connection info
     */
    public boolean isConnectedOnMobileData() {
        final android.net.NetworkInfo wifi = connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_WIFI);
        final android.net.NetworkInfo mobile = connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_MOBILE);
        boolean result;
        result = !wifi.isConnectedOrConnecting() && mobile.isConnectedOrConnecting();
        return result;
    }

    /**
     * Force user using mobile data for testing
     */
    public void forceUsingMobileData(){
        if(!isConnectedOnMobileData()){
            Log.d(ApplicationConstant.LogTag.MQA_INFO, "Device detected using WIFI, Forced using mobile data !");
            WifiManager wifiManager = (WifiManager) context.getSystemService(Context.WIFI_SERVICE);
            if(wifiManager.isWifiEnabled()){
                Log.d(ApplicationConstant.LogTag.MQA_INFO, "WIFI Manager is enabled, Turning off WIFI...");
                wifiManager.setWifiEnabled(false);
            }
        }
    }

}
