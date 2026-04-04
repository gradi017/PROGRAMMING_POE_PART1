/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.part1_poe;


public class Register {
    
    
    static User registeredUser = new User();
    
    static boolean checkUserName(String username){
        if(username.length() > 5 || !username.contains("_")){
            return false;
        }else{
            return true;
        }
    }
    
    static boolean checkPasswordComplexity(String password){
        if(password.length() < 8) {
            return false;
        }
        
        if(password.equals(password.toLowerCase())) {
            return false;
        }
        
        if(!password.matches(".*\\d.*")) {
            return false;
        }   
        else if(!password.matches(".*[!@#$%^&*()_+].*")) {
            return false;
        }else{
            return true;
        }
    }  
    
    static boolean checkCellPhoneNumber(String cellphone){
        if(cellphone.startsWith("+27") && cellphone.length() == 12){
            String numbers = cellphone.substring(3);
            if(numbers.matches("\\d+")){
                return true;
            }
        }
        return false;
    }
    
    static String registerUser(String firstName, String username, String password, String cellphone, String lastName){
        String errors = "";
        
        if(!checkUserName(username)){
            errors += "username is not correctly formatted;\n";
        }
        
        if(!checkPasswordComplexity(password)){
            errors += "password is not correctly formatted;\n";
        }
        
        if(!checkCellPhoneNumber(cellphone)){
            errors += "cellphone is not correctly formatted;\n";
        }
        
        if(!errors.isEmpty()){
            return errors;
        }
        
        String success = "";
        success += "Username successfully captured\n";
        success += "Password successfully captured\n";
        success += "Cellphone successfully captured\n";
        success += "Welcome " + firstName + " " + lastName + " it is great to see you.";
        
        registeredUser.username = username;
        registeredUser.password = password;
        registeredUser.firstName = firstName;
        registeredUser.lastName = lastName;
        registeredUser.cellphone = cellphone;
        
        return success;
    }
    
    static boolean loginUser(String username, String password){
        // Supprimer les System.out.println() dans les méthodes de test
        if(username.equals(registeredUser.username) && 
           password.equals(registeredUser.password)){
            return true;
        }else{
            return false;
        }
    }
    
    static String returnLoginStatus(boolean isLoggedIn) {
        if(isLoggedIn) {
            // Vérifier que firstName et lastName ne sont pas null
            String firstName = registeredUser.firstName != null ? registeredUser.firstName : "";
            String lastName = registeredUser.lastName != null ? registeredUser.lastName : "";
            return "Welcome back " + firstName + " " + lastName;
        } else {
            return "loggin has failed";
        }
    }
    
}
