package vm;

public class Instructions {

    private Instruction[] instructions;

    public Instructions(Instruction[] instructions, Program program) throws Exception {
        this.instructions = instructions;
        for (Instruction instruction : instructions) {
            instruction.setProgram(program);
        }
    }

    public void checkProgramIntegrity() throws ProgramIntegrityException {
        for (Instruction instruction : instructions) {
            instruction.checkIntegrity();
        }
    }

    public boolean hasInstructionAtIndex(int instructionIndex) {
        try {
            @SuppressWarnings("unused")
			Instruction instruction = instructions[instructionIndex];
        } catch (IndexOutOfBoundsException exception) {
            return false;
        }
        return true;
    }

    public Instruction getInstructionAtIndex(int instructionIndex) {
        return instructions[instructionIndex];
    }
}
