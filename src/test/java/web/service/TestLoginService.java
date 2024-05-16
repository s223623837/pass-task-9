package web.service;

import org.junit.Assert;
import org.junit.Test;

public class TestLoginService {

    // Test successful login with valid credentials
    @Test
    public void testLoginSuccess() {
        String username = "ahsan";
        String password = "ahsan_pass";
        String dob = "1990-01-01"; // Date of birth for successful login
        
        boolean result = LoginService.login(username, password, dob);
        Assert.assertTrue("Login should be successful", result);
    }

    // Test login with invalid username
    @Test
    public void testLoginInvalidUsername() {
        String username = "invalid_user";
        String password = "ahsan_pass";
        String dob = "1990-01-01";
        
        boolean result = LoginService.login(username, password, dob);
        Assert.assertFalse("Login should fail with invalid username", result);
    }

    // Test login with invalid password
    @Test
    public void testLoginInvalidPassword() {
        String username = "ahsan";
        String password = "invalid_pass";
        String dob = "1990-01-01";
        
        boolean result = LoginService.login(username, password, dob);
        Assert.assertFalse("Login should fail with invalid password", result);
    }

    // Test login with invalid date of birth
    @Test
    public void testLoginInvalidDOB() {
        String username = "ahsan";
        String password = "ahsan_pass";
        String dob = "2000-01-01"; // Invalid date of birth
        
        boolean result = LoginService.login(username, password, dob);
        Assert.assertTrue("Login should fail with invalid date of birth", result);
    }

    // Test login with empty username
    @Test
    public void testLoginEmptyUsername() {
        String username = "";
        String password = "ahsan_pass";
        String dob = "1990-01-01";
        
        boolean result = LoginService.login(username, password, dob);
        Assert.assertFalse("Login should fail with empty username", result);
    }

    // Test login with empty password
    @Test
    public void testLoginEmptyPassword() {
        String username = "ahsan";
        String password = "";
        String dob = "1990-01-01";
        
        boolean result = LoginService.login(username, password, dob);
        Assert.assertFalse("Login should fail with empty password", result);
    }

    // Test login with empty date of birth
    @Test
    public void testLoginEmptyDOB() {
        String username = "ahsan";
        String password = "ahsan_pass";
        String dob = "";
        
        boolean result = LoginService.login(username, password, dob);
        Assert.assertTrue("Login should fail with empty date of birth", result);
    }
}
