public class CellularNetwork {

    private String name;
    private String[] cellIds;
    private int[] capacities;

    public CellularNetwork(String name, String[] cellIds, int[] capacities) {
        this.name = name;
        this.cellIds = cellIds;
        this.capacities = capacities;
    }

}

class CellFullException extends Exception {

    public CellFullException(String cellId) {
        super("CellFullException: {" + cellId + "}");
    }

}
