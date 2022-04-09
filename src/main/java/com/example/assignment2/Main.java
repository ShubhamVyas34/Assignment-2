package com.example.assignment2;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application{

    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Cricket Player Management System");
        stage.setScene(scene);
        stage.getIcons().add(new Image("72940.png"));
        stage.show();
    }
    public static void main(String[] args) {
        launch();
    }

  /* public static void main(String[] args) {
        //launch();
        ApiResponse apiResponse=ApiUtility.getCricketDataFromAPI("India");
        System.out.println(apiResponse);

        ApiResponse apiResponse2=ApiUtility.getCricketDataFromAPI("Virat");
        System.out.println(apiResponse2);
    }*/


}