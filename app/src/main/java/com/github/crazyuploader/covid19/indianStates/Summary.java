
package com.github.crazyuploader.covid19.indianStates;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Summary {

    @SerializedName("total")
    @Expose
    private Long total;
    @SerializedName("confirmedCasesIndian")
    @Expose
    private Long confirmedCasesIndian;
    @SerializedName("confirmedCasesForeign")
    @Expose
    private Long confirmedCasesForeign;
    @SerializedName("discharged")
    @Expose
    private Long discharged;
    @SerializedName("deaths")
    @Expose
    private Long deaths;
    @SerializedName("confirmedButLocationUnidentified")
    @Expose
    private Long confirmedButLocationUnidentified;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Summary() {
    }

    /**
     * 
     * @param total
     * @param confirmedButLocationUnidentified
     * @param confirmedCasesForeign
     * @param discharged
     * @param confirmedCasesIndian
     * @param deaths
     */
    public Summary(Long total, Long confirmedCasesIndian, Long confirmedCasesForeign, Long discharged, Long deaths, Long confirmedButLocationUnidentified) {
        super();
        this.total = total;
        this.confirmedCasesIndian = confirmedCasesIndian;
        this.confirmedCasesForeign = confirmedCasesForeign;
        this.discharged = discharged;
        this.deaths = deaths;
        this.confirmedButLocationUnidentified = confirmedButLocationUnidentified;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public Long getConfirmedCasesIndian() {
        return confirmedCasesIndian;
    }

    public void setConfirmedCasesIndian(Long confirmedCasesIndian) {
        this.confirmedCasesIndian = confirmedCasesIndian;
    }

    public Long getConfirmedCasesForeign() {
        return confirmedCasesForeign;
    }

    public void setConfirmedCasesForeign(Long confirmedCasesForeign) {
        this.confirmedCasesForeign = confirmedCasesForeign;
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

    public Long getConfirmedButLocationUnidentified() {
        return confirmedButLocationUnidentified;
    }

    public void setConfirmedButLocationUnidentified(Long confirmedButLocationUnidentified) {
        this.confirmedButLocationUnidentified = confirmedButLocationUnidentified;
    }

}
