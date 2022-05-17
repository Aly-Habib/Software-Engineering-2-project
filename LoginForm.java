 
package View;
import Model.*;
import javax.swing.JOptionPane;


public class LoginForm extends javax.swing.JFrame {

    String username;
    String password;
    String type;
    public LoginForm() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenu1 = new javax.swing.JMenu();
        jMenu3 = new javax.swing.JMenu();
        jMenu5 = new javax.swing.JMenu();
        jMenu6 = new javax.swing.JMenu();
        jMenu7 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextPane1 = new javax.swing.JTextPane();
        userNameLabel = new javax.swing.JLabel();
        userNameTxt = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        passwordTxt = new javax.swing.JPasswordField();
        login = new javax.swing.JButton();
        userType = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();

        jMenu1.setText("jMenu1");

        jMenu3.setText("jMenu3");

        jMenu5.setText("jMenu5");

        jMenu6.setText("jMenu6");

        jMenu7.setText("jMenu7");

        jMenuItem1.setText("jMenuItem1");

        jScrollPane1.setViewportView(jTextPane1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Login");

        userNameLabel.setText("Enter User Name");

        userNameTxt.setToolTipText("");
        userNameTxt.setPreferredSize(new java.awt.Dimension(120, 22));

        jLabel2.setText("Enter Password");

        passwordTxt.setPreferredSize(new java.awt.Dimension(120, 22));

        login.setText("Login");
        login.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginActionPerformed(evt);
            }
        });

        userType.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Admin", "Team leader", "Employee" }));

        jLabel1.setText("Choose type");
        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(60, 60, 60)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(userNameLabel)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGap(69, 69, 69)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(userType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(userNameTxt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(passwordTxt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(139, 139, 139)
                        .addComponent(login)))
                .addContainerGap(63, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(userNameLabel)
                    .addComponent(userNameTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(70, 70, 70)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(passwordTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(44, 44, 44)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(userType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(login)
                .addContainerGap(46, Short.MAX_VALUE))
        );

        userType.getAccessibleContext().setAccessibleName("User type");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void loginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginActionPerformed
        username = userNameTxt.getText();
        password = String.valueOf(passwordTxt.getPassword());
        type = userType.getSelectedItem().toString();
        if(username.equals("") || password.equals(""))
            JOptionPane.showMessageDialog(this, "Enter all data");
        else if(type.equals("Admin")){
            startAdmin(username, password);
            this.setVisible(false);
        }
        else if(type.equals("Team leader")){
            startTeamLeader(username, password);
            this.setVisible(false);
        }
        else if(type.equals("Employee")){
            startEmployee(username, password);
            this.setVisible(false);
        }
    }//GEN-LAST:event_loginActionPerformed

    public static void main(String args[]) {
        new LoginForm().setVisible(true);
    }
    
    public void startAdmin(String username, String password){
        Admin admin = new Admin();
        if(admin.login(username, password)){
            new AdminForm().setVisible(true);
        }
        else{
            JOptionPane.showMessageDialog(this,  "Invalid username or password");
        }
    }
    
    public void startTeamLeader(String username, String password){
        TeamLeader leader = new TeamLeader();
        if(leader.login(username, password)){
            new TeamLeaderForm().setVisible(true);
            
        }
        else{
            JOptionPane.showMessageDialog(this, "Invalid username or password");
        }
    }
    
    public void startEmployee(String user, String password){
        Employee emp = new Employee();
        if(emp.login(username, password)){
            new EmployeeForm().setVisible(true);
        }
        else{
            JOptionPane.showMessageDialog(this, "Invalid username or password");
        }
    }
    

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenu jMenu6;
    private javax.swing.JMenu jMenu7;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextPane jTextPane1;
    private javax.swing.JButton login;
    private javax.swing.JPasswordField passwordTxt;
    private javax.swing.JLabel userNameLabel;
    private javax.swing.JTextField userNameTxt;
    private javax.swing.JComboBox<String> userType;
    // End of variables declaration//GEN-END:variables
}
