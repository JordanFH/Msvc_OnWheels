package org.onwheels.springcloud.msvc.empleados.models.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

import java.util.Date;

@Entity
@Table(name = "empleados")
public class Empleado {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @NotBlank(message = "El campo Nombre no puede estar vacio")
    @Size(max = 50)
    private String nombre;
    @NotBlank(message = "El campo Apellido Paterno no puede estar vacio")
    @Size(max = 30)
    private String apePaterno;
    @NotBlank(message = "El campo Apellido Materno no puede estar vacio")
    @Size(max = 30)
    private String apeMaterno;
    @Past
    @Null
    private Date fechaNacimiento;
    @PastOrPresent
    @NotNull(message = "El campo Fecha de Inicio de Contrato no puede ser nulo")
    private Date fechaInicioContrato;
    @FutureOrPresent
    @Null
    private Date fechaVenceContrato;
    @Pattern(regexp = "(^$|[0-9]{8})", message = "El campo DNI debe tener 8 dígitos")
    @Column(unique = true)
    @NotBlank(message = "El campo DNI no puede estar vacio")
    private String dni;
    @Pattern(regexp = "(^$|[0-9]{9})", message = "El campo teléfono debe tener 9 dígitos")
    @Column(unique = true)
    @NotBlank(message = "El campo teléfono no puede estar vacio")
    private String telefono;
    @Null
    @Size(max = 50)
    private String direccion;
    @Column(unique = true)
    @Email
    private String email;
    @Column(unique = true)
    @Size(min = 8)
    private String password;
    @Size(max = 30)
    private String cargo;
    @Size(max = 30)
    private String ciudad;
    @Size(max = 30)
    private String region;
    @Size(max = 30)
    private String pais;
    private boolean activo = true;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApePaterno() {
        return apePaterno;
    }

    public void setApePaterno(String apePaterno) {
        this.apePaterno = apePaterno;
    }

    public String getApeMaterno() {
        return apeMaterno;
    }

    public void setApeMaterno(String apeMaterno) {
        this.apeMaterno = apeMaterno;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public Date getFechaInicioContrato() {
        return fechaInicioContrato;
    }

    public void setFechaInicioContrato(Date fechaInicioContrato) {
        this.fechaInicioContrato = fechaInicioContrato;
    }

    public Date getFechaVenceContrato() {
        return fechaVenceContrato;
    }

    public void setFechaVenceContrato(Date fechaVenceContrato) {
        this.fechaVenceContrato = fechaVenceContrato;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }
}
