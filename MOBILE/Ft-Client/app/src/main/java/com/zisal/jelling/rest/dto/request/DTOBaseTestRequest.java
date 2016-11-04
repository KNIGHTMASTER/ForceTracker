package com.zisal.jelling.rest.dto.request;

import com.google.gson.annotations.SerializedName;

/**
 * Created on 6/1/2015 : 2:48 PM.
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
public class DTOBaseTestRequest extends DTOTestTime {

    @SerializedName("deviceid")
    private String deviceid;

    @SerializedName("user_code")
    private String user_code;

    @SerializedName("test_type")
    private String test_type;

    @SerializedName("test_status")
    private String test_status;

    @SerializedName("phone_type")
    private String phone_type;

    @SerializedName("phone_sn")
    private String phone_sn;

    @SerializedName("phone_os")
    private String phone_os;

    @SerializedName("phone_imei")
    private String phone_imei;

    @SerializedName("phone_imsi")
    private String phone_imsi;

    @SerializedName("phone_batt_lvl")
    private String phone_batt_lvl;

    @SerializedName("net_lat")
    private String net_lat;

    @SerializedName("net_long")
    private String net_long;

    @SerializedName("net_accu")
    private String net_accu;

    @SerializedName("net_operator")
    private String net_operator;

    @SerializedName("net_mcc")
    private String net_mcc;

    @SerializedName("net_mnc")
    private String net_mnc;

    @SerializedName("net_ln")
    private String net_ln;

    @SerializedName("net_local")
    private String net_local;

    @SerializedName("net_addr")
    private String net_addr;

    @SerializedName("net_rxl")
    private String net_rxl;

    @SerializedName("net_rxq")
    private String net_rxq;

    @SerializedName("net_ber")
    private String net_ber;

    @SerializedName("net_nettyp")
    private String net_nettyp;

    @SerializedName("net_lac")
    private String net_lac;

    @SerializedName("net_cellid")
    private String net_cellid;

    @SerializedName("net_connstat")
    private String net_connstat;

    @SerializedName("net_srvcstat")
    private String net_srvcstat;

    @SerializedName("net_wifi_name")
    private String net_wifi_name;

    @SerializedName("net_ipaddr")
    private String net_ipaddr;

    @SerializedName("net_apn")
    private String net_apn;

    @SerializedName("poi_code")
    private String poi_code;

    public String getPoi_code() {
        return poi_code;
    }

    public void setPoi_code(String poi_code) {
        this.poi_code = poi_code;
    }

    public String getDeviceid() {
        return deviceid;
    }

    public void setDeviceid(String deviceid) {
        this.deviceid = deviceid;
    }

    public String getUser_code() {
        return user_code;
    }

    public void setUser_code(String user_code) {
        this.user_code = user_code;
    }

    public String getTest_type() {
        return test_type;
    }

    public void setTest_type(String test_type) {
        this.test_type = test_type;
    }

    public String getTest_status() {
        return test_status;
    }

    public void setTest_status(String test_status) {
        this.test_status = test_status;
    }

    public String getPhone_type() {
        return phone_type;
    }

    public void setPhone_type(String phone_type) {
        this.phone_type = phone_type;
    }

    public String getPhone_sn() {
        return phone_sn;
    }

    public void setPhone_sn(String phone_sn) {
        this.phone_sn = phone_sn;
    }

    public String getPhone_os() {
        return phone_os;
    }

    public void setPhone_os(String phone_os) {
        this.phone_os = phone_os;
    }

    public String getPhone_imei() {
        return phone_imei;
    }

    public void setPhone_imei(String phone_imei) {
        this.phone_imei = phone_imei;
    }

    public String getPhone_imsi() {
        return phone_imsi;
    }

    public void setPhone_imsi(String phone_imsi) {
        this.phone_imsi = phone_imsi;
    }

    public String getPhone_batt_lvl() {
        return phone_batt_lvl;
    }

    public void setPhone_batt_lvl(String phone_batt_lvl) {
        this.phone_batt_lvl = phone_batt_lvl;
    }

    public String getNet_lat() {
        return net_lat;
    }

    public void setNet_lat(String net_lat) {
        this.net_lat = net_lat;
    }

    public String getNet_long() {
        return net_long;
    }

    public void setNet_long(String net_long) {
        this.net_long = net_long;
    }

    public String getNet_accu() {
        return net_accu;
    }

    public void setNet_accu(String net_accu) {
        this.net_accu = net_accu;
    }

    public String getNet_operator() {
        return net_operator;
    }

    public void setNet_operator(String net_operator) {
        this.net_operator = net_operator;
    }

    public String getNet_mcc() {
        return net_mcc;
    }

    public void setNet_mcc(String net_mcc) {
        this.net_mcc = net_mcc;
    }

    public String getNet_mnc() {
        return net_mnc;
    }

    public void setNet_mnc(String net_mnc) {
        this.net_mnc = net_mnc;
    }

    public String getNet_ln() {
        return net_ln;
    }

    public void setNet_ln(String net_ln) {
        this.net_ln = net_ln;
    }

    public String getNet_local() {
        return net_local;
    }

    public void setNet_local(String net_local) {
        this.net_local = net_local;
    }

    public String getNet_addr() {
        return net_addr;
    }

    public void setNet_addr(String net_addr) {
        this.net_addr = net_addr;
    }

    public String getNet_rxl() {
        return net_rxl;
    }

    public void setNet_rxl(String net_rxl) {
        this.net_rxl = net_rxl;
    }

    public String getNet_rxq() {
        return net_rxq;
    }

    public void setNet_rxq(String net_rxq) {
        this.net_rxq = net_rxq;
    }

    public String getNet_ber() {
        return net_ber;
    }

    public void setNet_ber(String net_ber) {
        this.net_ber = net_ber;
    }

    public String getNet_nettyp() {
        return net_nettyp;
    }

    public void setNet_nettyp(String net_nettyp) {
        this.net_nettyp = net_nettyp;
    }

    public String getNet_lac() {
        return net_lac;
    }

    public void setNet_lac(String net_lac) {
        this.net_lac = net_lac;
    }

    public String getNet_cellid() {
        return net_cellid;
    }

    public void setNet_cellid(String net_cellid) {
        this.net_cellid = net_cellid;
    }

    public String getNet_connstat() {
        return net_connstat;
    }

    public void setNet_connstat(String net_connstat) {
        this.net_connstat = net_connstat;
    }

    public String getNet_srvcstat() {
        return net_srvcstat;
    }

    public void setNet_srvcstat(String net_srvcstat) {
        this.net_srvcstat = net_srvcstat;
    }

    public String getNet_wifi_name() {
        return net_wifi_name;
    }

    public void setNet_wifi_name(String net_wifi_name) {
        this.net_wifi_name = net_wifi_name;
    }

    public String getNet_ipaddr() {
        return net_ipaddr;
    }

    public void setNet_ipaddr(String net_ipaddr) {
        this.net_ipaddr = net_ipaddr;
    }

    public String getNet_apn() {
        return net_apn;
    }

    public void setNet_apn(String net_apn) {
        this.net_apn = net_apn;
    }

    @Override
    public String toString() {
        return "DTOBaseTestRequest{" +
                "deviceid='" + deviceid + '\'' +
                ", user_code='" + user_code + '\'' +
                ", test_type='" + test_type + '\'' +
                ", test_status='" + test_status + '\'' +
                ", phone_type='" + phone_type + '\'' +
                ", phone_sn='" + phone_sn + '\'' +
                ", phone_os='" + phone_os + '\'' +
                ", phone_imei='" + phone_imei + '\'' +
                ", phone_imsi='" + phone_imsi + '\'' +
                ", phone_batt_lvl='" + phone_batt_lvl + '\'' +
                ", net_lat='" + net_lat + '\'' +
                ", net_long='" + net_long + '\'' +
                ", net_accu='" + net_accu + '\'' +
                ", net_operator='" + net_operator + '\'' +
                ", net_mcc='" + net_mcc + '\'' +
                ", net_mnc='" + net_mnc + '\'' +
                ", net_ln='" + net_ln + '\'' +
                ", net_local='" + net_local + '\'' +
                ", net_addr='" + net_addr + '\'' +
                ", net_rxl='" + net_rxl + '\'' +
                ", net_rxq='" + net_rxq + '\'' +
                ", net_ber='" + net_ber + '\'' +
                ", net_nettyp='" + net_nettyp + '\'' +
                ", net_lac='" + net_lac + '\'' +
                ", net_cellid='" + net_cellid + '\'' +
                ", net_connstat='" + net_connstat + '\'' +
                ", net_srvcstat='" + net_srvcstat + '\'' +
                ", net_wifi_name='" + net_wifi_name + '\'' +
                ", net_ipaddr='" + net_ipaddr + '\'' +
                ", net_apn='" + net_apn + '\'' +
                ", poi_code='" + poi_code + '\'' +
                '}';
    }
}
