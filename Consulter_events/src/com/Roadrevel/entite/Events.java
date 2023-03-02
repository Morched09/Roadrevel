/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Roadrevel.entite;

import java.util.Objects;

/**
 *
 * @author GAMING A15
 */
public class Events {

    private int Event_id;
    private String Event_name;
    private String Event_description;
    private String Location;
    private String Event_pic1;
    private String Event_pic2;
    private String Event_pic3;

    public Events() {
    }

    public Events(String Event_name) {
        this.Event_name = Event_name;
    }
    
    

    public Events(int Event_id) {
        this.Event_id = Event_id;
    }

    public Events(String Event_name, String Location, String Event_description) {
        this.Event_name = Event_name;
        this.Event_description = Event_description;
        this.Location=Location;

    }

    public Events(String Event_name, String Event_description, String Location, String Event_pic1, String Event_pic2, String Event_pic3) {
        this.Event_name = Event_name;
        this.Event_description = Event_description;
        this.Location = Location;
        this.Event_pic1 = Event_pic1;
        this.Event_pic2 = Event_pic2;
        this.Event_pic3 = Event_pic3;
    }
    
    public Events(int Event_id, String Event_name, String Location, String Event_description, String Event_pic1, String Event_pic2, String Event_pic3) {
        this.Event_id = Event_id;
        this.Event_name = Event_name;
        this.Location = Location;
        this.Event_description = Event_description;
        this.Event_pic1 = Event_pic1;
        this.Event_pic2 = Event_pic2;
        this.Event_pic3 = Event_pic3;
    }

    public int getEvent_id() {
        return Event_id;
    }

    public void setEvent_id(int Event_id) {
        this.Event_id = Event_id;
    }

    public String getEvent_name() {
        return Event_name;
    }

    public void setEvent_name(String Event_name) {
        this.Event_name = Event_name;
    }

    public String getEvent_description() {
        return Event_description;
    }

    public void setEvent_description(String Event_description) {
        this.Event_description = Event_description;
    }

    public String getEvent_pic1() {
        return Event_pic1;
    }

    public void setEvent_pic1(String Event_pic1) {
        this.Event_pic1 = Event_pic1;
    }

    public String getEvent_pic2() {
        return Event_pic2;
    }

    public void setEvent_pic2(String Event_pic2) {
        this.Event_pic2 = Event_pic2;
    }

    public String getEvent_pic3() {
        return Event_pic3;
    }

    public void setEvent_pic3(String Event_pic3) {
        this.Event_pic3 = Event_pic3;
    }

    public String getLocation() {
        return Location;
    }

    public void setLocation(String Location) {
        this.Location = Location;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 97 * hash + this.Event_id;
        hash = 97 * hash + Objects.hashCode(this.Event_name);
        hash = 97 * hash + Objects.hashCode(this.Event_description);
        hash = 97 * hash + Objects.hashCode(this.Location);
        hash = 97 * hash + Objects.hashCode(this.Event_pic1);
        hash = 97 * hash + Objects.hashCode(this.Event_pic2);
        hash = 97 * hash + Objects.hashCode(this.Event_pic3);
        return hash;
    }

    
   

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Events other = (Events) obj;
        return Objects.equals(this.Event_name, other.Event_name);
    }

    @Override
    public String toString() {
        return "Events{" + "Event_id=" + Event_id + ", Event_name=" + Event_name + ", Event_description=" + Event_description + ", Location=" + Location + ", Event_pic1=" + Event_pic1 + ", Event_pic2=" + Event_pic2 + ", Event_pic3=" + Event_pic3 + '}';
    }

    

}


