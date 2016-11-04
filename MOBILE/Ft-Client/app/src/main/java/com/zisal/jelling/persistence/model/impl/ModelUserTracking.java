package com.zisal.jelling.persistence.model.impl;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

import com.zisal.jelling.ApplicationConstant;

/**
 * Created on 6/3/2015 : 2:32 PM.
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
@DatabaseTable(tableName = ApplicationConstant.Database.TableUserTracking.TABLE_NAME)
public class ModelUserTracking {

    @DatabaseField(generatedId = true, canBeNull = false, columnName = ApplicationConstant.Database.ID)
    private int id;

    @DatabaseField(columnName = ApplicationConstant.Database.TableUserTracking.USER_TRACKING_JSON_DATA)
    private String userTrackingJsonData;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserTrackingJsonData() {
        return userTrackingJsonData;
    }

    public void setUserTrackingJsonData(String userTrackingJsonData) {
        this.userTrackingJsonData = userTrackingJsonData;
    }

    @Override
    public String toString() {
        return "ModelUserTracking{" +
                "id=" + id +
                ", userTrackingJsonData='" + userTrackingJsonData + '\'' +
                '}';
    }
}
