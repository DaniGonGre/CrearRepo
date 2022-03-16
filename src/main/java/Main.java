import javax.swing.*;
import java.io.*;

public class Main {


    public static void main(String[] args) {
        File file = new File("token.properties");
        String pathFile = "token.properties";
        Escribir escribir = new Escribir();
        if (file.exists()) {
            escribir.crear(pathFile);
        } else {
            escribir.escribir(pathFile);
            escribir.crear(pathFile);
        }
    }

}

