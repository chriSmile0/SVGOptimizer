import java.util.Collection;

public class Main {
    public static void main(String[] args) {
        Carre c = new Carre(100,100,5);
        c.getHauteurPiece();
        c.getLargeurPiece();
        c.getBorderSizePiece();

        Piece o = new Carre(200,200,5);
        o.getHauteurPiece();
        o.getLargeurPiece();
        o.getBorderSizePiece();

        Piece f = new Carre(300,300,5);

        System.out.println("Dimensions interne : hauteur : " + o.dimension_espace_vide()[0]+ "largeur :" + o.dimension_espace_vide()[1]);
        Piece[] tabP = {c,o,f};
        Collection_piece collect = new Collection_piece(tabP);
        System.out.println(collect.indexOfPieceEnterInMaxInternPlace(c));//Fonctionne , affiche bien la piece qui possede l'espace vide le plus grand possible pour stocker la piece
        System.out.println(collect.indexOfPieceEnterInMinInternPlace(c));//Fonctionne , affiche bien la piece qui possede l'espace vide le plus petit possible pour stocker la piece
        System.out.println("La piece la plus grand est à l'indice : "+collect.indexOfMaxPieceDimension());
        System.out.println("Est ce qu'une pièce peut s'inclure dans une autre ? si cpt > 0 alors oui sinon non : cpt "+collect.NbPieceInMaxInternalPlace());
        System.out.println(collect.indexOfMaxPieceDimension());
        collect.trieCollection();
        System.out.println(collect.indexOfMaxPieceDimension());

    }






}