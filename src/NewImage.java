
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Scanner;

public class NewImage {
    private int height;
    private int width;
    private int pixel;
    private int digit;
    private int[][] imageArray;
    private Scanner newsample, oldsample;
    private File newImage, oldImage;
    private String imageSD = "CleanPicture.txt";
    private PrintStream Stream;

    public NewImage(String inputFile) {

        this.oldImage = new File(inputFile);
    }

    public String Image() {
        //opening the file

        try {oldsample = new Scanner(oldImage); }
        catch (FileNotFoundException e) {e.printStackTrace();}

        //expansion of the content of text file
        int num = 0;
        int columnnum = 0;
        try (PrintStream Stream = new PrintStream(imageSD)) {
            while (oldsample.hasNext()) {
                digit = oldsample.nextInt();

                if (digit == -1)
                    break;

                if (num == 2) {
                    pixel = oldsample.nextInt();

                    for (int i = 0; i < digit; i++) {
                        Stream.print((int) pixel + " ");
                        columnnum += 1;

                        if (columnnum == width) {
                            columnnum = 0;
                            Stream.println();
                        }
                    }
                }
                if (num == 1) {
                    height = digit;
                    num += 1;
                }
                if (num == 0) {
                    width = digit;
                    num += 1;
                }
            }
            Stream.flush();
        }
        catch (FileNotFoundException e) { e.printStackTrace(); }
        return imageSD;
    }

    public int[][] Text(String input_file) {

        imageArray = new int[height][width];

        newImage = new File(input_file);

        try { newsample = new Scanner(newImage); }
        catch (FileNotFoundException e) { e.printStackTrace();}
        while (newsample.hasNext()) {
            for (int i = 0; i < height; i++) {
                for (int j = 0; j < width; j++) {
                    digit = newsample.nextInt();
                    imageArray[i][j] = digit;
                }
            }
        }
        return imageArray;
    }

}
