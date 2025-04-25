package iuh.QuanLyFileHeThong;

public class Client {
    public static void main(String[] args) {
        Directory root = new Directory("Root");
        Directory subDir1 = new Directory("SubDir1");
        Directory subDir2 = new Directory("SubDir2");

        File file1 = new File("File1.txt");
        File file2 = new File("File2.txt");
        File file3 = new File("File3.txt");

        root.addComponent(subDir1);
        root.addComponent(file1);
        subDir1.addComponent(file2);
        subDir1.addComponent(subDir2);
        subDir2.addComponent(file3);

        root.showDetails();
    }
}

