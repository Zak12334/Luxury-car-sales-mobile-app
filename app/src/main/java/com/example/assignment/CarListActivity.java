package com.example.assignment;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class CarListActivity extends AppCompatActivity {

    private Button mainScreenButton;
    private RecyclerView recyclerView;
    private VehicleAdapter carAdapter;
    private List<Vehicle> carData;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.car_list_activity);

        recyclerView = findViewById(R.id.recyclerView);
        carData = new ArrayList<>();

        mainScreenButton = findViewById(R.id.mainScreenButton);

        mainScreenButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CarListActivity.this, MainActivity.class);
                // This flag ensures that the user navigates to a fresh instance of the main activity.
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
            }
        });

        // Get the selected vehicle type from the intent
        String selectedVehicleType = getIntent().getStringExtra("vehicle_type");

        // Populate the carData list based on the selected vehicle type (customize this as needed)
        if (selectedVehicleType.equals("Cars")) {
            carData.add(new Vehicle(R.drawable.bmw7s, "BMW 7 Series", "2023", "$40,000", "Car"));
            carData.add(new Vehicle(R.drawable.mbc257, "Mercedes Benz C257", "2023", "$55,000", "Car"));
            carData.add(new Vehicle(R.drawable.audia5, "Audi A5", "2022", "$39,500", "Car"));
            carData.add(new Vehicle(R.drawable.rrphev, "Range Rover PHEV", "2019", "$45,000", "Car"));
            carData.add(new Vehicle(R.drawable.lexrx350, "Lexus RX350", "2023", "$65,000", "Car"));
            carData.add(new Vehicle(R.drawable.teslam3, "Tesla Model 3", "2023", "$75,000", "Car"));

        } else if (selectedVehicleType.equals("Bikes")) {
            carData.add(new Vehicle(R.drawable.ducapan, "Ducatti Panigale V4", "2023", "$27,995.00", "Bike"));
            carData.add(new Vehicle(R.drawable.hondacl500, "Honda CL500", "2023", "$6,000", "Bike"));
            carData.add(new Vehicle(R.drawable.harley2019, "Harley Davidson Softail", "2019", "$19,855", "Bike"));
            carData.add(new Vehicle(R.drawable.bmwbike, "BMW K1600", "2022", "$20,395", "Bike"));
            carData.add(new Vehicle(R.drawable.kawa, "Kawasaki Ninja", "2023", "$9,000", "Bike"));
            carData.add(new Vehicle(R.drawable.banelli, "Banelli Leocino 500", "2018", "$57,000", "Bike"));

        } else if (selectedVehicleType.equals("Parts")) {
            carData.add(new Vehicle(R.drawable.brakeclutch, "Brake % Clutch for Ducatti Panigale V4", "2023", "$860", "Parts"));
            carData.add(new Vehicle(R.drawable.bmwbrakes, "BMW Brake Pads", "20015-2023", "$6,000", "Parts"));
            carData.add(new Vehicle(R.drawable.bmwclutch, "BMW Clutch", "2010-2023", "$2,855", "Parts"));
            carData.add(new Vehicle(R.drawable.rangewiper, "Range Rover Wiper Blades", "2005-2023", "$50", "Parts"));
            carData.add(new Vehicle(R.drawable.battery, "Universal Car Battery", "2023", "$500", "Parts"));
            carData.add(new Vehicle(R.drawable.filters, "Universal Air Filters", "2023", "$60", "Parts"));
        }

        // Initialize the RecyclerView and set the adapter
        VehicleAdapter vehicleAdapter = new VehicleAdapter(this, carData);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(vehicleAdapter);

    }
}
