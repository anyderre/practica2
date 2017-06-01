import java.util.ArrayList;
import java.util.List;

/**
 * Created by Dany on 31/05/2017.
 */
public class Estudiante extends ArrayList {
    private int matricula;
    private String apellido;
    private String nombre;
    private String telefono;
    private static List<Estudiante> estudiantes= new ArrayList<Estudiante>();

    public Estudiante(int matricula, String apellido, String nombre, String telefono) {
        this.matricula = matricula;
        this.apellido = apellido;
        this.nombre = nombre;
        this.telefono = telefono;
    }

    public int getMatricula() {
        return matricula;
    }

    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public static List<Estudiante> getEstudiantes() {
        return estudiantes;
    }

    public static void setEstudiantes(Estudiante estudiante) {
        Estudiante.estudiantes.add(estudiante);
    }
}
