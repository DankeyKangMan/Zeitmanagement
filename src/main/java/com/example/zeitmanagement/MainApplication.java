package com.example.zeitmanagement;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle; //um den oberen Rahmen der Applikation zu entfernen

import java.io.IOException;


public class MainApplication extends Application {
    @Override
    public void start(Stage primaryStage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("login.fxml"));
        //primaryStage.initStyle(StageStyle.UNDECORATED);
        Scene scene = new Scene(fxmlLoader.load());
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {

        //EmployeeReader Idee: Von Hier
        /*EmployeeReader employeeReader = new EmployeeReader();
        List<Employee> employees = employeeReader.readEmployeesFromTextFile("path/to/employees.txt");

        // Now, you have a list of Employee objects with data from the text file
        for (Employee employee : employees) {
            System.out.println("Name: " + employee.getName());
            System.out.println("Password: " + employee.getPassword());
            System.out.println("Employee ID: " + employee.getEmployeeID());
        }*/
        //Bis Hier

        launch();
    }
}