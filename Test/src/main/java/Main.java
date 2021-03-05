import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.Timer;

public class Main {
	public static void main(String[] args) {
		new JFrameApp();
	}
}

class JFrameApp extends JFrame {
	private static final long serialVersionUID = 1L;

	public JFrameApp() {
		setTitle("My Application");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		add(new JPanelApp());
		setBounds(100, 100, 500, 700);
		setVisible(true);
	}
}

class JPanelApp extends JPanel {
	private static final long serialVersionUID = 1L;
	private Font font = new Font("TimesRoman", Font.BOLD, 23);

	public JPanelApp() {
		setLayout(null);
		Random rnd = new Random();
		final int[] array = new int[10];
		for (int i = 0; i < 10; i++) {
			array[i] = rnd.nextInt(100);
		}
		method(array);
		final JButton but = new JButton("Sort");
		but.setBounds(100, 10, 70, 20);
		add(but);

		final int DEFAULT_SPEED = 1000;

		but.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Timer timer = new Timer(DEFAULT_SPEED, new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						int low = 0;
						int high = array.length - 1;
						if (array.length == 0)
							return;
						if (low >= high)
							return;
						int middle = low + (high - low) / 2;
						int opora = array[middle];
						int i = low, j = high;
						while (i <= j) {
							while (array[i] < opora) {
								i++;
							}
							while (array[j] > opora) {
								j--;
							}
							if (i <= j) {
								int temp = array[i];
								array[i] = array[j];
								array[j] = temp;
								i++;
								j--;
								method(array);
							}
							System.out.println(Arrays.toString(array));
						}
					}
				});
				timer.start();
			}
		});

	}

	public void method(int[] array) {
		JTextField text;
		int x = 10;
		int y = 10;
		int h = 30;
		int w = 50;
		removeAll();
		for (int i = 0; i < 10; i++) {
			text = new JTextField(String.valueOf(array[i]));
			add(text).setBounds(x, y, w, h);
			text.setBackground(Color.yellow);
			text.setFont(font);
			y += 40;
		}
	}
}