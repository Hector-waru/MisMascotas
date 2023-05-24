package mx.edu.uacm.mismascotas;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.ClipData;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;

public class SegundoActivity extends AppCompatActivity {
/*donde estaran nuestros objetos*/
    ArrayList<Mascota> listMascotas;
/*la referencia a el Recycler*/
    RecyclerView recyclerMascotas;
//boton de prueba
    Button prueba;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_segundo);
        //
        /*boton perros*/
        prueba = findViewById(R.id.prueba);
        prueba.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent p = new Intent(SegundoActivity.this,DestacadoActivity.class);
                startActivity(p);
            }
        });

        //
        /*Adicion de elementos*/
        listMascotas=new ArrayList<>();
        /*referencia en el xml donde esta el recycler view*/
        recyclerMascotas = (RecyclerView) findViewById(R.id.recyclerId);
        recyclerMascotas.setLayoutManager(new LinearLayoutManager(this));

        llenarMascotas();
        MascotasAdapter adapter = new MascotasAdapter(listMascotas);
        recyclerMascotas.setAdapter(adapter);
    }
    /*alimentacion de lista*/
    private void llenarMascotas(){
        listMascotas.add(new Mascota("Oddin",R.string.perro_uno,R.mipmap.perro_uno));
        listMascotas.add(new Mascota("Filus",R.string.perro_dos,R.mipmap.perro_dos));
        listMascotas.add(new Mascota("Max",R.string.perro_tres,R.mipmap.perro_tres));
        listMascotas.add(new Mascota("Gul",R.string.perro_cuatro,R.mipmap.perro_cutro));
        listMascotas.add(new Mascota("Laika",R.string.perro_tres,R.mipmap.perro_uno));
    }

}