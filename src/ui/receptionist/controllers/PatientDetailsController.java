package ui.receptionist.controllers;

import classes.Receptionist;
import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import java.awt.*;
import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.stage.Stage;
import ui.receptionist.ModelTable;
import ui.receptionist.ReceptionistController;

import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;


public class PatientDetailsController implements Initializable {

    @FXML
    private Label detailedNameLabel;
    @FXML
    private Label detailedIDLabel;
    @FXML
    private Label detailedGenderLabel;
    @FXML
    private Label detailedBloodTypeLabel;
    @FXML
    private Label detailedBirthDateLabel;
    @FXML
    private Label detailedAddressLabel;
    @FXML
    private Label detailedPhoneNumber;
    @FXML
    private Label detailedInsurance;
    @FXML
    private Label detailedEmergencyContactName;
    @FXML
    private Label detailedEmergencyContactPhoneNumber;
    @FXML
    private Button backButton;

    public PatientDetailsController(){}

    public void update( String id ) throws SQLException
    {
        int patientKey = database.Database.findPatientKey(id);
        ArrayList<String> infoList = database.Database.patientDetails(patientKey);
        System.out.println(infoList.toString());
        detailedNameLabel.setText(infoList.get(0));
        detailedIDLabel.setText(infoList.get(1));
        detailedGenderLabel.setText(infoList.get(2));
        detailedBirthDateLabel.setText(infoList.get(4));
        detailedBloodTypeLabel.setText(infoList.get(3));
        detailedAddressLabel.setText(infoList.get(5));
        detailedPhoneNumber.setText(infoList.get(6));
        detailedInsurance.setText(infoList.get(7));
        detailedEmergencyContactName.setText(infoList.get(8));
        detailedEmergencyContactPhoneNumber.setText(infoList.get(9));
    }

    @Override
    public void initialize(URL location, ResourceBundle resources)
    {
        try {
            update( "" );
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @FXML private void pageClose(ActionEvent c)
    {
        Stage stage = (Stage) backButton.getScene().getWindow();
        stage.close();
    }

}