package cn.shlh.compress.simpleModel;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;
/**
 * java 实现文件压缩功能 简单示例
 * @author Administrator
 *
 */
public class ZipCompress {

	@SuppressWarnings({ "resource", "unused" })
	public static void main(String[] args) {
		String sourcePath = "F:\\data.json";
		String outPath = "F:\\test/test.zip";
		
		try {
			File file = new File(sourcePath);
			FileOutputStream fos = new FileOutputStream(new File(outPath));
			ZipOutputStream zos = new ZipOutputStream(fos);
			zos.putNextEntry(new ZipEntry(file.getName()));
			zos.setLevel(9);
			zos.setComment("forTest");
			FileInputStream fis = new FileInputStream(file);
			byte[] b = new byte[1024];
			int length;
			while((length = fis.read(b)) > 0){
				zos.write(b);
			}
			zos.close();
			fos.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
