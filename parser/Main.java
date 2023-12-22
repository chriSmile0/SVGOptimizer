import java.io.File;
import java.io.FileWriter;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Collection;


public class Main {
    public static char[] tableau_commandes  = {'A','a','C','c','H','h','L','l','M','m','O','o','S','s','T','t','V','v','Z','z'};

    public static double[] coordonnees(String line)//Quand on croise un M
    {
        int i = 0;
        int cpt_x = 0;
        double[] tab = {0.0,0.0,0.0};
        while(line.charAt(i) != ',') {
            cpt_x++;
            i++;
        }

        tab[0]  = ((double) Double.valueOf(line.substring(0,i))) +100.;//Bouge bien la forme en x, mais là cela bouge toutes les formes avec M car j'utilise coordonnes dans les 'path'
                                                                       //Sois on peut creer une méthode pour chaque objet mais ça peut prendre beaucoup de temps mais c'est possible
        while((line.charAt(i) != ' ') && (line.charAt(i) != '"')) 
            i++;
        
        tab[1] = (double) Double.valueOf(line.substring(cpt_x+1,i)) +100. ;//Bougera aussi la forme en y si on met une donnée de mouvement
        tab[2] =  (double) i;
        return tab;
        //On arrive donc a bouger les coordonnes de en principe toutes les formes
    }

    public static double[] x_rect(String line)//Ici on fera la modification de x du rectangle
    {
        int i = 0;
        double[] c_tab = {0.0,0.0};
        while(line.charAt(i) != '"') 
            i++;
        
        c_tab[0] = 50.0; //(double) Double.valueOf(line.substring(0,i));//
        c_tab[1] = (double) i ;
        return c_tab;
    }

    public static double[] y_rect(String line)//Ici on fera la modification de y du rectangle
    {
        int i = 0;
        double[] c_tab = {0.0,0.0};
        while(line.charAt(i) != '"') 
            i++;
        
        c_tab[0] = 30.0; //(double) Double.valueOf(line.substring(0,i));//
        c_tab[1] = (double) i ;
        return c_tab;
    }

    public static double height_rect(String line)//Hauteur du rectangle
    {
        int i = 0;
        while(line.charAt(i) != '"') 
            i++;
    
        return (double) Double.valueOf(line.substring(0,i));
    }

    public static double width_rect(String line)//Largeur du rectangle
    {
        int i = 0;
        while(line.charAt(i) != '"') 
            i++;
        
        return (double) Double.valueOf(line.substring(0,i));
    }

    public static double[] x_ellipse(String line)
    {
        int i = 0;
        double[] c_tab = {0.0,0.0};
        while(line.charAt(i) != '"') 
            i++;
        
        c_tab[0] = 50.0; //(double) Double.valueOf(line.substring(0,i));//
        c_tab[1] = (double) i;
        return c_tab;
    }

    public static double[] y_ellipse(String line)
    {
        int i = 0;
        double[] c_tab = {0.0,0.0};
        while(line.charAt(i) != '"') 
            i++;
        
        c_tab[0] = 50.0; //(double) Double.valueOf(line.substring(0,i));//
        c_tab[1] = (double) i ;
        return c_tab;

    }


    public static double width_ellipse(String line)
    {
        int i = 0;
        while(line.charAt(i) != '"') 
            i++;
        
        return (double) Double.valueOf(line.substring(0,i));
    }

    public static double height_ellipse(String line)
    {
        int i = 0;
        while(line.charAt(i) != '"') 
            i++;
        
        return (double) Double.valueOf(line.substring(0,i));
    }

    public static double[] x_text(String line)//Bouge un champ de type text en x
    {
        int i = 0;
        double[] c_tab = {0.0,0.0};
        while(line.charAt(i) != '"') 
            i++;
        
        c_tab[0] = 50.0; //(double) Double.valueOf(line.substring(0,i));//
        c_tab[1] = (double) i;
        return c_tab;
    }

    public static double[] y_text(String line)//Bouge un champ de type text en y 
    {
        int i = 0;
        double[] c_tab = {0.0,0.0};
        while(line.charAt(i) != '"') 
            i++;
        
        c_tab[0] = 50.0; //(double) Double.valueOf(line.substring(0,i));//
        c_tab[1] = (double) i ;
        return c_tab;

    }






    public static boolean chiffre_in_line(String line)//Savoir si on au moins un chiffre dans la commande
    {
        int i = 0;
        while(i<line.length()) {
            if((line.charAt(i) >= '0') && (line.charAt(i) <= '9'))
               return true;

            i++;
        }
        return false;
    }

    public static int nb_chiffre(String line) 
    {
       
            int i = 0;
            int cpt = 0;
            while(i<line.length()) {
                if((line.charAt(i) >= '0') && (line.charAt(i) <= '9')) {
                    cpt++;
                }
            }
        return cpt;
    }

    public static int index_last_chiffre(String line)
    {
        int i = line.length();
        while(i >= 0) {
            i--;
            if((line.charAt(i) >= '0') && (line.charAt(i) <= '9')) 
               return i;//On a l'indice du dernier chiffre;*/
            
        }
        return -1;
    }

    public static int index_premier_chiffre(String line)
    {
        int i = 0;
        while(i < line.length()) {
            if((line.charAt(i) >= '0') && (line.charAt(i) <= '9')) 
               return i;//On a l'indice du premier chiffre;

            i++;
            
        }
        return -1;
    }

    public static boolean is_inCommandes(char c)//Savoir si le caractere est une commande
    {
        int i = 0;
        for(i = 0 ; i < tableau_commandes.length;i++){
            if(c == tableau_commandes[i])
                return true;
        }
        return false;

    }

    public static int index_of_commande(char c)//Sort l'index de la commande trouver
    {
        int i = 0;
        for(i = 0 ; i < tableau_commandes.length;i++){
            if(c == tableau_commandes[i])
                return i;

        }
        return -1;

    }

    public static int index_of_petite_commande(char c)
    {
        int i = 0;
        for(i = 1 ; i < tableau_commandes.length;i = i+2 ){
            if(c == tableau_commandes[i])
                return i;

        }
        return -1;

    }

    public static int index_of_grande_commande(char c)
    {
        int i = 0;
        for(i = 0 ; i < tableau_commandes.length;i = i+2 ){
            if(c == tableau_commandes[i])
                return i;

        }
        return -1;  
    }

    public static char getCommande(char c) 
    {//Retourner la commande selectionné par c
        int n = 0;
        if(( n = index_of_commande(c))!= -1)
            return tableau_commandes[n];

        return 'K';//Commande non trouvé
    }

    public static double getCommande_by_double(double c_n) 
    {
        int n = 0;
        if(( n = index_of_commande((char)c_n))!= -1)
            return (double) tableau_commandes[n];

        return -1;//Commande non trouvé
    }

    public static double getPetiteCommande_by_double(double c_n)
    {
        int n = 0;
        if(( n = index_of_petite_commande((char)c_n))!= -1)
            return (double) tableau_commandes[n];

        return -1;//Commande non trouvé  

    }
    
    public static boolean commande_in_line(String line)//Savoir si on a une commande dans la ligne
    {
        int i = 0;
        while(i<line.length()) {
            if(is_inCommandes(line.charAt(i)))
                return true;

            i++;
        }
        return false; 
    }

    public static int next_commande_in_line(String line)
    {
        int i = 0;
        while(i<line.length()) {
            if(is_inCommandes(line.charAt(i)))
                return i++;

            i++;
        }
        return -1;
    }

    public static ArrayList<Double> dim_segment(String line)
    {
        double[] tab_recup = {0.0,0.0,0.0};
        ArrayList<Double> tab = new ArrayList<Double>();
        double n = 0.0;
        boolean chiffre = false;
        while((chiffre = chiffre_in_line(line))) {
            if((line.length() > 0 ) && (is_inCommandes(line.charAt(0)))) {
                double d = (double) line.charAt(0);
                tab.add((Double) d);
                tab.add(-0.0);
                line = line.substring((int) 1);
                System.out.println(line);
            }
            else {
                tab_recup = coordonnees(line);
                tab.add((Double)tab_recup[0]);
                tab.add((Double)tab_recup[1]);
                n = tab_recup[2] + 1;//Ce n'est pas + 1 mais l'index du prochain chiffre 
                line = line.substring((int)n); 
            }
        }
        return tab;
      
    }

    public static void readfile(String str) {
        try {
            File myObj = new File(str);
            FileWriter sortie = new FileWriter("tmp.svg");
            Scanner myReader = new Scanner(myObj); 
            int view_path = 0;
            int view_d = 0;
            int n = 0;
            int view_rect = 0;
            int view_x = 0;
            int view_y = 0;
            /*int view_height = 0;
            int view_width = 0;*/
            int view_ellipse = 0;
            int view_cx = 0;
            int view_cy = 0;
            int view_text = 0;
            int view_x_text = 0;
            int view_y_text = 0;
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                //On modifie la data que l'on a lu 
            
                
                if((data.indexOf("<path")!=-1) && (view_path == 0)) //On change une simple variable pour acceder à une partie qui va se declencher que après ce passage
                    view_path = 1;
                   
        
                if(view_path == 1) {
                    if(((n = data.indexOf(" d="))!=-1) && (view_d == 0)) {
                        view_d = 1;
                        String data_1 = data.substring(0,n+5);
                        String data_2 = data.substring(n+6);
                        char m_M = data_1.charAt(data_1.length()-1);
                        ArrayList<Double> tableau = new ArrayList<Double>();
                        String chiffre_restant = "";
                        if(m_M == 'm') {
                            double[] tab = coordonnees(data_2);
                            tableau.add((Double)tab[0]);
                            tableau.add((Double)tab[1]);
                            chiffre_restant = data_2.substring((int)tab[2]);
                        }
                        else {                          
                            tableau = dim_segment(data_2);
                        }
                        
                        String insert_coordonnes = "";
                        int i = 0;
                        Double g = 0.0;
                        int block_modif = 0;
                        int index_data_suivant = 0;
                        int index_g = 0;
                        for(i = 0 ; i< tableau.size(); i = i+2) {
                            if((g=getCommande_by_double(tableau.get(i)))!=-1) {
                                double shift = (double) tableau.get(i);
                                char c = (char) shift;
                                insert_coordonnes += " "+ c ;//La grosse lettre on y touche pas 
                                System.out.println("insert_coordonnees : "+insert_coordonnes);
                                System.out.println("g : "+g);
                                //Mais si on croise une petite lettre on conserve la suite 
                                if(index_of_petite_commande(c) != -1) {
                                    
                                    System.out.println("chiffre petite commande "+chiffre_restant);
                                    index_g = data_2.indexOf(c,index_g);
                                    chiffre_restant = data_2.substring(index_g+1);
                                    index_data_suivant = next_commande_in_line(chiffre_restant)-1;
                                    chiffre_restant = chiffre_restant.substring(0,index_data_suivant);
                                    block_modif = 1;
                                    System.out.println("cr "+chiffre_restant);
                                    index_g++;//Juste pour passer le l que l'on a passer
                                }   
                                
                                else if(index_of_grande_commande(c) != -1) {
                                    block_modif = 0;
                                }
                            }
                            else if(block_modif == 1){
                                insert_coordonnes += chiffre_restant;
                            }

                            else if(block_modif == 0) {
                                insert_coordonnes += " "+tableau.get(i) + ","+ tableau.get(i+1);
                            }
                            System.out.println("g "+g);
                        }

                        String fin_data_2 = "";
                        if(chiffre_restant == "") {
                            fin_data_2 = data_2.substring(index_last_chiffre(data_2));
                        }
                        
                        String affiche_data = data_1 + insert_coordonnes + chiffre_restant + fin_data_2;
                        view_path = 0;
                        data = affiche_data;
                        System.out.println(data);
                        view_d = 0;
                    }
                }
                if((data.indexOf("<rect")!=-1) && (view_rect == 0)) //On change une simple variable pour acceder à une partie qui va se declencher que après ce passage
                    view_rect = 1;

                if(view_rect == 1) {
                    /*if(((n = data.indexOf("width="))!= -1) && (view_width == 0)) {
                        view_width = 1;
                        String data_1 = data.substring(0,n+7);
                        String data_2 = data.substring(n+8);
                        double[] tableau = width_rect(data_2);
                        String insert_coordonnes =  String.valueOf(tableau[0]);
                        String data_3 = data_2.substring((int) tableau[1]);
                        String affiche_data = data_1 + insert_coordonnes + data_3;
                        data = affiche_data;
                        System.out.println(data);
                    }

                    if(((n = data.indexOf("height="))!= -1) && (view_width == 0)) {
                        view_width = 1;
                        String data_1 = data.substring(0,n+8);
                        String data_2 = data.substring(n+9);
                        double[] tableau = height_rect(data_2);
                        String insert_coordonnes =  String.valueOf(tableau[0]);
                        String data_3 = data_2.substring((int) tableau[1]);
                        String affiche_data = data_1 + insert_coordonnes + data_3;
                        data = affiche_data;
                        System.out.println(data);
                    }*/

                    if(((n = data.indexOf("x="))!= -1) && (view_x == 0)) {
                        view_x = 1;
                        String data_1 = data.substring(0,n+3);
                        String data_2 = data.substring(n+4);
                        double[] tableau = x_rect(data_2);
                        String insert_coordonnes =  String.valueOf(tableau[0]);
                        String data_3 = data_2.substring((int) tableau[1]);
                        String affiche_data = data_1 + insert_coordonnes + data_3;
                        data = affiche_data;
                        System.out.println(data);
                    }

                    if((( n = data.indexOf("y="))!=-1) && (view_y == 0)) {
                        view_y = 1;
                        String data_1 = data.substring(0,n+3);
                        String data_2 = data.substring(n+4);
                        double[] tableau = y_rect(data_2);
                        String insert_coordonnes =  String.valueOf(tableau[0]);
                        String data_3 = data_2.substring((int) tableau[1]);
                        String affiche_data = data_1 + insert_coordonnes + data_3;
                        data = affiche_data;
                        System.out.println(data);
                    } 
                }

                if((data.indexOf("<tspan")!=-1) && (view_text == 0)) //On change une simple variable pour acceder à une partie qui va se declencher que après ce passage
                    view_text = 1;

                if(view_text == 1) {
                    if(((n = data.indexOf(" x="))!= -1) && (view_x_text == 0)) {
                        view_x_text = 1;
                        String data_1 = data.substring(0,n+4);
                        String data_2 = data.substring(n+5);
                        double[] tableau = x_text(data_2);
                        String insert_coordonnes =  String.valueOf(tableau[0]);
                        String data_3 = data_2.substring((int) tableau[1]);
                        String affiche_data = data_1 + insert_coordonnes + data_3;
                        data = affiche_data;
                        System.out.println(data);
                    }

                    if((( n = data.indexOf(" y="))!=-1) && (view_y_text == 0)) {
                        view_y_text = 1;
                        String data_1 = data.substring(0,n+4);
                        String data_2 = data.substring(n+5);
                        double[] tableau = y_text(data_2);
                        String insert_coordonnes =  String.valueOf(tableau[0]);
                        String data_3 = data_2.substring((int) tableau[1]);
                        String affiche_data = data_1 + insert_coordonnes + data_3;
                        data = affiche_data;
                        System.out.println(data);
                    
                    }
                }

                if((data.indexOf("<ellipse")!=-1) && (view_ellipse == 0)) //On change une simple variable pour acceder à une partie qui va se declencher que après ce passage
                    view_ellipse = 1;

                if(view_ellipse == 1) {
                    if(((n = data.indexOf("cx="))!= -1) && (view_cx == 0)) {
                        view_cx = 1;
                        String data_1 = data.substring(0,n+4);
                        String data_2 = data.substring(n+5);
                        double[] tableau = x_ellipse(data_2);
                        String insert_coordonnes =  String.valueOf(tableau[0]);
                        String data_3 = data_2.substring((int) tableau[1]);
                        String affiche_data = data_1 + insert_coordonnes + data_3;
                        data = affiche_data;
                        System.out.println(data);
                    }

                    if((( n = data.indexOf("cy="))!=-1) && (view_cy == 0)) {
                        view_cy = 1;
                        String data_1 = data.substring(0,n+4);
                        String data_2 = data.substring(n+5);
                        double[] tableau = y_ellipse(data_2);
                        String insert_coordonnes =  String.valueOf(tableau[0]);
                        String data_3 = data_2.substring((int) tableau[1]);
                        String affiche_data = data_1 + insert_coordonnes + data_3;
                        data = affiche_data;
                        System.out.println(data);
                    
                    }
                }

                    /*if(((n = data.indexOf("rx="))!= -1) && (view_rx == 0)) {
                        view_ry = 1;
                        String data_1 = data.substring(0,n+7);
                        String data_2 = data.substring(n+8);
                        double[] tableau = width_ellipse(data_2);
                        String insert_coordonnes =  String.valueOf(tableau[0]);
                        String data_3 = data_2.substring((int) tableau[1]);
                        String affiche_data = data_1 + insert_coordonnes + data_3;
                        data = affiche_data;
                        System.out.println(data);
                    }

                    if(((n = data.indexOf("ry="))!= -1) && (view_ry == 0)) {
                        view_ry = 1;
                        String data_1 = data.substring(0,n+8);
                        String data_2 = data.substring(n+9);
                        double[] tableau = height_ellipse(data_2);
                        String insert_coordonnes =  String.valueOf(tableau[0]);
                        String data_3 = data_2.substring((int) tableau[1]);
                        String affiche_data = data_1 + insert_coordonnes + data_3;
                        data = affiche_data;
                        System.out.println(data);
                    }*/
                //}

                sortie.write(data + "\n");
            }
            myReader.close();
            sortie.close();
        } 
        catch (IOException e) {
            System.out.println("An error occurred , file not exist or the path is not right");
        }   
    }


    public static void main(String[] args) {
        readfile(args[0]);
        
    }
}