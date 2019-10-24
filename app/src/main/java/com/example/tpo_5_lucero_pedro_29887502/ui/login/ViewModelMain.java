package com.example.tpo_5_lucero_pedro_29887502.ui.login;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.tpo_5_lucero_pedro_29887502.model.Usuario;
import com.example.tpo_5_lucero_pedro_29887502.request.ApiClient;
import com.example.tpo_5_lucero_pedro_29887502.ui.registro.RegistroActivity;

public class ViewModelMain extends AndroidViewModel {

    Usuario usuario;



    Context context;

    private MutableLiveData<String> estadoLiveData;

    public ViewModelMain(@NonNull Application application) {
        super(application);

        context = application.getApplicationContext();

    }

    public void ingresar(String mail, String pass) {
        Usuario usuario = new Usuario();
        usuario = ApiClient.login(context, mail, pass);

        if (usuario == null) {
            setEstado("Verificar Datos Ingresados");
        } else {
            Intent intent = new Intent(context, RegistroActivity.class);
            intent.putExtra("usuario", usuario);
            context.startActivity(intent);
        }
    }

    public LiveData<String> getEstado(){
        if (estadoLiveData==null){
            estadoLiveData = new MutableLiveData<String>();
        }
        return estadoLiveData;
    }


    public void setEstado(String estado){
        if (estado!=null){
            estadoLiveData.setValue(estado);
        }


    }


}
