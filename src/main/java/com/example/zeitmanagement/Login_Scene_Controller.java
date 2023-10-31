package com.example.zeitmanagement;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.PasswordField;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Login_Scene_Controller {

    public Button loginButton;
    @FXML
    private Button cancelButton;
    @FXML
    private Label loginMessageLabel;
    @FXML
    private TextField usernameTextField;
    @FXML
    private PasswordField passwordPasswordField;

    private final List<Employee> employees = new ArrayList<>();

    public Login_Scene_Controller() {
        // Initialize the list with some employee data (replace with your data)
        employees.add(new Employee("Emre", "123", 101));
        employees.add(new Employee("Alice Smith", "mysecret", 102));
        employees.add(new Employee("Bob Johnson", "abc123", 103));
    }

    public void loginButtonAction() throws IOException {
        String enteredName = usernameTextField.getText();
        String enteredPassword = passwordPasswordField.getText();

        // Check the credentials
        Employee authenticatedEmployee = null;
        for (Employee employee : employees) {
            if (employee.getName().equals(enteredName) && employee.getPassword().equals(enteredPassword)) {
                authenticatedEmployee = employee;
                break; // Exit the loop on successful login
            }
        }

        // Successful login
        // Perform any actions you want on successful login
        if (authenticatedEmployee != null) loadGerippeScene();

        else if (!usernameTextField.getText().isBlank() && !passwordPasswordField.getText().isBlank()) {
            loginMessageLabel.setText("Invalid username or password!");
        } else {
            loginMessageLabel.setText("Please enter username and password.");
        }
    }

    public void cancelButtonAction() {
        Stage stage = (Stage) cancelButton.getScene().getWindow();
        stage.close();
    }


    @FXML
    private void loadMenuScene() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("main-menu-scene.fxml"));
        Scene scene = new Scene(loader.load());
        Stage stage = (Stage) loginMessageLabel.getScene().getWindow(); // Get the current stage
        stage.setScene(scene);
    }

    @FXML
    private void loadGerippeScene() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Scenengerippe.fxml"));
        Scene scene = new Scene(loader.load());
        Stage stage = (Stage) loginMessageLabel.getScene().getWindow(); // Get the current stage
        stage.setScene(scene);
    }
}

