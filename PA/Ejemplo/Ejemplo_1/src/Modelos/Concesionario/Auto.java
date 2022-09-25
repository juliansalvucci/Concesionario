/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelos.Concesionario;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author julia
 */


@Entity
@Table (name="auto") 
public class Auto implements Comparable
{
    @Id @GeneratedValue(strategy=javax.persistence.GenerationType.AUTO)
    private long id; 
    private Double precio;
    private int estado;
    //@OneToOne (targetEntity = Marca.class)
    @OneToOne (targetEntity = Marca.class, cascade= CascadeType.ALL,fetch=FetchType.LAZY)
    private Marca marca;
    
    public Double getPrecio()
    {
        return precio;
    }

    public void setPrecio(Double precio) 
    {
        this.precio = precio;
    }

    public int getEstado()
    {
        return estado;
    }

    public void setEstado(int estado) 
    {
        this.estado = estado;
    }

    public long getId() 
    {
        return id;
    }

    public void setId(long id) 
    {
        this.id = id;
    }

    public Marca getMarca() {
        return marca;
    }

    public void setMarca(Marca marca) {
        this.marca = marca;
    }
    
    ///////////////////////////////////////////
    public Auto(){}

    public Auto(Double precio) 
    {
        this.setPrecio(precio);
    }
    
    public void eliminar()
    {
        this.setEstado(1);
    }
    
    @Override
    public String toString () 
    {
        return this.getPrecio().toString();
    }  
    
    @Override
    public int compareTo(Object o) 
    {
        var m = (Auto) o;
        return this.getPrecio().compareTo(m.getPrecio());
    }    
}
