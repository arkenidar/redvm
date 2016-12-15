package vm;

public class InstructionIndex {
    private Integer instructionIndex;

    public InstructionIndex(Integer instructionIndex) {
        this.instructionIndex = instructionIndex;
    }

    public Boolean checkIndexValidity(Program program) {
        return program.getInstructions().hasInstructionAtIndex(instructionIndex);
    }
}
