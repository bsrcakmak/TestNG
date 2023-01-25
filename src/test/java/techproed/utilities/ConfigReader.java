package techproed.utilities;

import java.io.FileInputStream;
import java.util.Properties;

public class ConfigReader {
    // Bu class configuration.properties file'i okumak icin kullanilir.
    // property file'i okumak icin property objesi kullanilir.

    private static Properties properties;
    // static block : ilk calisir
    static {
        // calistirmak yada data cekmek istedigimiz dosyanin path'i
        String path="configuration.properties";
        try {
            // configuration.properties dosyasini acar icin kullaniriz FileInputStream
            FileInputStream fileInputStream = new FileInputStream(path);
            // properties objesini instantiate ediyoruz
            properties = new Properties();
            // configuration.properties dosyasindaki datalari yukler
            properties.load(fileInputStream);
            // fileInputStream'i kapatiyoruz
            fileInputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    //This method will get the key from properties file,
    //And return the value as String
    //We create this method to read the file

    // ConfigReader.getProperty("browser"); --> chrome
    // ConfigReader.getProperty("amazon_url"); --> https://www.amazon.com
    // ConfigReader.getProperty("username"); --> busra
    public static String getProperty(String key){
        String value=properties.getProperty(key);
        return value;
    }
}
