package vista;

import com.toedter.calendar.JDateChooser;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class VistaNutricionista extends javax.swing.JFrame {

    public VistaNutricionista() {
        initComponents();
    }

    public JRadioButton getMatutino() {
        return Matutino;
    }

    public void setMatutino(JRadioButton Matutino) {
        this.Matutino = Matutino;
    }

    public JRadioButton getVespertino() {
        return Vespertino;
    }

    public void setVespertino(JRadioButton Vespertino) {
        this.Vespertino = Vespertino;
    }

    public JDateChooser getFechaDeNacimientonutri() {
        return fechaDeNacimientonutri;
    }

    public void setFechaDeNacimientonutri(JDateChooser fechaDeNacimientonutri) {
        this.fechaDeNacimientonutri = fechaDeNacimientonutri;
    }

    public JTextField getTxtApellidonutri() {
        return txtApellidonutri;
    }

    public void setTxtApellidonutri(JTextField txtApellidonutri) {
        this.txtApellidonutri = txtApellidonutri;
    }

    public JTextField getTxtBuscarnutri() {
        return txtBuscarnutri;
    }

    public void setTxtBuscarnutri(JTextField txtBuscarnutri) {
        this.txtBuscarnutri = txtBuscarnutri;
    }

    public JTextField getTxtCedulanutri() {
        return txtCedulanutri;
    }

    public void setTxtCedulanutri(JTextField txtCedulanutri) {
        this.txtCedulanutri = txtCedulanutri;
    }

    public JTextField getTxtDireccionnutri() {
        return txtDireccionnutri;
    }

    public void setTxtDireccionnutri(JTextField txtDireccionnutri) {
        this.txtDireccionnutri = txtDireccionnutri;
    }

    public JTextField getTxtNombrenutri() {
        return txtNombrenutri;
    }

    public void setTxtNombrenutri(JTextField txtNombrenutri) {
        this.txtNombrenutri = txtNombrenutri;
    }

    public JTextField getTxtRutina() {
        return txtRutina;
    }

    public void setTxtRutina(JTextField txtRutina) {
        this.txtRutina = txtRutina;
    }

    public JTextField getTxtTelefononutri() {
        return txtTelefononutri;
    }

    public void setTxtTelefononutri(JTextField txtTelefononutri) {
        this.txtTelefononutri = txtTelefononutri;
    }

    public JButton getBtnActualizarNUTRI() {
        return btnActualizarNUTRI;
    }

    public void setBtnActualizarNUTRI(JButton btnActualizarNUTRI) {
        this.btnActualizarNUTRI = btnActualizarNUTRI;
    }

    public JButton getBtnCancelar() {
        return btnCancelar;
    }

    public void setBtnCancelar(JButton btnCancelar) {
        this.btnCancelar = btnCancelar;
    }

    public JButton getBtnCrearNUTRI() {
        return btnCrearNUTRI;
    }

    public void setBtnCrearNUTRI(JButton btnCrearNUTRI) {
        this.btnCrearNUTRI = btnCrearNUTRI;
    }

    public JButton getBtnEliminarNUTRI() {
        return btnEliminarNUTRI;
    }

    public void setBtnEliminarNUTRI(JButton btnEliminarNUTRI) {
        this.btnEliminarNUTRI = btnEliminarNUTRI;
    }

    public JButton getBtnGuardar() {
        return btnGuardar;
    }

    public void setBtnGuardar(JButton btnGuardar) {
        this.btnGuardar = btnGuardar;
    }

    public JButton getBtnModificarNUTRI() {
        return btnModificarNUTRI;
    }

    public void setBtnModificarNUTRI(JButton btnModificarNUTRI) {
        this.btnModificarNUTRI = btnModificarNUTRI;
    }

    public JDialog getjDialogNutricionista() {
        return jDialogNutricionista;
    }

   

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDialogNutricionista = new javax.swing.JDialog();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        txtCedulanutri = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtNombrenutri = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtApellidonutri = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        txtTelefononutri = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txtDireccionnutri = new javax.swing.JTextField();
        fechaDeNacimientonutri = new com.toedter.calendar.JDateChooser();
        jLabel7 = new javax.swing.JLabel();
        txtRutina = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        Vespertino = new javax.swing.JRadioButton();
        Matutino = new javax.swing.JRadioButton();
        btnGuardar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        txtBuscarnutri = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        btnCrearNUTRI = new javax.swing.JButton();
        btnModificarNUTRI = new javax.swing.JButton();
        btnActualizarNUTRI = new javax.swing.JButton();
        btnEliminarNUTRI = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla_nutri = new javax.swing.JTable();

        jLabel4.setFont(new java.awt.Font("Roboto Medium", 1, 18)); // NOI18N
        jLabel4.setText("Cedula:");

        jLabel5.setFont(new java.awt.Font("Roboto Medium", 1, 18)); // NOI18N
        jLabel5.setText("Nombre:");

        jLabel6.setFont(new java.awt.Font("Roboto Medium", 1, 18)); // NOI18N
        jLabel6.setText("Apellido:");

        jLabel8.setFont(new java.awt.Font("Roboto Medium", 1, 18)); // NOI18N
        jLabel8.setText("Fecha Nacimiento:");

        jLabel11.setFont(new java.awt.Font("Roboto Medium", 1, 18)); // NOI18N
        jLabel11.setText("TELEFONO:");

        jLabel9.setFont(new java.awt.Font("Roboto Medium", 1, 18)); // NOI18N
        jLabel9.setText("Direccion:");

        jLabel7.setFont(new java.awt.Font("Roboto Medium", 1, 18)); // NOI18N
        jLabel7.setText("Rutina:");

        jLabel10.setFont(new java.awt.Font("Roboto Medium", 1, 18)); // NOI18N
        jLabel10.setText("Horario:");

        Vespertino.setText("Vespertino");

        Matutino.setText("Matutino");

        btnGuardar.setText("Guardar");

        btnCancelar.setText("Cancelar");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8)
                            .addComponent(jLabel11)
                            .addComponent(jLabel6)
                            .addComponent(jLabel9)
                            .addComponent(jLabel5)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(fechaDeNacimientonutri, javax.swing.GroupLayout.DEFAULT_SIZE, 191, Short.MAX_VALUE)
                            .addComponent(txtDireccionnutri)
                            .addComponent(txtTelefononutri)
                            .addComponent(txtApellidonutri)
                            .addComponent(txtNombrenutri)
                            .addComponent(txtCedulanutri))
                        .addGap(50, 50, 50)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10)
                            .addComponent(jLabel7)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnGuardar)
                        .addGap(132, 132, 132)
                        .addComponent(btnCancelar)))
                .addGap(14, 14, 14)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtRutina, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(Matutino)
                        .addGap(11, 11, 11)
                        .addComponent(Vespertino)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(69, 69, 69)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(txtCedulanutri, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(17, 17, 17)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(txtNombrenutri, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(txtRutina, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(17, 17, 17)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(Vespertino)
                            .addComponent(Matutino))))
                .addGap(25, 25, 25)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtApellidonutri, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8)
                    .addComponent(fechaDeNacimientonutri, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(txtTelefononutri, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(txtDireccionnutri, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 9, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnGuardar)
                    .addComponent(btnCancelar))
                .addGap(45, 45, 45))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jDialogNutricionistaLayout = new javax.swing.GroupLayout(jDialogNutricionista.getContentPane());
        jDialogNutricionista.getContentPane().setLayout(jDialogNutricionistaLayout);
        jDialogNutricionistaLayout.setHorizontalGroup(
            jDialogNutricionistaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDialogNutricionistaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jDialogNutricionistaLayout.setVerticalGroup(
            jDialogNutricionistaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDialogNutricionistaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 153));

        jLabel13.setBackground(new java.awt.Color(255, 255, 255));
        jLabel13.setFont(new java.awt.Font("Roboto Black", 0, 18)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(51, 102, 255));
        jLabel13.setText("GIMNASIO ONE- PIECE");

        jLabel16.setFont(new java.awt.Font("Roboto Black", 1, 18)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(51, 102, 255));
        jLabel16.setText("REGISTRO NUTRICIONISTA");

        jLabel1.setText("Buscar:");

        btnCrearNUTRI.setText("Guardar");

        btnModificarNUTRI.setText("Modificar");

        btnActualizarNUTRI.setText("Actualizar");

        btnEliminarNUTRI.setText("Eliminar");

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/LOGO.jpg"))); // NOI18N

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/mANZA.jpg"))); // NOI18N

        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/LupaCaj.png"))); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtBuscarnutri, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel12)
                        .addGap(91, 91, 91)
                        .addComponent(btnCrearNUTRI)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                        .addComponent(btnModificarNUTRI)
                        .addGap(36, 36, 36)
                        .addComponent(btnActualizarNUTRI)
                        .addGap(39, 39, 39)
                        .addComponent(btnEliminarNUTRI)
                        .addGap(14, 14, 14))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel16)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addGap(33, 33, 33))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel16)
                                .addComponent(jLabel13))
                            .addComponent(jLabel2)))
                    .addComponent(jLabel3))
                .addGap(27, 27, 27)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtBuscarnutri, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(btnCrearNUTRI)
                    .addComponent(btnModificarNUTRI)
                    .addComponent(btnActualizarNUTRI)
                    .addComponent(btnEliminarNUTRI)
                    .addComponent(jLabel12))
                .addContainerGap(40, Short.MAX_VALUE))
        );

        tabla_nutri.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Cedula", "Nombre", "Apellido", "Rutina", "Horario"
            }
        ));
        jScrollPane1.setViewportView(tabla_nutri);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(21, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButton Matutino;
    private javax.swing.JRadioButton Vespertino;
    private javax.swing.JButton btnActualizarNUTRI;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnCrearNUTRI;
    private javax.swing.JButton btnEliminarNUTRI;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnModificarNUTRI;
    private com.toedter.calendar.JDateChooser fechaDeNacimientonutri;
    private javax.swing.JDialog jDialogNutricionista;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabla_nutri;
    private javax.swing.JTextField txtApellidonutri;
    private javax.swing.JTextField txtBuscarnutri;
    private javax.swing.JTextField txtCedulanutri;
    private javax.swing.JTextField txtDireccionnutri;
    private javax.swing.JTextField txtNombrenutri;
    private javax.swing.JTextField txtRutina;
    private javax.swing.JTextField txtTelefononutri;
    // End of variables declaration//GEN-END:variables
}
