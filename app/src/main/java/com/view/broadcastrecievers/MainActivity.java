package com.view.broadcastrecievers;

import androidx.appcompat.app.AppCompatActivity;

import android.content.BroadcastReceiver;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    public static final String CUSTOM_BROADCAST_ACTION = "com.view.broadcastrecievers.CUSTOM_BROADCAST";
    Button broadcast;
    EditText text;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        View decorView = getWindow().getDecorView();

        int uiOptions = View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
                | View.SYSTEM_UI_FLAG_FULLSCREEN;
        decorView.setSystemUiVisibility(uiOptions);

        broadcast=(Button) findViewById(R.id.brdcast);
        text=(EditText)findViewById(R.id.text);
        broadcast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent=new Intent(MainActivity.this, MainActivity2.class);
                intent.putExtra(CUSTOM_BROADCAST_ACTION,text.getText().toString());
                startActivity(intent);
            }
        });
    }
}