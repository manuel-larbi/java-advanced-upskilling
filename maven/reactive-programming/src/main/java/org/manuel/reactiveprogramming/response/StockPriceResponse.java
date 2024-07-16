package org.manuel.reactiveprogramming.response;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public record StockPriceResponse() {
    @SerializedName("Time Series (5min)")
    private static Map<String, TimeSeries> timeSeries;

    public Map<String, TimeSeries> getTimeSeries() {
        return timeSeries;
    }

    public static class TimeSeries {
        @SerializedName("1. open")
        private String open;

        @SerializedName("2. high")
        private String high;

        @SerializedName("3. low")
        private String low;

        @SerializedName("4. close")
        private String close;

        @SerializedName("5. volume")
        private String volume;

        public String getOpen() {
            return open;
        }

        public String getHigh() {
            return high;
        }

        public String getLow() {
            return low;
        }

        public String getClose() {
            return close;
        }

        public String getVolume() {
            return volume;
        }
    }
}
