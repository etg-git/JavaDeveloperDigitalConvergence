package kr.ac.green;

import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.KeyStroke;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.Document;

public class SimpledPad extends JFrame {

	private JMenuBar mBar;
	private JMenu mFile;
	private JMenuItem miNew;
	private JMenuItem miOpen;
	private JMenuItem miSave;
	private JMenuItem miSaveAs;
	private JMenuItem miExit;

	private JTextArea taEditor;

	private JFileChooser chooser;

	private String title = "SimplePad ver1.0";

	private File file;

	private int saveResult;

	public SimpledPad() {
		init();
		setDisplay();
		addListeners();
		showFrame();
	}

	private void init() {
		mBar = new JMenuBar();
		mFile = new JMenu("File");
		miNew = new JMenuItem("New");
		KeyStroke newFile = KeyStroke.getKeyStroke(KeyEvent.VK_N, InputEvent.CTRL_DOWN_MASK);
		miNew.setAccelerator(newFile);
		miOpen = new JMenuItem("Open");
		miSave = new JMenuItem("Save");
		KeyStroke save = KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.CTRL_DOWN_MASK);
		miSave.setAccelerator(save);
		miSaveAs = new JMenuItem("SaveAs");
		miExit = new JMenuItem("Exit");

		mFile.add(miNew);
		mFile.add(miOpen);
		mFile.add(miSave);
		mFile.add(miSaveAs);
		mFile.add(miExit);

		mBar.add(mFile);

		taEditor = new JTextArea();

		chooser = new JFileChooser("c:\\");
	}

	private void setDisplay() {
		setJMenuBar(mBar);
		add(new JScrollPane(taEditor), BorderLayout.CENTER);

	}

	private void addListeners() {
		ActionListener listener = (ae) -> {
			Object src = ae.getSource();

			if (src == miOpen) {
				open();
			} else if (src == miSave) {
				save();
			} else if (src == miNew) {
				newFile();
			} else if (src == miSaveAs) {
				saveAs();
			} else {
				exit();
			}
		};

		miOpen.addActionListener(listener);
		miSave.addActionListener(listener);
		miExit.addActionListener(listener);
		miNew.addActionListener(listener);
		miSaveAs.addActionListener(listener);
		Document doc = taEditor.getDocument();

		doc.addDocumentListener(new DocumentListener() {

			@Override
			public void removeUpdate(DocumentEvent e) {
			}

			// 내용이 변했을때만 감지한다
			@Override
			public void insertUpdate(DocumentEvent e) {
				setTitle(title + "*");
			}

			@Override
			public void changedUpdate(DocumentEvent e) {

			}
		});
	}

	private void newFile() {
		int save = 0;
		if (getTitle().contains("*")) {
			save = JOptionPane.showConfirmDialog(this, "이전파일 저장하시겠습니까?", "저장", JOptionPane.YES_NO_CANCEL_OPTION);
			if (save == JOptionPane.YES_OPTION) {
				save();
			} else if (save == JOptionPane.NO_OPTION) {
				taEditor.setText("");
				file = null;
				setTitle(title);
			}
		}
		if (save != JOptionPane.CANCEL_OPTION && saveResult == chooser.APPROVE_OPTION) {
			taEditor.setText("");
			file = null;
			setTitle(title);
		}
	}

	private void save() {
		FileWriter fw = null;

		if (file != null) {
			try {
				fw = new FileWriter(file);
				fw.write(taEditor.getText());
				fw.flush();
				JOptionPane.showMessageDialog(this, "저장완료");
			} catch (IOException e) {
				JOptionPane.showMessageDialog(this, "저장할수없습니다");
			}
			setTitle(title);
		} else {
			saveAs();
		}
	}
	private void openPrint() {
		int result = chooser.showOpenDialog(this);

		if (result == chooser.APPROVE_OPTION) {
			file = chooser.getSelectedFile();

			FileReader fr = null;
			BufferedReader br = null;
			try {
				fr = new FileReader(file);
				br = new BufferedReader(fr);

				String line = null;
				StringBuilder builder = new StringBuilder();
				while ((line = br.readLine()) != null) {
					builder.append(line + "\n");
				}
				taEditor.setText(builder.toString());
			} catch (IOException e) {
				JOptionPane.showMessageDialog(this, "불러오는 중 에러발생");
			} finally {
				MyUtils.closeAll(br, fr);
			}
			setTitle(title);
		}
	}
	private void open() {
		int save = 0;
		if (getTitle().contains("*")) {
			save = JOptionPane.showConfirmDialog(this, "이전파일 저장하시겠습니까?", "저장", JOptionPane.YES_NO_CANCEL_OPTION);
			if (save == JOptionPane.YES_OPTION) {
				save();
			} else if(save == JOptionPane.NO_OPTION){
				openPrint();
			}
		} else {
			openPrint();
		}
	}

	private void saveAs() {
		saveResult = chooser.showSaveDialog(this);

		if (saveResult == chooser.APPROVE_OPTION) {
			file = chooser.getSelectedFile();

			FileWriter fw = null;
			try {
				fw = new FileWriter(file);
				fw.write(taEditor.getText());
				fw.flush();
			} catch (IOException e) {
				JOptionPane.showMessageDialog(this, "저장중 에러발생");
			} finally {
				MyUtils.closeAll(fw);
			}
			setTitle(title);
		}

	}

	private void exit() {
		if (getTitle().contains("*")) {
			int save = JOptionPane.showConfirmDialog(this, "저장을하시겠습니까?", "저장", JOptionPane.YES_NO_CANCEL_OPTION);
			if (save == JOptionPane.YES_OPTION) {
				save();
			} else if (save == JOptionPane.NO_OPTION) {
				System.exit(0);
			}
		} else {
			System.exit(0);
		}
	}

	private void showFrame() {
		setTitle(title);
		setSize(500, 400);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}

	public static void main(String[] args) {
		new SimpledPad();
	}
}
