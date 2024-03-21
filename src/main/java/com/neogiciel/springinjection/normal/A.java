package com.neogiciel.springinjection.normal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import com.neogiciel.springinjection.util.Trace;

/*
 * @Component permet de declare un Bean 
 * Le fait de déclarer cette classe comme Bean a pour role de la charger au boot
 * Le constructeur de la classe est automatiquement appellé au boot
 */
@Component("A")
public class A {

    /*Variables*/
    String display;

    /*
     * Il existent deux modes d'injection de dépendence :
     * Choix 1: Commenter le constructeur public A(B b), laissé autowired sur la variable 
     * Choix 2: Commenter @Autowiredle, Commenter le constructeur public A()
     */
    @Autowired
    private B b;
    

    /*
     *Constructeur 
     */
    public A(){
        Trace.info("[A] constructeur");
        this.display = "Classe A";
    }

    /*
     *Constructeur 
     */
    public A(B b){
        Trace.info("[A] constructeur");
        Trace.info("[A] b.get()"+b.get());
        this.b = b;
    }

    /*
     * Si la méthode est annoté avec un Bean 
     * Elle seras initilisé au boot
     */
    @Bean
    public void init(){
        Trace.info("[A] init");
        display = "classe Init";
    }


    /*
     *set(String display)
     */
    public void set(String display){
        b.set(display);
    }

    /*
     *get() 
     */
    public String get() {
        Trace.info("[A] get");
        return b.get();
    }
}
