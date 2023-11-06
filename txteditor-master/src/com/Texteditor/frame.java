package com.Texteditor;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JTextArea;
import javax.swing.KeyStroke;
import javax.swing.UIManager;
import javax.swing.border.LineBorder;

class frame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected JMenuBar menubar;
	protected JFrame frame;
	protected JMenu filemenu, editmenu, helpmenu, Settings;
	protected JMenuItem open, support, about, save_us, exit, cut, copy, paste;
	protected JTextArea txtarea;
	protected ImageIcon img;
	protected JCheckBox chckbxNewCheckBox;

	public frame() {
		super("Text_Editor");
		img = new ImageIcon("notebook.png");
		menubar = new JMenuBar();
		menubar.setPreferredSize(new Dimension(0, 40));
		menubar.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		menubar.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		filemenu = new JMenu("File");
		filemenu.setPreferredSize(new Dimension(45, 21));

		filemenu.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		filemenu.setBorder(UIManager.getBorder("EditorPane.border"));
		editmenu = new JMenu("Edit");
		editmenu.setPreferredSize(new Dimension(45, 21));
		editmenu.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		editmenu.setBorder(UIManager.getBorder("EditorPane.border"));
		Settings = new JMenu("Settings");
		Settings.setPreferredSize(new Dimension(60, 21));
		Settings.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		Settings.setBorder(UIManager.getBorder("EditorPane.border"));
		helpmenu = new JMenu("Help");
		helpmenu.setPreferredSize(new Dimension(55, 21));
		helpmenu.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		helpmenu.setBorder(UIManager.getBorder("EditorPane.border"));
		/////////////////////////

		/////////////////////////
		menubar.add(filemenu);
		menubar.add(editmenu);
		menubar.add(Settings);

		chckbxNewCheckBox = new JCheckBox("Dark Theme");
		chckbxNewCheckBox.setFocusable(false);
		Settings.add(chckbxNewCheckBox);
		menubar.add(helpmenu);
		menubar.setBackground(new Color(153, 180, 209));

		/////////////////////////
		open = new JMenuItem("Open");

		support = new JMenuItem("Support");
		support.setForeground(Color.BLACK);
		about = new JMenuItem("About");
		about.setForeground(new Color(0, 0, 0));
		save_us = new JMenuItem("Save_us");
		cut = new JMenuItem("Cut");
		copy = new JMenuItem("Copy");
		paste = new JMenuItem("Paste");
		exit = new JMenuItem("Exit");
		/////////////////////////
		open.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, InputEvent.CTRL_DOWN_MASK));
		open.setMnemonic('O');

		save_us.setMnemonic('S');
		save_us.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.CTRL_DOWN_MASK));

		paste.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_V, InputEvent.CTRL_DOWN_MASK));
		paste.setMnemonic('P');

		copy.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, InputEvent.CTRL_DOWN_MASK));
		copy.setMnemonic('C');

		cut.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X, InputEvent.CTRL_DOWN_MASK));
		cut.setMnemonic('X');

		about.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, InputEvent.CTRL_DOWN_MASK));
		about.setMnemonic('A');

		support.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.SHIFT_DOWN_MASK));
		support.setMnemonic('S');

		exit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E, InputEvent.CTRL_DOWN_MASK));
		exit.setMnemonic('E');
		/////////////////////////
		filemenu.add(open);
		filemenu.add(save_us);
		filemenu.add(exit);
		/////////////////////////
		editmenu.add(cut);
		editmenu.add(copy);
		editmenu.add(paste);

		/////////////////////////
		helpmenu.add(support);
		helpmenu.add(about);

		/////////////////////////
		txtarea = new JTextArea();
		txtarea.setCaretColor(Color.BLACK);
		txtarea.setFont(new Font("Arial", Font.PLAIN, 20));

		/////////////////////////
		getContentPane().add(txtarea);
		setIconImage(img.getImage());
		new JFrame("Text_Editor");
		setVisible(true);
		setJMenuBar(menubar);
		setSize(600, 600);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		////////////////////////////

	}

}
