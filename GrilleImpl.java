package miage;
/**
 * Implementation de l'interface Grille.
 * @author atejo and clauvis
 */
public class GrilleImpl implements Grille {
	/**
	 * la grille de sudoku.
	 */
	public char[][] sudoku9 = new char[9][9];
	/**
	 * Les caractères possibles.
	 */
	static final char[] possible = new char[] {'1', '2', '3', '4', '5', '6', '7', '8', '9'};
	 /**
	  * La taille de la grille.
	  * @return largeur/hauteur de la grille
	  */
	@Override
	public int getDimension() {
		int taille = this.sudoku9.length;
		return taille;
	}
	/**
	* Affecte une valeur dans la grille.
	**@param x position x dans la grille
	* @param y position y dans la grille
	* @param value valeur a mettre dans la case
	* @throws IllegalArgumentException si x ou y sont hors bornes (0-8)
	* @throws IllegalArgumentException si la valeur est
	* interdite aux vues des
	* autres valeurs de la grille
	* @throws IllegalArgumentException si value n'est
	* pas un caractere autorise
	* ('1',...,'9')
	*/
	@Override
	public void setValue(int x, int y, char value)
			 throws IllegalArgumentException {
		if (!(x >= 0 && x <= 8) || !(y >= 0 && y <= 8)){
			throw new IllegalArgumentException("Valeur non permise pour x ou y");
		}
		if (!possible(x, y, value)) {
			throw new IllegalArgumentException("Position impossible pour cette valeur");
		}
		this.sudoku9[x][y] = value;
	}
	/**
	* Recupere une valeur de la grille.
	**@param x position x dans la grille
	* @param y position y dans la grille
	* @return valeur dans la case x,y
	* @throws IllegalArgumentException si x ou y sont hors bornes (0-8)
	*/
	@Override
	public char getValue(int x, int y) throws IllegalArgumentException {
		if (!(x >= 0 && x <= 8) || !(y >= 0 && y <= 8)) {
		throw new IllegalArgumentException("Valeur non permise pour x ou y");
		}
		return this.sudoku9[x][y];
	}
	/**
	* Test si une grille est terminee.
	**@return true si la grille est complete false sinon
	*/
	@Override
	public boolean complete() {
		boolean indic = true;
		// teste si chaque ligne du sudoku est similaire au tableau possible.
		// c'est à dire qu'il teste si chaque ligne  comtient tous les caractères possibles.
		for (int i = 0; i < 9; i++) {
			if (similaires(sudoku9[i], possible) == false) {
				indic = false;
				break;
			}
		}
		// teste si chaque colonne du sudoku est similaire au tableau possible.
		//teste si toutes les colonnes contiennet tous les caractères possibles.
		char[] colonne = new char[9];
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				// on recopie les éléments d'une colonne dans un tableau vide.
				colonne[j] = sudoku9[j][i];
			}
			// si la colonne n'est pas similaire à possible alors on arrete.
			if (similaires(colonne, possible) == false) {
				indic = false;
				break;
			}
		}
		
		return indic;
	}
	/**
	* Test si une valeur est possible dans la grille par rapport a ce qu'elle.
	* contient deja
	**@param x position x dans la grille
	* @param y position y dans la grille
	* @param value valeur a mettre dans la case
	* @throw IllegalArgumentException si x ou y
	* sont hors bornes (0-8)
	* @throw IllegalArgumentException si value
	*  n'est pas un caractere autorise
	* ('1',...,'9',..)
	* @return boolean  true si c'est possible et false sinon
	*/
	@Override
	public boolean possible(int x, int y, char value)
			throws IllegalArgumentException {
		
		// teste si les valeurs sont comprises dans les bornes
		if (!(x >= 0 && x <= 8 ) || !(y >= 0 && y <= 8 )) {
			throw new IllegalArgumentException("Valeur non permise pour x ou y");
		}
		// teste si le caractère est autorisé c'est à dire est contenu dans le tableau possible.
		if (contient(possible, value) == false) {
		throw new IllegalArgumentException("La valeur " + value + " est impossible !");
		}
		boolean indic = true;
		// on teste si la valeur n'existe pas encore sur la ligne
		for (int i = 0; i < 8; i++) {
			// si on trouve cette valeur  dans la ligne x
			if (sudoku9[x][i] == value) {
				indic = false;
				break;
			}
		}
		// on teste si la valeur n'existe pas encore sur la colonne
		for (int i = 0; i < 8; i++) {
			// si on trouve cette valeur  dans la colonne y
			if (sudoku9[i][y] == value) {
				indic = false;
				break;
			}
		}
		return indic;
	}
	/**
	 * méthode utilitaire.
	*Teste si 2 tableaux sont identiques.
	*(les elements peuvent etre dans un ordre différent)
	*@param tab1 le tableau
	*@param tab2 le second
	*@return true s'ils sont similaires et false sinon
	*/
	public  boolean similaires(char[] tab1,  char[] tab2) {
		boolean valeur = false;
		if (tab1 != null || tab2 != null) {
			if (tab1.length == tab2.length) {
				for (int i = 0; i < tab1.length; i++) {
					for (int j = 0; j < tab2.length; j++) {
						// si on trouve
						if (tab1[i] == tab2[j]) {
							valeur = true;
							break;
						}
						valeur = false;
					}
					if (!valeur) {
						break;
					}
				}
			}
		} else {
			throw new IllegalArgumentException("Tableaux null");
		}
		return valeur;
	}

	/**
	 * méthode utilitaire.
	*Teste si une valeur est contenue dans un tableau
	*@param tab le tableau
	*@param value la valeur
	*@return true si la valeur existe et false sinon
	*/
	public  boolean contient(char[] tab, char value) {
		boolean indic = false;
		for (int i = 0; i < tab.length; i++) {
			if (tab[i] == value) {
				indic = true;
				break;
			}
		}
		return indic;
	}
}
