package br.edu.ifsp.hto.rolejusto.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import br.edu.ifsp.hto.rolejusto.domain.Veiculo;

import java.util.List;

import br.edu.ifsp.hto.rolejusto.R;

public class VeiculoAdapter extends BaseAdapter {
    private final Context context;
    private final List<Veiculo> veiculos;

    public VeiculoAdapter(Context context, List veiculos){
        this.context = context;
        this.veiculos = veiculos;
    }


    @Override
    public int getCount() { return veiculos != null ? veiculos.size() : 0;  }

    @Override
    public Object getItem(int position) { return veiculos.get(position); }

    @Override
    public long getItemId(int position) { return veiculos.get(position).getN_vei(); }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = LayoutInflater.from(context).inflate(R.layout.adapter_veiculos, parent, false);

        TextView tNomeVei = (TextView) view.findViewById(R.id.tNomeVei);
        TextView tModeloVei = (TextView) view.findViewById(R.id.tModeloVei);
        TextView tAnoVei = (TextView) view.findViewById(R.id.tAnoVei);
        TextView tCombustivelVei = (TextView) view.findViewById(R.id.tCombustivelVei);
        TextView tConsumoVei = (TextView) view.findViewById(R.id.tConsumoVei);

        Veiculo veiculo = veiculos.get(position);
        tNomeVei.setText(veiculo.getNome_vei());
        tModeloVei.setText(veiculo.getModelo_vei());
        tAnoVei.setText(String.valueOf(veiculo.getAno_vei()));
        tCombustivelVei.setText(String.valueOf(veiculo.getCombustivel_vei()));
        tConsumoVei.setText(String.valueOf(veiculo.getConsumo_vei()));

        return view;
    }
}