package br.edu.ifsp.hto.rolejusto.presenter;

import android.content.Context;
import android.widget.ListView;

import java.util.List;

import br.edu.ifsp.hto.rolejusto.activity.MainActivity;
import br.edu.ifsp.hto.rolejusto.domain.Veiculo;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ListarVeiculoPresenter {
    public static String baseURL = MainActivity.ip();

    public void listarVeiculos(final Context context, final ListView listView){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(baseURL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        br.edu.ifsp.hto.rolejusto.service.VeiculoService service = retrofit.create(br.edu.ifsp.hto.rolejusto.service.VeiculoService.class);
        Call<List<Veiculo>> call = service.listarVeiculos();

        call.enqueue(new Callback<List<Veiculo>>() {
            @Override
            public void onResponse(Call<List<Veiculo>> call, Response<List<Veiculo>> response) {
                List<Veiculo> list = response.body();

                listView.setAdapter(new br.edu.ifsp.hto.rolejusto.adapter.VeiculoAdapter(context, list));
            }

            @Override
            public void onFailure(Call<List<Veiculo>> call, Throwable t) {

            }
        });
    }
}
