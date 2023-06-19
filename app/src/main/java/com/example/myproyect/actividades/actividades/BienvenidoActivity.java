package com.example.myproyect.actividades.actividades;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.example.myproyect.R;
import com.example.myproyect.actividades.actividades.usuario.ActualizarDatosUSER_Activity;
import com.example.myproyect.actividades.clases.InterfaceMenu;
import com.example.myproyect.actividades.entidades.Usuario;

public class BienvenidoActivity extends AppCompatActivity implements InterfaceMenu {

    TextView lblSaludo;
    Button btnSalida,btnReservar, btnActualizarDatos, btnListarRsv;

    Usuario usuario = Login_Activity.getUsuario();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bienvenido);

        referencias();

        lblSaludo = findViewById(R.id.bieLblSaludo);
        String nomUsuario = usuario.getNombre();
        lblSaludo.setText("Bienvenido "+nomUsuario);

    }
    private void referencias(){
        btnListarRsv = findViewById(R.id.btnReservasRealizadas_BienvenidoActv);
        btnListarRsv.setOnClickListener(view -> {
            Intent intent = new Intent(this, ConsultarReservaUser_Activity.class);
            startActivity(intent);

        });
        btnReservar = findViewById(R.id.btnRealizarRsv_BienvenidoActy);
        btnReservar.setOnClickListener(view -> {
            Intent intent = new Intent(this, TablaReservaUser_Activity.class);
            startActivity(intent);
            finish();
        });
        btnSalida = findViewById(R.id.actvbtnCerrar);
        btnSalida.setOnClickListener(view -> {
            this.finish();
            Intent intent = new Intent(this, Login_Activity.class);
            startActivity(intent);
        });
        btnActualizarDatos = findViewById(R.id.btnActualizarDatos_BienvenidoActv);
        btnActualizarDatos.setOnClickListener(view -> {
            Intent intent = new Intent(this, ActualizarDatosUSER_Activity.class);
            startActivity(intent);
            finish();
        });
    }

    @Override
    public void onClickMenu(int idBoton) {
        Intent iMenu = new Intent(this, Menu.class);
        iMenu.putExtra("idBoton",idBoton);
        startActivity(iMenu);
     //   finish();
    }

    private void cerrarSesion() {
        //borrar sesion de la base de datos interna
        //Sesion sesion = new Sesion(this);
        //sesion.eliminarUsuario(1);
        //destruir historial
        this.finish();
        //mandar al login
        Intent iLogin = new Intent(this, Login_Activity.class);
        startActivity(iLogin);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

}