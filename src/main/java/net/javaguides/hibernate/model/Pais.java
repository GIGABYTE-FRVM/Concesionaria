
package net.javaguides.hibernate.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="pais")
public class Pais {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    
    @Column(name = "nombre")
    private String nombre;

    public Pais(String nombre) {
        this.nombre = nombre;
    }

    @ManyToOne
    @JoinColumn(name="id_region",referencedColumnName="id")
    private Region region;
    
    public Pais() {
    }

    public Pais(String nombre, Region region) {
        this.nombre = nombre;
        this.region = region;
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
    
    public Region getRegion() {
        return region;
    }

    public void setRegion(Region region) {
        this.region = region;
    }

    public Pais(int id,  String nombre, Region region) {
        this.id = id;
        this.nombre = nombre;
        this.region = region; 
    }
    
    @Override
    public String toString() {
        return nombre;
    }
}
