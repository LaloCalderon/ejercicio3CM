package com.example.ejercicio3cm;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
public class Main2Activity extends AppCompatActivity implements View.OnClickListener {
    ImageView botonlistar, botonanadir;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        botonanadir=findViewById(R.id.botonanadir);
        botonlistar=findViewById(R.id.botonlistar);
        botonanadir.setOnClickListener(this);
        botonlistar.setOnClickListener(this);}
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.botonanadir:
                //Activity 3 encargada de agregar una planta a la lista.
                //Bundle bundle =new Bundle();
                //bundle.putInt("siete",7);
                Intent intent = new Intent(Main2Activity.this,Main3Activity.class);
                //intent.putExtras(bundle);
                startActivity(intent);
                break;
            case R.id.botonlistar:
                //Activity 4 encargada de listar:
                Intent intento = new Intent(Main2Activity.this,Main4Activity.class);
                startActivity(intento);
                break;
            default:
                break;
        }
    }
}
