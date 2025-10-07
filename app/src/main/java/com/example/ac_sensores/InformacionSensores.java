package com.example.ac_sensores;

import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class InformacionSensores extends AppCompatActivity {

    private RecyclerView recyclerSensores;

    // Administrador de sensores
    private SensorManager gestorSensores;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.infosensores_activity);

        recyclerSensores = findViewById(R.id.recyclerSensores);

        // Configurar 2 columnas
        recyclerSensores.setLayoutManager(new GridLayoutManager(this, 2));

        // Llamar al servicio de sensores
        gestorSensores = (SensorManager) getSystemService(SENSOR_SERVICE);

        cargarSensores();
    }

    private void cargarSensores() {
        List<Sensor> listaSensores = gestorSensores.getSensorList(Sensor.TYPE_ALL);
        List<SensorInfo> datos = new ArrayList<>();

        for (Sensor sensor : listaSensores) {
            datos.add(new SensorInfo(
                    sensor.getName(),
                    sensor.getVendor(),
                    sensor.getVersion(),
                    sensor.getStringType()
            ));
        }

        SensorAdapter adaptador = new SensorAdapter(datos);
        recyclerSensores.setAdapter(adaptador);
    }
}
