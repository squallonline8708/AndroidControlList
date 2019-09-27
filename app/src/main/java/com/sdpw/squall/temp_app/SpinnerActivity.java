package com.sdpw.squall.temp_app;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;
import android.widget.Toast;

public class SpinnerActivity extends AppCompatActivity {

    private Spinner spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spinner);

        spinner=(Spinner)findViewById(R.id.spLineZone);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String Result=parent.getItemAtPosition(position).toString();//获取选择项的值
                Toast t=Toast.makeText(getApplicationContext(),Result,Toast.LENGTH_SHORT);
                t.show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                Toast t=Toast.makeText(getApplicationContext(),"Nothing",Toast.LENGTH_SHORT);
                t.show();
            }
        });
    }


}
