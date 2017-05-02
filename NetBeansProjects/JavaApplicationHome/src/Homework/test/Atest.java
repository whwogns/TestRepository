/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Homework.test;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Administrator
 */
public class Atest {
    String value="bbbbbb";
    
    @Override
    public boolean equals(Object obj) {
        return 1==1;
    }

    @Override
    public int hashCode() {
        return 1;
        
    }

    @Override
    public String toString() {
        return value; //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
    
    public static void main(String[] args) {
        int a=10;
        if(a==10){
            try {
                throw new aaaException("aaaaagggglsdkjalskdgl");
            } catch (aaaException ex) {
                ex.printStackTrace();
            }
        }
    }
}
