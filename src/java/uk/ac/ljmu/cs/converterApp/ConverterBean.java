package uk.ac.ljmu.cs.converterApp;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

@Named(value = "converterBean")
@SessionScoped
public class ConverterBean implements Serializable {

    //Properties
    private double gb;
    private double mb;
    
    //Constructor
    public ConverterBean() {
        this.gb = 0;
        this.mb = 0;
    }

    //Converter function
    public void convertMe(){
        
        //Load contextual info of current request/response
        FacesContext context = FacesContext.getCurrentInstance();
        
        //Check if both values are not 0 - nothing to convert
        if(gb <= 0 && mb <=0){
            //Return with faces error msg
             context.addMessage(null, new FacesMessage("Error: Both fields cannot be empty."));
             //Stop execution of function
             return;
        }
        //Check if both values are not > 0 - don't know what to convert
        if(gb > 0 && mb > 0){
            //Return with faces error msg
            context.addMessage(null, new FacesMessage("Error: One field should be empty."));
            //Stop execution of function
            return;
        }
                 
        //Check if it is GB that needs converting
        if(gb > 0){
            mb = gb * 1024;
        }
        //Check if it is MB that needs converting
        else if(mb > 0){
            gb = mb / 1024;
        }
    }
    
    //Getters and Setters
    public double getMb() {
        return mb;
    }

    public void setMb(double userChoice) {
        this.mb = userChoice;
    }
    
    public double getGb() {
        return gb;
    }

    public void setGb(double userChoice) {
        this.gb = userChoice;
    }
}
