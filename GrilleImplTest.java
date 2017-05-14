package miage;
import static org.junit.Assert.*;
import org.junit.Test;

/**
 * @author nguele ebale ebenny atejo.
 * classe contenant les tests de la classe GrilleImpl
 */
public class GrilleImplTest {

	/**
	 * Insttance de la classe GrilleImpl pour avoir accès aux méthodes.
	 */
	private GrilleImpl grille  = new GrilleImpl();
	/**
	 * la grille de sudoku 9X9.
	 */
	private char[][] su = {{'@', '@', '9', '@', '2', '@', '3', '@', '@'},
		            {'6', '8', '@', '@', '9', '@', '@', '2', '4'},
		            {'@', '@', '@', '1', '8', '6', '@', '@', '@'},
		            {'@', '@', '3', '@', '@', '@', '5', '@', '@'},
		            {'@', '@', '5', '7', '@', '3', '8', '@', '@'},
		            {'7', '@', '@', '@', '@', '@', '@', '@', '2'},
		            {'9', '@', '@', '@', '@', '@', '@', '@', '1'},
		            {'5', '1', '@', '@', '@', '@', '@', '9', '6'},
		            {'2', '@', '@', '@', '@', '@', '@', '@', '3'}};
	/**
	 * Test de la fonction getDimesion.
	 */
	@Test
	public void testGetDimension() {
		assertEquals(9, grille.getDimension());
	}
	/**
	 * Test de la fonction setValue.
	 */
	@Test
	public void testSetValue() {
		grille.sudoku9 = su;
		// teste sur les exceptions
		try {
			// x hors bornes
			grille.setValue(-1, 5, '2');
			fail("Une exception aurait dûe être levée sur x");
			// y hors bornes
			grille.setValue(4, 17, '2');
			fail("Une exception aurait dûe être levée sur y");
			// x et y hors bornes
			grille.setValue(-1, 11, '2');
			fail("Une exception aurait dûe être levée sur x et y");
			//value non permise
			grille.setValue(7, 3, 'k');
			fail("Une exception aurait dûe être levée sur value");
			// valeur non permise au vu des autres
			grille.setValue(0, 0, '9');
			fail("Une exception aurait dûe être levée sur value car 9 existe déjà sur cette ligne");
		} catch (IllegalArgumentException e) {
		}
	}
	/**
	 * Test de la fonction getValue.
	 */
	@Test
	public void testGetValue() {
		grille.sudoku9 = su;
		// teste sur les exceptions
				try {
					// x hors bornes
					grille.setValue(-1, 5, '2');
					fail("Une exception aurait dûe être levée sur x");
					// y hors bornes
					grille.setValue(4, 17, '2');
					fail("Une exception aurait dûe être levée sur y");
					// x et y hors bornes 
					grille.setValue(-1, 11, '2');
					fail("Une exception aurait dûe être levée sur x et y");			
				} catch (IllegalArgumentException e) {
				}
				// tests sur les valeurs
				assertEquals('5', grille.getValue(7, 0));
				assertEquals('@', grille.getValue(0, 0));
	}
	/**
	 * Test de la fonction Complete.
	 */
	@Test
	public void testComplete() {
		grille.sudoku9 = su;
		assertEquals(false, grille.complete());
	}
	/**
	 * Test de la fonction Possible.
	 */
	@Test
	public void testPossible() {
		grille.sudoku9 = su;
		try {
			// x hors bornes
			grille.setValue(-1, 5, '2');
			fail("Une exception aurait dûe être levée sur x");
			// y hors bornes
			grille.setValue(4, 17, '2');
			fail("Une exception aurait dûe être levée sur y");
			// x et y hors bornes
			grille.setValue(-1, 11, '2');
			fail("Une exception aurait dûe être levée sur x et y");
		} catch (IllegalArgumentException e) {
		}
		assertEquals(false, grille.possible(0, 0, '9'));
		assertEquals(true, grille.possible(0, 0, '1'));
	}
}
