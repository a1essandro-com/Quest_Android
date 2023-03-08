package com.example.quest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    StoryLine storyLine;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        storyLine=new StoryLine();
        storyLine.update(0);
        print(storyLine.currentIntro, storyLine.currentOptions, storyLine.currentNum);
    }
    public void print(String intro, String option, int buttons){
        ((TextView) findViewById(R.id.intro)).
                setText(intro);
        ((TextView) findViewById(R.id.options)).
                setText(option);
        ((LinearLayout) findViewById(R.id.layout)).removeAllViews();

        for (int i = 0; i < buttons; i++) {
            Button b = new Button(this);
            if (!storyLine.isDead) b.setText(Integer.toString(i + 1));
            else b.setText("Начать заново");
            final int buttonId = i;

            b.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    storyLine.update(buttonId);
                    print(storyLine.currentIntro, storyLine.currentOptions, storyLine.currentNum);
                }
            });
            ((LinearLayout) findViewById(R.id.layout)).addView(b);
        }
    }
}