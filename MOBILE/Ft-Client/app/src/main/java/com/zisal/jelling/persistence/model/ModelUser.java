package com.zisal.jelling.persistence.model;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

import com.zisal.jelling.ApplicationConstant;
import com.zisal.jelling.ApplicationConstant.Database.TableUser;

/**
 * Created on 6/1/2015 : 9:57 AM.
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
@DatabaseTable(tableName = TableUser.TABLE_NAME)
public class ModelUser {

    @DatabaseField(generatedId = true, canBeNull = false, columnName = ApplicationConstant.Database.ID)
    private int id;

    @DatabaseField(columnName = TableUser.USER_NAME)
    private String userName;

    @DatabaseField(columnName = TableUser.LOGIN_STATUS)
    private int loginStatus;

    @DatabaseField(columnName = TableUser.IS_ACTIVE)
    private int isActive;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getLoginStatus() {
        return loginStatus;
    }

    public void setLoginStatus(int loginStatus) {
        this.loginStatus = loginStatus;
    }

    public int getIsActive() {
        return isActive;
    }

    /**
     * 1 active
     * 0 / null is not active
     * @param isActive int
     */
    public void setIsActive(int isActive) {
        this.isActive = isActive;
    }

    @Override
    public String toString() {
        return "ModelUser{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", loginStatus=" + loginStatus +
                ", isActive=" + isActive +
                '}';
    }
}
