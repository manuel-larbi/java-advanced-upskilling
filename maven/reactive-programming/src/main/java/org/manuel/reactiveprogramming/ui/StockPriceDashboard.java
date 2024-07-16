package org.manuel.reactiveprogramming.ui;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import io.reactivex.rxjava3.schedulers.Schedulers;
import javafx.application.Platform;
import org.manuel.reactiveprogramming.service.StockPriceService;

public class StockPriceDashboard extends Application {
    private final Label stockPriceLabel = new Label("Loading...");

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        VBox root = new VBox(stockPriceLabel);
        Scene scene = new Scene(root, 300, 200);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Stock Price Dashboard");
        primaryStage.show();

        fetchStockPrice();
    }

    private void fetchStockPrice() {
        StockPriceService service = StockPriceService.create();
        String apiKey = "your_api_key_here";
        service.getStockPrice("TIME_SERIES_INTRADAY", "AAPL", apiKey)
                .map(response -> response.getTimeSeries().get("2024-07-16 09:30:00").getClose())
                .subscribeOn(Schedulers.io())
                .observeOn(Schedulers.trampoline())
                .subscribe(price -> Platform.runLater(() -> stockPriceLabel.setText("Stock price: " + price)));
    }
}
