package vm;

import java.util.BitSet;

public class Memory {
    private final int size;
    private BitSet bitset;

    public Memory(int size) {
        this(size, new BitSet());
    }

    public Memory(int size, BitSet memoryBitset) throws IndexOutOfBoundsException {
        this.size = size;
        bitset = memoryBitset;
        if (bitset.length() > size) {
            throw new IndexOutOfBoundsException();
        }
    }

    public boolean hasAddressIndex(AddressIndex addressIndex) {
        try {
            @SuppressWarnings("unused")
			boolean bit = getBit(addressIndex);
        } catch (IndexOutOfBoundsException e) {
            return false;
        }
        return true;
    }

    public boolean isAddressValid(AddressIndex addressIndex){
        final int address = addressIndex.getValue();
        boolean isAddressValid = address >= 0 && address < size;
        return isAddressValid;
    }

    public boolean getBit(AddressIndex addressIndex) throws IndexOutOfBoundsException {
        if(!isAddressValid(addressIndex)) throw new IndexOutOfBoundsException();
        return bitset.get(addressIndex.getValue());
    }

    public void setBit(AddressIndex addressIndex, boolean bit) throws IndexOutOfBoundsException {
        if(!isAddressValid(addressIndex)) throw new IndexOutOfBoundsException();
        bitset.set(addressIndex.getValue(), bit);
    }
}
