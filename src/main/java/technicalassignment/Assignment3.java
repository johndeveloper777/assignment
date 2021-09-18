package technicalassignment;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Assignment3 {
    public static void main(String[] args) {
        System.out.println(generateLetters(17, 8));
    }

    public static String generateLetters(int a, int b) {
        StringBuilder result = new StringBuilder();
        Random rand = new Random();
        StringBuilder aLetters = new StringBuilder();

        int aRem = a % 3;
        int cursorA = 0;
        boolean putARemain = false;
        boolean firstTime = true;
        boolean loop = true;
        boolean turnA = true;

        for (int i = 0; i < a; i++) aLetters.append("a");

        while (loop) {
            if (cursorA >= a) break;

            StringBuilder aWords = new StringBuilder();
            StringBuilder bWords = new StringBuilder();

            Random random = new Random();
            int aOrBFirst = random.nextInt(2);

            int aRnd = random.nextInt(2);
            int bRnd = random.nextInt(2);

            if (aRnd == 0) {
                if (firstTime) {
                    if (putARemain) {
                        cursorA += 3;
                    } else {
                        cursorA += 2;
                    }

                    putARemain = true;
                    aWords.append(aLetters.substring(0, cursorA));
                } else {
                    if (cursorA >= a-3) break;
                    aWords.append(aLetters.substring(cursorA, cursorA+3));
                    cursorA += 3;
                }

            } else {
                if (putARemain) {
                    if (cursorA >= a-3) break;
                    aWords.append(aLetters.substring(cursorA, cursorA+3));
                    cursorA += 3;
                } else {
                    if (cursorA >= a-2) break;
                    aWords.append(aLetters.substring(cursorA, cursorA+2));
                    cursorA += 2;
                }

                putARemain = true;
            }

            if (b > 0) {
                if (bRnd == 0) {
                    if (cursorA > b/3) {
                        bWords.append("bb");
                        b-=2;
                    } else {
                        bWords.append("b");
                        b--;
                    }
                } else {
                    bWords.append("b");
                    b--;
                }
            }

            if (firstTime) {
                if (aOrBFirst == 0) {
                    result.append(bWords);
                    result.append(aWords);
                    turnA = false;
                } else {
                    result.append(aWords);
                    result.append(bWords);
                    turnA = true;
                }
            } else {
                if (turnA) {
                    result.append(aWords);
                    result.append(bWords);
                    turnA = true;
                } else {
                    result.append(bWords);
                    result.append(aWords);
                    turnA = false;
                }
            }

            firstTime = false;
        }

        if (b > 0) {
            for (int i = 0; i < b; i++) {
                result.append("b");
            }
        }


        return result.toString();
    }
}
