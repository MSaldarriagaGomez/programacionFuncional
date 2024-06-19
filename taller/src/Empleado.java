import java.util.Objects;

public class Empleado {
    private String nombre;
    private String departamento;

    public Empleado(String nombre, String departamento) {
        this.nombre = nombre;
        this.departamento = departamento;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDepartamento() {
        return departamento;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Empleado)) return false;
        Empleado empleado = (Empleado) o;
        return Objects.equals(getNombre(), empleado.getNombre()) && Objects.equals(getDepartamento(), empleado.getDepartamento());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getNombre(), getDepartamento());
    }
}
