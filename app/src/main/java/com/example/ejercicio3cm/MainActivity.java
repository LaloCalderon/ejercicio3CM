package com.example.ejercicio3cm;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.ImageView;
public class MainActivity extends AppCompatActivity implements ExpandableListView.OnClickListener {
    ImageView boton1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        boton1=findViewById(R.id.boton1);
        boton1.setOnClickListener(this);}
    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.boton1:
                Intent intent=new Intent(MainActivity.this,Main2Activity.class);
                startActivity(intent);
                break;
            default:
                break;
        }
    }
}
