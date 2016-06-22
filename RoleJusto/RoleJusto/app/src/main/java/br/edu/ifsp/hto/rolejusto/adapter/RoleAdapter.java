package br.edu.ifsp.hto.rolejusto.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import br.edu.ifsp.hto.rolejusto.R;
import br.edu.ifsp.hto.rolejusto.domain.Role;

public class RoleAdapter extends BaseAdapter {
    private final Context context;
    private final List<Role> roles;

    public RoleAdapter(Context context, List roles){
        this.context = context;
        this.roles = roles;
    }


    @Override
    public int getCount() { return roles != null ? roles.size() : 0;  }

    @Override
    public Object getItem(int position) { return roles.get(position); }

    @Override
    public long getItemId(int position) { return roles.get(position).getN_role(); }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = LayoutInflater.from(context).inflate(R.layout.adapter_roles, parent, false);

        TextView tDistancia = (TextView) view.findViewById(R.id.tDistancia);
        TextView tTotalPedagio = (TextView) view.findViewById(R.id.tTotalPedagio);
        TextView tTotalPessoas = (TextView) view.findViewById(R.id.tTotalPessoas);
        TextView tValorCombustivel = (TextView) view.findViewById(R.id.tValorCombustivel);
        TextView tConsumo = (TextView) view.findViewById(R.id.tConsumo);
        TextView tTotalCombustivel = (TextView) view.findViewById(R.id.tTotalCombustivel);
        TextView tTotalRole = (TextView) view.findViewById(R.id.tTotalRole);
        TextView tValorPessoa = (TextView) view.findViewById(R.id.tValorPessoa);

        Role role = roles.get(position);
        tDistancia.setText(String.valueOf(role.getDistancia()));
        tTotalPedagio.setText(String.valueOf(role.getTotalPedagio()));
        tTotalPessoas.setText(String.valueOf(role.getQtdPessoas()));
        tValorCombustivel.setText(String.valueOf(role.getValorLitroCombustivel()));
        tConsumo.setText(String.valueOf(role.getConsumo()));
        tTotalCombustivel.setText(String.valueOf(role.getValorTotalCombustivel()));
        tTotalRole.setText(String.valueOf(role.getValorTotalRole()));
        tValorPessoa.setText(String.valueOf(role.getValorPorPessoa()));

        return view;
    }
}