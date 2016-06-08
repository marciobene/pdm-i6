package br.edu.ifsp.hto.prova2.fragment;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;


import java.text.ParseException;
import java.text.SimpleDateFormat;

import br.edu.ifsp.hto.prova2.R;
//import br.edu.ifsp.hto.prova2.domain.Chefe;
//import br.edu.ifsp.hto.prova2.domain.Departamento;
import br.edu.ifsp.hto.prova2.domain.Funcionario;
import br.edu.ifsp.hto.prova2.service.FuncionarioService;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class NovoFuncionarioFragment extends Fragment {


    public NovoFuncionarioFragment() {

    }

    private Context context;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_novo_funcionario, container, false);

        Button btGravarFuncionario = (Button) view.findViewById(R.id.btGravarFuncionario);
        btGravarFuncionario.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gravarFuncionario();
            }
        });

        context = container.getContext();
        return view;
    }

    public void gravarFuncionario(){
        String baseURL = "http://186.223.104.119:9090/";

        EditText eNomeFuncionario   = (EditText) getView().findViewById(R.id.eNomeFuncionario);
        EditText eCargo             = (EditText) getView().findViewById(R.id.eCargo);
        EditText eDataAdm           = (EditText) getView().findViewById(R.id.eDataAdm);
        EditText eSal               = (EditText) getView().findViewById(R.id.eSal);
        EditText eCom               = (EditText) getView().findViewById(R.id.eCom);
        //EditText eChefe             = (EditText) getView().findViewById(R.id.eChefe);
        //EditText eDepto             = (EditText) getView().findViewById(R.id.eDepto);

        SimpleDateFormat sdf = new SimpleDateFormat("dd/mm/aaaa");

        Funcionario funcionario = new Funcionario();

        funcionario.setNome(eNomeFuncionario.getText().toString());
        funcionario.setCargo(eCargo.getText().toString());
        //funcionario.setDataAdmissao(sdf.parse(eDataAdm.getText().toString()));
        funcionario.setSal(Double.parseDouble(String.valueOf(eSal.getText())));
        funcionario.setCom(Double.parseDouble(String.valueOf(eCom.getText())));
        //funcionario.setChefe((Chefe)eChefe.getText());
        //funcionario.setDepartamento((Departamento)eDepto.getText());


        eNomeFuncionario.setText("");
        eCargo.setText("");
        eDataAdm.setText("");
        eSal.setText("");
        eCom.setText("");
        //eChefe.setText("");
        //eDepto.setText("");

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

        FuncionarioService service = retrofit.create(FuncionarioService.class);

        Call<Funcionario> call = service.criarFuncionario(funcionario);

        call.enqueue(new Callback<Funcionario>() {
            @Override
            public void onResponse(Call<Funcionario> call, Response<Funcionario> response) {

            }

            @Override
            public void onFailure(Call<Funcionario> call, Throwable t) {

            }
        });
    }
}
