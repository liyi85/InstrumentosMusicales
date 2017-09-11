package com.example.andrearodriguez.instrumentosmusicales;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by andrearodriguez on 9/10/17.
 */

public class InstrumentoFragment extends Fragment {

    private static final String LLAVE_POSICION = "posicion";
    private int posicionActual = -1;

    public static InstrumentoFragment getInstance(int posicion){
        InstrumentoFragment fragment = new InstrumentoFragment();

        Bundle argumentos = new Bundle();
        argumentos.putInt(LLAVE_POSICION, posicion);
        fragment.setArguments(argumentos);

        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        if(savedInstanceState != null)
            posicionActual = savedInstanceState.getInt(LLAVE_POSICION);

        return inflater.inflate(R.layout.fragment_instrumento, container, false);
    }

    @Override
    public void onStart() {
        super.onStart();

        Bundle argumentos = getArguments();
        if(argumentos != null)
            actualizarVista(argumentos.getInt(LLAVE_POSICION));
        else if (posicionActual != -1)
            actualizarVista(posicionActual);

    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        outState.putInt(LLAVE_POSICION, posicionActual);
    }

    public void actualizarVista(int posicion){

        String [] instrumentos = getResources().getStringArray(R.array.instrumentos);
        String [] descripciones = getResources().getStringArray(R.array.descripciones);

        TextView txtdescricpcion = (TextView) getActivity().findViewById(R.id.tv_descripcion);
        txtdescricpcion.setText(descripciones[posicion]);

        Drawable iconoInstrumento = null;
        Drawable iconoInstrumento2 = null;


        switch (posicion){
            case 0:
                iconoInstrumento = ContextCompat.getDrawable(getContext(), R.drawable.guitarra);
                iconoInstrumento2 = ContextCompat.getDrawable(getContext(), R.drawable.arpa);
                getActivity().setTitle(instrumentos[posicion]);
                break;
            case 1:
                iconoInstrumento = ContextCompat.getDrawable(getContext(), R.drawable.bongo);
                iconoInstrumento2 = ContextCompat.getDrawable(getContext(), R.drawable.conga);
                getActivity().setTitle(instrumentos[posicion]);
                break;
            case 2:
                iconoInstrumento = ContextCompat.getDrawable(getContext(), R.drawable.saxo);
                iconoInstrumento2 = ContextCompat.getDrawable(getContext(), R.drawable.sikus);
                getActivity().setTitle(instrumentos[posicion]);
                break;
            case 3:
                iconoInstrumento = ContextCompat.getDrawable(getContext(), R.drawable.sintetizador);
                iconoInstrumento2 = ContextCompat.getDrawable(getContext(), R.drawable.bajoelectrico);
                getActivity().setTitle(instrumentos[posicion]);
                break;
        }


        ((ImageView) getActivity().findViewById(R.id.img_instrumentoizq)).setImageDrawable(iconoInstrumento);
        ((ImageView) getActivity().findViewById(R.id.img_instrumentoder)).setImageDrawable(iconoInstrumento2);


    }


}
