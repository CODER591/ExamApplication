package ComposeExamDB;


import java.io.File;
import java.util.ArrayList;
import java.util.List;
// detect Json files by path and stringify them
public class GetDB {

    private List<String> result;  //here is list of all files with given extension by specified path
    //extension should be like "json" NOT like ".json"
    GetDB(String path_to_jsons_folder,String extension) {
        final File folder = new File(path_to_jsons_folder);
        this.result = new ArrayList<String>();

        search(".*\\." + extension, folder, result);
    }
    private static void search(final String pattern, final File folder, List<String> result) {

        for (final File f : folder.listFiles()) {

            if (f.isDirectory()) {
                search(pattern, f, result);
            }

            if (f.isFile()) {
                if (f.getName().matches(pattern)) {
                    result.add(f.getAbsolutePath());
                }
            }

        }
    }
    public List<String> getDB() {

        return result;
    }

}
