/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import java.io.File;
import java.io.Serializable;

/**
 *
 * @author Marcos
 */
public class Plant implements Serializable{
    String name;
    String owner;
    String type;
    String site;
    int watering;
    File pict;
    
    public Plant(String na, String ow, String ty, String si, int wat, File pic){
        name = na;
        owner = ow;
        type = ty;
        site = si;
        watering = wat;
        pict = pic;
    }
    
    public String toString(){
        return "The plant " + name + " from " + owner + " that is located in " + site + " and its type is " + type + " needs a watering of "
                + watering + "days per week.";
    }
}
