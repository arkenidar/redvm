package vm;

public class ProgramDefinition {



    int memorySize;
    Instruction[] instructions;

    public int getMemorySize() {
        return memorySize;
    }

    public void setMemorySize(int memorySize) {
        this.memorySize = memorySize;
    }

    public Instruction[] getInstructions() {
        return instructions;
    }

    public void setInstructions(Instruction[] instructions) {
        this.instructions = instructions;
    }

    ProgramDefinition(int memorySize, Instruction[] instructions){
        setMemorySize(memorySize);
        setInstructions(instructions);
    }
}
