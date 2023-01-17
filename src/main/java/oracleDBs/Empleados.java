package oracleDBs;

import jakarta.persistence.*;

import java.math.BigInteger;

@Entity
public class Empleados {

    @Id
    @Column(name = "NIF")
    private String nif;
    @Basic
    @Column(name = "NOMBRE")
    private String nombre;
    @Basic
    @Column(name = "DIRECCION")
    private String direccion;
    @Basic
    @Column(name = "CARGO")
    private String cargo;
    @Basic
    @Column(name = "COD_OFI")
    private BigInteger codOfi;
    @Basic
    @Column(name = "SUELDO")
    private BigInteger sueldo;

    @ManyToOne
    @JoinColumn(name = "COD_OFI", referencedColumnName = "DEPARTAMENTO", nullable = false,insertable=false, updatable=false)
    private Departamentos departamentosByIdDptEmp;

    public Empleados() {

    }



    public Empleados(String nif, String nombre, String cargo, BigInteger codOfi, BigInteger sueldo) {
        this.nif = nif;
        this.nombre = nombre;
        this.cargo = cargo;
        this.codOfi = codOfi;
        this.sueldo = sueldo;

    }

    public String getNif() {
        return nif;
    }

    public void setNif(String nif) {
        this.nif = nif;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public BigInteger getCodOfi() {
        return codOfi;
    }

    public void setCodOfi(BigInteger codOfi) {
        this.codOfi = codOfi;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Empleados empleados = (Empleados) o;

        if (nif != null ? !nif.equals(empleados.nif) : empleados.nif != null) return false;
        if (nombre != null ? !nombre.equals(empleados.nombre) : empleados.nombre != null) return false;
        if (direccion != null ? !direccion.equals(empleados.direccion) : empleados.direccion != null) return false;
        if (cargo != null ? !cargo.equals(empleados.cargo) : empleados.cargo != null) return false;
        if (codOfi != null ? !codOfi.equals(empleados.codOfi) : empleados.codOfi != null) return false;

        return true;
    }

    @Override
    public String toString() {
        return "Empleado {" +
                "Codigo='" + nif + '\'' +
                ", Nombre='" + nombre + '\'' +
                ", Direccion='" + direccion + '\'' +
                ", Cargo='" + cargo + '\'' +
                ", Codigo Oficina=" + codOfi +
                ", Sueldo=" + sueldo +

                '}';
    }

    public String toStringFull(){
        return "Empleado {" +
                "Codigo='" + nif + '\'' +
                ", Nombre='" + nombre + '\'' +
                ", Direccion='" + direccion + '\'' +
                ", Cargo='" + cargo + '\'' +
                ", Codigo Oficina=" + codOfi +
                ", Sueldo=" + sueldo +
                ", Departamento=" + departamentosByIdDptEmp +
                '}';
    }

    @Override
    public int hashCode() {
        int result = nif != null ? nif.hashCode() : 0;
        result = 31 * result + (nombre != null ? nombre.hashCode() : 0);
        result = 31 * result + (direccion != null ? direccion.hashCode() : 0);
        result = 31 * result + (cargo != null ? cargo.hashCode() : 0);
        result = 31 * result + (codOfi != null ? codOfi.hashCode() : 0);
        return result;
    }

    public BigInteger getSueldo() {
        return sueldo;
    }

    public void setSueldo(BigInteger sueldo) {
        this.sueldo = sueldo;
    }
}
