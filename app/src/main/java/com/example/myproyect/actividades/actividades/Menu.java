package com.example.myproyect.actividades.actividades;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

import com.example.myproyect.R;
import com.example.myproyect.actividades.clases.InterfaceMenu;
import com.example.myproyect.actividades.fragmentos.Doctor1Fragment;
import com.example.myproyect.actividades.fragmentos.Doctor2Fragment;
import com.example.myproyect.actividades.fragmentos.Doctor3Fragment;
import com.example.myproyect.actividades.fragmentos.Doctor4Fragment;

public class Menu extends AppCompatActivity implements InterfaceMenu {
    Fragment[] fragments;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        fragments = new Fragment[4];
        fragments[0] = new Doctor1Fragment();
        fragments[1] = new Doctor2Fragment();
        fragments[2] = new Doctor3Fragment();
        fragments[3] = new Doctor4Fragment();
        int idBoton = getIntent().getIntExtra("idBoton", -1);
        onClickMenu(idBoton);
    }

    @Override
    public void onClickMenu(int idBoton) {
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(R.id.menRelMenu, fragments[idBoton]);
        ft.commit();
    }
}