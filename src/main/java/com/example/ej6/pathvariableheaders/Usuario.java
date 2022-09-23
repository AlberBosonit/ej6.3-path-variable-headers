package com.example.ej6.pathvariableheaders;

import lombok.Getter;
import lombok.Setter;
import java.io.Serializable;

@Getter
@Setter
public class Usuario implements Serializable {

    private static final long serialVersionUID = -8808067950889802323L;
    private long id;
    private String nombre;
    private int numArticulos;

    public Usuario(long id, String nombre, int numArticulos) {
        this.id = id;
        this.nombre = nombre;
        this.numArticulos = numArticulos;
    }
}
