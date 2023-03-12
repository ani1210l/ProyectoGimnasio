package Vista;

import javax.accessibility.AccessibleContext;
import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRootPane;

/**
 *
 * @author Carla Leon
 */
public class VistaPrincipal extends javax.swing.JFrame {

    public VistaPrincipal() {
        initComponents();
    }

    public JButton getBtn_horario() {
        return btn_horario;
    }

    public void setBtn_horario(JButton btn_horario) {
        this.btn_horario = btn_horario;
    }

    public JButton getBtn_pago() {
        return btn_pago;
    }

    public void setBtn_pago(JButton btn_pago) {
        this.btn_pago = btn_pago;
    }

    public JButton getBtninstructor() {
        return btninstructor;
    }

    public void setBtninstructor(JButton btninstructor) {
        this.btninstructor = btninstructor;
    }

    public JButton getBtnnutricionista() {
        return btnnutricionista;
    }

    public void setBtnnutricionista(JButton btnnutricionista) {
        this.btnnutricionista = btnnutricionista;
    }

    public JButton getBtnpersonas() {
        return btnpersonas;
    }

    public void setBtnpersonas(JButton btnpersonas) {
        this.btnpersonas = btnpersonas;
    }

    public JButton getBtnregistrocli() {
        return btnregistrocli;
    }

    public void setBtnregistrocli(JButton btnregistrocli) {
        this.btnregistrocli = btnregistrocli;
    }

    public JButton getBtnregistroemp() {
        return btnregistroemp;
    }

    public void setBtnregistroemp(JButton btnregistroemp) {
        this.btnregistroemp = btnregistroemp;
    }

    public JButton getBtnregistroservcli() {
        return btnregistroservcli;
    }

    public void setBtnregistroservcli(JButton btnregistroservcli) {
        this.btnregistroservcli = btnregistroservcli;
    }

    public JButton getBtnservicios() {
        return btnservicios;
    }

    public void setBtnservicios(JButton btnservicios) {
        this.btnservicios = btnservicios;
    }

    public JButton getjButtonLogoOnePiece() {
        return jButtonLogoOnePiece;
    }

    public void setjButtonLogoOnePiece(JButton jButtonLogoOnePiece) {
        this.jButtonLogoOnePiece = jButtonLogoOnePiece;
    }

    public JDesktopPane getjDesktopPane() {
        return jDesktopPane;
    }

    public void setjDesktopPane(JDesktopPane jDesktopPane) {
        this.jDesktopPane = jDesktopPane;
    }

    
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jButtonLogoOnePiece = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        btnpersonas = new javax.swing.JButton();
        btninstructor = new javax.swing.JButton();
        btnnutricionista = new javax.swing.JButton();
        btn_horario = new javax.swing.JButton();
        btn_pago = new javax.swing.JButton();
        btnservicios = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        btnregistrocli = new javax.swing.JButton();
        btnregistroemp = new javax.swing.JButton();
        btnregistroservcli = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jDesktopPane = new javax.swing.JDesktopPane();
        jLabel6 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 102));
        jPanel1.setForeground(new java.awt.Color(102, 204, 255));

        jButtonLogoOnePiece.setBackground(new java.awt.Color(255, 255, 51));
        jButtonLogoOnePiece.setForeground(new java.awt.Color(255, 255, 255));
        jButtonLogoOnePiece.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Logoi-.png"))); // NOI18N
        jButtonLogoOnePiece.setBorder(null);

        jLabel1.setFont(new java.awt.Font("Roboto Black", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("GYM");

        btnpersonas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/PERSONA.png"))); // NOI18N
        btnpersonas.setText("PERSONAS");

        btninstructor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/FIT{.jpg"))); // NOI18N
        btninstructor.setText("INSTRUCTOR");

        btnnutricionista.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/mANZA.jpg"))); // NOI18N
        btnnutricionista.setText("NUTRICIONISTA");

        btn_horario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/horario.jpg"))); // NOI18N
        btn_horario.setText("HORARIO");
        btn_horario.setAutoscrolls(true);

        btn_pago.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/dinero.jpg"))); // NOI18N
        btn_pago.setText("PAGO");

        btnservicios.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/mano.jpg"))); // NOI18N
        btnservicios.setText("SERVICIOS");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(93, 93, 93)
                                .addComponent(jLabel1))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(47, 47, 47)
                                .addComponent(jButtonLogoOnePiece)))
                        .addGap(0, 19, Short.MAX_VALUE))
                    .addComponent(btnnutricionista, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_horario, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btninstructor, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnpersonas, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_pago, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnservicios, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jButtonLogoOnePiece)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(btnpersonas)
                .addGap(18, 18, 18)
                .addComponent(btninstructor)
                .addGap(18, 18, 18)
                .addComponent(btnnutricionista)
                .addGap(18, 18, 18)
                .addComponent(btn_horario)
                .addGap(18, 18, 18)
                .addComponent(btn_pago)
                .addGap(18, 18, 18)
                .addComponent(btnservicios)
                .addContainerGap(87, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(0, 204, 204));

        btnregistrocli.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/cli.png"))); // NOI18N
        btnregistrocli.setText("RIGISTRO CLIENTES");

        btnregistroemp.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/imageEs.png"))); // NOI18N
        btnregistroemp.setText("REGISTRO EMPLEADOS");

        btnregistroservcli.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/perso.jpg"))); // NOI18N
        btnregistroservcli.setText("REGISTRO SERVICIOS CLIENTES");

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setFont(new java.awt.Font("Roboto Black", 1, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/LOGO.jpg"))); // NOI18N
        jLabel2.setText("GIMNASIO ONE PICE");
        jLabel2.setToolTipText("");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(btnregistrocli, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(btnregistroemp)
                .addGap(32, 32, 32)
                .addComponent(btnregistroservcli, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(48, 48, 48)
                .addComponent(jLabel2)
                .addContainerGap(137, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(67, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnregistrocli, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnregistroemp, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnregistroservcli, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29))
        );

        jLabel6.setFont(new java.awt.Font("Roboto Black", 1, 48)); // NOI18N
        jLabel6.setText("BIENVENIDOS");

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/imagesGGG.jpg"))); // NOI18N

        jDesktopPane.setLayer(jLabel6, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane.setLayer(jLabel5, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jDesktopPaneLayout = new javax.swing.GroupLayout(jDesktopPane);
        jDesktopPane.setLayout(jDesktopPaneLayout);
        jDesktopPaneLayout.setHorizontalGroup(
            jDesktopPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDesktopPaneLayout.createSequentialGroup()
                .addGroup(jDesktopPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jDesktopPaneLayout.createSequentialGroup()
                        .addGap(511, 511, 511)
                        .addComponent(jLabel6))
                    .addGroup(jDesktopPaneLayout.createSequentialGroup()
                        .addGap(629, 629, 629)
                        .addComponent(jLabel5)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jDesktopPaneLayout.setVerticalGroup(
            jDesktopPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDesktopPaneLayout.createSequentialGroup()
                .addGap(224, 224, 224)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5)
                .addContainerGap(157, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jDesktopPane)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 18, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jDesktopPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_horario;
    private javax.swing.JButton btn_pago;
    private javax.swing.JButton btninstructor;
    private javax.swing.JButton btnnutricionista;
    private javax.swing.JButton btnpersonas;
    private javax.swing.JButton btnregistrocli;
    private javax.swing.JButton btnregistroemp;
    private javax.swing.JButton btnregistroservcli;
    private javax.swing.JButton btnservicios;
    private javax.swing.JButton jButtonLogoOnePiece;
    private javax.swing.JDesktopPane jDesktopPane;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    // End of variables declaration//GEN-END:variables
}
