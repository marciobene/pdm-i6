package br.edu.ifsp.hto.rolejusto.service;

import java.util.List;

import br.edu.ifsp.hto.rolejusto.domain.Role;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface RoleService {
    @GET("role/list")
    Call<List<Role>> listarRoles();


    @POST("role/new")
    Call<Role> criarRole(@Body Role role);
}
