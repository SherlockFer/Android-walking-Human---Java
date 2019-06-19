package walkingandroids;

import java.io.IOException;

/**
 *
 * @author
 * @author
 */
public class WalkingAndroids {

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws IOException {

        SetUp su = new SetUp();
        Android walkingAndroid = su.CreateAndroid("setup.csv");
        Battery battery = new Battery();

        walkingAndroid.Stand("stand1.csv", "stand2.csv", "stand3.csv", battery);
        walkingAndroid.Walk("walk1.csv", "walk2.csv", "walk3.csv", "walk4.csv", "walk5.csv", battery);
        walkingAndroid.Sit("sit1.csv", "sit2.csv", "sit3.csv", battery);

    }

}
