package com.zisal.jelling.persistence.model.impl;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import com.zisal.jelling.ApplicationConstant;


/**
 * Created on 5/27/2015 : 1:38 PM.
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
@DatabaseTable(tableName = ApplicationConstant.Database.TablePhoneNetwork.TABLE_NAME)
public class ModelPhoneNetwork {

    @DatabaseField(generatedId = true, canBeNull = false, columnName = ApplicationConstant.Database.ID )
    private int id;

    @DatabaseField(columnName = ApplicationConstant.Database.TablePhoneNetwork.LATITUDE )
    private double latitude;

    @DatabaseField(columnName = ApplicationConstant.Database.TablePhoneNetwork.LONGITUDE)
    private double longitude;

    @DatabaseField(columnName = ApplicationConstant.Database.TablePhoneNetwork.ACCURACY)
    private double accuracy;

    @DatabaseField(columnName = ApplicationConstant.Database.TablePhoneNetwork.DEVICE_ID)
    private String deviceId;

    @DatabaseField(columnName = ApplicationConstant.Database.TablePhoneNetwork.SUBSCRIBER_ID)
    private String subscriberId;

    @DatabaseField(columnName = ApplicationConstant.Database.TablePhoneNetwork.PHONE_TYPE)
    private String phoneType;

    @DatabaseField(columnName = ApplicationConstant.Database.TablePhoneNetwork.SOFTWARE_VERSION)
    private String softwareVersion;

    @DatabaseField(columnName = ApplicationConstant.Database.TablePhoneNetwork.SIM_OPERATOR_NAME)
    private String simOperatorName;

    @DatabaseField(columnName = ApplicationConstant.Database.TablePhoneNetwork.SIM_SERIAL)
    private String simSerial;

    @DatabaseField(columnName = ApplicationConstant.Database.TablePhoneNetwork.MCC)
    private String mcc;

    @DatabaseField(columnName = ApplicationConstant.Database.TablePhoneNetwork.MNC)
    private String mnc;

    @DatabaseField(columnName = ApplicationConstant.Database.TablePhoneNetwork.LINE_NUMBER)
    private String lineNumber;

    @DatabaseField(columnName = ApplicationConstant.Database.TablePhoneNetwork.LOCALITY)
    private String locality;

    @DatabaseField(columnName = ApplicationConstant.Database.TablePhoneNetwork.BATTERY_LEVEL)
    private float batteryLevel;

    @DatabaseField(columnName = ApplicationConstant.Database.TablePhoneNetwork.ADDRESS)
    private String address;

    @DatabaseField(columnName = ApplicationConstant.Database.TablePhoneNetwork.RX_LEVEL)
    private double rxLevel;

    @DatabaseField(columnName = ApplicationConstant.Database.TablePhoneNetwork.RX_QUALITY)
    private int rxQuality;

    @DatabaseField(columnName = ApplicationConstant.Database.TablePhoneNetwork.BER)
    private double ber;

    @DatabaseField(columnName = ApplicationConstant.Database.TablePhoneNetwork.NETWORK_TYPE)
    private String networkType;

    @DatabaseField(columnName = ApplicationConstant.Database.TablePhoneNetwork.LAC)
    private int lac;

    @DatabaseField(columnName = ApplicationConstant.Database.TablePhoneNetwork.CELL_ID)
    private int cellId;

    @DatabaseField(columnName = ApplicationConstant.Database.TablePhoneNetwork.CONNECTION_STATUS)
    private String connectionStatus;

    @DatabaseField(columnName = ApplicationConstant.Database.TablePhoneNetwork.SERVICE_STATE)
    private String serviceState;

    @DatabaseField(columnName = ApplicationConstant.Database.TablePhoneNetwork.IP_ADDRESS)
    private String ipAddress;

    @DatabaseField(columnName = ApplicationConstant.Database.TablePhoneNetwork.WIFI_NAME)
    private String wifiName;

    @DatabaseField(columnName = ApplicationConstant.Database.TablePhoneNetwork.APN_NAME)
    private String apnName;

    @DatabaseField(columnName = ApplicationConstant.Database.RECORD_DATE_TIME)
    private String recordDateTime;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public double getAccuracy() {
        return accuracy;
    }

    public void setAccuracy(double accuracy) {
        this.accuracy = accuracy;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public String getSubscriberId() {
        return subscriberId;
    }

    public void setSubscriberId(String subscriberId) {
        this.subscriberId = subscriberId;
    }

    public String getPhoneType() {
        return phoneType;
    }

    public void setPhoneType(String phoneType) {
        this.phoneType = phoneType;
    }

    public String getSoftwareVersion() {
        return softwareVersion;
    }

    public void setSoftwareVersion(String softwareVersion) {
        this.softwareVersion = softwareVersion;
    }

    public String getSimOperatorName() {
        return simOperatorName;
    }

    public void setSimOperatorName(String simOperatorName) {
        this.simOperatorName = simOperatorName;
    }

    public String getSimSerial() {
        return simSerial;
    }

    public void setSimSerial(String simSerial) {
        this.simSerial = simSerial;
    }

    public String getMcc() {
        return mcc;
    }

    public void setMcc(String mcc) {
        this.mcc = mcc;
    }

    public String getMnc() {
        return mnc;
    }

    public void setMnc(String mnc) {
        this.mnc = mnc;
    }

    public String getLineNumber() {
        return lineNumber;
    }

    public void setLineNumber(String lineNumber) {
        this.lineNumber = lineNumber;
    }

    public String getLocality() {
        return locality;
    }

    public void setLocality(String locality) {
        this.locality = locality;
    }

    public float getBatteryLevel() {
        return batteryLevel;
    }

    public void setBatteryLevel(float batteryLevel) {
        this.batteryLevel = batteryLevel;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public double getRxLevel() {
        return rxLevel;
    }

    public void setRxLevel(double rxLevel) {
        this.rxLevel = rxLevel;
    }

    public int getRxQuality() {
        return rxQuality;
    }

    public void setRxQuality(int rxQuality) {
        this.rxQuality = rxQuality;
    }

    public double getBer() {
        return ber;
    }

    public void setBer(double ber) {
        this.ber = ber;
    }

    public String getNetworkType() {
        return networkType;
    }

    public void setNetworkType(String networkType) {
        this.networkType = networkType;
    }

    public int getLac() {
        return lac;
    }

    public void setLac(int lac) {
        this.lac = lac;
    }

    public int getCellId() {
        return cellId;
    }

    public void setCellId(int cellId) {
        this.cellId = cellId;
    }

    public String getConnectionStatus() {
        return connectionStatus;
    }

    public void setConnectionStatus(String connectionStatus) {
        this.connectionStatus = connectionStatus;
    }

    public String getServiceState() {
        return serviceState;
    }

    public void setServiceState(String serviceState) {
        this.serviceState = serviceState;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    public String getWifiName() {
        return wifiName;
    }

    public void setWifiName(String wifiName) {
        this.wifiName = wifiName;
    }

    public String getApnName() {
        return apnName;
    }

    public void setApnName(String apnName) {
        this.apnName = apnName;
    }

    public String getRecordDateTime() {
        return recordDateTime;
    }

    public void setRecordDateTime(String recordDateTime) {
        this.recordDateTime = recordDateTime;
    }

    @Override
    public String toString() {
        return "ModelPhoneNetwork{" +
                "id=" + id +
                ", latitude=" + latitude +
                ", longitude=" + longitude +
                ", accuracy=" + accuracy +
                ", deviceId='" + deviceId + '\'' +
                ", subscriberId='" + subscriberId + '\'' +
                ", phoneType='" + phoneType + '\'' +
                ", softwareVersion='" + softwareVersion + '\'' +
                ", simOperatorName='" + simOperatorName + '\'' +
                ", simSerial='" + simSerial + '\'' +
                ", mcc='" + mcc + '\'' +
                ", mnc='" + mnc + '\'' +
                ", lineNumber='" + lineNumber + '\'' +
                ", locality='" + locality + '\'' +
                ", batteryLevel=" + batteryLevel +
                ", address='" + address + '\'' +
                ", rxLevel=" + rxLevel +
                ", rxQuality=" + rxQuality +
                ", ber=" + ber +
                ", networkType='" + networkType + '\'' +
                ", lac='" + lac + '\'' +
                ", cellId='" + cellId + '\'' +
                ", connectionStatus='" + connectionStatus + '\'' +
                ", serviceState='" + serviceState + '\'' +
                ", ipAddress='" + ipAddress + '\'' +
                ", wifiName='" + wifiName + '\'' +
                ", apnName='" + apnName + '\'' +
                ", recordDateTime='" + recordDateTime + '\'' +
                '}';
    }
}
