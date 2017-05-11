package com.iot.unb.SmartMetering;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.android.volley.VolleyError;
import com.iot.unb.model.domain.result.AutoRegisterResult;
import com.iot.unb.model.service.Raise;
import com.iot.unb.model.service.RaiseUIOT;

public class SettingsActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Settings");
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.btnForceAutoRegister) {
            autoRegisterClick();
        } else if (view.getId() == R.id.btnRevalidateAutoRegister) {

        } if (view.getId() == R.id.btnForceDataCollection) {

        }
    }

    private void autoRegisterClick() {
        RaiseUIOT.autoRegister(new Raise.Listener<AutoRegisterResult>() {
            @Override
            public void onSucces(AutoRegisterResult response) {
                Toast.makeText(SettingsActivity.this, "The device has successfuly been auto registered with services!", Toast.LENGTH_LONG).show();
            }
        }, new Raise.ErrorListener() {
            @Override
            public void onError(VolleyError error) {

            }
        });
    }

}
