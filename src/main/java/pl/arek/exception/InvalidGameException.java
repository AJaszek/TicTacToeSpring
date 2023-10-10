/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pl.arek.exception;

/**
 *
 * @author Arek
 */
public class InvalidGameException extends Exception{
    
    private String message;
    
    public InvalidGameException(String message){
        this.message = message;
    }
    
    public String getMessage(){
        return this.message;
    }
    
}