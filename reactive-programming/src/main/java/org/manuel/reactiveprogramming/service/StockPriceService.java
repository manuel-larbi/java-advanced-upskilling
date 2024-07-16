package org.manuel.reactiveprogramming.service;

import io.reactivex.rxjava3.core.Observable;
import org.manuel.reactiveprogramming.response.StockPriceResponse;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface StockPriceService {
    @GET("query")
    Observable<StockPriceResponse> getStockPrice(
            @Query("function") String function,
            @Query("symbol") String symbol,
            @Query("apikey") String apiKey
    );

    static StockPriceService create() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://www.alphavantage.co/")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
                .build();

        return retrofit.create(StockPriceService.class);
    }
}
