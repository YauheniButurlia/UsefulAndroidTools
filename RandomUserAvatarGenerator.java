import java.net.*;
import java.io.*;
import javax.net.ssl.HttpsURLConnection;

public class RandomUserAvatarGenerator {
  public static void main(String[] args) throws Exception {
    int amount = 1;
    if(args.length != 0){
      amount = Integer.parseInt(args[0]);
    }
    URL url = new URL("https://thispersondoesnotexist.com/image");
    for(int i = 0; i < amount; i++){
      HttpsURLConnection connection = (HttpsURLConnection) url.openConnection();
      connection.connect();
      InputStream response = connection.getInputStream();
      FileOutputStream out = new FileOutputStream("Photo" + String.valueOf(i) + ".jpg");
      byte[] buffer = new byte[200000];
      int c;
      while((c = response.read(buffer)) != -1) {
        out.write(buffer,0,c);
      }
      connection.disconnect();
      response.close();
      out.close();
      Thread.sleep(1000);
    }
  }
}
