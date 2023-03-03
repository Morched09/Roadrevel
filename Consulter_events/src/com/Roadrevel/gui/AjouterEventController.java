/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.Roadrevel.gui;

import com.Roadrevel.utils.DataSource;
import com.Roadrevel.service.*;
import com.Roadrevel.entite.Events;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseDragEvent;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javax.swing.JOptionPane;


/**
 * FXML Controller class
 *
 * @author GAMING A15
 */
public class AjouterEventController implements Initializable {

     private Connection cnx = null;
     private PreparedStatement pst = null;
     ResultSet result = null;
     private ObservableList<Events> data;
    
    @FXML
    private TextField nom;
    @FXML
    private TextField emplacement;
    @FXML
    private TextArea description;
    @FXML
    private Button ajouter;
    @FXML
    private TableView<Events> evenement;
    @FXML
    private TableColumn<Events, String> colNom;
    @FXML
    private TableColumn<Events, String> colEmp;
    @FXML
    private TableColumn<Events, String> colDes;
    @FXML
    private Button update;
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
    
    @FXML
    private void Ajout(ActionEvent event) throws IOException, SQLException{
 
        
        String Event_name = nom.getText();
        String Location = emplacement.getText();
        String Event_description = description.getText();
        
        if (Event_name.isEmpty() || Location.isEmpty() || Event_description.isEmpty() ){
            
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText("Erreur");
            alert.setContentText("tous les chapms doit etre remplir");
            alert.showAndWait();
            
        }else{
            ServicesEvents e = new ServicesEvents();
        e.ajouter(new Events(nom.getText(), emplacement.getText(), description.getText() ));
        JOptionPane.showMessageDialog(null, "evenement ajoutée !");
        nom.clear();
        emplacement.clear();
        description.clear();
        }
        
        
        }
     @FXML
    public void SetCell(){
        
       //SetData();
        colNom.setCellValueFactory(new PropertyValueFactory<>("Event_name"));
        colEmp.setCellValueFactory(new PropertyValueFactory<>("Location"));
        colDes.setCellValueFactory(new PropertyValueFactory<>("Event_description"));
        
        
    
}
    
    public void SetData() {
         
        try {
            //data.clear();
             pst = cnx.prepareStatement("SELECT * FROM evenement");
             result = pst.executeQuery();
             
             while (result.next()){
                  data.add(new Events( result.getString("Event_name"), result.getString("Location"), result.getString("Event_description")));
                  evenement.setItems(data);
                  
             }
         } catch (SQLException ex) {
             System.out.println(ex.getMessage());
         } 
        
    }

    @FXML
    private void update(ActionEvent event) throws IOException{
    
    }
    @FXML
    public void Refresh(){
        data.clear();
         try {
            //data.clear();
             pst = cnx.prepareStatement("SELECT * FROM evenement");
             result = pst.executeQuery();
             
             while (result.next()){
                  data.add(new Events( result.getString("Event_name"), result.getString("Location"), result.getString("Event_description")));
                  evenement.setItems(data);
                  
             }
         } catch (SQLException ex) {
             System.out.println(ex.getMessage());
         } 
         
    }
        
        
         
        
    }

    


   

    
    
    
    


    
    

