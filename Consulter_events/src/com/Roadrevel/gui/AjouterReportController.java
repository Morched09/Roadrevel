/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.Roadrevel.gui;

import com.Roadrevel.entite.Report;
import com.Roadrevel.service.ServiceReport;
import com.Roadrevel.utils.DataSource;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.input.TouchEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.control.TextArea;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author GAMING A15
 */
public class AjouterReportController implements Initializable {

    private Connection cnx = null;
     private PreparedStatement pst = null;
     ResultSet result = null;
     private ObservableList<Report> data;
    @FXML
    private TextField tfReport_subject;
    @FXML
    private TextField tfType;
    @FXML
    private TextField tfTourist_name;
    @FXML
    private TextArea taReport_description;
    @FXML
    private TextField tfInvolvment;
    @FXML
    private TextField tfincident_location;
    @FXML
    private Button Ajouter;
    private TableView<Report> report;
    @FXML
    private TableColumn<Report, String> col_tfTourist_name;
    @FXML
    private TableColumn<Report, String> coltfReport_subject;
    @FXML
    private TableColumn<Report, String> coltfincident_location;
    @FXML
    private TableColumn<Report, String> coltfInvolvment;
    @FXML
    private TableColumn<Report, String> coltaReport_description;
    @FXML
    private TableColumn<Report, String> col_tfType;
    @FXML
    private Button refresh;
    
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        cnx = DataSource.getInstance().getCnx();
         data = FXCollections.observableArrayList();
         SetCell();
         SetData();
    }    
    private void AjouterReport (ActionEvent events)throws IOException{
   
}
    

    @FXML
    private void AjoutR(ActionEvent event) {
        
        String Tourist_name = tfTourist_name.getText();
        String Report_subject = tfReport_subject.getText();
        String Type=tfType.getText();
        String Report_description = taReport_description.getText();
        String Involvment = tfInvolvment.getText();
        String incident_location = tfincident_location.getText();
        if (Tourist_name.isEmpty() || Report_subject.isEmpty() || Type.isEmpty() || Report_description.isEmpty() ||Involvment.isEmpty() ||incident_location.isEmpty() ){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setContentText("tous les chapms doit etre remplir");
            alert.showAndWait();
            
        }else {
        ServiceReport r = new ServiceReport();
        r.ajouter(new Report(tfTourist_name.getText(),tfReport_subject.getText(), tfType.getText(), taReport_description.getText(),tfInvolvment.getText(),tfincident_location.getText()));
        JOptionPane.showMessageDialog(null, "report ajoutée !");
        tfTourist_name.clear();
        tfReport_subject.clear();
        tfType.clear();
        taReport_description.clear();
        tfInvolvment.clear();
        tfincident_location.clear();
        }
        
        

    }

    @FXML
    private void Refresh(ActionEvent event) {
        data.clear();
        try {
             pst = cnx.prepareStatement("SELECT * FROM report");
             result = pst.executeQuery();
             while (result.next()){
                 data.add(new Report( result.getString("Tourist_name"), result.getString("Report_subject"),result.getString("Type"), result.getString("Report_description"), result.getString("Involvment"), result.getString("Incident_location")));                  
             }
         } catch (SQLException ex) {
             System.out.println(ex.getMessage());
         }
        report.setItems(data);
    }
    public void SetData() {
         
        try {
             pst = cnx.prepareStatement("SELECT * FROM report");
             result = pst.executeQuery();
             while (result.next()){
                  data.add(new Report( result.getString("Tourist_name"), result.getString("Report_subject"),result.getString("Type"), result.getString("Report_description"),  result.getString("involvment"), result.getString("incident_location")));
                  
             }
         } catch (SQLException ex) {
             System.out.println(ex.getMessage());
         }
        report.setItems(data);
    }
    
    public void SetCell(){
        
       //SetData();
        col_tfTourist_name.setCellValueFactory(new PropertyValueFactory<>("Tourist_name"));
        coltfReport_subject.setCellValueFactory(new PropertyValueFactory<>("Report_subject"));
        col_tfType.setCellValueFactory(new PropertyValueFactory<>("Type"));
        coltfincident_location.setCellValueFactory(new PropertyValueFactory<>("incident_location"));
        coltfInvolvment.setCellValueFactory(new PropertyValueFactory<>("involvment"));
        coltaReport_description.setCellValueFactory(new PropertyValueFactory<>("Report_description"));
        
    }

}
