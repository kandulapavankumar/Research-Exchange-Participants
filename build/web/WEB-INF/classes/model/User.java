/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;

/**
 *
 * @author Varun Amin
 */
public class User implements Serializable{
 
    private String name;
    private String email;
    public String password;
    private int coins;
    private int participants;
    private int participation;

    public User(){
        
    }

    public User(String name, String email, int coins, int participants, int participation) {
        this.name = name;
        this.email = email;
        this.coins = coins;
        this.participants = participants;
        this.participation = participation;
    }
   
    
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
     public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getCoins() {
        return coins;
    }

    public void setCoins(int coins) {
        this.coins = coins;
    }

    public int getParticipants() {
        return participants;
    }

    public void setParticipants(int participants) {
        this.participants = participants;
    }

    public int getParticipation() {
        return participation;
    }

    public void setParticipation(int participation) {
        this.participation = participation;
    }
    
    
}
