package com.example.sunmeter;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.navigation.NavigationBarView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private ProgressBar progressBar;
    private TextView progressText;
    ImageButton refresh;
    int i = 100;






    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        progressBar = findViewById(R.id.progress_bar);
        progressText = findViewById(R.id.progres_text);



        FloatingActionButton countdown = findViewById(R.id.countdown_btn);

        countdown.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        if(i >= 0){
                            //android.os.SystemClock.sleep(5000);
                            progressText.setText(""+i+"sec");
                            progressBar.setProgress(i);
                            i--;
                            handler.postDelayed(this,1000);


                        }else{
                            handler.removeCallbacks(this);

                        }

                    }
                },1000);

            }
        });

        refresh = findViewById(R.id.refresh_btn);
        refresh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

       Button button = findViewById(R.id.recycle_btn);
       button.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               Intent intent = new Intent(view.getContext(),ranklist.class);
               startActivity(intent);

           }
       });
       Button button1 = findViewById(R.id.setting_btn);
       button1.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               Intent intent = new Intent(view.getContext(),setting.class);
               startActivity(intent);
           }
       });

    }

}