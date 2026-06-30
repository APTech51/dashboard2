
package masterdata;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import koneksisemua.koneksi;


/**
 *
 * @author Aulia Larasati
 */
public class data_pembeli extends javax.swing.JFrame {

     DefaultTableModel model; 
    public data_pembeli() {
        initComponents();
      String[] judul = {"Kode Pembeli", "Nama", "Alamat", "No.Telp"};
    model = new DefaultTableModel(judul, 0);
    table.setModel(model);
    tampilkan();
    kodeOtomatis();               // ← tambah ini
    kd_pembeli.setEditable(false); // ← biar tidak bisa diedit manual
    table.addMouseListener(new java.awt.event.MouseAdapter() {
        public void mouseClicked(java.awt.event.MouseEvent evt) {
            int baris = table.rowAtPoint(evt.getPoint());
            kd_pembeli.setText(table.getValueAt(baris, 0).toString());
            nm_pembeli.setText(table.getValueAt(baris, 1).toString());
            almt.setText(table.getValueAt(baris, 2).toString());
            n_tlpn.setText(table.getValueAt(baris, 3).toString());
        }
    });
         }

private void kosong() {
    nm_pembeli.setText("");
    almt.setText("");
    n_tlpn.setText("");
    Mencari.setText("");
}

 private void tampilkan() {

    model.setRowCount(0);

    try {

        Connection conn = koneksi.getConnection();

        String sql = "SELECT * FROM pembeli";

        Statement st = conn.createStatement();

        ResultSet rs = st.executeQuery(sql);

        while (rs.next()) {

            model.addRow(new Object[]{
                rs.getString("kd_pembeli"),
                rs.getString("nm_pembeli"),
                rs.getString("almt"),
                rs.getString("n_tlpn")
            });

        }

    } catch (SQLException ex) {

        Logger.getLogger(data_pembeli.class.getName())
              .log(Level.SEVERE, null, ex);

    }

}
 private void kodeOtomatis() {

    try (Connection conn = koneksi.getConnection()) {

        String sql =
            "SELECT kd_pembeli FROM pembeli " +
            "ORDER BY kd_pembeli DESC LIMIT 1";

        Statement st = conn.createStatement();

        ResultSet rs = st.executeQuery(sql);

        if (rs.next()) {

            String kode = rs.getString("kd_pembeli");

            if (kode != null
                    && kode.startsWith("DTPMBLI")
                    && kode.length() > 7) {

                int nomor =
                    Integer.parseInt(kode.substring(7).trim());

                nomor++;

                kd_pembeli.setText(
                    "DTPMBLI" + String.format("%02d", nomor)
                );

            } else {

                kd_pembeli.setText("DTPMBLI01");

            }

        } else {

            kd_pembeli.setText("DTPMBLI01");

        }

    } catch (Exception e) {

        JOptionPane.showMessageDialog(
            null,
            "Kode Otomatis Error : " + e.getMessage()
        );

    }

}
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        kd_pembeli = new javax.swing.JTextField();
        nm_pembeli = new javax.swing.JTextField();
        n_tlpn = new javax.swing.JTextField();
        simpan = new javax.swing.JButton();
        edit = new javax.swing.JButton();
        hapus = new javax.swing.JButton();
        reset = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        Mencari = new javax.swing.JTextField();
        cari = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        almt = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel2.setBackground(new java.awt.Color(255, 153, 102));

        jLabel1.setFont(new java.awt.Font("Trebuchet MS", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("INPUT DATA PEMBELI");

        jPanel3.setBackground(new java.awt.Color(255, 204, 153));

        jLabel2.setFont(new java.awt.Font("Trebuchet MS", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Kode Pembeli");

        jLabel3.setFont(new java.awt.Font("Trebuchet MS", 1, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Nama Pembeli");

        jLabel4.setFont(new java.awt.Font("Trebuchet MS", 1, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Alamat");

        jLabel5.setFont(new java.awt.Font("Trebuchet MS", 1, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("No.Telepon");

        kd_pembeli.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kd_pembeliActionPerformed(evt);
            }
        });

        nm_pembeli.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nm_pembeliActionPerformed(evt);
            }
        });

        n_tlpn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                n_tlpnActionPerformed(evt);
            }
        });

        simpan.setBackground(new java.awt.Color(0, 102, 102));
        simpan.setFont(new java.awt.Font("Trebuchet MS", 1, 16)); // NOI18N
        simpan.setForeground(new java.awt.Color(255, 255, 255));
        simpan.setText("SIMPAN");
        simpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                simpanActionPerformed(evt);
            }
        });

        edit.setBackground(new java.awt.Color(0, 102, 102));
        edit.setFont(new java.awt.Font("Trebuchet MS", 1, 16)); // NOI18N
        edit.setForeground(new java.awt.Color(255, 255, 255));
        edit.setText("EDIT");
        edit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editActionPerformed(evt);
            }
        });

        hapus.setBackground(new java.awt.Color(0, 102, 102));
        hapus.setFont(new java.awt.Font("Trebuchet MS", 1, 16)); // NOI18N
        hapus.setForeground(new java.awt.Color(255, 255, 255));
        hapus.setText("HAPUS");
        hapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hapusActionPerformed(evt);
            }
        });

        reset.setBackground(new java.awt.Color(0, 102, 102));
        reset.setFont(new java.awt.Font("Trebuchet MS", 1, 16)); // NOI18N
        reset.setForeground(new java.awt.Color(255, 255, 255));
        reset.setText("RESET");
        reset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resetActionPerformed(evt);
            }
        });

        jPanel4.setBackground(new java.awt.Color(255, 204, 153));

        jLabel6.setFont(new java.awt.Font("Trebuchet MS", 1, 24)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Daftar Pembeli");

        cari.setBackground(new java.awt.Color(0, 102, 102));
        cari.setFont(new java.awt.Font("Trebuchet MS", 1, 16)); // NOI18N
        cari.setForeground(new java.awt.Color(255, 255, 255));
        cari.setText("CARI");
        cari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cariActionPerformed(evt);
            }
        });

        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Kode Pembeli", "Nama", "Alamat", "No.Telp"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane2.setViewportView(table);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(Mencari, javax.swing.GroupLayout.PREFERRED_SIZE, 397, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(41, 41, 41)
                                .addComponent(cari, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 278, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 533, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Mencari, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cari, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(297, 297, 297))
        );

        almt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                almtActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(jPanel3Layout.createSequentialGroup()
                                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGap(18, 18, 18)
                                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(n_tlpn)
                                        .addComponent(almt, javax.swing.GroupLayout.PREFERRED_SIZE, 374, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(jPanel3Layout.createSequentialGroup()
                                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(kd_pembeli, javax.swing.GroupLayout.PREFERRED_SIZE, 374, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel3Layout.createSequentialGroup()
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(nm_pembeli, javax.swing.GroupLayout.PREFERRED_SIZE, 374, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(simpan, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(edit, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(hapus, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(reset, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(kd_pembeli, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(nm_pembeli, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE)
                    .addComponent(almt))
                .addGap(26, 26, 26)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(n_tlpn, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE))
                .addGap(77, 77, 77)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(simpan, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(edit, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(hapus, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(reset, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 379, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(819, Short.MAX_VALUE))
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 39, Short.MAX_VALUE)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 30, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void kd_pembeliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kd_pembeliActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_kd_pembeliActionPerformed

    private void nm_pembeliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nm_pembeliActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nm_pembeliActionPerformed

    private void n_tlpnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_n_tlpnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_n_tlpnActionPerformed

    private void simpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_simpanActionPerformed
   if (nm_pembeli.getText().trim().isEmpty()
            || almt.getText().trim().isEmpty()
            || n_tlpn.getText().trim().isEmpty()) {

        JOptionPane.showMessageDialog(
                null,
                "Nama Pembeli, Alamat, dan No. Telepon wajib diisi!"
        );
        return;
    }

    try {
        Connection conn = koneksi.getConnection();

        String sql = "INSERT INTO pembeli "
                   + "(kd_pembeli, nm_pembeli, almt, n_tlpn) "
                   + "VALUES (?,?,?,?)";

        java.sql.PreparedStatement ps = conn.prepareStatement(sql);

        ps.setString(1, kd_pembeli.getText());
        ps.setString(2, nm_pembeli.getText().trim());
        ps.setString(3, almt.getText().trim());
        ps.setString(4, n_tlpn.getText().trim());

        ps.executeUpdate();

        JOptionPane.showMessageDialog(null, "Data berhasil disimpan");

        tampilkan();
        kosong();
        kodeOtomatis();

    } catch (Exception e) {

        JOptionPane.showMessageDialog(
                null,
                "Gagal menyimpan data : " + e.getMessage()
        );

    }

    }//GEN-LAST:event_simpanActionPerformed

    private void editActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editActionPerformed
    

    if (nm_pembeli.getText().trim().isEmpty()
            || almt.getText().trim().isEmpty()
            || n_tlpn.getText().trim().isEmpty()) {

        JOptionPane.showMessageDialog(
                null,
                "Nama Pembeli, Alamat, dan No. Telepon wajib diisi!"
        );
        return;
    }

    try {

        Connection conn = koneksi.getConnection();

        String sql =
                "UPDATE pembeli SET "
                + "nm_pembeli=?, "
                + "almt=?, "
                + "n_tlpn=? "
                + "WHERE kd_pembeli=?";

        java.sql.PreparedStatement ps =
                conn.prepareStatement(sql);

        ps.setString(1, nm_pembeli.getText().trim());
        ps.setString(2, almt.getText().trim());
        ps.setString(3, n_tlpn.getText().trim());
        ps.setString(4, kd_pembeli.getText());

        ps.executeUpdate();

        JOptionPane.showMessageDialog(
                null,
                "Data berhasil diubah"
        );

        tampilkan();
        kosong();
        kodeOtomatis();

    } catch (Exception e) {

        JOptionPane.showMessageDialog(
                null,
                "Edit gagal : " + e.getMessage()
        );

    }

    }//GEN-LAST:event_editActionPerformed

    private void hapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hapusActionPerformed
        try {
        Connection conn = koneksi.getConnection();
        String sql = "DELETE FROM pembeli WHERE kd_pembeli=?";
        java.sql.PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, kd_pembeli.getText());
        ps.executeUpdate();
        JOptionPane.showMessageDialog(null, "Data berhasil dihapus");
        tampilkan();
        kosong();
        kodeOtomatis();
    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, e.getMessage());
    }
    }//GEN-LAST:event_hapusActionPerformed

    private void resetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resetActionPerformed
    kosong();

    table.clearSelection();

    kodeOtomatis();

    kd_pembeli.setEditable(false);

    }//GEN-LAST:event_resetActionPerformed

    private void cariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cariActionPerformed
      String cariData = Mencari.getText().toLowerCase();

    for (int i = 0; i < table.getRowCount(); i++) {
        String kode  = table.getValueAt(i, 0).toString().toLowerCase();
        String nama  = table.getValueAt(i, 1).toString().toLowerCase();
        String alamat = table.getValueAt(i, 2).toString().toLowerCase();
        String telp  = table.getValueAt(i, 3).toString().toLowerCase();

        if (kode.contains(cariData) ||
            nama.contains(cariData) ||
            alamat.contains(cariData) ||
            telp.contains(cariData)) {

            table.setRowSelectionInterval(i, i);
            kd_pembeli.setText(table.getValueAt(i, 0).toString());
            nm_pembeli.setText(table.getValueAt(i, 1).toString());
            almt.setText(table.getValueAt(i, 2).toString());
            n_tlpn.setText(table.getValueAt(i, 3).toString());

            JOptionPane.showMessageDialog(null, "Data ditemukan");
            return;
        }
    }
    JOptionPane.showMessageDialog(null, "Data tidak ditemukan");
    }                                       

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
       } catch (ClassNotFoundException ex) {
    java.util.logging.Logger.getLogger(data_pembeli.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
} catch (InstantiationException ex) {
    java.util.logging.Logger.getLogger(data_pembeli.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
} catch (IllegalAccessException ex) {
    java.util.logging.Logger.getLogger(data_pembeli.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
} catch (javax.swing.UnsupportedLookAndFeelException ex) {
    java.util.logging.Logger.getLogger(data_pembeli.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
}
// ...
// ...
 
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
            new data_pembeli().setVisible(true);
            }
        });
    }//GEN-LAST:event_cariActionPerformed

    private void almtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_almtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_almtActionPerformed

    /**
     * @param args the command line arguments
     */
   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField Mencari;
    private javax.swing.JTextField almt;
    private javax.swing.JButton cari;
    private javax.swing.JButton edit;
    private javax.swing.JButton hapus;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField kd_pembeli;
    private javax.swing.JTextField n_tlpn;
    private javax.swing.JTextField nm_pembeli;
    private javax.swing.JButton reset;
    private javax.swing.JButton simpan;
    private javax.swing.JTable table;
    // End of variables declaration//GEN-END:variables
}
