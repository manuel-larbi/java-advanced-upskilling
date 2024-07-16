package org.manuel.reactiveprogramming;

import org.manuel.reactiveprogramming.service.StockPriceService;

public class StockPriceApplication {
    public static void main(String[] args) {
        StockPriceService service = StockPriceService.create();
        String apiKey = "your_api_key_here";
        service.getStockPrice("TIME_SERIES_INTRADAY", "AAPL", apiKey)
                .map(response -> response.getTimeSeries().get("2024-07-16 09:30:00").getClose())
                .subscribe(price -> System.out.println("Stock price: " + price));
    }
}
