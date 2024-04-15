package com.example.luckyseven.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.util.Random;

public class LuckySevenController {
    @FXML
    private Label numberOne;

    @FXML
    private Label numberTwo;

    @FXML
    private Label numberThree;

    @FXML
    private Button curlWheel;

    @FXML
    private  Button leave;


   private void takeLuckySeven()
   {
       Random random = new Random();
       int numberOne = random.nextInt(8);

       int numberTwo = random.nextInt(8);

       int numberThree = random.nextInt(8);

       if (numberOne == 7 || numberTwo == 7 || numberThree == 7){};

   }
}
