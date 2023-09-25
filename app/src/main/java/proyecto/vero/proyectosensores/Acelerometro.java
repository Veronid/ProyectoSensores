package proyecto.vero.proyectosensores;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.pm.PermissionInfoCompat;

import android.annotation.SuppressLint;
import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.TextView;

public class Acelerometro extends AppCompatActivity implements SensorEventListener {

    private SensorManager sensorManager;

    private Sensor acelerometro;

    TextView x,y,z;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_acelerometro);
        x = findViewById(R.id.txtEjeX);
        y = findViewById(R.id.txtEjeY);
        z = findViewById(R.id.txtEjeZ);
        sensorManager = (SensorManager)
                //Inicializamos el apartado de los sensores
            getSystemService(Context.SENSOR_SERVICE);
        //Accedimos al acelerometro
        acelerometro = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);

    }
    @Override
    //Se crean el metodo
    //Para leer el estado de los sensores
    protected void onResume(){
        super.onResume();
        sensorManager.registerListener(this,acelerometro,SensorManager.SENSOR_DELAY_NORMAL);
    }

    @Override
    //Se crea el metodo
    //Para pausar, ahorro de energia
    protected void onPause(){
        super.onPause();
        sensorManager.unregisterListener(this);
    }
    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {
        float txtEjeX = sensorEvent.values[0];
        x.setText(String.valueOf(txtEjeX));
        float txtEjeY = sensorEvent.values[1];
        y.setText(String.valueOf(txtEjeY));
        float txtEjeZ = sensorEvent.values[2];
        z.setText(String.valueOf(txtEjeZ));

    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {

    }
}