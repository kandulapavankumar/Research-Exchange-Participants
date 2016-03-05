/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Varun Amin
 */
public class Study implements Serializable {
 
    private String name;
    private String code;
    private String Datecreated;
    public String Email;
    public  String question;
    private String requestedparticipants;
    private String numberofparticipants;
    private String description;
    private String status;
    private String getImage;
    private String collection;
    private ArrayList<Answer> answers = new ArrayList<Answer>();
   
    
    public Study(String name, String code, String Datecreated, String Email, String question, String requestedparticipants, String numberofparticipants, String description, String status, String getImage, String collection) {

        this.name = name;
        this.code = code;
     
        this.Email = Email;
        this.question = question;
        this.requestedparticipants = requestedparticipants;
        this.numberofparticipants = numberofparticipants;
        this.description = description;
        this.status = status;
        this.getImage = code+".jpg";
        this.collection= collection;
    }

   public Study()
   {}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDatecreated() {
        return Datecreated;
    }

    public void setDatecreated(String Datecreated) {
        this.Datecreated = Datecreated;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getGetImage() {
        return getImage;
    }

    public void setGetImage(String getImage) {
        this.getImage = getImage;
    }

    public String getRequestedparticipants() {
        return requestedparticipants;
    }

    public void setRequestedparticipants(String requestedparticipants) {
        this.requestedparticipants = requestedparticipants;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getNumberofparticipants() {
        return numberofparticipants;
    }

    public void setNumberofparticipants(String numberofparticipants) {
        this.numberofparticipants = numberofparticipants;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCollection() {
        return collection;
    }

    public void setCollection(String collection) {
        this.collection = collection;
    }

    public ArrayList<Answer> getAnswers() {
        return answers;
    }

    public void setAnswers(ArrayList<Answer> answers) {
        this.answers = answers;
    }
    
    public void addAnswer(Answer answer){
        answers.add(answer);
    }
    
    public double getAverage(){
        double average=0;
        for(Answer answer:answers){
            average+=answer.getChoice();
        }
        average=average/answers.size();
        return average;
    }
    
    public int getMinimum(){
        int min =answers.get(0).getChoice();
        for(Answer answer:answers){
            if(min>answer.getChoice()){
                min = answer.getChoice();
            }
        }
        return min;
    }
    
    public int getMaximum(){
        int max =answers.get(0).getChoice();
        for(Answer answer:answers){
            if(max<answer.getChoice()){
                max = answer.getChoice();
            }
        }
        return max;
    }
    
    public double getSD(){
        double average = getAverage();
        double standarddeviation=0;
        for(Answer answer:answers){
            standarddeviation += Math.pow((average-answer.getChoice()),2);
        }
        standarddeviation = standarddeviation/answers.size();
        standarddeviation = Math.sqrt(standarddeviation);
        return standarddeviation;
    }
    

    
}
