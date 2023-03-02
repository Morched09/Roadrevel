/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Roadrevel.service;
import com.Roadrevel.entite.Events;
import com.Roadrevel.utils.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author GAMING A15
 */
public class ServicesEvents implements IService<Events> {
    
    
    private Connection cnx = DataSource.getInstance().getCnx();
    
    @Override
    public void ajouter(Events e) {
        String req = "INSERT INTO evenement(Event_name, Location, Event_description) VALUES(?, ?, ?);";
        try {
            //Statement st = cnx.createStatement();
            PreparedStatement pst = cnx.prepareStatement(req);
            pst.setString(1, e.getEvent_name());
            pst.setString(3, e.getEvent_description());
            pst.setString(2, e.getLocation());
            
            pst.executeUpdate();
            System.out.println("event ajoutée !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    @Override
    public void modifier(Events e) {
        String req = "UPDATE  evenement SET  Location= ?, Event_description= ? WHERE getEvent_name=?";
        try {
            PreparedStatement pst = cnx.prepareStatement(req);
            
            pst.setString(3, e.getEvent_name());
            pst.setString(1, e.getLocation());
            pst.setString(2, e.getEvent_description());
            
            pst.executeUpdate();
            System.out.println("event modifiée !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    
    @Override
    public void supprimer(Events e) {
        String req = "DELETE FROM evenement WHERE Event_name=?";
        try {
            PreparedStatement pst = cnx.prepareStatement(req);
            pst.setString(1, e.getEvent_name());
            pst.executeUpdate();
            System.out.println("event supprimée !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public List<Events> afficher() {
        List<Events> list = new ArrayList<>();
        
        String req = "SELECT * FROM evenement";
        try {
            PreparedStatement pst = cnx.prepareStatement(req);
            ResultSet result = pst.executeQuery();
            while(result.next()) {
                list.add(new Events(result.getInt("Event_id"), result.getString("Event_name"), result.getString("Location"), result.getString("Event_description"),  result.getString("Event_pic1"), result.getString("Event_pic2"),result.getString("Event_pic3")));
            }
            System.out.println("event récupérées !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        
        return list;
    }

    
    
    
}
