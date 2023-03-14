package Vista;

import com.toedter.calendar.JDateChooser;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

/**
 *
 * @author Michelle
 */
public class VistaServicios extends javax.swing.JFrame {

    /**
     * Creates new form VistaServicios
     */
    public VistaServicios() {
        initComponents();
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        dlgServicio = new javax.swing.JDialog();
        jPanel1 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        btnguardarser = new javax.swing.JButton();
        btncancelarser = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtdetalle = new javax.swing.JTextField();
        cmbhorario = new javax.swing.JComboBox();
        cardio = new javax.swing.JRadioButton();
        baiolo = new javax.swing.JRadioButton();
        pesas = new javax.swing.JRadioButton();
        fechaservicio = new com.toedter.calendar.JDateChooser();
        jLabel5 = new javax.swing.JLabel();
        txtcodservicio = new javax.swing.JTextField();
        GroupServicio = new javax.swing.ButtonGroup();
        jPanel4 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        btnCrearservicios = new javax.swing.JButton();
        btnActualizarservicios = new javax.swing.JButton();
        btnModificarservicios = new javax.swing.JButton();
        txtBuscar = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblservicios = new javax.swing.JTable();

        jPanel1.setBackground(new java.awt.Color(247, 247, 220));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));

        jLabel13.setBackground(new java.awt.Color(255, 255, 255));
        jLabel13.setFont(new java.awt.Font("Roboto Black", 0, 18)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(51, 102, 255));
        jLabel13.setText("GIMNASIO ONE- PIECE");

        jLabel18.setFont(new java.awt.Font("Roboto Black", 1, 24)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(51, 153, 255));
        jLabel18.setText("Servicio");

        jLabel19.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/LOGO.jpg"))); // NOI18N

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(jLabel19)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 220, Short.MAX_VALUE)
                .addComponent(jLabel18)
                .addGap(38, 38, 38))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel18))
                    .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 630, -1));

        btnguardarser.setFont(new java.awt.Font("Roboto Light", 0, 12)); // NOI18N
        btnguardarser.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/descarga.1png.png"))); // NOI18N
        btnguardarser.setText("Guardar");
        jPanel1.add(btnguardarser, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 440, -1, -1));

        btncancelarser.setFont(new java.awt.Font("Roboto Light", 0, 12)); // NOI18N
        btncancelarser.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/png-transparent-computer-icons-no-symbol-cancel-8angle-rim-svg.png"))); // NOI18N
        btncancelarser.setText("Cancelar");
        jPanel1.add(btncancelarser, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 440, -1, -1));

        jLabel1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel1.setText("Código:");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 100, -1, 20));

        jLabel2.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel2.setText("Tipo:");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 150, -1, -1));

        jLabel3.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel3.setText("Detalle:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 260, -1, -1));

        jLabel4.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel4.setText("Fecha Ingreso:");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 350, -1, -1));
        jPanel1.add(txtdetalle, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 260, 240, 60));

        cmbhorario.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Matutino", "Nocturno" }));
        jPanel1.add(cmbhorario, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 200, 140, -1));

        cardio.setBackground(new java.awt.Color(247, 247, 220));
        GroupServicio.add(cardio);
        cardio.setText("Cardio");
        jPanel1.add(cardio, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 150, -1, -1));

        baiolo.setBackground(new java.awt.Color(247, 247, 220));
        GroupServicio.add(baiolo);
        baiolo.setText("Bailoterapia");
        jPanel1.add(baiolo, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 150, -1, -1));

        pesas.setBackground(new java.awt.Color(247, 247, 220));
        GroupServicio.add(pesas);
        pesas.setText("Levantamiento Pesas");
        jPanel1.add(pesas, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 150, -1, -1));
        jPanel1.add(fechaservicio, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 350, 200, -1));

        jLabel5.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel5.setText("Horario:");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 200, -1, -1));
        jPanel1.add(txtcodservicio, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 100, 110, -1));

        javax.swing.GroupLayout dlgServicioLayout = new javax.swing.GroupLayout(dlgServicio.getContentPane());
        dlgServicio.getContentPane().setLayout(dlgServicioLayout);
        dlgServicioLayout.setHorizontalGroup(
            dlgServicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 632, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        dlgServicioLayout.setVerticalGroup(
            dlgServicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 538, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));

        jLabel12.setBackground(new java.awt.Color(255, 255, 255));
        jLabel12.setFont(new java.awt.Font("Roboto Black", 0, 18)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(51, 102, 255));
        jLabel12.setText("GIMNASIO ONE- PIECE");

        jLabel15.setFont(new java.awt.Font("Roboto Black", 1, 24)); // NOI18N
        jLabel15.setText("REGISTRO DE SERVICIOS");

        jLabel16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/LOGO.jpg"))); // NOI18N

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(jLabel16)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel15)
                .addGap(20, 20, 20))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel15))
                    .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(24, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(255, 255, 102));

        btnCrearservicios.setBackground(new java.awt.Color(255, 51, 51));
        btnCrearservicios.setFont(new java.awt.Font("Roboto Medium", 0, 13)); // NOI18N
        btnCrearservicios.setForeground(new java.awt.Color(255, 255, 255));
        btnCrearservicios.setText("Crear");
        btnCrearservicios.setBorder(null);

        btnActualizarservicios.setBackground(new java.awt.Color(255, 51, 51));
        btnActualizarservicios.setFont(new java.awt.Font("Roboto Medium", 0, 13)); // NOI18N
        btnActualizarservicios.setForeground(new java.awt.Color(255, 255, 255));
        btnActualizarservicios.setText("Actualizar");
        btnActualizarservicios.setBorder(null);

        btnModificarservicios.setBackground(new java.awt.Color(255, 51, 51));
        btnModificarservicios.setFont(new java.awt.Font("Roboto Medium", 0, 13)); // NOI18N
        btnModificarservicios.setForeground(new java.awt.Color(255, 255, 255));
        btnModificarservicios.setText("Modificar");
        btnModificarservicios.setBorder(null);

        jLabel10.setFont(new java.awt.Font("Roboto Medium", 0, 14)); // NOI18N
        jLabel10.setText("Buscar:");

        jLabel17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/LupaCaj.png"))); // NOI18N

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jLabel10)
                .addGap(18, 18, 18)
                .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel17)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 71, Short.MAX_VALUE)
                .addComponent(btnCrearservicios, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addComponent(btnActualizarservicios, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addComponent(btnModificarservicios, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap(34, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCrearservicios, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnActualizarservicios, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel17)
                    .addComponent(btnModificarservicios, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27))
        );

        tblservicios.setBackground(new java.awt.Color(0, 153, 255));
        tblservicios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "ser_codigo", "ser_tipo", "ser_hora", "ser_detalle", "ser_fechaingreso"
            }
        ));
        jScrollPane1.setViewportView(tblservicios);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
            .addComponent(jScrollPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 340, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(68, 68, 68))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public ButtonGroup getGroupServicio() {
        return GroupServicio;
    }

    public void setGroupServicio(ButtonGroup GroupServicio) {
        this.GroupServicio = GroupServicio;
    }

    public JRadioButton getBaiolo() {
        return baiolo;
    }

    public void setBaiolo(JRadioButton baiolo) {
        this.baiolo = baiolo;
    }

    public JButton getBtnActualizarservicios() {
        return btnActualizarservicios;
    }

    public void setBtnActualizarservicios(JButton btnActualizarservicios) {
        this.btnActualizarservicios = btnActualizarservicios;
    }

    public JButton getBtnCrearservicios() {
        return btnCrearservicios;
    }

    public void setBtnCrearservicios(JButton btnCrearservicios) {
        this.btnCrearservicios = btnCrearservicios;
    }

    public JButton getBtnModificarservicios() {
        return btnModificarservicios;
    }

    public void setBtnModificarservicios(JButton btnModificarservicios) {
        this.btnModificarservicios = btnModificarservicios;
    }

    public JButton getBtncancelarser() {
        return btncancelarser;
    }

    public void setBtncancelarser(JButton btncancelarser) {
        this.btncancelarser = btncancelarser;
    }

    public JButton getBtnguardarser() {
        return btnguardarser;
    }

    public void setBtnguardarser(JButton btnguardarser) {
        this.btnguardarser = btnguardarser;
    }

    public JRadioButton getCardio() {
        return cardio;
    }

    public void setCardio(JRadioButton cardio) {
        this.cardio = cardio;
    }

    public JComboBox getCmbhorario() {
        return cmbhorario;
    }

    public void setCmbhorario(JComboBox cmbhorario) {
        this.cmbhorario = cmbhorario;
    }

    public JDialog getDlgServicio() {
        return dlgServicio;
    }

    public void setDlgServicio(JDialog dlgServicio) {
        this.dlgServicio = dlgServicio;
    }

    public JDateChooser getFechaservicio() {
        return fechaservicio;
    }

    public void setFechaservicio(JDateChooser fechaservicio) {
        this.fechaservicio = fechaservicio;
    }

    public JScrollPane getjScrollPane1() {
        return jScrollPane1;
    }

    public void setjScrollPane1(JScrollPane jScrollPane1) {
        this.jScrollPane1 = jScrollPane1;
    }

    public JRadioButton getPesas() {
        return pesas;
    }

    public void setPesas(JRadioButton pesas) {
        this.pesas = pesas;
    }

    public JTable getTblservicios() {
        return tblservicios;
    }

    public void setTblservicios(JTable tblservicios) {
        this.tblservicios = tblservicios;
    }

    public JTextField getTxtBuscar() {
        return txtBuscar;
    }

    public void setTxtBuscar(JTextField txtBuscar) {
        this.txtBuscar = txtBuscar;
    }

    public JTextField getTxtcodservicio() {
        return txtcodservicio;
    }

    public void setTxtcodservicio(JTextField txtcodservicio) {
        this.txtcodservicio = txtcodservicio;
    }

    public JTextField getTxtdetalle() {
        return txtdetalle;
    }

    public void setTxtdetalle(JTextField txtdetalle) {
        this.txtdetalle = txtdetalle;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup GroupServicio;
    private javax.swing.JRadioButton baiolo;
    private javax.swing.JButton btnActualizarservicios;
    private javax.swing.JButton btnCrearservicios;
    private javax.swing.JButton btnModificarservicios;
    private javax.swing.JButton btncancelarser;
    private javax.swing.JButton btnguardarser;
    private javax.swing.JRadioButton cardio;
    private javax.swing.JComboBox cmbhorario;
    private javax.swing.JDialog dlgServicio;
    private com.toedter.calendar.JDateChooser fechaservicio;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JRadioButton pesas;
    private javax.swing.JTable tblservicios;
    private javax.swing.JTextField txtBuscar;
    private javax.swing.JTextField txtcodservicio;
    private javax.swing.JTextField txtdetalle;
    // End of variables declaration//GEN-END:variables
}
