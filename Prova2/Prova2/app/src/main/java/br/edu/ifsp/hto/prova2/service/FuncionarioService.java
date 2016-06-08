package br.edu.ifsp.hto.prova2.service;

import java.util.List;

import br.edu.ifsp.hto.prova2.domain.Funcionario;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface FuncionarioService {
    @GET("funcionario/list")
    Call<List<Funcionario>> listarFuncionarios();


    @POST("funcionario/new")
    Call<Funcionario> criarFuncionario(@Body Funcionario funcionario);
}
