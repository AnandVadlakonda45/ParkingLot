package models;

public class Vehicle extends BaseEntity{
    private VehicleType vechicleType;
    private String number;

    public Vehicle(String number,VehicleType type) {
        super();
        this.number = number;
        this.vechicleType = type;
    }

    public VehicleType getVechicleType() {
        return vechicleType;
    }

    public void setVechicleType(VehicleType vechicleType) {
        this.vechicleType = vechicleType;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }
}
