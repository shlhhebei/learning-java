

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class UnZipFile {

	public static void main(String[] args) {
		// 待解压缩文件的路径
		String sourcePath = "F:\\test\\王超翔.zip";
		//输出文件路径
		String outPath = "F:\\test";
		
		unZip(sourcePath, outPath);

	}

	/**
	 * 解压压缩文件
	 * @param sourcePath 待解压缩文件的路径
	 * @param outPath 输出文件路径
	 */
	private static void unZip(String sourcePath, String outPath) {
		try {
			FileInputStream fin = new FileInputStream(sourcePath);
			ZipInputStream zis = new ZipInputStream(fin);
			
			ZipEntry zipEntry;
			//遍历压缩文件的所有压缩条目
			while((zipEntry =zis.getNextEntry()) != null ){
				//将压缩条目输出到输出路径
				File targetFile = new File(outPath + File.separator + zipEntry.getName());
				//判断目标输出文件的父目录是否存在，如果不存在的话则要创建一个父文件夹
				if(!targetFile.getParentFile().exists()){
					//不存在父文件夹，则创建
					targetFile.getParentFile().mkdirs();
				}
				
				if (zipEntry.isDirectory()) {
					//判断当前的压缩条目是否是文件夹，如果是文件夹的话，直接在输出路径创建文件即可
					targetFile.mkdirs();
				}else{
					//当前的压缩条目手机一个文件，需要将输入的压缩文件内容输出到输出路径
					FileOutputStream fos = new FileOutputStream(targetFile);
					byte[] buff = new byte[1024];
					int length;
					while((length = zis.read(buff)) > 0){
						fos.write(buff, 0, length);
					}
					fos.close();
				}
			}
			zis.close();
			fin.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
