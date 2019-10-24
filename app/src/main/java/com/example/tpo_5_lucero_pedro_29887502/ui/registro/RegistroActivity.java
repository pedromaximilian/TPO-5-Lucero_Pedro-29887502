package com.example.tpo_5_lucero_pedro_29887502.ui.registro;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.tpo_5_lucero_pedro_29887502.R;
import com.example.tpo_5_lucero_pedro_29887502.model.LiveDataUsuarioViewModel;
import com.example.tpo_5_lucero_pedro_29887502.model.Usuario;
import com.example.tpo_5_lucero_pedro_29887502.request.ApiClient;

public class RegistroActivity extends AppCompatActivity {


    EditText etDni, etNombre, etApellido, etEmail, etPassword;
    Button btnGuardar;

    private LiveDataUsuarioViewModel liveDataUsuarioViewModel;

    Usuario usuario = new Usuario();








    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);



        configView();
    }

    private void configView() {

        usuario = new Usuario();
        usuario = ApiClient.leer(getApplicationContext());
        liveDataUsuarioViewModel = ViewModelProviders.of(this).get(LiveDataUsuarioViewModel.class);


        etDni = findViewById(R.id.etRegistro_dni);
        etNombre = findViewById(R.id.etRegistro_nombre);
        etApellido = findViewById(R.id.etRegistro_apellido);
        etEmail= findViewById(R.id.etRegistro_email);
        etPassword = findViewById(R.id.etRegistro_pass);
        btnGuardar = findViewById(R.id.btnGuardar);
        btnGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                Usuario usuario = new Usuario();

                usuario.setDni(Long.parseLong(etDni.getText().toString()));
                usuario.setApellido(etApellido.getText().toString());
                usuario.setNombre(etNombre.getText().toString());
                usuario.setMail(etEmail.getText().toString());
                usuario.setPassword(etPassword.getText().toString());


                ApiClient.guardar(getApplicationContext(), usuario);
            }

        });


        final Observer<Usuario> usuarioObserver = new Observer<Usuario>() {
            @Override
            public void onChanged(Usuario usuario) {
                if (usuario!=null){
                    etDni.setText(String.valueOf(usuario.getDni())+"");
                    etApellido.setText(String.valueOf(usuario.getApellido())+"");
                    etNombre.setText(usuario.getNombre()+"");
                    etEmail.setText(usuario.getMail()+"");
                    etPassword.setText(usuario.getPassword()+"");
                }
            }
        };

        liveDataUsuarioViewModel.getUsuario().observe(this, usuarioObserver);


    }
}
