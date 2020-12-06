package com.it.estore.utils;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.BinaryBitmap;
import com.google.zxing.DecodeHintType;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.Result;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.common.HybridBinarizer;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.geom.RoundRectangle2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Hashtable;

/**
 * @Author: BruceCseng
 * @Date: 2020/11/29 下午8:51
 * @Description: com.it.estore.utils
 * @Version: 1.0
 */
public class QRCodeUtils {

    private static final String CHARSET = "utf-8";

    // 二维码尺寸
    private static final int QRCODE_SIZE = 300;

    // LOGO宽度
    private static final int WIDTH = 100;

    // LOGO高度
    private static final int HEIGHT = 100;

    /**
     * 将前端传入的信息，编码成二维码
     *
     * @param content
     * @param imaPath
     * @param needCompress
     * @param outputStream
     * @throws Exception
     */
    public static void encode(String content, String imaPath, boolean needCompress, OutputStream outputStream) throws Exception {
        BufferedImage image = QRCodeUtils.createImage(content, imaPath, needCompress);
        ImageIO.write(image,"png",outputStream);
    }

    /**
     * 生成二维码核心代码
     *
     * @param content
     * @param imgPath
     * @param needCompress
     * @return
     * @throws Exception
     */
    private static BufferedImage createImage(String content, String imgPath, boolean needCompress) throws Exception {
        HashMap hints = new HashMap(16);
        // 指定要使用的纠错程度，例如在二维码中
        hints.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.H);
        // 指定字符编码
        hints.put(EncodeHintType.CHARACTER_SET, CHARSET);
        // 指定生成条形码时要使用的边距（以像素为单位）
        hints.put(EncodeHintType.MARGIN, 1);
        BitMatrix bitMatrix = new MultiFormatWriter().encode(content, BarcodeFormat.QR_CODE, QRCODE_SIZE, QRCODE_SIZE, hints);
        int width = bitMatrix.getWidth();
        int height = bitMatrix.getHeight();
        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                // true就是黑色，false就是白色
                image.setRGB(x, y, bitMatrix.get(x, y) ? 0xFF000000 : 0xFFFFFFFF);
            }
        }
        if (imgPath == null || "".equals(imgPath)) {
            return image;
        }
        // 插入LOGO图片
        QRCodeUtils.insertImage(image, imgPath, needCompress);
        return image;
    }

    /**
     * 插入二维码中的LOGO图片
     *
     * @param source
     * @param imgPath
     * @param needCompress
     * @throws Exception
     */
    private static void insertImage(BufferedImage source, String imgPath, boolean needCompress) throws Exception {
        File file = new File(imgPath);
        if (!file.exists()) {
            System.err.println("" + imgPath + "   该文件不存在！");
            return;
        }
        Image src = ImageIO.read(file);
        int height = src.getHeight(null);
        int width = src.getWidth(null);

        // 压缩LOGO
        if (needCompress) {
            if (width > WIDTH) {
                width = WIDTH;
            }
            if (height > HEIGHT) {
                height = HEIGHT;
            }

            Image image = src.getScaledInstance(width, height, Image.SCALE_SMOOTH);
            BufferedImage tag = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
            Graphics graphics = tag.getGraphics();

            // 绘制此图像的缩放版本
            graphics.drawImage(image, 0, 0, null);
            graphics.dispose();
            src = image;
        }
        // 插入LOGO
        Graphics2D graph = source.createGraphics();
        int x = (QRCODE_SIZE - width) / 2;
        int y = (QRCODE_SIZE - height) / 2;
        graph.drawImage(src, x, y, width, height, null);
        Shape shape = new RoundRectangle2D.Float(x, y, width, width, 6, 6);
        graph.setStroke(new BasicStroke(3f));
        graph.draw(shape);
        graph.dispose();
    }

    /**
     * 解码，将二维码里的信息解码出来
     *
     * @param path
     * @return
     * @throws Exception
     */
    public static String decode(String path) throws Exception {
        File file = new File(path);
        BufferedImage image = ImageIO.read(file);
        if (image == null) {
            return null;
        }
        BufferedImageLuminanceSource source = new BufferedImageLuminanceSource(image);
        BinaryBitmap bitmap = new BinaryBitmap(new HybridBinarizer(source));
        Result result;
        Hashtable hints = new Hashtable();
        hints.put(DecodeHintType.CHARACTER_SET, CHARSET);
        result = new MultiFormatReader().decode(bitmap, hints);
        String resultStr = result.getText();
        return resultStr;
    }
}
