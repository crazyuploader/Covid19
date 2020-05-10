
package com.github.crazyuploader.covid19.indianStates;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class IndianStatesData {

    @SerializedName("success")
    @Expose
    private Boolean success;
    @SerializedName("data")
    @Expose
    private Data data;
    @SerializedName("lastRefreshed")
    @Expose
    private String lastRefreshed;
    @SerializedName("lastOriginUpdate")
    @Expose
    private String lastOriginUpdate;

    /**
     * No args constructor for use in serialization
     * 
     */
    public IndianStatesData() {
    }

    /**
     * 
     * @param lastRefreshed
     * @param data
     * @param success
     * @param lastOriginUpdate
     */
    public IndianStatesData(Boolean success, Data data, String lastRefreshed, String lastOriginUpdate) {
        super();
        this.success = success;
        this.data = data;
        this.lastRefreshed = lastRefreshed;
        this.lastOriginUpdate = lastOriginUpdate;
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }

    public String getLastRefreshed() {
        return lastRefreshed;
    }

    public void setLastRefreshed(String lastRefreshed) {
        this.lastRefreshed = lastRefreshed;
    }

    public String getLastOriginUpdate() {
        return lastOriginUpdate;
    }

    public void setLastOriginUpdate(String lastOriginUpdate) {
        this.lastOriginUpdate = lastOriginUpdate;
    }

}
