package br.edu.ifsp.hto.prova2.presenter;

import android.content.Context;
import android.widget.ListView;

import java.util.List;

import br.edu.ifsp.hto.prova2.adapter.DepartamentoAdapter;
import br.edu.ifsp.hto.prova2.domain.Departamento;
import br.edu.ifsp.hto.prova2.service.DepartamentoService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ListarDepartamentosPresenter {
    public static String baseURL = "http://186.223.104.119:9090/";

    public void listarDepartamentos(final Context context, final ListView listView){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(baseURL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        DepartamentoService service = retrofit.create(DepartamentoService.class);
        Call<List<Departamento>> call = service.listarDepartamentos();

        call.enqueue(new Callback<List<Departamento>>() {
            @Override
            public void onResponse(Call<List<Departamento>> call, Response<List<Departamento>> response) {
                List<Departamento> list = response.body();

                listView.setAdapter(new DepartamentoAdapter(context, list));
            }

            @Override
            public void onFailure(Call<List<Departamento>> call, Throwable t) {

            }
        });
    }
}
