package fr.fiegel.conjugueur.client.ui;

import java.awt.Component;
import java.awt.LayoutManager;

import javax.swing.JPanel;
/**
 * JPanel amélioré, les composants qu'il contient ont le même état (enabled/disabled) que lui-même
 * @author Michel
 *
 */
public class DisablablePanel extends JPanel {

	private static final long serialVersionUID = -7022191498299579027L;

	public DisablablePanel() {
		super();
	}

	public DisablablePanel(LayoutManager layout) {
		super(layout);
	}

	public DisablablePanel(boolean isDoubleBuffered) {
		super(isDoubleBuffered);
	}

	public DisablablePanel(LayoutManager layout, boolean isDoubleBuffered) {
		super(layout, isDoubleBuffered);
	}
	
	@Override
	public void setEnabled(boolean enabled) {
		super.setEnabled(enabled);
		Component[] comps = this.getComponents();
		for(int i=0;i<comps.length;i++){
			comps[i].setEnabled(enabled);
		}
	}

}
