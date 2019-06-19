package walkingandroids;

/**
 *
 * @author fabriciobarros
 * @author aldanalouzan
 */
public class Battery {
    double maxVoltage = 8.0;
    double rechargeAmount = 2.6;
    double actualVoltage = 8.0;
    double holdingMotors = 1.0;

    public Battery() {
    }
    
    
    public Battery(double maxVoltage, double rechargeAmount, double actualVoltage, double holdingMotors) {
        this.maxVoltage = maxVoltage;
        this.rechargeAmount = rechargeAmount;
        this.actualVoltage = actualVoltage;
        this.holdingMotors = holdingMotors;
    }

    public double getMaxVoltage() {
        return maxVoltage;
    }

    public double getRechargeAmount() {
        return rechargeAmount;
    }

    public double getActualVoltage() {
        return actualVoltage;
    }

    public double getHoldingMotors() {
        return holdingMotors;
    }

    public void setMaxVoltage(double maxVoltage) {
        this.maxVoltage = maxVoltage;
    }

    public void setRechargeAmount(double rechargeAmount) {
        this.rechargeAmount = rechargeAmount;
    }

    public void setActualVoltage(double actualVoltage) {
        this.actualVoltage = actualVoltage;
    }

    public void setHoldingMotors(double holdingMotors) {
        this.holdingMotors = holdingMotors;
    }
    
    
    
    
}
