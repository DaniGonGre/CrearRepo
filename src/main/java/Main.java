import org.kohsuke.github.GHRepository;
import org.kohsuke.github.GitHub;
import org.kohsuke.github.GitHubBuilder;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        GitHub github = null;
        try {
            String pathAlFich = "/home/dam1/IdeaProjects/CrearProyecto/ficheroToken.propierties";
            github = new GitHubBuilder()
                    //.withOAuthToken("AÑADE TU TOKEN AQUI")
                    .fromPropertyFile(pathAlFich)
                    .build();
        } catch (IOException e) {
            e.printStackTrace();
        }

        GHRepository repo = null;
        try {
            //GHRepository repo2 = github.createRepository("miRepo").create();
            repo = github.createRepository(
                    "Nuevo_Repositorio", "this is my new repository",
                    "https://www.kohsuke.org/", true/*public*/);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
