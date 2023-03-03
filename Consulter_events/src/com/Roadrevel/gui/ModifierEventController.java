/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.Roadrevel.gui;

import com.Roadrevel.utils.DataSource;
import com.Roadrevel.service.ServicesEvents;
import com.Roadrevel.entite.Events;
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
import javafx.scene.control.Button;
import javafx.scene.control.SortEvent;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.input.MouseEvent;
import javax.swing.JOptionPane;
import javafx.scene.control.cell.*;


/**
 * FXML Controller class
 *
 * @author GAMING A15
 */
public class ModifierEventController implements Initializable {

    @FXML
    private TextField nom;
    @FXML
    private TextField emplacement;
    @FXML
    private TextArea description;
    @FXML
    private Button update;
    @FXML
    private TableView<Events> evenement;
    @FXML
    private TableColumn<Events, String> colNom;
    @FXML
    private TableColumn<Events, String> colEmp;
    @FXML
    private TableColumn<Events, String> colDes;
    
    private Connection cnx = null;
     private PreparedStatement pst = null;
     ResultSet result = null;
     private ObservableList<Events> data;
    @FXML
    private TextField event_sup;
    @FXML
    private Button supprimer;
    @FXML
    private Button refresh;

    /**
     * Initializes the controller class.
     * 
     */
    @Override
    public void initialize(URL url, ResourceBundle rb){
        // TODO
        
        cnx = DataSource.getInstance().getCnx();
         data = FXCollections.observableArrayList();
         SetCell();
         SetData();
         
    }    
    
    
    
    @FXML
    private void update(ActionEvent event) throws SQLException{
        String req = "UPDATE  evenement SET  Location= ?, Event_description= ? WHERE Event_name=?";
        
        try{
            
                PreparedStatement pst = cnx.prepareStatement(req);
                pst.setString(3, nom.getText());
                pst.setString(1, emplacement.getText());
                pst.setString(2, description.getText());
                pst.executeUpdate();
                JOptionPane.showMessageDialog(null, "evenement modifiée !");
                System.out.println("evenement modifiée !");
                
        }catch(Exception e){
            e.printStackTrace();
                }
        }
        
        
        
    
    @FXML
    public void SetCell() {
        
       //SetData();
        colNom.setCellValueFactory(new PropertyValueFactory<>("Event_name"));
        colEmp.setCellValueFactory(new PropertyValueFactory<>("Location"));
        colDes.setCellValueFactory(new PropertyValueFactory<>("Event_description"));
        //int rowsUpdated = pst.executeUpdate();
    
}
    
    public void SetData() {
         String Event_name = nom.getText();
        String Location = emplacement.getText();
        String Event_description = description.getText();
        try {
             pst = cnx.prepareStatement("SELECT * FROM evenement");
             result = pst.executeQuery();
             while (result.next()){
                  data.add(new Events( result.getString("Event_name"), result.getString("Location"), result.getString("Event_description"),  result.getString("Event_pic1"), result.getString("Event_pic2"),result.getString("Event_pic3")));
                  
             }
         } catch (SQLException ex) {
             System.out.println(ex.getMessage());
         }
        evenement.setItems(data);
        
        
            

         
    }

    @FXML
    private void clear(ActionEvent event) {
        ServicesEvents e = new ServicesEvents();
        e.supprimer(new Events(event_sup.getText()));
        JOptionPane.showMessageDialog(null, "evenement suprimer !");
        event_sup.clear();
        
        
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
