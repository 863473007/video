package com.zhiyou.tools;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.awt.image.CropImageFilter;
import java.awt.image.FilteredImageSource;
import java.awt.image.ImageFilter;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

/**
 * @author ����ΰ   
 * @version ����ʱ�䣺2017��6��22�� ����10:33:45
 * ��˵��
 */
public class ImageCut {  
    
    /** 
     * ͼƬ�и� 
     * @param imagePath  ԭͼ��ַ 
     * @param x  Ŀ����Ƭ���� X����� 
     * @param y  Ŀ����Ƭ���� Y����� 
     * @param w  Ŀ����Ƭ ��� 
     * @param h  Ŀ����Ƭ �߶� 
     */  
    public  void cutImage(String imagePath, int x ,int y ,int w,int h){  
        try {  
            Image img;  
            ImageFilter cropFilter;  
            // ��ȡԴͼ��  
            BufferedImage bi = ImageIO.read(new File(imagePath));  
            int srcWidth = bi.getWidth();      // Դͼ���  
            int srcHeight = bi.getHeight();    // Դͼ�߶�  
              
            //��ԭͼ��С������Ƭ��С��������и�  
            if (srcWidth >= w && srcHeight >= h) {  
                Image image = bi.getScaledInstance(srcWidth, srcHeight,Image.SCALE_DEFAULT);  
                  
                //���jspҳ����չʾ����ԭͼ�Ĵ�С����ô�˴��Ͳ�������ʼ����Ϳ���ˣ�ֱ�Ӳü�
                int x1 = x;  
                int y1 = y;  
                int w1 = w;  
                int h1 = h;  
                  
                cropFilter = new CropImageFilter(x1, y1, w1, h1);  
                img = Toolkit.getDefaultToolkit().createImage(new FilteredImageSource(image.getSource(), cropFilter));  
                BufferedImage tag = new BufferedImage(w1, h1,BufferedImage.TYPE_INT_RGB);  
                Graphics g = tag.getGraphics();  
                g.drawImage(img, 0, 0, null); // ������С���ͼ  
                g.dispose();  
                // ���Ϊ�ļ�  
                ImageIO.write(tag, "JPEG", new File(imagePath));  
            }  
        } catch (IOException e) {  
            e.printStackTrace();  
        }  
    }  
}  
