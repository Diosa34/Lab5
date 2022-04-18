package CheckCorrectData;

import java.nio.file.Path;
import java.util.HashSet;

/**
 * CheckExistPath class
 */
public class CheckExistPath {
    private HashSet<Path> existingPathList = new HashSet<>();

    /**
     *
     * @param path path is needed to check
     * @return has path already existed
     */
    public boolean checkExistPath(Path path) {
        if (existingPathList.contains(path)) return true;

        existingPathList.add(path);
        return false;
    }

    /**
     * Clear list with existing paths
     */
    public void clearList() {
        existingPathList.clear();
    }
}
