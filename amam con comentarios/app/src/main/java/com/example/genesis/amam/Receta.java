package com.example.genesis.amam;

//Clase Receta
public class Receta {

    //Atributos de la clase
    int numReceta;
    String titulo, tiempo, ingredientes, procedimiento;

    //Constructores
    public Receta(){ }

    public Receta(int numReceta,String titulo, String tiempo, String ingredientes, String procedimiento) {
        this.numReceta = numReceta;
        this.titulo = titulo;
        this.tiempo = tiempo;
        this.ingredientes = ingredientes;
        this.procedimiento = procedimiento;
    }

    //Getters y setters de los atributos
    public int getNumReceta() {
        return numReceta;
    }

    public void setNumReceta(int numReceta) {
        this.numReceta = numReceta;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getTiempo() {
        return tiempo;
    }

    public void setTiempo(String tiempo) {
        this.tiempo = tiempo;
    }

    public String getIngredientes() {
        return ingredientes;
    }

    public void setIngredientes(String ingredientes) {
        this.ingredientes = ingredientes;
    }

    public String getProcedimiento() {
        return procedimiento;
    }

    public void setProcedimiento(String procedimiento) {
        this.procedimiento = procedimiento;
    }

    //Método toString() de la receta
    @Override
    public String toString() {
        return
                ""                              + titulo        + "\n" + "\n" +
                        "Tiempo estimado: "     + tiempo        + "\n" + "\n" +
                        "Ingredientes:"  + "\n" + ingredientes  + "\n" + "\n" +
                        "Procedimiento:" + "\n" + procedimiento + "\n" + "\n" + "\n" ;
    }

}
