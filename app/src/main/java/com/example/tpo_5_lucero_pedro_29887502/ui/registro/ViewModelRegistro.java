package com.example.tpo_5_lucero_pedro_29887502.ui.registro;

import android.app.Application;
import android.content.Context;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.tpo_5_lucero_pedro_29887502.model.Usuario;
import com.example.tpo_5_lucero_pedro_29887502.request.ApiClient;

public class ViewModelRegistro extends AndroidViewModel {

    private Context context;
    private  Usuario usuario;
    private MutableLiveData<Usuario> usuarioMutableLiveData;




    public ViewModelRegistro(@NonNull Application application) {
        super(application);

        context = application.getApplicationContext();
    }


    public void guardar(Usuario usuario){
        ApiClient.guardar(context, usuario);

    }


    public LiveData<Usuario> getEstado(){
        if (usuario==null){
            usuarioMutableLiveData = new MutableLiveData<Usuario>();
        }
        return usuarioMutableLiveData;
    }


    public void setUsuario(Usuario usuario){
        if (usuario!=null){
            usuarioMutableLiveData.setValue(usuario);
        }


    }





}
