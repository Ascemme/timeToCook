package com.ascemme.cookingtime2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button breakfast;
    Button lunch;
    Button supper;
    Button fullday;
    Button start;
    TextView warning;
    int chose = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        warning = findViewById(R.id.warning);
        breakfast = findViewById(R.id.breakfast_btn);
        lunch = findViewById(R.id.lunch_btn);
        supper = findViewById(R.id.supper_btn);
        fullday = findViewById(R.id.fullday_btn);
        start = findViewById(R.id.start_btn);
        breakfast.setOnClickListener(this);
        lunch.setOnClickListener(this);
        supper.setOnClickListener(this);
        fullday.setOnClickListener(this);
        start.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.start_btn:
                if (chose != 0) {
                    Intent intent;
                    intent = new Intent(this, game.class);
                    startActivity(intent);
                    warning.setText("");
                } else {
                    warning.setText("Выберите метод");
                    chose = 0;
                }
                break;

            case R.id.breakfast_btn:
                chose = 1;
                warning.setText("");
                break;
            case R.id.lunch_btn:
                chose = 2;
                warning.setText("");
                break;
            case R.id.supper_btn:
                chose = 3;
                warning.setText("");
                break;
            case R.id.fullday_btn:
                chose = 4;
                warning.setText("");
                break;

        }

    }
}
