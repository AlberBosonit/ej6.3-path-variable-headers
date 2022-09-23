package com.example.ej6.pathvariableheaders;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class UsuarioController {

    private static final String template = "%s";
    private final AtomicLong incrementigCounter = new AtomicLong();
    @Autowired
    ArrayList<Usuario> listaDeUsuarios;

    @PostMapping("/generateUser")
    public Usuario generateUser(@RequestParam(value = "nombre", defaultValue = "sin nombre") String nombre,
                                @RequestParam(value = "numArticulos", defaultValue = "4") int numArticulos) {
        Usuario usuario = new Usuario(incrementigCounter.incrementAndGet(), String.format(template, nombre),numArticulos);
        listaDeUsuarios.add(usuario);
        return usuario;
    }

    @GetMapping("/user/{id}")
    public Usuario getUser(@PathVariable long id){
        try{
            return listaDeUsuarios.get((int)id-1);
        }catch (IndexOutOfBoundsException e){
            System.out.println("En /user/{id} ha saltado IndexOutOfBoundsException porque el índice no se correspondía con ninguno de la lista.");
            return null;
        }
    }

    @PutMapping("/post")
    public void modifyUser(@RequestParam long id,
                           @RequestParam String nombre,
                           @RequestParam int numArticulos){
        try{
            listaDeUsuarios.get((int)id-1).setNombre(nombre);
            listaDeUsuarios.get((int)id-1).setNumArticulos(numArticulos);
        }catch (IndexOutOfBoundsException e){
            System.out.println("En /post ha saltado IndexOutOfBoundsException porque el índice no se correspondía con ninguno de la lista.");
        }

    }
}
