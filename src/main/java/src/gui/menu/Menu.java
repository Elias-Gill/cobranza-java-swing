/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package src.gui.menu;

import com.formdev.flatlaf.FlatDarkLaf;
import src.gui.comprobante.Comprobante;
import src.gui.formulario.*;
import src.gui.intercambiarPaneles.IntercambiarPaneles;
import src.mediador.Mediador;

/**
 * @author Abeld
 */
public class Menu extends javax.swing.JPanel {

    private Mediador m;
    private IntercambiarPaneles intercambiar = new IntercambiarPaneles();

    /**
     * Creates new form Principal
     */
    public Menu() {
        initComponents();
    }

    public Menu(Mediador m) {
        initComponents();
        this.m = m;
        jtextSaldo.setText(String.valueOf(m.cuentaActiva.saldo));
        jtextCuenta.setText(String.valueOf(m.cuentaActiva.nroCuenta));
        jtextCedula.setText(String.valueOf(m.cuentaActiva.cedula));
        jtextTelefono.setText(m.cuentaActiva.telefono);
        jtextTitular.setText(m.cuentaActiva.nombre + " " + m.cuentaActiva.apellido);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelIzq = new javax.swing.JPanel();
        btnPagarServicios = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        btnInicio = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        btnTransferir = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        btnDepositar = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        btnPagarTarjeta = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        btnSalir = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        panelDer = new javax.swing.JPanel();
        panelInicio = new javax.swing.JPanel();
        lblSaldo = new javax.swing.JLabel();
        lblDatos = new javax.swing.JLabel();
        lblCedula = new javax.swing.JLabel();
        lblCuenta = new javax.swing.JLabel();
        lblTelefono = new javax.swing.JLabel();
        jtextSaldo = new javax.swing.JLabel();
        jtextCuenta = new javax.swing.JLabel();
        jtextCedula = new javax.swing.JLabel();
        jtextTelefono = new javax.swing.JLabel();
        lblGuarani = new javax.swing.JLabel();
        btnRecargar = new javax.swing.JButton();
        lblTitular = new javax.swing.JLabel();
        jtextTitular = new javax.swing.JLabel();

        setMaximumSize(new java.awt.Dimension(769, 500));
        setMinimumSize(new java.awt.Dimension(769, 500));
        setPreferredSize(new java.awt.Dimension(769, 500));

        panelIzq.setBackground(new java.awt.Color(13, 167, 150));
        panelIzq.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        btnPagarServicios.setBackground(new java.awt.Color(102, 102, 102));
        btnPagarServicios.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        btnPagarServicios.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnPagarServicios.setPreferredSize(new java.awt.Dimension(93, 39));
        btnPagarServicios.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnPagarServiciosMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnPagarServiciosMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnPagarServiciosMouseExited(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(204, 204, 204));
        jLabel1.setText("Pagar Servicios Externos");

        jLabel12.setFont(new java.awt.Font("Segoe UI Emoji", 0, 14)); // NOI18N
        jLabel12.setText("🏦");

        javax.swing.GroupLayout btnPagarServiciosLayout = new javax.swing.GroupLayout(btnPagarServicios);
        btnPagarServicios.setLayout(btnPagarServiciosLayout);
        btnPagarServiciosLayout.setHorizontalGroup(
            btnPagarServiciosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnPagarServiciosLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addComponent(jLabel1)
                .addContainerGap(39, Short.MAX_VALUE))
        );
        btnPagarServiciosLayout.setVerticalGroup(
            btnPagarServiciosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnPagarServiciosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(btnPagarServiciosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btnInicio.setBackground(new java.awt.Color(102, 102, 102));
        btnInicio.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        btnInicio.setForeground(new java.awt.Color(153, 255, 255));
        btnInicio.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnInicio.setPreferredSize(new java.awt.Dimension(93, 39));
        btnInicio.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnInicioMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnInicioMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnInicioMouseExited(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(204, 204, 204));
        jLabel8.setText("Inicio");

        jLabel11.setFont(new java.awt.Font("Segoe UI Emoji", 0, 14)); // NOI18N
        jLabel11.setText("👤");

        javax.swing.GroupLayout btnInicioLayout = new javax.swing.GroupLayout(btnInicio);
        btnInicio.setLayout(btnInicioLayout);
        btnInicioLayout.setHorizontalGroup(
            btnInicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnInicioLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel8)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        btnInicioLayout.setVerticalGroup(
            btnInicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btnInicioLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(btnInicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel8)
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        btnTransferir.setBackground(new java.awt.Color(102, 102, 102));
        btnTransferir.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        btnTransferir.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnTransferir.setPreferredSize(new java.awt.Dimension(93, 39));
        btnTransferir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnTransferirMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnTransferirMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnTransferirMouseExited(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(204, 204, 204));
        jLabel3.setText("Transferir");

        jLabel13.setFont(new java.awt.Font("Segoe UI Emoji", 0, 14)); // NOI18N
        jLabel13.setText("💸");

        javax.swing.GroupLayout btnTransferirLayout = new javax.swing.GroupLayout(btnTransferir);
        btnTransferir.setLayout(btnTransferirLayout);
        btnTransferirLayout.setHorizontalGroup(
            btnTransferirLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnTransferirLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(3, 3, 3)
                .addComponent(jLabel3)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        btnTransferirLayout.setVerticalGroup(
            btnTransferirLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnTransferirLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(btnTransferirLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btnDepositar.setBackground(new java.awt.Color(102, 102, 102));
        btnDepositar.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        btnDepositar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnDepositar.setPreferredSize(new java.awt.Dimension(93, 39));
        btnDepositar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnDepositarMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnDepositarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnDepositarMouseExited(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(204, 204, 204));
        jLabel4.setText("Depositar");

        jLabel10.setFont(new java.awt.Font("Segoe UI Emoji", 0, 14)); // NOI18N
        jLabel10.setText("💰");

        javax.swing.GroupLayout btnDepositarLayout = new javax.swing.GroupLayout(btnDepositar);
        btnDepositar.setLayout(btnDepositarLayout);
        btnDepositarLayout.setHorizontalGroup(
            btnDepositarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnDepositarLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        btnDepositarLayout.setVerticalGroup(
            btnDepositarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btnDepositarLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(btnDepositarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        btnPagarTarjeta.setBackground(new java.awt.Color(102, 102, 102));
        btnPagarTarjeta.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        btnPagarTarjeta.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnPagarTarjeta.setPreferredSize(new java.awt.Dimension(93, 39));
        btnPagarTarjeta.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnPagarTarjetaMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnPagarTarjetaMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnPagarTarjetaMouseExited(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(204, 204, 204));
        jLabel5.setText("Pagar Tarjeta");

        jLabel9.setFont(new java.awt.Font("Segoe UI Emoji", 0, 14)); // NOI18N
        jLabel9.setText("💳");

        javax.swing.GroupLayout btnPagarTarjetaLayout = new javax.swing.GroupLayout(btnPagarTarjeta);
        btnPagarTarjeta.setLayout(btnPagarTarjetaLayout);
        btnPagarTarjetaLayout.setHorizontalGroup(
            btnPagarTarjetaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnPagarTarjetaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel5)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        btnPagarTarjetaLayout.setVerticalGroup(
            btnPagarTarjetaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btnPagarTarjetaLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(btnPagarTarjetaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel9))
                .addContainerGap())
        );

        btnSalir.setBackground(new java.awt.Color(102, 102, 102));
        btnSalir.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        btnSalir.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnSalir.setPreferredSize(new java.awt.Dimension(93, 39));
        btnSalir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnSalirMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnSalirMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnSalirMouseExited(evt);
            }
        });

        jLabel14.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(204, 204, 204));
        jLabel14.setText("Salir");

        jLabel15.setFont(new java.awt.Font("Segoe UI Emoji", 0, 14)); // NOI18N
        jLabel15.setText("🚪");

        javax.swing.GroupLayout btnSalirLayout = new javax.swing.GroupLayout(btnSalir);
        btnSalir.setLayout(btnSalirLayout);
        btnSalirLayout.setHorizontalGroup(
            btnSalirLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnSalirLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel14)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        btnSalirLayout.setVerticalGroup(
            btnSalirLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btnSalirLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(btnSalirLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jLabel7.setBackground(new java.awt.Color(0, 0, 0));
        jLabel7.setFont(new java.awt.Font("Segoe UI Emoji", 1, 80)); // NOI18N
        jLabel7.setText("🌄");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(254, 254, 254));
        jLabel6.setText("    Banco Diaz Gill");

        javax.swing.GroupLayout panelIzqLayout = new javax.swing.GroupLayout(panelIzq);
        panelIzq.setLayout(panelIzqLayout);
        panelIzqLayout.setHorizontalGroup(
            panelIzqLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelIzqLayout.createSequentialGroup()
                .addGroup(panelIzqLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelIzqLayout.createSequentialGroup()
                        .addGap(83, 83, 83)
                        .addComponent(jLabel7)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(panelIzqLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(panelIzqLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnPagarServicios, javax.swing.GroupLayout.DEFAULT_SIZE, 289, Short.MAX_VALUE)
                            .addComponent(btnInicio, javax.swing.GroupLayout.DEFAULT_SIZE, 289, Short.MAX_VALUE)
                            .addComponent(btnTransferir, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 289, Short.MAX_VALUE)
                            .addComponent(btnDepositar, javax.swing.GroupLayout.DEFAULT_SIZE, 289, Short.MAX_VALUE)
                            .addComponent(btnPagarTarjeta, javax.swing.GroupLayout.DEFAULT_SIZE, 289, Short.MAX_VALUE)
                            .addComponent(btnSalir, javax.swing.GroupLayout.DEFAULT_SIZE, 289, Short.MAX_VALUE))))
                .addContainerGap())
            .addGroup(panelIzqLayout.createSequentialGroup()
                .addGap(53, 53, 53)
                .addComponent(jLabel6)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelIzqLayout.setVerticalGroup(
            panelIzqLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelIzqLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6)
                .addGap(18, 18, 18)
                .addComponent(btnInicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnPagarServicios, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnTransferir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnDepositar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnPagarTarjeta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        panelDer.setBackground(new java.awt.Color(255, 255, 255));
        panelDer.setForeground(new java.awt.Color(255, 255, 255));

        panelInicio.setBackground(new java.awt.Color(255, 255, 255));
        panelInicio.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED, new java.awt.Color(102, 102, 102), new java.awt.Color(102, 102, 102), new java.awt.Color(102, 102, 102), new java.awt.Color(102, 102, 102)));

        lblSaldo.setBackground(new java.awt.Color(102, 102, 102));
        lblSaldo.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblSaldo.setForeground(new java.awt.Color(102, 102, 102));
        lblSaldo.setText("Saldo Disponible");

        lblDatos.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lblDatos.setForeground(new java.awt.Color(102, 102, 102));
        lblDatos.setText("Datos de la Cuenta ");

        lblCedula.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblCedula.setForeground(new java.awt.Color(102, 102, 102));
        lblCedula.setText("N° de Cédula:");

        lblCuenta.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblCuenta.setForeground(new java.awt.Color(102, 102, 102));
        lblCuenta.setText("Cuenta N°:");

        lblTelefono.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblTelefono.setForeground(new java.awt.Color(102, 102, 102));
        lblTelefono.setText("Telefono:");

        jtextSaldo.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jtextSaldo.setForeground(new java.awt.Color(51, 51, 51));

        jtextCuenta.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jtextCuenta.setForeground(new java.awt.Color(51, 51, 51));
        jtextCuenta.setText("DFGDFG");

        jtextCedula.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jtextCedula.setForeground(new java.awt.Color(51, 51, 51));
        jtextCedula.setText("DFGDFGDG");

        jtextTelefono.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jtextTelefono.setForeground(new java.awt.Color(51, 51, 51));
        jtextTelefono.setText("DFGDFG");

        lblGuarani.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblGuarani.setForeground(new java.awt.Color(51, 51, 51));
        lblGuarani.setText("₲");

        btnRecargar.setBackground(new java.awt.Color(254, 254, 254));
        btnRecargar.setForeground(new java.awt.Color(70, 70, 70));
        btnRecargar.setText("🔄");
        btnRecargar.setBorder(null);
        btnRecargar.setBorderPainted(false);
        btnRecargar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnRecargarMouseClicked(evt);
            }
        });

        lblTitular.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblTitular.setForeground(new java.awt.Color(102, 102, 102));
        lblTitular.setText("Titular:");

        jtextTitular.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jtextTitular.setForeground(new java.awt.Color(51, 51, 51));
        jtextTitular.setText("DFGDFGH");

        javax.swing.GroupLayout panelInicioLayout = new javax.swing.GroupLayout(panelInicio);
        panelInicio.setLayout(panelInicioLayout);
        panelInicioLayout.setHorizontalGroup(
            panelInicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelInicioLayout.createSequentialGroup()
                .addGap(66, 66, 66)
                .addGroup(panelInicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jtextTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtextTitular, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblTitular)
                    .addComponent(lblDatos)
                    .addComponent(lblTelefono)
                    .addComponent(lblCuenta, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblCedula, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panelInicioLayout.createSequentialGroup()
                        .addComponent(lblSaldo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnRecargar, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jtextCedula, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtextCuenta, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panelInicioLayout.createSequentialGroup()
                        .addComponent(lblGuarani)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jtextSaldo, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(176, Short.MAX_VALUE))
        );
        panelInicioLayout.setVerticalGroup(
            panelInicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelInicioLayout.createSequentialGroup()
                .addGap(65, 65, 65)
                .addGroup(panelInicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblSaldo)
                    .addComponent(btnRecargar, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelInicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblGuarani)
                    .addComponent(jtextSaldo))
                .addGap(18, 18, 18)
                .addComponent(lblDatos)
                .addGap(18, 18, 18)
                .addComponent(lblTitular)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jtextTitular, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblCedula)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jtextCedula, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblCuenta)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jtextCuenta, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblTelefono)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jtextTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(107, 107, 107))
        );

        javax.swing.GroupLayout panelDerLayout = new javax.swing.GroupLayout(panelDer);
        panelDer.setLayout(panelDerLayout);
        panelDerLayout.setHorizontalGroup(
            panelDerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelInicio, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        panelDerLayout.setVerticalGroup(
            panelDerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelInicio, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panelIzq, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelDer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelIzq, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(panelDer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnPagarServiciosMouseClicked(
            java.awt.event.MouseEvent evt) { // GEN-FIRST:event_btnPagarServiciosMouseClicked
        FormularioPagarServicios panel = new FormularioPagarServicios(m);
        intercambiar.modificarPanel(panel, panelDer);
    } // GEN-LAST:event_btnPagarServiciosMouseClicked

    private void btnInicioMouseClicked(
            java.awt.event.MouseEvent evt) { // GEN-FIRST:event_btnInicioMouseClicked
        try {
            m.IniciarSesion(m.cuentaActiva.contrasena, m.cuentaActiva.cedula);
            jtextSaldo.setText(String.valueOf(m.cuentaActiva.saldo));
        } catch (Exception e) {
        }
        panelDer.removeAll();
        panelDer.revalidate();
        panelDer.add(panelInicio);
        panelDer.repaint();
    } // GEN-LAST:event_btnInicioMouseClicked

    private void btnTransferirMouseClicked(
            java.awt.event.MouseEvent evt) { // GEN-FIRST:event_btnTransferirMouseClicked
        FormularioTransferencia panel = new FormularioTransferencia(m);
        intercambiar.modificarPanel(panel, panelDer);
    } // GEN-LAST:event_btnTransferirMouseClicked

    private void btnDepositarMouseClicked(
            java.awt.event.MouseEvent evt) { // GEN-FIRST:event_btnDepositarMouseClicked
        FormularioDeposito panel = new FormularioDeposito(m);
        intercambiar.modificarPanel(panel, panelDer);
    } // GEN-LAST:event_btnDepositarMouseClicked

    private void btnPagarTarjetaMouseClicked(
            java.awt.event.MouseEvent evt) { // GEN-FIRST:event_btnPagarTarjetaMouseClicked
        FormularioPagoTarjetas panel = new FormularioPagoTarjetas(m);
        intercambiar.modificarPanel(panel, panelDer);
    } // GEN-LAST:event_btnPagarTarjetaMouseClicked

    private void btnSalirMouseClicked(
            java.awt.event.MouseEvent evt) { // GEN-FIRST:event_btnSalirMouseClicked
        System.exit(0);
    } // GEN-LAST:event_btnSalirMouseClicked

    private void btnInicioMouseEntered(
            java.awt.event.MouseEvent evt) { // GEN-FIRST:event_btnInicioMouseEntered
        btnInicio.setBackground(new java.awt.Color(51, 51, 51));
    } // GEN-LAST:event_btnInicioMouseEntered

    private void btnInicioMouseExited(
            java.awt.event.MouseEvent evt) { // GEN-FIRST:event_btnInicioMouseExited
        btnInicio.setBackground(new java.awt.Color(102, 102, 102));
    } // GEN-LAST:event_btnInicioMouseExited

    private void btnPagarServiciosMouseEntered(
            java.awt.event.MouseEvent evt) { // GEN-FIRST:event_btnPagarServiciosMouseEntered
        btnPagarServicios.setBackground(new java.awt.Color(51, 51, 51));
    } // GEN-LAST:event_btnPagarServiciosMouseEntered

    private void btnPagarServiciosMouseExited(
            java.awt.event.MouseEvent evt) { // GEN-FIRST:event_btnPagarServiciosMouseExited
        btnPagarServicios.setBackground(new java.awt.Color(102, 102, 102));
    } // GEN-LAST:event_btnPagarServiciosMouseExited

    private void btnTransferirMouseEntered(
            java.awt.event.MouseEvent evt) { // GEN-FIRST:event_btnTransferirMouseEntered
        btnTransferir.setBackground(new java.awt.Color(51, 51, 51));
    } // GEN-LAST:event_btnTransferirMouseEntered

    private void btnTransferirMouseExited(
            java.awt.event.MouseEvent evt) { // GEN-FIRST:event_btnTransferirMouseExited
        btnTransferir.setBackground(new java.awt.Color(102, 102, 102));
    } // GEN-LAST:event_btnTransferirMouseExited

    private void btnDepositarMouseEntered(
            java.awt.event.MouseEvent evt) { // GEN-FIRST:event_btnDepositarMouseEntered
        btnDepositar.setBackground(new java.awt.Color(51, 51, 51));
    } // GEN-LAST:event_btnDepositarMouseEntered

    private void btnDepositarMouseExited(
            java.awt.event.MouseEvent evt) { // GEN-FIRST:event_btnDepositarMouseExited
        btnDepositar.setBackground(new java.awt.Color(102, 102, 102));
    } // GEN-LAST:event_btnDepositarMouseExited

    private void btnPagarTarjetaMouseEntered(
            java.awt.event.MouseEvent evt) { // GEN-FIRST:event_btnPagarTarjetaMouseEntered
        btnPagarTarjeta.setBackground(new java.awt.Color(51, 51, 51));
    } // GEN-LAST:event_btnPagarTarjetaMouseEntered

    private void btnPagarTarjetaMouseExited(
            java.awt.event.MouseEvent evt) { // GEN-FIRST:event_btnPagarTarjetaMouseExited
        btnPagarTarjeta.setBackground(new java.awt.Color(102, 102, 102));
    } // GEN-LAST:event_btnPagarTarjetaMouseExited

    private void btnSalirMouseEntered(
            java.awt.event.MouseEvent evt) { // GEN-FIRST:event_btnSalirMouseEntered
        btnSalir.setBackground(new java.awt.Color(51, 51, 51));
    } // GEN-LAST:event_btnSalirMouseEntered

    private void btnSalirMouseExited(
            java.awt.event.MouseEvent evt) { // GEN-FIRST:event_btnSalirMouseExited
        btnSalir.setBackground(new java.awt.Color(102, 102, 102));
    } // GEN-LAST:event_btnSalirMouseExited

    private void btnRecargarMouseClicked(
            java.awt.event.MouseEvent evt) { // GEN-FIRST:event_jButton1MouseClicked
        try {
            Comprobante comp = m.ConsultaSaldo(m.cuentaActiva.saldo);
            IntercambiarPaneles intercambiar = new IntercambiarPaneles();
            intercambiar.modificarPanel(comp, panelDer);

        } catch (Exception e) {
        }
    } // GEN-LAST:event_jButton1MouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {

        FlatDarkLaf.setup();
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(
                new Runnable() {
            public void run() {
                new Menu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel btnDepositar;
    private javax.swing.JPanel btnInicio;
    private javax.swing.JPanel btnPagarServicios;
    private javax.swing.JPanel btnPagarTarjeta;
    private javax.swing.JButton btnRecargar;
    private javax.swing.JPanel btnSalir;
    private javax.swing.JPanel btnTransferir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jtextCedula;
    private javax.swing.JLabel jtextCuenta;
    private javax.swing.JLabel jtextSaldo;
    private javax.swing.JLabel jtextTelefono;
    private javax.swing.JLabel jtextTitular;
    private javax.swing.JLabel lblCedula;
    private javax.swing.JLabel lblCuenta;
    private javax.swing.JLabel lblDatos;
    private javax.swing.JLabel lblGuarani;
    private javax.swing.JLabel lblSaldo;
    private javax.swing.JLabel lblTelefono;
    private javax.swing.JLabel lblTitular;
    public javax.swing.JPanel panelDer;
    public javax.swing.JPanel panelInicio;
    public javax.swing.JPanel panelIzq;
    // End of variables declaration//GEN-END:variables
}
