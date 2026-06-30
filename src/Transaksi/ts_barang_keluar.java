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
 * @author USER
 */

public class ts_barang_keluar extends javax.swing.JFrame {
private Connection conn = new koneksi().getConnection();
    private DefaultTableModel tabmode;
    private javax.swing.JFrame parentFrame;
    private int idKeluar = 0;
    /**
     * Creates new form ts_barang_keluar
     */
        public ts_barang_keluar() {
        initComponents();
        tampilData();
        tampilNamaBarang(); 
        tampilPetugas();
        tampilData();
        tampilNamaBarang();
        tampilPetugas();
        tampilPembeli();
        kd_brg.setEditable(false);
        
        
        
    
   
 
        // ✅ Auto-fill harga jual dari supplier saat nama barang dipilih
   nm_brg.addActionListener(new java.awt.event.ActionListener() {
    @Override
    public void actionPerformed(java.awt.event.ActionEvent evt) {
        if (nm_brg.getSelectedItem() != null) {
            isiDataBarang();
        }
    }
});
    }
    // ✅ Auto-fill: cari pembeli berdasarkan nama yang diketik
private void tampilPembeli() {
    try {
        Connection conn = koneksi.getConnection();
        Statement st = conn.createStatement();

        ResultSet rs = st.executeQuery(
            "SELECT nm_pembeli FROM pembeli ORDER BY nm_pembeli ASC"
        );

        nm_pembeli.removeAllItems();

        while (rs.next()) {
            nm_pembeli.addItem(rs.getString("nm_pembeli"));
        }

    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, e.getMessage());
    }
}
    private void tampilPetugas() {
    try {
        Connection conn = koneksi.getConnection();
        Statement st = conn.createStatement();

        ResultSet rs = st.executeQuery(
            "SELECT nama_petugas FROM db_petugas ORDER BY nama_petugas ASC"
        );

        nm_petugas.removeAllItems();

        while (rs.next()) {
            nm_petugas.addItem(rs.getString("nama_petugas"));
        }

    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, e.getMessage());
    }
}
    
    private void isiKodeBarang() {
    try {
        String sql = "SELECT kd_brng FROM barang WHERE n_brng = ?";
        PreparedStatement pst = conn.prepareStatement(sql);
        pst.setString(1, nm_brg.getSelectedItem().toString());

        ResultSet rs = pst.executeQuery();

        if (rs.next()) {
            kd_brg.setText(rs.getString("kd_brng"));
        } else {
            kd_brg.setText("");
        }

    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, e.getMessage());
    }
}
 
    // ✅ Auto-fill: isi harga jual dari tabel supplier berdasarkan barang dipilih
    private void isiHargaJual() {
    try {
        String sql = "SELECT hg_jual FROM barang WHERE n_brng=?";
        PreparedStatement pst = conn.prepareStatement(sql);
        pst.setString(1, nm_brg.getSelectedItem().toString());

        ResultSet rs = pst.executeQuery();

        if (rs.next()) {
            hg_jual.setText(rs.getString("hg_jual"));
        } else {
            hg_jual.setText("");
        }
    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, e.getMessage());
    }
}  
    
    private void isiDataBarang() {
    try {
        String sql = "SELECT kd_brng, hg_jual FROM barang WHERE n_brng = ?";
        PreparedStatement pst = conn.prepareStatement(sql);
        pst.setString(1, nm_brg.getSelectedItem().toString());

        ResultSet rs = pst.executeQuery();

        if (rs.next()) {
            kd_brg.setText(rs.getString("kd_brng"));
            hg_jual.setText(rs.getString("hg_jual"));
        } else {
            kd_brg.setText("");
            hg_jual.setText("");
        }

    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, e.getMessage());
    }
}
    
  private void kosongkanForm() {
    nm_brg.setSelectedIndex(0);
    if (nm_petugas.getItemCount() > 0) {
    nm_petugas.setSelectedIndex(0);
    nm_pembeli.setSelectedIndex(0);
}
    hg_jual.setText("");
    jm_keluar.setText("");
    kd_brg.setText("");
}
        
    private void tampilNamaBarang() {
    try {
        Connection conn = koneksi.getConnection();
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery(
          "  SELECT n_brng FROM barang ORDER BY n_brng ASC"
        );

        nm_brg.removeAllItems();

        while (rs.next()) {
            nm_brg.addItem(rs.getString("n_brng"));
        }

    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, e.getMessage());
    }
}
    
private void tampilData() {
        DefaultTableModel model = new DefaultTableModel();
       model.addColumn("No");
model.addColumn("Kode Barang");
model.addColumn("Nama Barang");
model.addColumn("Nama Petugas");
model.addColumn("Nama Pembeli");
model.addColumn("Harga Jual");
model.addColumn("Jumlah Keluar");
        try {
            Connection conn = koneksi.getConnection();
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM ts_brg_klr");

            while (rs.next()) {
            model.addRow(new Object[]{
   rs.getInt("id_keluar"),
    rs.getString("kd_brg"),
    rs.getString("nm_brg"),
    rs.getString("nm_petugas"),
    rs.getString("nm_pembeli"),
    rs.getString("hg_jual"),
    rs.getString("jm_keluar")
});
            }
           
            TBL.setModel(model);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
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
        kd_brg = new javax.swing.JTextField();
        hg_jual = new javax.swing.JTextField();
        jm_keluar = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        Bsave = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        Bedit = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        Bhapus = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        TBL = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        nm_brg = new javax.swing.JComboBox<>();
        btnCetakKeluaran = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        nm_petugas = new javax.swing.JComboBox<>();
        nm_pembeli = new javax.swing.JComboBox<>();
        Mencari = new javax.swing.JTextField();
        Cari = new javax.swing.JButton();
        reset = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 204, 153));

        kd_brg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kd_brgActionPerformed(evt);
            }
        });

        hg_jual.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hg_jualActionPerformed(evt);
            }
        });

        jm_keluar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jm_keluarActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Trebuchet MS", 1, 16)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Kode Barang   :");

        jLabel3.setFont(new java.awt.Font("Trebuchet MS", 1, 16)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Nama Barang  :");

        Bsave.setBackground(new java.awt.Color(0, 102, 102));
        Bsave.setFont(new java.awt.Font("Trebuchet MS", 1, 16)); // NOI18N
        Bsave.setForeground(new java.awt.Color(255, 255, 255));
        Bsave.setText("Save");
        Bsave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BsaveActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Trebuchet MS", 1, 16)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Harga Jual      :");

        Bedit.setBackground(new java.awt.Color(0, 102, 102));
        Bedit.setFont(new java.awt.Font("Trebuchet MS", 1, 16)); // NOI18N
        Bedit.setForeground(new java.awt.Color(255, 255, 255));
        Bedit.setText("Edit");
        Bedit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BeditActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Trebuchet MS", 1, 16)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Jumlah Keluar :");

        Bhapus.setBackground(new java.awt.Color(0, 102, 102));
        Bhapus.setFont(new java.awt.Font("Trebuchet MS", 1, 16)); // NOI18N
        Bhapus.setForeground(new java.awt.Color(255, 255, 255));
        Bhapus.setText("Hapus");
        Bhapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BhapusActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Trebuchet MS", 1, 16)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Nama Petugas :");

        TBL.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "No", "Kode Barang", "Nama Barang", "Nama Petugas", "Nama Pembeli", "Harga Jual", "Jumlah Keluar"
            }
        ));
        TBL.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TBLMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(TBL);

        jPanel2.setBackground(new java.awt.Color(255, 153, 102));

        jLabel1.setFont(new java.awt.Font("Trebuchet MS", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Transaksi Barang Keluar");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(59, 59, 59)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 291, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(36, Short.MAX_VALUE))
        );

        btnCetakKeluaran.setBackground(new java.awt.Color(0, 102, 102));
        btnCetakKeluaran.setFont(new java.awt.Font("Trebuchet MS", 1, 16)); // NOI18N
        btnCetakKeluaran.setForeground(new java.awt.Color(255, 255, 255));
        btnCetakKeluaran.setText("Cetak");
        btnCetakKeluaran.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCetakKeluaranActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Trebuchet MS", 1, 16)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Nama Pembeli :");

        Cari.setBackground(new java.awt.Color(0, 102, 102));
        Cari.setFont(new java.awt.Font("Trebuchet MS", 1, 16)); // NOI18N
        Cari.setForeground(new java.awt.Color(255, 255, 255));
        Cari.setText("Cari");
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
            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(0, 0, Short.MAX_VALUE)))
                                .addGap(30, 30, 30))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(hg_jual, javax.swing.GroupLayout.DEFAULT_SIZE, 147, Short.MAX_VALUE)
                            .addComponent(jm_keluar, javax.swing.GroupLayout.DEFAULT_SIZE, 147, Short.MAX_VALUE)
                            .addComponent(nm_brg, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(kd_brg)
                            .addComponent(nm_petugas, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(nm_pembeli, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 83, Short.MAX_VALUE)
                        .addComponent(Mencari, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(36, 36, 36)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(Bhapus, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Bedit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Bsave, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnCetakKeluaran, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Cari, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(reset, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(29, 29, 29)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 721, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(53, 53, 53)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(nm_brg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(kd_brg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(15, 15, 15)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(hg_jual, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(nm_petugas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(nm_pembeli, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jm_keluar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(99, 99, 99)
                        .addComponent(Bedit, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Bhapus)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Bsave)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnCetakKeluaran)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(reset))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(53, 53, 53)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Mencari, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Cari))
                .addContainerGap(180, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void kd_brgActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kd_brgActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_kd_brgActionPerformed

    private void hg_jualActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hg_jualActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_hg_jualActionPerformed

    private void jm_keluarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jm_keluarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jm_keluarActionPerformed

    private void BeditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BeditActionPerformed

    try {

        Connection conn = koneksi.getConnection();

        // Ambil data lama berdasarkan ID
        String sqlLama =
            "SELECT jm_keluar, kd_brg " +
            "FROM ts_brg_klr " +
            "WHERE id_keluar=?";

        PreparedStatement psLama =
            conn.prepareStatement(sqlLama);

        psLama.setInt(1, idKeluar);

        ResultSet rs = psLama.executeQuery();

        if (!rs.next()) {
            JOptionPane.showMessageDialog(
                null,
                "Data tidak ditemukan!"
            );
            return;
        }

        int jumlahLama = rs.getInt("jm_keluar");
        int jumlahBaru = Integer.parseInt(jm_keluar.getText());

        // Kembalikan stok lama
        String sqlKembali =
            "UPDATE barang " +
            "SET Jmlh = Jmlh + ? " +
            "WHERE kd_brng=?";

        PreparedStatement psKembali =
            conn.prepareStatement(sqlKembali);

        psKembali.setInt(1, jumlahLama);
        psKembali.setString(2, kd_brg.getText());

        psKembali.executeUpdate();

        // Cek stok terbaru
        String sqlCek =
            "SELECT Jmlh FROM barang WHERE kd_brng=?";

        PreparedStatement psCek =
            conn.prepareStatement(sqlCek);

        psCek.setString(1, kd_brg.getText());

        ResultSet rsCek = psCek.executeQuery();
        rsCek.next();

        int stok = rsCek.getInt("Jmlh");

        if (jumlahBaru > stok) {

            // balikin lagi stok seperti semula
            String sqlBalik =
                "UPDATE barang " +
                "SET Jmlh = Jmlh - ? " +
                "WHERE kd_brng=?";

            PreparedStatement psBalik =
                conn.prepareStatement(sqlBalik);

            psBalik.setInt(1, jumlahLama);
            psBalik.setString(2, kd_brg.getText());

            psBalik.executeUpdate();

            JOptionPane.showMessageDialog(
                null,
                "Stok tidak mencukupi!"
            );

            return;
        }

        // Kurangi stok sesuai jumlah baru
        String sqlKurang =
            "UPDATE barang " +
            "SET Jmlh = Jmlh - ? " +
            "WHERE kd_brng=?";

        PreparedStatement psKurang =
            conn.prepareStatement(sqlKurang);

        psKurang.setInt(1, jumlahBaru);
        psKurang.setString(2, kd_brg.getText());

        psKurang.executeUpdate();

        // Update transaksi berdasarkan ID
        String sql =
            "UPDATE ts_brg_klr SET " +
            "kd_brg=?, " +
            "nm_brg=?, " +
            "nm_petugas=?, " +
            "nm_pembeli=?, " +
            "hg_jual=?, " +
            "jm_keluar=? " +
            "WHERE id_keluar=?";

        PreparedStatement pst =
            conn.prepareStatement(sql);

        pst.setString(1, kd_brg.getText());
        pst.setString(2, nm_brg.getSelectedItem().toString());
        pst.setString(3, nm_petugas.getSelectedItem().toString());
        pst.setString(4, nm_pembeli.getSelectedItem().toString());
        pst.setInt(5, Integer.parseInt(hg_jual.getText()));
        pst.setInt(6, jumlahBaru);
        pst.setInt(7, idKeluar);

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

    private void BsaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BsaveActionPerformed
    try {
    Connection conn = koneksi.getConnection();

    // 1. Cek stok
    String cek = "SELECT Jmlh FROM barang WHERE n_brng=?";
    PreparedStatement ps = conn.prepareStatement(cek);
    ps.setString(1, nm_brg.getSelectedItem().toString());

    ResultSet rs = ps.executeQuery();

    if (!rs.next()) {
        JOptionPane.showMessageDialog(null, "Barang tidak ditemukan!");
        return;
    }

    int stok = rs.getInt("Jmlh");
    int keluar = Integer.parseInt(jm_keluar.getText());
if(keluar > stok){
    JOptionPane.showMessageDialog(
        null,
        "Stok tidak mencukupi!");
    return;
}

    // 2. Simpan transaksi
    String sql =
        "INSERT INTO ts_brg_klr (kd_brg, nm_brg, nm_petugas, hg_jual, nm_pembeli, jm_keluar) VALUES (?,?,?,?,?,?)";

    PreparedStatement pst = conn.prepareStatement(sql);
    pst.setString(1, kd_brg.getText());
    pst.setString(2, nm_brg.getSelectedItem().toString());
    pst.setString(3, nm_petugas.getSelectedItem().toString());
    pst.setString(4, hg_jual.getText());
    pst.setString(5, nm_pembeli.getSelectedItem().toString());
    pst.setString(6, jm_keluar.getText());
    pst.executeUpdate();

            String update =
          "UPDATE barang " +
          "SET Jmlh = Jmlh - ? " +
          "WHERE kd_brng=?";

          PreparedStatement ps2 =
          conn.prepareStatement(update);

          ps2.setInt(1,
          Integer.parseInt(jm_keluar.getText()));

          ps2.setString(2,
          kd_brg.getText());

          ps2.executeUpdate();

    JOptionPane.showMessageDialog(null, "Data berhasil disimpan");

    tampilData();
    kosongkanForm();

} catch (Exception e) {
    JOptionPane.showMessageDialog(null, e.getMessage());
}
    }//GEN-LAST:event_BsaveActionPerformed

    private void BhapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BhapusActionPerformed

    if (idKeluar == 0) {
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
            "SELECT kd_brg, jm_keluar " +
            "FROM ts_brg_klr " +
            "WHERE id_keluar=?";

        PreparedStatement psCari =
            conn.prepareStatement(sqlCari);

        psCari.setInt(1, idKeluar);

        ResultSet rs = psCari.executeQuery();

        if (!rs.next()) {
            JOptionPane.showMessageDialog(
                null,
                "Data tidak ditemukan!"
            );
            return;
        }

        String kodeBarang = rs.getString("kd_brg");
        int jumlahKeluar = rs.getInt("jm_keluar");

        // Kembalikan stok
        String sqlUpdate =
            "UPDATE barang " +
            "SET Jmlh = Jmlh + ? " +
            "WHERE kd_brng=?";

        PreparedStatement psUpdate =
            conn.prepareStatement(sqlUpdate);

        psUpdate.setInt(1, jumlahKeluar);
        psUpdate.setString(2, kodeBarang);

        psUpdate.executeUpdate();

        // Hapus berdasarkan ID
        String sqlDelete =
            "DELETE FROM ts_brg_klr " +
            "WHERE id_keluar=?";

        PreparedStatement psDelete =
            conn.prepareStatement(sqlDelete);

        psDelete.setInt(1, idKeluar);

        psDelete.executeUpdate();

        JOptionPane.showMessageDialog(
            null,
            "Data berhasil dihapus"
        );

        idKeluar = 0;
        
        tampilData();
        kosongkanForm();

    } catch (Exception e) {

        JOptionPane.showMessageDialog(
            null,
            e.getMessage()
        );

    }


    }//GEN-LAST:event_BhapusActionPerformed

    private void btnCetakKeluaranActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCetakKeluaranActionPerformed
        try {
     
        java.sql.Connection conn = (java.sql.Connection) koneksisemua.koneksi.getConnection(); 
        
       
        if (conn == null) {
            javax.swing.JOptionPane.showMessageDialog(null, "Gagal menyambungkan ke database db_1!", "Error", javax.swing.JOptionPane.ERROR_MESSAGE);
            return;
        }
        
       
        String reportPath = "src/laporan/barangkeluar.jasper"; 
        
      
        java.util.HashMap<String, Object> parameters = new java.util.HashMap<>();
        
      
        net.sf.jasperreports.engine.JasperPrint print = 
            net.sf.jasperreports.engine.JasperFillManager.fillReport(reportPath, parameters, conn);
            
    
        net.sf.jasperreports.view.JasperViewer.viewReport(print, false);
        
    } catch (Exception e) {
        javax.swing.JOptionPane.showMessageDialog(null, 
            "Gagal menampilkan laporan barang keluar!\nError: " + e.getMessage(), 
            "Error Cetak", 
            javax.swing.JOptionPane.ERROR_MESSAGE);
    }
    }//GEN-LAST:event_btnCetakKeluaranActionPerformed

    private void TBLMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TBLMouseClicked
      int baris = TBL.getSelectedRow();

idKeluar = Integer.parseInt(
    TBL.getValueAt(baris,0).toString()
);

kd_brg.setText(TBL.getValueAt(baris,1).toString());
nm_brg.setSelectedItem(TBL.getValueAt(baris,2).toString());
nm_petugas.setSelectedItem(TBL.getValueAt(baris,3).toString());
nm_pembeli.setSelectedItem(TBL.getValueAt(baris,4).toString());
hg_jual.setText(TBL.getValueAt(baris,5).toString());
jm_keluar.setText(TBL.getValueAt(baris,6).toString());
    }//GEN-LAST:event_TBLMouseClicked

    private void CariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CariActionPerformed
             String cariData = Mencari.getText().toLowerCase(); // ← pakai tf_cari

    for (int i = 0; i < TBL.getRowCount(); i++) { // ← pakai tbl_supplier
        String KDBarang  = TBL.getValueAt(i, 0).toString().toLowerCase();
        String NMBarang  = TBL.getValueAt(i, 1).toString().toLowerCase();
        String NMSupplier = TBL.getValueAt(i, 2).toString().toLowerCase();
        String HGJual  = TBL.getValueAt(i, 3).toString().toLowerCase();
        String NmPembeli  = TBL.getValueAt(i, 4).toString().toLowerCase();
        String JMLKeluar  = TBL.getValueAt(i, 4).toString().toLowerCase();
        if (KDBarang.contains(cariData) ||
            NMBarang.contains(cariData) ||
            NMSupplier.contains(cariData) ||
            HGJual.contains(cariData) ||
            NmPembeli.contains(cariData) ||    
            JMLKeluar.contains(cariData)) {
                

            TBL.setRowSelectionInterval(i, i);
            kd_brg.setText(TBL.getValueAt(i, 0).toString());
            nm_brg.setSelectedItem(TBL.getValueAt(i, 1).toString());
            nm_petugas.setSelectedItem(TBL.getValueAt(i, 2).toString());
            hg_jual.setText(TBL.getValueAt(i, 3).toString());
            nm_pembeli.setSelectedItem(TBL.getValueAt(i, 4).toString());
            jm_keluar.setText(TBL.getValueAt(i, 5).toString());
                
            JOptionPane.showMessageDialog(null, "Data ditemukan");
            return;
        }
    }
    JOptionPane.showMessageDialog(null, "Data tidak ditemukan");
                  

                                   

    }//GEN-LAST:event_CariActionPerformed

    private void resetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resetActionPerformed
     kosongkanForm();
     tampilPetugas();
     tampilPembeli();
               
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
            java.util.logging.Logger.getLogger(ts_barang_keluar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ts_barang_keluar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ts_barang_keluar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ts_barang_keluar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ts_barang_keluar().setVisible(true);
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
    private javax.swing.JButton btnCetakKeluaran;
    private javax.swing.JTextField hg_jual;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField jm_keluar;
    private javax.swing.JTextField kd_brg;
    private javax.swing.JComboBox<String> nm_brg;
    private javax.swing.JComboBox<String> nm_pembeli;
    private javax.swing.JComboBox<String> nm_petugas;
    private javax.swing.JButton reset;
    // End of variables declaration//GEN-END:variables
}
