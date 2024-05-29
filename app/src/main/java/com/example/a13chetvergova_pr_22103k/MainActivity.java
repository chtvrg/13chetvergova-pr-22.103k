package com.example.a13chetvergova_pr_22103k;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       try
       {
           this.getSupportActionBar().hide();
       }
       catch (NullPointerException e){}
       setContentView(R.layout.activity_list1);
       getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
    }

    public boolean Started = false;
    public boolean Finished = false;

    public void Start (View view){
    Button button = (Button)findViewById(R.id.btnStart);
if(!Finished){
    if(!Started){
        button.setBackgroundColor(Color.RED);
        button.setText("Пауза");
        Started = true;
    }
    else if (Started){
        button.setBackgroundColor(Color.GREEN);
        button.setText("Старт");
        Started = false;
    }
}
else{
    Intent intent = new Intent (MainActivity.this, MainActivity.class);
    startActivity(intent);
}
    }
    public void Drive1(View view){
        Button button = (Button) findViewById(R.id.btnStart);
        View Car = (View)findViewById(R.id.CarPurple);
        TextView result = (TextView) findViewById(R.id.tvResult);
        if(Started && !Finished){
            ViewGroup.MarginLayoutParams margin = (ViewGroup.MarginLayoutParams)Car.getLayoutParams();
            margin.leftMargin +=1000;
            margin.rightMargin -=1000;
            Car.requestLayout();
            if(margin.rightMargin <= -1200){
                result.setText("Победа 1 игрока");
                button.setText("Заново");
                result.setTextColor(0xffe91E63);
                Finished = true;
            }
        }
    }
    public void Drive2(View view){
        Button button = (Button) findViewById(R.id.btnStart);
        View Car = (View)findViewById(R.id.CarWhite);
        TextView result = (TextView) findViewById(R.id.tvResult);
        if(Started && !Finished){
            ViewGroup.MarginLayoutParams margin = (ViewGroup.MarginLayoutParams)Car.getLayoutParams();
            margin.leftMargin +=1000;
            margin.rightMargin -=1000;
            Car.requestLayout();
            if(margin.rightMargin <= -1200){
                result.setText("Победа 2 игрока");
                button.setText("Заново");
                result.setTextColor(0xfff00000);
                Finished = true;
            }
        }
    }
}