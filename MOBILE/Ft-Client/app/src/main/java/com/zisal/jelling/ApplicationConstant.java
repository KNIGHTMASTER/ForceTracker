package com.zisal.jelling;

import android.telephony.PhoneStateListener;

import id.co.telkomsigma.mforce.mqa.common.component.GeneralConstant;

/**
 * Created on 5/25/2015 : 11:48 AM.
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
public interface ApplicationConstant {

    interface LogTag {
        String MQA_INFO = "MQA INFO";
        String MQA_ERROR = "MQA ERROR";
    }

    interface SMS{
        String PHONE_TARGET = "082298945846";
        String BASE_PROTOCOL = "MQA#";
    }

    interface Scheduler{
        int NOTIFICATION_SCAN_INTERVAL = 600;
    }

    interface Rest {

        String HOST_DEV = "10.210.9.84";
        String HOST_PROD = "93.188.165.47";

        int PORT_DEV = 8280;

        int SCHEDULER_INTERVAL = 90;
        int START_WORKING_HOUR = 0;
        int STOP_WORKING_HOUR = 24;

        String BASE_URL_DEV = "http://10.210.9.84:8080/mforce-rest/ws/service";
        String BASE_URL_PROD = "http://180.250.115.49:8080/mforce-rest/ws/service";

        String AUTHORIZATION = "Authorization";
        String BASIC = "Basic";
        String ACCEPT = "Accept";
        String APPLICATION_JSON = "application/json";
        String APPLICATION_XML = "application/xml";
        String URL_APK = "http://180.250.115.49/apk/MQABackgroundV2.apk";
    }

    interface PhoneStateEvents {
        int events =
                PhoneStateListener.LISTEN_SIGNAL_STRENGTHS |
                        PhoneStateListener.LISTEN_DATA_ACTIVITY |
                        PhoneStateListener.LISTEN_CELL_LOCATION |
                        PhoneStateListener.LISTEN_CALL_STATE |
                        PhoneStateListener.LISTEN_CALL_FORWARDING_INDICATOR |
                        PhoneStateListener.LISTEN_DATA_CONNECTION_STATE |
                        PhoneStateListener.LISTEN_MESSAGE_WAITING_INDICATOR |
                        PhoneStateListener.LISTEN_SERVICE_STATE;
    }

    interface ApplicationMessage {
        String ACTION_BAR_TITLE = "Force Tracker";
        String WORKING_HOUR = "Working Hour";
        String NON_WORKING_HOUR = "Non Working Hour";

        String AUTO_AGENT_ACTIVATION_SUCCESS = "Activation Successful, Service is running";
        String AUTO_AGENT_ACTIVATION_FAILED = "Automatic Agent Activation Failed";
        String AUTO_AGENT_IS_NOT_REGISTERED = "Activation Failed, IMSI Not registered";
        String AUTO_AGENT_IS_NOT_CONN_INTERNET = "Activation Failed, No internet connection";

        String TEST_REMINDER = "Not Tested POI";

        String TESTING_SUCCESS = "Testing Success";
        String TESTING_FAILED = "Testing Failed";
    }

    interface Database {
        String TENANT_NAME = "telkomsel";
        String DATABASE_NAME = "mforce_mqa_background_".concat(TENANT_NAME);
        int DB_VERSION = 1;
        String ID = "id";
        String APP_TEST_ID = "app_test_id";
        String START_TEST = "start_test";
        String END_TEST = "end_test";
        String TEST_TYPE = "test_type";
        String DEVICE_ID = "device_id";
        String USER_CODE = "user_code";
        String TEST_STATUS = "test_status";
        String REASON = "reason";

        String RECORD_DATE_TIME = "record_date_time";
        String THROUGHPUT = "throughput";

        interface TablePhoneNetwork {
            String TABLE_NAME = "mforce_phone_network";
            String LATITUDE = "latitude";
            String LONGITUDE = "longitude";
            String ACCURACY = "accuracy";
            String DEVICE_ID = "device_id";
            String SUBSCRIBER_ID = "subscriber_id";
            String PHONE_TYPE = "phone_type";
            String SOFTWARE_VERSION = "software_version";
            String SIM_OPERATOR_NAME = "sim_operator_name";
            String SIM_SERIAL = "sim_serial";
            String MCC = "mcc";
            String MNC = "mnc";
            String LINE_NUMBER = "line_number";
            String LOCALITY = "locality";
            String BATTERY_LEVEL = "battery_level";
            String ADDRESS = "address";
            String RX_LEVEL = "rx_level";
            String RX_QUALITY = "rx_quality";
            String BER = "ber";
            String NETWORK_TYPE = "network_type";
            String LAC = "lac";
            String CELL_ID = "cell_id";
            String CONNECTION_STATUS = "connection_status";
            String SERVICE_STATE = "service_state";
            String IP_ADDRESS = "ip_address";
            String WIFI_NAME = "wifi_name";
            String APN_NAME = "apn_name";
        }

        interface TableTestController {
            String TABLE_NAME = "mforce_test_controller";
            String SPEED_TEST = "speed_test";
            String VIDEO_TEST = "video_test";
            String WEB_TEST = "web_test";
            String BGP_SPEED_TEST = "bgp_speed_test";
            String BGP_VIDEO_TEST = "bgp_video_test";
            String BGP_WEB_TEST = "bgp_web_test";
            String RETRY_NUMBER = "retry_number";
            String TEST_DATE = "test_date";
            String IS_RETRYING = "is_retrying";
        }

        interface TablePOIWriter{
            String TABLE_NAME = "mforce_poi_writer";
            String POI_NAME = "poi_name";
        }

        interface TableSpeedTest {
            String TABLE_NAME = "mforce_speed_test";
            String LATENCY = "latency";
            String DOWNLOAD = "download";
            String UPLOAD = "upload";
            String START_CONNECTION_TIME = "start_connection_time";
            String END_CONNECTION_TIME = "end_connection_time";
            String FILE_DOWNLOADED_SIZE = "file_downloaded_size";
            String START_DOWNLOAD_TIME = "start_download_time";
            String END_DOWNLOAD_TIME = "end_download_time";
            String DOWNLOAD_DURATION = "download_duration";
            String LATENCY_COUNTER = "latency_counter";
        }

        interface TableVideoTest {
            String TABLE_NAME = "mforce_video_test";
            String TOTAL_BUFFER_EVENT = "total_buffer_event";
            String TOTAL_BUFFER_TIME = "total_buffer_time";
            String VIDEO_DURATION = "video_duration";
            String VIDEO_URL = "video_url";
            String DEFINITION = "definition";
            String RESOLUTION = "resolution";
            String INIT_BUFFER = "init_buffer";
            String REBUFFER = "rebuffer";
            String VIDEO_SIZE = "video_size";
            String START_VIDEO_TIME = "start_video_time";
            String END_VIDEO_TIME = "end_video_time";
            String VIDEO_TEST_ID = "video_test_id";
            String VIDEO_TEST_LOCK = "video_test_lock";
        }

        interface TableWebTest {
            String TABLE_NAME = "mforce_web_test";
            String LOADING_TIME = "loading_time";
            String LOADING_STATUS = "loading_status";
            String PAGE_URL = "page_url";
            String RESOLUTION = "resolution";
            String PAGE_SIZE = "page_size";
            String START_LOADING_TIME = "start_loading_time";
            String END_LOADING_TIME = "end_loading_time";
            String WEB_TEST_ID = "web_test_id";
            String WEB_TEST_LOCK = "web_test_lock";
        }

        interface TableUser {
            String TABLE_NAME = "mforce_user";
            String USER_NAME = "user_name";
            String LOGIN_STATUS = "login_status";
            String IS_ACTIVE = "is_active";
        }

        interface TableTestConfiguration {
            String TABLE_NAME = "mforce_test_configuration";
            String ASSIGNED_POI = "assigned_poi";
            String TEST_SEQUENCE = "test_sequence";
            String SCHEDULER_INTERVAL = "scheduler_interval";
            String HOST = "host";
            String PORT = "port";
            String POI_RADIUS = "poi_radius";
            String START_WORKING_HOUR = "start_working_hour";
            String STOP_WORKING_HOUR = "stop_working_hour";
            String PHONE_NUMBER = "phone_number";
        }

        interface TableTestSequence {
            String TABLE_NAME = "mforce_test_sequence";
            String TEST_CONFIGURATION_ID = "test_configuration_id";
            String TEST_NAME = "test_name";
            String TEST_URL = "test_url";
            String TEST_PRIORITY = "test_priority";
            String TEST_STATUS = "test_status";
            String CONNECTION_TIMEOUT = "connection_timeout";
            String SOCKET_TIMEOUT = "socket_timeout";
            String RETRY_NUMBER = "retry_number";
            String RETRY_TIMEOUT = "retry_timeout";
            String THREAD_SIZE = "thread_size";
            String SOCKET_HOST = "socket_host";
            String SOCKET_PORT = "socket_port";
        }

        interface TableUserTracking {
            String TABLE_NAME = "mforce_user_tracking";
            String USER_TRACKING_JSON_DATA = "user_tracking_json_data";
        }

        interface TableDropCall {
            String TABLE_NAME = "mforce_drop_call";
            String DROP_CALL_JSON_DATA = "drop_call_json_data";
        }

        interface TableFailedTest {
            String TABLE_NAME = "mforce_failed_test";
            String FAILED_TEST_JSON_DATA = "failed_test_json_data";
            String TEST_NAME = "test_name";
            String TEST_ID = "test_id";
        }

        interface TableAssignedPOI {
            String TABLE_NAME = "mforce_assigned_poi";
            String LAC = "lac";
            String CI = "ci";
            String LATITUDE = "latitude";
            String LONGITUDE = "longitude";
            String POI_NAME = "poi_name";
            String POI_CODE = "poi_code";
        }

        interface TableCurrentMatchedPOI {
            String TABLE_NAME = "mforce_current_matched_poi";
            String POI_CODE = "poi_code";
            String POI_NAME = "poi_name";
        }
    }

    interface TestName {
        String SPEED_TEST = "SPEED_TEST";
        String VIDEO_TEST = "VIDEO_TEST";
        String WEB_TEST = "WEB_TEST";
    }

    interface TestType {
        /*String SPEED_TEST = "sst";
        String VIDEO_TEST = "vst";
        String WEB_TEST = "bst";*/
        String BACKGROUND_TEST = "BGT";
    }

    interface TestStatus {
        interface Process {
            String PASS = "P";
            String FAILED = "F";
        }

        interface Config {
            String ACTIVE = "A";
            String DEACTIVE = "D";
        }
    }

    interface Command {
        String CALL_TEST_CONTROLLER = "call test controller";
    }

    interface ThreadName {
        String BGP_SPEED_TEST = "bgp speed test";
        String BGP_VIDEO_TEST = "bgp video test";
        String BGP_WEB_TEST = "bgp web test";
        String [] threadGroup = new String[]{
                BGP_SPEED_TEST,
                BGP_VIDEO_TEST,
                BGP_WEB_TEST,
                GeneralConstant.ThreadName.LATENCY_THREAD,
                GeneralConstant.ThreadName.DOWNLOAD_THREAD,
                GeneralConstant.ThreadName.VIDEO_THREAD,
                GeneralConstant.ThreadName.WEB_THREAD
        };
    }

}