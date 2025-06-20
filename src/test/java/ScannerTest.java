import java.util.Scanner;

public class ScannerTest {
    public static void main(String[] args) throws InterruptedException {
       Scanner scanner = new Scanner(System.in);
       String input = scanner.nextLine();
       PersonalTest personalTest = new PersonalTest();
       personalTest.quill(input);
       //everythig works well
    }
}
