package com.contrado.source;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class FileUtil {
    private static FileReader reader;
    private static Properties properties;

    public static void loadPropertiesFile() throws IOException {
        reader = new FileReader("C:\\Users\\krunal\\eclipse-workspace\\krunal_04may2022\\config.properties");
        properties = new Properties();
        properties.load(reader);
    }

    public static String getProperty(String key) {
        return (String) properties.get(key);
    }
}