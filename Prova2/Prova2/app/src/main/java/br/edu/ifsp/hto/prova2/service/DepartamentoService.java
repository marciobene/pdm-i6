package br.edu.ifsp.hto.prova2.service;

import java.util.List;

import br.edu.ifsp.hto.prova2.domain.Departamento;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface DepartamentoService {
    @GET("departamento/list")
    Call<List<Departamento>> listarDepartamentos();


    @POST("departamento/new")
    Call<Departamento> criarDepartamento(@Body Departamento departamento);
}
