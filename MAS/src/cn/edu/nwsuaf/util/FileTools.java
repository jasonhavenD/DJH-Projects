package cn.edu.nwsuaf.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.UUID;

import org.apache.struts2.ServletActionContext;

public class FileTools {
	public static String getNewFileName(String fileName){
		//return UUID.randomUUID().toString()+fileName.substring(fileName.lastIndexOf("."));
		return UUID.randomUUID().toString() + "-" + fileName;
	}
	
	public static String fileUp(File file,String fileName,String saveFolder){
		boolean haveException = false;
		InputStream is = null;
		OutputStream os = null;
		File targetFile = null;//目标文件
		String newFileName = null;
		try {
			//得到文件的输入流
			is = new FileInputStream(file);
			int len = 0;
			//设置一个缓冲区
			byte[] bytes = new byte[1024];
			
			//得到/files目录的绝对路径
			String savePath = ServletActionContext.getServletContext().getRealPath("/"+saveFolder+"/@");
			savePath=savePath.replace("@", "");
			System.out.println("saveFolder"+saveFolder);
			File parent = new File(savePath);
			//如果该目录不存在，则新建
			if(!parent.exists()){
				parent.mkdirs();
			}
			//为文件新取一个名字，防止重名，重名会自动覆盖原来的
			newFileName = getNewFileName(fileName);
			
			//创建输出流
			targetFile = new File(parent,newFileName);
			os = new FileOutputStream(targetFile);
			while((len = is.read(bytes))>0){
				os.write(bytes, 0, len);
			}
			System.out.println("savePath"+savePath);
			newFileName = savePath+""+newFileName;
			System.out.println("newFileName"+newFileName);
		} catch (Exception e) {
			//发生异常，删除上传的文件
			haveException = true;
			e.printStackTrace();
			throw new RuntimeException(e.getMessage());
		} finally {
			try {
				if(os != null){
					os.close();
				}
				if(is != null){
					is.close();
				}
				//删除临时文件
				//file.delete();
				//如果发生异常-->haveException=true,则删除已上传文件
				if(haveException && targetFile != null && targetFile.exists()){
					targetFile.delete();
				}
			} catch(IOException e){
				e.printStackTrace();
			}
		}
		return haveException==true?null:newFileName;
	}
	
	//删除文件
	public static void delFile(String newFileName) {
		File file = new File(newFileName);
		if(file.exists())
			file.delete();
	}
}
