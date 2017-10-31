package com.zisal.jelling.persistence.model;

import com.j256.ormlite.field.DatabaseField;

import com.zisal.jelling.ApplicationConstant;

/**
 * Created on 5/27/2015 : 2:15 PM.
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
public class AttributeTest {

    @DatabaseField(columnName = ApplicationConstant.Database.APP_TEST_ID )
    private String appTestId;

    @DatabaseField(columnName = ApplicationConstant.Database.START_TEST )
    private String startTest;

    @DatabaseField(columnName = ApplicationConstant.Database.END_TEST)
    private String endTest;

    @DatabaseField(columnName = ApplicationConstant.Database.TEST_TYPE)
    private String testType;

    @DatabaseField(columnName = ApplicationConstant.Database.DEVICE_ID)
    private String deviceId;

    @DatabaseField(columnName = ApplicationConstant.Database.USER_CODE)
    private String userCode;

    @DatabaseField(columnName = ApplicationConstant.Database.TEST_STATUS)
    private String testStatus;

    @DatabaseField(columnName = ApplicationConstant.Database.REASON)
    private String reason;

    @DatabaseField(columnName = ApplicationConstant.Database.RECORD_DATE_TIME)
    private String recordDateTime;


    public String getAppTestId() {
        return appTestId;
    }

    public void setAppTestId(String appTestId) {
        this.appTestId = appTestId;
    }

    public String getStartTest() {
        return startTest;
    }

    public void setStartTest(String startTest) {
        this.startTest = startTest;
    }

    public String getEndTest() {
        return endTest;
    }

    public void setEndTest(String endTest) {
        this.endTest = endTest;
    }

    public String getTestType() {
        return testType;
    }

    public void setTestType(String testType) {
        this.testType = testType;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public String getUserCode() {
        return userCode;
    }

    public void setUserCode(String userCode) {
        this.userCode = userCode;
    }

    public String getTestStatus() {
        return testStatus;
    }

    public void setTestStatus(String testStatus) {
        this.testStatus = testStatus;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getRecordDateTime() {
        return recordDateTime;
    }

    public void setRecordDateTime(String recordDateTime) {
        this.recordDateTime = recordDateTime;
    }

}
