import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int[] numbers = {-1, -1, -1};
        String[] O = {"0", "0"};
        int currentInt = 0;
        int currentO = 0;
        int finalResult = 1;

        Scanner in = new Scanner(System.in);
        String S = in.nextLine();
        in.close();
        Scanner scan = new Scanner(S);

        while (scan.hasNext()) {
            if (scan.hasNextInt()) {
                numbers[currentInt++] = scan.nextInt();
                if (numbers[currentInt - 1] < 1 || numbers[currentInt - 1] > 10) {
                    throw new ArithmeticException("Invalid input");
                }
            } else if (scan.hasNext()) {
                O[currentO++] = scan.next();
                if (currentO != currentInt) {
                    throw new ArithmeticException("Invalid input");
                }
                if (O[currentO - 1].equals("+") && O[currentO - 1].equals("-") && O[currentO - 1].equals("*") &&
                    O[currentO - 1].equals("/")) {
                    throw new ArithmeticException("Invalid input");
                }
            }
        }
        scan.close();
        if (currentInt != currentO + 1 || currentInt > 3 || currentInt < 2) {
            throw new ArithmeticException("Invalid input");
        }

        if (currentInt == 2) {
            if (O[0].equals("*")) {
                finalResult = numbers[0] * numbers[1];
            }
            if (O[0].equals("+")) {
                finalResult = numbers[0] + numbers[1];
            }
            if (O[0].equals("-")) {
                finalResult = numbers[0] - numbers[1];
            }
            if (O[0].equals("/")) {
                finalResult = numbers[0] / numbers[1];
            }
        }
        else {
            if (O[0].equals("*")) {
                if (O[1].equals("+")) {
                    finalResult = numbers[0] * numbers[1] + numbers[2];
                }
                if (O[1].equals("-")) {
                    finalResult = numbers[0] * numbers[1] - numbers[2];
                }
                if (O[1].equals("*")) {
                    finalResult = numbers[0] * numbers[1] * numbers[2];
                }
                if (O[1].equals("/")) {
                    finalResult = numbers[0] * numbers[1] / numbers[2];
                }
            }
            if (O[0].equals("/")) {
                if (O[1].equals("+")) {
                    finalResult = numbers[0] / numbers[1] + numbers[2];
                }
                if (O[1].equals("-")) {
                    finalResult = numbers[0] / numbers[1] - numbers[2];
                }
                if (O[1].equals("*")) {
                    finalResult = numbers[0] / numbers[1] * numbers[2];
                }
                if (O[1].equals("/")) {
                    finalResult = numbers[0] / numbers[1] / numbers[2];
                }
            }
            if (O[0].equals("+")) {
                if (O[1].equals("+")) {
                    finalResult = numbers[0] + numbers[1] + numbers[2];
                }
                if (O[1].equals("-")) {
                    finalResult = numbers[0] + numbers[1] - numbers[2];
                }
                if (O[1].equals("*")) {
                    finalResult = numbers[0] + numbers[1] * numbers[2];
                }
                if (O[1].equals("/")) {
                    finalResult = numbers[0] + numbers[1] / numbers[2];
                }
            }
            if (O[0].equals("-")) {
                if (O[1].equals("+")) {
                    finalResult = numbers[0] - numbers[1] + numbers[2];
                }
                if (O[1].equals("-")) {
                    finalResult = numbers[0] - numbers[1] - numbers[2];
                }
                if (O[1].equals("*")) {
                    finalResult = numbers[0] - numbers[1] * numbers[2];
                }
                if (O[1].equals("/")) {
                    finalResult = numbers[0] - numbers[1] / numbers[2];
                }
            }
        }
        System.out.println(finalResult);
    }
}