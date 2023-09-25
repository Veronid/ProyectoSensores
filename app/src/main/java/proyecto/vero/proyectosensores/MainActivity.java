package proyecto.vero.proyectosensores;

import static java.lang.StrictMath.log;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.TextView;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private TextView SalidaSensores;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SalidaSensores = findViewById(R.id.txtSensores);
        //Se crea un objeto para acceder a los sensores
        SensorManager sensorManager = (SensorManager)
                getSystemService(SENSOR_SERVICE);

        //Se crea una lista con el objeto sensor y se accede a todos los sensores con all
        List<Sensor> listadoSensores = sensorManager.getSensorList(Sensor.TYPE_ALL);
        for (Sensor sensor : listadoSensores) {
            log(sensor.getName());

        }
    }
    private void log (String sensores){
        SalidaSensores.append(sensores + "\n");
    }
}