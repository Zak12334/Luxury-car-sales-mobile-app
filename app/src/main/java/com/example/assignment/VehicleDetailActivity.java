package com.example.assignment;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class VehicleDetailActivity extends AppCompatActivity {

    private Button goBackButton, homeButton;
    private ImageView vehicleImageView;
    private TextView vehicleNameTextView, vehicleYearTextView, vehiclePriceTextView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.vehicle_detail_activity);

        vehicleImageView = findViewById(R.id.detailVehicleImage);
        vehicleNameTextView = findViewById(R.id.detailVehicleName);
        vehicleYearTextView = findViewById(R.id.detailVehicleYear);
        vehiclePriceTextView = findViewById(R.id.detailVehiclePrice);

        goBackButton = findViewById(R.id.goBackButton);
        homeButton = findViewById(R.id.homeButton);

        goBackButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        homeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(VehicleDetailActivity.this, MainActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
            }
        });

        // Get data from intent
        Intent intent = getIntent();
        if (intent != null) {
            String vehicleName = intent.getStringExtra("vehicleName");
            int vehicleImageResId = intent.getIntExtra("vehicleImage", -1); // -1 is default value
            String vehicleYear = intent.getStringExtra("vehicleYear");
            String vehiclePrice = intent.getStringExtra("vehiclePrice");

            // Set data to views
            vehicleImageView.setImageResource(vehicleImageResId);
            vehicleNameTextView.setText(vehicleName);
            vehicleYearTextView.setText(vehicleYear);
            vehiclePriceTextView.setText(vehiclePrice);
        }
    }
}
