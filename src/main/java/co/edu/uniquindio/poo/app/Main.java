package co.edu.uniquindio.poo.app;

import co.edu.uniquindio.poo.model.Estudiante;
import co.edu.uniquindio.poo.model.Universidad;
import java.util.ArrayList;
import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        Universidad universidad = new Universidad("Uniquindio","Armenia");
        while (true){
            JOptionPane.showMessageDialog(null, "Bienvenido, puedo ayudarte en varias funciones");
            int desicion = JOptionPane.showOptionDialog(
                    null,
                    "Selecciona una opcion que desee",
                    "Menu Principal",
                    JOptionPane.DEFAULT_OPTION,
                    JOptionPane.QUESTION_MESSAGE,
                    null,
                    new Object[]{"Registrar Estudiante","Mostrar todos los estudiantes","Mostrar estudiante\n",
                    "Mostrar Estudiante de mayor promedio","Gestionar notas de Estudiante","Salir"},
                    "Agregar Estudiante"
            );
            switch (desicion){
                case 0:
                    universidad.registrarEstudiante();
                    break;
                case 1:
                    universidad.mostrarEstudiantes();
                    break;
                case 2:
                    universidad.mostrarEstudiante();
                    break;
                case 3:
                    universidad.EstudianteMayorPromedio();
                    break;
                case 4:
                    int op = JOptionPane.showOptionDialog(
                            null,
                            "Que quiere hacer con las notas?",
                            "Gestor de notas",
                            JOptionPane.DEFAULT_OPTION,
                            JOptionPane.QUESTION_MESSAGE,
                            null,
                            new Object[]{"Agregar Nota","Actualizar Nota","Calcular Promedio","Salir al menu principal"},
                            "Agregar Nota"
                            );

                    switch (op){
                        case 0:
                            universidad.agregarNota();
                            break;
                        case 1:
                            universidad.actualizarNota();
                            break;
                        case 2:
                            universidad.calcularPromedio();
                            break;
                        case 3:
                            JOptionPane.showMessageDialog(null,"Saliendo al menu principal");
                            break;

                    }
                break;
                case 5:
                    JOptionPane.showMessageDialog(null,"Programa finalizado");
                    System.exit(0);
                    break;
                default:
                    JOptionPane.showMessageDialog(null,"Selecciona una opcion correcta");
                    break;

            }
        }
    }
}