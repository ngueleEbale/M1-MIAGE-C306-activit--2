package miage;
import static org.junit.Assert.*;
import org.junit.Test;
/**
* Tests d'écriture , TabAlgos.java.
*
*@author manatejo@gmail.com (Nguele Ebale)
*
**/
public final class TabAlgos {
	/**
	*Calcul la moyenne des valeurs d' un tableau.
	*@param tab le tableau
	*@return la moyenne de tab
	*/
	public static double moyenne(final int[] tab) {
		int somme = 0;
		if (tab != null) {
			for (int i = 0; i < tab.length; i++) {
				somme += tab[i];
			}
		} else {
			throw new IllegalArgumentException("Tableaux null");
		}
			return  somme / tab.length;
		}
	/**
	*Renvoie la valeur mediane des valeurs d' un tableau.
	*@param tab le tableau
	*@return la mediane de tab
	*/
	public static int mediane(final int[] tab) {
		int[] tab1;
		int mediane = 0;
			if (tab.length != 0 || tab != null) {
				// on tri le tabaleau
				//affiche(tab);
				tab1 = tribulles(tab);
				//affiche(tab1);
				int n = tab1.length;
				if (tab1.length % 2 == 0) {
					mediane = (tab1[(n / 2) -  1] + tab[(n / 2)]) / 2;
				} else {
					mediane = tab1[((n + 1)  / 2) - 1];
				}
			} else if (tab == null) {
	throw new IllegalArgumentException("Tableaux null");
			}
			return mediane;
		}
	/**
	 * Renvoie la valeur la plus grande d' un tableau.
	 * @param tab le tableau
	 *@return max le plus grand nombre de tab
	 */
	public static int plusGrand(final int[] tab) {
		int max = 0;
		for (int i = 0; i < tab.length; i++) {
			if (tab[i] > max) {
				max = tab[i];
			}
		}
		return max;
	}
	/**
	*Teste si 2 tableaux sont identiques.
	*(avec les elements dans le meme ordre)
	*@param tab1 le tableau
	*@param tab2 le second
	*@return true s'ils sont égaux et false sinon
	*/
	public static boolean egaux(final int[] tab1, final int[] tab2) {
		boolean valeur = true;
		if (tab1 != null && tab2 != null) {
			if (tab1.length == tab2.length) {
					for (int i = 0; i  < tab1.length; i++) {
						// cas de différence
						if (tab1[i] != tab2[i]) {
							valeur = false;
							break;
						}
					}
			} else {
				// longueurs différentes
				 valeur = false;
			}
		} else {
			throw new IllegalArgumentException("Tableaux null");
		}
		return valeur;
	}
	/**
	*Teste si 2 tableaux sont identiques.
	*(les elements peuvent etre dans un ordre différent)
	*@param tab1 le tableau
	*@param tab2 le second
	*@return true s'ils sont similaires et false sinon
	*/
	public static boolean similaires(final int[] tab1, final int[] tab2) {
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
	*Effectuer un tibulle.
	*@param t le tableau
	*@return tableau trié
	*/
	public static int[] tribulles(final int[] t) {
            for (int i = 0; i <=  (t.length - 2); i++) {
                    for (int j = (t.length - 1); i < j; j--) {
                            if (t[j] < t[j - 1]) {
                                    int x =  t[j - 1];
                                    t[j - 1] = t[j];
                                    t[j] = x;
                            }
                    }
            }
            return t;
    }
	/**
	 * Tests unitaires sur la moyenne.
	 */
	@Test
	public void  testMoyenne() {
		int[] tab = {1, 1, 1};
		assertEquals(1, moyenne(tab), 1);
		int[] tab1 = {1, 2, 3};
		assertEquals(2, moyenne(tab1), 1);
	}
	/**
	 * Tests unitaires sur kes paramètres de toutes les méthodes.
	 */
	@Test
	public void testParametre() {
		 try {
			 moyenne(null);
			 mediane(null);
			 plusGrand(null);
			 egaux(null, null);
			similaires(null, null);
			 fail("Une exception aurait dûe être levée sur tab");
		 } catch (IllegalArgumentException e) {
		 }
	}
	/**
	 * Tests unitaires sur PlusGrand.
	 */
	@Test
	public void testPlusGrand() {
		// les mêmes valeurs.
		int[] tab = {1, 1, 1};
		assertEquals(1, plusGrand(tab));
		// test sur 0
		int[] tab1 = {-1, -2, 0};
		assertEquals(0, plusGrand(tab1));
		// en ordre
		int[] tab2 = {1, 2, 3};
		assertEquals(3, plusGrand(tab2));
		// en désordre
		int[] tab3 = {3, 1, 2};
		assertEquals(3, plusGrand(tab3));
	}
	/**
	 * Tests unitaires sur la mediane.
	 */
	@Test
	public void testMediane() {
		int[] tab3 =  {12, 5, 6, 89, 5, 2390, 1}; // impair
		int[] tab4 =  {12, 5, 6, 89, 5, 1}; //pair
		assertEquals(6, mediane(tab3));
		assertEquals(5, mediane(tab4));
	}
	/**
	 * Tests unitaires sur Egaux.
	 */
	@Test
	public void testEgaux() {
		int[] tab  = {1, 2, 3};
		int[] tab1 = {1, 2, 3};
		int[] tab2 = {3, 1, 2};
		int[] tab3 = {1, 2, 4};
		assertEquals(true, egaux(tab, tab1));
		assertEquals(false, egaux(tab, tab2));
		assertEquals(false, egaux(tab, tab3));
	}
	/**
	 * Tests unitaires sur Similaires.
	 */
	@Test
	public void testSimilaires() {
		int[] tab  = {1, 2, 3};
		int[] tab1 = {1, 2, 3};
		int[] tab2 = {3, 1, 2};
		int[] tab3 = {3, 1, 4};
		assertEquals(true, similaires(tab, tab1));
		assertEquals(true, similaires(tab, tab2));
		assertEquals(false, similaires(tab, tab3));
	}
}
