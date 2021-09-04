/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelob;

/**
 *
 * @author Maicol
 */
public class baile {
    int id;
    String nombre;
    int antiguedad;
    int duracion;

    public baile() {
    }

    public baile(int id, String nombre, int antiguedad, int duracion) {
        this.id = id;
        this.nombre = nombre;
        this.antiguedad = antiguedad;
        this.duracion = duracion;
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

    public int getAntiguedad() {
        return antiguedad;
    }

    public void setAntiguedad(int antiguedad) {
        this.antiguedad = antiguedad;
    }

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }
    
    
}
