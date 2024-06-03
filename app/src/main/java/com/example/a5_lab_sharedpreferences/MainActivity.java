package com.example.a5_lab_sharedpreferences;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText userEdit, passEdit;
    Button saveBtn, showBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        saveBtn = (Button) findViewById(R.id.buttonSave);
        showBtn = (Button) findViewById(R.id.buttonShow);
        userEdit = (EditText) findViewById(R.id.usernameEdit);
        passEdit = (EditText) findViewById(R.id.passwordEdit);


        saveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveInfo(v);
            }
        });

        showBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showData(v);
            }
        });
    }

  public void saveInfo(View view){
      SharedPreferences sharedPref = getSharedPreferences("userInfo", Context.MODE_PRIVATE);
      SharedPreferences.Editor editor = sharedPref.edit();

      editor.putString("Username", userEdit.getText().toString());
      editor.putString("Password", passEdit.getText().toString());
      editor.apply();

      Toast toast = Toast.makeText(this, "Saved!", Toast.LENGTH_SHORT);
      toast.show();
  }

  public void showData(View view){
//        String data = "";
//
//        SharedPreferences sharedPref = getSharedPreferences("userInfo", Context.MODE_PRIVATE);
//        String name = sharedPref.getString("Username", "");
//        String password = sharedPref.getString("Password", "");
//
//        data = "Username: " + name + "\n" + "Password: " + password;

        Intent intent = new Intent(this, ShowDataActivity.class);
        //intent.putExtra("data", data);
        startActivity(intent);
  }

}