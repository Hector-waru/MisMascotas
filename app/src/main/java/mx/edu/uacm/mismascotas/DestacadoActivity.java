package mx.edu.uacm.mismascotas;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class DestacadoActivity extends AppCompatActivity {

    TextView etiNombre, etiDescripcion;
    ImageView imagen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.destacado);

        etiNombre = findViewById(R.id.idNombre);
        etiDescripcion = findViewById(R.id.idDescribe);
        imagen = findViewById(R.id.idImagen);

        Intent intent = getIntent();
        if (intent != null && intent.hasExtra("listMascotasDestacadas")) {
            ArrayList<Mascota> listMascotasDestacadas = intent.<Mascota>getParcelableArrayListExtra("listMascotasDestacadas");

            // Supongamos que solo se destaca la primera mascota de la lista
            if (!listMascotasDestacadas.isEmpty()) {
                Mascota mascotaDestacada = listMascotasDestacadas.get(0);

                etiNombre.setText(mascotaDestacada.getNombre());
                etiDescripcion.setText(mascotaDestacada.getDescripcion());
                imagen.setImageResource(mascotaDestacada.getImagen());
            }
        }
    }
}