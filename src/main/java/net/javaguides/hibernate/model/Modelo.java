
package net.javaguides.hibernate.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="modelo")
public class Modelo {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    
    @Column(name = "nombre")
    private String nombre;
    
    @Column(name = "version")
    private String version;
    
    @Column(name = "añoLanzamiento")
    private String añoLanzamiento;

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getAñoLanzamiento() {
        return añoLanzamiento;
    }

    public void setAñoLanzamiento(String añoLanzamiento) {
        this.añoLanzamiento = añoLanzamiento;
    }

    public Modelo(String nombre, String version, String añoLanzamiento) {
        this.nombre = nombre;
        this.version = version;
        this.añoLanzamiento = añoLanzamiento;
    }


    public Modelo() {
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


    
    @Override
    public String toString() {
        return "Pais [id=" + id + ", nombre=" + nombre + ", version="+ version + ",añoLanzamiento="+ añoLanzamiento + "]";
    }
}
