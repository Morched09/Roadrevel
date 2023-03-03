/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Roadrevel.entite;

//import java.util.Date;
import java.util.Objects;

/**
 *
 * @author GAMING A15
 */
public class Report {
    
    private int Report_id;
    private String Tourist_name;
    private String Report_subject;
    private String Type;
    private String Report_description;
    private String involvment;
    private String incident_location;

    public Report() {
    }
    
    
    
     public Report(String Tourist_name) {
        this.Tourist_name = Tourist_name;
    }

    public Report(int Report_id, String Tourist_name, String Report_subject, String Type, String Report_description, String involvment, String incident_location) {
        this.Report_id = Report_id;
        this.Tourist_name = Tourist_name;
        this.Report_subject = Report_subject;
        this.Type = Type;
        this.Report_description = Report_description;
        this.involvment = involvment;
        this.incident_location = incident_location;
    }

    public Report(String Tourist_name, String Report_subject, String Type, String Report_description, String involvment, String incident_location) {
        this.Tourist_name = Tourist_name;
        this.Report_subject = Report_subject;
        this.Type = Type;
        this.Report_description = Report_description;
        this.involvment = involvment;
        this.incident_location = incident_location;
        
        
    }

   

    public int getReport_id() {
        return Report_id;
    }

    public void setReport_id(int Report_id) {
        this.Report_id = Report_id;
    }

    public String getTourist_name() {
        return Tourist_name;
    }

    public void setTourist_name(String Tourist_name) {
        this.Tourist_name = Tourist_name;
    }

    public String getReport_subject() {
        return Report_subject;
    }

    public void setReport_subject(String Report_subject) {
        this.Report_subject = Report_subject;
    }

    public String getType() {
        return Type;
    }

    public void setType(String Type) {
        this.Type = Type;
    }

    public String getReport_description() {
        return Report_description;
    }

    public void setReport_description(String Report_description) {
        this.Report_description = Report_description;
    }

    public String getInvolvment() {
        return involvment;
    }

    public void setInvolvment(String involvment) {
        this.involvment = involvment;
    }

    public String getIncident_location() {
        return incident_location;
    }

    public void setIncident_location(String incident_location) {
        this.incident_location = incident_location;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 23 * hash + this.Report_id;
        hash = 23 * hash + Objects.hashCode(this.Tourist_name);
        hash = 23 * hash + Objects.hashCode(this.Report_subject);
        hash = 23 * hash + Objects.hashCode(this.Type);
        hash = 23 * hash + Objects.hashCode(this.Report_description);
        hash = 23 * hash + Objects.hashCode(this.involvment);
        hash = 23 * hash + Objects.hashCode(this.incident_location);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Report other = (Report) obj;
        if (!Objects.equals(this.Tourist_name, other.Tourist_name)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Report{" + "Report_id=" + Report_id + ", Tourist_name=" + Tourist_name + ", Report_subject=" + Report_subject + ", Type=" + Type + ", Report_description=" + Report_description + ", involvment=" + involvment + ", incident_location=" + incident_location + '}';
    }
        

    
    
   
    }

    
    

    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    

