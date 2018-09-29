package org.springframework.validation;

import org.apache.tools.zip.ZipEntry;
import org.apache.tools.zip.ZipFile;
import org.apache.tools.zip.ZipOutputStream;
import org.springframework.util.Assert;
import org.springframework.util.StringUtils;

import java.io.*;
import java.util.Enumeration;

/**
 * @author qinlinsen
 */
public class ZipFileUtils {
	private static final String ZIP_FILE_NOT_EXISTS = "zip file doesn't exists";
	private static final String DEFAULT_ZIP_CHARSET = "GBK";
	private static final String UNZIP_OPERATION_SUCCESS = "doUnzip operation success ";
	private static final String UNZIP_FILE_PATH_CANNOT_BE_NULL = "unzip file absolute path cannot be null";
	private static final String ZIP_FILE_PATH_CANNOT_BE_NULL = "zip file absolute path cannot be null";
	private static final String FILE_SEPARATOR = "file.separator";

	/**
	 * 解压操作
	 * @param zipFilePath    zip文件的绝对路径
	 * @param unzipFilePath  解压之后文件的绝对路径
	 * @return
	 */
	public static String doUnzip(String zipFilePath, String unzipFilePath) {
		//validate input parameters
		Assert.notNull(unzipFilePath, UNZIP_FILE_PATH_CANNOT_BE_NULL);
		Assert.notNull(zipFilePath, ZIP_FILE_PATH_CANNOT_BE_NULL);
		ZipFile zipFile = null;
		String directoryName = "";
		try {
			zipFile = new ZipFile(zipFilePath, DEFAULT_ZIP_CHARSET);
		} catch (IOException e) {
			System.out.println(ZIP_FILE_NOT_EXISTS);
			e.printStackTrace();
		}
		Enumeration<ZipEntry> entries = zipFile.getEntries();
		while (entries.hasMoreElements()) {
			ZipEntry zipEntry = entries.nextElement();
			if (zipEntry.isDirectory()) {
				directoryName = zipEntry.getName();
				directoryName = directoryName.substring(0, directoryName.length() - 1);
				if(!unzipFilePath.endsWith(System.getProperty(FILE_SEPARATOR))){
					unzipFilePath=unzipFilePath+System.getProperty(FILE_SEPARATOR);
				}
				File folder = new File(unzipFilePath + directoryName);

				//create a folder
				folder.mkdir();
			} else {
				InputStream in = null;
				OutputStream out = null;
				try {
					File file = new File(unzipFilePath + zipEntry.getName());
					//create a parent file
					file.getParentFile().mkdir();
					//create a file
					file.createNewFile();
					//read and write operation
					in = zipFile.getInputStream(zipEntry);
					out = new FileOutputStream(file);
					int len = 0;
					byte[] bytes = new byte[1024];
					while ((len = in.read(bytes, 0, 1024)) != -1) {
						out.write(bytes, 0, len);
					}
				} catch (IOException e) {
					e.printStackTrace();
				} finally {
					try {
						in.close();
						out.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
		}
		System.out.println(UNZIP_OPERATION_SUCCESS);
		if (!StringUtils.isEmpty(zipFile)) {
			try {
				zipFile.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return unzipFilePath + directoryName;
	}

	/**
	 * 压缩文件的操作
	 *具体用法参考下面的main方法的用法
	 * @param sourceUnzipFileAbsolutePath  要压缩的文件的绝对路径，这里假定这个文件形如：a/b/c/d.jpg
	 * @param destZipFileAbsolutePath  压缩文件的绝对路径
	 */
	public static void doZip(String sourceUnzipFileAbsolutePath, String destZipFileAbsolutePath) {

		File unzipFile = null;
		BufferedInputStream in = null;
		ZipOutputStream out = null;
		try {
			//validate input parameters
			Assert.notNull(sourceUnzipFileAbsolutePath, UNZIP_FILE_PATH_CANNOT_BE_NULL);
			Assert.notNull(destZipFileAbsolutePath, ZIP_FILE_PATH_CANNOT_BE_NULL);
			Assert.isTrue(destZipFileAbsolutePath.endsWith(".zip"), "zip file must ends with .zip");
			unzipFile = new File(sourceUnzipFileAbsolutePath);
			if (unzipFile.exists()) {
				File zipFile = new File(destZipFileAbsolutePath);
				if (zipFile.exists()) {
					throw new RuntimeException("该zip文件已经存在，请重新输入.zip文件的绝对路径");
				}
				zipFile.createNewFile();

				if (zipFile.exists()) {
					File[] sourceFiles = unzipFile.listFiles();
					if (null == sourceFiles || sourceFiles.length < 1) {
						System.out.println("File Catalog:" + sourceUnzipFileAbsolutePath + "nothing in there,don't have to compress!");
					} else {
						out = new ZipOutputStream(new BufferedOutputStream(new FileOutputStream(zipFile)));
						byte[] buffers = new byte[1024 * 10];
						for (int i = 0; i < sourceFiles.length; i++) {
							// create .zip and put pictures in
							ZipEntry zipEntry = new ZipEntry(sourceFiles[i].getName());
							out.putNextEntry(zipEntry);
							// read documents and put them in the zip
							in = new BufferedInputStream(new FileInputStream(sourceFiles[i]), 1024 * 10);
							int read = 0;
							while ((read = in.read(buffers, 0, buffers.length)) != -1) {
								out.write(buffers, 0, read);
							}
						}
						System.out.println("压缩成功，压缩文件的目录：" + zipFile.getAbsolutePath());
					}
				}
			} else {
				System.out.println(unzipFile.getAbsolutePath() + " doesn't not exists !");
				throw new RuntimeException(unzipFile.getAbsolutePath() + " doesn't not exists !");
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		} finally {
			try {
				if (null != in) {
					in.close();
				}
				if (null != out) {
					out.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 *对jpg照片进行重命名操作
	 * @param unzipFilePath  需要重命名的文件路径
	 * @param userName 用户名
	 * @param workCode 工号
	 * @param orgCode   结构代码
	 */
	public static void doRename(String unzipFilePath,String userName,String workCode,String orgCode){
		try {
			Assert.notNull(unzipFilePath,"file cannot be null");
			Assert.notNull(userName,"user name  cannot be null");
			Assert.notNull(workCode,"work code cannot be null");
			Assert.notNull(orgCode,"organization code  cannot be null");
			File unzipFile = new File(unzipFilePath);
			File[] files = unzipFile.listFiles();
			int count=0;
			for(File file :files){
				String destFilePath = file.getParent()+"/";
				String destFileName=userName+count+"-"+workCode+count+"-"+orgCode+".jpg";
				file.renameTo(new File(destFilePath+destFileName));
				count++;
			}
			System.out.println("rename successfully !");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("rename failed !");
		} finally {
		}
	}
	public static void main(String[] args) {
		//压缩文件的操作测试
		String zipPath_zip_operation = "C:\\Users\\yckj0911\\Desktop\\yyyy.zip";
		String unzipPath_zip_operation = "C:\\Users\\yckj0911\\Desktop\\人民2\\人民";
//		doZip(unzipPath_zip_operation, zipPath_zip_operation);


		//解压文件的操作测试：
		String zipPath_unzip_operation = "C:\\Users\\yckj0911\\Desktop\\yyyy.zip";
		String unzipPath_unzip_operation = "C:\\Users\\yckj0911\\Desktop\\ccc";
		if(!unzipPath_unzip_operation.endsWith(System.getProperty("file.separator"))){
			unzipPath_unzip_operation=unzipPath_unzip_operation+System.getProperty("file.separator");
		}
      //doUnzip(zipPath_unzip_operation,unzipPath_unzip_operation);
	  String need_rename_file_path= "C:\\Users\\yckj0911\\Desktop\\ccc";
      doRename(need_rename_file_path,"qls","yckj","YCKJ");
	}
}
