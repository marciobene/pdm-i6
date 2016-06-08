package br.edu.ifsp.hto.prova2.presenter;

import android.content.Context;
import android.widget.ListView;

import java.util.List;

import br.edu.ifsp.hto.prova2.adapter.FuncionarioAdapter;
import br.edu.ifsp.hto.prova2.domain.Funcionario;
import br.edu.ifsp.hto.prova2.service.FuncionarioService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ListarFuncionariosPresenter {
    public static String baseURL = "http://186.223.104.119:9090/";

    public void listarFuncionarios(final Context context, final ListView listView){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(baseURL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        FuncionarioService service = retrofit.create(FuncionarioService.class);
        Call<List<Funcionario>> call = service.listarFuncionarios();

        call.enqueue(new Callback<List<Funcionario>>() {
            @Override
            public void onResponse(Call<List<Funcionario>> call, Response<List<Funcionario>> response) {
                List<Funcionario> list = response.body();

                listView.setAdapter(new FuncionarioAdapter(context, list));
            }

            @Override
            public void onFailure(Call<List<Funcionario>> call, Throwable t) {

            }
        });
    }
}
