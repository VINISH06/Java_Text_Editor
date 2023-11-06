package com.Texteditor;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

public class Text_Editor extends frame implements ActionListener {
	protected JFileChooser Chooser;
	protected FileWriter writer;
	protected FileReader reader;
	protected BufferedReader br;
	protected StringBuilder sb;

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Text_Editor() {

		///////////////////////////////////////////////////////////////////////////////////////////////////

		open.addActionListener(this);

		save_us.addActionListener(this);

		copy.addActionListener(this);

		paste.addActionListener(this);

		cut.addActionListener(this);

		about.addActionListener(this);

		support.addActionListener(this);

		exit.addActionListener(this);

		chckbxNewCheckBox.addActionListener(this);

	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == open) {
			Chooser = new JFileChooser();
			Chooser.setApproveButtonText("Open this");
			Chooser.setDialogTitle("Open a files..");
			Chooser.setCurrentDirectory(new File("."));
			Chooser.setFileFilter(new FileNameExtensionFilter("Text Files(*.txt)", "txt"));
			Chooser.setFileFilter(new FileNameExtensionFilter("Java Source Files(*.java)", "java"));
			int Value = Chooser.showOpenDialog(this);
			if (Value == JFileChooser.APPROVE_OPTION) {
				try {
					reader = new FileReader(Chooser.getSelectedFile());
					br = new BufferedReader(reader);
					String line;
					sb = new StringBuilder();
					while ((line = br.readLine()) != null) {
						sb.append(line).append("\n");
						txtarea.setText(sb.toString());
						br.close();
					}
				} catch (IOException evt) {
					evt.printStackTrace();
				}

			}
		} else if (e.getSource() == copy) {
			txtarea.copy();

		} else if (e.getSource() == paste) {

			txtarea.paste();

		} else if (e.getSource() == cut) {

			txtarea.cut();

		} else if (e.getSource() == about) {

			String message = "Created :by @Vinish06" + "\n" + "Contact_us:SvinishXXx@gmail.com";
			String title = "About us";
			showMessage(title, message);
		} else if (e.getSource() == support) {

			String message = "Support:2023-2029";
			String title = "Support";
			showMessage(title, message);

		} else if (e.getSource() == chckbxNewCheckBox) {

			if (chckbxNewCheckBox.isSelected()) {
				txtarea.setBackground(Color.BLACK);
				txtarea.setForeground(Color.WHITE);
				menubar.setBackground(Color.green);

			} else {
				txtarea.setBackground(Color.WHITE);
				txtarea.setForeground(Color.BLACK);
				menubar.setBackground(new Color(153, 180, 209));
			}

		} else if (e.getSource() == exit) {
			String responses[] = { "keep edit", "Exit" };
			int r = JOptionPane.showOptionDialog(null, "Do You Want to Exit", "Exit", JOptionPane.YES_NO_CANCEL_OPTION,
					JOptionPane.WARNING_MESSAGE, null, responses, 0);
			if (r == 1) {
				exit();

			}
		} else if (e.getSource() == save_us) {
			Chooser = new JFileChooser();
			Chooser.setApproveButtonText("Save");
			Chooser.setDialogTitle("Save file as");
			Chooser.setFileFilter(new FileNameExtensionFilter("Text Files(*.txt)", "txt"));
			Chooser.setFileFilter(new FileNameExtensionFilter("Java Source Files(*.java)", "java"));
			Chooser.setCurrentDirectory(new File("."));
			int Value = Chooser.showSaveDialog(this);
			if (Value == JFileChooser.APPROVE_OPTION) {
				try {
					writer = new FileWriter(Chooser.getSelectedFile().getAbsolutePath());
					writer.write(txtarea.getText());
					writer.close();
				} catch (IOException evt) {
					evt.printStackTrace();
				}
			}
		}

	}

	public void showMessage(String title, String message) {
		JOptionPane.showMessageDialog(null, message, title, JOptionPane.INFORMATION_MESSAGE);
	}

	public void exit() {
		System.exit(0);
	}

	public static void main(String[] args) {

		new Text_Editor();

	}

}
