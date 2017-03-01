/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.util.Random;

/**
 *
 * @author ChiNguyen
 */
public class RandomNumber {
    private static int authenticationNumber;
    
    

    public static int getAuthenticationNumber() {
        return authenticationNumber;
    }
    
    public static int generateNumber() {
        authenticationNumber = 100000 + (new Random()).nextInt(899999);
        return authenticationNumber;
    }    
    
}
