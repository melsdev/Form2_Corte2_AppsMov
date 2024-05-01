package com.example.pruebarecycleview.adaptadores;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.pruebarecycleview.R;
import com.example.pruebarecycleview.clases.Usuario;
import com.squareup.picasso.Picasso;

import java.util.List;

public class UsuarioAdaptador extends RecyclerView.Adapter<UsuarioAdaptador.ViewHolder> {

    private List<Usuario> datos;

    public UsuarioAdaptador(List<Usuario> datos){
        this.datos = datos;
    }
    @NonNull
    @Override
    public UsuarioAdaptador.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_usuario, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull UsuarioAdaptador.ViewHolder holder, int position) {

        Usuario dato = datos.get(position);
        holder.bind(dato);
    }

    @Override
    public int getItemCount() {
        return datos.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{

        TextView txt_nombre_usuario, txt_curso_usuario;
        ImageView img_usuario;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txt_nombre_usuario = itemView.findViewById(R.id.txt_nombre_usuario);
            txt_curso_usuario = itemView.findViewById(R.id.txt_curso_usuario);
            img_usuario = itemView.findViewById(R.id.img_usuario);
        }

        public void bind(Usuario dato){
            txt_nombre_usuario.setText(dato.getNombre());
            txt_curso_usuario.setText(dato.getCurso());
            // imagen libreria
            Picasso.get().load(dato.getImagen()).into(img_usuario);
        }
    }
}
