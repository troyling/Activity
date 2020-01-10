package com.example.activity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    public static final int REQUEST_CODE = 2;
    public static final String TEXT_KEY = "TEXT_KEY";

    private final String TAG = "LIFE_CYCLE";

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

        Button startActivityButton = findViewById(R.id.button2);
        startActivityButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                startActivityForResult(intent, REQUEST_CODE);
            }
        });

        Log.i(TAG, "onCreate invoked");
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Log.i(TAG, "onActivityResult invoked");
        if (requestCode == REQUEST_CODE) {
             text = data.getStringExtra(TEXT_KEY);
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i(TAG, "onStart invoked");
    }

    @Override
    protected void onResume() {
        super.onResume();
        textView.setText(text);
        Log.i(TAG, "onResume invoked");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i(TAG, "onPause invoked");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i(TAG, "onStop invoked");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i(TAG, "onRestart invoked");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i(TAG, "onDestroy invoked");
    }

    @Override
    public void onSaveInstanceState(Bundle bundle) {
        bundle.putString(TEXT_KEY, text);
        Log.i(TAG, "onSaveInstanceState invoked");
        super.onSaveInstanceState(bundle);
    }
}
