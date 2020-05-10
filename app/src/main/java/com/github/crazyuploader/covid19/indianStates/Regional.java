
package com.github.crazyuploader.covid19.indianStates;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Regional {

    @SerializedName("loc")
    @Expose
    private String loc;
    @SerializedName("confirmedCasesIndian")
    @Expose
    private Long confirmedCasesIndian;
    @SerializedName("discharged")
    @Expose
    private Long discharged;
    @SerializedName("deaths")
    @Expose
    private Long deaths;
    @SerializedName("confirmedCasesForeign")
    @Expose
    private Long confirmedCasesForeign;
    @SerializedName("totalConfirmed")
    @Expose
    private Long totalConfirmed;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Regional() {
    }

    /**
     * 
     * @param loc
     * @param discharged
     * @param confirmedCasesForeign
     * @param confirmedCasesIndian
     * @param deaths
     * @param totalConfirmed
     */
    public Regional(String loc, Long confirmedCasesIndian, Long discharged, Long deaths, Long confirmedCasesForeign, Long totalConfirmed) {
        super();
        this.loc = loc;
        this.confirmedCasesIndian = confirmedCasesIndian;
        this.discharged = discharged;
        this.deaths = deaths;
        this.confirmedCasesForeign = confirmedCasesForeign;
        this.totalConfirmed = totalConfirmed;
    }

    public String getLoc() {
        return loc;
    }

    public void setLoc(String loc) {
        this.loc = loc;
    }

    public Long getConfirmedCasesIndian() {
        return confirmedCasesIndian;
    }

    public void setConfirmedCasesIndian(Long confirmedCasesIndian) {
        this.confirmedCasesIndian = confirmedCasesIndian;
    }

    public Long getDischarged() {
        return discharged;
    }

    public void setDischarged(Long discharged) {
        this.discharged = discharged;
    }

    public Long getDeaths() {
        return deaths;
    }

    public void setDeaths(Long deaths) {
        this.deaths = deaths;
    }

    public Long getConfirmedCasesForeign() {
        return confirmedCasesForeign;
    }

    public void setConfirmedCasesForeign(Long confirmedCasesForeign) {
        this.confirmedCasesForeign = confirmedCasesForeign;
    }

    public Long getTotalConfirmed() {
        return totalConfirmed;
    }

    public void setTotalConfirmed(Long totalConfirmed) {
        this.totalConfirmed = totalConfirmed;
    }

}
