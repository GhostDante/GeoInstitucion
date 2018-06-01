package com.example.sistemas.geoinstitu;

import android.animation.Animator;
import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.sistemas.geoinstitu.contru.Construccion;

import java.util.List;

public class AdaptadorInstituciones extends RecyclerView.Adapter<AdaptadorInstituciones.DatosViewHolder> {

    List<Datos> datos;


    public AdaptadorInstituciones(List<Datos> datos){
        this.datos = datos ;

    }

    public static class DatosViewHolder extends RecyclerView.ViewHolder{
        CardView cv;
        TextView nombre,nombreSede,sede,direccion;
        ImageView geolo,constru;
        private Context context;
        public DatosViewHolder(View itemView) {
            super(itemView);
            context = itemView.getContext();
            cv = (CardView) itemView.findViewById(R.id.cv);
            nombre = (TextView) itemView.findViewById(R.id.tv1);
            nombreSede = (TextView) itemView.findViewById(R.id.tv2);
            sede = (TextView) itemView.findViewById(R.id.tv3);
            direccion = (TextView) itemView.findViewById(R.id.tv4);
            geolo = (ImageView) itemView.findViewById(R.id.geolo);
            constru = (ImageView) itemView.findViewById(R.id.constru);
        }
    }

    @Override
    public DatosViewHolder onCreateViewHolder(ViewGroup viewGroup , int i) {
       View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.targetainstituciones, viewGroup,false);
        DatosViewHolder pvh = new DatosViewHolder(v);
        return pvh;
    }

    @Override
    public void onBindViewHolder(final DatosViewHolder holder, final int position) {
        holder.nombre.setText(datos.get(position).getNombre());
        holder.nombreSede.setText(datos.get(position).getNombreSede());
        holder.sede.setText(datos.get(position).getSede());
        holder.direccion.setText(datos.get(position).getDireccion()+" "+datos.get(position).getBarrio());
        holder.geolo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(holder.context,MapsActivity.class);
                i.putExtra("v",datos.get(position).getCordenadas().get(0));
                i.putExtra("v1",datos.get(position).getCordenadas().get(1));
                i.putExtra("nombre",datos.get(position).getNombreSede());
                i.putExtra("sede",datos.get(position).getSede());
                i.putExtra("direccion",datos.get(position).getDireccion());
                holder.context.startActivity(i);
            }
        });
        holder.constru.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double uno =datos.get(position).getCordenadas().get(0);
                double dos =datos.get(position).getCordenadas().get(1);
                ((MainActivity) v.getContext()).actualizarListaPorContrucciones(uno,dos);
            }
        });
    }

    @Override
    public int getItemCount() {
        return datos.size();
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    @Override
    public void onViewAttachedToWindow(DatosViewHolder holder) {
        super.onViewAttachedToWindow(holder);
        animateCircularReveal(holder.itemView);
    }

    public void animateCircularReveal(View view){
        int centerX =0;
        int centerY =0;
        int startRadius = 0;
        int endRadius = Math.max(view.getWidth(),view.getHeight());
        Animator animation = null;
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
            animation = ViewAnimationUtils.createCircularReveal(view,centerX,centerY,startRadius,endRadius);
        }
        view.setVisibility(View.VISIBLE);
        animation.start();
    }
}
