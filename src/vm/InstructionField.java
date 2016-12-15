package vm;

public abstract class InstructionField {
    @Override
    public abstract String toString();

    public abstract void checkValidity() throws ProgramIntegrityException;

    private InstructionFieldType fieldType;

    protected void setFieldType(InstructionFieldType fieldType) {
        this.fieldType = fieldType;
    }

    public InstructionFieldType getFieldType() {
        return fieldType;
    }

    private Instruction instruction;

    public void setInstruction(Instruction instruction) {
        this.instruction = instruction;
    }

    public Instruction getInstruction() {
        return instruction;
    }

}
