package org.damx.demojpa.models;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "personas", schema = "public")
public class Persona {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "nombre", nullable = false, length = 50, unique = false)
    private String nombre;
    @Column(name = "fecha_nacimiento", nullable = true, unique = false)
    private LocalDate fechaNacimiento;
    @Column(name = "email", length = 100, unique = true)
    private String correo;

    @OneToOne(mappedBy = "persona", cascade = CascadeType.ALL)
    private Pasaporte pasaporte;

    @OneToOne(mappedBy = "persona", cascade = CascadeType.ALL)
    private Telefono telefono;

    @OneToMany(mappedBy = "persona", cascade = CascadeType.ALL)
    private List<Actividad> actividades = new ArrayList<>();




    @OneToMany(mappedBy = "persona", cascade = CascadeType.ALL)
    private List<Gasto> gastos = new ArrayList<>();

    public List<Gasto> getGastos() {
        return gastos;
    }

    public void setGastos(List<Gasto> gastos) {
        this.gastos = gastos;
    }




    public List<Actividad> getActividades() {
        return actividades;
    }

    public void setActividades(List<Actividad> actividades) {
        this.actividades = actividades;
    }

    public Telefono getTelefono() {
        return telefono;
    }

    public void setTelefono(Telefono telefono) {
        this.telefono = telefono;
    }

    public Pasaporte getPasaporte() {
        return pasaporte;
    }

    public void setPasaporte(Pasaporte pasaporte) {
        this.pasaporte = pasaporte;
    }

    public Persona() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }
}
