package br.edu.ifsp.hto.prova2.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import br.edu.ifsp.hto.prova2.R;
import br.edu.ifsp.hto.prova2.domain.Funcionario;

public class FuncionarioAdapter extends BaseAdapter {
    private final Context context;
    private final List<Funcionario> funcionarios;

    public FuncionarioAdapter(Context context, List funcionarios){
        this.context = context;
        this.funcionarios = funcionarios;
    }


    @Override
    public int getCount() { return funcionarios != null ? funcionarios.size() : 0;  }

    @Override
    public Object getItem(int position) { return funcionarios.get(position); }

    @Override
    public long getItemId(int position) { return funcionarios.get(position).getId(); }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = LayoutInflater.from(context).inflate(R.layout.adapter_funcionarios, parent, false);

        TextView tNomeFun = (TextView) view.findViewById(R.id.tNomeFunc);
        TextView tCargo = (TextView) view.findViewById(R.id.tCargo);
        TextView tDataAdm = (TextView) view.findViewById(R.id.tDataAdm);
        TextView tSalario = (TextView) view.findViewById(R.id.tSalario);
        TextView tComissao = (TextView) view.findViewById(R.id.tComissao);
        //TextView tChefe = (TextView) view.findViewById(R.id.tChefe);
        //TextView tDepartamento = (TextView) view.findViewById(R.id.tDepartamento);

        Funcionario funcionario = funcionarios.get(position);
        tNomeFun.setText(funcionario.getNome());
        tCargo.setText(funcionario.getCargo());
        //tDataAdm.setText(funcionario.getDataAdmissao().toString());
        tSalario.setText(String.valueOf(funcionario.getSal()));
        tComissao.setText(String.valueOf(funcionario.getCom()));
        //tChefe.setText((CharSequence) funcionario.getChefe());
        //tDepartamento.setText((CharSequence) funcionario.getDepartamento());

        return view;
    }
}