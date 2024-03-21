package com.neogiciel.springinjection.normal;
import org.springframework.stereotype.Component;
import com.neogiciel.springinjection.util.Trace;

/*
 * @Component permet de declare un Bean 
 * Le fait de déclarer cette classe comme Bean a pour role de la charger au boot
 * Le constructeur de la classe est automatiquement appellé au boot
 */
@Component("B")
public class B {
    
    String display;
    
    public B(){
        Trace.info("[B] constructeur");
        display = "classe B";
    }

    public void init(){
        Trace.info("[B] init");
        display = "classe Init";
    }
    public void set(String display){
        this.display = display;
    }

    public String get() {
        Trace.info("[B] get: "+ display);
        return display;
    }
}
