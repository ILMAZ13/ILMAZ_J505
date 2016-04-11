import java.io.File;
import java.util.Arrays;

class FileTree {
    public void printTree(File file){
        print(file,"",1);
    }
    private void print(File file, String pre, int decount){
        if(decount == 1) {
            System.out.println(pre + "└" + file.getName());
            pre = pre + " ";
        } else {
            System.out.println(pre + "├" + file.getName());
        }
        if(file.isDirectory()) {
            File[] files = file.listFiles();
            if (files != null) {
                Arrays.sort(files);
                if (decount == 1) {
                    for (int i = 0; i < files.length; i++) {
                        print(files[i], pre + "  ", files.length - i);
                    }
                } else {
                    for (int i = 0; i < files.length; i++) {
                        print(files[i], pre + "│ ", files.length - i);
                    }
                }
            }
        }
    }
    public void printDesctopTree(){
        print(new File(System.getProperty("user.home")), "", 1);
    }
}
