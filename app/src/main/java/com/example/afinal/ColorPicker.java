package com.example.afinal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class ColorPicker extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_color_picker);
        initSettings();
        initRadioGroupSortBy();

    }
    private void initSettings() {
        SharedPreferences sharedPref = getSharedPreferences("MyColorPreferences",
                Context.MODE_PRIVATE);
        int color = sharedPref.getInt("colorfield", -1);




    }

    private void initRadioGroupSortBy() {
        RadioGroup rg = findViewById(R.id.radioGroupColor);
        RadioButton rbRed = findViewById(R.id.radioRed);
        RadioButton rbBlue = findViewById(R.id.radioBlue);
        RadioButton rbPurple = findViewById(R.id.radioPurple);
        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if (rbRed.isChecked()) {
                    SharedPreferences sp = getSharedPreferences("MyColorPreferences", Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = sp.edit();
                    editor.putInt("colorfield", 0xFFD3D3D3);
                    editor.apply();

                } else if (rbBlue.isChecked()) {
                    SharedPreferences sp = getSharedPreferences("MyColorPreferences", Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = sp.edit();
                    editor.putInt("colorfield", 0xFF6495ED);
                    editor.apply();

                } else if (rbPurple.isChecked()) {
                    SharedPreferences sp = getSharedPreferences("MyColorPreferences", Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = sp.edit();
                    editor.putInt("colorfield", 0xFFCBC3E3);
                    editor.apply();

                }
                else {
                    SharedPreferences sp = getSharedPreferences("MyColorPreferences", Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = sp.edit();
                    editor.putInt("colorfield", 0xFF00FF00);
                    editor.apply();
                }
            }
        });
    }

}