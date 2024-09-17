package com.example.lab1;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Main extends Activity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_act);

        Button b1 = (Button) findViewById(R.id.button);
        Button b2 = (Button) findViewById(R.id.button2);
        Button b3 = (Button) findViewById(R.id.button3);
        Button b4 = (Button) findViewById(R.id.button5);

        b1.setOnClickListener(this);
        b2.setOnClickListener(this);
        b3.setOnClickListener(this);
        b4.setOnClickListener(this);
    }
    @Override
    public void onClick(View view) {
        Button b =(Button)view;
        b.setText(R.string.buttonChanged);
    }
}
