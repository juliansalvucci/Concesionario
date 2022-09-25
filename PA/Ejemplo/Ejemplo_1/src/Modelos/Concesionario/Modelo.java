/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelos.Concesionario;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author julia
 */


@Entity
@Table (name="modelo") 

public class Modelo implements Comparable
{
    @Id @GeneratedValue(strategy=javax.persistence.GenerationType.AUTO)
    private long id;
        
    private String nombreModelo;
    
    private int estado;
    
    //@OneToOne (targetEntity = Pais.class, cascade= CascadeType.ALL,fetch=FetchType.LAZY)
    //private Pais pais;
    
    public String getNombreModelo()
    {
        return nombreModelo;
    }

    public void setNombreModelo(String nombreModelo) 
    {
        this.nombreModelo = nombreModelo;
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
    
    /*
    public Pais getPais() {
        return pais;
    }

    public void setPais(Pais pais) {
        this.pais = pais;
    }
    */

    ///////////////////////////////////////////
    public Modelo(){}

    public Modelo(String nombreModelo) 
    {
        this.setNombreModelo(nombreModelo);
    }
    
    public void eliminar()
    {
        this.setEstado(1);
    }
    
    @Override
    public String toString () 
    {
        return  this.getNombreModelo();
    }  
    
    @Override
    public int compareTo(Object o) 
    {
        var m = (Modelo) o;
        return this.getNombreModelo().compareTo(m.getNombreModelo());
    }    
}