package com.example.assignment2;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class SearchViewController implements Initializable {

    @FXML
    private TextField searchTextField;

    @FXML
    private ListView<Player> resultListView;

    @FXML
    private Label msgLabel;

    @FXML
    private ImageView imageView;

    @FXML
    private ProgressBar progressBar;

    @FXML
    private Button getInfoButton;


    @FXML
    void searchPlayer(ActionEvent event) {
        ApiResponse apiResponse=ApiUtility.getCricketDataFromAPIQuick(searchTextField.getText());
        resultListView.getItems().clear();
        if(apiResponse.getData()!=null){
            resultListView.getItems().addAll(apiResponse.getData());
            msgLabel.setText("");
        }
        else{
            msgLabel.setText("Player not found");
        }


    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        getInfoButton.setVisible(false);
        resultListView.getSelectionModel().selectedItemProperty().addListener(
                (obs, oldMovieSelected, newMovieSelected) -> {
                    getInfoButton.setVisible(true);
                    try {
                        imageView.setImage(new Image("https://upload.wikimedia.org/wikipedia/commons/4/41/Cricket_ball_on_grass.jpg"));
                    }
                    catch (IllegalArgumentException e)
                    {
                        imageView.setImage(new Image("https://trailerfailure.com/img/images/missingCoverPhoto.jpg"));
                    }
                    getInfoButton.setVisible(true);
                });
    }
    @FXML
    void getDetails(ActionEvent event) throws IOException {
        String id = resultListView.getSelectionModel().getSelectedItem().getId();
        SceneChanger.changeScenes(event, "Team-detail.fxml",id);
    }

}
