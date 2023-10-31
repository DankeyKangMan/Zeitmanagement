package com.example.zeitmanagement;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.util.converter.LocalDateTimeStringConverter;

import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

import static java.time.temporal.ChronoUnit.MINUTES;

public class Main_Menu_Scene_Controller  {

        @FXML
        private Button Ausstempeln;

        @FXML
        private DatePicker DatePicker;

        @FXML
        private Button Einstempeln;

        @FXML
        private Label myLabel;

        private LocalDate myDate; // Declare myDate as a field
        private LocalTime myTime_in; // zeit wann eingestempelt
        private LocalTime myTime_out; // zeit wann eingestempelt
        private LocalTime myTime_in_formatted; // zeit wann eingestempelt
        private LocalTime myTime_out_formatted; // zeit wann eingestempelt

        @FXML
        void Eingestempelt(MouseEvent event) {

                myTime_in = LocalTime.now();

                //System.out.println(myTime_in);

                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");

                String myTime_in_formatted = formatter.format(myTime_in);

                //System.out.println(myTime_in_formatted);

        }

        @FXML
        void Ausgestempelt(MouseEvent event) {
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

                float elapsedSeconds = Duration.between(myTimeIn, myTimeOut).toSeconds();
                System.out.println(elapsedSeconds/60);

        }

        @FXML
        void myDate(ActionEvent event) {

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

        @FXML
        void onHelloButtonClick(ActionEvent event) {

                if(myDate == null){
                        System.out.println("Bitte Datum wählen");
                }
                else{
                        System.out.println("Datum gewählt");
                }

        }

}



