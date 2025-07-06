package Analizador;

import java.awt.Color;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.StringReader;
import java.nio.file.Files;
import java.util.logging.Level;
import java.util.logging.Logger;
import java_cup.runtime.Symbol;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import Analizador.AST.Nodo;
import Analizador.Optimizador;
import Analizador.GeneradorCodigo;
import Analizador.ErrorDeSintaxisException;

public class CompiladorVista extends javax.swing.JFrame {

    private Script script;
    private Compilador compilador; 

    public CompiladorVista() {
        initComponents();

        this.script = new Script("C:\\Program Files (x86)\\Embarcadero\\Dev-Cpp\\TDM-GCC-64\\bin\\");
            this.compilador = new Compilador();

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        BotonAnalisis = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        Resultado = new javax.swing.JTextArea();
        BotonSintactico = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtAnalizarLex = new javax.swing.JTextArea();
        btnArchivo = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        txtAnalizarSin = new javax.swing.JTextArea();
        Borrar1 = new javax.swing.JButton();
        Borrar2 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jBIntermedio = new javax.swing.JButton();
        jBAssembler = new javax.swing.JButton();
        jBObjeto = new javax.swing.JButton();
        jBEjecutable = new javax.swing.JButton();
        jBEjecutar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        ResultadoCodigoOptimizado = new javax.swing.JTextArea();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        ButtonOptimizacion = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setAlwaysOnTop(true);
        setAutoRequestFocus(false);
        setBackground(new java.awt.Color(102, 102, 102));
        setType(java.awt.Window.Type.POPUP);

        BotonAnalisis.setBackground(new java.awt.Color(0, 0, 0));
        BotonAnalisis.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        BotonAnalisis.setForeground(new java.awt.Color(255, 255, 255));
        BotonAnalisis.setText("Análisis Léxico");
        BotonAnalisis.setIconTextGap(2);
        BotonAnalisis.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonAnalisisActionPerformed(evt);
            }
        });

        Resultado.setBackground(new java.awt.Color(0, 0, 0));
        Resultado.setColumns(20);
        Resultado.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        Resultado.setForeground(new java.awt.Color(255, 255, 255));
        Resultado.setRows(5);
        Resultado.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jScrollPane1.setViewportView(Resultado);

        BotonSintactico.setBackground(new java.awt.Color(0, 0, 0));
        BotonSintactico.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        BotonSintactico.setForeground(new java.awt.Color(255, 255, 255));
        BotonSintactico.setText("Análisis Sintático");
        BotonSintactico.setIconTextGap(2);
        BotonSintactico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonSintacticoActionPerformed(evt);
            }
        });

        txtAnalizarLex.setBackground(new java.awt.Color(0, 0, 0));
        txtAnalizarLex.setColumns(20);
        txtAnalizarLex.setForeground(new java.awt.Color(255, 255, 255));
        txtAnalizarLex.setRows(5);
        txtAnalizarLex.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jScrollPane2.setViewportView(txtAnalizarLex);

        btnArchivo.setBackground(new java.awt.Color(0, 0, 0));
        btnArchivo.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnArchivo.setForeground(new java.awt.Color(255, 255, 255));
        btnArchivo.setText("Abrir Fuente");
        btnArchivo.setIconTextGap(2);
        btnArchivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnArchivoActionPerformed(evt);
            }
        });

        txtAnalizarSin.setBackground(new java.awt.Color(0, 0, 0));
        txtAnalizarSin.setColumns(20);
        txtAnalizarSin.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        txtAnalizarSin.setForeground(new java.awt.Color(255, 255, 255));
        txtAnalizarSin.setRows(5);
        txtAnalizarSin.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jScrollPane3.setViewportView(txtAnalizarSin);

        Borrar1.setBackground(new java.awt.Color(0, 0, 0));
        Borrar1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        Borrar1.setForeground(new java.awt.Color(255, 255, 255));
        Borrar1.setText("Borrar");
        Borrar1.setIconTextGap(2);
        Borrar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Borrar1ActionPerformed(evt);
            }
        });

        Borrar2.setBackground(new java.awt.Color(0, 0, 0));
        Borrar2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        Borrar2.setForeground(new java.awt.Color(255, 255, 255));
        Borrar2.setText("Borrar");
        Borrar2.setIconTextGap(2);
        Borrar2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Borrar2ActionPerformed(evt);
            }
        });

        jBIntermedio.setBackground(new java.awt.Color(0, 0, 0));
        jBIntermedio.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jBIntermedio.setForeground(new java.awt.Color(255, 255, 255));
        jBIntermedio.setText("Intermedio");
        jBIntermedio.setIconTextGap(2);
        jBIntermedio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBIntermedioActionPerformed(evt);
            }
        });

        jBAssembler.setBackground(new java.awt.Color(0, 0, 0));
        jBAssembler.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jBAssembler.setForeground(new java.awt.Color(255, 255, 255));
        jBAssembler.setText("Assembler");
        jBAssembler.setIconTextGap(2);
        jBAssembler.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBAssemblerActionPerformed(evt);
            }
        });

        jBObjeto.setBackground(new java.awt.Color(0, 0, 0));
        jBObjeto.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jBObjeto.setForeground(new java.awt.Color(255, 255, 255));
        jBObjeto.setText("Objeto");
        jBObjeto.setIconTextGap(2);
        jBObjeto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBObjetoActionPerformed(evt);
            }
        });

        jBEjecutable.setBackground(new java.awt.Color(0, 0, 0));
        jBEjecutable.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jBEjecutable.setForeground(new java.awt.Color(255, 255, 255));
        jBEjecutable.setText("Ejecutable");
        jBEjecutable.setIconTextGap(2);
        jBEjecutable.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBEjecutableActionPerformed(evt);
            }
        });

        jBEjecutar.setBackground(new java.awt.Color(0, 0, 0));
        jBEjecutar.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jBEjecutar.setForeground(new java.awt.Color(255, 255, 255));
        jBEjecutar.setText("Ejecutar");
        jBEjecutar.setIconTextGap(2);
        jBEjecutar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBEjecutarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addComponent(jBIntermedio)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jBAssembler)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jBObjeto)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jBEjecutable)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBEjecutar)
                .addContainerGap(158, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBEjecutable)
                    .addComponent(jBEjecutar)
                    .addComponent(jBObjeto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jBAssembler, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jBIntermedio, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jLabel2.setFont(new java.awt.Font("Sitka Text", 0, 36)); // NOI18N
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/file (1).jpg"))); // NOI18N

        jLabel3.setFont(new java.awt.Font("Sitka Text", 0, 36)); // NOI18N
        jLabel3.setText("Compilador C en JAVA");

        jLabel1.setFont(new java.awt.Font("Serif", 1, 18)); // NOI18N
        jLabel1.setText("Analizador Sintáctico");

        jLabel4.setFont(new java.awt.Font("Serif", 1, 18)); // NOI18N
        jLabel4.setText("Codigo C");

        jLabel5.setFont(new java.awt.Font("Serif", 1, 18)); // NOI18N
        jLabel5.setText("Analizador Lexico");

        ResultadoCodigoOptimizado.setBackground(new java.awt.Color(0, 0, 0));
        ResultadoCodigoOptimizado.setColumns(20);
        ResultadoCodigoOptimizado.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        ResultadoCodigoOptimizado.setForeground(new java.awt.Color(255, 255, 255));
        ResultadoCodigoOptimizado.setRows(5);
        ResultadoCodigoOptimizado.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jScrollPane4.setViewportView(ResultadoCodigoOptimizado);

        jLabel6.setFont(new java.awt.Font("Serif", 1, 18)); // NOI18N
        jLabel6.setText("Codigo C");

        jLabel7.setFont(new java.awt.Font("Serif", 1, 18)); // NOI18N
        jLabel7.setText("Codigo C optimizado");

        ButtonOptimizacion.setBackground(new java.awt.Color(0, 0, 0));
        ButtonOptimizacion.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        ButtonOptimizacion.setForeground(new java.awt.Color(255, 255, 255));
        ButtonOptimizacion.setText("Optimizar");
        ButtonOptimizacion.setIconTextGap(2);
        ButtonOptimizacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonOptimizacionActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(412, Short.MAX_VALUE)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(310, 310, 310))
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 594, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel2))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addComponent(jLabel5)
                                        .addGap(18, 18, 18)
                                        .addComponent(BotonAnalisis)
                                        .addGap(18, 18, 18)
                                        .addComponent(Borrar1, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addComponent(jLabel4)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addGap(497, 497, 497)
                                                .addComponent(jLabel6))
                                            .addGroup(layout.createSequentialGroup()
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(btnArchivo)
                                                .addGap(496, 496, 496)
                                                .addComponent(jLabel7)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(ButtonOptimizacion)))))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addGap(20, 20, 20))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(18, 18, 18)
                                .addComponent(BotonSintactico)
                                .addGap(18, 18, 18)
                                .addComponent(Borrar2)
                                .addContainerGap())
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 661, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(20, 20, 20))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jScrollPane4)
                                .addContainerGap())))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(18, 18, 18)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(1, 1, 1)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 29, Short.MAX_VALUE)
                                    .addComponent(btnArchivo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(ButtonOptimizacion, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(10, 10, 10)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(Borrar2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(BotonSintactico))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(Borrar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(BotonAnalisis, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(10, 10, 10)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void analizarLexico() throws IOException {
        int cont = 1;

        String expr = (String) Resultado.getText();
        Lexico lexicos = new Lexico(new StringReader(expr));
        String resultado = "NO. LINEA \t\tSIMBOLO\nLINEA " + cont + "\n";
        while (true) {
            Tokens token = lexicos.yylex();
            if (token == null) {
                txtAnalizarLex.setText(resultado);
                return;
            }
            switch (token) {
                case Linea:
                    cont++;
                    resultado += "LINEA " + cont + "\n";
                    break;
                case STRING_LITERAL:
                    resultado += "  <Cadena>\t\t" + lexicos.lexemas + "\n";
                    break;
                case Comillas:
                    resultado += "  <Comillas>\t\t" + lexicos.lexemas + "\n";
                    break;
                case Comilla_simple:
                    resultado += "  <Comilla simple>\t" + lexicos.lexemas + "\n";
                    break;
                case _String:
                    resultado += "  <Tipo de dato String>\t" + lexicos.lexemas + "\n";
                    break;
                case If:
                    resultado += "  <Reservada if>\t" + lexicos.lexemas + "\n";
                    break;
                case Int:
                    resultado += "  <Tipo de dato int>\t" + lexicos.lexemas + "\n";
                    break;
                case Double:
                    resultado += "  <Tipo de dato double>\t" + lexicos.lexemas + "\n";
                    break;
                case Float:
                    resultado += "  <Tipo de dato float>\t" + lexicos.lexemas + "\n";
                    break;
                case Bool:
                    resultado += "  <Tipo de dato bool>\t" + lexicos.lexemas + "\n";
                    break;
                case Byte:
                    resultado += "  <Tipo de dato byte>\t" + lexicos.lexemas + "\n";
                    break;
                case Long:
                    resultado += "  <Tipo de dato long>\t" + lexicos.lexemas + "\n";
                    break;
                case Scanf:
                    resultado += "  <Reservado Scanf>\t" + lexicos.lexemas + "\n";
                    break;
                case Printf:
                    resultado += "  <Reservado Printf>\t" + lexicos.lexemas + "\n";
                    break;
                case Short:
                    resultado += "  <Tipo de dato short>\t" + lexicos.lexemas + "\n";
                    break;
                case Char:
                    resultado += "  <Tipo de dato char>\t" + lexicos.lexemas + "\n";
                    break;
                case Incremento:
                    resultado += "  <Incremento>\t\t" + lexicos.lexemas + "\n";
                    break;
                case Decremento:
                    resultado += "  <Decremento>\t\t" + lexicos.lexemas + "\n";
                    break;
                case Else:
                    resultado += "  <Reservada else>\t" + lexicos.lexemas + "\n";
                    break;
                case Endl:
                    resultado += "  <Salto de linea>\t" + lexicos.lexemas + "\n";
                    break;
                case Return:
                    resultado += "  <Reservada return>\t" + lexicos.lexemas + "\n";
                    break;
                case Void:
                    resultado += "  <Reservada switch>\t" + lexicos.lexemas + "\n";
                    break;
                case Typedef:
                    resultado += "  <Reservada switch>\t" + lexicos.lexemas + "\n";
                    break;
                case Switch:
                    resultado += "  <Reservada switch>\t" + lexicos.lexemas + "\n";
                    break;
                case Do:
                    resultado += "  <Reservada do>\t" + lexicos.lexemas + "\n";
                    break;
                case For:
                    resultado += "  <Reservada for>\t" + lexicos.lexemas + "\n";
                    break;
                case Igual:
                    resultado += "  <Operador igual>\t" + lexicos.lexemas + "\n";
                    break;
                case O_logico:
                    resultado += "  <Operador o logico>\t" + lexicos.lexemas + "\n";
                    break;
                case BitOr:
                    resultado += "  <Operador bitor>\t" + lexicos.lexemas + "\n";
                    break;
                case Y_logico:
                    resultado += "  <Operador y logico>\t" + lexicos.lexemas + "\n";
                    break;
                case BitAnd:
                    resultado += "  <Operador bitand>\t" + lexicos.lexemas + "\n";
                    break;

                case Suma:
                    resultado += "  <Operador suma>\t" + lexicos.lexemas + "\n";
                    break;
                case Resta:
                    resultado += "  <Operador resta>\t" + lexicos.lexemas + "\n";
                    break;
                case Multiplicacion:
                    resultado += "  <Operador multiplicacion>\t" + lexicos.lexemas + "\n";
                    break;
                case Division:
                    resultado += "  <Operador division>\t" + lexicos.lexemas + "\n";
                    break;
                case ModuloIgual:
                    resultado += "  <Operador modulo igual>\t" + lexicos.lexemas + "\n";
                    break;
                case Modulo:
                    resultado += "  <Operador modulo>\t" + lexicos.lexemas + "\n";
                    break;
                case Diferente:
                    resultado += "  <Comparador diferente>\t" + lexicos.lexemas + "\n";
                    break;
                case Negador:
                    resultado += "  <Operador de negacion>\t" + lexicos.lexemas + "\n";
                    break;
                case DobleMayor:
                    resultado += "  <Doble mayor>\t" + lexicos.lexemas + "\n";
                    break;
                case DobleMenor:
                    resultado += "  <Doble menor>\t" + lexicos.lexemas + "\n";
                    break;
                case MayorQue:
                    resultado += "  <Simbolo Mayor que>\t" + lexicos.lexemas + "\n";
                    break;
                case MenorQue:
                    resultado += "  <Simbolo Menor que>\t" + lexicos.lexemas + "\n";
                    break;
                case MayorIgual:
                    resultado += "  <Mayor igual>\t\t" + lexicos.lexemas + "\n";
                    break;
                case MenorIgual:
                    resultado += "  <Menor igual>\t\t" + lexicos.lexemas + "\n";
                    break;
                case MasIgual:
                    resultado += "  <Mas igual>\t\t" + lexicos.lexemas + "\n";
                    break;
                case MenosIgual:
                    resultado += "  <Menos igual>\t\t" + lexicos.lexemas + "\n";
                    break;
                case MultiplicacionIgual:
                    resultado += "  <Multiplica igual>\t" + lexicos.lexemas + "\n";
                    break;
                case DivisionIgual:
                    resultado += "  <Division igual>\t" + lexicos.lexemas + "\n";
                    break;
                case Parent_a:
                    resultado += "  <Parentesis de apertura>\t" + lexicos.lexemas + "\n";
                    break;
                case Parent_c:
                    resultado += "  <Parentesis de cierre>\t" + lexicos.lexemas + "\n";
                    break;
                case Llave_a:
                    resultado += "  <Llave de apertura>\t" + lexicos.lexemas + "\n";
                    break;
                case Llave_c:
                    resultado += "  <Llave de cierre>\t" + lexicos.lexemas + "\n";
                    break;
                case Corchete_a:
                    resultado += "  <Corchete de apertura>\t" + lexicos.lexemas + "\n";
                    break;
                case Corchete_c:
                    resultado += "  <Corchete de cierre>\t" + lexicos.lexemas + "\n";
                    break;
                case Main:
                    resultado += "  <Reservada main>\t" + lexicos.lexemas + "\n";
                    break;
                case While:
                    resultado += "  <Reservada while>\t" + lexicos.lexemas + "\n";
                    break;
                case Cin:
                    resultado += "  <Entrada por consola>\t" + lexicos.lexemas + "\n";
                    break;
                case Cout:
                    resultado += "  <Salida por consola>\t" + lexicos.lexemas + "\n";
                    break;
                case P_coma:
                    resultado += "  <Punto y coma>\t" + lexicos.lexemas + "\n";
                    break;
                case Punto:
                    resultado += "  <Punto>\t\t" + lexicos.lexemas + "\n";
                    break;
                case Coma:
                    resultado += "  <Coma>\t\t" + lexicos.lexemas + "\n";
                    break;
                case DosPuntos:
                    resultado += "  <Dos puntos>\t\t" + lexicos.lexemas + "\n";
                    break;
                case Include:
                    resultado += "  <Reservado include>\t" + lexicos.lexemas + "\n";
                    break;
                case Std:
                    resultado += "  <Reservado std>\t" + lexicos.lexemas + "\n";
                    break;
                case Namespace:
                    resultado += "  <Reservado namespace>\t" + lexicos.lexemas + "\n";
                    break;
                case Case:
                    resultado += "  <Reservado case>\t" + lexicos.lexemas + "\n";
                    break;
                case Continue:
                    resultado += "  <Reservado continue>\t" + lexicos.lexemas + "\n";
                    break;
                case Break:
                    resultado += "  <Reservado break>\t" + lexicos.lexemas + "\n";
                    break;
                case Iostream:
                    resultado += "  <Reservado iostream>\t" + lexicos.lexemas + "\n";
                    break;
                case Using:
                    resultado += "  <Reservado using>\t" + lexicos.lexemas + "\n";
                    break;
                case Const:
                    resultado += "  <Reservado using>\t" + lexicos.lexemas + "\n";
                    break;
                case Default:
                    resultado += "  <Reservado default>\t" + lexicos.lexemas + "\n";
                    break;
                case Define:
                    resultado += "  <Reservado define>\t" + lexicos.lexemas + "\n";
                    break;
                case Unsigned:
                    resultado += "  <Reservado unsigned>\t" + lexicos.lexemas + "\n";
                    break;
                case Register:
                    resultado += "  <Reservado register>\t" + lexicos.lexemas + "\n";
                    break;
                case Struct:
                    resultado += "  <Reservado struct>\t" + lexicos.lexemas + "\n";
                    break;
                case Numeral:
                    resultado += "  <Reservado numeral>\t" + lexicos.lexemas + "\n";
                    break;
                case Identificador:
                    resultado += "  <Identificador>\t\t" + lexicos.lexemas + "\n";
                    break;
                case Numero:
                    resultado += "  <Numero>\t\t" + lexicos.lexemas + "\n";
                    break;
                case ERROR:
                    resultado += "  <Simbolo no definido>\n";
                    break;
                default:
                    resultado += "  < " + lexicos.lexemas + " >\n";
                    break;
            }
        }

    }

    private void BotonAnalisisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonAnalisisActionPerformed
        try {
            analizarLexico();
        } catch (IOException ex) {
            Logger.getLogger(CompiladorVista.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_BotonAnalisisActionPerformed

    private void Borrar2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Borrar2ActionPerformed
        txtAnalizarSin.setText(null);
    }//GEN-LAST:event_Borrar2ActionPerformed

    private void btnArchivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnArchivoActionPerformed
        JFileChooser directory = new JFileChooser();
        directory.setCurrentDirectory(new File("."));
        directory.setDialogTitle("DIRECTORIO");
        directory.setAcceptAllFileFilterUsed(false);

        if (directory.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
            try {

                File arc = new File(directory.getSelectedFile().getAbsolutePath());
                String ST = new String(Files.readAllBytes(arc.toPath()));
                Resultado.setText(ST);
            } catch (FileNotFoundException ex) {
                //Logger.getLogger(FrmAnalizador.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                //Logger.getLogger(FrmAnalizador.class.getName()).log(Level.SEVERE, null, ex);
            } catch (Exception ex) {
                //Logger.getLogger(FrmAnalizador.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            script.setPath(null);
        }


    }//GEN-LAST:event_btnArchivoActionPerformed

    private void BotonSintacticoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonSintacticoActionPerformed
        String ST = Resultado.getText();
        Sintaxis s = new Sintaxis(new Analizador.LexicoCup(new StringReader(ST)));

        try {
            s.parse();
            txtAnalizarSin.setText("Analisis realizado correctamente");
            txtAnalizarSin.setForeground(new Color(25, 111, 61));
        } catch (Exception ex) {
            Symbol sym = s.getS();
            txtAnalizarSin.setText("Error de sintaxis. Linea: " + (sym.right + 1) + " Columna: " + (sym.left + 1) + ", Texto: \"" + sym.value + "\"");
            txtAnalizarSin.setForeground(Color.red);
        }
    }//GEN-LAST:event_BotonSintacticoActionPerformed

    private void Borrar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Borrar1ActionPerformed
        txtAnalizarLex.setText(null);
    }//GEN-LAST:event_Borrar1ActionPerformed

    private void jBIntermedioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBIntermedioActionPerformed
String codigoParaCompilar;

    // Primero, obtenemos el texto del panel de código optimizado.
    String codigoOptimizado = ResultadoCodigoOptimizado.getText();

    if (codigoOptimizado != null && !codigoOptimizado.trim().isEmpty()) {
        // Si hay código optimizado, lo usamos para la compilación.
        codigoParaCompilar = codigoOptimizado;
        JOptionPane.showMessageDialog(this, "Usando el código optimizado para la compilación.", "Información", JOptionPane.INFORMATION_MESSAGE);
    } else {
        // Si no hay código optimizado, usamos el original como respaldo.
        codigoParaCompilar = Resultado.getText();
        JOptionPane.showMessageDialog(this, "El panel de optimización está vacío.\nUsando el código original para la compilación.", "Aviso", JOptionPane.WARNING_MESSAGE);
    }

    // Validamos que el código que vamos a usar no esté vacío.
    if (codigoParaCompilar.trim().isEmpty()) {
        JOptionPane.showMessageDialog(this, "No hay código para compilar.", "Error", JOptionPane.ERROR_MESSAGE);
        return; // Detenemos la ejecución si no hay nada que compilar.
    }

    File archivoDestino = new File("src/Archivos/Programa.cpp");

    // El resto del proceso es el mismo, pero usando "codigoParaCompilar".
    try (FileOutputStream out = new FileOutputStream(archivoDestino)) {
        byte[] bytxt = codigoParaCompilar.getBytes();
        out.write(bytxt);
        
        // Ejecutar el script para generar el código intermedio
        boolean exito = script.intermedio();
        if (exito) {
            JOptionPane.showMessageDialog(this, "Código intermedio generado con éxito.", "Información", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(this, "Error al generar el código intermedio.", "Error", JOptionPane.ERROR_MESSAGE);
        }

    } catch (IOException e) {
        // Manejar el error en caso de que no se pueda escribir el archivo
        JOptionPane.showMessageDialog(this, "No se pudo guardar el archivo fuente: " + e.getMessage(), "Error de Archivo", JOptionPane.ERROR_MESSAGE);
    
    }    }//GEN-LAST:event_jBIntermedioActionPerformed

    private void jBAssemblerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBAssemblerActionPerformed
        script.assambler();
    }//GEN-LAST:event_jBAssemblerActionPerformed

    private void jBObjetoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBObjetoActionPerformed
        script.objeto();
    }//GEN-LAST:event_jBObjetoActionPerformed

    private void jBEjecutableActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBEjecutableActionPerformed
        script.ejecutable();
    }//GEN-LAST:event_jBEjecutableActionPerformed

    private void jBEjecutarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBEjecutarActionPerformed
        script.start();
    }//GEN-LAST:event_jBEjecutarActionPerformed

    private void ButtonOptimizacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonOptimizacionActionPerformed
            String codigoOriginal = Resultado.getText();

    if (codigoOriginal.trim().isEmpty()) {
        JOptionPane.showMessageDialog(this, "No hay código para optimizar.", "Aviso", JOptionPane.WARNING_MESSAGE);
        return;
    }

    ResultadoCodigoOptimizado.setText(""); // Limpiar el área de resultado

    try {
        // Llama a nuestra nueva clase para hacer todo el trabajo pesado.
        String codigoOptimizado = this.compilador.optimizar(codigoOriginal);

        // Si todo sale bien, muestra el resultado.
        ResultadoCodigoOptimizado.setText(codigoOptimizado);
        txtAnalizarSin.setText("Código optimizado con éxito.");
        txtAnalizarSin.setForeground(new Color(25, 111, 61));
        JOptionPane.showMessageDialog(this, "El proceso de optimización se completó correctamente.", "Proceso Completado", JOptionPane.INFORMATION_MESSAGE);

    } catch (ErrorDeSintaxisException ex) {
        // Si nuestra excepción personalizada es atrapada, significa que hubo un error de sintaxis.
        Symbol sym = ex.getSymbol();
        String mensajeError = "Error de sintaxis. Linea: " + (sym.right + 1) + " Columna: " + (sym.left + 1) + ", Texto: \"" + sym.value + "\"";
        
        txtAnalizarSin.setText(mensajeError);
        txtAnalizarSin.setForeground(Color.red);
        JOptionPane.showMessageDialog(this, mensajeError, "Error de Sintaxis", JOptionPane.ERROR_MESSAGE);

    } catch (Exception ex) {
        // Atrapa cualquier otro error inesperado.
        txtAnalizarSin.setText("Ocurrió un error inesperado durante la compilación.");
        txtAnalizarSin.setForeground(Color.red);
        JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage(), "Error Inesperado", JOptionPane.ERROR_MESSAGE);
        ex.printStackTrace(); // Útil para depurar.
    }
    }//GEN-LAST:event_ButtonOptimizacionActionPerformed
    private boolean saveFile(File file, String doc) {
        String message = null;
        try {
            FileOutputStream out = new FileOutputStream(file);
            byte[] bytxt = doc.getBytes();
            out.write(bytxt);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public static void main(String args[]) throws Exception {

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(CompiladorVista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CompiladorVista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CompiladorVista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CompiladorVista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CompiladorVista().setVisible(true);
            }
        });
    }
  
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Borrar1;
    private javax.swing.JButton Borrar2;
    private javax.swing.JButton BotonAnalisis;
    private javax.swing.JButton BotonSintactico;
    private javax.swing.JButton ButtonOptimizacion;
    private javax.swing.JTextArea Resultado;
    private javax.swing.JTextArea ResultadoCodigoOptimizado;
    private javax.swing.JButton btnArchivo;
    private javax.swing.JButton jBAssembler;
    private javax.swing.JButton jBEjecutable;
    private javax.swing.JButton jBEjecutar;
    private javax.swing.JButton jBIntermedio;
    private javax.swing.JButton jBObjeto;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTextArea txtAnalizarLex;
    private javax.swing.JTextArea txtAnalizarSin;
    // End of variables declaration//GEN-END:variables
}
