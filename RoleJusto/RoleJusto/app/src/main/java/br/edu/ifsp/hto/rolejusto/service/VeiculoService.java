package br.edu.ifsp.hto.rolejusto.service;

import java.util.List;

import br.edu.ifsp.hto.rolejusto.domain.Veiculo;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface VeiculoService {
    @GET("veiculo/list")
    Call<List<Veiculo>> listarVeiculos();


    @POST("veiculo/new")
    Call<Veiculo> criarVeiculo(@Body Veiculo veiculo);
}
