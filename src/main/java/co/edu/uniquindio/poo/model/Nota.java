package co.edu.uniquindio.poo.model;

public class Nota {
    private String nombre;
    private float valor;

    public Nota(String nombre, float valor){
        this.nombre = nombre;
        this.valor = valor;
    }
    public String getNombre(){
        return nombre;
    }
    public float getValor(){
        return valor;
    }
    public void setNombre(String nombre){
        this.nombre = nombre;
    }
    public void setValor(float valor){
        this.valor = valor;
    }
    @Override
    public String toString(){
        return "La nota de nombre: " + nombre + "\nTiene como valor: " + valor;
    }
}
