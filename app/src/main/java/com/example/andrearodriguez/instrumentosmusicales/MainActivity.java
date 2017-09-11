package com.example.andrearodriguez.instrumentosmusicales;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements ListaTiposInstrumentosFragment.InstrumentoSeleccionado{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (findViewById(R.id.contenedor) != null){

            if (savedInstanceState != null)
                return;

            ListaTiposInstrumentosFragment fragment = new ListaTiposInstrumentosFragment();
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.contenedor, fragment)
                    .commit();

        }
    }

    @Override
    public void instrumentoSeleccionado(int position) {
        //Toast.makeText(this, "Posicion " + position, Toast.LENGTH_LONG).show();
        InstrumentoFragment fragment = (InstrumentoFragment)
                getSupportFragmentManager().findFragmentById(R.id.fragment_detalle);

        if (fragment != null){
            fragment.actualizarVista(position);
        }else{
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.contenedor, InstrumentoFragment.getInstance(position))
                    .addToBackStack(null)
                    .commit();
        }
    }


    public void mensajeFavoritos(View view) {
        Toast.makeText(this, "Agregado con exito a favoritos ", Toast.LENGTH_LONG).show();
    }

    public void mensajeReproduciendo(View view) {
        Toast.makeText(this, "Reproduciendo sonido ", Toast.LENGTH_LONG).show();
    }
}
