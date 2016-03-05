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
public class Answer implements Serializable {
    private String email;
    private int choice;
    private String DateSubmitted;
    
    public Answer(){
        
    }
    
    public Answer(String email, int choice) {
        this.email = email;
        this.choice = choice;
        this.DateSubmitted = DateSubmitted;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getChoice() {
        return choice;
    }

    public void setChoice(int choice) {
        this.choice = choice;
    }

   
}
