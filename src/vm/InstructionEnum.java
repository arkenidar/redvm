package vm;

public enum InstructionEnum {
    EXIT("EXIT");

    private final String name;

    InstructionEnum(String instructionEnumName) {
        name = instructionEnumName;
    }

    public boolean equalsName(String otherName) {
        return (otherName == null) ? false : name.equals(otherName);
    }

    public String toString() {
        return this.name;
    }
}
