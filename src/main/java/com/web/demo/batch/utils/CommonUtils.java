package com.web.demo.batch.utils;

import com.google.common.io.Resources;

import java.io.IOException;
import java.nio.charset.Charset;
import java.text.SimpleDateFormat;
import java.util.Date;

public interface CommonUtils {

    SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
    static String getOsName() {
        return System.getProperty("os.name");
    }

    static boolean isWindows() {
        return getOsName().startsWith("Windows");
    }

    static boolean isLinux() {
        return getOsName().startsWith("Linux");
    }

    static boolean isMac() {
        return getOsName().startsWith("Mac");
    }

    static String readResource(final String fileName, Charset charset) throws IOException {
        return Resources.toString(Resources.getResource(fileName), charset);
    }

    static String currentDateTime(){
        Date date = new Date();
        return formatter.format(date);
    }
}
