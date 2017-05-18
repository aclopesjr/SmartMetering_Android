package com.iot.unb.model.service;

import android.os.Build;
import android.provider.Settings;

import com.iot.unb.SmartMetering.MainActivity;


/**
 * Created by aclopesjr on 5/14/17.
 */

public class Device {


    public static String getUniqueIdentifier() {
        return Settings.Secure.getString(MainActivity.getContext().getContentResolver(), Settings.Secure.ANDROID_ID);
    }

    public static String getDeviceName() {
        return Build.DEVICE;
    }

    public static String getOperationSystem() {
        return Build.VERSION.CODENAME + " " + Build.VERSION.BASE_OS;
    }

    public static String getBrand() {
        return Build.MANUFACTURER;
    }

    public static String getModel() {
        return Build.MODEL;
    }

    public static String getMacAdress() {
        return "";
    }

    public static String getChipset() {
        return Build.HARDWARE;
    }

    public static String getProcessor() {
        return Build.HARDWARE;
    }

    public static float getLatitude() {
        return (float) -15.87878787;
    }

    public static float getLongitude() {
        return (float) -15.87878787;
    }
}
