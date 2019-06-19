package walkingandroids;

/**
 *
 * @author fabriciobarros
 * @author aldanalouzan
 */
public class Articulation {

    private String name;
    private double flexion;
    private double rotation;
    private double voltsRequired;
    private double initialDegree;
    private double finalDegree;
    private double moveFlexion;
    private double moveRotation;
    private double initialRotation;
    private double finalRotation;
    private double representativity;
    private double voltsPerDegree;

    public Articulation() {
    }

    public Articulation(Articulation articulation) {
        this.name = articulation.getName();
        this.flexion = articulation.getFlexion();
        this.rotation = articulation.getRotation();
        this.voltsRequired = articulation.getVoltsRequired();
        this.initialDegree = articulation.getInitialDegree();
        this.finalDegree = articulation.getFinalDegree();
        this.moveFlexion = articulation.getMoveFlexion();
        this.moveRotation = articulation.getMoveRotation();
        this.initialRotation = articulation.getInitialRotation();
        this.finalRotation = articulation.getFinalRotation();
        this.voltsPerDegree = articulation.getVoltsPerDegree();
    }

    public Articulation(String name, double rotation, double voltsRequired, double moveRotation, double initialRotation, double finalRotation) {
        this.name = name;
        this.rotation = rotation;
        this.voltsRequired = voltsRequired;
        this.moveRotation = moveRotation;
        this.initialRotation = initialRotation;
        this.finalRotation = finalRotation;
        this.voltsPerDegree = this.voltsRequired / 15.0;
    }

    public Articulation(String name, double rotation, double flexion, double voltsRequired) {
        this.name = name;
        this.flexion = flexion;
        this.rotation = rotation;
        this.voltsRequired = voltsRequired;
        this.voltsPerDegree = this.voltsRequired / 15.0;
    }

    public Articulation(String name, double flexion, double voltsRequired) {
        this.name = name;
        this.flexion = flexion;
        this.voltsRequired = voltsRequired;
        this.voltsPerDegree = this.voltsRequired / 15.0;
    }

    public Articulation(String name, double flexion, double rotation, double voltsRequired, double initialDegree, double finalDegree, double moveFlexion, double moveRotation, double initialRotation, double finalRotation, double representativity) {
        this.name = name;
        this.flexion = flexion;
        this.rotation = rotation;
        this.voltsRequired = voltsRequired;
        this.initialDegree = initialDegree;
        this.finalDegree = finalDegree;
        this.moveFlexion = moveFlexion;
        this.moveRotation = moveRotation;
        this.initialRotation = initialRotation;
        this.finalRotation = finalRotation;
        this.representativity = representativity;
        this.voltsPerDegree = this.voltsRequired / 15.0;
    }

    public double getRepresentativity() {
        return representativity;
    }

    public double getInitialDegree() {
        return initialDegree;
    }

    public double getFinalDegree() {
        return finalDegree;
    }

    public double getMoveFlexion() {
        return moveFlexion;
    }

    public void setInitialDegree(double initialDegree) {
        this.initialDegree = initialDegree;
    }

    public void setFinalDegree(double finalDegree) {
        this.finalDegree = finalDegree;
    }

    public void setMoveFlexion(double moveFlexion) {
        this.moveFlexion = moveFlexion;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setFlexion(double flexion) {
        this.flexion = flexion;
    }

    public void setVoltsRequired(double voltsRequired) {
        this.voltsRequired = voltsRequired;
    }

    public String getName() {
        return name;
    }

    public double getFlexion() {
        return flexion;
    }

    public double getVoltsRequired() {
        return voltsRequired;
    }

    public void setRepresentativity(double representativity) {
        this.representativity = representativity;
    }

    public double getMoveRotation() {
        return moveRotation;
    }

    public void setMoveRotation(double moveRotation) {
        this.moveRotation = moveRotation;
    }

    public double getRotation() {
        return rotation;
    }

    public double getInitialRotation() {
        return initialRotation;
    }

    public double getFinalRotation() {
        return finalRotation;
    }

    public void setRotation(double rotation) {
        this.rotation = rotation;
    }

    public void setInitialRotation(double initialRotation) {
        this.initialRotation = initialRotation;
    }

    public void setFinalRotation(double finalRotation) {
        this.finalRotation = finalRotation;
    }

    public double getVoltsPerDegree() {
        return voltsPerDegree;
    }

    public void setVoltsPerDegree() {
        this.voltsPerDegree = this.getVoltsRequired() / 15.0;
    }

}
