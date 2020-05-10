
package com.github.crazyuploader.covid19.indianStates;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class UnofficialSummary {

    @SerializedName("source")
    @Expose
    private String source;
    @SerializedName("total")
    @Expose
    private Long total;
    @SerializedName("recovered")
    @Expose
    private Long recovered;
    @SerializedName("deaths")
    @Expose
    private Long deaths;
    @SerializedName("active")
    @Expose
    private Long active;

    /**
     * No args constructor for use in serialization
     * 
     */
    public UnofficialSummary() {
    }

    /**
     * 
     * @param total
     * @param recovered
     * @param active
     * @param source
     * @param deaths
     */
    public UnofficialSummary(String source, Long total, Long recovered, Long deaths, Long active) {
        super();
        this.source = source;
        this.total = total;
        this.recovered = recovered;
        this.deaths = deaths;
        this.active = active;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public Long getRecovered() {
        return recovered;
    }

    public void setRecovered(Long recovered) {
        this.recovered = recovered;
    }

    public Long getDeaths() {
        return deaths;
    }

    public void setDeaths(Long deaths) {
        this.deaths = deaths;
    }

    public Long getActive() {
        return active;
    }

    public void setActive(Long active) {
        this.active = active;
    }

}
