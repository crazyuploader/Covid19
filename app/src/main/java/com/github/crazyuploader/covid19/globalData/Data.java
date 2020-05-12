
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
  private Integer casesPerOneMillion;
  @SerializedName("deathsPerOneMillion")
  @Expose
  private Integer deathsPerOneMillion;
  @SerializedName("tests") @Expose private Integer tests;
  @SerializedName("testsPerOneMillion")
  @Expose
  private Integer testsPerOneMillion;
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

  public Integer getCasesPerOneMillion() { return casesPerOneMillion; }

  public Integer getDeathsPerOneMillion() { return deathsPerOneMillion; }

  public Integer getTests() { return tests; }

  public Integer getTestsPerOneMillion() { return testsPerOneMillion; }

  public String getContinent() { return continent; }
}
