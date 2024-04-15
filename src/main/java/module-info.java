module com.example.luckyseven {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.luckyseven to javafx.fxml;
    exports com.example.luckyseven;
    exports com.example.luckyseven.controller;
    opens com.example.luckyseven.controller to javafx.fxml;
}