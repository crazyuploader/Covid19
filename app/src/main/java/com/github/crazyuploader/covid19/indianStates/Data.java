
package com.github.crazyuploader.covid19.indianStates;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Data {

    @SerializedName("summary")
    @Expose
    private Summary summary;
    @SerializedName("unofficial-summary")
    @Expose
    private List<UnofficialSummary> unofficialSummary = null;
    @SerializedName("regional")
    @Expose
    private List<Regional> regional = null;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Data() {
    }

    /**
     * 
     * @param summary
     * @param regional
     * @param unofficialSummary
     */
    public Data(Summary summary, List<UnofficialSummary> unofficialSummary, List<Regional> regional) {
        super();
        this.summary = summary;
        this.unofficialSummary = unofficialSummary;
        this.regional = regional;
    }

    public Summary getSummary() {
        return summary;
    }

    public void setSummary(Summary summary) {
        this.summary = summary;
    }

    public List<UnofficialSummary> getUnofficialSummary() {
        return unofficialSummary;
    }

    public void setUnofficialSummary(List<UnofficialSummary> unofficialSummary) {
        this.unofficialSummary = unofficialSummary;
    }

    public List<Regional> getRegional() {
        return regional;
    }

    public void setRegional(List<Regional> regional) {
        this.regional = regional;
    }

}
