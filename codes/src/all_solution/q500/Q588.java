package all_solution.q500;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

public class Q588 {
}

class FileSystem {
    class File {
        TreeMap<String, File> children = new TreeMap<>();
        boolean isFile = false;
        String name = "";
        StringBuilder content = new StringBuilder();

        public File(String name) {
            this.name = name;
        }
    }

    File root;

    public FileSystem() {
        root = new File("");
    }

    public List<String> ls(String path) {
        File cur = root;
        List<String> res = new ArrayList<>();
        String[] split = path.split("/");
        for (String dir : split) {
            if (dir.length() == 0) continue;
            if (!cur.children.containsKey(dir)) return res;
            cur = cur.children.get(dir);
        }
        if (cur.isFile) {
            res.add(cur.name);
        } else {
            res.addAll(cur.children.keySet());
        }
        return res;
    }

    public void mkdir(String path) {
        String[] split = path.split("/");
        File cur = root;
        for (String name : split) {
            if (name.length() == 0) continue;
            if (!cur.children.containsKey(name)) {
                cur.children.put(name, new File(name));
            }
            cur = cur.children.get(name);
        }
    }

    public void addContentToFile(String filePath, String content) {
        String[] split = filePath.split("/");
        File cur = root;
        for (String name : split) {
            if (name.length() == 0) continue;
            if (!cur.children.containsKey(name)) {
                cur.children.put(name, new File(name));
            }
            cur = cur.children.get(name);
        }
        cur.isFile = true;
        cur.content.append(content);
    }

    public String readContentFromFile(String filePath) {
        String[] split = filePath.split("/");
        File cur = root;
        for (String name : split) {
            if (name.length() == 0) continue;
            if (!cur.children.containsKey(name)) {
                cur.children.put(name, new File(name));
            }
            cur = cur.children.get(name);
        }
        if (!cur.isFile) return "";
        return cur.content.toString();
    }
}
