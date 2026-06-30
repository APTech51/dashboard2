package Transaksi;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import koneksisemua.koneksi;
import java.sql.PreparedStatement;
/**
 *
 * @author stevenJt
 */
public class ts_barang_masuk extends javax.swing.JFrame {
private Connection conn = new koneksi().getConnection();
    private int idMasuk = 0;
    private DefaultTableModel tabmode;
    private javax.swing.JFrame parentFrame;
    
    /**
     * Creates new form ts_barang
     */
    
    private void tampilSupplier() {
    try {
        Connection conn = koneksi.getConnection();
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery(
            "SELECT Nama_Supp FROM supplier ORDER BY Nama_Supp ASC"
        );

        supplier.removeAllItems();

        while (rs.next()) {
            supplier.addItem(rs.getString("Nama_Supp"));
        }

    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, e.getMessage());
    }
}
    
    
    private void tampilNamaBarang() {
    try {
        Connection conn = koneksi.getConnection();
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery(
            "SELECT n_brng FROM barang ORDER BY n_brng ASC"
        );

        nm_brg.removeAllItems();

        while (rs.next()) {
            nm_brg.addItem(rs.getString("n_brng"));
        }

    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, e.getMessage());
    }
}
    
    private void kosongkanForm() {
    nm_brg.setSelectedIndex(0);
    supplier.setSelectedIndex(0);
    hg_beli.setText("");
    jumlah.setText("");
    kd_brg.setText("");
}
    
    public ts_barang_masuk() {
    initComponents();

    tampilData();
    tampilSupplier();
    tampilNamaBarang();
    kd_brg.setEditable(false);
}
    
    private void tampilData() {
        DefaultTableModel model = new DefaultTableModel();
      model.addColumn("No");
model.addColumn("Kode Barang");
model.addColumn("Nama Barang");
model.addColumn("Supplier");
model.addColumn("Harga Beli");
model.addColumn("Jumlah");  
       

        try {
            Connection conn = koneksi.getConnection();
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM ts_brg_msk");

            while (rs.next()) {
              model.addRow(new Object[]{
    rs.getInt("id_masuk"),
    rs.getString("kd_brg"),
    rs.getString("nm_brg"),
    rs.getString("supplier"),
    rs.getString("hg_beli"),
    rs.getString("jumlah")
});
            }
            TBL.setModel(model);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        kd_brg = new javax.swing.JTextField();
        hg_beli = new javax.swing.JTextField();
        jumlah = new javax.swing.JTextField();
        Bsave = new javax.swing.JButton();
        Bedit = new javax.swing.JButton();
        Bhapus = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        TBL = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        supplier = new javax.swing.JComboBox<>();
        btnCetak = new javax.swing.JButton();
        nm_brg = new javax.swing.JComboBox<>();
        Mencari = new javax.swing.JTextField();
        Cari = new javax.swing.JButton();
        reset = new javax.swing.JButton();

        jLabel5.setText("jLabel2");

        jLabel7.setText("jLabel2");

        jLabel10.setText("jLabel2");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 204, 153));

        jLabel2.setFont(new java.awt.Font("Trebuchet MS", 1, 16)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Nama Barang  :");

        jLabel3.setFont(new java.awt.Font("Trebuchet MS", 1, 16)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Supplier          :");

        jLabel4.setFont(new java.awt.Font("Trebuchet MS", 1, 16)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Harga Beli      :");

        jLabel6.setFont(new java.awt.Font("Trebuchet MS", 1, 16)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Kode Barang   :");

        jLabel9.setFont(new java.awt.Font("Trebuchet MS", 1, 16)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Jumlah          :");

        kd_brg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kd_brgActionPerformed(evt);
            }
        });

        Bsave.setBackground(new java.awt.Color(0, 102, 102));
        Bsave.setFont(new java.awt.Font("Trebuchet MS", 1, 16)); // NOI18N
        Bsave.setForeground(new java.awt.Color(255, 255, 255));
        Bsave.setText("Save");
        Bsave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BsaveActionPerformed(evt);
            }
        });

        Bedit.setBackground(new java.awt.Color(0, 102, 102));
        Bedit.setFont(new java.awt.Font("Trebuchet MS", 1, 16)); // NOI18N
        Bedit.setForeground(new java.awt.Color(255, 255, 255));
        Bedit.setText("Edit");
        Bedit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BeditActionPerformed(evt);
            }
        });

        Bhapus.setBackground(new java.awt.Color(0, 102, 102));
        Bhapus.setFont(new java.awt.Font("Trebuchet MS", 1, 16)); // NOI18N
        Bhapus.setForeground(new java.awt.Color(255, 255, 255));
        Bhapus.setText("Hapus");
        Bhapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BhapusActionPerformed(evt);
            }
        });

        TBL.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "No", "Kode Barang", "Nama Barang", "Supplier", "Harga Beli", "Jumlah"
            }
        ));
        TBL.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TBLMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(TBL);

        jPanel2.setBackground(new java.awt.Color(255, 153, 102));

        jLabel1.setFont(new java.awt.Font("Trebuchet MS", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Transaksi Barang Masuk");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(54, 54, 54)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 289, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(49, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34))
        );

        btnCetak.setBackground(new java.awt.Color(0, 102, 102));
        btnCetak.setFont(new java.awt.Font("Trebuchet MS", 1, 16)); // NOI18N
        btnCetak.setForeground(new java.awt.Color(255, 255, 255));
        btnCetak.setText("Cetak");
        btnCetak.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCetakActionPerformed(evt);
            }
        });

        nm_brg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nm_brgActionPerformed(evt);
            }
        });

        Cari.setBackground(new java.awt.Color(0, 102, 102));
        Cari.setFont(new java.awt.Font("Trebuchet MS", 1, 16)); // NOI18N
        Cari.setForeground(new java.awt.Color(255, 255, 255));
        Cari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CariActionPerformed(evt);
            }
        });

        reset.setBackground(new java.awt.Color(0, 102, 102));
        reset.setFont(new java.awt.Font("Trebuchet MS", 1, 16)); // NOI18N
        reset.setForeground(new java.awt.Color(255, 255, 255));
        reset.setText("Reset");
        reset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resetActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(Mencari)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(26, 26, 26)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(kd_brg, javax.swing.GroupLayout.DEFAULT_SIZE, 135, Short.MAX_VALUE)
                            .addComponent(hg_beli, javax.swing.GroupLayout.DEFAULT_SIZE, 135, Short.MAX_VALUE)
                            .addComponent(jumlah, javax.swing.GroupLayout.DEFAULT_SIZE, 135, Short.MAX_VALUE)
                            .addComponent(supplier, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(nm_brg, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(66, 66, 66)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(Bsave, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(Bhapus))
                                .addGap(35, 35, 35)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(btnCetak, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(Bedit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addComponent(Cari, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(125, 125, 125)
                        .addComponent(reset)))
                .addContainerGap(427, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 66, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Bedit, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(Bsave))
                        .addGap(22, 22, 22)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(Bhapus, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnCetak, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addComponent(reset)
                        .addGap(155, 155, 155))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(kd_brg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(19, 19, 19)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(nm_brg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(14, 14, 14)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(supplier, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(hg_beli, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(17, 17, 17)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jumlah, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Mencari, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Cari, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 0, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(196, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 4, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void kd_brgActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kd_brgActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_kd_brgActionPerformed

    private void BsaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BsaveActionPerformed
     
    try {
        Connection conn = koneksi.getConnection();

        // Simpan histori barang masuk
        String sqlInsert =
            "INSERT INTO ts_brg_msk " +
            "(kd_brg, nm_brg, supplier, hg_beli, jumlah) " +
            "VALUES (?,?,?,?,?)";

        PreparedStatement pst = conn.prepareStatement(sqlInsert);
        pst.setString(1, kd_brg.getText());
        pst.setString(2, nm_brg.getSelectedItem().toString());
        pst.setString(3, supplier.getSelectedItem().toString());
        pst.setInt(4, Integer.parseInt(hg_beli.getText()));
        pst.setInt(5, Integer.parseInt(jumlah.getText()));
        pst.executeUpdate();

        // Update stok barang
        String sqlUpdate =
            "UPDATE barang SET " +
            "Jmlh = Jmlh + ?, " +
            "hg_beli = ? " +
            "WHERE kd_brng=?";

        PreparedStatement ps2 = conn.prepareStatement(sqlUpdate);
        ps2.setInt(1, Integer.parseInt(jumlah.getText()));
        ps2.setInt(2, Integer.parseInt(hg_beli.getText()));
        ps2.setString(3, kd_brg.getText());
        ps2.executeUpdate();

        JOptionPane.showMessageDialog(null, "Data berhasil disimpan");

        tampilData();
        kosongkanForm();

    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, e.getMessage());
    }
    }//GEN-LAST:event_BsaveActionPerformed

    private void BeditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BeditActionPerformed
    

    try {

        Connection conn = koneksi.getConnection();

        String sqlLama =
            "SELECT jumlah FROM ts_brg_msk " +
            "WHERE id_masuk=?";

        PreparedStatement psLama =
            conn.prepareStatement(sqlLama);

        psLama.setInt(1, idMasuk);

        ResultSet rs = psLama.executeQuery();

        if (!rs.next()) {
            JOptionPane.showMessageDialog(
                null,
                "Data tidak ditemukan!"
            );
            return;
        }

        int jumlahLama = rs.getInt("jumlah");
        int jumlahBaru = Integer.parseInt(jumlah.getText());

        String sqlKurang =
            "UPDATE barang " +
            "SET Jmlh = Jmlh - ? " +
            "WHERE kd_brng=?";

        PreparedStatement psKurang =
            conn.prepareStatement(sqlKurang);

        psKurang.setInt(1, jumlahLama);
        psKurang.setString(2, kd_brg.getText());

        psKurang.executeUpdate();

        String sqlTambah =
            "UPDATE barang " +
            "SET Jmlh = Jmlh + ?, hg_beli=? " +
            "WHERE kd_brng=?";

        PreparedStatement psTambah =
            conn.prepareStatement(sqlTambah);

        psTambah.setInt(1, jumlahBaru);
        psTambah.setInt(2,
            Integer.parseInt(hg_beli.getText()));
        psTambah.setString(3, kd_brg.getText());

        psTambah.executeUpdate();

        String sql =
            "UPDATE ts_brg_msk SET " +
            "kd_brg=?, " +
            "nm_brg=?, " +
            "supplier=?, " +
            "hg_beli=?, " +
            "jumlah=? " +
            "WHERE id_masuk=?";

        PreparedStatement pst =
            conn.prepareStatement(sql);

        pst.setString(1, kd_brg.getText());
        pst.setString(2,
            nm_brg.getSelectedItem().toString());
        pst.setString(3,
            supplier.getSelectedItem().toString());
        pst.setInt(4,
            Integer.parseInt(hg_beli.getText()));
        pst.setInt(5, jumlahBaru);
        pst.setInt(6, idMasuk);

        pst.executeUpdate();

        JOptionPane.showMessageDialog(
            null,
            "Data berhasil diupdate"
        );

        tampilData();
        kosongkanForm();

    } catch (Exception e) {

        JOptionPane.showMessageDialog(
            null,
            e.getMessage()
        );
    }

   
        
    }//GEN-LAST:event_BeditActionPerformed

    private void BhapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BhapusActionPerformed
    

    if (idMasuk == 0) {

        JOptionPane.showMessageDialog(
            null,
            "Pilih data terlebih dahulu!"
        );

        return;
    }

    int konfirmasi = JOptionPane.showConfirmDialog(
        null,
        "Yakin ingin menghapus data?",
        "Konfirmasi",
        JOptionPane.YES_NO_OPTION
    );

    if (konfirmasi != JOptionPane.YES_OPTION) {
        return;
    }

    try {

        Connection conn = koneksi.getConnection();

        String sqlCari =
            "SELECT kd_brg, jumlah " +
            "FROM ts_brg_msk " +
            "WHERE id_masuk=?";

        PreparedStatement psCari =
            conn.prepareStatement(sqlCari);

        psCari.setInt(1, idMasuk);

        ResultSet rs = psCari.executeQuery();

        if (!rs.next()) {

            JOptionPane.showMessageDialog(
                null,
                "Data tidak ditemukan!"
            );

            return;
        }

        String kodeBarang =
            rs.getString("kd_brg");

        int jumlahLama =
            rs.getInt("jumlah");

        String sqlUpdate =
            "UPDATE barang " +
            "SET Jmlh = Jmlh - ? " +
            "WHERE kd_brng=?";

        PreparedStatement psUpdate =
            conn.prepareStatement(sqlUpdate);

        psUpdate.setInt(1, jumlahLama);
        psUpdate.setString(2, kodeBarang);

        psUpdate.executeUpdate();

        String sqlDelete =
            "DELETE FROM ts_brg_msk " +
            "WHERE id_masuk=?";

        PreparedStatement psDelete =
            conn.prepareStatement(sqlDelete);

        psDelete.setInt(1, idMasuk);

        psDelete.executeUpdate();

        JOptionPane.showMessageDialog(
            null,
            "Data berhasil dihapus"
        );

        idMasuk = 0;

        tampilData();
        kosongkanForm();

    } catch (Exception e) {

        JOptionPane.showMessageDialog(
            null,
            e.getMessage()
        );
    }

    }//GEN-LAST:event_BhapusActionPerformed

    private void TBLMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TBLMouseClicked
          int bar = TBL.getSelectedRow();

    idMasuk = Integer.parseInt(
        TBL.getValueAt(bar,0).toString()
    );

    kd_brg.setText(TBL.getValueAt(bar,1).toString());
    nm_brg.setSelectedItem(TBL.getValueAt(bar,2).toString());
    supplier.setSelectedItem(TBL.getValueAt(bar,3).toString());
    hg_beli.setText(TBL.getValueAt(bar,4).toString());
    jumlah.setText(TBL.getValueAt(bar,5).toString());
        

    }//GEN-LAST:event_TBLMouseClicked

    private void btnCetakActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCetakActionPerformed
        try {
        // 1. Mengambil koneksi database db_1 Anda
        java.sql.Connection conn = (java.sql.Connection) koneksisemua.koneksi.getConnection(); 
        
        if (conn == null) {
            javax.swing.JOptionPane.showMessageDialog(null, 
                "Gagal menyambungkan ke database db_1!", 
                "Error Koneksi", 
                javax.swing.JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        // 2. PERBAIKAN: Jalur file diarahkan tepat ke file cetakan Barang Masuk yang baru
        String reportPath = "src/laporan/barangmasuk.jasper"; 
        
        // 3. Menyiapkan parameter kosong untuk query utama tabel ts_brg_msk
        java.util.HashMap<String, Object> parameters = new java.util.HashMap<>();
        
        // 4. Memproses kompilasi data ke dalam template laporan baru
        net.sf.jasperreports.engine.JasperPrint print = 
            net.sf.jasperreports.engine.JasperFillManager.fillReport(reportPath, parameters, conn);
            
        // 5. Menampilkan jendela pratinjau cetak (JasperViewer)
        net.sf.jasperreports.view.JasperViewer.viewReport(print, false);
        
    } catch (Exception e) {
        javax.swing.JOptionPane.showMessageDialog(null, 
            "Gagal menampilkan laporan baru!\nError: " + e.getMessage(), 
            "Error Cetak", 
            javax.swing.JOptionPane.ERROR_MESSAGE);
    }
    }//GEN-LAST:event_btnCetakActionPerformed

    private void nm_brgActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nm_brgActionPerformed
        try {
        Connection conn = koneksi.getConnection();

        String sql = "SELECT kd_brng, hg_beli FROM barang WHERE n_brng=?";
PreparedStatement ps = conn.prepareStatement(sql);
ps.setString(1, nm_brg.getSelectedItem().toString());

ResultSet rs = ps.executeQuery();

if (rs.next()) {
    kd_brg.setText(rs.getString("kd_brng"));
    hg_beli.setText(rs.getString("hg_beli"));
}

    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, e.getMessage());
    }

    }//GEN-LAST:event_nm_brgActionPerformed

    private void CariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CariActionPerformed
                    String cariData = Mencari.getText().toLowerCase(); // ← pakai tf_cari

    for (int i = 0; i < TBL.getRowCount(); i++) { // ← pakai tbl_supplier
        String KDBarang  = TBL.getValueAt(i, 0).toString().toLowerCase();
        String NMBarang  = TBL.getValueAt(i, 1).toString().toLowerCase();
        String Supplier = TBL.getValueAt(i, 2).toString().toLowerCase();
        String HGBeli  = TBL.getValueAt(i, 3).toString().toLowerCase();
        String Jumlah  = TBL.getValueAt(i, 4).toString().toLowerCase();

        if (KDBarang.contains(cariData) ||
            NMBarang.contains(cariData) ||
            Supplier.contains(cariData) ||
            HGBeli.contains(cariData) ||    
            Jumlah.contains(cariData)) {
                

            TBL.setRowSelectionInterval(i, i);
            kd_brg.setText(TBL.getValueAt(i, 0).toString());
            nm_brg.setSelectedItem(TBL.getValueAt(i, 1).toString());
            supplier.setSelectedItem(TBL.getValueAt(i, 2).toString());
            hg_beli.setText(TBL.getValueAt(i, 3).toString());
            jumlah.setText(TBL.getValueAt(i, 4).toString());

            JOptionPane.showMessageDialog(null, "Data ditemukan");
            return;
        }
    }
    JOptionPane.showMessageDialog(null, "Data tidak ditemukan");
                  

                                   

    }//GEN-LAST:event_CariActionPerformed

    private void resetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resetActionPerformed
      kosongkanForm();
     tampilSupplier();
     tampilNamaBarang();
               
       TBL.clearSelection();

   
    }//GEN-LAST:event_resetActionPerformed

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
            java.util.logging.Logger.getLogger(ts_barang_masuk.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ts_barang_masuk.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ts_barang_masuk.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ts_barang_masuk.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ts_barang_masuk().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Bedit;
    private javax.swing.JButton Bhapus;
    private javax.swing.JButton Bsave;
    private javax.swing.JButton Cari;
    private javax.swing.JTextField Mencari;
    private javax.swing.JTable TBL;
    private javax.swing.JButton btnCetak;
    private javax.swing.JTextField hg_beli;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jumlah;
    private javax.swing.JTextField kd_brg;
    private javax.swing.JComboBox<String> nm_brg;
    private javax.swing.JButton reset;
    private javax.swing.JComboBox<String> supplier;
    // End of variables declaration//GEN-END:variables

 
}
    
