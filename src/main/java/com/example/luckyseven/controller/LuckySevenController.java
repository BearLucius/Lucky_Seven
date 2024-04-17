package com.example.luckyseven.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.*;
import java.util.Random;
// (Нажатия * победы) / 100;
public class LuckySevenController {
    // Всё что НЕ используется для показа;
    private File file = new File("C:/Users/Krapivin2021/IdeaProjects/luckySeven/casino.txt");
    private Label numberOne;
    private Label numberTwo;
    private Label numberThree;
    private int clicked; // Нажатие на кнопку "Крутите барабан"
    private int victory; // Счёт побед;
    private double percentSave;

    // Всё что используется для показа;
    @FXML
    private Label resultLabelOne; // Возвращаемый результат ячейки 1;
    @FXML
    private Label resultLabelTwo; // Возвращаемый результат ячейки 2;
    @FXML
    private Label resultLabelThree; // Возвращаемый результат ячейки 3;
    @FXML
    private ImageView resImage; // Возвращаем картинку;
    @FXML
    private Label labelClicked;
    @FXML
    private Label labelVictory;
    @FXML
    private Label percentVictory;

    @FXML
   private void takeAction() // Привязана к кнопке "Вращайте барабан", выдаёт диалоговое окно при получение одной 7-рки из трёх/ всех трёх 7-рок/ ни одной 7-рки;
   {
       percentSave = (clicked*victory)/100;
       percentVictory.setText("Шанс победы: " + percentSave);
        clicked++;
        labelClicked.setText("Всего нажатий: " + clicked);
       // Генерация рандомных чисед от 0 до 7;
       Random random = new Random();
       int numberOne = random.nextInt(10);
       int numberTwo = random.nextInt(10);
       int numberThree = random.nextInt(10);

       // resultLabel служит переменной в которую мы передаём данные о том, какое число нам выпало и выводим его на ячейки;
        resultLabelOne.setText(numberOne + "");
        resultLabelTwo.setText(numberTwo + "");
        resultLabelThree.setText(numberThree + "");

        // При получении хотя бы одной 7-рки
       if (numberOne == 7 || numberTwo == 7 || numberThree == 7)
       {   victory++;
           Alert alert = new Alert(Alert.AlertType.WARNING);
           alert.setTitle("AH YES!");
           alert.setHeaderText("YOU WIN!");
           alert.setContentText("'Cause u have lucky SEVEN!");
           alert.showAndWait();
           labelVictory.setText("Побед: " + victory);
           resImage.setImage(new Image("C:/Users/Krapivin2021/IdeaProjects/luckySeven/victory.png"));

           // При получении всех трёх 7-рок;
           if (numberOne == 7 && numberTwo == 7 && numberThree == 7)
           {   victory++;
               Alert alert1 = new Alert(Alert.AlertType.WARNING);
               resImage.setImage(new Image(""));
               alert1.setTitle("OMG!");
               alert1.setHeaderText("JACKPOT MY FRINED!");
               alert1.setContentText("THREE LUCKY SEVEN IN A RAW!");
               alert1.showAndWait();
               labelVictory.setText("Побед:" + victory);
               resImage.setImage(new Image("C:/Users/Krapivin2021/IdeaProjects/luckySeven/victory.png"));
           }
       }
       else resImage.setImage(new Image("C:/Users/Krapivin2021/IdeaProjects/luckySeven/lose.png"));

       saveTxt(); // Сохранение в TXT
   }

   private void saveTxt() {
       try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
           writer.write(clicked + "\n");
           writer.write(victory + "\n");
       } catch (IOException ex) {
           throw new RuntimeException(ex);
       }
   }
       private void readTxt() {
           if (file.exists())
            try (BufferedReader reader = new BufferedReader(new FileReader(file)))
            {
                clicked =  Integer.parseInt(reader.readLine());
                victory =  Integer.parseInt(reader.readLine());
           } catch (IOException ex) {
               throw new RuntimeException(ex);
           }
    }
    public void initialize (){
        readTxt();
    }

}
