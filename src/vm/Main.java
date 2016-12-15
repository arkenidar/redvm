package vm;

public class Main {

    @SuppressWarnings("unused")
	private static ProgramDefinition getTest(){
        ProgramDefinition test = new ProgramDefinition(1,
                new Instruction[]{
                        new Instruction(
                                new Address(new AddressIndex(0)),
                                new Address(AddressEnum.ONE),
                                new InstructionPointer(InstructionEnum.EXIT),
                                new InstructionPointer(InstructionEnum.EXIT)
                        )
                }
        );
        return test;
    }

    @SuppressWarnings("unused")
	private static ProgramDefinition getNot(){
        ProgramDefinition programDefinition = new ProgramDefinition(0,
                new Instruction[]{
                        new Instruction(
                                new Address(AddressEnum.PATHSEL),
                                new Address(AddressEnum.IN),
                                new InstructionPointer(2),
                                new InstructionPointer(1)
                        ),

                        new Instruction(
                                new Address(AddressEnum.OUT),
                                new Address(AddressEnum.ZERO),
                                new InstructionPointer(0),
                                new InstructionPointer(0)
                        ),

                        new Instruction(
                                new Address(AddressEnum.OUT),
                                new Address(AddressEnum.ONE),
                                new InstructionPointer(0),
                                new InstructionPointer(0)
                        )
                }
        );
        return programDefinition;
    }

    @SuppressWarnings("unused")
    private static ProgramDefinition getArray(){
        ProgramDefinition programDefinition = new ProgramDefinition(7,
                new Instruction[]{
                        new Instruction(
                                new Address(new AddressIndex(0)),
                                new Address(AddressEnum.IN),
                                new InstructionPointer(1),
                                new InstructionPointer(1)
                        ),

                        new Instruction(
                                new Address(new AddressIndex(1)),
                                new Address(AddressEnum.IN),
                                new InstructionPointer(2),
                                new InstructionPointer(2)
                        ),

                        new Instruction(
                                new Address(new AddressIndex(2)),
                                new Address(AddressEnum.IN),
                                new InstructionPointer(3),
                                new InstructionPointer(3)
                        ),

                        new Instruction(
                                new Address(AddressEnum.PATHSEL),
                                new Address(new AddressIndex(1)),
                                new InstructionPointer(4),
                                new InstructionPointer(5)
                        ),

                        new Instruction(
                                new Address(AddressEnum.PATHSEL),
                                new Address(new AddressIndex(2)),
                                new InstructionPointer(6),
                                new InstructionPointer(7)
                        ),

                        new Instruction(
                                new Address(AddressEnum.PATHSEL),
                                new Address(new AddressIndex(2)),
                                new InstructionPointer(8),
                                new InstructionPointer(9)
                        ),

                        new Instruction(
                                new Address(new AddressIndex(3)),
                                new Address(new AddressIndex(0)),
                                new InstructionPointer(10),
                                new InstructionPointer(10)
                        ),

                        new Instruction(
                                new Address(new AddressIndex(4)),
                                new Address(new AddressIndex(0)),
                                new InstructionPointer(10),
                                new InstructionPointer(10)
                        ),

                        new Instruction(
                                new Address(new AddressIndex(5)),
                                new Address(new AddressIndex(0)),
                                new InstructionPointer(10),
                                new InstructionPointer(10)
                        ),

                        new Instruction(
                                new Address(new AddressIndex(6)),
                                new Address(new AddressIndex(0)),
                                new InstructionPointer(10),
                                new InstructionPointer(10)
                        ),

                        new Instruction(
                                new Address(AddressEnum.OUT),
                                new Address(new AddressIndex(3)),
                                new InstructionPointer(11),
                                new InstructionPointer(11)
                        ),

                        new Instruction(
                                new Address(AddressEnum.OUT),
                                new Address(new AddressIndex(4)),
                                new InstructionPointer(12),
                                new InstructionPointer(12)
                        ),

                        new Instruction(
                                new Address(AddressEnum.OUT),
                                new Address(new AddressIndex(5)),
                                new InstructionPointer(13),
                                new InstructionPointer(13)
                        ),

                        new Instruction(
                                new Address(AddressEnum.OUT),
                                new Address(new AddressIndex(6)),
                                new InstructionPointer(0),
                                new InstructionPointer(0)
                        ),
                }
        );
        return programDefinition;
    }

    public static void main(String[] args) {

        try {
            ProgramDefinition definitionToRun = getNot();
            Program program = new Program(definitionToRun);

            program.run();

            System.out.println("exit");

        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

}
