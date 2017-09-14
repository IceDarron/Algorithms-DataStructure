package com.iceDarron.utils;

import javax.imageio.stream.FileImageInputStream;
import javax.imageio.stream.FileImageOutputStream;
import java.io.*;

public class IOUtils {

    public void writeFile(String url, String context) {
        File file = null;
        FileReader fr = null;
        FileWriter fw = null;
        BufferedReader br = null;
        BufferedWriter bw = null;
        try {
            file = new File(url);
            fr = new FileReader(file);
            fw = new FileWriter(file, true);// 一定要加true否则每次到这都会把文件内容删掉
            br = new BufferedReader(fr);
            bw = new BufferedWriter(fw);
            if (!file.exists()) {
                file.createNewFile();
            }
            String s = null;
            s = br.readLine();
            while (true) {
                if (s == null) {
                    bw.write(context);
                    bw.newLine();
                    bw.flush();
                    break;
                }
                s = br.readLine();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                fw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    //图片到byte数组
    public static byte[] image2byte(String path){
        byte[] data = null;
        FileImageInputStream input = null;
        try {
            input = new FileImageInputStream(new File(path));
            ByteArrayOutputStream output = new ByteArrayOutputStream();
            byte[] buf = new byte[1024];
            int numBytesRead = 0;
            while ((numBytesRead = input.read(buf)) != -1) {
                output.write(buf, 0, numBytesRead);
            }
            data = output.toByteArray();
            output.close();
            input.close();
        }
        catch (FileNotFoundException ex1) {
            ex1.printStackTrace();
        }
        catch (IOException ex1) {
            ex1.printStackTrace();
        }
        return data;
    }

    //byte数组到图片
    public static void byte2image(byte[] data,String path){
        if(data.length<3||path.equals("")) return;
        try{
            FileImageOutputStream imageOutput = new FileImageOutputStream(new File(path));
            imageOutput.write(data, 0, data.length);
            imageOutput.close();
            System.out.println("Make Picture success,Please find image in " + path);
        } catch(Exception ex) {
            System.out.println("Exception: " + ex);
            ex.printStackTrace();
        }
    }

    public static void main(String[] args) {
        byte[] bytes = image2byte("H:\\Jetbrains\\Idea\\Workspace\\Algorithms\\resource\\image\\ChMkJ1bxATiIVlzmAAlJIHaXmLkAAOTUgN32YEACUk4716.jpg");
        System.out.println(bytes.length);
//        for (int i = 0; i < bytes.length ; i++) {
//            System.out.print(bytes[i]);
//        }

        byte2image(bytes, "H:\\Jetbrains\\Idea\\Workspace\\Algorithms\\resource\\image\\Copy_ChMkJ1bxATiIVlzmAAlJIHaXmLkAAOTUgN32YEACUk4716.jpg");
    }
}
