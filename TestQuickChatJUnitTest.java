package TestClasses;

import com.mycompany.quickchat_part2.Login;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TestQuickChatJUnitTest {

    // Test username valid
    @Test
    public void testCheckUserName_Valid() {

        Login user = new Login(
                "Nathi",
                "Lahliwe",
                "ab_cd",
                "Password1!",
                "+27614160372"
        );

        assertTrue(user.checkUserName());
    }

    // Test username invalid
    @Test
    public void testCheckUserName_Invalid() {

        Login user = new Login(
                "Nathi",
                "Lahliwe",
                "abcdef",
                "Password1!",
                "+27614160372"
        );

        assertFalse(user.checkUserName());
    }

    // Test password valid
    @Test
    public void testCheckPasswordComplexity_Valid() {

        Login user = new Login(
                "Nathi",
                "Lahliwe",
                "ab_cd",
                "Password1!",
                "+27614160372"
        );

        assertTrue(user.checkPasswordComplexity());
    }

    // Test password invalid
    @Test
    public void testCheckPasswordComplexity_Invalid() {

        Login user = new Login(
                "Nathi",
                "Lahliwe",
                "ab_cd",
                "password",
                "+27614160372"
        );

        assertFalse(user.checkPasswordComplexity());
    }

    // Test cellphone valid
    @Test
    public void testCheckCellphoneNumber_Valid() {

        Login user = new Login(
                "Nathi",
                "Lahliwe",
                "ab_cd",
                "Password1!",
                "+27614160372"
        );

        assertTrue(user.checkCellphoneNumber());
    }

    // Test cellphone invalid
    @Test
    public void testCheckCellphoneNumber_Invalid() {

        Login user = new Login(
                "Nathi",
                "Lahliwe",
                "ab_cd",
                "Password1!",
                "0614160372"
        );

        assertFalse(user.checkCellphoneNumber());
    }

    // Test registration
    @Test
    public void testRegisterUser() {

        Login user = new Login(
                "Nathi",
                "Lahliwe",
                "ab_cd",
                "Password1!",
                "+27614160372"
        );

        assertEquals(
                "User is registered successfully.",
                user.registerUser()
        );
    }

    // Test login success
    @Test
    public void testLoginUser_Success() {

        Login user = new Login(
                "Nathi",
                "Lahliwe",
                "ab_cd",
                "Password1!",
                "+27614160372"
        );

        assertTrue(user.loginUser("ab_cd", "Password1!"));
    }

    // Test login failure
    @Test
    public void testLoginUser_Failure() {

        Login user = new Login(
                "Nathi",
                "Lahliwe",
                "ab_cd",
                "Password1!",
                "+27614160372"
        );

        assertFalse(user.loginUser("wrong", "123"));
    }

    // Test login status success
    @Test
    public void testReturnLoginStatus_Success() {

        Login user = new Login(
                "Nathi",
                "Lahliwe",
                "ab_cd",
                "Password1!",
                "+27614160372"
        );

        assertEquals(
                "Welcome Nathi Lahliwe, it is great to see you again.",
                user.returnLoginStatus(true)
        );
    }

    // Test login status failure
    @Test
    public void testReturnLoginStatus_Failure() {

        Login user = new Login(
                "Nathi",
                "Lahliwe",
                "ab_cd",
                "Password1!",
                "+27614160372"
        );

        assertEquals(
                "Username or password incorrect, please try again.",
                user.returnLoginStatus(false)
        );
    }
}