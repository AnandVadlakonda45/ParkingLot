package models;

public class Vehicle extends BaseEntity{
    private VehicleType vechicleType;
    private String number;

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
