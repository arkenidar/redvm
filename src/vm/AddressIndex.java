package vm;

public class AddressIndex {
    private int addressIndex;

    public AddressIndex(int addressIndex) {
        this.addressIndex = addressIndex;
    }

    public int getValue() {
        return addressIndex;
    }

    public String toString() {
        return String.valueOf(addressIndex);
    }
}
