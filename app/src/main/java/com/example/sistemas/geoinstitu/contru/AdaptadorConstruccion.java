package com.example.sistemas.geoinstitu.contru;

import android.animation.Animator;
import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.sistemas.geoinstitu.R;

import java.util.List;

public class AdaptadorConstruccion extends RecyclerView.Adapter<AdaptadorConstruccion.DatosViewHolder> {

    List<Edificio> datos;

    public AdaptadorConstruccion(List<Edificio> datos){
        this.datos = datos ;

    }

    public static class DatosViewHolder extends RecyclerView.ViewHolder{
        CardView cv;
        TextView nombre,estado,inversion,cambios;
        ImageView geolo;
        private Context context;
        public DatosViewHolder(View itemView) {
            super(itemView);
            context = itemView.getContext();
            cv = (CardView) itemView.findViewById(R.id.cvc);
            nombre = (TextView) itemView.findViewById(R.id.tvc1);
            estado = (TextView) itemView.findViewById(R.id.tvc2);
            inversion = (TextView) itemView.findViewById(R.id.tvc3);
            cambios = (TextView) itemView.findViewById(R.id.tvc4);
           // geolo = (ImageView) itemView.findViewById(R.id.geolo);
        }
    }

    @Override
    public DatosViewHolder onCreateViewHolder(ViewGroup viewGroup , int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.targetaconstrucciones, viewGroup,false);
        DatosViewHolder pvh = new DatosViewHolder(v);
        return pvh;
    }

    @Override
    public void onBindViewHolder(final DatosViewHolder holder, final int position) {
        holder.nombre.setText(datos.get(position).getNombreEstablecimiento());
        holder.estado.setText(datos.get(position).getEstado());
        holder.inversion.setText(datos.get(position).getInvercion());
        holder.cambios.setText(datos.get(position).getIntervencion());
        /*holder.geolo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(holder.context,MapsActivity.class);
                i.putExtra("v",datos.get(position).getCordenadas().get(0));
                i.putExtra("v1",datos.get(position).getCordenadas().get(1));
                i.putExtra("nombre",datos.get(position).getNombreSede());
                holder.context.startActivity(i);
            }
        });*/
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
