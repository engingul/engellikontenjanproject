package com.engelli.kontenjan;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.JCheckBox;
import javax.swing.SwingConstants;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class EngelliKontenjan {

	private JFrame frame;
	private JTextField txtToplamCalisan;
	private JTextField txtEngelliCalisan;
	private JTextField txtCalistirilmasiGereken;
	private JTextField txtEngelliKontenjanFarki;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EngelliKontenjan window = new EngelliKontenjan();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public EngelliKontenjan() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 728, 555);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(224, 255, 255));
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);

		Font font = new Font("Courier", Font.BOLD, 15);

		JLabel lblEngelliKontenjan = new JLabel("Engelli Kontenjan Hesabı");
		lblEngelliKontenjan.setBounds(226, 11, 307, 31);
		lblEngelliKontenjan.setBackground(Color.ORANGE);
		lblEngelliKontenjan.setForeground(Color.BLUE);
		lblEngelliKontenjan.setFont(font);
		panel.add(lblEngelliKontenjan);

		JLabel lblToplamCalisan = new JLabel("Toplam Çalışan Sayısı ");
		lblToplamCalisan.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblToplamCalisan.setForeground(new Color(0, 0, 255));
		lblToplamCalisan.setBounds(10, 44, 229, 38);
		panel.add(lblToplamCalisan);

		JLabel lblEngelliKontenjanFarki = new JLabel("Engelli Kontenjan Farkı");
		lblEngelliKontenjanFarki.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblEngelliKontenjanFarki.setForeground(Color.BLUE);
		lblEngelliKontenjanFarki.setBounds(10, 203, 264, 38);
		panel.add(lblEngelliKontenjanFarki);

		JLabel lblCalistirilmasiGereken = new JLabel("Çalıştırılması Gereken Engelli Sayısı");
		lblCalistirilmasiGereken.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblCalistirilmasiGereken.setForeground(Color.BLUE);
		lblCalistirilmasiGereken.setBounds(10, 156, 264, 51);
		panel.add(lblCalistirilmasiGereken);

		JLabel lblEngellialanSayisi = new JLabel("Engelli Çalışan Sayısı");
		lblEngellialanSayisi.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblEngellialanSayisi.setForeground(Color.BLUE);
		lblEngellialanSayisi.setBounds(10, 82, 229, 38);
		panel.add(lblEngellialanSayisi);

		JLabel lblSonuc = new JLabel("Sonuç");
		lblSonuc.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblSonuc.setForeground(Color.BLUE);
		lblSonuc.setBounds(10, 354, 117, 45);
		panel.add(lblSonuc);

		txtToplamCalisan = new JTextField();
		txtToplamCalisan.setBounds(424, 53, 215, 20);
		panel.add(txtToplamCalisan);
		txtToplamCalisan.setColumns(10);

		txtEngelliCalisan = new JTextField();
		txtEngelliCalisan.setColumns(10);
		txtEngelliCalisan.setBounds(424, 91, 215, 20);
		panel.add(txtEngelliCalisan);

		txtCalistirilmasiGereken = new JTextField();
		txtCalistirilmasiGereken.setColumns(10);
		txtCalistirilmasiGereken.setBounds(424, 172, 215, 20);
		panel.add(txtCalistirilmasiGereken);

		txtEngelliKontenjanFarki = new JTextField();
		txtEngelliKontenjanFarki.setColumns(10);
		txtEngelliKontenjanFarki.setBounds(424, 212, 215, 20);
		panel.add(txtEngelliKontenjanFarki);

		JLabel lblSonucValue = new JLabel("");
		lblSonucValue.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblSonucValue.setBounds(243, 308, 397, 153);
		panel.add(lblSonucValue);

		JButton btnHesapla = new JButton("Hesapla");
		btnHesapla.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnHesapla.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				int totalEmployee = 0;
				int disabledPersonelCount = 0;
				int engelliKontenjanFarki =0;
				int engelliKontenjanStatus =0;
				try {
				if (txtToplamCalisan != null && txtEngelliCalisan != null) {
					if (txtToplamCalisan.getText() != "" && isNumerical(txtToplamCalisan.getText())
							&& txtEngelliCalisan.getText() != "" && isNumerical(txtToplamCalisan.getText())) {
                        
						totalEmployee =txtToplamCalisan.getText()== "" ? 0 :  Integer.parseInt(txtToplamCalisan.getText());
						
						if(totalEmployee < 50) {
							txtCalistirilmasiGereken.setText(String.valueOf(0));
							txtEngelliKontenjanFarki.setText(String.valueOf(0)); 
							engelliKontenjanFarki = 0;
						} else {
							
							disabledPersonelCount = Integer.parseInt(txtEngelliCalisan.getText());

							int calistirilmasiGereken = 0;
							if (totalEmployee != 0  && totalEmployee > 0) {

								double gerekenEngelli = (totalEmployee * 3.0) / 100.0f;
								int intPart = (int) gerekenEngelli;
								double decimalPart = gerekenEngelli - intPart;
								if (decimalPart >= 0.5) {
									calistirilmasiGereken = (int) roundCeil(gerekenEngelli);
									txtCalistirilmasiGereken.setText(String.valueOf(calistirilmasiGereken));
								} else if (decimalPart < 0.5) {
									calistirilmasiGereken = (int) roundFloor(gerekenEngelli);
									txtCalistirilmasiGereken.setText(String.valueOf(calistirilmasiGereken));
								}

							}
                            engelliKontenjanStatus = disabledPersonelCount - calistirilmasiGereken;
						    engelliKontenjanFarki = Math.abs(disabledPersonelCount - calistirilmasiGereken);
							txtEngelliKontenjanFarki.setText(String.valueOf(engelliKontenjanFarki));

						}
						
						if (engelliKontenjanStatus == 0 ||  engelliKontenjanStatus> 0) {
							lblSonucValue.setText("Engelli Açığı Yok");
						} else if (engelliKontenjanStatus < 0) {
							lblSonucValue.setText("Engelli Açığı Var!!!");
						} else {
							lblSonucValue.setText("İşlemde Hata Var!!!");
						}
					} else if (txtToplamCalisan.getText() == "" || txtEngelliCalisan.getText() == "") {
						lblSonucValue.setText("Lütfen numerik değerler giriniz!!!");
					}
					
					}
				} catch(NumberFormatException ex){ // handle your exception
					lblSonucValue.setText("Lütfen numerik değerler giriniz!!!");
				}

			}
		});
		btnHesapla.setBounds(424, 122, 215, 39);
		panel.add(btnHesapla);

	}

	private static double roundCeil(double value) {
		return Math.ceil(value);
	}

	private static double roundFloor(double value) {
		return Math.floor(value);
	}

	public boolean isNumerical(String value) {
		int i = 0;
		if (value.length() > 0) {
			while (i < value.length()) {
				int temp = (int) value.charAt(i);
				
				if(i== 0 && value.length() == 1 && temp == 48) {
					return true;
				}
				if (i == 0 && (temp == 48 || temp == 0 || temp == 32)) {
					return false;
				}

				if (temp > 57 && temp < 48) {
					return false;
				}

				i++;
			}
		}

		return true;
	}
}
