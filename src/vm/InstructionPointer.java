package vm;

public class InstructionPointer extends InstructionField {

    private InstructionEnum instructionEnum;
    private Integer instructionIndex;
    boolean isEnum;

    public InstructionPointer(InstructionEnum instruction) {
        this.instructionEnum = instruction;
        isEnum = true;
    }

    public InstructionPointer(Integer instruction) {
        this.instructionIndex = instruction;
        isEnum = false;
    }

    private void isValidCheck(Program program) throws ProgramIntegrityException {
        if (isEnum) return;
        else {
            boolean hasInstructionAtIndex = program.getInstructions().hasInstructionAtIndex(instructionIndex);
            if (!hasInstructionAtIndex) {
                throw new ProgramIntegrityException(getFieldType(), getInstruction());
            }
        }
    }

    @Override
    public String toString() {
        return isEnum ? String.valueOf(instructionEnum) : String.valueOf(instructionIndex);
    }

    @Override
    public void checkValidity() throws ProgramIntegrityException {
        isValidCheck(getInstruction().getProgram());
    }

    public boolean isPointingToExit() {
        return isEnum && instructionEnum == InstructionEnum.EXIT;
    }

    public int getInstructionIndex() throws Exception {
        if (isEnum) throw new Exception("trying to get an numerica instruction index from a named constant");
        return instructionIndex;
    }
}
