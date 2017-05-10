package com.iot.unb.model.service;

import android.app.Application;
import android.net.Uri;
import android.provider.Settings;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.iot.unb.SmartMetering.MainActivity;

/**
 * Created by aclopesjr on 5/7/17.
 */

public class RaiseUIOT {

    //Release Enviroment
    //public static final String UIOT_HOST          = "raise.uiot.com.br";
    //Test Enviroment
    public static final String UIOT_HOST            = "http://homol.redes.unb.br/uiot-raise";
    public static final String CLIENT_REGISTER      = "client/register";
    public static final String CLIENT_REVALIDATE    = "client/revalidate";
    public static final String SERVICE_REGISTER     = "service/register";
    public static final String DATA_REGISTER        = "data/register";
    public static final String DATA_LIST            = "data/list";

    /**
     * Returns weather the device is auto registered or not.
     * @return <{@link Boolean}/>
     */
    public static boolean isAutoRegistered() {
        return false;
    }

    /**
     * Auto register the device.
     */
    public void autoRegister() {

        RequestQueue request = Volley.newRequestQueue(MainActivity.getContext());

        StringRequest stringRequest = new StringRequest(Request.Method.GET,
                UIOT_HOST.concat("/").concat(CLIENT_REGISTER),
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                });
        request.add(stringRequest);
    }

    /**
     * Revalidates the auto register.
     */
    public void revalidateAutoRegister() {

        RequestQueue request = Volley.newRequestQueue(MainActivity.getContext());

        StringRequest stringRequest = new StringRequest(Request.Method.GET,
                UIOT_HOST.concat("/").concat(CLIENT_REVALIDATE),
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                });
        request.add(stringRequest);
    }
}
