package vm;

import static vm.InstructionFieldType.*;
import static vm.InstructionFieldType.CASE_ZERO;

public class Instruction {

    private Address destination;
    private Address origin;
    private InstructionPointer caseZero;
    private InstructionPointer caseOne;

    private Program program;

    public Instruction(Address destination, Address origin,
                       InstructionPointer caseZero, InstructionPointer caseOne) {
        setDestination(destination);
        setOrigin(origin);
        setCaseZero(caseZero);
        setCaseOne(caseOne);
    }

    public void setDestination(Address destination) {
        this.destination = destination;
        destination.setInstruction(this);
        destination.setFieldType(DESTINATION);
    }

    public Address getDestination() {
        return destination;
    }

    public void setOrigin(Address origin) {
        this.origin = origin;
        origin.setInstruction(this);
        origin.setFieldType(ORIGIN);
    }

    public Address getOrigin() {
        return origin;
    }

    public void setCaseZero(InstructionPointer caseZero) {
        this.caseZero = caseZero;
        caseZero.setInstruction(this);
        caseZero.setFieldType(CASE_ZERO);
    }

    public InstructionPointer getCaseZero() {
        return caseZero;
    }

    public void setCaseOne(InstructionPointer caseOne) {
        this.caseOne = caseOne;
        caseOne.setInstruction(this);
        caseOne.setFieldType(CASE_ONE);
    }

    public InstructionPointer getCaseOne() {
        return caseOne;
    }

    public void setProgram(Program program) {
        this.program = program;
    }

    public Program getProgram() {
        return program;
    }

    public void checkIntegrity() throws ProgramIntegrityException {
        destination.checkValidity();
        origin.checkValidity();
        caseZero.checkValidity();
        caseOne.checkValidity();
    }

    public InstructionField getField(InstructionFieldType field) {
        switch (field) {
            case ORIGIN:
                return origin;
            case DESTINATION:
                return destination;
            case CASE_ZERO:
                return caseZero;
            case CASE_ONE:
                return caseOne;
        }
        return null;
    }
}
