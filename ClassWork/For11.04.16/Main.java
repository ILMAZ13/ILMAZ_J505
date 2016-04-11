import java.io.File;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String path = sc.nextLine();
        FileTree fileTree = new FileTree();
        File file = new File(path);
        fileTree.printTree(file);
        //fileTree.printDesctopTree();
    }

}
