package com.example.trabajo_final_unidad_3;

public class Pokemon {
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
}