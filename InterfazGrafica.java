import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

/**
 * Codificador de mensajes mediante codificación por Huffman y aritmética
 * Teoría de la Información y Códigos - 2º Ingeniería Informática
 * Autores: Jose Alberto Benítez Andrades y Juan Antonio Valbuena López
 * DNIs: 71454586A - 71
 * Fecha: 26/04/2008 
 */

/** Clase principal en la que se crea la ventana principal del programa con los respectivos
 * contenedores
 */
public class InterfazGrafica extends JFrame 
{
	public static void main(String[] args)
    throws IOException
    {		
	// La función principal simplemente crea el objeto VentanaGrande que es el programa en sí.
    InterfazGrafica ventanaGrande = new InterfazGrafica();
    }
	/* Este es el constructor de la clase */
	public InterfazGrafica()
	{
		super("Codificador JABA-JAVL 1.4");
			/* Aquí creamos el panel principal que contiene todo, para luego insertarlo en el frame 
			 * principal.
			 */
			PanelPpal panelCompleto = new PanelPpal();
			JScrollPane panelSPrincipal = new JScrollPane(panelCompleto,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
			add(panelSPrincipal);

			setVisible(true);

			//Asigno un tamaño por defecto para el frame.
			setSize(800,850);

			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	class PanelPpal extends JPanel implements ActionListener
	{
		

		/* Cadena en la que almacenamos el mensaje en Huffman con F1 */
		public String mensajeHuffman = "";
		
		/* Cadena en la que almacenamos el mensaje en Huffman con F2 */
		public String mensajeHuffman2 = "";
		
		/* Cadena en la que almacenamos el mensaje en Ascii */
		public String mensajeAscii = "";
		/** Texto Aceptar para el boton Codificar */
		protected static final String CODIFICAR = "Codificar";
		
		/** Texto que muestra labelMensaje */
	    protected static final String stringMensaje	= "Mensaje a codificar";
	    
		/** Texto que muestra labelAscii */
	    protected static final String stringAscii	= "Ascii";
	    
		/** Texto que muestra labelHuffman1 */
	    protected static final String stringHuffman1	= "Mensaje en Huffman con F1";
	    
		/** Texto que muestra labelHuffman2 */
	    protected static final String stringHuffman2	= "Mensaje en Huffman con F2";
	    
		/** Texto que muestra labelAritmetica */
	    protected static final String stringAritmetica	= "Aritmetica con F1";
	    
		/** Texto que muestra labelFuente1 */
	    protected static final String stringFuente	= "Fuente1 y Fuente2";
	    
		/** Texto que muestra labelFuente2 */
	    protected static final String stringHuffman	= "Huffman con F1 y Huffman con F2";
	    
		/** Campo de texto para introducir el Mensaje */
		JTextArea textMensaje;
		
		/** Campo de texto para introducir el Ascii */
		JTextArea textAscii;
		
		/** Campo de texto para introducir el Huffman1 */
		JTextArea textHuffman1;
		
		/** Campo de texto para introducir el Huffman2 */
		JTextArea textHuffman2;
		
		/** Campo de texto para introducir el Aritmetica */
		JTextArea textAritmetica;
		
		/** Campo de texto para introducir la longitud Ascii */
		JTextField longitudAscii;
		
		/** Campo de texto para introducir la longitud en Huffman con F1 */
		JTextField longitudHuffman1;
		
		/** Campo de texto para introducir la longitud en Huffman con F2 */
		JTextField longitudHuffman2;
		
		/** Campo de texto para introducir la longitud en Aritmetica */
		JTextField longitudAritmetica;
		
		/** Campo de texto para introducir el ratio de la codificacion Ascii */
		JTextField ratioAscii;
		
		/** Campo de texto para introducir el ratio de la codificacion Huffman con F1 */
		JTextField ratioHuffman1;
		
		/** Campo de texto para introducir el ratio de la codificacion Huffman con F2 */
		JTextField ratioHuffman2;
		
		/** Campo de texto para introducir el ratio de la codificacion Aritmetica */
		JTextField ratioAritmetica;
		
		/** Etiquetas correspondientes a los TextFields anteriores */
		JLabel labelLongAscii;
		JLabel labelLongHuffman1;
		JLabel labelLongHuffman2;
		JLabel labelLongAritmetica;
		JLabel labelRatioAscii;
		JLabel labelRatioHuffman1;
		JLabel labelRatioHuffman2;
		JLabel labelRatioAritmetica;
		
		/** Etiqueta Titulacion */
		JLabel labelMensaje;
		
		/** Panel de control que contiene los botones */
		JComponent buttonPanel;
		
		/** Panel principal donde irÃ¡ el cuadro de bÃºsqueda y la tabla */
		JPanel panelPrincipal;
		JScrollPane panelSPrincipal;
		
		/** Panel en el que estará el mensaje a codificar */
		JPanel mensajePanel;
		
		/** Panel en el que estará el mensaje en Ascii */
		JPanel asciiPanel;
		
		/** Panel en el que estará el mensaje en Huffman con F1 */
		JPanel huffman1Panel;
		
		/** Panel en el que estará el mensaje en Huffman con F2 */
		JPanel huffman2Panel;
		
		/** Panel en el que estará la fuente 1 */
		JPanel fuentePanel;
		
		/** Panel en el que estará la fuente 2 */
		JPanel huffmanPanel;
		
		/** Panel en el que estará el mensaje en codificacion Aritmética */
		JPanel aritmeticaPanel;
		
		/** Panel en el que estará el mensaje en codificacion Aritmética */
		JPanel aritmeticaTablaPanel;
		
		JPanel statsPanel;
		
		/** Tabla que almacenará F1 y su modelo*/
		JTable tblFuente1;
		DefaultTableModel modeloF1;
		
		/** Tabla que almacenará F2 y su modelo*/
		JTable tblFuente2;
		DefaultTableModel modeloF2;
		
		/** Tabla que almacenaráHF1 y su modelo*/
		JTable tblHF1;
		DefaultTableModel modeloHF1;
		
		/** Tabla que almacenará HF2 y su modelo*/
		JTable tblHF2;
		DefaultTableModel modeloHF2;
		
		/** Tabla que almacenará la tabla aritmética y su modelo*/
		JTable tblAritmetica;
		DefaultTableModel modeloArit;

		public PanelPpal()
		{
			/* Todo lo relacionado con el mensaje y su panel */
			mensajePanel = new JPanel();
			mensajePanel.setBorder(
					BorderFactory.createCompoundBorder(
                                BorderFactory.createTitledBorder(stringMensaje),
                                BorderFactory.createEmptyBorder(5,5,5,5)));  
			/* Campo de texto de mensaje junto con su panel con scroll para el
			 * textArea, y el panel principal donde se insertará el panel
			 * con scroll.
			 */
			textMensaje = new JTextArea(5,30);
			textMensaje.setLineWrap(true);
			JScrollPane mensajeScrollPane = new JScrollPane(textMensaje);
			mensajeScrollPane.setVerticalScrollBarPolicy(
					JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
			mensajeScrollPane.setPreferredSize(new Dimension(350, 110));
	        mensajePanel.add(mensajeScrollPane);
	        
			/* Campo de texto de ascii junto con su panel con scroll para el
			 * textArea, y el panel principal donde se insertará el panel
			 * con scroll.
			 */
	        
			asciiPanel = new JPanel();
			asciiPanel.setBorder(
					BorderFactory.createCompoundBorder(
                                BorderFactory.createTitledBorder(stringAscii),
                                BorderFactory.createEmptyBorder(5,5,5,5)));  
			textAscii = new JTextArea(5,30);
			textAscii.setLineWrap(true);
			textAscii.setEditable(false);
			JScrollPane asciiScrollPane = new JScrollPane(textAscii);
			asciiScrollPane.setVerticalScrollBarPolicy(
					JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
			asciiScrollPane.setPreferredSize(new Dimension(350, 110));
			asciiPanel.add(asciiScrollPane);
	        
			
			
			/* Campo de texto de Huffman junto con su panel con scroll para el
			 * textArea, y el panel principal donde se insertará el panel
			 * con scroll.
			 */
			huffman1Panel = new JPanel();
			huffman1Panel.setBorder(
					BorderFactory.createCompoundBorder(
                                BorderFactory.createTitledBorder(stringHuffman1),
                                BorderFactory.createEmptyBorder(5,5,5,5)));  
			//Campo de texto de Mensaje
			textHuffman1 = new JTextArea(5,30);
			textHuffman1.setEditable(false);
			textHuffman1.setLineWrap(true);
			JScrollPane huffman1ScrollPane = new JScrollPane(textHuffman1);
			huffman1ScrollPane.setVerticalScrollBarPolicy(
					JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
			huffman1ScrollPane.setPreferredSize(new Dimension(350, 110));
			huffman1Panel.add(huffman1ScrollPane);
	        
			

			/* Campo de texto de Huffman con F2 junto con su panel con scroll para el
			 * textArea, y el panel principal donde se insertará el panel
			 * con scroll.
			 */			
			huffman2Panel = new JPanel();
			huffman2Panel.setBorder(
					BorderFactory.createCompoundBorder(
                                BorderFactory.createTitledBorder(stringHuffman2),
                                BorderFactory.createEmptyBorder(5,5,5,5)));  
			textHuffman2 = new JTextArea(5,30);
			textHuffman2.setEditable(false);
			textHuffman2.setLineWrap(true);
			JScrollPane huffman2ScrollPane = new JScrollPane(textHuffman2);
			huffman2ScrollPane.setVerticalScrollBarPolicy(
					JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
			huffman2ScrollPane.setPreferredSize(new Dimension(350, 110));
			huffman2Panel.add(huffman2ScrollPane);
	        
			
			/* Campo de texto de Aritmética junto con su panel con scroll para el
			 * textArea, y el panel principal donde se insertará el panel
			 * con scroll.
			 */
			aritmeticaPanel = new JPanel();
			aritmeticaPanel.setBorder(
					BorderFactory.createCompoundBorder(
                                BorderFactory.createTitledBorder(stringAritmetica),
                                BorderFactory.createEmptyBorder(5,5,5,5)));  
			textAritmetica = new JTextArea(5,30);
			textAritmetica.setLineWrap(true);
			textAritmetica.setEditable(false);
			JScrollPane aritmeticaScrollPane = new JScrollPane(textAritmetica);
			aritmeticaScrollPane.setVerticalScrollBarPolicy(
					JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
			aritmeticaScrollPane.setPreferredSize(new Dimension(350, 110));
			aritmeticaPanel.add(aritmeticaScrollPane);
			
			
			fuentePanel = new JPanel(new GridLayout(1,2));
			fuentePanel.setBorder(
					BorderFactory.createCompoundBorder(
                                BorderFactory.createTitledBorder(stringFuente),
                                BorderFactory.createEmptyBorder(5,5,5,5))); 
			modeloF1 = new DefaultTableModel();
			tblFuente1 = new JTable(modeloF1);
			tblFuente1.setGridColor(Color.BLACK);
			JScrollPane scrollFuente1 = new JScrollPane(tblFuente1);
			scrollFuente1.setPreferredSize(new Dimension (10, 10));
			//tblFuente1.setPreferredSize(new Dimension (10, 160));
			modeloF1.addColumn("C");
			modeloF1.addColumn("P");
			
			modeloF2 = new DefaultTableModel();
			tblFuente2 = new JTable(modeloF2);
			tblFuente2.setGridColor(Color.BLACK);
			JScrollPane scrollFuente2 = new JScrollPane(tblFuente2);
			scrollFuente2.setPreferredSize(new Dimension (10, 10));
			//tblFuente2.setPreferredSize(new Dimension (10, 160));
			modeloF2.addColumn("C");
			modeloF2.addColumn("P");
			
			fuentePanel.add(scrollFuente1);
			fuentePanel.add(scrollFuente2);
			
			
			/* Aquí se crea el panel donde estará la tabla del código
			 * de Huffman con Fuente1  y Fuente2.
			 */
			huffmanPanel = new JPanel(new GridLayout(1,2));
			huffmanPanel.setBorder(
					BorderFactory.createCompoundBorder(
                                BorderFactory.createTitledBorder(stringHuffman),
                                BorderFactory.createEmptyBorder(5,5,5,5)));  
			modeloHF1 = new DefaultTableModel();
			tblHF1 = new JTable(modeloHF1);
			tblHF1.setGridColor(Color.BLACK);
			JScrollPane scrollHF1 = new JScrollPane(tblHF1);
			scrollHF1.setPreferredSize(new Dimension (10, 10));
			modeloHF1.addColumn("C");
			modeloHF1.addColumn("F1");
			
			modeloHF2 = new DefaultTableModel();
			tblHF2 = new JTable(modeloHF2);
			tblHF2.setGridColor(Color.BLACK);
			JScrollPane scrollHF2 = new JScrollPane(tblHF2);
			scrollHF2.setPreferredSize(new Dimension (10, 10));
			modeloHF2.addColumn("C");
			modeloHF2.addColumn("F2");
			
			huffmanPanel.add(scrollHF1);
			huffmanPanel.add(scrollHF2);
			
			/* Aquí se crea el panel donde estará la tabla del código
			 * de codificación Aritmética con Fuente1  y Fuente2.
			 */
			aritmeticaTablaPanel = new JPanel(new GridLayout(1,2));
			aritmeticaTablaPanel.setBorder(
					BorderFactory.createCompoundBorder(
                                BorderFactory.createTitledBorder("Aritmética"),
                                BorderFactory.createEmptyBorder(5,5,5,5)));  
			modeloArit = new DefaultTableModel();
			tblAritmetica = new JTable(modeloArit);
			tblAritmetica.setGridColor(Color.BLACK);
			JScrollPane scrollArit = new JScrollPane(tblAritmetica);
			scrollArit.setPreferredSize(new Dimension (10, 10));
			modeloArit.addColumn("C");
			modeloArit.addColumn("Intervalo");
			
			aritmeticaTablaPanel.add(scrollArit);
			
			/* Y este panel es el último donde se mostrarán las longitudes y los ratios
			 * de las codificaciones diferentes que hay.Creo individualmente los JTextField
			 * y las etiquetas correspondientes para que se vea todo correctamente.
			 */
			statsPanel = new JPanel(new GridLayout(2,2));

			JButton botonCodificar = new JButton(CODIFICAR);
			botonCodificar.setActionCommand(CODIFICAR);
			botonCodificar.addActionListener(this);
			JPanel buttonPanel = new JPanel();
			buttonPanel.add(botonCodificar);
			statsPanel.setBorder(
					BorderFactory.createCompoundBorder(
                            BorderFactory.createTitledBorder("Longitudes y Ratios"),
                            BorderFactory.createEmptyBorder(5,5,5,5))); 
			longitudAscii = new JTextField();
			longitudAscii.setEditable(false);
			labelLongAscii = new JLabel("Long Ascii:");
			labelLongAscii.setLabelFor(longitudAscii);
			
			longitudHuffman1 = new JTextField();
			longitudHuffman1.setEditable(false);
			labelLongHuffman1 = new JLabel("Long HF1:");
			labelLongHuffman1.setLabelFor(longitudHuffman1);
			
			longitudHuffman2 = new JTextField();
			longitudHuffman2.setEditable(false);
			labelLongHuffman2 = new JLabel("Long HF2:");
			labelLongHuffman2.setLabelFor(longitudHuffman2);
			
			longitudAritmetica = new JTextField();
			longitudAritmetica.setEditable(false);
			labelLongAritmetica = new JLabel("Long Aritmetica:");
			labelLongAritmetica.setLabelFor(longitudAritmetica);
			
			ratioAscii = new JTextField();
			ratioAscii.setEditable(false);
			labelRatioAscii = new JLabel("Ratio Ascii:");
			labelRatioAscii.setLabelFor(labelRatioAscii);
			
			ratioHuffman1 = new JTextField();
			ratioHuffman1.setEditable(false);
			labelRatioHuffman1 = new JLabel("Ratio HF1:");
			labelRatioHuffman1.setLabelFor(labelRatioHuffman1);
			
			ratioHuffman2 = new JTextField();
			ratioHuffman2.setEditable(false);
			labelRatioHuffman2 = new JLabel("Ratio HF2:");
			labelRatioHuffman2.setLabelFor(labelRatioHuffman2);
			
			ratioAritmetica = new JTextField();
			ratioAritmetica.setEditable(false);
			labelRatioAritmetica = new JLabel("Ratio Aritmetica:");
			labelRatioAritmetica.setLabelFor(labelRatioAritmetica);
			
			JPanel textControlsPane1 = new JPanel();
	       	GridBagLayout gridbag = new GridBagLayout();
		    GridBagConstraints c = new GridBagConstraints();
			textControlsPane1.setLayout(gridbag);
			
			JLabel[] labels = {labelLongAscii, labelLongHuffman1, labelLongHuffman2, labelLongAritmetica};
		    JTextField[] textFields = {longitudAscii, longitudHuffman1, longitudHuffman2, longitudAritmetica};
			addLabelTextRows(labels, textFields, gridbag, textControlsPane1);
			
			JPanel textControlsPane2 = new JPanel();
			textControlsPane2.setLayout(gridbag);
			
			JLabel[] labels2 = {labelRatioAscii, labelRatioHuffman1, labelRatioHuffman2, labelRatioAritmetica};
			JTextField[] textFields2 = {ratioAscii, ratioHuffman1, ratioHuffman2, ratioAritmetica};
			addLabelTextRows(labels2, textFields2, gridbag, textControlsPane2);
			
			statsPanel.add(textControlsPane1);
			statsPanel.add(textControlsPane2);
			statsPanel.add(buttonPanel);
			
			panelPrincipal = new JPanel(new GridLayout(5,4));
			//GridLayout capaSc = new GridLayout(4,4);
			//panelPrincipal.setLayout(capaSc);
			panelPrincipal.add(mensajePanel);
			panelPrincipal.add(huffman1Panel);
			panelPrincipal.add(fuentePanel);
			panelPrincipal.add(huffman2Panel);
			panelPrincipal.add(huffmanPanel);
			panelPrincipal.add(aritmeticaPanel);
			panelPrincipal.add(aritmeticaTablaPanel);
			panelPrincipal.add(asciiPanel);
			panelPrincipal.add(statsPanel);
	

			//add(panelSPrincipal);
	        add(panelPrincipal);

	        
	        
		}
		
		/** Este procedimiento crea los 2 minipaneles en los que estarán
		 * las longitudes y los ratios. Recibe las etiquetas, los TextFields
		 * la capa que utilizará el panel y el contenedor.
		 */
		private void addLabelTextRows(JLabel[] labels,
			      JTextField[] textFields,
			      GridBagLayout gridbag,
			      Container container) 
		{
		
			GridBagConstraints c = new GridBagConstraints();
			c.anchor = GridBagConstraints.EAST;
			int numLabels = labels.length;
			
			for (int i = 0; i < numLabels; i++) {
				c.gridwidth = GridBagConstraints.RELATIVE; 
				c.fill = GridBagConstraints.NONE;      
				c.weightx = 0.0;                       
				container.add(labels[i], c);
			
				c.gridwidth = GridBagConstraints.REMAINDER;    
				c.fill = GridBagConstraints.HORIZONTAL;
				c.weightx = 1.0;
				container.add(textFields[i], c);
			}//fin_del_for
			
		}//fin_addLabelTextRows
		
		/* Este procedimiento es el que se ejecuta al pulsar el botón
		 * de codificar.
		 */
		public void actionPerformed(ActionEvent e) 
		{
			if (CODIFICAR.equals(e.getActionCommand()))
			{	/* Creo los modelos nuevos para las tablas que tengo creadas */
				DefaultTableModel modeloNF1 = new DefaultTableModel();
				DefaultTableModel modeloNF2 = new DefaultTableModel();
				DefaultTableModel modeloNHF1 = new DefaultTableModel();
				DefaultTableModel modeloNHF2 = new DefaultTableModel();
				DefaultTableModel modeloNArit = new DefaultTableModel();
				/* Creo los arrays de cadenas para la codificación de Huffman
				 * y los arrays de enteros que almacenarán las probabilidades
				 * de los caracteres, es decir las fuentes.
				 * Y también L y H que son los intervalos de la codificación
				 * Aritmética.
				 */
				String[] huffMan = new String[256];
				String[][] huffMan2 = new String[256][256];
				int[] fuenteUno = new int[256];
				int[][] fuenteDos = new int[256][256];
				float[] L = new float[256];
				float[] H = new float[256];
				
				Huffman codificadorJABAJAVL = new Huffman();
				/* Cogemos el texto del area de texto del mensaje y lo almaceno
				 * en mensaje.
				 */
				String mensaje = textMensaje.getText();
				StringBuffer fileContents = new StringBuffer(mensaje);
	   			
	           /* Hallo la longitud del mensaje normal */
	           int longitud = fileContents.length();
	           
	           // Calcula el árbol de Huffman con Fuente1.
	           // El fileContents es el mensaje.
	           huffMan = codificadorJABAJAVL.processFile(fileContents.toString(),fuenteUno);
	           
	           mensajeHuffman = codificadorJABAJAVL.crearMensajeHuffman1(fileContents);
	          
	           mensajeAscii = codificadorJABAJAVL.crearMensajeAscii(fileContents);
	           if(longitud%2 == 0)
	           {
		           huffMan2 = codificadorJABAJAVL.processFile2(fuenteDos,fuenteUno);
		           
		           mensajeHuffman2 = codificadorJABAJAVL.crearMensajeHuffman2(fileContents);
	           }
	           else mensajeHuffman2 = "No se puede codificar porque el número de caracteres de la cadena es impar";
			   
	           /* Con estos bucles creo las tablas, con la información que ya tengo
	            * en fuenteUno, fuenteDos, L,H y huffMan1 y huffMan2.
	            */
	           modeloNF1.addColumn("C");
			   modeloNF1.addColumn("P");
			   tblFuente1.setModel(modeloNF1);
			   Object [] fila = new Object[2];
			   for (int i=0;i<255;i++)
			   {  if(fuenteUno[i] > 0)
			   		{
				   	  fila[0] = (char)i; 
			   		  fila[1] = (float)fuenteUno[i]/longitud;
					  modeloNF1.addRow(fila);
					  
			   		}
			   }

			   
			   modeloNF2.addColumn("C");
			   modeloNF2.addColumn("P");
			   tblFuente2.setModel(modeloNF2);
			   Object [] fila2 = new Object[2];
			   for (int i=0;i<255;i++)
			   {  
				   for(int j=0;j<255;j++)
				   {
					   if(fuenteDos[i][j] > 0)
				   		{ 
					   	  fila2[0] = (char)i + "" + (char)j; 
				   		  fila2[1] = (float)fuenteDos[i][j]/(longitud*longitud);
						  modeloNF2.addRow(fila2);
				   		}
				   }
			   }
			   
			   modeloNHF1.addColumn("C");
			   modeloNHF1.addColumn("F1");
			   tblHF1.setModel(modeloNHF1);
			   Object [] fila3 = new Object[2];
			   for (int i=0;i<255;i++)
			   {  
				   if(fuenteUno[i] > 0)
				   	{ 
					   fila3[0] = (char)i; 
				   	   fila3[1] = huffMan[i];
					   modeloNHF1.addRow(fila3);
				   	}
			   }
			   
			   modeloNHF2.addColumn("C");
			   modeloNHF2.addColumn("F2");
			   tblHF2.setModel(modeloNHF2);
			   Object [] fila4 = new Object[2];
			   for (int i=0;i<255;i++)
			   {  
				   for(int j=0;j<255;j++)
				   {	
					   if(fuenteDos[i][j] > 0)
				   		{ 
					   	  fila4[0] = (char)i + "" + (char)j; 
				   		  fila4[1] = huffMan2[i][j];
						  modeloNHF2.addRow(fila4);
				   		}
				   }
			   }
			   
			   
			   
			   modeloNArit.addColumn("C");
			   modeloNArit.addColumn("Intervalo");
			   tblAritmetica.setModel(modeloNArit);
			   Object [] fila5 = new Object[2];
			   int primero = 0;
		   	   int segundo = 0;
			   for (int i=0;i<255;i++)
			   {  
				   if(fuenteUno[i] > 0)
				   	{  
					   primero = segundo;
				   	   segundo = segundo + fuenteUno[i];
				   	   L[i] = (float)primero/longitud;
				   	   H[i] = (float)segundo/longitud;
					   fila5[0] = (char)i; 
				   	   fila5[1] = "[" + L[i] +  " , " + H[i]+ " )";
				   	   System.out.println(i + " " + L[i] + " " + H[i]);
					   modeloNArit.addRow(fila5);
				   	}
			   }
			   
			   // Creo el objeto de codificacion Aritmética para calcular el mensaje.
			   Aritmetica codifAritmetica = new Aritmetica();
			   String mensajeAritmetica = Aritmetica.crearMensajeAritmetico(fileContents, L, H);
	           textAscii.setText(mensajeAscii);
	           textHuffman1.setText(mensajeHuffman);
	           textHuffman2.setText(mensajeHuffman2);
	           textAritmetica.setText(mensajeAritmetica);

	           /* Escribe las longitudes y los ratios en los TextFields correspondientes. */
	           longitudAscii.setText(Integer.toString(mensajeAscii.length()));
	           longitudHuffman1.setText(Integer.toString(mensajeHuffman.length()));
	           longitudHuffman2.setText(Integer.toString(mensajeHuffman2.length()));
	           longitudAritmetica.setText(Integer.toString(mensajeAritmetica.length()));
	           
	           int longAscii = mensajeAscii.length();
	           ratioAscii.setText("100%");
	           ratioHuffman1.setText(Float.toString(((float)mensajeHuffman.length()/(float)longAscii)*100)+"%");
	           ratioHuffman2.setText(Float.toString(((float)mensajeHuffman2.length()/(float)longAscii)*100)+"%");
	           ratioAritmetica.setText(Float.toString(((float)mensajeAritmetica.length()/(float)longAscii)*100)+"%");
	           if(longitud %2 != 0) 
	           {
	        	   					longitudHuffman2.setText("0");
	        	   					ratioHuffman2.setText("0");
	           }
;
			}
			
		}
		
	}


	
	
}
