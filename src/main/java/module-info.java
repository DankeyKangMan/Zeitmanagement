module com.example.loginappv4 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.zeitmanagement to javafx.fxml;
    exports com.example.zeitmanagement;
}