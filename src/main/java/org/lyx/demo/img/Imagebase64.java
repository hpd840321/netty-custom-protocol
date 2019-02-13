package org.lyx.demo.img;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;

public class Imagebase64 {
    static BASE64Encoder encoder = new sun.misc.BASE64Encoder();
    static BASE64Decoder decoder = new sun.misc.BASE64Decoder();

    public static void main(String[] args) {
        System.out.println(getImageBinary()); // image to base64
      //  base64StringToImage(getImageBinary()); // base64 to image
    }

    static String getImageBinary() {
        File f = new File("D:\\upload\\header\\2018\\11\\0050cbeb2a4f4838ba6e52e785113bfd.jpg");
        try {
            BufferedImage bi = ImageIO.read(f);
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ImageIO.write(bi, "jpg", baos);
            byte[] bytes = baos.toByteArray();

            return encoder.encodeBuffer(bytes).trim();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    static void base64StringToImage(String base64String) {
        try {
            byte[] bytes1 = decoder.decodeBuffer(base64String);
            ByteArrayInputStream bais = new ByteArrayInputStream(bytes1);
            BufferedImage bi1 = ImageIO.read(bais);
            File f1 = new File("d://out.jpg");
            ImageIO.write(bi1, "jpg", f1);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}