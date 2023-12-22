public class Piece {
    protected double hauteur;
    protected double largeur;
    protected int[] tab_vides;
    protected double border_size;
    


    public void getHauteurPiece() 
    {
        System.out.println(this.hauteur);
    }

    public void getLargeurPiece() 
    {
        System.out.println(this.largeur);
    }

    public void getBorderSizePiece() 
    {
        System.out.println(this.border_size);
    }



    public boolean espace_vide() 
    {
        if(this.tab_vides != null) 
            return true;
        else 
            return false;    
    }

    public boolean ThisPieceInPieceB(Piece B) {
        Double[] piece_dim_interne_B = B.dimension_espace_vide();
        double dim_l_A = this.largeur;
        double dim_h_A = this.hauteur;
        if((piece_dim_interne_B[0] > dim_h_A ) && (piece_dim_interne_B[1] > dim_l_A))
            return true;
        else
            return false;
    }


    public Double[] dimension_espace_vide() 
    {
        Double[] tab = {0.0,0.0};
        if(this.espace_vide()== true)  {
            double dim_l_interne = this.largeur - this.border_size;
            double dim_h_interne = this.hauteur - this.border_size;
            tab[0] = dim_h_interne;
            tab[1] = dim_l_interne;
        }
        return tab;
    }


    





}