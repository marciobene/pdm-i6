package br.edu.ifsp.hto.rolejusto.activity;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import br.edu.ifsp.hto.rolejusto.R;
import br.edu.ifsp.hto.rolejusto.domain.Role;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class CalculoRoleActivity extends DebugActivity {

    private Context context = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculo_role);

        Bundle args = getIntent().getExtras();

        String totalRole = Double.toString(args.getDouble("totalRole"));
        String valorPorPessoa = Double.toString(args.getDouble("valorPorPessoa"));
        String totalCombustivel = Double.toString(args.getDouble("totalGastoEmCombustivel"));

        TextView tvValorTotalRole = (TextView) findViewById(R.id.tvValorTotalRole);
        tvValorTotalRole.setText(totalRole);
        TextView tvValorTotalCombustivel = (TextView) findViewById(R.id.tvValorTotalCombustivel);
        tvValorTotalCombustivel.setText(totalCombustivel);
        TextView tvValorPessoa = (TextView) findViewById(R.id.tvValorPessoa);
        tvValorPessoa.setText(valorPorPessoa);


    }

    public View grava(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_novo_veiculo, container, false);

        Button btGravarVeiculo = (Button) view.findViewById(R.id.btGravarVeiculo);
        btGravarVeiculo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gravarRole();
            }
        });

        context = container.getContext();
        return view;
    }

    public void gravarRole(){
        String baseURL = MainActivity.ip();

        Bundle args = getIntent().getExtras();

        double distancia = 0;
        double totalPedagios = 0;
        double valorCombustivel = 0;
        double totalGastoEmCombustivel = 0;
        double consumo = 0;
        int totalPessoas =0;
        double valorTotalGasto = 0;
        double valorPorPessoa = 0;

        distancia = args.getDouble("distancia");
        totalPedagios = args.getDouble("totalPedagios");
        valorCombustivel = args.getDouble("valorCombustivel");
        totalGastoEmCombustivel = args.getDouble("totalGastoEmCombustivel");
        consumo = args.getDouble("consumo");
        totalPessoas = args.getInt("totalPessoas");
        valorTotalGasto = args.getDouble("valorTotalGasto");
        valorPorPessoa = args.getDouble("valorPorPessoa");

        Role role = new Role();

        role.setDistancia(distancia);
        role.setTotalPedagio(totalPedagios);
        role.setValorLitroCombustivel(valorCombustivel);
        role.setValorTotalCombustivel(totalGastoEmCombustivel);
        role.setConsumo(consumo);
        role.setQtdPessoas(totalPessoas);
        role.setValorTotalRole(valorTotalGasto);
        role.setValorPorPessoa(valorPorPessoa);

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
