public class TestPicture {
    public static void main(String[] args){
        NewImage imageText = new NewImage("picture.txt");
        String imageSD = imageText.Image();
        int[][] imageArray = imageText.Text(imageSD);
        PrintImage image = new PrintImage(imageArray);
    }
}
