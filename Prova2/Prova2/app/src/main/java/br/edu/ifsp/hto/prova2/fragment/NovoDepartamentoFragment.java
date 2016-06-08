package br.edu.ifsp.hto.prova2.fragment;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import br.edu.ifsp.hto.prova2.R;
import br.edu.ifsp.hto.prova2.domain.Departamento;
import br.edu.ifsp.hto.prova2.service.DepartamentoService;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class NovoDepartamentoFragment extends Fragment {

    public NovoDepartamentoFragment() {

    }

    private Context context;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_novo_departamento, container, false);

        Button btGravarDepartamento = (Button) view.findViewById(R.id.btGravarDepto);
        btGravarDepartamento.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gravarDepartamento();
            }
        });

        context = container.getContext();
        return view;
    }



    public void gravarDepartamento(){
        String baseURL = "http://186.223.104.119:9090/";

        EditText eNomeDepto  = (EditText) getView().findViewById(R.id.eNomeDepto);
        EditText eLocal = (EditText) getView().findViewById(R.id.eLocal);


        Departamento departamento = new Departamento();
                departamento.setNome(eNomeDepto.getText().toString());
        departamento.setLocal(eLocal.getText().toString());



        eNomeDepto.setText("");
        eLocal.setText("");


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

        DepartamentoService service = retrofit.create(DepartamentoService.class);

        Call<Departamento> call = service.criarDepartamento(departamento);

        call.enqueue(new Callback<Departamento>() {
            @Override
            public void onResponse(Call<Departamento> call, Response<Departamento> response) {

            }

            @Override
            public void onFailure(Call<Departamento> call, Throwable t) {

            }
        });
    }
}
