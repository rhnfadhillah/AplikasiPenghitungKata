
# Aplikasi Penghitung Kata
Tugas 5 - Muhammad Raihan Fadhillah 2210010404

## Daftar Isi
- [Deskripsi](#deskripsi)
- [Prerequisites](#prerequisites)
- [Fitur](#fitur)
- [Cara Menjalankan](#cara-menjalankan)
- [Dokumentasi](#dokumentasi)
- [Screenshots](#screenshots)
- [Contoh Penggunaan](#contoh-penggunaan)
- [Pembuat](#pembuat)

## Deskripsi
Aplikasi Penghitung Kata adalah sebuah program Java berbasis GUI yang memungkinkan pengguna untuk menghitung jumlah kata, karakter, kalimat, dan paragraf dalam teks yang dimasukkan. Selain itu, aplikasi ini juga menyediakan fitur pencarian kata dan penyimpanan hasil perhitungan ke dalam file teks.


## Prerequisites
Sebelum menjalankan aplikasi ini, pastikan Anda telah menginstal:
- Java Development Kit (JDK) versi 8 atau yang lebih baru.
- IDE seperti IntelliJ IDEA, Eclipse, atau NetBeans untuk menjalankan dan mengembangkan aplikasi.

## Fitur   
1. Menghitung jumlah kata, karakter, kalimat, dan paragraf.
2. Mencari kata dalam teks.
3. Menyimpan hasil perhitungan dan teks ke dalam file `hasil.txt`.


## Cara Menjalankan
1. Clone atau Download Repository:
    - Clone repository ini atau download sebagai ZIP dan ekstrak.

2. Buka Proyek di IDE:
    - Buka IDE Anda dan import proyek Java yang telah diunduh.

3. Jalankan Aplikasi:
    - Jalankan kelas AplikasiPenghitungKata dari IDE Anda.
  
## Dokumentasi
- Method konstruktor
``` java
 public AplikasiPenghitungKata() {
        initComponents();
        listeners();
    }
```

- Method Listeners
``` java
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
```

- Method hitung kata dan karakter
``` java
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
```

- Method hitung kata
``` java
private int hitungKata(String text) {
        Pattern pattern = Pattern.compile("\\w+");
        Matcher matcher = pattern.matcher(text);
        int jumlahKata = 0;
        while (matcher.find()) {
            jumlahKata++;
        }
        return jumlahKata;
    }
```

- Method hitung kalimat
``` java
private int hitungKalimat(String text) {
        String[] kalimat = text.split("[.!?]+");
        return kalimat.length;
    }
```

- Method hitung paragraf
``` java
 private int hitungParagraf(String text) {
        String[] paragraf = text.split("\\n+");
        return paragraf.length;
    }
```

- Method cari kata
``` java
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
```

- Method simpan ke file
``` java
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
```
## Screenshots
![Screenshot 2024-11-10 173604](https://github.com/user-attachments/assets/5ffb6623-da60-4610-83c8-c5da12ec1625)



## Contoh Penggunaan
1. Masukkan teks ke dalam wadah yang sudah disediakan.
2. Klik tombol hitung dan aplikasi akan menampilkan jumlah kata, karakter, kalimat, dan paragraf.
3. Untuk mencari kata masukkan ke dalam inputan yang berada paling atas dan klik cari. Maka program akan mencari kata yang sesuai dan menampilkan ada berapa kata tersebut dalam teks yang dimasukkan.
4. Klik tombol simpan untuk menyimpan file ke dalam `hasil.txt` yang terdapat di dalam folder project kita.


## Pembuat

- Nama : Muhammad Raihan Fadhillah
- NPM : 2210010404

