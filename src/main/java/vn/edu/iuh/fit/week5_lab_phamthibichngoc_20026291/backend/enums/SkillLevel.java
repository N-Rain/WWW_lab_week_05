package vn.edu.iuh.fit.week5_lab_phamthibichngoc_20026291.backend.enums;

public enum SkillLevel {
    MASTER(5),

    PROFESSIONAL(4),

    ADVANCED(3),

    IMTERMEDIATE(2),

    BEGINER(1);

    private final int value;
    SkillLevel(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
