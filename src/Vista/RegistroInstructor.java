package Vista;

/**
 *
 * @author miche
 */
public class RegistroInstructor extends javax.swing.JFrame {

    /**
     * Creates new form RegistroInstructor
     */
    public RegistroInstructor() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        registro = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        txtcodins = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtcedulains = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtdescrip = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtapellidoins = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtdireccionins = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        telefonoins = new javax.swing.JFormattedTextField();
        jLabel10 = new javax.swing.JLabel();
        txtsalarioins = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        jCmbhorarioins = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        fechanacimins = new com.toedter.calendar.JDateChooser();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        txtnombreins = new javax.swing.JTextField();
        txtareatrabajo = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableInstructor = new javax.swing.JTable();
        txtbuscarins = new javax.swing.JTextField();
        btguardarIns = new javax.swing.JButton();
        editarIns = new javax.swing.JButton();
        eliminarIns = new javax.swing.JButton();
        limpiarIns = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(240, 232, 217));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(255, 204, 204));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        registro.setFont(new java.awt.Font("SansSerif", 1, 24)); // NOI18N
        registro.setForeground(new java.awt.Color(51, 0, 0));
        registro.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        registro.setText("Registro Instructor");
        jPanel2.add(registro, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 20, 250, 50));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/registro-en-linea.png"))); // NOI18N
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 10, -1, -1));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/sombrero (1).png"))); // NOI18N
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1100, 10, -1, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 3, 18)); // NOI18N
        jLabel3.setText("One Piece");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(1060, 50, 100, -1));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1220, 90));

        jLabel13.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 1, 18)); // NOI18N
        jLabel13.setText("Codigo:");
        jPanel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 140, -1, -1));

        txtcodins.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        jPanel1.add(txtcodins, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 140, 40, 30));

        jLabel4.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 1, 18)); // NOI18N
        jLabel4.setText("Cedula:");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 190, -1, -1));
        jPanel1.add(txtcedulains, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 190, 260, -1));

        jLabel5.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 1, 18)); // NOI18N
        jLabel5.setText("Nombre:");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 230, -1, -1));
        jPanel1.add(txtdescrip, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 650, 230, -1));

        jLabel6.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 1, 18)); // NOI18N
        jLabel6.setText("Apellido:");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 280, -1, -1));
        jPanel1.add(txtapellidoins, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 280, 260, -1));

        jLabel8.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 1, 18)); // NOI18N
        jLabel8.setText("Fecha Nacimiento:");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 330, -1, -1));
        jPanel1.add(txtdireccionins, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 430, 230, -1));

        jLabel11.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 1, 18)); // NOI18N
        jLabel11.setText("Telefono:");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 380, -1, -1));

        try {
            telefonoins.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(#) ##-#####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        jPanel1.add(telefonoins, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 380, 230, -1));

        jLabel10.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 1, 18)); // NOI18N
        jLabel10.setText("Salario:");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 480, -1, -1));
        jPanel1.add(txtsalarioins, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 480, 150, -1));

        jLabel19.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 1, 18)); // NOI18N
        jLabel19.setText("Descripción:");
        jPanel1.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 650, -1, -1));

        jCmbhorarioins.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Matutino", "Vespertino" }));
        jPanel1.add(jCmbhorarioins, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 530, 230, -1));

        jLabel9.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 1, 18)); // NOI18N
        jLabel9.setText("Direccion:");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 430, -1, -1));
        jPanel1.add(fechanacimins, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 330, 190, -1));

        jLabel20.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 1, 18)); // NOI18N
        jLabel20.setText("Horario:");
        jPanel1.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 530, -1, -1));

        jLabel21.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 1, 18)); // NOI18N
        jLabel21.setText("Area Trabajo:");
        jPanel1.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 590, -1, -1));
        jPanel1.add(txtnombreins, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 230, 260, -1));
        jPanel1.add(txtareatrabajo, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 590, 230, -1));

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/LupaCaj.png"))); // NOI18N
        jLabel7.setToolTipText("");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 140, -1, -1));

        jTableInstructor.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "txtcedulains", "txtdescrip", "txtapellidoins", "Edad", "CorreoCon", "txtdireccionins", "Genero", "Telofono", "Bono", "txtsalarioins", "Codigo Empleado"
            }
        ));
        jTableInstructor.setName(""); // NOI18N
        jScrollPane1.setViewportView(jTableInstructor);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 220, 740, 380));
        jPanel1.add(txtbuscarins, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 150, 280, 30));

        btguardarIns.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/icon-save.png"))); // NOI18N
        jPanel1.add(btguardarIns, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 640, -1, -1));

        editarIns.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/icon-actualizar.png"))); // NOI18N
        jPanel1.add(editarIns, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 640, -1, -1));

        eliminarIns.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/icon-delete.png"))); // NOI18N
        jPanel1.add(eliminarIns, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 640, -1, -1));

        limpiarIns.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/icon-clear.png"))); // NOI18N
        jPanel1.add(limpiarIns, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 640, -1, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1221, 711));

        pack();
    }// </editor-fold>//GEN-END:initComponents



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btguardarIns;
    private javax.swing.JButton editarIns;
    private javax.swing.JButton eliminarIns;
    private com.toedter.calendar.JDateChooser fechanacimins;
    private javax.swing.JComboBox<String> jCmbhorarioins;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableInstructor;
    private javax.swing.JButton limpiarIns;
    private javax.swing.JLabel registro;
    private javax.swing.JFormattedTextField telefonoins;
    private javax.swing.JTextField txtapellidoins;
    private javax.swing.JTextField txtareatrabajo;
    private javax.swing.JTextField txtbuscarins;
    private javax.swing.JTextField txtcedulains;
    private javax.swing.JTextField txtcodins;
    private javax.swing.JTextField txtdescrip;
    private javax.swing.JTextField txtdireccionins;
    private javax.swing.JTextField txtnombreins;
    private javax.swing.JTextField txtsalarioins;
    // End of variables declaration//GEN-END:variables
}
