package com.zisal.jelling.model;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Ladies Man on 11/29/2015.
 */
@Table(name = "mst_tracker")
@Entity
public class ModelForceTracker implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;

    @Column(name = "code", length = 50)
    private String code;

    @Column(name = "name", length = 50)
    private String name;

    @Column(name = "last_latitude", length = 50)
    private String lastLatitude;

    @Column(name = "last_longitude", length = 50)
    private String lastLongitude;

    @Column(name = "imei_number", length = 100)
    private String imeiNumber;

    @Column(name = "imsi_number", length = 100)
    private String imsiNumber;

    @Column(name = "phone_number", length = 50)
    private String phoneNumber;

    @Column(name = "address", length = 255)
    private String address;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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
        return "ModelForceTracker{" +
                "id=" + id +
                ", code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", lastLatitude='" + lastLatitude + '\'' +
                ", lastLongitude='" + lastLongitude + '\'' +
                ", imeiNumber='" + imeiNumber + '\'' +
                ", imsiNumber='" + imsiNumber + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}

