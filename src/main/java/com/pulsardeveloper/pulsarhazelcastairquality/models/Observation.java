package com.pulsardeveloper.pulsarhazelcastairquality.models;

import java.util.Map;

public class Observation {
    private String DateObserved;
    private Integer HourObserved;
    private String LocalTimeZone;
    private String ReportingArea;
    private String StateCode;
    private Double Latitude;
    private Double Longitude;
    private String ParameterName;
    private Integer AQI;
    private Category Category;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Observation() {
        super();
    }

    /**
     * 
     * @param dateObserved
     * @param latitude
     * @param localTimeZone
     * @param aqi
     * @param stateCode
     * @param parameterName
     * @param hourObserved
     * @param category
     * @param reportingArea
     * @param longitude
     */
    public Observation(String dateObserved, Integer hourObserved, String localTimeZone, String reportingArea, String stateCode, Double latitude, Double longitude, String parameterName, Integer aqi, Category category) {
        super();
        this.DateObserved = dateObserved;
        this.HourObserved = hourObserved;
        this.LocalTimeZone = localTimeZone;
        this.ReportingArea = reportingArea;
        this.StateCode = stateCode;
        this.Latitude = latitude;
        this.Longitude = longitude;
        this.ParameterName = parameterName;
        this.AQI = aqi;
        this.Category = category;
    }

    public String getDateObserved() {
        return DateObserved;
    }

    public void setDateObserved(String dateObserved) {
        this.DateObserved = dateObserved;
    }

    public Integer getHourObserved() {
        return HourObserved;
    }

    public void setHourObserved(Integer hourObserved) {
        this.HourObserved = hourObserved;
    }

    public String getLocalTimeZone() {
        return LocalTimeZone;
    }

    public void setLocalTimeZone(String localTimeZone) {
        this.LocalTimeZone = localTimeZone;
    }

    public String getReportingArea() {
        return ReportingArea;
    }

    public void setReportingArea(String reportingArea) {
        this.ReportingArea = reportingArea;
    }

    public String getStateCode() {
        return StateCode;
    }

    public void setStateCode(String stateCode) {
        this.StateCode = stateCode;
    }

    public Double getLatitude() {
        return Latitude;
    }

    public void setLatitude(Double latitude) {
        this.Latitude = latitude;
    }

    public Double getLongitude() {
        return Longitude;
    }

    public void setLongitude(Double longitude) {
        this.Longitude = longitude;
    }

    public String getParameterName() {
        return ParameterName;
    }

    public void setParameterName(String parameterName) {
        this.ParameterName = parameterName;
    }

    public Integer getAQI() {
        return AQI;
    }

    public void setAQI(Integer AQI) {
        this.AQI = AQI;
    }

    public Category getCategory() {
        return Category;
    }

    public void setCategory(Category category) {
        this.Category = category;
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(Observation.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("dateObserved");
        sb.append('=');
        sb.append(((this.DateObserved == null)?"<null>":this.DateObserved));
        sb.append(',');
        sb.append("hourObserved");
        sb.append('=');
        sb.append(((this.HourObserved == null)?"<null>":this.HourObserved));
        sb.append(',');
        sb.append("localTimeZone");
        sb.append('=');
        sb.append(((this.LocalTimeZone == null)?"<null>":this.LocalTimeZone));
        sb.append(',');
        sb.append("reportingArea");
        sb.append('=');
        sb.append(((this.ReportingArea == null)?"<null>":this.ReportingArea));
        sb.append(',');
        sb.append("stateCode");
        sb.append('=');
        sb.append(((this.StateCode == null)?"<null>":this.StateCode));
        sb.append(',');
        sb.append("latitude");
        sb.append('=');
        sb.append(((this.Latitude == null)?"<null>":this.Latitude));
        sb.append(',');
        sb.append("longitude");
        sb.append('=');
        sb.append(((this.Longitude == null)?"<null>":this.Longitude));
        sb.append(',');
        sb.append("parameterName");
        sb.append('=');
        sb.append(((this.ParameterName == null)?"<null>":this.ParameterName));
        sb.append(',');
        sb.append("aqi");
        sb.append('=');
        sb.append(((this.AQI == null)?"<null>":this.AQI));
        sb.append(',');
        sb.append("category");
        sb.append('=');
        sb.append(((this.Category == null)?"<null>":this.Category));
        if (sb.charAt((sb.length()- 1)) == ',') {
            sb.setCharAt((sb.length()- 1), ']');
        } else {
            sb.append(']');
        }
        return sb.toString();
    }
}