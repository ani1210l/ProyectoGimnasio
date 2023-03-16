package vista;

import com.toedter.calendar.JDateChooser;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JRadioButton;
import javax.swing.JTable;
import javax.swing.JTextField;

public class VistaInstructor extends javax.swing.JInternalFrame {

    public VistaInstructor() {
        initComponents();
    }

    public JRadioButton getMatutino() {
        return Matutino;
    }

    public void setMatutino(JRadioButton Matutino) {
        this.Matutino = Matutino;
    }

    public JRadioButton getNocturno() {
        return Nocturno;
    }

    public void setNocturno(JRadioButton Nocturno) {
        this.Nocturno = Nocturno;
    }

    public JRadioButton getVespertino() {
        return Vespertino;
    }

    public void setVespertino(JRadioButton Vespertino) {
        this.Vespertino = Vespertino;
    }

    public JButton getBtnActualizar() {
        return btnActualizar;
    }

    public void setBtnActualizar(JButton btnActualizar) {
        this.btnActualizar = btnActualizar;
    }

    public JButton getBtnCancelar() {
        return btnCancelar;
    }

    public void setBtnCancelar(JButton btnCancelar) {
        this.btnCancelar = btnCancelar;
    }

    public JButton getBtnCrear() {
        return btnCrear;
    }

    public void setBtnCrear(JButton btnCrear) {
        this.btnCrear = btnCrear;
    }

    public JButton getBtnEliminar() {
        return btnEliminar;
    }

    public void setBtnEliminar(JButton btnEliminar) {
        this.btnEliminar = btnEliminar;
    }

    public JButton getBtnGuardar() {
        return btnGuardar;
    }

    public void setBtnGuardar(JButton btnGuardar) {
        this.btnGuardar = btnGuardar;
    }

    public JButton getBtnModificar() {
        return btnModificar;
    }

    public void setBtnModificar(JButton btnModificar) {
        this.btnModificar = btnModificar;
    }

    public JDateChooser getFechaDeNacimiento() {
        return fechaDeNacimiento;
    }

    public void setFechaDeNacimiento(JDateChooser fechaDeNacimiento) {
        this.fechaDeNacimiento = fechaDeNacimiento;
    }

    public ButtonGroup getHorario() {
        return horario;
    }

    public void setHorario(ButtonGroup horario) {
        this.horario = horario;
    }

    public JDialog getjDlgInstructor() {
        return jDlgInstructor;
    }

    public void setjDlgInstructor(JDialog jDlgInstructor) {
        this.jDlgInstructor = jDlgInstructor;
    }

    public JTable getTblInstructor() {
        return tblInstructor;
    }

    public void setTblInstructor(JTable tblInstructor) {
        this.tblInstructor = tblInstructor;
    }

    public JTextField getTxtApellido() {
        return txtApellido;
    }

    public void setTxtApellido(JTextField txtApellido) {
        this.txtApellido = txtApellido;
    }

    public JTextField getTxtAreaTrabajo() {
        return txtAreaTrabajo;
    }

    public void setTxtAreaTrabajo(JTextField txtAreaTrabajo) {
        this.txtAreaTrabajo = txtAreaTrabajo;
    }

    public JTextField getTxtBuscar() {
        return txtBuscar;
    }

    public void setTxtBuscar(JTextField txtBuscar) {
        this.txtBuscar = txtBuscar;
    }

    public JTextField getTxtCedula() {
        return txtCedula;
    }

    public void setTxtCedula(JTextField txtCedula) {
        this.txtCedula = txtCedula;
    }

    public JTextField getTxtDireccion() {
        return txtDireccion;
    }

    public void setTxtDireccion(JTextField txtDireccion) {
        this.txtDireccion = txtDireccion;
    }

    public JTextField getTxtNombre() {
        return txtNombre;
    }

    public void setTxtNombre(JTextField txtNombre) {
        this.txtNombre = txtNombre;
    }

    public JTextField getTxtTelefono() {
        return txtTelefono;
    }

    public void setTxtTelefono(JTextField txtTelefono) {
        this.txtTelefono = txtTelefono;
    }

    public JTextField getTxtCodigoInstructor() {
        return txtCodigoInstructor;
    }

    public void setTxtCodigoInstructor(JTextField txtCodigoInstructor) {
        this.txtCodigoInstructor = txtCodigoInstructor;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDlgInstructor = new javax.swing.JDialog();
        jPanel2 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtCedula = new javax.swing.JTextField();
        txtAreaTrabajo = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtCodigoInstructor = new javax.swing.JTextField();
        Vespertino = new javax.swing.JRadioButton();
        Matutino = new javax.swing.JRadioButton();
        Nocturno = new javax.swing.JRadioButton();
        jLabel10 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        txtApellido = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        fechaDeNacimiento = new com.toedter.calendar.JDateChooser();
        jLabel11 = new javax.swing.JLabel();
        txtTelefono = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txtDireccion = new javax.swing.JTextField();
        btnGuardar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        horario = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        txtBuscar = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        btnCrear = new javax.swing.JButton();
        btnModificar = new javax.swing.JButton();
        btnActualizar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblInstructor = new javax.swing.JTable();

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setFont(new java.awt.Font("Roboto Medium", 0, 18)); // NOI18N
        jLabel4.setText("Cedula:");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(42, 76, -1, -1));

        jLabel2.setFont(new java.awt.Font("Roboto Medium", 1, 18)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Registrar instructor");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 20, 880, -1));
        jPanel2.add(txtCedula, new org.netbeans.lib.awtextra.AbsoluteConstraints(212, 76, 191, -1));
        jPanel2.add(txtAreaTrabajo, new org.netbeans.lib.awtextra.AbsoluteConstraints(632, 76, 186, -1));

        jLabel7.setFont(new java.awt.Font("Roboto Medium", 0, 18)); // NOI18N
        jLabel7.setText("Área de trabajo:");
        jPanel2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(492, 76, -1, -1));
        jPanel2.add(txtCodigoInstructor, new org.netbeans.lib.awtextra.AbsoluteConstraints(822, 76, 45, -1));

        Vespertino.setFont(new java.awt.Font("Roboto Medium", 0, 14)); // NOI18N
        Vespertino.setText("Vespertino");
        jPanel2.add(Vespertino, new org.netbeans.lib.awtextra.AbsoluteConstraints(732, 136, -1, -1));

        Matutino.setFont(new java.awt.Font("Roboto Medium", 0, 14)); // NOI18N
        Matutino.setText("Matutino");
        jPanel2.add(Matutino, new org.netbeans.lib.awtextra.AbsoluteConstraints(632, 136, -1, -1));

        Nocturno.setFont(new java.awt.Font("Roboto Medium", 0, 14)); // NOI18N
        Nocturno.setText("Nocturno");
        jPanel2.add(Nocturno, new org.netbeans.lib.awtextra.AbsoluteConstraints(632, 186, -1, -1));

        jLabel10.setFont(new java.awt.Font("Roboto Medium", 0, 18)); // NOI18N
        jLabel10.setText("Horario:");
        jPanel2.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(492, 136, -1, -1));
        jPanel2.add(txtNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(212, 116, 191, -1));
        jPanel2.add(txtApellido, new org.netbeans.lib.awtextra.AbsoluteConstraints(212, 166, 191, -1));

        jLabel6.setFont(new java.awt.Font("Roboto Medium", 0, 18)); // NOI18N
        jLabel6.setText("Nombre:");
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 120, -1, -1));

        jLabel8.setFont(new java.awt.Font("Roboto Medium", 0, 18)); // NOI18N
        jLabel8.setText("Fecha Nacimiento:");
        jPanel2.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(42, 226, -1, -1));
        jPanel2.add(fechaDeNacimiento, new org.netbeans.lib.awtextra.AbsoluteConstraints(212, 226, 191, -1));

        jLabel11.setFont(new java.awt.Font("Roboto Medium", 0, 18)); // NOI18N
        jLabel11.setText("Teléfono:");
        jPanel2.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(42, 286, -1, -1));
        jPanel2.add(txtTelefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(212, 286, 191, -1));

        jLabel9.setFont(new java.awt.Font("Roboto Medium", 0, 18)); // NOI18N
        jLabel9.setText("Dirección:");
        jPanel2.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(46, 344, -1, -1));
        jPanel2.add(txtDireccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(212, 346, 191, -1));

        btnGuardar.setFont(new java.awt.Font("Roboto Medium", 1, 14)); // NOI18N
        btnGuardar.setText("Guardar");
        jPanel2.add(btnGuardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(322, 416, -1, -1));

        btnCancelar.setFont(new java.awt.Font("Roboto Medium", 1, 14)); // NOI18N
        btnCancelar.setText("Cancelar");
        jPanel2.add(btnCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(562, 416, -1, -1));

        jLabel12.setFont(new java.awt.Font("Roboto Medium", 0, 18)); // NOI18N
        jLabel12.setText("Apellido:");
        jPanel2.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 170, -1, -1));

        javax.swing.GroupLayout jDlgInstructorLayout = new javax.swing.GroupLayout(jDlgInstructor.getContentPane());
        jDlgInstructor.getContentPane().setLayout(jDlgInstructorLayout);
        jDlgInstructorLayout.setHorizontalGroup(
            jDlgInstructorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 883, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        jDlgInstructorLayout.setVerticalGroup(
            jDlgInstructorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel13.setBackground(new java.awt.Color(255, 255, 255));
        jLabel13.setFont(new java.awt.Font("Roboto Black", 0, 18)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(51, 102, 255));
        jLabel13.setText("GIMNASIO ONE- PIECE");

        jLabel16.setFont(new java.awt.Font("Roboto Black", 1, 18)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(51, 102, 255));
        jLabel16.setText("REGISTRO INSTRUCTOR");

        jLabel1.setText("Buscar:");

        btnCrear.setText("Guardar");

        btnModificar.setText("Modificar");

        btnActualizar.setText("Actualizar");

        btnEliminar.setText("Eliminar");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(153, 153, 153)
                        .addComponent(btnCrear)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 68, Short.MAX_VALUE)
                        .addComponent(btnModificar)
                        .addGap(55, 55, 55)
                        .addComponent(btnActualizar)
                        .addGap(60, 60, 60)
                        .addComponent(btnEliminar))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(77, 77, 77)
                        .addComponent(jLabel16)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(69, 69, 69))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(jLabel13))
                .addGap(27, 27, 27)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(btnCrear)
                    .addComponent(btnModificar)
                    .addComponent(btnActualizar)
                    .addComponent(btnEliminar))
                .addContainerGap(40, Short.MAX_VALUE))
        );

        tblInstructor.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Cédula", "Nombre", "Apellido", "Área de trabajo", "Horario"
            }
        ));
        jScrollPane1.setViewportView(tblInstructor);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jScrollPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 301, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButton Matutino;
    private javax.swing.JRadioButton Nocturno;
    private javax.swing.JRadioButton Vespertino;
    private javax.swing.JButton btnActualizar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnCrear;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnModificar;
    private com.toedter.calendar.JDateChooser fechaDeNacimiento;
    private javax.swing.ButtonGroup horario;
    private javax.swing.JDialog jDlgInstructor;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblInstructor;
    private javax.swing.JTextField txtApellido;
    private javax.swing.JTextField txtAreaTrabajo;
    private javax.swing.JTextField txtBuscar;
    private javax.swing.JTextField txtCedula;
    private javax.swing.JTextField txtCodigoInstructor;
    private javax.swing.JTextField txtDireccion;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtTelefono;
    // End of variables declaration//GEN-END:variables
}
