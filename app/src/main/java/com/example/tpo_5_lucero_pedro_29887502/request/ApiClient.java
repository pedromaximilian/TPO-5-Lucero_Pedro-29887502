package com.example.tpo_5_lucero_pedro_29887502.request;

import android.content.Context;
import android.content.SharedPreferences;

import com.example.tpo_5_lucero_pedro_29887502.model.Usuario;

public class ApiClient {
    private static SharedPreferences sp;

    private static SharedPreferences conectar(Context context){
        if (sp==null){
            sp=context.getSharedPreferences("datos",0);

        }
        return sp;
    }

    public static void guardar(Context context, Usuario usuario){
        SharedPreferences sp= conectar(context);
        SharedPreferences.Editor editor=sp.edit();
        editor.putLong("dni",usuario.getDni());
        editor.putString("apellido", usuario.getApellido());
        editor.putString("nombre", usuario.getNombre());
        editor.putString("mail", usuario.getMail());
        editor.putString("pass", usuario.getPassword());

        editor.commit();
    }


    public static Usuario leer(Context context){

        SharedPreferences sp=conectar(context);
        Long dni=sp.getLong("dni", -1);
        String apellido= sp.getString("apellido", "-1");
        String nombre= sp.getString("nombre", "-1");
        String email= sp.getString("mail", "-1");
        String epass = sp.getString("pass", "-1");


        Usuario usuario = new Usuario(dni, apellido, nombre, email, epass);

        return usuario;
    }

    public static Usuario login(Context context, String mail, String pass){
        Usuario usuario = null;
        SharedPreferences sp=conectar(context);
        Long dni=sp.getLong("dni", -1);
        String apellido= sp.getString("apellido", "-1");
        String nombre= sp.getString("nombre", "-1");
        String email= sp.getString("mail", "-1");
        String epass = sp.getString("pass", "-1");

        if (email.equals(mail)&epass.equals(pass)){
            usuario = new Usuario(dni, apellido, nombre, email, pass);
        }
        return usuario;
    }




}
