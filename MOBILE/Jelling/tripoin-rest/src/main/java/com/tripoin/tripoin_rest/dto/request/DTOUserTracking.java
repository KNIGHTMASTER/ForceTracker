package com.tripoin.tripoin_rest.dto.request;

import com.google.gson.annotations.SerializedName;

/**
 * Created on 6/22/2015 : 3:52 PM.
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
public class DTOUserTracking {

    @SerializedName("name")
    private String name;

    @SerializedName("latitude")
    private String latitude;

    @SerializedName("longitude")
    private String longitude;

    @SerializedName("phoneNumber")
    private String phoneNumber;

    @SerializedName("imsi")
    private String imsi;

    @SerializedName("imei")
    private String imei;

    @SerializedName("address")
    private String address;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getImsi() {
        return imsi;
    }

    public void setImsi(String imsi) {
        this.imsi = imsi;
    }

    public String getImei() {
        return imei;
    }

    public void setImei(String imei) {
        this.imei = imei;
    }

    @Override
    public String toString() {
        return "DTOUserTracking{" +
                "latitude='" + latitude + '\'' +
                ", longitude='" + longitude + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", imsi='" + imsi + '\'' +
                ", imei='" + imei + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
