package models;

import java.util.List;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Funciones {

    private List<String> funcion;

    public List<String> getFuncion() {
        return funcion;
    }

    public void setFuncion(List<String> funcion) {
        this.funcion = funcion;
    }

}
