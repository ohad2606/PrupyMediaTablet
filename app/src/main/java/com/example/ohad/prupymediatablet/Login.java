package com.example.ohad.prupymediatablet;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by ohad on 3/13/18.
 */

public class Login extends Activity{

    public static final String PREFS = "prefs";
    public static final String STORENAME = "storename";

    String storeName;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        SharedPreferences sharedPreferences = getSharedPreferences(PREFS, MODE_PRIVATE);
        storeName = sharedPreferences.getString(STORENAME, null);
        if(storeName != null)
            goToMainActivity(storeName);
    }

    private void goToMainActivity(String storeName) {
        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra(STORENAME, storeName);
        startActivity(intent);
        finish();
    }

    public void btnStart(View view){
        TextView lbllblStore = findViewById(R.id.lblStore);
        EditText txtStoreName = findViewById(R.id.txtStoreName);
        String storeName = txtStoreName.getText().toString();
        SharedPreferences sharedPreferences = getSharedPreferences(PREFS, MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(STORENAME, storeName);
        editor.commit();
        if(storeName.isEmpty()) {
            Toast.makeText(this, "הכנס שם חנות", Toast.LENGTH_SHORT).show();
            return;
        }
        goToMainActivity(storeName);
    }

}
