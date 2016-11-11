package cn.shlh.compress.simpleModel;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.CRC32;
import java.util.zip.CheckedInputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class UnZipFile {

	public static void main(String[] args) {
		// ����ѹ���ļ���·��
		String sourcePath = "F:\\test/��Ҫ���˵����-ͼֽ����ģ��.zip";
		//����ļ�·��
		String outPath = "F:\\test";
		
		unZip(sourcePath, outPath);

	}

	/**
	 * ��ѹѹ���ļ�
	 * @param sourcePath ����ѹ���ļ���·��
	 * @param outPath ����ļ�·��
	 */
	private static void unZip(String sourcePath, String outPath) {
		try {
			FileInputStream fin = new FileInputStream(sourcePath);
			//��Ҫά������ȡ����У��͵���������У��Ϳ�������֤�������ݵ������ԡ�
			CheckedInputStream cis = new CheckedInputStream(fin, new CRC32());
			ZipInputStream zis = new ZipInputStream(cis);
			
			ZipEntry zipEntry;
			//����ѹ���ļ�������ѹ����Ŀ
			while((zipEntry =zis.getNextEntry()) != null ){
				//��ѹ����Ŀ��������·��
				File targetFile = new File(outPath + File.separator + zipEntry.getName());
				//�ж�Ŀ������ļ��ĸ�Ŀ¼�Ƿ���ڣ���������ڵĻ���Ҫ����һ�����ļ���
				if(!targetFile.getParentFile().exists()){
					//�����ڸ��ļ��У��򴴽�
					targetFile.getParentFile().mkdirs();
				}
				
				if (zipEntry.isDirectory()) {
					//�жϵ�ǰ��ѹ����Ŀ�Ƿ����ļ��У�������ļ��еĻ���ֱ�������·�������ļ�����
					targetFile.mkdirs();
				}else{
					//��ǰ��ѹ����Ŀ�ֻ�һ���ļ�����Ҫ�������ѹ���ļ�������������·��
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
			System.out.println("����ͣ�" + cis.getChecksum().getValue());
			cis.close();
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