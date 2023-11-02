module com.example.loginappv4 {
    requires javafx.controls;
    requires javafx.fxml;
    requires org.mongodb.driver.core;
    requires org.mongodb.driver.sync.client;
    requires org.mongodb.bson;


    opens com.example.zeitmanagement to javafx.fxml;
    exports com.example.zeitmanagement;
}