package UtilityFile;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesUpdater 
{

    static final String PROPERTIES_PATH = System.getProperty("user.dir") + "\\src\\main\\java\\Resources\\global.properties";

    public static void updateUserCredentials(String email, String password) {
        try {
            Properties prop = new Properties();
            FileInputStream fis = new FileInputStream(PROPERTIES_PATH);
            prop.load(fis);
            fis.close();

            // Update the values
            prop.setProperty("user_email", email);
            prop.setProperty("user_password", password);
            
            FileOutputStream fos = new FileOutputStream(PROPERTIES_PATH);
            prop.store(fos, "Updated user credentials from Excel");
            fos.close();

            System.out.println("global.properties updated successfully!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}