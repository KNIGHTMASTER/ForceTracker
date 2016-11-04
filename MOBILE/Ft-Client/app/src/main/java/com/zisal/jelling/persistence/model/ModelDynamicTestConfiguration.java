package com.zisal.jelling.persistence.model;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import com.zisal.jelling.ApplicationConstant;
import com.zisal.jelling.ApplicationConstant.Database.TableTestConfiguration;

/**
 * Created on 6/1/2015 : 10:01 AM.
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
@DatabaseTable(tableName = TableTestConfiguration.TABLE_NAME)
public class ModelDynamicTestConfiguration {

    @DatabaseField(generatedId = true, canBeNull = false, columnName = ApplicationConstant.Database.ID)
    private int id;

    /*### START GLOBAL CONFIG ###*/
    @DatabaseField(columnName = TableTestConfiguration.HOST)
    private String host;

    @DatabaseField(columnName = TableTestConfiguration.PORT)
    private int port;

    @DatabaseField(columnName = TableTestConfiguration.POI_RADIUS)
    private int poiRadius;
    /*### END GLOBAL CONFIG ###*/

    /*### START SCHEDULER CONFIG ###*/
    @DatabaseField(columnName = TableTestConfiguration.SCHEDULER_INTERVAL)
    private int schedulerInterval;

    @DatabaseField(columnName = TableTestConfiguration.START_WORKING_HOUR)
    private int startWorkingHour;

    @DatabaseField(columnName = TableTestConfiguration.STOP_WORKING_HOUR)
    private int stopWorkingHour;
    /*### END SCHEDULER CONFIG ###*/

    @DatabaseField(columnName = TableTestConfiguration.PHONE_NUMBER)
    private String phoneNumber;

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public int getSchedulerInterval() {
        return schedulerInterval;
    }

    public void setSchedulerInterval(int schedulerInterval) {
        this.schedulerInterval = schedulerInterval;
    }

    public int getStartWorkingHour() {
        return startWorkingHour;
    }

    public void setStartWorkingHour(int startWorkingHour) {
        this.startWorkingHour = startWorkingHour;
    }

    public int getStopWorkingHour() {
        return stopWorkingHour;
    }

    public void setStopWorkingHour(int stopWorkingHour) {
        this.stopWorkingHour = stopWorkingHour;
    }


    public int getPoiRadius() {
        return poiRadius;
    }

    public void setPoiRadius(int poiRadius) {
        this.poiRadius = poiRadius;
    }

    public String getBaseUrl(){
        return  "http://"
                .concat(getHost())
                .concat(":")
                .concat(String.valueOf(getPort()))
                .concat("/jelling/rest");
    }

    @Override
    public String toString() {
        return "ModelDynamicTestConfiguration{" +
                "id=" + id +
                ", host='" + host + '\'' +
                ", port=" + port +
                ", poiRadius=" + poiRadius +
                ", schedulerInterval=" + schedulerInterval +
                ", startWorkingHour=" + startWorkingHour +
                ", stopWorkingHour=" + stopWorkingHour +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }
}
