/**
 * Copyright (c) 2014. All rights reserved.
 **/
package com.sharestatistics.java.client;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import com.sharestatistics.java.client.api.IStatistics;
import com.sharestatistics.java.client.spi.Statistics;

/**
 * The SwingGUITestClient program is a stand-alone Swing-based GUI program to
 * test the back-end functionality in user-friendly way.
 *
 * @author Uttam Bhatia
 * @version 1.0
 * @since   2014-05-14 
 *
 */
public class SwingGUITestClient extends JFrame implements ActionListener{

	private static final long serialVersionUID = 1L;
	private static String[] companyNames = {};
	private IStatistics stat=new Statistics();
	private ShareStatisticTable jtablePanel=new ShareStatisticTable();

	private JTextField textfield1 = new JTextField("Select any to view max price of share : ");

	private JComboBox<String> comboBox = new JComboBox<String>();

	private int count = 0;

	/**
	 * Default constructor.
	 */
	public SwingGUITestClient() {

		companyNames=stat.getCompanyName();

		for(int i = 0; i < companyNames.length; i++)
			comboBox.addItem(companyNames[count++]);
		textfield1.setEditable(false);

		comboBox.addActionListener(this);

		setLayout(new FlowLayout());
		add(textfield1);
		add(comboBox); 
		add(jtablePanel);

	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		setFrame(new SwingGUITestClient(), 450, 250);
	}

	/**
	 * @param frame
	 * @param width
	 * @param height
	 */
	public static void setFrame(final JFrame frame, final int width, final int height) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				frame.setTitle(frame.getClass().getSimpleName());
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setSize(width, height);
				frame.setVisible(true);
			}
		});
	}

	/**
	 * (non-Javadoc)
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 **/
	@Override
	public void actionPerformed(ActionEvent e) {

		ClientDto dto=stat.getMaxShareHoldingDetail((String)    
				((JComboBox<String>)e.getSource()).getSelectedItem());

		String[] dataValues=new String[]{
				dto.getYear(),dto.getMonth(),dto.getTotalShares()+""
		};

		jtablePanel.addRow(dataValues);
	}

}