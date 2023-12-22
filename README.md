					PROJET POO2
//Optimiation de l'espace a découper , c'est à dire , positionner au mieux les motifs/pièces pour occuper le moins de place possible

//Algorithme

I(*
-Tout d'abord il faut définir la plus grande pièce de la collection en pixels , par x et y 
	-Algo:
		Collection<- Tout les objets présents sur l'image
		Comparer les différentes dimensions de tout les objets
			Les comparer d'abord dans la hauteur puis dans la largeur
		Extraire la collection , qui doit être rangés du plus grand au plus petit objet

	-Retour algo : Collection[0] , repond à notre première interrogation


-Coller la pièce la plus grande pièce à un peu près 3px du bord en haut à gauche
-Retenir dans une variable h et l , la hauteur qu'il nous reste sous la plus grande pièce et sur une largeur l qui correspond à la largeur de la plus grande pièce
	-Algo:
		h<- 1m - Collection[0].hauteur
		l<- (infini) - Collection[0].largeur
		place_piece<- h*l
		Voir dans la Collection quelle est la plus grande pièce qui peut rentrer dans une place de dimensions 'place_piece'
		Retourner l'indice de la pièce qui correspond à cette condition
		Si aucune pièce ne correspond on retourne -1
	-Retour algo : 
		(INT) indice 
		Sinon -1
			Alors avancer le curseur de placement de l //a traiter lors de la grande boucle qui placera les pièces



*)
	

II(*

Une fois que toutes les pièces sont plus ou moins bien placées , donc les unes à cotés des autres ou en dessous des autres
Il va falloir optimiser l'algo pour essayer de faire rentrer une pièce dans une autre.
Exemple nous avons la lettre A de dimension 200cm de haut et 100cm de large: On pourra donc faire rentré en théorie un L de largeur 62.5cm et de hauteur 70cm (verifier par la pratique sous échelle)

-Chercher LA pièce qui bénéficie du plus grand espace occupable , c'est à dire que à l'intérieur de cette forme on peut y stocker d'autres formes ou motif.
	L'Algo1 cherche le plus grand espace vide parmis tout les pièces de la collection
	-Algo1: 
		-max_l<- 0
		-max_h<- 0
		-i<- 0
		-indice_piece<- 0
		-espace_vide<-0
		Comparer les différentes dimensions internes de chaque forme (il faut exclure les groupes car on ne peut rien mettre à l'interieur):
			-Parcours de la Collection:
				Si Collection[i].Nb_espace_vides > 0 :
					j<- 0
					Tant que j < Collection[i].Nb_espaces_vides:
						Si Collection[i].tab_vides[j].hauteur*Collection[i].tab_vides[j].largeur > max_h*max_l:
							max_h<- Collection[i].tab_vides[j].hauteur
							max_l<- Collection[i].tab_vides[j].largeur
							espace_vide<- j	//Indice qui correspond à l'espace vide le plus grand possible dans une piece que l'on parcours
							indice_piece<- i //Indice de cette pièce 
						Fin Si
						j<- j++
					Fin Tant que	
				Fin Si
			-Fin parcours	

		-On retourne le couple (indice_piece,espace_vide)		
		
	-Retour algo:
		Retour du couple (indice_piece,espace_vide) qui nous permettra de trouver la bonne pièce et le bonne espace pour y stocker une forme qui soit la plus grande possible pour y rentrer


	On va maintenant chercher avec l'Algo la pièce qui rentrera le mieux dans l'espace de pièce
	Collection[indice_piece].tab_vides[espace_vide].hauteur*Collection[indice_piece].tab_vides[espace_vide].largeur
	-Algo:
		h<- Collection[indice_piece].tab_vides[espace_vide].hauteur
		l<- Collection[indice_piece].tab_vides[espace_vide].largeur
		//On peut aussi appeler l'algo précedent et utilser le retour cet algo
		place_piece<- h*l
		Voir dans la Collection quelle est la plus grande pièce qui peut rentrer dans une place de dimensions 'place_piece'
		Retourner l'indice de la pièce qui correspond à cette condition
		Si aucune pièce ne correspond on retourne -1 
			
	-Retour algo : 
		(INT) indice 
		Sinon -1
			//Ce qui voudra que aucune pièce ne peut s'inserer dans une autre pièce.!!!!!



*)


III(*
	



*)
	


		


		





