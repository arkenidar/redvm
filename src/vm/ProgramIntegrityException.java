package vm;

@SuppressWarnings("serial")
public class ProgramIntegrityException extends Exception {
    private final InstructionFieldType field;
    private final Instruction instruction;

    public ProgramIntegrityException(InstructionFieldType field, Instruction instruction) {
        this.field = field;
        this.instruction = instruction;
    }

    public String toString() {
        return "In an instruction the " + field + " is wrongly set to " + instruction.getField(field);
    }
}
