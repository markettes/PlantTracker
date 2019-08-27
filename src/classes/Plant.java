/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import java.io.File;

/**
 *
 * @author Marcos
 */
public class Plant {
    String owner;
    String type;
    String site;
    int watering;
    File pict;
    
    public Plant(String ow, String ty, String si, int wat, File pic){
        owner = ow;
        type = ty;
        site = si;
        watering = wat;
        pict = pic;
    }
}
