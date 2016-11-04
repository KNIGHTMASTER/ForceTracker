package com.tripoin.tripoin_rest.dto.response.location;

import com.google.gson.annotations.SerializedName;

import org.parceler.Parcel;

import java.math.BigInteger;

/**
 * Created on 11/29/2015 : 5:50 PM.
 *
 * @author <a href="fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
@Parcel
public class DTOResponseLocation {

    @SerializedName("id")
    public BigInteger id;

    @SerializedName("code")
    public String code;

    @SerializedName("name")
    public String name;

    @SerializedName("lastLatitude")
    public String lastLatitude;

    @SerializedName("lastLongitude")
    public String lastLongitude;

    @SerializedName("imeiNumber")
    public String imeiNumber;

    @SerializedName("imsiNumber")
    public String imsiNumber;

    @SerializedName("address")
    public String address;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public BigInteger getId() {
        return id;
    }

    public void setId(BigInteger id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastLatitude() {
        return lastLatitude;
    }

    public void setLastLatitude(String lastLatitude) {
        this.lastLatitude = lastLatitude;
    }

    public String getLastLongitude() {
        return lastLongitude;
    }

    public void setLastLongitude(String lastLongitude) {
        this.lastLongitude = lastLongitude;
    }

    public String getImeiNumber() {
        return imeiNumber;
    }

    public void setImeiNumber(String imeiNumber) {
        this.imeiNumber = imeiNumber;
    }

    public String getImsiNumber() {
        return imsiNumber;
    }

    public void setImsiNumber(String imsiNumber) {
        this.imsiNumber = imsiNumber;
    }

    @Override
    public String toString() {
        return "DTOResponseLocation{" +
                "id=" + id +
                ", code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", lastLatitude='" + lastLatitude + '\'' +
                ", lastLongitude='" + lastLongitude + '\'' +
                ", imeiNumber='" + imeiNumber + '\'' +
                ", imsiNumber='" + imsiNumber + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
