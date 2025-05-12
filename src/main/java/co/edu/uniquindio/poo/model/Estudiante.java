package co.edu.uniquindio.poo.model;
import javax.swing.JOptionPane;
public class Estudiante {
    private String nombre;
    private String identificacion;
    private Nota[] listaNotas;

    public Estudiante(String nombre, String identificacion){
        this.nombre = nombre;
        this.identificacion = identificacion;
        this.listaNotas = new Nota[5];
    }
    /*
    Este metodo es usado por la clase estudiante para agregar una nota, itera sobre el tamaño de ListaNotas,
    se asegura que el espacio este vacion y agrega la ijnstancia en el indice designado
    */
    public void agregarNota(float valorNota,String nombreNota){
        for(int i = 0; i < listaNotas.length; i++){
            if(listaNotas[i] == null){
                Nota nota = new Nota(nombreNota, valorNota);
                listaNotas[i] = nota;
                JOptionPane.showMessageDialog(null,"Nota Agregada Exitosamente" );
                return;
            }
        }
        JOptionPane.showMessageDialog(null,"No se puede agregar mas notas, Ya tiene 5");

    }
    public void actualizarNota(String nombre, float nuevoValor) {
        for (int i = 0; i < listaNotas.length; i++) {
            if (listaNotas[i] != null && listaNotas[i].getNombre().equals(nombre)) {
                listaNotas[i].setValor(nuevoValor);
                JOptionPane.showMessageDialog(null, "Nota actualizada exitosamente.");
                return;
            }
        }
        JOptionPane.showMessageDialog(null, "No se encontró ninguna nota con ese nombre.");
    }

    /*
    Este metodo simplemente itera sobre la lista de notas y muestra el valor de la clase con todos sus
    atributos "toString"
     */
    public void mostrarNotas() {
        try {
            for (int i = 0; i < listaNotas.length; i++) {
                JOptionPane.showMessageDialog(null, listaNotas[i].toString() + "\ntiene como promedio: " + calcularPromedio());
            }
        }catch (Exception NullPointerException){
            JOptionPane.showMessageDialog(null, "No hay notas registradas");
        }
    }
    /*
    Este metodo retorna el promedio del estudiante, itera sobre el tamaño de la lista, se asegura de que no
    haya un espacio null, caso en que si sea null,lo salta.
    suma el valor de la nota al promedio y luego retorna el valor del promedio dividido por la cantidad de
    notas
    */
    public float calcularPromedio(){
        float promedio = 0;
        int cantNotas = 0;
        for(int i = 0; i < listaNotas.length; i++){
            if(listaNotas[i] != null){
                promedio += listaNotas[i].getValor();
                cantNotas++;
            }
        }
        return promedio / cantNotas;
    }
    //Getters y Setters
    public String getNombre() {

        return nombre;
    }

    public String getIdentificacion() {
        return identificacion;
    }
    public Nota[] getListaNotas(){
        return listaNotas;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }

    @Override
    public String toString() {
        return "Nombre del estudiante: " + nombre + "\nnumero de identificacion: " + identificacion +
                "\nPromedio :" + calcularPromedio();
    }





}
