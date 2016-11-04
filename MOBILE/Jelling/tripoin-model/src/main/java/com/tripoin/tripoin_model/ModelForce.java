package com.tripoin.tripoin_model;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import com.tripoin.tripoin_common.constant.ApplicationConstant;

/**
 * Created by Achmad Fauzi on 6/4/2015 : 9:59 PM.
 * @author <a href="fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
@DatabaseTable(tableName = ApplicationConstant.Database.TableForce.TABLE_NAME)
public class ModelForce {

    @DatabaseField(generatedId = true, canBeNull = false, columnName = ApplicationConstant.Database.ID, unique = true)
    private int id;

    @DatabaseField(columnName = ApplicationConstant.Database.TableForce.NAME)
    private String name;

    @DatabaseField(columnName = ApplicationConstant.Database.TableForce.IMEI)
    private String imei;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImei() {
        return imei;
    }

    public void setImei(String imei) {
        this.imei = imei;
    }

    @Override
    public String toString() {
        return "ModelForce{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", imei='" + imei + '\'' +
                '}';
    }
}
