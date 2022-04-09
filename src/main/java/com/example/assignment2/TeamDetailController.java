package com.example.assignment2;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;

public class TeamDetailController implements Initializable {

    @FXML
    private Label TeamTitleLabel;

    @FXML
    private Label nameLabel;

    @FXML
    private Label dateLabel;

    @FXML
    private Label roleTable;

    @FXML
    private Label battingStyleLabel;

    @FXML
    private Label bowlingStyleLabel;

    @FXML
    private Label idLabel;

    @FXML
    private Label birthLabel;

    @FXML
    private Label countryLabel;


    private TeamDetails obj;
    public void loadTeamDetails(String id){
        System.out.println("The id we got from search view "+id);

       obj=ApiUtility.getTeamDetails(id);
        System.out.println("obj is "+obj);
        idLabel.setText(obj.getId());
        nameLabel.setText(obj.getName());
        dateLabel.setText(obj.getDateOfBirth());
        roleTable.setText(obj.getRole());
        battingStyleLabel.setText(obj.getBattingStyle());
        bowlingStyleLabel.setText(obj.getBattingStyle());
        birthLabel.setText(obj.getPlaceOfBirth());
        countryLabel.setText(obj.getCountry());


    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
