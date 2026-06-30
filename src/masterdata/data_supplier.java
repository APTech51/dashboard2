package masterdata;




/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Aulia Larasati
 */
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import java.sql.Statement;
import javax.swing.table.DefaultTableModel;
import koneksisemua.koneksi;
public class data_supplier extends javax.swing.JFrame {

   
    DefaultTableModel model;
    
    
    public data_supplier() {
        initComponents();
         KD_Supp.setEditable(false);
    String[] judul = {"KD_Supp", "Nama_Supp", "Alamat", "NoTelp", "Email"};
    model = new DefaultTableModel(judul, 0);
    tbl_supplier.setModel(model);
   tampilkan();
    kosong();
    kodeOtomatis();
    
    tbl_supplier.addMouseListener(new java.awt.event.MouseAdapter() {
        public void mouseClicked(java.awt.event.MouseEvent evt) {
            int baris = tbl_supplier.rowAtPoint(evt.getPoint());
           KD_Supp.setText(tbl_supplier.getValueAt(baris, 0).toString());
            Nama_Supp.setText(tbl_supplier.getValueAt(baris, 1).toString());
            Alamat.setText(tbl_supplier.getValueAt(baris, 2).toString());
            NoTelp.setText(tbl_supplier.getValueAt(baris, 3).toString());
            Email.setText(tbl_supplier.getValueAt(baris, 4).toString());
            }
        });
         }

private void kosong() {
     KD_Supp.setText("");
      Nama_Supp.setText("");
     Alamat.setText("");
        NoTelp.setText("");
        Email.setText("");
        tf_cari.setText("");
}

 private void tampilkan() {
        int row = tbl_supplier.getRowCount();
        for (int a = 0; a < row; a++) {
            model.removeRow(0);
        }
        try {
            Connection conn = koneksi.getConnection();
            ResultSet rs = conn.createStatement().executeQuery("SELECT * FROM supplier");
            while (rs.next()) {
                String data[] = {rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5)};
                model.addRow(data);
            }
        } catch (SQLException ex) {
            Logger.getLogger(data_supplier.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
 private void kodeOtomatis() {

    try (Connection conn = koneksi.getConnection()) {

        String sql =
            "SELECT KD_Supp FROM supplier " +
            "ORDER BY KD_Supp DESC LIMIT 1";

        Statement stat = conn.createStatement();
        ResultSet rs = stat.executeQuery(sql);

        if (rs.next()) {

            String kode = rs.getString("KD_Supp");

            if (kode != null
                    && kode.startsWith("DTSPPLR")
                    && kode.length() > 7) {

                String angka = kode.substring(7).trim();

                int nomor = Integer.parseInt(angka);

                nomor++;

                KD_Supp.setText(
                    "DTSPPLR" + String.format("%02d", nomor)
                );

            } else {

                KD_Supp.setText("DTSPPLR01");

            }

        } else {

            KD_Supp.setText("DTSPPLR01");

        }

    } catch (Exception e) {

        JOptionPane.showMessageDialog(
            null,
            "Kode otomatis error : " + e.getMessage()
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
        lb_KDsupp = new javax.swing.JLabel();
        lb_NAMAsupp = new javax.swing.JLabel();
        lb_Alamat = new javax.swing.JLabel();
        lb_NoTelp = new javax.swing.JLabel();
        lb_Email = new javax.swing.JLabel();
        KD_Supp = new javax.swing.JTextField();
        Nama_Supp = new javax.swing.JTextField();
        Alamat = new javax.swing.JTextField();
        NoTelp = new javax.swing.JTextField();
        Email = new javax.swing.JTextField();
        bt_tambah = new javax.swing.JButton();
        bt_edit = new javax.swing.JButton();
        bt_hapus = new javax.swing.JButton();
        bt_reset = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_supplier = new javax.swing.JTable();
        tf_cari = new javax.swing.JTextField();
        bt_cari = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel2.setBackground(new java.awt.Color(255, 153, 102));

        jLabel1.setFont(new java.awt.Font("Trebuchet MS", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("DATA SUPPLIER");

        jPanel3.setBackground(new java.awt.Color(255, 204, 153));

        lb_KDsupp.setFont(new java.awt.Font("Trebuchet MS", 1, 24)); // NOI18N
        lb_KDsupp.setForeground(new java.awt.Color(255, 255, 255));
        lb_KDsupp.setText("Kode Supplier");

        lb_NAMAsupp.setFont(new java.awt.Font("Trebuchet MS", 1, 24)); // NOI18N
        lb_NAMAsupp.setForeground(new java.awt.Color(255, 255, 255));
        lb_NAMAsupp.setText("Nama Supplier");

        lb_Alamat.setFont(new java.awt.Font("Trebuchet MS", 1, 24)); // NOI18N
        lb_Alamat.setForeground(new java.awt.Color(255, 255, 255));
        lb_Alamat.setText("Alamat");

        lb_NoTelp.setFont(new java.awt.Font("Trebuchet MS", 1, 24)); // NOI18N
        lb_NoTelp.setForeground(new java.awt.Color(255, 255, 255));
        lb_NoTelp.setText("No.Telepon");

        lb_Email.setFont(new java.awt.Font("Trebuchet MS", 1, 24)); // NOI18N
        lb_Email.setForeground(new java.awt.Color(255, 255, 255));
        lb_Email.setText("Email");

        KD_Supp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                KD_SuppActionPerformed(evt);
            }
        });

        bt_tambah.setBackground(new java.awt.Color(0, 102, 102));
        bt_tambah.setFont(new java.awt.Font("Trebuchet MS", 1, 24)); // NOI18N
        bt_tambah.setForeground(new java.awt.Color(255, 255, 255));
        bt_tambah.setText("Tambah");
        bt_tambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_tambahActionPerformed(evt);
            }
        });

        bt_edit.setBackground(new java.awt.Color(0, 102, 102));
        bt_edit.setFont(new java.awt.Font("Trebuchet MS", 1, 24)); // NOI18N
        bt_edit.setForeground(new java.awt.Color(255, 255, 255));
        bt_edit.setText("Edit");
        bt_edit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_editActionPerformed(evt);
            }
        });

        bt_hapus.setBackground(new java.awt.Color(0, 102, 102));
        bt_hapus.setFont(new java.awt.Font("Trebuchet MS", 1, 24)); // NOI18N
        bt_hapus.setForeground(new java.awt.Color(255, 255, 255));
        bt_hapus.setText("Hapus");
        bt_hapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_hapusActionPerformed(evt);
            }
        });

        bt_reset.setBackground(new java.awt.Color(0, 102, 102));
        bt_reset.setFont(new java.awt.Font("Trebuchet MS", 1, 24)); // NOI18N
        bt_reset.setForeground(new java.awt.Color(255, 255, 255));
        bt_reset.setText("Reset");
        bt_reset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_resetActionPerformed(evt);
            }
        });

        tbl_supplier.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        tbl_supplier.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "", "", "", "", ""
            }
        ));
        jScrollPane1.setViewportView(tbl_supplier);

        bt_cari.setBackground(new java.awt.Color(0, 102, 102));
        bt_cari.setFont(new java.awt.Font("Trebuchet MS", 1, 36)); // NOI18N
        bt_cari.setForeground(new java.awt.Color(255, 255, 255));
        bt_cari.setText("cari");
        bt_cari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_cariActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1247, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lb_NAMAsupp, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lb_KDsupp, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lb_Email, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(29, 29, 29)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(Alamat, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(NoTelp, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(Email, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(Nama_Supp, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(KD_Supp, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addComponent(lb_Alamat, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lb_NoTelp, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(169, 169, 169)
                                .addComponent(bt_edit, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(30, 30, 30)
                                .addComponent(bt_hapus, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(34, 34, 34)
                                .addComponent(bt_reset, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(bt_tambah, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tf_cari, javax.swing.GroupLayout.PREFERRED_SIZE, 281, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(32, 32, 32)
                        .addComponent(bt_cari, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(48, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tf_cari, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(bt_cari, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(105, 105, 105))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lb_KDsupp, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(KD_Supp, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lb_NAMAsupp, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Nama_Supp, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lb_Alamat, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Alamat, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lb_NoTelp, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(NoTelp, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lb_Email, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Email, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)))
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bt_tambah, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bt_edit, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bt_hapus, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bt_reset, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(119, 119, 119))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 341, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                .addGap(0, 0, Short.MAX_VALUE))
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
    
    


























    
    private void bt_tambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_tambahActionPerformed
    if (Nama_Supp.getText().trim().isEmpty()
        || Alamat.getText().trim().isEmpty()
        || NoTelp.getText().trim().isEmpty()
        || Email.getText().trim().isEmpty()) {

    JOptionPane.showMessageDialog(
        null,
        "Semua data supplier wajib diisi!"
    );
    return;
}    
    try {
        Connection conn = koneksi.getConnection();
        String sql =
    "INSERT INTO supplier " +
    "(KD_Supp, Nama_Supp, Alamat, NoTelp, Email, hg_beli) " +
    "VALUES (?,?,?,?,?,?)";
        java.sql.PreparedStatement ps = conn.prepareStatement(sql);
       ps.setString(1, KD_Supp.getText());
ps.setString(2, Nama_Supp.getText());
ps.setString(3, Alamat.getText());
ps.setString(4, NoTelp.getText());
ps.setString(5, Email.getText());

ps.setInt(6, 0);

ps.executeUpdate();
        JOptionPane.showMessageDialog(null, "Data berhasil disimpan");
       tampilkan();
        kosong();
        kodeOtomatis();
    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, e.getMessage());
    }
    }//GEN-LAST:event_bt_tambahActionPerformed

    private void bt_editActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_editActionPerformed
  
    if (Nama_Supp.getText().trim().isEmpty()
            || Alamat.getText().trim().isEmpty()
            || NoTelp.getText().trim().isEmpty()
            || Email.getText().trim().isEmpty()) {

        JOptionPane.showMessageDialog(
            null,
            "Semua data supplier wajib diisi!"
        );
        return;
    }

    try {

        Connection conn = koneksi.getConnection();

        String sql =
            "UPDATE supplier SET " +
            "Nama_Supp=?, " +
            "Alamat=?, " +
            "NoTelp=?, " +
            "Email=? " +
            "WHERE KD_Supp=?";

        java.sql.PreparedStatement ps =
            conn.prepareStatement(sql);

        ps.setString(1, Nama_Supp.getText().trim());
        ps.setString(2, Alamat.getText().trim());
        ps.setString(3, NoTelp.getText().trim());
        ps.setString(4, Email.getText().trim());
        ps.setString(5, KD_Supp.getText());

        ps.executeUpdate();

        JOptionPane.showMessageDialog(
            null,
            "Data berhasil diupdate"
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

    }//GEN-LAST:event_bt_editActionPerformed

    private void bt_hapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_hapusActionPerformed
    int pilih = JOptionPane.showConfirmDialog(
    null,
    "Yakin ingin menghapus supplier?",
    "Konfirmasi",
    JOptionPane.YES_NO_OPTION
    );

    if (pilih != JOptionPane.YES_OPTION) {
    return;
    }
        
        try{
      Connection conn = koneksi.getConnection();
            String sql = "DELETE FROM supplier WHERE KD_Supp=?";
            java.sql.PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, KD_Supp.getText());
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Data berhasil dihapus");
            tampilkan();
            kosong();
            kodeOtomatis();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }         
    }//GEN-LAST:event_bt_hapusActionPerformed

    private void bt_resetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_resetActionPerformed
      kosong();
    kodeOtomatis();
        tbl_supplier.clearSelection();

        
 

    }//GEN-LAST:event_bt_resetActionPerformed

    private void bt_cariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_cariActionPerformed
        String cariData = tf_cari.getText().toLowerCase(); // ← pakai tf_cari

    for (int i = 0; i < tbl_supplier.getRowCount(); i++) { // ← pakai tbl_supplier
        String kode  = tbl_supplier.getValueAt(i, 0).toString().toLowerCase();
        String nama  = tbl_supplier.getValueAt(i, 1).toString().toLowerCase();
        String alamat = tbl_supplier.getValueAt(i, 2).toString().toLowerCase();
        String telp  = tbl_supplier.getValueAt(i, 3).toString().toLowerCase();
        String email = tbl_supplier.getValueAt(i, 4).toString().toLowerCase();

        if (kode.contains(cariData) ||
            nama.contains(cariData) ||
            alamat.contains(cariData) ||
            telp.contains(cariData) ||
            email.contains(cariData)) {

            tbl_supplier.setRowSelectionInterval(i, i);
            KD_Supp.setText(tbl_supplier.getValueAt(i, 0).toString());
            Nama_Supp.setText(tbl_supplier.getValueAt(i, 1).toString());
            Alamat.setText(tbl_supplier.getValueAt(i, 2).toString());
            NoTelp.setText(tbl_supplier.getValueAt(i, 3).toString());
            Email.setText(tbl_supplier.getValueAt(i, 4).toString());

            JOptionPane.showMessageDialog(null, "Data ditemukan");
            return;
        }
    }
    JOptionPane.showMessageDialog(null, "Data tidak ditemukan");
    }//GEN-LAST:event_bt_cariActionPerformed

    private void KD_SuppActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_KD_SuppActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_KD_SuppActionPerformed

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
            java.util.logging.Logger.getLogger(data_supplier.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(data_supplier.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(data_supplier.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(data_supplier.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new data_supplier().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField Alamat;
    private javax.swing.JTextField Email;
    private javax.swing.JTextField KD_Supp;
    private javax.swing.JTextField Nama_Supp;
    private javax.swing.JTextField NoTelp;
    private javax.swing.JButton bt_cari;
    private javax.swing.JButton bt_edit;
    private javax.swing.JButton bt_hapus;
    private javax.swing.JButton bt_reset;
    private javax.swing.JButton bt_tambah;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lb_Alamat;
    private javax.swing.JLabel lb_Email;
    private javax.swing.JLabel lb_KDsupp;
    private javax.swing.JLabel lb_NAMAsupp;
    private javax.swing.JLabel lb_NoTelp;
    private javax.swing.JTable tbl_supplier;
    private javax.swing.JTextField tf_cari;
    // End of variables declaration//GEN-END:variables
}
