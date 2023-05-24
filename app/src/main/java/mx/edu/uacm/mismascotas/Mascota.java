package mx.edu.uacm.mismascotas;

import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.parceler.Parcel;

@Parcel
public class Mascota implements Parcelable {
    private String nombre;
    private int descripcion;
    private int imagen;

    public Mascota(){

    }
    public Mascota(String nombre, int descripcion, int imagen) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.imagen = imagen;
    }

    protected Mascota(android.os.Parcel in) {
        nombre = in.readString();
        descripcion = in.readInt();
        imagen = in.readInt();
    }

    public static final Creator<Mascota> CREATOR = new Creator<Mascota>() {
        @Override
        public Mascota createFromParcel(android.os.Parcel in) {
            return new Mascota(in);
        }

        @Override
        public Mascota[] newArray(int size) {
            return new Mascota[size];
        }
    };

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(int descripcion) {
        this.descripcion = descripcion;
    }

    public int getImagen() {
        return imagen;
    }

    public void setImagen(int imagen) {
        this.imagen = imagen;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull android.os.Parcel parcel, int i) {
        parcel.writeString(nombre);
        parcel.writeInt(descripcion);
        parcel.writeInt(imagen);
    }
}
