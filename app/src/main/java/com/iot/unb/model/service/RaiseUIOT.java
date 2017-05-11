package com.iot.unb.model.service;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.iot.unb.SmartMetering.MainActivity;
import com.iot.unb.model.domain.register.AutoRegister;
import com.iot.unb.model.domain.result.AutoRegisterResult;

import java.io.UnsupportedEncodingException;

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
    public static void autoRegister(final Raise.Listener<AutoRegisterResult> successListener, final Raise.ErrorListener errorListener) {

        RequestQueue request = Volley.newRequestQueue(MainActivity.getContext());
        StringRequest stringRequest = new StringRequest(Request.Method.POST,
                UIOT_HOST.concat("/").concat(CLIENT_REGISTER),
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        AutoRegisterResult result = new Gson().fromJson(response, AutoRegisterResult.class);
                        successListener.onSucces(result);
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        errorListener.onError(error);
                    }
                })
        {
            @Override
            public String getBodyContentType() {
                return "application/json; charset=utf-8";
            }

            @Override
            public byte[] getBody() throws AuthFailureError {
                try {
                    //Creates instance of AutoRegister
                    AutoRegister jsonData = new AutoRegister();

                    //Serializes the AutoRegister object to json.
                    String json = new GsonBuilder()
                            .setPrettyPrinting()
                            .create()
                            .toJson(jsonData);

                    //Prints the json
                    System.out.print(json);

                    return json.getBytes("utf-8");
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                    return null;
                }
            }
        };

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
