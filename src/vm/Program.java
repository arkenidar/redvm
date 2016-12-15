package vm;

import java.util.Scanner;

public class Program {

    public static Scanner getScanner() {
        return scanner;
    }

    static Scanner scanner = new Scanner(System.in);

    public Program(Instruction instructions[], int memorySize) throws Exception {
        this(instructions, new Memory(memorySize));
    }

    public Program(Instruction instructions[], Memory memory) throws Exception {
        setMemory(memory);
        setInstructions(instructions);

    }

    private Memory memory;

    public Program(ProgramDefinition definition) throws Exception {
        this(definition.getInstructions(), definition.getMemorySize());
    }

    private void setMemory(Memory memory) {
        this.memory = memory;
    }

    public Memory getMemory() {
        return memory;
    }

    private Instructions instructions;

    public Instructions getInstructions() {
        return instructions;
    }

    public void setInstructions(Instruction instructions[]) throws Exception {
        if (instructions.length < 1) throw new Exception("program should have at least one instruction");
        this.instructions = new Instructions(instructions, this);
        currentInstructionPointer = new InstructionPointer(0);
        getInstructions().checkProgramIntegrity();
    }

    private InstructionPointer currentInstructionPointer;
    private boolean pathSelector;

    public void run() {
        while (step()) {
        }
    }

    public boolean step() {

        if (currentInstructionPointer.isPointingToExit()) return false;

        int instructionIndex;

        try {
            instructionIndex = currentInstructionPointer.getInstructionIndex();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

        Instruction currentInstruction = getInstructions().getInstructionAtIndex(instructionIndex);

        // read a bit
        boolean bit;
        try {
            bit = currentInstruction.getOrigin().readBitFromThisAddress();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

        // write a bit
        try {
            currentInstruction.getDestination().writeBitToThisAddress(bit);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

        // select a path
        currentInstructionPointer = pathSelector ? currentInstruction.getCaseOne() : currentInstruction.getCaseZero();

        return true;
    }

    public void setPathSelector(boolean pathSelector){
        this.pathSelector=pathSelector;
    }
}
