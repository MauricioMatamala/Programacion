package com.politecnico;

import com.politecnico.composicion.AnimalC;
import com.politecnico.composicion.KoalaC;
import com.politecnico.composicion.PerroC;
import com.politecnico.composicion.ReproductorSonido;
import com.politecnico.herencia.AnimalH;
import com.politecnico.herencia.Koala;
import com.politecnico.herencia.Perro;
import java.util.Random;

public class AnimalesApp {
    public static void main(String[] args) {
        AnimalH a = new Perro();
        System.out.println(a.hablar());
        AnimalH b = new Koala();
        System.out.println(b.hablar());

        //----------------------------

        ReproductorSonido reproductor = new ReproductorSonido();
        AnimalC animal = dameUnAnimal();
        System.out.println(reproductor.hablar(animal));
        animal = dameUnAnimal();
        System.out.println(reproductor.hablar(animal));
    }

    public static AnimalC dameUnAnimal(){
        Random random = new Random();
        int aleatorio = random.nextInt(100);
        if (aleatorio % 2 == 0)
            return new PerroC();
        else
            return new KoalaC();
    }
}
