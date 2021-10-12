package com.msb.dongbao.portal.web.code;

import com.sun.xml.internal.messaging.saaj.util.ByteOutputStream;
import lombok.Data;
import org.apache.tomcat.util.buf.ByteChunk;

import javax.imageio.ImageIO;
import javax.imageio.stream.ImageOutputStream;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Random;

@Data
public class ImageCode {
    //图形中的内容
    private String code;

    //图片
    private ByteArrayInputStream image;

    private int height=100;

    private int width=100;

    //单例
    public static ImageCode getInstance(){
        return new ImageCode();
    }

    private ImageCode(){
        //图形缓冲区 给个黑板
        BufferedImage image=new BufferedImage(width,height,BufferedImage.TYPE_INT_RGB);

        //给你支画笔
        Graphics graphics=image.getGraphics();

        //拿笔 涂色，画图形
        graphics.setColor(new Color(255,255,255));

        //画矩形
        graphics.fillRect(0,0,width,height);

        //字体
        graphics.setFont(new Font("宋体",Font.PLAIN,30));

        //
        Random random = new Random();
        this.code="";
        for (int i=0;i<6;i++){
            String s=String.valueOf(random.nextInt(10));
            this.code +=s;

            graphics.setColor(new Color(0,0,0));

            graphics.drawString(s,(width/6)*i,40);

            //划线
//            graphics.setColor(new Color(100,100,100));
//            graphics.drawLine((width/6)*i,40,(width/6)*i+25,40-30);

        }
           //识别中文测试
//         graphics.setColor(new Color(0,0,0));
//        graphics.drawString("我是中国人",(width/6),40);

//        graphics.setColor(new Color(100,100,100));
//       for (int i=0;i<100;i++){
//           int x=random.nextInt(width);
//           int y=random.nextInt(height);
//           int x1=random.nextInt(20);
//           int y1=random.nextInt(20);
//           graphics.drawLine(x,y,x+x1,y+y1);
//
//
//       }

       //收笔
        graphics.dispose();


       ByteArrayInputStream inputStream=null;
        ByteOutputStream outputStream =new ByteOutputStream();

        try {
            ImageOutputStream imageOutputStream = ImageIO.createImageOutputStream(outputStream);
            ImageIO.write(image,"jpeg",imageOutputStream);

            inputStream=new ByteArrayInputStream(outputStream.getBytes());
        } catch (IOException e) {
            System.out.println("生成验证码错误");

        }
        this.image=inputStream;

    }
}
