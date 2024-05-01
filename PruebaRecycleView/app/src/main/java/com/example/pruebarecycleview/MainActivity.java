package com.example.pruebarecycleview;

import android.content.Intent;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.pruebarecycleview.adaptadores.UsuarioAdaptador;
import com.example.pruebarecycleview.clases.Usuario;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements UsuarioAdaptador.OnItemClickListener {

    RecyclerView rcv_usuario;
    List<Usuario> listaUsuario = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        rcv_usuario = findViewById(R.id.rcv_usuario);

        Usuario usu1 = new Usuario("https://rickandmortyapi.com/api/character/avatar/72.jpeg", "Melissa", "Movil");
        Usuario usu2 = new Usuario("https://rickandmortyapi.com/api/character/avatar/120.jpeg", "Saray", "Web");
        Usuario usu3 = new Usuario("https://rickandmortyapi.com/api/character/avatar/190.jpeg", "Luis", "Movil");
        Usuario usu4 = new Usuario("https://rickandmortyapi.com/api/character/avatar/241.jpeg", "Gabriel", "Apps");

        listaUsuario.add(usu1);
        listaUsuario.add(usu2);
        listaUsuario.add(usu3);
        listaUsuario.add(usu4);

        rcv_usuario.setLayoutManager(new LinearLayoutManager(this));
        UsuarioAdaptador adapter = new UsuarioAdaptador(listaUsuario, this); // pass the listener to the adapter
        rcv_usuario.setAdapter(adapter);
    }

    @Override
    public void onItemClick(int position) {
        // handle click here, for example:
        Usuario usuario = listaUsuario.get(position);
        Intent intent = new Intent(MainActivity.this, DetalleUsuario.class);
        intent.putExtra("usuario", (CharSequence) usuario);
        startActivity(intent);
    }

}