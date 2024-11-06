package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import semana_05.ArregloSueldos;

import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Ejemplo extends JFrame {

	private JPanel contentPane;
	private JScrollPane scrollPane;
	private JTextArea txtReporte;
	private JButton btnListar;
	private JButton btnReportar;
	private JButton btnGenerar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ejemplo frame = new Ejemplo();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Ejemplo() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 452, 525);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		{
			scrollPane = new JScrollPane();
			scrollPane.setBounds(10, 86, 416, 389);
			contentPane.add(scrollPane);
			{
				txtReporte = new JTextArea();
				scrollPane.setViewportView(txtReporte);
			}
		}
		
		ArregloSueldos as = new ArregloSueldos();
		
		{
			btnListar = new JButton("Listar");
			btnListar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					txtReporte.setText("");
					for (int i = 0; i < as.tamanio(); i++) {
						imprimir(" [ "+i+ " ] " + as.obtener(i));
					}
				}
			});
			btnListar.setBounds(10, 36, 89, 23);
			contentPane.add(btnListar);
		}
		
		
		
		
		{
			btnReportar = new JButton("Reportar");
			btnReportar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					imprimir("\n" + "Reporte  :");
					imprimir("Cantidad de sueldos:  " + as.tamanio());
					imprimir("Sueldo promedio:  " + as.sueldoPromedio());
					imprimir("Sueldo mayor:  " + as.sueldoMayor());
					imprimir("Sueldo menor:  " + as.sueldoMenor());
					imprimir("# de empleados cuyo sueldo >= al sueldo promedio:  " + as.cantMayoresSueldoPromedio());
					imprimir("# de empleados cuyo sueldo < al sueldo promedio:  " + as.cantMenoresSueldoPromedio());
					imprimir("posicion del segundo sueldo mayor a 850.0:  " + as.posSegundoSueldoMayorAlMinimo());
					imprimir("posicion del ultimo sueldo menor a 850.0:  " + as.posUltimoSueldoMenorAlMinimo());
				}
			});
			btnReportar.setBounds(178, 36, 89, 23);
			contentPane.add(btnReportar);
		}


		
		
		{
			btnGenerar = new JButton("Generar");
			btnGenerar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					as.generar();
					imprimir("Los sueldo fueron actualizados, presione Listar");
					
				}
			});
			btnGenerar.setBounds(337, 36, 89, 23);
			contentPane.add(btnGenerar);
		}
		
		
	}
	void imprimir(){
		imprimir("");
	}
	
	void imprimir(String s){
		txtReporte.append(s+"\n");}
}
