package br.com.mrcsfelipe.voo.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by markFelipe on 20/10/15.
 */
public class Voo implements Parcelable{

    private String nome;
    private Integer noVoo;
    private String destino;

    public Voo(String nome, Integer noVoo, String destino) {
        this.nome = nome;
        this.noVoo = noVoo;
        this.destino = destino;
    }

    public Voo (Parcel in){
        readFromParcel(in);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getNoVoo() {
        return noVoo;
    }

    public void setNoVoo(Integer noVoo) {
        this.noVoo = noVoo;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.nome);
        dest.writeInt(this.noVoo);
        dest.writeString(this.destino);
    }

    private void readFromParcel(Parcel in) {
        this.nome  = in.readString();
        this.noVoo = in.readInt();
        this.destino = in.readString();
    }

    public static final Parcelable.Creator CREATOR = new Parcelable.Creator<Voo>() {
        public Voo createFromParcel(Parcel in) {
            return new Voo(in);
        }

        public Voo[] newArray(int size) {
            return new Voo[size];
        }
    };
}
