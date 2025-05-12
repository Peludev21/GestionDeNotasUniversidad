package co.edu.uniquindio.poo.model;
import javax.swing.*;
import java.util.ArrayList;
public class Universidad {
    private String nombre;
    private String ubicacion;
    private ArrayList<Estudiante> listaEstudiantes;

    public Universidad(String nombre, String ubicacion) {
        this.nombre = nombre;
        this.ubicacion = ubicacion;
        this.listaEstudiantes = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public ArrayList<Estudiante> getListaEstudiantes() {
        return listaEstudiantes;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public void registrarEstudiante() {
        String nombre = JOptionPane.showInputDialog("Ingrese el nombre del estudiante");
        String id = JOptionPane.showInputDialog("Ingrese la identificacion del estudiante");

        Estudiante estudiante = new Estudiante(nombre, id);
        listaEstudiantes.add(estudiante);
        JOptionPane.showMessageDialog(null, "Estudiante registrado exitosamente");
    }


    public void mostrarEstudiantes() {
        for (Estudiante estudiante : listaEstudiantes) {
            JOptionPane.showMessageDialog(null, estudiante.toString());
        }
    }
    public Estudiante buscarEstudiante(String id){
        for(int i = 0; i < listaEstudiantes.size(); i++){
            if(listaEstudiantes.get(i).getIdentificacion().equals(id)){
                return listaEstudiantes.get(i);
            }
        }
        return null;
    }
    public void mostrarEstudiante(){
        String id = JOptionPane.showInputDialog(null,"Ingrese el id del estudiante");
        Estudiante estudianteBuscado = buscarEstudiante(id);
        estudianteBuscado.mostrarNotas();
    }
    public void EstudianteMayorPromedio(){
        Estudiante EstudianteMayorPromedio = null;
        float mayorPromedio = 0;
        for(int i = 0; i < listaEstudiantes.size(); i++) {
            if (listaEstudiantes.get(i).calcularPromedio() > mayorPromedio) {
                mayorPromedio = listaEstudiantes.get(i).calcularPromedio();
                EstudianteMayorPromedio = listaEstudiantes.get(i);
            }
        }
        JOptionPane.showMessageDialog(null, "El estudiante con mayor promedio es: " + EstudianteMayorPromedio.toString());
    }
    public void actualizarNota(){
        String nombreNota = JOptionPane.showInputDialog(null,"Ingrese el nombre de la nota que desea registrar");
        String valorIngresado = JOptionPane.showInputDialog(null,"Ingrese el valor nuevo de la nota");
        String id = JOptionPane.showInputDialog(null,"Ingrese el id del estudiante");
        float valorNuevo = Float.parseFloat(valorIngresado);
        Estudiante estudianteBuscado = buscarEstudiante(id);
        estudianteBuscado.actualizarNota(nombreNota,valorNuevo);
    }
    public void calcularPromedio(){
        String id = JOptionPane.showInputDialog(null, "Ingrese el id del estudiantes");
        Estudiante estudiante = buscarEstudiante(id);
        JOptionPane.showMessageDialog(null, "El estudiante tiene el sigueinte promedio" + estudiante.calcularPromedio());
    }
    public void agregarNota(){
        String nombreNota = JOptionPane.showInputDialog(null,"Ingrese el nombre de la nota");
        String valorIngresado = JOptionPane.showInputDialog(null,"Ingrese el valor de la nota");
        String id = JOptionPane.showInputDialog(null,"Ingrese el id del estudiante");

        float valorNota = Float.parseFloat(valorIngresado);
        for(int i = 0; i < listaEstudiantes.size(); i++){
            if(listaEstudiantes.get(i).getIdentificacion().equals(id)){
                listaEstudiantes.get(i).agregarNota(valorNota,nombreNota);
            }
        }
    }
}