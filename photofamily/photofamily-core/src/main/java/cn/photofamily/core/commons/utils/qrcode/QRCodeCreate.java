package cn.photofamily.core.commons.utils.qrcode;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;

import javax.imageio.ImageIO;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;

/**
 * 
 * 版权所有：易汇金信息服务有限公司
 * 
 * @ClassName: QRCodeCreate
 * @Package:com.ehking.bankchannel.xuwen.test.scancode.alipay
 * @todo: 二维码生成器
 * @author wen.xu
 * @date 2015年8月28日 下午4:48:19
 * @deprecated @see com.ehking.commons.utils.qrcode.QRCodeUtils
 */
public class QRCodeCreate {
	

	private static final int BLACK = 0xFF000000;
	private static final int WHITE = 0xFFFFFFFF;

	private QRCodeCreate() {
	}

	public static BufferedImage toBufferedImage(BitMatrix matrix) {
		int width = matrix.getWidth();
		int height = matrix.getHeight();
		BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		for (int x = 0; x < width; x++) {
			for (int y = 0; y < height; y++) {
				image.setRGB(x, y, matrix.get(x, y) ? BLACK : WHITE);
			}
		}
		return image;
	}

	public static void writeToFile(BitMatrix matrix, String format, File file) throws IOException {
		BufferedImage image = toBufferedImage(matrix);
		if (!ImageIO.write(image, format, file)) {
			throw new IOException("Could not write an image of format " + format + " to " + file);
		}
	}

	public static void writeToStream(BitMatrix matrix, String format, OutputStream stream) throws IOException {
		BufferedImage image = toBufferedImage(matrix);
		if (!ImageIO.write(image, format, stream)) {
			throw new IOException("Could not write an image of format " + format);
		}
	}

	public static byte[] writeToImageStream(BitMatrix matrix, String format) throws IOException {
		BufferedImage image = toBufferedImage(matrix);

		ByteArrayOutputStream out = new ByteArrayOutputStream();

		if (!ImageIO.write(image, format, out)) {
			throw new IOException("Could not write an image of format " + format);
		}

		byte[] imageBytes = out.toByteArray();

		return imageBytes;
	}

	/**
	 * 
	 * @Title: createQRCode
	 * @todo: 生成二维码，返回字节流
	 * @return byte[]
	 * @author wen.xu
	 * @date 2015年8月28日 下午4:50:58
	 */
	public static byte[] createQRCode(String content) {
		byte[] imageBytes = null;
		try {
			MultiFormatWriter multiFormatWriter = new MultiFormatWriter();
			Map hints = new HashMap();
			hints.put(EncodeHintType.CHARACTER_SET, "UTF-8");
			//指定纠错级别(L--7%,M--15%,Q--25%,H--30%)  
            hints.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.H);
			BitMatrix bitMatrix = multiFormatWriter.encode(content, BarcodeFormat.QR_CODE, 400, 400, hints);

			imageBytes = writeToImageStream(bitMatrix, "jpg");
			
		} catch (Exception e) {
		}
		return imageBytes;
	}
	
	/**
	 * 
	 * @Title: createQRCode
	 * @todo: 生产二维码图片保存到指定地址
	 * @param content
	 * @param path
	 * @param name
	 * @return void
	 * @author wen.xu
	 * @date 2015年8月28日 下午4:55:30
	 */
	public static void createQRCode(String content,String path,String fielname) {
		try {
		     MultiFormatWriter multiFormatWriter = new MultiFormatWriter();
		     Map hints = new HashMap();
		     hints.put(EncodeHintType.CHARACTER_SET, "UTF-8");
		     //指定纠错级别(L--7%,M--15%,Q--25%,H--30%)  
		     hints.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.H);
		     BitMatrix bitMatrix = multiFormatWriter.encode(content, BarcodeFormat.QR_CODE, 400, 400,hints);
		     File saveFile = new File(path,fielname);
		     writeToFile(bitMatrix, "jpg", saveFile);
		     
		 } catch (Exception e) {
		 }
	}

}
