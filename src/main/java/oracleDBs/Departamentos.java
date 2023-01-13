package oracleDBs;

import jakarta.persistence.*;

import java.math.BigInteger;

@Entity
public class Departamentos {
 //   private BigInteger dep;
   // private String nombre;

    @Id
    @Column(name = "DEPARTAMENTO")
    private BigInteger departamento;
    @Basic
    @Column(name = "NOMBRE")
    private String nombre;
    @Basic
    @Column(name = "LOCALIDAD")
    private String localidad;

    public BigInteger getDepartamento() {
        return departamento;
    }

    public void setDepartamento(BigInteger departamento) {
        this.departamento = departamento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getLocalidad() {
        return localidad;
    }

    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }

    public Departamentos(BigInteger departamento, String nombre, String localidad) {
        this.departamento = departamento;
        this.nombre = nombre;
        this.localidad = localidad;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Departamentos that = (Departamentos) o;

        if (departamento != null ? !departamento.equals(that.departamento) : that.departamento != null) return false;
        if (nombre != null ? !nombre.equals(that.nombre) : that.nombre != null) return false;
        if (localidad != null ? !localidad.equals(that.localidad) : that.localidad != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = departamento != null ? departamento.hashCode() : 0;
        result = 31 * result + (nombre != null ? nombre.hashCode() : 0);
        result = 31 * result + (localidad != null ? localidad.hashCode() : 0);
        return result;
    }
}
