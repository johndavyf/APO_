import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Questionnaire {
    ArrayList<Item> items ;

    public Questionnaire(File fichier) {
        ArrayList<Item> items = new ArrayList<>();
        try
        {
            Scanner flux = new Scanner(fichier);
            while ( flux.hasNext() )
            {
                String ligne = flux.nextLine();
                Item q = new Item() ;
                q.setQuestion(ligne);
                ligne = flux.nextLine();
                q.setReponse(ligne);
                items.add(q);
            }
        }
        catch (FileNotFoundException fnfe)
        {
            System.out.println("Erreur fichier " + fnfe);
            fnfe.printStackTrace();
        }
        this.items = items;
    }
}
