package com.example.tpo_5_lucero_pedro_29887502.ui.login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.tpo_5_lucero_pedro_29887502.R;
import com.example.tpo_5_lucero_pedro_29887502.model.Usuario;
import com.example.tpo_5_lucero_pedro_29887502.request.ApiClient;
import com.example.tpo_5_lucero_pedro_29887502.ui.registro.RegistroActivity;

public class MainActivity extends AppCompatActivity {

    Usuario usuario;

    Button btnRegistro, btnIngresar;
    EditText etDni, etNombre, etApellido, etPass, etMail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        configView();
    }

    private void configView() {


        etMail = findViewById(R.id.etmail_login);
        etPass = findViewById(R.id.etpassword_login);
        btnIngresar = findViewById(R.id.btnIngresar);
        btnIngresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                usuario = new Usuario();
                usuario = ApiClient.login(getApplicationContext(), etMail.getText().toString(), etPass.getText().toString());
                if (usuario==null){
                    Toast.makeText(MainActivity.this, "Verifique Contraseña", Toast.LENGTH_LONG).show();
                }else{
                    startActivity(new Intent(getApplicationContext(), RegistroActivity.class));
                }

            }
        });//End btnIngresar

        btnRegistro = findViewById(R.id.btnRegistro);
        btnRegistro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), RegistroActivity.class));
            }
        });


    }//end configView()
}
