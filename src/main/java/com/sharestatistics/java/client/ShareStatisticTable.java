/**
 * Copyright (c) 2014. All rights reserved.
 **/
package com.sharestatistics.java.client;

import java.awt.BorderLayout;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 * The ShareStatisticTable is class of type {@link JPanel} 
 * It wraps java JTable to render the value of max share price in
 * tabular form.
 *
 * @author Uttam Bhatia
 * @version 1.0
 * @since   2014-05-14 
 *
 */
class ShareStatisticTable extends JPanel
 {
	private static final long serialVersionUID = 1L;
	String columnNames[] = { "Year", "Month", "Share Price" };
	private DefaultTableModel tableModel;
	String dataValues[][] ={};

	private	JTable		table;
	private	JScrollPane scrollPane;

	/**
	 * Constructor
	 */
	public ShareStatisticTable()
	{
		setLayout( new BorderLayout() );

		table = new JTable();
		tableModel = new DefaultTableModel(columnNames,0);
	    table.setModel(tableModel);
	    
		scrollPane = new JScrollPane( table );
		add( scrollPane, BorderLayout.CENTER );
	}
	
	/**
	 * @param dataValues:Dynamically render the value in the 
	 * table on company selection change.
	 */
	public void addRow(final String [] dataValues)
	{
		tableModel.setRowCount(0);
		tableModel.addRow(dataValues);
	}

}

