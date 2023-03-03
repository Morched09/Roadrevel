/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.Roadrevel.test;

import com.Roadrevel.service.* ;
import com.Roadrevel.entite.*;

/**
 *
 * @author GAMING A15
 */
public class Roadrevel {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        ServiceReport r = new ServiceReport();
        ServicesEvents e = new ServicesEvents();
        r.ajouter(new Report("sam","i get hitten buy a tree","place","aaaaaaa","aaaaaaa","aaaaaaaaa"));
        
        //e.supprimer(new Events("new"));
        //System.out.println(r.afficher());
    
    }
    
}
