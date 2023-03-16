package vista;

import javax.swing.JButton;
import javax.swing.JDesktopPane;

public class VistaPrincipal extends javax.swing.JFrame {

    public VistaPrincipal() {
        initComponents();
    }

    public JButton getBtnInstructor() {
        return btnInstructor;
    }

    public void setBtnInstructor(JButton btnInstructor) {
        this.btnInstructor = btnInstructor;
    }

    public JDesktopPane getEscritorioPrincipal() {
        return escritorioPrincipal;
    }

    public void setEscritorioPrincipal(JDesktopPane escritorioPrincipal) {
        this.escritorioPrincipal = escritorioPrincipal;
    }

    public JButton getBtnNutricionista() {
        return btnNutricionista;
    }

    public void setBtnNutricionista(JButton btnNutricionista) {
        this.btnNutricionista = btnNutricionista;
    }

    public JButton getBtnCliente() {
        return btnCliente;
    }

    public void setBtnCliente(JButton btnCliente) {
        this.btnCliente = btnCliente;
    }

    public JButton getBtnServicio() {
        return btnServicio;
    }

    public void setBtnServicio(JButton btnServicio) {
        this.btnServicio = btnServicio;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        btnInstructor = new javax.swing.JButton();
        btnNutricionista = new javax.swing.JButton();
        btnCliente = new javax.swing.JButton();
        btnServicio = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        escritorioPrincipal = new javax.swing.JDesktopPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 204));

        btnInstructor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/instructor.png"))); // NOI18N
        btnInstructor.setText("Instructor");

        btnNutricionista.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/nutricionistat.png"))); // NOI18N
        btnNutricionista.setText("Nutricionista");

        btnCliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/agregar-usuario.png"))); // NOI18N
        btnCliente.setText("Cliente");

        btnServicio.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/apoyo-tecnico.png"))); // NOI18N
        btnServicio.setText("Servicio");

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/hat.png"))); // NOI18N
        jLabel1.setText("GIMNASIO ONE PIECE");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnNutricionista, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnInstructor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnCliente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnServicio, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
                .addComponent(btnInstructor)
                .addGap(18, 18, 18)
                .addComponent(btnNutricionista)
                .addGap(18, 18, 18)
                .addComponent(btnCliente)
                .addGap(18, 18, 18)
                .addComponent(btnServicio)
                .addGap(22, 22, 22))
        );

        javax.swing.GroupLayout escritorioPrincipalLayout = new javax.swing.GroupLayout(escritorioPrincipal);
        escritorioPrincipal.setLayout(escritorioPrincipalLayout);
        escritorioPrincipalLayout.setHorizontalGroup(
            escritorioPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1036, Short.MAX_VALUE)
        );
        escritorioPrincipalLayout.setVerticalGroup(
            escritorioPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(escritorioPrincipal))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(escritorioPrincipal)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCliente;
    private javax.swing.JButton btnInstructor;
    private javax.swing.JButton btnNutricionista;
    private javax.swing.JButton btnServicio;
    private javax.swing.JDesktopPane escritorioPrincipal;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
