package com.example.assignment;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.assignment.CarListActivity;

public class MainActivity extends AppCompatActivity {

    private RadioGroup radioGroup;
    private Button startButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        radioGroup = (RadioGroup) findViewById(R.id.radioGroup);
        startButton = (Button) findViewById(R.id.startButton);
        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int selectedId = radioGroup.getCheckedRadioButtonId();

                if (selectedId != -1) {
                    RadioButton selectedRadioButton = (RadioButton) findViewById(selectedId);
                    String selectedText = selectedRadioButton.getText().toString();

                    if (selectedText.equals("Cars")) {
                        Intent intent = new Intent(MainActivity.this, CarListActivity.class);
                        intent.putExtra("vehicle_type", selectedText);
                        startActivity(intent);
                    } else if (selectedText.equals("Bikes")) {
                        Intent intent = new Intent(MainActivity.this, CarListActivity.class);
                        intent.putExtra("vehicle_type", selectedText);
                        startActivity(intent);
                    } else if (selectedText.equals("Parts")) {
                        Intent intent = new Intent(MainActivity.this, CarListActivity.class);
                        intent.putExtra("vehicle_type", selectedText);
                        startActivity(intent);
                    } else {
                        Toast.makeText(MainActivity.this, "Please select an option", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }
}