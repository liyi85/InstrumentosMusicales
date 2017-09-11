package com.example.andrearodriguez.instrumentosmusicales;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.ListFragment;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

/**
 * Created by andrearodriguez on 9/10/17.
 */

public class ListaTiposInstrumentosFragment extends ListFragment{

    private InstrumentoSeleccionado implementacion;

    public interface InstrumentoSeleccionado {
        void instrumentoSeleccionado(int position);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        try {
            implementacion = (InstrumentoSeleccionado) context;
        }catch (ClassCastException ex){
            throw new ClassCastException(context.toString()
            + "debe implementar SeleccionarInstrumento");
        }
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        String[] instrumentos = getResources().getStringArray(R.array.instrumentos);
        setListAdapter(new ArrayAdapter<>(getContext(), android.R.layout.simple_list_item_1, instrumentos));
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        implementacion.instrumentoSeleccionado(position);
        getListView().setItemChecked(position, true);
    }
    @Override
    public void onResume() {
        super.onResume();

        getActivity().setTitle("Instrumentos Musicales");

    }
}
