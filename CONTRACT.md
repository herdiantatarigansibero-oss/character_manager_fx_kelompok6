

\# CONTRACT.md

\# Character Manager v0.7



\## 1. Tujuan Project

Mengembangkan Character Manager dari Java Swing menjadi JavaFX menggunakan FXML dan pola MVC.



\## 2. Pembagian Tugas



\### Model Manager

Branch: feature/model



\- Mengelola Character.java

\- Mengelola CharacterType.java

\- Mengelola CharacterManager.java

\- Membuat ModelCheck.java

\- Memastikan aturan bisnis berjalan dengan benar.



\### View Manager

Branch: feature/view



\- Membuat CharacterView.fxml.

\- Mengatur tampilan menggunakan JavaFX dan Scene Builder.

\- Menentukan fx:id dan tombol sesuai kesepakatan.



\### Controller Manager

Branch: feature/controller



\- Mengatur pom.xml.

\- Membuat CharacterManagerApp.java.

\- Membuat CharacterController.java.

\- Menghubungkan Model dan View.

\- Mengatur aksi tombol Save dan Reset.



\## 3. Kesepakatan FXML



\- nameField

\- typeComboBox

\- levelField

\- characterContainer

\- averageLevelLabel

\- statusLabel

\- saveButton

\- resetButton



Event:

\- handleSave()

\- handleReset()



\## 4. Kesepakatan Model



\- Character

\- CharacterType

\- CharacterManager

\- getAverageLevel() mengembalikan 0 jika data kosong.

\- Model tidak menggunakan import JavaFX atau Swing.



\## 5. Kesepakatan Controller



\- initialize()

\- setManager()

\- handleSave()

\- handleReset()

\- refreshList()



\## 6. Git Workflow



\- main sebagai branch utama.

\- Setiap anggota bekerja pada branch masing-masing.

\- Dilarang commit langsung ke main tanpa kesepakatan.

\- Minimal 5 commit bermakna setiap anggota.

\- Minimal 2 Pull Request setiap anggota.

\- Setiap PR harus melalui review.



\## 7. Menjalankan Aplikasi



mvn clean javafx:run



