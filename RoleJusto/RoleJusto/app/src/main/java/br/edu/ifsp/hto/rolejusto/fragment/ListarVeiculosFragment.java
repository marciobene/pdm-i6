package br.edu.ifsp.hto.rolejusto.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import br.edu.ifsp.hto.rolejusto.R;

public class ListarVeiculosFragment extends Fragment {
    private ListView mList;

    public ListarVeiculosFragment() {

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_listar_veiculos, container, false);

        mList = (ListView) view.findViewById(R.id.listView);
        br.edu.ifsp.hto.rolejusto.presenter.ListarVeiculoPresenter listarVeiculoPresenter = new br.edu.ifsp.hto.rolejusto.presenter.ListarVeiculoPresenter();

        listarVeiculoPresenter.listarVeiculos(getContext(), mList);

        return view;
    }

}
