public class Collection_piece {
	private Piece[] TabPiece;
	public Collection_piece(Piece[] TabPiece){
		this.TabPiece = TabPiece;
    }

    public int indexOfPieceEnterInMaxInternPlace(Piece p)//On choisit l'espace le plus grand possible
    {
        int i = 0;
        double max_l_dim = 0;
        double max_h_dim = 0;
        int indice_piece = -1;
        for(i = 0; i < TabPiece.length;i++) {
            if(TabPiece[i].espace_vide() == true) {
                if(((TabPiece[i].hauteur > max_h_dim ) && (TabPiece[i].largeur > max_l_dim)) 
                    &&(p.ThisPieceInPieceB(TabPiece[i]))) {
                        max_h_dim = TabPiece[i].hauteur;
                        max_l_dim = TabPiece[i].largeur;
                        indice_piece = i;
                }
            }
        }

        return indice_piece;

    }

    public int indexOfPieceEnterInMinInternPlace(Piece p)//On choisit l'espace le plus optimisé donc le plus petit possible pour y stocker la piece
    {
        int i = 0;
        double min_l_dim = 10000;
        double min_h_dim = 10000;
        int indice_piece = -1;
        for(i = 0; i < TabPiece.length;i++) {
            if(TabPiece[i].espace_vide() == true) {
                if(((TabPiece[i].hauteur < min_h_dim ) && (TabPiece[i].largeur < min_l_dim)) 
                    &&(p.ThisPieceInPieceB(TabPiece[i]))) {
                        min_h_dim = TabPiece[i].hauteur;
                        min_l_dim = TabPiece[i].largeur;
                        indice_piece = i;
                }
            }
        }

        return indice_piece;

    }

    public int indexOfPieceMaxInternPlace() 
    {
        int i = 0;
        double max_l_dim = 0;
        double max_h_dim = 0;
        Double[] piece_dim_interne = {0.0,0.0};
        int indice_piece = -1;
        for(i = 0; i < TabPiece.length;i++) {
            if(TabPiece[i].espace_vide() == true) {
                piece_dim_interne = TabPiece[i].dimension_espace_vide(); 
                if((piece_dim_interne[0] > max_h_dim ) && (piece_dim_interne[1] > max_l_dim)) {
                    max_h_dim = piece_dim_interne[0];
                    max_l_dim = piece_dim_interne[1];
                    indice_piece = i;
                }  
            }
        }

        return indice_piece;
    }

    //On va chercher la piece avec le plus grand espace vide possible , et parcourir la collection pour savoir si une pièce rentre dedans
    //Si cette méhode nous renvoie autre chose que 0 alors il faudra refaire une boucle pour placer la bonne pièce dans les bons espaces vides
    //Sinon cela veut dire qu'il n'y a aucunes pièces qui rentrent dans une autre donc que l'on peut s'arreter là

    public int indexOfMaxPieceDimension() 
    {
        int i = 0;
        int indice_max = 0;
        for(i = 0 ; (i < TabPiece.length) ; i++) {
            if((TabPiece[i].hauteur > TabPiece[indice_max].hauteur) && (TabPiece[i].largeur > TabPiece[indice_max].largeur))
                indice_max = i;
        }
        return indice_max;
    }

    public void echanger(Piece[] TabPiece,int i , int j )
    {
        Piece tmp;
        tmp = TabPiece[i];
        TabPiece[i] = TabPiece[j];
        TabPiece[j] = tmp;
    }

    public void trieCollection() 
    {
        int indice_max;
        for(int i  = TabPiece.length; i>0 ; i--) {
            indice_max = indexOfMaxPieceDimension();
            echanger(TabPiece,i-1,indice_max);
        }
    }






    public int NbPieceInMaxInternalPlace() 
    {
        int cpt = 0;
        int index_max_empty_space = this.indexOfPieceMaxInternPlace();
        Piece p = TabPiece[index_max_empty_space];
        int index_max_piece = indexOfMaxPieceDimension();
        for(int i = 0 ; i < TabPiece.length ; i++) {
            if(TabPiece[i].ThisPieceInPieceB(p))
                cpt++;
        }
        

        return cpt;
    }

}
	