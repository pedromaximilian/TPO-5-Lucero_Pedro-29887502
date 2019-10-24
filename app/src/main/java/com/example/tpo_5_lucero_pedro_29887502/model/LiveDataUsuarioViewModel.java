package com.example.tpo_5_lucero_pedro_29887502.model;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class LiveDataUsuarioViewModel extends ViewModel {

    private MutableLiveData<Usuario> usuarioLiveData;

    public LiveData<Usuario> getUsuario(){
        if (usuarioLiveData==null){
            usuarioLiveData = new MutableLiveData<Usuario>();
        }
        return usuarioLiveData;
    }


    public void setUsuario(Usuario usuario){
        if (usuario!=null){
            usuarioLiveData.setValue(usuario);
        }


    }



}
