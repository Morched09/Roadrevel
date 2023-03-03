/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Roadrevel.service;
import com.Roadrevel.entite.Report;
import com.Roadrevel.utils.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author GAMING A15
 */
public class ServiceReport implements IService<Report>{
    private Connection cnx = DataSource.getInstance().getCnx();



@Override
    public void ajouter(Report r) {
        String req = "INSERT INTO report( Tourist_name, Report_subject, Type, Report_description, Involvment,  Incident_location  ) VALUES(?, ?, ?, ?, ?,?);";
        try {
            //Statement st = cnx.createStatement();
            PreparedStatement pst = cnx.prepareStatement(req);
            pst.setString(1, r.getTourist_name());
            pst.setString(2, r.getReport_subject());
            pst.setString(3, r.getType());
            pst.setString(4, r.getReport_description());
            pst.setString(5, r.getInvolvment());
            pst.setString(6, r.getIncident_location());
            
            pst.executeUpdate();
            System.out.println("report ajoutée !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
        
    @Override
    public void modifier(Report r) {
        String req = "UPDATE  report SET Report_subject= ? , Type=?,  Report_description= ? ,Involvment= ? ,Incident_location=?  WHERE Tourist_name=?";
        try {
            PreparedStatement pst = cnx.prepareStatement(req);
            pst.setString(6, r.getTourist_name());
            pst.setString(1, r.getReport_subject());
            pst.setString(2, r.getType());
            pst.setString(3, r.getReport_description());
            pst.setString(4, r.getInvolvment());
            pst.setString(5, r.getIncident_location());
            
            pst.executeUpdate();
            System.out.println("report modifiée !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    @Override
    public void supprimer(Report r) {
        String req = "DELETE FROM report WHERE Tourist_name=?";
        try {
            PreparedStatement pst = cnx.prepareStatement(req);
            pst.setString(1, r.getTourist_name());
            pst.executeUpdate();
            System.out.println("report supprimée !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public List<Report> afficher() {
        List<Report> list = new ArrayList<>();
        
        String req = "SELECT * FROM report";
        try {
            PreparedStatement pst = cnx.prepareStatement(req);
            ResultSet result = pst.executeQuery();
            while(result.next()) {
                list.add(new Report( result.getString("Tourist_name"), result.getString("Report_subject"),result.getString("Type"), result.getString("Report_description"), result.getString("Involvment"), result.getString("Incident_location")));
            }
            System.out.println("report récupérées !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        
        return list;
    }
    
    
    
    
}
