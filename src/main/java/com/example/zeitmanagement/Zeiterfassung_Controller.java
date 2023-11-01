package com.example.zeitmanagement;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import static java.time.temporal.ChronoUnit.MINUTES;

public class Zeiterfassung_Controller  {

    @FXML
    private Button Ausstempeln;

    @FXML
    private javafx.scene.control.DatePicker DatePicker;

    @FXML
    private Button Einstempeln;

    @FXML
    private Label myLabel;

    @FXML
    private Label TimeWorkedTodayLabel;

    @FXML
    private Button Logout;

    @FXML
    private Label labelAusstempelZeit;

    @FXML
    private Label labelEinstempelZeit;

    @FXML
    private ProgressIndicator ZeiterfassungGrafik;


    private LocalDate myDate; // Declare myDate as a field
    private LocalTime myTime_in; // zeit wann eingestempelt
    private LocalTime myTime_out; // zeit wann eingestempelt
    private LocalTime myTime_in_formatted; // zeit wann eingestempelt
    private LocalTime myTime_out_formatted; // zeit wann eingestempelt
    float elapsedSeconds;

    @FXML
    void Eingestempelt() {

        myTime_in = LocalTime.now();

        //System.out.println(myTime_in);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");

        String myTime_in_formatted = formatter.format(myTime_in);

        labelEinstempelZeit.setText(myTime_in_formatted);

    }

    @FXML
    void Ausgestempelt() {
        myTime_out = LocalTime.now();

        //System.out.println(myTime_out);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");

        //-----------------

        String myTime_in_formatted = formatter.format(myTime_in);

        System.out.print("IN:  ");
        System.out.println(myTime_in_formatted);

        //-----------------

        String myTime_out_formatted = formatter.format(myTime_out);

        System.out.print("Out: ");
        System.out.println(myTime_out_formatted);


        //-----------------------------------

        System.out.println(myTime_in_formatted.getClass().getName());
        System.out.println(myTime_out_formatted.getClass().getName());

        //-----------------------------------

        LocalTime myTimeIn = LocalTime.parse(myTime_in_formatted, DateTimeFormatter.ofPattern("HH:mm:ss"));
        LocalTime myTimeOut = LocalTime.parse(myTime_out_formatted, DateTimeFormatter.ofPattern("HH:mm:ss"));

        //-----------------------------------

        System.out.println(myTimeIn.getClass().getName());
        System.out.println(myTimeOut.getClass().getName());

        //-----------------------------------

        System.out.println(MINUTES.between(myTimeIn, myTimeOut));

        elapsedSeconds += Duration.between(myTimeIn, myTimeOut).toSeconds();
        System.out.println(elapsedSeconds/60);

        labelAusstempelZeit.setText(myTime_out_formatted);


        TimeWorkedToday();
        ZeiterfassungGrafikAktualisieren();
    }


    @FXML
    void TimeWorkedToday(){

        int elapsedHours = (int)elapsedSeconds / 3600;
        int elapsedMinutes = ((int)elapsedSeconds % 3600) / 60;

        TimeWorkedTodayLabel.setText("Heute gearbeitet: " + elapsedHours + " Stunden und " + elapsedMinutes + " Minuten");
    }


    @FXML
    void myDate() {

        LocalDate myDate = DatePicker.getValue();
        System.out.println(myDate.toString());

        ArrayList<String> TagemitEintrag = new ArrayList<String>();
        TagemitEintrag.add("2023-10-10");


        if (TagemitEintrag.contains(String.valueOf(myDate))){
            System.out.println("Datum vorhanden");
            myLabel.setText("Kommen: XX:XX / Gehen: XX:XX / Zeit: XX:XX");
        }
        else {
            System.out.println("Datum nicht vorhanden");
            myLabel.setText("Kein Eintrag Vorhanden");
        }

    }

    private Stage stage;
    private Scene scene;

    @FXML
    private void loadLoginScene(ActionEvent event) throws IOException {


        Parent root = FXMLLoader.load(getClass().getResource("login.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void ZeiterfassungGrafikAktualisieren() {

        // loop und aktuelle Zeit
        float Arbeitszeit = 8;
        float elapsedHours = (elapsedSeconds / 3600);

        float Prozent = elapsedHours/Arbeitszeit;

        System.out.println(Prozent);
        ZeiterfassungGrafik.setProgress(Prozent);
    }

}
