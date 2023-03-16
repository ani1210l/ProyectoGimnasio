package vista;

import controlador.ControladorLogin;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 *
 * @author miche
 */
public class Login extends javax.swing.JFrame {

    /**
     * Creates new form Login
     */
    public Login() {
        initComponents();
    }

    
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtusuario = new javax.swing.JTextField();
        btnregistrar = new javax.swing.JButton();
        lbmostrar = new javax.swing.JLabel();
        btniniciar = new javax.swing.JButton();
        lbocultar = new javax.swing.JLabel();
        txtcontra = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel1.setText("Contraseña:");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(86, 171, -1, -1));

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel2.setText("Usuario:");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(123, 110, -1, -1));
        jPanel1.add(txtusuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 110, 186, 30));

        btnregistrar.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        btnregistrar.setText("Registrar");
        jPanel1.add(btnregistrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 260, -1, -1));

        lbmostrar.setBackground(new java.awt.Color(255, 204, 51));
        lbmostrar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbmostrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/ojo-rojo.png"))); // NOI18N
        jPanel1.add(lbmostrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 170, 30, 30));

        btniniciar.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        btniniciar.setText("Iniciar");
        jPanel1.add(btniniciar, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 260, -1, -1));

        lbocultar.setBackground(new java.awt.Color(255, 0, 0));
        lbocultar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbocultar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/visible.png"))); // NOI18N
        jPanel1.add(lbocultar, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 170, 30, 30));
        jPanel1.add(txtcontra, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 170, 190, 30));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 631, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 388, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public JButton getBtniniciar() {
        return btniniciar;
    }

    public void setBtniniciar(JButton btniniciar) {
        this.btniniciar = btniniciar;
    }

    public JButton getBtnregistrar() {
        return btnregistrar;
    }

    public void setBtnregistrar(JButton btnregistrar) {
        this.btnregistrar = btnregistrar;
    }

    public JPasswordField getTxtcontra() {
        return txtcontra;
    }

    public void setTxtcontra(JPasswordField txtcontra) {
        this.txtcontra = txtcontra;
    }

    public JTextField getTxtusuario() {
        return txtusuario;
    }

    public void setTxtusuario(JTextField txtusuario) {
        this.txtusuario = txtusuario;
    }

    public JLabel getLbmostrar() {
        return lbmostrar;
    }

    public void setLbmostrar(JLabel lbmostrar) {
        this.lbmostrar = lbmostrar;
    }

    public JLabel getLbocultar() {
        return lbocultar;
    }

    public void setLbocultar(JLabel lbocultar) {
        this.lbocultar = lbocultar;
    }
    
    

    
    
    
    public static void main(String args[]) {
        
        
        Login vistaLogin = new Login();
        ControladorLogin control = new ControladorLogin(vistaLogin);
        control.iniciarControl();
        
    }
    
   
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btniniciar;
    private javax.swing.JButton btnregistrar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lbmostrar;
    private javax.swing.JLabel lbocultar;
    private javax.swing.JPasswordField txtcontra;
    private javax.swing.JTextField txtusuario;
    // End of variables declaration//GEN-END:variables
}
