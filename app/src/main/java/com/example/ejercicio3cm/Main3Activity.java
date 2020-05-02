package com.example.ejercicio3cm;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
public class Main3Activity extends AppCompatActivity implements View.OnClickListener {
    Button boton;
    private Spinner select;
    planta plantax;
    EditText etname, etid, etflores;
    ArrayList<planta> plantas=new ArrayList<>();
    String pasa;
    private ArrayList<typeItem> arrayimagen;
    private spinnerAdapter adapt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        initList();
        Spinner spinnertype = findViewById(R.id.select);
        adapt= new spinnerAdapter(this, arrayimagen);
        spinnertype.setAdapter(adapt);
        spinnertype.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                typeItem clickedOtem= (typeItem) parent.getItemAtPosition(position);
                String clickedTypeName =clickedOtem.getTypeName();
                Toast.makeText(Main3Activity.this,"Seleccionó:"+clickedTypeName,Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        boton=findViewById(R.id.boton);
        etname=findViewById(R.id.etname);
        etid=findViewById(R.id.etid);
        etflores=findViewById(R.id.etflores);
        boton.setOnClickListener(this);

        /*
        select=(Spinner) findViewById(R.id.select);
        ArrayList<String> elementos=new ArrayList<>();
        elementos.add("Árbol");
        elementos.add("Arbusto");
        elementos.add("Hierba");
        elementos.add("Alimenticia");
        elementos.add("Medicinal");
        elementos.add("Ornamental");
        ArrayAdapter adp = new ArrayAdapter(Main3Activity.this, android.R.layout.simple_spinner_dropdown_item, elementos);
        select.setAdapter(adp);
        select.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String elemento=(String) select.getAdapter().getItem(position);
                Toast.makeText(Main3Activity.this, "Seleccionaste:"+elemento, Toast.LENGTH_SHORT).show();
                pasa=elemento;
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
        */

    }
    private void initList(){
        arrayimagen=new ArrayList<>();
        arrayimagen.add(new typeItem("Árbol",R.drawable.arbol));
        arrayimagen.add(new typeItem("Arbusto",R.drawable.arbusto));
        arrayimagen.add(new typeItem("Comestible",R.drawable.comestibles));
        arrayimagen.add(new typeItem("Hierbas",R.drawable.hierbas));
        arrayimagen.add(new typeItem("Ornamental",R.drawable.flor));
        arrayimagen.add(new typeItem("Medicinal",R.drawable.medicinal));
    }
    @Override
    public void onClick(View v) {
        switch(v.getId()) {
            case R.id.boton:
                if(valida()){
                    Bundle bundle =new Bundle();
                    bundle.putSerializable("planta",plantax);
                    bundle.putSerializable("array",plantas);
                    Intent intent = new Intent(Main3Activity.this, Main4Activity.class);
                    intent.putExtras(bundle);
                    startActivity(intent);

                }
                break;
            default:break;
        }
    }

    private boolean valida() {
        if(etid.getText().length()==0){
            Toast.makeText(Main3Activity.this, "Campo ID vacío", Toast.LENGTH_SHORT).show();
            return false;
        }else{
            if(etname.getText().length()==0 || etname.getText().length()<2){
                Toast.makeText(Main3Activity.this, "Campo nombre vacío o incompleto", Toast.LENGTH_SHORT).show();
                return false;
            }else{
                if(etflores.getText().length() < 2){
                    Toast.makeText(Main3Activity.this, "Campo de flores vacío o incompleto", Toast.LENGTH_SHORT).show();
                    return false;
                }else{
                    try{
                        int num =Integer.parseInt(etid.getText().toString());
                        plantax=new planta(etflores.getText().toString(), pasa,num, etname.getText().toString());
                        plantas.add(plantax);
                        Toast.makeText(Main3Activity.this, "Planta verificada", Toast.LENGTH_SHORT).show();
                        return true;
                    }catch(Exception e){
                        Toast.makeText(Main3Activity.this, "Verifica los datos", Toast.LENGTH_SHORT).show();
                        return false;
                    }
                }
            }
        }
    }
}
