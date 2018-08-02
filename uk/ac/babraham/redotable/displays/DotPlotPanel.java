package uk.ac.babraham.redotable.displays;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

import uk.ac.babraham.redotable.datatypes.SequenceCollectionAlignment;
import uk.ac.babraham.redotable.displays.alignment.CollectionAlignmentPanel;
import uk.ac.babraham.redotable.displays.scaleBars.HorizontalScaleBar;
import uk.ac.babraham.redotable.displays.scaleBars.VerticalScaleBar;

public class DotPlotPanel extends JPanel {

	private HorizontalScaleBar xScale;
	private VerticalScaleBar yScale;
	private JPanel centrePanel;
	
	private GridBagConstraints gbc;
	
	
	public DotPlotPanel () {
		
		setLayout(new GridBagLayout());
		setBackground(Color.WHITE);
		
		xScale = new HorizontalScaleBar(0, 100);
		yScale = new VerticalScaleBar(0, 100);
		
		centrePanel = new JPanel();
		centrePanel.setBackground(Color.WHITE);
		centrePanel.setLayout(new BorderLayout());
		centrePanel.add(new JLabel("No alignment yet",JLabel.CENTER),BorderLayout.CENTER);
		
		gbc = new GridBagConstraints();
		gbc.gridx=1;
		gbc.gridy=1;
		gbc.weightx=0.999;
		gbc.weighty=0.001;
		gbc.fill= GridBagConstraints.BOTH;
		
		add(xScale,gbc);
		
		gbc.gridx=0;
		gbc.gridy=0;
		gbc.weightx=0.001;
		gbc.weighty=0.999;
		
		add(yScale,gbc);
		
		gbc.gridx=1;
		gbc.weightx=0.999;
		
		add(centrePanel,gbc);
	}
	
	public void setAlignment (SequenceCollectionAlignment alignment) {
		xScale.setLimits(0, alignment.collectionX().length());
		yScale.setLimits(0, alignment.collectionY().length());
		
		remove(centrePanel);
		validate();
		
		centrePanel = new CollectionAlignmentPanel(alignment);
		add(centrePanel,gbc);
		
		validate();
		repaint();
	}
	
}