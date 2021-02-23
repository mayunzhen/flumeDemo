package com.myz.flume.common;

/**
 * @author mayunzhen
 * @version 1.0
 * @date 2020/11/24 15:59
 * @desc
 */
public interface IDataAdminConstants {

    public static final String SU = "success";

    //redis中 同步Mysql中 v_rsi_priority表的数据的KEY
    public static final String  ZHLW_RSI_PRIORITY = "zhlw_rsi_priority";

    //redis中 同步Mysql中 device_rsu表的数据的KEY
    public static final String ZHLW_DEVICE_RSU = "zhlw_device_rsu";

    //车辆临时坐标存储  用于长期车道占用功能
    public static final String ZHLW_CAR_LOCATION_INTIME ="zhlw_car_location";

    //车辆临时坐标存储  用于长期车道占用功能
    public static final long ZHLW_CAR_LOCATION_TIME_GAP = 30;

    //告警信息结果数据集IDS
    public static final String ZHLW_ALERT_RTEIDS ="zhlw_alert_rteIds";
    //告警信息结果数据集KEY
    public static final String ZHLW_ALERT_RES ="zhlw_alert_res";

    public static final String RoadintersAlert = "RoadintersAlert";

    public static final String RoadAlert = "RoadAlert";

    public static final String RoadintersAlertSUM = "RoadintersAlertSum";

    public static final String RoadAlertSUM = "RoadAlertSum";

    public static final String WINDOW_SUM = "window_sum";

    //长期占用车道编码
    public static final String  ZHLW_LANE_IN_LONGTIME_CODE = "0911";

    //长期占用车道告警级别
    public static final Integer  ZHLW_LANE_IN_LONGTIME_LEVEL = 2;

    //长期占用车道描述
    public static final String  ZHLW_LANE_IN_LONGTIME_DESC = "长期占用应急车道";

    //路段编码标记type
    public static final Long  ZHLW_CROSSROAD = Long.valueOf("1007");

    public static final Integer  ZHLW_BSM_LANE_IN_LONGTIME_TYPE = 13;

    public static final String  ZHLW_TRAFFICFLOW_DAY_IN_TIME = "traffic_in_time";

    public static final String  ZHLW_TRAFFICFLOW_DAY_CUT_TIME = "traffic_cut_in_time";

    public static final String TRAFFICFLOW_TYPE_MONTH ="month";

    public static final String TRAFFICFLOW_TYPE_WEEK = "week";

    public static final String TRAFFICFLOW_TYPE_DAY ="day";

    public static final String SignType_BUS_Limit_Speed ="236";

    public static final Integer InValidBSMData = 8191;

    public static final String CAMERAPre = "camera_";

    public static final String ROAD_STATUS = "road_status";

    public static final String CAR_REAL_TIME_STATUS = "car_real_time_status";

    public static final String CAR_REAL_TIME_CNT = "car_real_time_cnt";

    public static final String RSM_REAL_TIME_STATUS = "rsm_real_time_status";

    public static final String RSM_REAL_TIME_CNT = "rsm_real_time_cnt";

    public static final String V2X_RSI_RECORD = "V2X-RSI-RECORD:";

    public static final String V2X_RSM_RECORD = "V2X-RSM-RECORD:";
}

