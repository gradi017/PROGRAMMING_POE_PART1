/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.part1_poe;

import org.junit.Test;
import org.junit.Assert;


public class RegisterTest {
    
    // ✅ USERNAME TESTS
    @Test
    public void testCheckUserNameCorrect() {
        Assert.assertEquals(true, Register.checkUserName("kyl_1"));
    }
    
    @Test
    public void testCheckUserNameIncorrect() {
        Assert.assertEquals(false, Register.checkUserName("kyle!!!"));
    }
    
    // ✅ PASSWORD TESTS
    @Test
    public void testCheckPasswordComplexityCorrect() {
        Assert.assertEquals(true, Register.checkPasswordComplexity("Kibesi22@@"));
    }
    
    @Test
    public void testCheckPasswordComplexityIncorrect() {
        Assert.assertEquals(false, Register.checkPasswordComplexity("password"));
    }
    
    // ✅ CELLPHONE TESTS
    @Test
    public void testCheckCellPhoneNumberCorrect() {
        Assert.assertEquals(true, Register.checkCellPhoneNumber("+27606076767"));
    }
    
    @Test
    public void testCheckCellPhoneNumberIncorrect() {
        Assert.assertEquals(false, Register.checkCellPhoneNumber("0606076767"));
    }
    
    // ✅ REGISTER TEST
    @Test
    public void testRegisterUser() {
        String result = Register.registerUser("John", "kyl_1", "Kibesi22@@", "+27606076767", "Doe");
        Assert.assertEquals(true, result.contains("Welcome"));
    }
    
    // ✅ LOGIN TESTS
    @Test
    public void testLoginUserCorrect() {
        Register.registerUser("John", "kyl_1", "Kibesi22@@", "+27606076767", "Doe");
        Assert.assertEquals(true, Register.loginUser("kyl_1", "Kibesi22@@"));
    }
    
    @Test
    public void testLoginUserIncorrect() {
        Assert.assertEquals(false, Register.loginUser("wrong", "wrong"));
    }
    
    // ✅ LOGIN STATUS TESTS
    @Test
    public void testReturnLoginStatusSuccess() {
        Assert.assertEquals(true, Register.returnLoginStatus(true).contains("Welcome back"));
    }
    
    @Test
    public void testReturnLoginStatusFailed() {
        Assert.assertEquals(true, Register.returnLoginStatus(false).contains("failed"));
    }
}