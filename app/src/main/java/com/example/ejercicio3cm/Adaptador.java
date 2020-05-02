package com.example.ejercicio3cm;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.ArrayList;
public class Adaptador extends BaseAdapter {
    private static LayoutInflater inflater=null;
    Context contexto;
    int i=0;
    planta plantax;
    ArrayList<planta> plantas=new ArrayList<planta>();
    public Adaptador(Context contexto, planta plantax, ArrayList<planta> plantas) {
        this.contexto = contexto;
        this.plantax = plantax;
        this.plantas = plantas;
        inflater=(LayoutInflater) contexto.getSystemService(contexto.LAYOUT_INFLATER_SERVICE);
    }
    @Override
    public int getCount() {
        return plantas.size();
    }
    @Override
    public Object getItem(int position) {
        return null;
    }
    @Override
    public long getItemId(int position) {
        return Long.valueOf(R.id.etid);
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final View vista=inflater.inflate(R.layout.elemento_lista, null);
        ImageView iv=vista.findViewById(R.id.ivtipo);
        TextView tvtipo=vista.findViewById(R.id.tvtipo);
        TextView tvflores=vista.findViewById(R.id.tvflores);
        TextView tvnombre=vista.findViewById(R.id.tvname);
        TextView tvid=vista.findViewById(R.id.tvid);
        //Puedo acceder a cada elemento del último objeto agregado, pero no a desplegar todos los objetos con sus respectivos elementos.
        tvnombre.setText("Nombre: "+plantax.getNombre());
        tvtipo.setText("Tipo: "+plantax.getTipo());
        tvflores.setText(plantax.getFlores()+" da flores");
        tvid.setText("id: "+plantas.get(i).getId());


        return vista;
        /*
        Este es el código que pretendía usar, para acceder  cada uno de los elementos del array e irlos desplegando secuencialmente
        pero no funcionó
        tvnombre.setText(plantas.get(i).getNombre());
        tvflores.setText(plantas.get(i).getFlores());
        tvid.setText(plantas.get(i).getId());
        RECUPERAR ELEMENTOS DEL SPINNER ADAPTER:
        tvtipo.setText();
        iv.setImageResource();

        i++;*/
    }
}