package br.edu.ifsp.hto.prova2.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import java.util.List;

import br.edu.ifsp.hto.prova2.R;
import br.edu.ifsp.hto.prova2.domain.Departamento;


/**
 * Created by MarcioBene on 6/1/2016.
 */
public class DepartamentoAdapter extends BaseAdapter {
    private final Context context;
    private final List<Departamento> departamentos;

    public DepartamentoAdapter(Context context, List departamentos){
        this.context = context;
        this.departamentos = departamentos;
    }

    @Override
    public int getCount() { return departamentos != null ? departamentos.size() : 0;  }

    @Override
    public Object getItem(int position) { return departamentos.get(position); }

    @Override
    public long getItemId(int position) { return departamentos.get(position).getId(); }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = LayoutInflater.from(context).inflate(R.layout.adapter_departamentos, parent, false);

        TextView tNomeDep = (TextView) view.findViewById(R.id.tNomeDepto );
        TextView tLocalDep = (TextView) view.findViewById(R.id.tLocalDepto);

        Departamento departamento = departamentos.get(position);
        tNomeDep.setText(departamento.getNome());
        tLocalDep.setText(departamento.getLocal());

        return view;
    }
}