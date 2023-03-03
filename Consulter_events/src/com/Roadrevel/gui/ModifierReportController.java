/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.Roadrevel.gui;


import com.Roadrevel.entite.Report;
import com.Roadrevel.service.ServiceReport;
import com.Roadrevel.utils.DataSource;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author GAMING A15
 */
public class ModifierReportController implements Initializable {

    
    private Connection cnx = null;
    private PreparedStatement pst = null;
    ResultSet result = null;
    private ObservableList<Report> data;
    @FXML
    private TextField tfTourist_name;
    @FXML
    private TextField tfReport_subject;
    @FXML
    private TextField tfInvolvment;
    @FXML
    private TextField tfincident_location;
    @FXML
    private TextArea taReport_description;
    @FXML
    private TableColumn<Report, String> col_tfTourist_name;
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
    private Button update;
    @FXML
    private Button clear;
    private TableView<Report> report;
    @FXML
    private Button refresh;
    @FXML
    private TextField report_sup;
    
    @FXML
    private TextField tfType;
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        cnx = DataSource.getInstance().getCnx();
         data = FXCollections.observableArrayList();
         SetCell();
         setData();
    }    

    @FXML
    private void update(ActionEvent event) throws SQLException {
         String req = "UPDATE  report SET Report_subject= ? , Type=? Report_description= ? ,Involvment= ? ,Incident_location=?  WHERE Tourist_name=?";
        try{
            
                PreparedStatement pst = cnx.prepareStatement(req);
                pst.setString(5, tfTourist_name.getText());
                pst.setString(1, tfReport_subject.getText());
                pst.setString(2, tfType.getText());
                pst.setString(2, taReport_description.getText());
                pst.setString(3, tfInvolvment.getText());
                pst.setString(4, tfincident_location.getText());
                pst.executeUpdate();
                JOptionPane.showMessageDialog(null, "report modifiée !");
                System.out.println("report modifiée !");
                
        }catch(Exception e){
            e.printStackTrace();
                }
        }
        
        
    

    @FXML
    private void clear(ActionEvent event) throws SQLException {
      
        ServiceReport r = new ServiceReport();
        r.supprimer(new Report(report_sup.getText()));
        JOptionPane.showMessageDialog(null, "report suprimer !");
        report_sup.clear();
    }
    
    
    public void setData() {
         
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
        //ObservableList<Report> list = SetData();
       //SetData();
        col_tfTourist_name.setCellValueFactory(new PropertyValueFactory<>("Tourist_name"));
        coltfReport_subject.setCellValueFactory(new PropertyValueFactory<>("Report_subject"));
        col_tfType.setCellValueFactory(new PropertyValueFactory<>("Type"));
        coltfincident_location.setCellValueFactory(new PropertyValueFactory<>("incident_location"));
        coltfInvolvment.setCellValueFactory(new PropertyValueFactory<>("involvment"));
        coltaReport_description.setCellValueFactory(new PropertyValueFactory<>("Report_description"));
        report.setItems(data);
    }

    @FXML
    private void Refresh(ActionEvent event) {
        data.clear();
        
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
    
    
    
 
}
