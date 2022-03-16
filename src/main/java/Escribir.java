import org.kohsuke.github.GHRepository;
import org.kohsuke.github.GitHub;
import org.kohsuke.github.GitHubBuilder;
import javax.swing.*;
import java.io.*;

public class Escribir {
    PrintWriter esc;
    FileWriter fich;

    public void escribir(String fichero) {
        try {
            fich = new FileWriter(fichero, false);
            esc = new PrintWriter(fich);
            esc.println("oauth=" + JOptionPane.showInputDialog("Introduce el token:"));
            System.out.println("Fichero creado.");

        } catch (IOException e) {
            System.out.println("Error" + e.getMessage());
        } finally {
            esc.close();
        }
    }


    public void crear(String file) {
        GitHub github = null;
        try {
            new GitHubBuilder();
            github = GitHubBuilder
                    .fromPropertyFile(file)
                    .build();

        } catch (IOException e) {
            System.out.println("Error de token");
            e.printStackTrace();
        }

        try {
            if (github != null) {
                String nomRepo = JOptionPane.showInputDialog("Introduce el nombre del proyecto: ");
                GHRepository repo1 = github.createRepository(
                                nomRepo)
                        .create();
            }
        } catch (IOException e) {
            System.out.println("Repositorio existente");
            e.printStackTrace();
        }
    }
}

