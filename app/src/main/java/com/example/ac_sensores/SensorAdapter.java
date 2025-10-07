package com.example.ac_sensores;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class SensorAdapter extends RecyclerView.Adapter<SensorAdapter.ViewHolder> {

    private List<SensorInfo> listaSensores;

    public SensorAdapter(List<SensorInfo> listaSensores) {
        this.listaSensores = listaSensores;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.cards_activity, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        SensorInfo sensor = listaSensores.get(position);
        holder.txtNombre.setText(sensor.getNombre());
        holder.txtVendor.setText(sensor.getVendor());
        holder.txtVersion.setText("Versión: " + sensor.getVersion());
        holder.txtType.setText(sensor.getTipo());
    }

    @Override
    public int getItemCount() {
        return listaSensores.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        TextView txtNombre, txtVendor, txtVersion, txtType;

        ViewHolder(@NonNull View itemView) {
            super(itemView);
            txtNombre = itemView.findViewById(R.id.Tvnombre);
            txtVendor = itemView.findViewById(R.id.Tvvendor);
            txtVersion = itemView.findViewById(R.id.Tvversion);
            txtType = itemView.findViewById(R.id.Tvtype);
        }
    }
}
