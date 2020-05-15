
package com.github.crazyuploader.covid19.globalData;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Data {

    @SerializedName("updated") @Expose private Long updated;
    @SerializedName("country") @Expose private String country;
    @SerializedName("countryInfo") @Expose private CountryInfo countryInfo;
    @SerializedName("cases") @Expose private Integer cases;
    @SerializedName("todayCases") @Expose private Integer todayCases;
    @SerializedName("deaths") @Expose private Integer deaths;
    @SerializedName("todayDeaths") @Expose private Integer todayDeaths;
    @SerializedName("recovered") @Expose private Integer recovered;
    @SerializedName("active") @Expose private Integer active;
    @SerializedName("critical") @Expose private Integer critical;
    @SerializedName("casesPerOneMillion")
    @Expose
    private Double casesPerOneMillion;
    @SerializedName("deathsPerOneMillion")
    @Expose
    private Double deathsPerOneMillion;
    @SerializedName("tests") @Expose private Double tests;
    @SerializedName("testsPerOneMillion")
    @Expose
    private Double testsPerOneMillion;
    @SerializedName("continent") @Expose private String continent;

    public long getUpdated() { return updated; }

    public String getCountry() { return country; }

    public CountryInfo getCountryInfo() { return countryInfo; }

    public Integer getCases() { return cases; }

    public Integer getTodayCases() { return todayCases; }

    public Integer getDeaths() { return deaths; }

    public Integer getTodayDeaths() { return todayDeaths; }

    public Integer getRecovered() { return recovered; }

    public Integer getActive() { return active; }

    public Integer getCritical() { return critical; }

    public Double getCasesPerOneMillion() { return casesPerOneMillion; }

    public Double getDeathsPerOneMillion() { return deathsPerOneMillion; }

    public Double getTests() { return tests; }

    public Double getTestsPerOneMillion() { return testsPerOneMillion; }

    public String getContinent() { return continent; }
}
