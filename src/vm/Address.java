package vm;

import java.util.Scanner;

public class Address extends InstructionField {
    private AddressEnum addressEnum;
    private AddressIndex addressIndex;
    private Boolean isEnum;
    private Instruction instruction;

    public Address(AddressEnum address) {
        this.addressEnum = address;
        isEnum = true;
    }

    public Address(AddressIndex address) {
        this.addressIndex = address;
        isEnum = false;

    }

    public void setInstruction(Instruction instruction) {
        this.instruction = instruction;
    }

    public Instruction getInstruction() {
        return instruction;
    }


    private void isValidCheck(Program program) throws ProgramIntegrityException {
        if (isEnum) return;
        else {
            boolean hasAddressIndex = program.getMemory().hasAddressIndex(addressIndex);
            if (!hasAddressIndex)
                throw new ProgramIntegrityException(getFieldType(), getInstruction());
        }
    }

    @Override
    public String toString() {
        return isEnum ? String.valueOf(addressEnum) : String.valueOf(addressIndex);
    }

    @Override
    public void checkValidity() throws ProgramIntegrityException {
        isValidCheck(getInstruction().getProgram());
    }

    public boolean readBitFromThisAddress() throws Exception {

    	boolean bit = false;

        if(isEnum){
            if (addressEnum == AddressEnum.IN) {

                System.out.print("bit?    ");
                String line = Program.getScanner().next();
                
                if(line.equals("0"))
                    bit = false;
                else if(line.equals("1"))
                    bit = true;
                else
                    throw new Exception("input not valid: should be 0 or 1");
                
            }else if(addressEnum==AddressEnum.ZERO){
                bit = false;
                
            } else if(addressEnum==AddressEnum.ONE){
                bit = true;
                
            } else{
                throw new Exception("invalid AddressEnum");
            }
        }else{
            bit = getInstruction().getProgram().getMemory().getBit(addressIndex);
        }

        return bit;
    }

    public void writeBitToThisAddress(boolean bit) throws Exception {
        if (isEnum) {
            if (addressEnum.equals(AddressEnum.OUT)) {
                System.out.println("out:    " + (bit?"1":"0") );

            } else if(addressEnum.equals(AddressEnum.PATHSEL)) {
                getInstruction().getProgram().setPathSelector(bit);

            } else {
                throw new Exception("invalid AddressEnum: "+addressEnum);
            }
        } else {
            getInstruction().getProgram().getMemory().setBit(addressIndex, bit);
        }
    }
}
