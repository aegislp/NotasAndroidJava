package com.example.layout.tabs;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.layout.R;
import com.example.layout.interfaces.NotaInteractionListener;
import com.example.layout.model.Nota;
import java.util.ArrayList;
import java.util.List;

/**
 * A fragment representing a list of Items.
 * <p/>
 * Activities containing this fragment MUST implement the {@link com.example.layout.interfaces.NotaInteractionListener}
 * interface.
 */
public class NotaFragment extends Fragment {

    private int mColumnCount = 2;

    private NotaInteractionListener mListener;

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public NotaFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_nota_list, container, false);

        // Set the adapter
        if (view instanceof RecyclerView) {
            Context context = view.getContext(); 
            RecyclerView recyclerView = (RecyclerView) view;

            DisplayMetrics dpMetric =  context.getResources().getDisplayMetrics();
            float dpWidth = dpMetric.widthPixels / dpMetric.density;
            int cantCol = (int) (dpWidth / 180);

            if (cantCol <= 1) {
                recyclerView.setLayoutManager(new LinearLayoutManager(context));
            } else {
                recyclerView.setLayoutManager(new StaggeredGridLayoutManager( cantCol ,StaggeredGridLayoutManager.VERTICAL));
            }

            List<Nota> notas = new ArrayList<Nota>();

            notas.add(new Nota("Nota Titulo muy largo que no tendria que entrar en 2 lineas","Contenido de la primera nota que es mas grande que el contenido de las anteriores",true,998873));

            notas.add(new Nota("Nota 1","Contenido 1",true,998873));

            notas.add(new Nota("Nota 1","Contenido 1",false,998873));

            notas.add(new Nota("Nota 1","Contenido 1",true,998873));

            notas.add(new Nota("Nota 1","Contenido 1",false,998873));

            recyclerView.setAdapter(new MyNotaRecyclerViewAdapter(notas, mListener));
        }
        return view;
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof NotaInteractionListener) {
            mListener = (NotaInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnListFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }


}
