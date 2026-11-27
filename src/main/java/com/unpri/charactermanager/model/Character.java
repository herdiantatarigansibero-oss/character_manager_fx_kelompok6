package com.unpri.charactermanager.model;

public class Character {

    private String name;
    private int level;
    private CharacterType type;

    private static int totalCharacterCreated = 0;

    public Character(String name, CharacterType type, int level) {
        validateName(name);
        validateType(type);
        validateLevel(level, type);

        this.name = name.trim();
        this.type = type;
        this.level = level;

        totalCharacterCreated++;
    }

    private void validateName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException(
                "Nama karakter wajib diisi"
            );
        }
    }

    private void validateType(CharacterType type) {
        if (type == null) {
            throw new IllegalArgumentException(
                "Role karakter wajib dipilih"
            );
        }
    }

    private void validateLevel(int level, CharacterType type) {
        if (level < 1 || level > 99) {
            throw new IllegalArgumentException(
                "Level harus antara 1 sampai 99"
            );
        }

        if (type == CharacterType.MAGE && level > 60) {
            throw new IllegalArgumentException(
                "MAGE tidak boleh memiliki level lebih dari 60"
            );
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        validateName(name);
        this.name = name.trim();
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        validateLevel(level, type);
        this.level = level;
    }

    public CharacterType getType() {
        return type;
    }

    public void setType(CharacterType type) {
        validateType(type);
        validateLevel(level, type);
        this.type = type;
    }

    public static int getTotalCharacterCreated() {
        return totalCharacterCreated;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof Character)) {
            return false;
        }

        Character other = (Character) obj;

        return name.equalsIgnoreCase(other.name);
    }

    @Override
    public String toString() {
        return name + " - " + type + " - Level " + level;
    }
}
