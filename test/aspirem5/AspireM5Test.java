/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package aspirem5;

import java.io.File;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Mark
 */
public class AspireM5Test {
    
    public AspireM5Test() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
    }
    
    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of main method, of class AspireM5.
     */
    @Test
    public void testMain() {
        System.out.println("test main");
        String[] args = {AspireM5.class.getProtectionDomain().getCodeSource().getLocation().getPath()+"\\dist\\test.ngc"};
        AspireM5.main(args);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of processFilesFromFolder method, of class AspireM5.
     */
    @Test
    public void testProcessFilesFromFolder() {
        System.out.println("processFilesFromFolder");
        File folder = null;
        AspireM5.processFilesFromFolder(folder);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of InstallInCM method, of class AspireM5.
     */
    @Test
    public void testInstallInCM() {
        System.out.println("InstallInCM");
        AspireM5.InstallInCM();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
