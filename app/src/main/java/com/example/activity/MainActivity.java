package com.example.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    private final String TAG = "LIFE_CYCLE";
    private final String TEXT_KEY = "TEXT_KEY";

    private TextView textView;
    private String text = "Hello";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.text);

        if (savedInstanceState != null) {
            text = savedInstanceState.getString(TEXT_KEY);
        }

        Button button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                text = "hi";
                textView.setText(text);
            }
        });

        Log.i(TAG,"onCreate invoked");
    }
    @Override
    protected void onStart() {
        super.onStart();
        Log.i(TAG,"onStart invoked");
    }
    @Override
    protected void onResume() {
        super.onResume();
        textView.setText(text);
        Log.i(TAG,"onResume invoked");
    }
    @Override
    protected void onPause() {
        super.onPause();
        Log.i(TAG,"onPause invoked");
    }
    @Override
    protected void onStop() {
        super.onStop();
        Log.i(TAG,"onStop invoked");
    }
    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i(TAG,"onRestart invoked");
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i(TAG,"onDestroy invoked");
    }

    @Override
    public void onSaveInstanceState(Bundle bundle) {
        bundle.putString(TEXT_KEY, text);
        Log.i(TAG,"onSaveInstanceState invoked");
        super.onSaveInstanceState(bundle);
    }
}
