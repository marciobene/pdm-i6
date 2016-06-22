package br.edu.ifsp.hto.rolejusto.fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import br.edu.ifsp.hto.rolejusto.R;
import br.edu.ifsp.hto.rolejusto.activity.CalculoRoleActivity;
import br.edu.ifsp.hto.rolejusto.activity.MainActivity;
import br.edu.ifsp.hto.rolejusto.domain.Role;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class NovoRoleFragment extends Fragment implements AdapterView.OnItemSelectedListener {

    public NovoRoleFragment() {

    }

    private Context context;

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_novo_role, container, false);

        Button btCalcularRole = (Button) view.findViewById(R.id.btCalcularRole);
        btCalcularRole.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calcularRole();
            }
        });

        context = container.getContext();
        return view;
    }


    public void calcularRole(){
        String baseURL = MainActivity.ip();

        EditText eDistancia         = (EditText) getView().findViewById(R.id.eDistancia);
        EditText eTotalPedagio      = (EditText) getView().findViewById(R.id.eTotalPedagio);
        EditText eTotalPessoas      = (EditText) getView().findViewById(R.id.eTotalPessoas);
        EditText eValorCombustivel  = (EditText) getView().findViewById(R.id.eValorCombustivel);
        EditText eConsumo           = (EditText) getView().findViewById(R.id.eConsumo);

        double distancia = Double.parseDouble(eDistancia.getText().toString());
        double totalPedagios = Double.parseDouble(eTotalPedagio.getText().toString());
        int totalPessoas = Integer.parseInt(eTotalPessoas.getText().toString());
        double valorCombustivel = Double.parseDouble(eValorCombustivel.getText().toString());
        double consumo = Double.parseDouble(eConsumo.getText().toString());

        double litros = distancia / consumo;
        double totalGastoEmCombustivel = litros * valorCombustivel;
        double valorTotalGasto = totalGastoEmCombustivel + totalPedagios;
        double valorPorPessoa = valorTotalGasto / totalPessoas;


        Intent intent = new Intent(context, CalculoRoleActivity.class);
        Bundle params = new Bundle();

        params.putDouble("distancia", distancia);
        params.putDouble("totalPedagios", totalPedagios);
        params.putInt("totalPessoas", totalPessoas);
        params.putDouble("valorCombustivel", valorCombustivel);
        params.putDouble("consumo", consumo);
        params.putDouble("totalRole", valorTotalGasto);
        params.putDouble("totalGastoEmCombustivel", totalGastoEmCombustivel);
        params.putDouble("valorPorPessoa", valorPorPessoa);

        intent.putExtras(params);
        startActivity(intent);

        Role role = new Role();

        role.setDistancia(distancia);
        role.setTotalPedagio(totalPedagios);
        role.setValorLitroCombustivel(valorCombustivel);
        role.setValorTotalCombustivel(totalGastoEmCombustivel);
        role.setConsumo(consumo);
        role.setQtdPessoas(totalPessoas);
        role.setValorTotalRole(valorTotalGasto);
        role.setValorPorPessoa(valorPorPessoa);

        eDistancia.setText("");
        eTotalPedagio.setText("");
        eTotalPessoas.setText("");
        eValorCombustivel.setText("");
        eConsumo.setText("");

//Debug
        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
        httpClient.addInterceptor(logging);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(baseURL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(httpClient.build())
                .build();

        br.edu.ifsp.hto.rolejusto.service.RoleService service = retrofit.create(br.edu.ifsp.hto.rolejusto.service.RoleService.class);

        Call<Role> call = service.criarRole(role);

        call.enqueue(new Callback<Role>() {
            @Override
            public void onResponse(Call<Role> call, Response<Role> response) {

            }

            @Override
            public void onFailure(Call<Role> call, Throwable t) {

            }
        });


    }
}
