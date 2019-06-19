package walkingandroids;

import java.io.IOException;

/**
 *
 * @author fabriciobarros
 * @author aldanalouzan
 */
public interface Movement {
    
    /**
     *
     * @param filePositions
     * @throws IOException
     */
public void Stand(String filePositions1, String filePositions2, String filePositions3, Battery battery) throws IOException;
public void Walk(String filePositions1, String filePositions2, String filePositions3, String filePositions4, String filePositions5, Battery battery)throws IOException;
public void Sit(String filePositions1, String filePositions2, String filePositions3, Battery battery)throws IOException;
    
}
