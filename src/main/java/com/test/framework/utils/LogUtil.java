package com.test.framework.utils;

import com.test.framework.commons.Settings;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class LogUtil {
    String pathLog = System.getProperty("user.dir") + "LOGS";
    ZonedDateTime date = ZonedDateTime.now();
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("ddMMyyyyHHMMSS");
    String fileNameFormat = date.format(formatter);

    private BufferedWriter bufferedWriter = null;

    public void createLogFile() throws IOException {
        File dir = new File(pathLog);
        if (!dir.exists()){
            dir.mkdirs();
        }

        File logFile = new File(dir +"/"+ fileNameFormat +".log");

        FileWriter fileWriter = new FileWriter(logFile.getAbsoluteFile());
        bufferedWriter = new BufferedWriter(fileWriter);
    }

    public void write(String message) {
        try {
            formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy:HH_MM_SS");
            String dateFormat = date.format(formatter);
            bufferedWriter.write("[" + dateFormat + "]: " + message);
            bufferedWriter.newLine();
            bufferedWriter.flush();
        } catch (Exception exception){

        }
    }
}
