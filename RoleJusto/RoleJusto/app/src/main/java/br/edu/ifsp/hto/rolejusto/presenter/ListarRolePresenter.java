package br.edu.ifsp.hto.rolejusto.presenter;

import android.content.Context;
import android.widget.ListView;

import java.util.List;

import br.edu.ifsp.hto.rolejusto.activity.MainActivity;
import br.edu.ifsp.hto.rolejusto.domain.Role;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ListarRolePresenter {
    public static String baseURL = MainActivity.ip();

    public void listarRoles(final Context context, final ListView listView){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(baseURL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        br.edu.ifsp.hto.rolejusto.service.RoleService service = retrofit.create(br.edu.ifsp.hto.rolejusto.service.RoleService.class);
        Call<List<Role>> call = service.listarRoles();

        call.enqueue(new Callback<List<Role>>() {
            @Override
            public void onResponse(Call<List<Role>> call, Response<List<Role>> response) {
                List<Role> list = response.body();

                listView.setAdapter(new br.edu.ifsp.hto.rolejusto.adapter.RoleAdapter(context, list));
            }

            @Override
            public void onFailure(Call<List<Role>> call, Throwable t) {

            }
        });
    }
}
