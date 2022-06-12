import java.io.*;
import java.net.URL;

public class Main
{
    public static void main(String[]args)
    {
        Frame frame = new Frame();
    }

    public static void saveImage(String imageUrl, String destinationFile)
    {
        try {
            URL url = new URL(imageUrl);
            InputStream is = url.openStream();
            OutputStream os = new FileOutputStream(destinationFile);
            byte[] b = new byte[2048];
            int length;
            while ((length = is.read(b)) != -1)
            {
                os.write(b, 0, length);
            }
            is.close();
            os.close();
        }catch (Exception e)
        {
            //TODO: handle exception
        }
    }
}
