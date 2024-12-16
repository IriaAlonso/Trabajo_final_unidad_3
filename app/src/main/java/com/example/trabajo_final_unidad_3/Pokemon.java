package com.example.trabajo_final_unidad_3;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

public class Pokemon implements Parcelable {
    // Atributos del objetos
    private String name;
    private String type;
    private int image;
    private boolean showImage;

    // constructor
    public Pokemon(String name, String type, int image) {
        this.name = name;
        this.type = type;
        this.image = image;
    }

    protected Pokemon(Parcel in) {
        name = in.readString();
        type = in.readString();
        image = in.readInt();
        showImage = in.readByte() != 0;
    }

    public static final Creator<Pokemon> CREATOR = new Creator<Pokemon>() {
        @Override
        public Pokemon createFromParcel(Parcel in) {
            return new Pokemon(in);
        }

        @Override
        public Pokemon[] newArray(int size) {
            return new Pokemon[size];
        }
    };

    // getters/setters y toString
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public boolean isShowImage() {
        return showImage;
    }

    public void setShowImage(boolean showImage) {
        this.showImage = showImage;
    }

    @Override
    public String toString() {
        return "Pokemon{" +
                "name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", image=" + image +
                '}';
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel parcel, int i) {
        parcel.writeString(name);
        parcel.writeString(type);
        parcel.writeInt(image);
        parcel.writeByte((byte) (showImage ? 1 : 0));
    }
}