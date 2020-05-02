package com.example.ejercicio3cm;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
public class Main4Activity extends AppCompatActivity {
    ListView lv;
    ArrayList<planta> plantas=new ArrayList<planta>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
        lv=findViewById(R.id.lv);
        planta plantax;
        Bundle bundle=new Bundle();
        bundle=getIntent().getExtras();
        planta obj=(planta) bundle.getSerializable("planta");
        plantas=(ArrayList<planta>) bundle.getSerializable("array");
        Adaptador adaptador = new Adaptador(this, obj,plantas);
        lv.setAdapter(adaptador);
    }
}