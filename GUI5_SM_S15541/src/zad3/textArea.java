package zad3;


import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class textArea extends JFrame {
	
				
				String tFont;
				String tColour;
				String tSize;
				String bColour;
				boolean isBold;
				boolean isUnderlined;
				boolean isItalic;


		 public textArea() {

			    SwingUtilities.invokeLater(new Runnable() {

			      @Override
			      public void run() {
			        produceTextArea();
			      }
			    });
			  }

			  protected void produceTextArea() {
				getContentPane().setLayout(new FlowLayout());
				//JPanel questionPanel = new JPanel();
				Box questionPanel = new Box( BoxLayout.Y_AXIS);
				setTitle("Pytania");
				//questionPanel.setLayout(new BoxLayout(questionPanel, BoxLayout.Y_AXIS));
				questionPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
			
			//	Dimension d = new Dimension(500, 500);
			//	setPreferredSize(d);
				this.add(questionPanel);

				JCheckBoxMenuItem bold = new JCheckBoxMenuItem();
				JCheckBoxMenuItem italic = new JCheckBoxMenuItem();
				
				DefaultListModel<String> fontListD = new DefaultListModel<String>();
				JList<String> fontList = new JList<>( fontListD );
				fontListD.addElement("Arial");
				fontListD.addElement("Comic Sans MS");
				fontListD.addElement("Calibri");
				
				DefaultListModel<String> sizeListD = new DefaultListModel<String>();
				JList<String> sizeList = new JList<>( sizeListD );
				sizeListD.addElement("8");
				sizeListD.addElement("30");
				sizeListD.addElement("48");
				
				DefaultListModel<String> bColourListD = new DefaultListModel<String>();
				JList<String> bColourList = new JList<>( bColourListD );
				bColourListD.addElement("żółty");
				bColourListD.addElement("zielony");
				bColourListD.addElement("niebieski");
				
				DefaultListModel<String> tColourListD = new DefaultListModel<String>();
				JList<String> tColourList = new JList<>( tColourListD );
				tColourListD.addElement("czerwony");
				tColourListD.addElement("szary");
				
				JButton ok = new JButton("OK");
				
				
				questionPanel.add(new JLabel("Podaj typ czcionki: "));
				questionPanel.add(Box.createRigidArea(new Dimension(5,5)));
				questionPanel.add(fontList);
				questionPanel.add(Box.createRigidArea(new Dimension(30,30)));
				questionPanel.add(new JLabel("Podaj styl czcionki: "));
				questionPanel.add(Box.createRigidArea(new Dimension(5,5)));
				questionPanel.add(new JLabel("Pogrubiona"));
				questionPanel.add(bold);
				questionPanel.add(new JLabel("Kursywa"));
				questionPanel.add(italic);
				questionPanel.add(Box.createRigidArea(new Dimension(30,30)));
				questionPanel.add(new JLabel("Podaj rozmiar czcionki. Domyślna czcionka będzie w rozmiarze 20"));
				questionPanel.add(Box.createRigidArea(new Dimension(5,5)));
				questionPanel.add(sizeList);
				questionPanel.add(Box.createRigidArea(new Dimension(30,30)));
				questionPanel.add(new JLabel("Podaj kolor tła. Domyślne tło będzie białe"));
				questionPanel.add(Box.createRigidArea(new Dimension(5,5)));
				questionPanel.add(bColourList);
				questionPanel.add(Box.createRigidArea(new Dimension(30,30)));
				questionPanel.add(new JLabel("Podaj kolor czcionki. Domyślna czcionka będzie czarna"));
				questionPanel.add(Box.createRigidArea(new Dimension(5,5)));
				questionPanel.add(tColourList);
				questionPanel.add(Box.createRigidArea(new Dimension(30,30)));
				questionPanel.add(ok);
				
				
				bold.addItemListener(new ItemListener() {
				      public void itemStateChanged(ItemEvent e) {
				        isBold = bold.isSelected();
				      }
				    });
				
				italic.addItemListener(new ItemListener() {
				      public void itemStateChanged(ItemEvent e) {
				        isItalic = italic.isSelected();
				      }
				    });
				
				sizeList.addListSelectionListener(new ListSelectionListener() {
		            @Override
		            public void valueChanged(ListSelectionEvent arg0) {
		            	tSize = sizeList.getSelectedValue();
		                }
		        });
				
				fontList.addListSelectionListener(new ListSelectionListener() {
		            @Override
		            public void valueChanged(ListSelectionEvent arg0) {
		            	tFont = fontList.getSelectedValue();
		                }
		        });
				
				tColourList.addListSelectionListener(new ListSelectionListener() {
		            @Override
		            public void valueChanged(ListSelectionEvent arg0) {
		            	tColour = tColourList.getSelectedValue();
		                }
		        });
				
				bColourList.addListSelectionListener(new ListSelectionListener() {
		            @Override
		            public void valueChanged(ListSelectionEvent arg0) {
		            	bColour = bColourList.getSelectedValue();
		                }
		        });
				
								
				ok.addActionListener(
		                new ActionListener(){
		                    public void actionPerformed(ActionEvent e){
		                       dispose();
		                       new readyText(tFont, tColour, tSize, bColour, isBold, isItalic);
		                    }
		                });
	
				setDefaultCloseOperation(EXIT_ON_CLOSE);
			    pack();
			    setLocationRelativeTo(null);
			    setVisible(true);
			  }
	

	
}
