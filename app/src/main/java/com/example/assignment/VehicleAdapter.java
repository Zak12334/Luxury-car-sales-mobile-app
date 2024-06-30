package com.example.assignment;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class VehicleAdapter extends RecyclerView.Adapter<VehicleAdapter.VehicleViewHolder> {

    private List<Vehicle> vehicleData;
    private Context context;

    public VehicleAdapter(Context context, List<Vehicle> vehicles) {
        this.context = context;
        this.vehicleData = vehicles;
    }

    @NonNull
    @Override
    public VehicleViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.car_list_item, parent, false);
        return new VehicleViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(VehicleViewHolder holder, int position) {
        Vehicle vehicle = vehicleData.get(position);
        holder.vehicleImageView.setImageResource(vehicle.getImageResId());
        holder.vehicleNameTextView.setText(vehicle.getName());
        holder.vehicleYearTextView.setText(vehicle.getYear());
        holder.vehiclePriceTextView.setText(vehicle.getPrice());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, VehicleDetailActivity.class);  // Launching the details page
                // Optional: if you want to pass details of the clicked vehicle to the new activity.
                intent.putExtra("vehicleName", vehicle.getName());
                intent.putExtra("vehicleImage", vehicle.getImageResId());
                intent.putExtra("vehicleYear", vehicle.getYear());
                intent.putExtra("vehiclePrice", vehicle.getPrice());
                context.startActivity(intent);
            }
        });
    }


    @Override
    public int getItemCount() {
        return vehicleData.size();
    }

    public class VehicleViewHolder extends RecyclerView.ViewHolder {
        TextView vehicleNameTextView;
        TextView vehicleYearTextView;
        TextView vehiclePriceTextView;
        ImageView vehicleImageView;

        public VehicleViewHolder(View itemView) {
            super(itemView);
            vehicleNameTextView = itemView.findViewById(R.id.carTitle);
            vehicleYearTextView = itemView.findViewById(R.id.carYear);
            vehiclePriceTextView = itemView.findViewById(R.id.carPrice);
            vehicleImageView = itemView.findViewById(R.id.carImage);
        }
    }
}
