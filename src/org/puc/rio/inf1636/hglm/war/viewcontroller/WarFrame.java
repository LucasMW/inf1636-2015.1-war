package org.puc.rio.inf1636.hglm.war.viewcontroller;

import javax.swing.BoxLayout;
import javax.swing.JFrame;

import org.puc.rio.inf1636.hglm.war.Util;
import org.puc.rio.inf1636.hglm.war.model.Territory;

public class WarFrame extends JFrame {

	private UIPanel uiPanel;
	private MapPanel mapPanel;
	private AttackFrame attackFrame;
	private ChooseNumberFrame chooseNumberFrame;

	public WarFrame() {
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setTitle("War - by Hugo Grochau and Lucas Menezes");
		this.setSize(Util.getGameSize());
		this.getContentPane().setLayout(
				new BoxLayout(this.getContentPane(), BoxLayout.Y_AXIS));
		this.setResizable(false);
		this.addPanels();
		this.setVisible(true);
	}

	private void addPanels() {
		this.mapPanel = new MapPanel();
		this.uiPanel = new UIPanel();
		this.getContentPane().add(mapPanel);
		this.getContentPane().add(uiPanel);
	}

	public MapPanel getMapPanel() {
		return this.mapPanel;
	}

	public UIPanel getUIPanel() {
		return this.uiPanel;
	}

	public void update(boolean first) {
		this.uiPanel.update(first);
		this.mapPanel.update(first);
	}

	public void spawnAttackFrame(Territory from, Territory to, int number) {
		this.attackFrame = new AttackFrame(from, to, number);
		this.attackFrame.setVisible(true);
	}

	public void spawnChooseNumberFrame(int number, String message) {
		this.chooseNumberFrame = new ChooseNumberFrame(number, message);
		this.chooseNumberFrame.setVisible(true);
	}
}
