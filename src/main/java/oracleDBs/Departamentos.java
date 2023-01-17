package oracleDBs;

import jakarta.persistence.*;

import java.math.BigInteger;

@Entity
public class Departamentos {
 //   private BigInteger dep;
   // private String nombreDpt;

    @Id
    @Column(name = "DEPARTAMENTO")
    private BigInteger departamento;
   
    @Basic
    @Column(name = "LOCALIDAD")
    private String localidad;
    @Basic
    @Column(name = "NOMBRE_DPT")
    private String nombreDpt;

    public Departamentos(BigInteger departamento, String nombreDpt, String localidad) {
        this.departamento = departamento;
        this.nombreDpt = nombreDpt;
        this.localidad = localidad;
    }

    public Departamentos() {

    }

    public BigInteger getDepartamento() {
        return departamento;
    }

    public void setDepartamento(BigInteger departamento) {
        this.departamento = departamento;
    }

    public String getNombre() {
        return nombreDpt;
    }

    public void setNombre(String nombreDpt) {
        this.nombreDpt = nombreDpt;
    }

    public String getLocalidad() {
        return localidad;
    }

    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Departamentos that = (Departamentos) o;

        if (departamento != null ? !departamento.equals(that.departamento) : that.departamento != null) return false;
        if (nombreDpt != null ? !nombreDpt.equals(that.nombreDpt) : that.nombreDpt != null) return false;
        if (localidad != null ? !localidad.equals(that.localidad) : that.localidad != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = departamento != null ? departamento.hashCode() : 0;
        result = 31 * result + (nombreDpt != null ? nombreDpt.hashCode() : 0);
        result = 31 * result + (localidad != null ? localidad.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Departamento{" +
                "Codigo Departamento=" + departamento +
                ", Localidad='" + localidad + '\'' +
                ", Nombre Departamento='" + nombreDpt + '\'' +
                '}';
    }

    public String getNombreDpt() {
        return nombreDpt;
    }

    public void setNombreDpt(String nombreDpt) {
        this.nombreDpt = nombreDpt;
    }
}
