package mx.edu.uacm.mismascotas;

import android.animation.ObjectAnimator;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MascotasAdapter extends RecyclerView.Adapter<MascotasAdapter.ViewHolderMascotas> {

    private ArrayList<Mascota> listMascotas;
    private ArrayList<Mascota> listMascotasDestacadas;

    public MascotasAdapter(ArrayList<Mascota> listMascotas) {
        this.listMascotas = listMascotas;
        this.listMascotasDestacadas = new ArrayList<>();
    }

    @Override
    public MascotasAdapter.ViewHolderMascotas onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.elemento, parent, false);
        return new ViewHolderMascotas(view);
    }

    @Override
    public void onBindViewHolder(MascotasAdapter.ViewHolderMascotas holder, int position) {
        Mascota mascota = listMascotas.get(position);

        holder.etiNombre.setText(mascota.getNombre());
        holder.etiDescripcion.setText(mascota.getDescripcion());
        holder.imagen.setImageResource(mascota.getImagen());

        holder.agregado.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listMascotasDestacadas.add(mascota);
                Intent intent = new Intent(view.getContext(), DestacadoActivity.class);
                intent.putExtra("listMascotasDestacadas", listMascotasDestacadas);
                view.getContext().startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return listMascotas.size();
    }

    public class ViewHolderMascotas extends RecyclerView.ViewHolder {

        TextView etiNombre, etiDescripcion;
        ImageView imagen;
        // Crear una animación de rotación
        Button agregado;
        public ViewHolderMascotas(View itemView) {
            super(itemView);
            etiDescripcion = itemView.findViewById(R.id.idDescribe);
            etiNombre = itemView.findViewById(R.id.idNombre);
            imagen = itemView.findViewById(R.id.idImagen);
            agregado = itemView.findViewById(R.id.agregado);
            ObjectAnimator rotation = ObjectAnimator.ofFloat(imagen, "rotation", 0f, 360f);
            rotation.setDuration(13000);
            rotation.setRepeatCount(ObjectAnimator.INFINITE);
            rotation.start();
        }
    }
}