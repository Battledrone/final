package com.example.afinal;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

public class MainActivity extends AppCompatActivity {
    private TextView helloView;
    private Button button;
    private EditText numberEdit;
    private Button button2;
    private SeekBar seekBar;
    private TextView textBarLabel;
    private ConstraintLayout layout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        layout = findViewById(R.id.layout);
        helloView = findViewById(R.id.helloView);
        button = findViewById(R.id.button);
        numberEdit = findViewById(R.id.numberEdit);
        button2 = findViewById(R.id.button2);


        initChangeButton();

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                int num = Integer.parseInt(numberEdit.getText().toString());
                if (num > 0) {
                    helloView.setText("Your tip is " + (num * .15) + " and your total is " + (num * 1.15) + "!");
                }
                else {
                    helloView.setText("Error, Enter a number other than 0");
                }
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                int num = Integer.parseInt(numberEdit.getText().toString());
                if (num > 0) {
                    helloView.setText("Your tip is " + (num * .20) + " and your total is " + (num * 1.20) + "!");
                } else {
                    helloView.setText("Error, Enter a number other than 0");
                }
            }
        });


    }
    public void onResume() {
        super.onResume();
        SharedPreferences sp = getSharedPreferences("MyColorPreferences", Context.MODE_PRIVATE);
        int color = sp.getInt("colorfield", 0);
        layout.setBackgroundColor(color);

    }
    private void initChangeButton(){
        Button changeButton = findViewById(R.id.buttonColor);
        changeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, ColorPicker.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
            }
        });
    }


}