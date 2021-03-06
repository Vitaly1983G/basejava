package com.urise.webapp.util;

import com.urise.webapp.storage.SqlStorage;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Config {
    private static final String PROPS = "/resumes.properties";
    //"D:/Programms installed/proj J/lesson06/basejava/config/resumes.properties");
    // /Users/vitalygavrilov/Documents/Java/basejava/config
    // private static final File PROPS = new File(getHomeDir() + "/config/resumes.properties");
    private static final Config INSTANCE = new Config();
    private final File storageDir;
    private final SqlStorage SqlStorage;

    private Config() {
        /*   try (InputStream is = new FileInputStream(PROPS)) {*/
        try (InputStream is = Config.class.getResourceAsStream(PROPS)) {
            Properties props = new Properties();
            props.load(is);
            storageDir = new File(props.getProperty("storage.dir"));
            SqlStorage = new SqlStorage(props.getProperty("db.url"), props.getProperty("db.user"), props.getProperty("db.password"));
        } catch (IOException e) {
            throw new IllegalStateException("Invalid config file" + PROPS);
        }
    }

    public static Config get() {
        return INSTANCE;
    }

    public File getStorageDir() {
        return storageDir;
    }

    public SqlStorage getSqlStorage() {
        return SqlStorage;
    }

 /*   private static File getHomeDir() {
        String prop = System.getProperty("homeDir");
        File homeDir = new File(prop == null ? "." : prop);
        if (!homeDir.isDirectory()) {
            throw new IllegalStateException(homeDir + " is not directory");
        }
        return homeDir;
    }*/
}