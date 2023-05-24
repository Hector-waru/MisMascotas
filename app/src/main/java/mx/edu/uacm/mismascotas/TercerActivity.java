package mx.edu.uacm.mismascotas;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class TercerActivity extends AppCompatActivity {
    /*donde estaran nuestros objetos*/
    ArrayList<Mascota> listMascotas;
    /*la referencia a el Recycler*/
    RecyclerView recyclerMascotas;

    Button prueba;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tercer);
//
        /*boton perros*/
        prueba = findViewById(R.id.prueba);
        prueba.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent p = new Intent(TercerActivity.this,DestacadoActivity.class);
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
        listMascotas.add(new Mascota("Leopoldo",R.string.gato_uno,R.mipmap.gato_uno));
        listMascotas.add(new Mascota("Tocina",R.string.gato_dos,R.mipmap.gato_dos));
        listMascotas.add(new Mascota("Hamburgueso",R.string.gato_tres,R.mipmap.gato_tres));
        listMascotas.add(new Mascota("Mora",R.string.gato_cuatro,R.mipmap.gato_cuatro));
        listMascotas.add(new Mascota("Leono",R.string.gato_cuatro,R.mipmap.gato_uno));
    }
}