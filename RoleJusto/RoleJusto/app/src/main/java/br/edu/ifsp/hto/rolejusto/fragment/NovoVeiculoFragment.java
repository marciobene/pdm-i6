package br.edu.ifsp.hto.rolejusto.fragment;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;


import br.edu.ifsp.hto.rolejusto.R;
import br.edu.ifsp.hto.rolejusto.activity.MainActivity;
import br.edu.ifsp.hto.rolejusto.domain.Veiculo;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class NovoVeiculoFragment extends Fragment {


    public NovoVeiculoFragment() {

    }

    private Context context;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_novo_veiculo, container, false);

        Button btGravarVeiculo = (Button) view.findViewById(R.id.btGravarVeiculo);
        btGravarVeiculo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gravarVeiculo();
            }
        });

        context = container.getContext();
        return view;
    }



    public void gravarVeiculo(){
        String baseURL = MainActivity.ip();

        EditText eNomeVei           = (EditText) getView().findViewById(R.id.eNomeVei);
        EditText eModeloVei         = (EditText) getView().findViewById(R.id.eModeloVei);
        EditText eAnoVei            = (EditText) getView().findViewById(R.id.eAnoVei);
        EditText eCombustivelVei    = (EditText) getView().findViewById(R.id.eCombustivelVei);
        EditText eConsumoVei        = (EditText) getView().findViewById(R.id.eConsumoVei);

        Veiculo veiculo = new Veiculo();

        veiculo.setNome_vei(eNomeVei.getText().toString());
        veiculo.setModelo_vei(eModeloVei.getText().toString());
        veiculo.setAno_vei(Integer.parseInt(eAnoVei.getText().toString()));
        veiculo.setCombustivel_vei(eCombustivelVei.getText().toString());
        veiculo.setConsumo_vei(Float.parseFloat(eConsumoVei.getText().toString()));


        eNomeVei.setText("");
        eModeloVei.setText("");
        eAnoVei.setText("");
        eCombustivelVei.setText("");
        eConsumoVei.setText("");

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

        br.edu.ifsp.hto.rolejusto.service.VeiculoService service = retrofit.create(br.edu.ifsp.hto.rolejusto.service.VeiculoService.class);

        Call<Veiculo> call = service.criarVeiculo(veiculo);

        call.enqueue(new Callback<Veiculo>() {
            @Override
            public void onResponse(Call<Veiculo> call, Response<Veiculo> response) {

            }

            @Override
            public void onFailure(Call<Veiculo> call, Throwable t) {

            }
        });
    }
}
