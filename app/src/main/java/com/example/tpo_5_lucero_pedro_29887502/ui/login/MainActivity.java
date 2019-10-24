package com.example.tpo_5_lucero_pedro_29887502.ui.login;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.tpo_5_lucero_pedro_29887502.R;
import com.example.tpo_5_lucero_pedro_29887502.model.LiveDataUsuarioViewModel;
import com.example.tpo_5_lucero_pedro_29887502.model.Usuario;
import com.example.tpo_5_lucero_pedro_29887502.request.ApiClient;
import com.example.tpo_5_lucero_pedro_29887502.ui.registro.RegistroActivity;

public class MainActivity extends AppCompatActivity {
    private LiveDataUsuarioViewModel liveDataUsuarioViewModel;
    private ViewModelMain viewModelMain;

    Usuario usuario;

    Button btnRegistro, btnIngresar;
    EditText etDni, etNombre, etApellido, etPass, etMail;
    TextView tvEstado;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        configView();
    }

    private void configView() {

        usuario = new Usuario();
        liveDataUsuarioViewModel = ViewModelProviders.of(this).get(LiveDataUsuarioViewModel.class);
        viewModelMain= ViewModelProviders.of(this).get(ViewModelMain.class);
        etMail = findViewById(R.id.etmail_login);
        etPass = findViewById(R.id.etpassword_login);
        btnIngresar = findViewById(R.id.btnIngresar);
        tvEstado = findViewById(R.id.tvEstado);
        btnIngresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                viewModelMain.ingresar(etMail.getText().toString(), etPass.getText().toString());


            }
        });//End btnIngresar

        btnRegistro = findViewById(R.id.btnRegistro);
        btnRegistro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                startActivity(new Intent(getApplicationContext(), RegistroActivity.class).addFlags(Intent.FLAG_ACTIVITY_NEW_TASK));
            }
        });

        final Observer<String> estadoObserver = new Observer<String>() {
            @Override
            public void onChanged(String s) {
                tvEstado.setText(s);
            }
        };


        final Observer<Usuario> usuarioObserverLogin = new Observer<Usuario>() {
            @Override
            public void onChanged(Usuario usuario) {
                if (usuario!=null){
                    etMail.setText(usuario.getMail());
                    etPass.setText(usuario.getPassword());
                }
            }
        };

        viewModelMain.getEstado().observe(this, estadoObserver);

        liveDataUsuarioViewModel.getUsuario().observe(this, usuarioObserverLogin);


    }//end configView()
}
