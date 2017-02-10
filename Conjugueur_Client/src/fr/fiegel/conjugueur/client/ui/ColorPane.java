package fr.fiegel.conjugueur.client.ui;

import java.awt.Color;

import javax.swing.JTextPane;
import javax.swing.text.AttributeSet;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyleContext;

/**
 * 
 * @author Michel
 * @see <a href="https://www.java-tips.org/java-se-tips-100019/15-javax-swing/1843-how-to-add-colored-text-to-the-document.html">https://www.java-tips.org/java-se-tips-100019/15-javax-swing/1843-how-to-add-colored-text-to-the-document.html</a>
 */
public class ColorPane extends JTextPane {

	private static final long serialVersionUID = 4097989376249872622L;

	public ColorPane() {
		super();
	}
	
	public void append(Color c, String s) { 
	    StyleContext sc = StyleContext.getDefaultStyleContext();
	    AttributeSet aset = sc.addAttribute(SimpleAttributeSet.EMPTY,
	                                        StyleConstants.Foreground, c);
	   
	    int len = getDocument().getLength(); // same value as getText().length();
	    setCaretPosition(len);  // place caret at the end (with no selection)
	    setCharacterAttributes(aset, false);
	    replaceSelection(s); // there is no selection, so inserts at caret
	  }
}
