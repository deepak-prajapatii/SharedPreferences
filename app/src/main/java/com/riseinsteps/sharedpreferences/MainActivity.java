package com.riseinsteps.sharedpreferences;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    Button button;
    TextView textView;
    EditText editText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = findViewById(R.id.button);
        textView = findViewById(R.id.textView);
        editText = findViewById(R.id.editTextTextPersonName);

        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                String msg = editText.getText().toString();

                SharedPreferences sharedPreferences = getSharedPreferences("demo",MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();

                editor.putString("str",msg);
                editor.apply();
                textView.setText(msg);
            }
        });
        SharedPreferences getShared = getSharedPreferences("demo", MODE_PRIVATE);

        String value = getShared.getString("str", "Save notes and it will shown up here.");
        textView.setText(value);

    }
}