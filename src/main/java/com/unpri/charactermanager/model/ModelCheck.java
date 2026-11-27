
package com.unpri.charactermanager.model;

public class ModelCheck {

    public static void main(String[] args) {

        System.out.println("==================================");
        System.out.println("     CHARACTER MANAGER v0.7");
        System.out.println("          MODEL CHECK");
        System.out.println("==================================");

        CharacterManager manager = new CharacterManager();

        int passed = 0;
        int failed = 0;

        // TEST 1: Membuat karakter valid
        try {
            Character c = new Character(
                "Alucard", CharacterType.WARRIOR, 10
            );

            if (c != null) {
                System.out.println("[PASS] Membuat karakter valid");
                passed++;
            } else {
                System.out.println("[FAIL] Membuat karakter valid");
                failed++;
            }

        } catch (Exception e) {
            System.out.println("[FAIL] Membuat karakter valid");
            failed++;
        }

        // TEST 2: Menolak nama kosong
        try {
            new Character("", CharacterType.MAGE, 10);

            System.out.println("[FAIL] Menolak nama kosong");
            failed++;

        } catch (IllegalArgumentException e) {
            System.out.println("[PASS] Menolak nama kosong");
            passed++;
        }

        // TEST 3: Menolak nama null
        try {
            new Character(null, CharacterType.MAGE, 10);

            System.out.println("[FAIL] Menolak nama null");
            failed++;

        } catch (IllegalArgumentException e) {
            System.out.println("[PASS] Menolak nama null");
            passed++;
        }

        // TEST 4: Menolak level kurang dari 1
        try {
            new Character("Miya", CharacterType.ARCHER, 0);

            System.out.println("[FAIL] Menolak level 0");
            failed++;

        } catch (IllegalArgumentException e) {
            System.out.println("[PASS] Menolak level 0");
            passed++;
        }

        // TEST 5: Menolak level lebih dari 99
        try {
            new Character("Eudora", CharacterType.MAGE, 100);

            System.out.println("[FAIL] Menolak level 100");
            failed++;

        } catch (IllegalArgumentException e) {
            System.out.println("[PASS] Menolak level 100");
            passed++;
        }

        // TEST 6: Menolak role null
        try {
            new Character("Tigreal", null, 20);

            System.out.println("[FAIL] Menolak role null");
            failed++;

        } catch (IllegalArgumentException e) {
            System.out.println("[PASS] Menolak role null");
            passed++;
        }

        // TEST 7: Menambahkan karakter
        Character c1 = new Character(
            "Alucard", CharacterType.WARRIOR, 10
        );

        try {
            manager.addCharacter(c1);

            if (manager.getTotalCharacters() == 1) {
                System.out.println("[PASS] Menambahkan karakter");
                passed++;
            } else {
                System.out.println("[FAIL] Menambahkan karakter");
                failed++;
            }

        } catch (Exception e) {
            System.out.println("[FAIL] Menambahkan karakter");
            failed++;
        }

        // TEST 8: Menolak nama duplikat
        try {
            Character c2 = new Character(
                "Alucard", CharacterType.MAGE, 20
            );

            manager.addCharacter(c2);

            System.out.println("[FAIL] Menolak karakter duplikat");
            failed++;

        } catch (IllegalArgumentException e) {
            System.out.println("[PASS] Menolak karakter duplikat");
            passed++;
        }

        // TEST 9: Menghitung jumlah karakter
        if (manager.getTotalCharacters() == 1) {
            System.out.println("[PASS] Menghitung jumlah karakter");
            passed++;
        } else {
            System.out.println("[FAIL] Menghitung jumlah karakter");
            failed++;
        }

        // TEST 10: Menghitung rata-rata level
        Character c3 = new Character(
            "Miya", CharacterType.ARCHER, 20
        );

        manager.addCharacter(c3);

        if (Math.abs(manager.getAverageLevel() - 15.0) < 0.0001) {
            System.out.println("[PASS] Menghitung rata-rata level");
            passed++;
        } else {
            System.out.println("[FAIL] Menghitung rata-rata level");
            failed++;
        }

        // TEST 11: Rata-rata level saat data kosong
        CharacterManager emptyManager = new CharacterManager();

        if (emptyManager.getAverageLevel() == 0) {
            System.out.println("[PASS] Rata-rata level saat kosong");
            passed++;
        } else {
            System.out.println("[FAIL] Rata-rata level saat kosong");
            failed++;
        }

        // HASIL AKHIR
        System.out.println("----------------------------------");
        System.out.println("Total pengujian : " + (passed + failed));
        System.out.println("Berhasil        : " + passed);
        System.out.println("Gagal           : " + failed);
        System.out.println("----------------------------------");

        if (failed == 0) {
            System.out.println("SEMUA PENGUJIAN BERHASIL!");
        } else {
            System.out.println("MASIH ADA PENGUJIAN YANG GAGAL!");
        }

        System.out.println("==================================");
    }
}
