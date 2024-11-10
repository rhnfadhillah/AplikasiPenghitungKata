import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author rhnfa
 */
public class AplikasiPenghitungKata extends javax.swing.JFrame {

    /**
     * Creates new form AplikasiPenghitungKata
     */
    public AplikasiPenghitungKata() {
        initComponents();
        listeners();
    }
    
    private void listeners(){
        btnHitung.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                hitungKataDanKarakter();
            }
        });
        
        btnCari.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cariKata();
            }
        });
        btnSimpan.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                simpanKeFile();
            }
        });
       
        inputArea.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                hitungKataDanKarakter();
            }
            @Override
            public void removeUpdate(DocumentEvent e) {
                hitungKataDanKarakter();
            }
            @Override
            public void changedUpdate(DocumentEvent e) {
                hitungKataDanKarakter();
            }
        });
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    
    private void hitungKataDanKarakter() {
        String text = inputArea.getText();
        int jumlahKarakter = text.length();
        int jumlahKata = hitungKata(text);
        int jumlahKalimat = hitungKalimat(text);
        int jumlahParagraf = hitungParagraf(text);
        labelJmlKata.setText("Jumlah Kata : " + jumlahKata + " Kata");
        labelJmlKarakter.setText("Jumlah Karakter : " + jumlahKarakter + " Karakter");
        labelJmlKalimat.setText("Jumlah Kalimat : " + jumlahKalimat + " Kalimat");
        labelJmlParagraf.setText("Jumlah Paragraf : " + jumlahParagraf + " Paragraf");
    }
    
    private int hitungKata(String text) {
        Pattern pattern = Pattern.compile("\\w+");
        Matcher matcher = pattern.matcher(text);
        int jumlahKata = 0;
        while (matcher.find()) {
            jumlahKata++;
        }
        return jumlahKata;
    }
    
    private int hitungKalimat(String text) {
        String[] kalimat = text.split("[.!?]+");
        return kalimat.length;
    }
    
    private int hitungParagraf(String text) {
        String[] paragraf = text.split("\\n+");
        return paragraf.length;
    }
    
    private void cariKata() {
        String kataDicari = txtCariKata.getText();
        String text = inputArea.getText();
        
        int count = 0;
        String[] words = text.split("\\W+");
        for (String word : words) {
            if (word.equalsIgnoreCase(kataDicari)) {
                count++;
            }
        }
        if (count > 0) {
            JOptionPane.showMessageDialog(this, "Kata '" + kataDicari + "' ditemukan " + count + " kali!", "Hasil Pencarian", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(this, "Kata '" + kataDicari + "' tidak ditemukan!", "Hasil Pencarian", JOptionPane.WARNING_MESSAGE);

        }
    }
    private void simpanKeFile() {
        String text = inputArea.getText();
        String hasil = labelJmlKata.getText() + "\n" + labelJmlKarakter.getText() + "\n" + labelJmlKalimat.getText() + "\n" + labelJmlParagraf.getText();
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("hasil.txt"))) {
            writer.write("Teks:\n" + text + "\n\nHasil Perhitungan:\n" + hasil);
            JOptionPane.showMessageDialog(this, "Teks dan hasil perhitungan berhasil disimpan ke 'hasil.txt'", "Simpan Berhasil", JOptionPane.INFORMATION_MESSAGE);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Gagal menyimpan ke file!", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelContainer = new javax.swing.JPanel();
        panelTxtArea = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        inputArea = new javax.swing.JTextArea();
        labelCariKata = new javax.swing.JLabel();
        txtCariKata = new javax.swing.JTextField();
        panelButton = new javax.swing.JPanel();
        btnHitung = new javax.swing.JButton();
        btnCari = new javax.swing.JButton();
        btnSimpan = new javax.swing.JButton();
        panelLabel = new javax.swing.JPanel();
        labelJmlKata = new javax.swing.JLabel();
        labelJmlKarakter = new javax.swing.JLabel();
        labelJmlKalimat = new javax.swing.JLabel();
        labelJmlParagraf = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        panelContainer.setBorder(javax.swing.BorderFactory.createTitledBorder("Aplikasi Penghitung Kata"));

        inputArea.setColumns(20);
        inputArea.setRows(5);
        jScrollPane1.setViewportView(inputArea);

        labelCariKata.setText("Cari Kata :");

        javax.swing.GroupLayout panelTxtAreaLayout = new javax.swing.GroupLayout(panelTxtArea);
        panelTxtArea.setLayout(panelTxtAreaLayout);
        panelTxtAreaLayout.setHorizontalGroup(
            panelTxtAreaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelTxtAreaLayout.createSequentialGroup()
                .addContainerGap(41, Short.MAX_VALUE)
                .addGroup(panelTxtAreaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelTxtAreaLayout.createSequentialGroup()
                        .addComponent(labelCariKata)
                        .addGap(18, 18, 18)
                        .addComponent(txtCariKata, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 834, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25))
        );
        panelTxtAreaLayout.setVerticalGroup(
            panelTxtAreaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelTxtAreaLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(panelTxtAreaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelCariKata)
                    .addComponent(txtCariKata, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 40, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 279, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        btnHitung.setText("Hitung");

        btnCari.setText("Cari");

        btnSimpan.setText("Simpan");

        javax.swing.GroupLayout panelButtonLayout = new javax.swing.GroupLayout(panelButton);
        panelButton.setLayout(panelButtonLayout);
        panelButtonLayout.setHorizontalGroup(
            panelButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelButtonLayout.createSequentialGroup()
                .addGap(115, 115, 115)
                .addComponent(btnSimpan, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnCari, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnHitung, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelButtonLayout.setVerticalGroup(
            panelButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelButtonLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnHitung)
                    .addComponent(btnCari)
                    .addComponent(btnSimpan))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        labelJmlKata.setText("Jumlah Kata : 0 Kata");

        labelJmlKarakter.setText("Jumlah Karakter : 0 Karakter");

        labelJmlKalimat.setText("Jumlah Kalimat : 0 Kalimat");

        labelJmlParagraf.setText("Jumlah Paragraf : 0 Paragraf");

        javax.swing.GroupLayout panelLabelLayout = new javax.swing.GroupLayout(panelLabel);
        panelLabel.setLayout(panelLabelLayout);
        panelLabelLayout.setHorizontalGroup(
            panelLabelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelLabelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(labelJmlKata)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(labelJmlKarakter)
                .addGap(24, 24, 24)
                .addComponent(labelJmlKalimat)
                .addGap(18, 18, 18)
                .addComponent(labelJmlParagraf)
                .addGap(103, 103, 103))
        );
        panelLabelLayout.setVerticalGroup(
            panelLabelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelLabelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(panelLabelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelJmlKata)
                    .addComponent(labelJmlKarakter)
                    .addComponent(labelJmlKalimat)
                    .addComponent(labelJmlParagraf))
                .addContainerGap())
        );

        javax.swing.GroupLayout panelContainerLayout = new javax.swing.GroupLayout(panelContainer);
        panelContainer.setLayout(panelContainerLayout);
        panelContainerLayout.setHorizontalGroup(
            panelContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelContainerLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(panelLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelTxtArea, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        panelContainerLayout.setVerticalGroup(
            panelContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelContainerLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelTxtArea, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(52, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelContainer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelContainer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(AplikasiPenghitungKata.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AplikasiPenghitungKata.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AplikasiPenghitungKata.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AplikasiPenghitungKata.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AplikasiPenghitungKata().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCari;
    private javax.swing.JButton btnHitung;
    private javax.swing.JButton btnSimpan;
    private javax.swing.JTextArea inputArea;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labelCariKata;
    private javax.swing.JLabel labelJmlKalimat;
    private javax.swing.JLabel labelJmlKarakter;
    private javax.swing.JLabel labelJmlKata;
    private javax.swing.JLabel labelJmlParagraf;
    private javax.swing.JPanel panelButton;
    private javax.swing.JPanel panelContainer;
    private javax.swing.JPanel panelLabel;
    private javax.swing.JPanel panelTxtArea;
    private javax.swing.JTextField txtCariKata;
    // End of variables declaration//GEN-END:variables
}
