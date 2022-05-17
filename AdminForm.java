
package View;


public class AdminForm extends javax.swing.JFrame {


    public AdminForm() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuItem1 = new javax.swing.JMenuItem();
        employee = new javax.swing.JButton();
        teamLeader = new javax.swing.JButton();
        task = new javax.swing.JButton();
        logout = new javax.swing.JButton();

        jMenuItem1.setText("jMenuItem1");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Admin");

        employee.setText("Employee");
        employee.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                employeeActionPerformed(evt);
            }
        });

        teamLeader.setText("Team leader");
        teamLeader.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                teamLeaderActionPerformed(evt);
            }
        });

        task.setText("Task");
        task.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                taskActionPerformed(evt);
            }
        });

        logout.setText("Log out");
        logout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logoutActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(employee)
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(logout)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(teamLeader)
                        .addGap(43, 43, 43)
                        .addComponent(task, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(69, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(employee, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(teamLeader, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(task, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 97, Short.MAX_VALUE)
                .addComponent(logout)
                .addGap(78, 78, 78))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void employeeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_employeeActionPerformed
        new AdminEmployeeForm().setVisible(true);
    }//GEN-LAST:event_employeeActionPerformed

    private void teamLeaderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_teamLeaderActionPerformed
        new AdminTeamLeaderForm().setVisible(true);
    }//GEN-LAST:event_teamLeaderActionPerformed

    private void taskActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_taskActionPerformed
        new AdminTaskForm().setVisible(true);
    }//GEN-LAST:event_taskActionPerformed

    private void logoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logoutActionPerformed
        new LoginForm().setVisible(true);
    }//GEN-LAST:event_logoutActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton employee;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JButton logout;
    private javax.swing.JButton task;
    private javax.swing.JButton teamLeader;
    // End of variables declaration//GEN-END:variables
}
