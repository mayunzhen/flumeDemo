package com.myz.flume.entity;

import lombok.Data;

import java.util.List;

/**
 * @author mayunzhen
 * @version 1.0
 * @date 2021/2/4 11:23
 * @desc
 */
@Data
public class CarPerception {
    private String id;
    private Long time;
    private String longitude;
    private String latitude;
    private Integer speed;
    private Double heading;
    private String plate;
    private String company;
    private Integer autodrive;
    private Integer motortype;
    private List<Participant> participants;
    @Data
    public static class Participant{
        private Integer id;
        private Position location;
        @Data
        public static class Position{
            private Double longitude;
            private Double latitude;
        }
        private Integer type;
        private Double speed;
        private Double orientation;
        private Size size;
        @Data
        public static class Size{
            private Integer width;
            private Integer length;
            private Integer height;
        }
        private int lane;
    }
}
