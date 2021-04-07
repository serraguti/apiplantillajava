package models;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Plantilla {

    private int idPlantilla;
    private String apellido;
    private String funcion;
    private String turno;
    private int salario;

    public Plantilla() {
    }

    public Plantilla(int idPlantilla, String apellido, String funcion, String turno, int salario) {
        this.idPlantilla = idPlantilla;
        this.apellido = apellido;
        this.funcion = funcion;
        this.turno = turno;
        this.salario = salario;
    }

    public int getIdPlantilla() {
        return idPlantilla;
    }

    public void setIdPlantilla(int idPlantilla) {
        this.idPlantilla = idPlantilla;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getFuncion() {
        return funcion;
    }

    public void setFuncion(String funcion) {
        this.funcion = funcion;
    }

    public String getTurno() {
        return turno;
    }

    public void setTurno(String turno) {
        this.turno = turno;
    }

    public int getSalario() {
        return salario;
    }

    public void setSalario(int salario) {
        this.salario = salario;
    }

}
