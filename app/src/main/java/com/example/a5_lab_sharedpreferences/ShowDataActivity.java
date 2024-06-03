package com.example.a5_lab_sharedpreferences;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;

import org.w3c.dom.Text;

public class ShowDataActivity extends AppCompatActivity {

    TextView showData;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_data);

        showData = (TextView) findViewById(R.id.textView);

//        String data = "";
//        data = getIntent().getStringExtra("data");

        String data = "";

        SharedPreferences sharedPref = getSharedPreferences("userInfo", Context.MODE_PRIVATE);
        String name = sharedPref.getString("Username", "");
        String password = sharedPref.getString("Password", "");

        data = "Username: " + name + "\n" + "Password: " + password;

        showData.setText(data);
    }
}