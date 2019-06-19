package walkingandroids;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;
import java.util.ArrayList;
import static walkingandroids.FormatColors.*;

/**
 *
 * @author
 * @author
 * @author
 */
public class Android implements Movement {

    private Ankle leftAnkle;
    private Ankle rightAnkle;
    private Elbow leftElbow;
    private Elbow rightElbow;
    private Head head;
    private Hip leftHip;
    private Hip rightHip;
    private Knee leftKnee;
    private Knee rightKnee;
    private Neck neck;
    private Shoulder leftShoulder;
    private Shoulder rightShoulder;
    private Waist waist;
    private Wrist leftWrist;
    private Wrist rightWrist;
    private int counter = 0;
    
    DecimalFormat df = new DecimalFormat("0.00");

    public Android() {

    }

    public Android(Ankle leftAnkle, Ankle rightAnkle, Elbow leftElbow, Elbow rightElbow, Head head, Hip leftHip, Hip rightHip, Knee leftKnee, Knee rightKnee, Neck neck, Shoulder leftShoulder, Shoulder rightShoulder, Waist waist, Wrist leftWrist, Wrist rightWrist) {
        this.leftAnkle = leftAnkle;
        this.rightAnkle = rightAnkle;
        this.leftElbow = leftElbow;
        this.rightElbow = rightElbow;
        this.head = head;
        this.leftHip = leftHip;
        this.rightHip = rightHip;
        this.leftKnee = leftKnee;
        this.rightKnee = rightKnee;
        this.neck = neck;
        this.leftShoulder = leftShoulder;
        this.rightShoulder = rightShoulder;
        this.waist = waist;
        this.leftWrist = leftWrist;
        this.rightWrist = rightWrist;
    }

    @Override
    public void Stand(String filePositions1, String filePositions2, String filePositions3, Battery battery) throws IOException {

        Stand st = new Stand();

        System.out.format("%-31s%1s", "\n\nMOVEMENT:", "|\tStanding");
        System.out.format("%-30s%1s", "\nINITIAL BATTERY LEVEL:", "|\t" + df.format(battery.getActualVoltage()) + "v");
        System.out.format("%-30s%1s", "\nHOLDING MOTORS USAGE:", "|\t" + df.format(battery.getHoldingMotors()) + "v");
        System.out.format("%-30s%1s", "\nAVAILABLE BATTERY TO USE:", "|\t" + df.format((battery.getActualVoltage() - battery.getHoldingMotors())) + "v");

        counter = 1;
        counter = st.StandPosition1(this, filePositions1, battery, counter);
        counter = st.StandPosition2(this, filePositions2, battery, counter);
        st.StandPosition3(this, filePositions3, battery, counter);

    }

    @Override
    public void Walk(String filePositions1, String filePositions2, String filePositions3, String filePositions4, String filePositions5, Battery battery) throws IOException {
        Walk wa = new Walk();

        System.out.format("%-31s%1s", "\n\nMOVEMENT:", "|\tWalking");
        System.out.format("%-30s%1s", "\nINITIAL BATTERY LEVEL:", "|\t" + df.format(battery.getActualVoltage()) + "v");
        System.out.format("%-30s%1s", "\nHOLDING MOTORS USAGE:", "|\t" + df.format(battery.getHoldingMotors()) + "v");
        System.out.format("%-30s%1s", "\nAVAILABLE BATTERY TO USE:", "|\t" + df.format((battery.getActualVoltage() - battery.getHoldingMotors())) + "v");

        counter = 1;
        counter = wa.WalkPosition1(this, filePositions1, battery, counter);
        counter = wa.WalkPosition2(this, filePositions2, battery, counter);
        counter = wa.WalkPosition3(this, filePositions3, battery, counter);
        counter = wa.WalkPosition4(this, filePositions4, battery, counter);
        wa.WalkPosition5(this, filePositions5, battery, counter);

    }

    @Override
    public void Sit(String filePositions1, String filePositions2, String filePositions3, Battery battery) throws IOException {

        Sit si = new Sit();

        System.out.format("%-31s%1s", "\n\nMOVEMENT:", "|\tSitting");
        System.out.format("%-30s%1s", "\nINITIAL BATTERY LEVEL:", "|\t" + df.format(battery.getActualVoltage()) + "v");
        System.out.format("%-30s%1s", "\nHOLDING MOTORS USAGE:", "|\t" + df.format(battery.getHoldingMotors()) + "v");
        System.out.format("%-30s%1s", "\nAVAILABLE BATTERY TO USE:", "|\t" + df.format((battery.getActualVoltage() - battery.getHoldingMotors())) + "v");

        counter = 1;
        counter = si.SitPosition1(this, filePositions1, battery, counter);
        counter = si.SitPosition2(this, filePositions2, battery, counter);
        si.SitPosition3(this, filePositions3, battery, counter);

    }

    public void SetMovementRotation(Articulation articulation, double finalDegreesToMove) {

        if (articulation.getMoveRotation() <= finalDegreesToMove) {
            articulation.setMoveRotation(0);
        } else {
            articulation.setMoveRotation(articulation.getMoveRotation() - finalDegreesToMove);
        }
    }

    public void SetMovementFlexion(Articulation articulation, double finalDegreesToMove) {

        if (articulation.getMoveFlexion() <= finalDegreesToMove) {
            articulation.setMoveFlexion(0);
        } else {
            articulation.setMoveFlexion(articulation.getMoveFlexion() - finalDegreesToMove);
        }
    }

    public void SetArticulations(String filePositions) throws FileNotFoundException, IOException {
        FileInputStream fs = new FileInputStream(filePositions);
        BufferedReader br = new BufferedReader(new InputStreamReader(fs));

        String line = br.readLine();
        String[] leftAnkle = line.split(",");
        line = br.readLine();
        String[] rightAnkle = line.split(",");
        line = br.readLine();
        String[] leftKnee = line.split(",");
        line = br.readLine();
        String[] rightKnee = line.split(",");
        line = br.readLine();
        String[] leftHip = line.split(",");
        line = br.readLine();
        String[] rightHip = line.split(",");
        line = br.readLine();
        String[] waist = line.split(",");
        line = br.readLine();
        String[] leftWrist = line.split(",");
        line = br.readLine();
        String[] rightWrist = line.split(",");
        line = br.readLine();
        String[] leftElbow = line.split(",");
        line = br.readLine();
        String[] rightElbow = line.split(",");
        line = br.readLine();
        String[] leftShoulder = line.split(",");
        line = br.readLine();
        String[] rightShoulder = line.split(",");
        line = br.readLine();
        String[] neck = line.split(",");
        line = br.readLine();
        String[] head = line.split(",");

        this.leftAnkle.setInitialDegree(Integer.parseInt(leftAnkle[1]));
        this.leftAnkle.setFinalDegree(Integer.parseInt(leftAnkle[2]));
        this.rightAnkle.setInitialDegree(Integer.parseInt(rightAnkle[1]));
        this.rightAnkle.setFinalDegree(Integer.parseInt(rightAnkle[2]));
        this.leftKnee.setInitialDegree(Integer.parseInt(leftKnee[1]));
        this.leftKnee.setFinalDegree(Integer.parseInt(leftKnee[2]));
        this.rightKnee.setInitialDegree(Integer.parseInt(rightKnee[1]));
        this.rightKnee.setFinalDegree(Integer.parseInt(rightKnee[2]));
        this.leftHip.setInitialDegree(Integer.parseInt(leftHip[1]));
        this.leftHip.setFinalDegree(Integer.parseInt(leftHip[2]));
        this.rightHip.setInitialDegree(Integer.parseInt(rightHip[1]));
        this.rightHip.setFinalDegree(Integer.parseInt(rightHip[2]));
        this.waist.setInitialRotation(Integer.parseInt(waist[1]));
        this.waist.setInitialDegree(Integer.parseInt(waist[2]));
        this.waist.setFinalRotation(Integer.parseInt(waist[3]));
        this.waist.setFinalDegree(Integer.parseInt(waist[4]));
        this.leftWrist.setInitialDegree(Integer.parseInt(leftWrist[1]));
        this.leftWrist.setFinalDegree(Integer.parseInt(leftWrist[2]));
        this.rightWrist.setInitialDegree(Integer.parseInt(rightWrist[1]));
        this.rightWrist.setFinalDegree(Integer.parseInt(rightWrist[2]));
        this.leftElbow.setInitialDegree(Integer.parseInt(leftElbow[1]));
        this.leftElbow.setFinalDegree(Integer.parseInt(leftElbow[2]));
        this.rightElbow.setInitialDegree(Integer.parseInt(rightElbow[1]));
        this.rightElbow.setFinalDegree(Integer.parseInt(rightElbow[2]));
        this.leftShoulder.setInitialRotation(Integer.parseInt(leftShoulder[1]));
        this.leftShoulder.setInitialDegree(Integer.parseInt(leftShoulder[2]));
        this.leftShoulder.setFinalRotation(Integer.parseInt(leftShoulder[3]));
        this.leftShoulder.setFinalDegree(Integer.parseInt(leftShoulder[4]));
        this.rightShoulder.setInitialRotation(Integer.parseInt(rightShoulder[1]));
        this.rightShoulder.setInitialDegree(Integer.parseInt(rightShoulder[2]));
        this.rightShoulder.setFinalRotation(Integer.parseInt(rightShoulder[3]));
        this.rightShoulder.setFinalDegree(Integer.parseInt(rightShoulder[4]));
        this.neck.setInitialRotation(Integer.parseInt(neck[1]));
        this.neck.setFinalRotation(Integer.parseInt(neck[2]));
        this.head.setInitialRotation(Integer.parseInt(head[1]));
        this.head.setInitialDegree(Integer.parseInt(head[2]));
        this.head.setFinalRotation(Integer.parseInt(head[3]));
        this.head.setFinalDegree(Integer.parseInt(head[4]));
        this.leftAnkle.setMoveFlexion(this.leftAnkle.getFinalDegree() - this.leftAnkle.getInitialDegree());
        this.rightAnkle.setMoveFlexion(this.rightAnkle.getFinalDegree() - this.rightAnkle.getInitialDegree());
        this.leftKnee.setMoveFlexion(this.leftKnee.getFinalDegree() - this.leftKnee.getInitialDegree());
        this.rightKnee.setMoveFlexion(this.rightKnee.getFinalDegree() - this.rightKnee.getInitialDegree());
        this.leftHip.setMoveFlexion(this.leftHip.getFinalDegree() - this.leftHip.getInitialDegree());
        this.rightHip.setMoveFlexion(this.rightHip.getFinalDegree() - this.rightHip.getInitialDegree());
        this.waist.setMoveRotation(this.waist.getFinalRotation() - this.waist.getInitialRotation());
        this.waist.setMoveFlexion(this.waist.getFinalDegree() - this.waist.getInitialDegree());
        this.leftWrist.setMoveFlexion(this.leftWrist.getFinalDegree() - this.leftWrist.getInitialDegree());
        this.rightWrist.setMoveFlexion(this.rightWrist.getFinalDegree() - this.rightWrist.getInitialDegree());
        this.leftElbow.setMoveFlexion(this.leftElbow.getFinalDegree() - this.leftElbow.getInitialDegree());
        this.rightElbow.setMoveFlexion(this.rightElbow.getFinalDegree() - this.rightElbow.getInitialDegree());
        this.leftShoulder.setMoveRotation(this.leftShoulder.getFinalRotation() - this.leftShoulder.getInitialRotation());
        this.leftShoulder.setMoveFlexion(this.leftShoulder.getFinalDegree() - this.leftShoulder.getInitialDegree());
        this.rightShoulder.setMoveRotation(this.rightShoulder.getFinalRotation() - this.rightShoulder.getInitialRotation());
        this.rightShoulder.setMoveFlexion(this.rightShoulder.getFinalDegree() - this.rightShoulder.getInitialDegree());
        this.neck.setMoveRotation(this.neck.getFinalRotation() - this.neck.getInitialRotation());
        this.head.setMoveRotation(this.head.getFinalRotation() - this.head.getInitialRotation());
        this.head.setMoveFlexion(this.head.getFinalDegree() - this.head.getInitialDegree());

    }

    public void PrintInitialPosition() {
        System.out.format("%-31s%1s", "\n\nARTICULATIONS", "|\tINITIAL POSITION");
        System.out.print("\n------------------------------------------------");
        System.out.format("%-30s%1s", "\n" + getLeftAnkle().getName() + " (Flexion)", "|\t" + getLeftAnkle().getInitialDegree());
        System.out.format("%-30s%1s", "\n" + getRightAnkle().getName() + " (Flexion)", "|\t" + getLeftAnkle().getInitialDegree());
        System.out.format("%-30s%1s", "\n" + getLeftKnee().getName() + " (Flexion)", "|\t" + getLeftKnee().getInitialDegree());
        System.out.format("%-30s%1s", "\n" + getRightKnee().getName() + " (Flexion)", "|\t" + getRightKnee().getInitialDegree());
        System.out.format("%-30s%1s", "\n" + getLeftHip().getName() + " (Flexion)", "|\t" + getLeftHip().getInitialDegree());
        System.out.format("%-30s%1s", "\n" + getRightHip().getName() + " (Flexion)", "|\t" + getRightHip().getInitialDegree());
        System.out.format("%-30s%1s", "\n" + getWaist().getName() + " (Flexion)", "|\t" + getWaist().getInitialDegree());
        System.out.format("%-30s%1s", "\n" + getWaist().getName() + " (Rotation)", "|\t" + getWaist().getInitialRotation());
        System.out.format("%-30s%1s", "\n" + getLeftWrist().getName() + " (Flexion)", "|\t" + getLeftWrist().getInitialDegree());
        System.out.format("%-30s%1s", "\n" + getRightWrist().getName() + " (Flexion)", "|\t" + getRightWrist().getInitialDegree());
        System.out.format("%-30s%1s", "\n" + getLeftElbow().getName() + " (Flexion)", "|\t" + getLeftElbow().getInitialDegree());
        System.out.format("%-30s%1s", "\n" + getRightElbow().getName() + " (Flexion)", "|\t" + getRightElbow().getInitialDegree());
        System.out.format("%-30s%1s", "\n" + getLeftShoulder().getName() + " (Flexion)", "|\t" + getLeftShoulder().getInitialDegree());
        System.out.format("%-30s%1s", "\n" + getLeftShoulder().getName() + " (Rotation)", "|\t" + getLeftShoulder().getInitialRotation());
        System.out.format("%-30s%1s", "\n" + getRightShoulder().getName() + " (Flexion)", "|\t" + getRightShoulder().getInitialDegree());
        System.out.format("%-30s%1s", "\n" + getRightShoulder().getName() + " (Rotation)", "|\t" + getRightShoulder().getInitialRotation());
        System.out.format("%-30s%1s", "\n" + getNeck().getName() + " (Rotation)", "|\t" + getNeck().getInitialRotation());
        System.out.format("%-30s%1s", "\n" + getHead().getName() + " (Flexion)", "|\t" + getHead().getInitialDegree());
        System.out.format("%-30s%1s", "\n" + getHead().getName() + " (Rotation)", "|\t" + getHead().getInitialRotation());

    }

    public void setLeftAnkle(Ankle leftAnkle) {
        this.leftAnkle = leftAnkle;
    }

    public void setRightAnkle(Ankle rightAnkle) {
        this.rightAnkle = rightAnkle;
    }

    public void setLeftElbow(Elbow leftElbow) {
        this.leftElbow = leftElbow;
    }

    public void setRightElbow(Elbow rightElbow) {
        this.rightElbow = rightElbow;
    }

    public void setHead(Head head) {
        this.head = head;
    }

    public void setLeftHip(Hip leftHip) {
        this.leftHip = leftHip;
    }

    public void setLeftKnee(Knee leftKnee) {
        this.leftKnee = leftKnee;
    }

    public void setRightHip(Hip rightHip) {
        this.rightHip = rightHip;
    }

    public void setRightKnee(Knee rightKnee) {
        this.rightKnee = rightKnee;
    }

    public void setNeck(Neck neck) {
        this.neck = neck;
    }

    public void setLeftShoulder(Shoulder leftShoulder) {
        this.leftShoulder = leftShoulder;
    }

    public void setRightShoulder(Shoulder rightShoulder) {
        this.rightShoulder = rightShoulder;
    }

    public void setWaist(Waist waist) {
        this.waist = waist;
    }

    public void setLeftWrist(Wrist leftWrist) {
        this.leftWrist = leftWrist;
    }

    public void setRightWrist(Wrist rightWrist) {
        this.rightWrist = rightWrist;
    }

    public Ankle getLeftAnkle() {
        return leftAnkle;
    }

    public Ankle getRightAnkle() {
        return rightAnkle;
    }

    public Elbow getLeftElbow() {
        return leftElbow;
    }

    public Elbow getRightElbow() {
        return rightElbow;
    }

    public Head getHead() {
        return head;
    }

    public Hip getLeftHip() {
        return leftHip;
    }

    public Hip getRightHip() {
        return rightHip;
    }

    public Knee getLeftKnee() {
        return leftKnee;
    }

    public Knee getRightKnee() {
        return rightKnee;
    }

    public Neck getNeck() {
        return neck;
    }

    public Shoulder getLeftShoulder() {
        return leftShoulder;
    }

    public Shoulder getRightShoulder() {
        return rightShoulder;
    }

    public Waist getWaist() {
        return waist;
    }

    public Wrist getLeftWrist() {
        return leftWrist;
    }

    public Wrist getRightWrist() {
        return rightWrist;
    }

    @Override
    public String toString() {
        return "Android:"
                + "\nLeft Ankle:"
                + "\n\tName: " + leftAnkle.getName()
                + "\n\tFlexion maximum degrees: " + leftAnkle.getFlexion()
                + "\n\tVolts required: " + leftAnkle.getVoltsRequired()
                + "\n\tInitial Flex Position: " + leftAnkle.getInitialDegree()
                + "\n\tFinal Flex Position: " + leftAnkle.getFinalDegree()
                + "\n\tDegrees to move Flex: " + leftAnkle.getMoveFlexion()
                + "\n\nRight Ankle:"
                + "\n\tName: " + rightAnkle.getName()
                + "\n\tFlexion maximum degrees: " + rightAnkle.getFlexion()
                + "\n\tVolts required: " + rightAnkle.getVoltsRequired()
                + "\n\tInitial Flex Position: " + rightAnkle.getInitialDegree()
                + "\n\tFinal Flex Position: " + rightAnkle.getFinalDegree()
                + "\n\tDegrees to move Flex: " + rightAnkle.getMoveFlexion()
                + "\n\nLeft Elbow:"
                + "\n\tName: " + leftElbow.getName()
                + "\n\tFlexion maximum degrees: " + leftElbow.getFlexion()
                + "\n\tVolts required: " + leftElbow.getVoltsRequired()
                + "\n\tInitial Flex Position: " + leftElbow.getInitialDegree()
                + "\n\tFinal Flex Position: " + leftElbow.getFinalDegree()
                + "\n\tDegrees to move Flex: " + leftElbow.getMoveFlexion()
                + "\n\nRight Elbow:"
                + "\n\tName: " + rightElbow.getName()
                + "\n\tFlexion maximum degrees: " + rightElbow.getFlexion()
                + "\n\tVolts required: " + rightElbow.getVoltsRequired()
                + "\n\tInitial Flex Position: " + rightElbow.getInitialDegree()
                + "\n\tFinal Flex Position: " + rightElbow.getFinalDegree()
                + "\n\tDegrees to move Flex: " + rightElbow.getMoveFlexion()
                + "\n\nHead:"
                + "\n\tName: " + head.getName()
                + "\n\tRotation maximum degrees: " + head.getRotation()
                + "\n\tFlexion maximum degrees: " + head.getFlexion()
                + "\n\tVolts required: " + head.getVoltsRequired()
                + "\n\tInitial Rotation Position: " + head.getInitialRotation()
                + "\n\tFinal Rotation Position: " + head.getFinalRotation()
                + "\n\tInitial Flex Position: " + head.getInitialDegree()
                + "\n\tFinal Flex Position: " + head.getFinalDegree()
                + "\n\tDegrees to move Rotation: " + head.getMoveRotation()
                + "\n\tDegrees to move Flex: " + head.getMoveFlexion()
                + "\n\nLeft Hip:"
                + "\n\tName: " + leftHip.getName()
                + "\n\tFlexion maximum degrees: " + leftHip.getFlexion()
                + "\n\tVolts required: " + leftHip.getVoltsRequired()
                + "\n\tInitial Flex Position: " + leftHip.getInitialDegree()
                + "\n\tFinal Flex Position: " + leftHip.getFinalDegree()
                + "\n\tDegrees to move Flex: " + leftHip.getMoveFlexion()
                + "\n\nRight Hip:"
                + "\n\tName: " + rightHip.getName()
                + "\n\tFlexion maximum degrees: " + rightHip.getFlexion()
                + "\n\tVolts required: " + rightHip.getVoltsRequired()
                + "\n\tInitial Flex Position: " + rightHip.getInitialDegree()
                + "\n\tFinal Flex Position: " + rightHip.getFinalDegree()
                + "\n\tDegrees to move Flex: " + rightHip.getMoveFlexion()
                + "\n\nLeft Knee:"
                + "\n\tName: " + leftKnee.getName()
                + "\n\tFlexion maximum degrees: " + leftKnee.getFlexion()
                + "\n\tVolts required: " + leftKnee.getVoltsRequired()
                + "\n\tInitial Flex Position: " + leftKnee.getInitialDegree()
                + "\n\tFinal Flex Position: " + leftKnee.getFinalDegree()
                + "\n\tDegrees to move Flex: " + leftKnee.getMoveFlexion()
                + "\n\nRight Knee:"
                + "\n\tName: " + rightKnee.getName()
                + "\n\tFlexion maximum degrees: " + rightKnee.getFlexion()
                + "\n\tVolts required: " + rightKnee.getVoltsRequired()
                + "\n\tInitial Flex Position: " + rightKnee.getInitialDegree()
                + "\n\tFinal Flex Position: " + rightKnee.getFinalDegree()
                + "\n\tDegrees to move Flex: " + rightKnee.getMoveFlexion()
                + "\n\nNeck:"
                + "\n\tName: " + neck.getName()
                + "\n\tRotation maximum degrees: " + neck.getRotation()
                + "\n\tVolts required: " + neck.getVoltsRequired()
                + "\n\tInitial Rotation Position: " + neck.getInitialRotation()
                + "\n\tFinal Rotation Position: " + neck.getFinalRotation()
                + "\n\tDegrees to move Rotation: " + neck.getMoveRotation()
                + "\n\nLeft Shoulder:"
                + "\n\tName: " + leftShoulder.getName()
                + "\n\tRotation maximum degrees: " + leftShoulder.getRotation()
                + "\n\tFlexion maximum degrees: " + leftShoulder.getFlexion()
                + "\n\tVolts required: " + leftShoulder.getVoltsRequired()
                + "\n\tInitial Rotation Position: " + leftShoulder.getInitialRotation()
                + "\n\tFinal Rotation Position: " + leftShoulder.getFinalRotation()
                + "\n\tInitial Flex Position: " + leftShoulder.getInitialDegree()
                + "\n\tFinal Flex Position: " + leftShoulder.getFinalDegree()
                + "\n\tDegrees to move Rotation: " + leftShoulder.getMoveRotation()
                + "\n\tDegrees to move Flex: " + leftShoulder.getMoveFlexion()
                + "\n\nRight Shoulder:"
                + "\n\tName: " + rightShoulder.getName()
                + "\n\tRotation maximum degrees: " + rightShoulder.getRotation()
                + "\n\tFlexion maximum degrees: " + rightShoulder.getFlexion()
                + "\n\tVolts required: " + rightShoulder.getVoltsRequired()
                + "\n\tInitial Rotation Position: " + rightShoulder.getInitialRotation()
                + "\n\tFinal Rotation Position: " + rightShoulder.getFinalRotation()
                + "\n\tInitial Flex Position: " + rightShoulder.getInitialDegree()
                + "\n\tFinal Flex Position: " + rightShoulder.getFinalDegree()
                + "\n\tDegrees to move Rotation: " + rightShoulder.getMoveRotation()
                + "\n\tDegrees to move Flex: " + rightShoulder.getMoveFlexion()
                + "\n\nWaist:"
                + "\n\tName: " + waist.getName()
                + "\n\tRotation maximum degrees: " + waist.getRotation()
                + "\n\tFlexion maximum degrees: " + waist.getFlexion()
                + "\n\tVolts required: " + waist.getVoltsRequired()
                + "\n\tInitial Rotation Position: " + waist.getInitialRotation()
                + "\n\tFinal Rotation Position: " + waist.getFinalRotation()
                + "\n\tDegrees to move Rotation: " + waist.getMoveRotation()
                + "\n\tDegrees to move Flex: " + waist.getMoveFlexion()
                + "\n\nLeft Wrist:"
                + "\n\tName: " + leftWrist.getName()
                + "\n\tFlexion maximum degrees: " + leftWrist.getFlexion()
                + "\n\tVolts required: " + leftWrist.getVoltsRequired()
                + "\n\tInitial Flex Position: " + leftWrist.getInitialDegree()
                + "\n\tFinal Flex Position: " + leftWrist.getFinalDegree()
                + "\n\tDegrees to move Flex: " + leftWrist.getMoveFlexion()
                + "\n\nRight Wrist:"
                + "\n\tName: " + rightWrist.getName()
                + "\n\tFlexion maximum degrees: " + rightWrist.getFlexion()
                + "\n\tVolts required: " + rightWrist.getVoltsRequired()
                + "\n\tInitial Flex Position: " + rightWrist.getInitialDegree()
                + "\n\tFinal Flex Position: " + rightWrist.getFinalDegree()
                + "\n\tDegrees to move Flex: " + rightWrist.getMoveFlexion();
    }

}
