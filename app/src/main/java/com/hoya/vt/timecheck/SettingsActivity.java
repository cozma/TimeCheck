package com.hoya.vt.timecheck;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

public class SettingsActivity extends AppCompatActivity {

    TextView statusTextView;
    Switch statusSwitch;
    GlobalClass globals;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        globals = (GlobalClass) getApplication();
        statusTextView = (TextView) findViewById(R.id.statusTextView);
        statusSwitch = (Switch) findViewById(R.id.statusSwitch);

        if (globals.sharedPref.getString("currentStatus", "empty").equals("Bus Driver")) {
            statusTextView.setText("Remove 'Bus Driver' status");
        }
        else {
            statusTextView.setText("Remove 'Passenger' status");
        }

    }



    public void applyChanges(View view) {

        if (statusSwitch.isChecked()) {
            globals.editor.remove("currentStatus");
            globals.editor.commit();
            globals.editor.clear();
            globals.editor.commit();
            startActivity(new Intent(this, MainActivity.class));
            finish();
        }
    }


}
