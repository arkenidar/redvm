package vm;

public enum InstructionFieldType {
    ORIGIN("ORIGIN"),
    DESTINATION("DESTINATION"),
    CASE_ZERO("CASE ZERO"),
    CASE_ONE("CASE ONE");

    private final String fieldName;

    private InstructionFieldType(String fieldName) {
        this.fieldName = fieldName;
    }

    public boolean equalsName(String otherName) {
        return (otherName == null) ? false : fieldName.equals(otherName);
    }

    public String toString() {
        return this.fieldName + " field";
    }
}
