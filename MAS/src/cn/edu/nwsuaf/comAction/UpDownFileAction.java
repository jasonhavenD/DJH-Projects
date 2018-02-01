package cn.edu.nwsuaf.comAction;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.struts2.ServletActionContext;
import org.artofsolving.jodconverter.OfficeDocumentConverter;
import org.artofsolving.jodconverter.sample.web.WebappContext;

import cn.edu.nwsuaf.Service.Impl.FileinfoattachmentService;
import cn.edu.nwsuaf.bean.FileinfoAttachment;
import cn.edu.nwsuaf.util.FileTools;
import cn.edu.nwsuaf.util.QueryUtil;

import com.opensymphony.xwork2.ActionSupport;


/**
 * 1.上传附件
 * 2.下载附件
 * @author wal
 *
 */
public class UpDownFileAction extends ActionSupport {


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private FileinfoattachmentService fiaService=new FileinfoattachmentService();
	
	
	private File attachment;
	private String attachmentFileName;
	private FileinfoAttachment fia;
	
	private String masCode;
	private String year;
	private String attachmentId;
	
	private boolean  flag;
	private int rol;
	

	
	/**
	 * 上传附件
	 * @return
	 */
	public String uploadFile() {
		flag=false;
		try {
			System.out.println(attachment.getName());
			System.out.println(attachmentFileName+","+attachment);
			//上传附件，返回该文件在服务器上的绝对路径
			fia = fiaService.findById(FileinfoAttachment.class, attachmentId);
			
			String newFileName = FileTools.fileUp(attachment, attachmentFileName, fia.getMas().getMajor().getMname()+"/"+fia.getYear());
			if(fia.getActualPath()!=null)
			{
				FileTools.delFile(fia.getActualPath());
			}
			if(newFileName != null){
				
				fia.setActualPath(newFileName);
				fia.setUploadStatus(1);

				//如果上传不成功，则删除文件
				if(!QueryUtil.uploadFia(fia)){
					FileTools.delFile(newFileName);
				}
				else{
					flag=true;
					
					//只会把doc,docx,xls转换为pdf
					String extName=newFileName.substring(newFileName.lastIndexOf(".")+1);
			         
					if(!extName.equalsIgnoreCase("xls")&&!extName.equalsIgnoreCase("doc")&&!extName.equalsIgnoreCase("docx")){
			         	System.out.println("只允许xls、doc和docx文件类型转换为pdf！");
			         }
			         else{
			        	 //进行转换
			        	 String pdfName=newFileName.substring(0,newFileName.lastIndexOf("."))+".pdf";
			        	 WebappContext webappContext = WebappContext.get(ServletActionContext.getServletContext());
			     		 ServletFileUpload fileUpload = webappContext.getFileUpload();
			     		 OfficeDocumentConverter converter = webappContext.getDocumentConverter();
			     		 long startTime = System.currentTimeMillis();
			     		 converter.convert(new File(newFileName), new File(pdfName));
			        	 long conversionTime = System.currentTimeMillis() - startTime;
			        	 /*
			        	 Office2PDF.setOfficeHome("/opt/openoffice4/");
			        	 Office2PDF.setTimeout(60000);
			        	 String pdfName=newFileName.substring(0,newFileName.lastIndexOf("."))+".pdf";
			        	 String r=Office2PDF.convert(newFileName, pdfName);
			        	 
			        	 if(!"".equals(r))
			        		 throw new Exception(r);
			        	 */
			         }
				}
			}
			return SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
			return ERROR;
		}

	}
	/**
	 * 下载附件
	 * @return
	 * @throws UnsupportedEncodingException
	 */
	public String downloadFile() throws UnsupportedEncodingException {
		try {
			fia = fiaService.findById(FileinfoAttachment.class, attachmentId);
			String fileName = fia.getYear()+"_"+fia.getMas().getMasCode()+"_"+fia.getMas().getMajor().getMname()+fia.getActualPath().substring(fia.getActualPath().lastIndexOf("."));
			System.out.println(fileName);
			HttpServletResponse response = ServletActionContext.getResponse();
			response.setContentType("application/octet-stream");
			/*response.setContentType("text/html;charset=utf-8");*/
			//告诉浏览器有文件要下载
			//response.setHeader("Content-Disposition", "attachment;filename="+fileName);
			response.setHeader("Content-Disposition", "attachment;filename="+new String(fileName.getBytes(),"ISO8859-1"));
			
			InputStream is = null;
			OutputStream os = null;
			try {
				is = new FileInputStream(new File(fia.getActualPath()));
				os = response.getOutputStream();
				byte[] buffer = new byte[1024];
				int len = 0;
				while((len = is.read(buffer)) > 0){
					os.write(buffer, 0, len);
				}
			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				try {
					if(os != null){
						os.close();
					}
					if(is != null){
						is.close();
					}
				} catch(IOException e){
					e.printStackTrace();
				}
			}
			return  null;
		} catch (Exception e) {
			return ERROR;
		}
	}
	
	public boolean isFlag() {
		return flag;
	}
	public void setFlag(boolean flag) {
		this.flag = flag;
	}
	public int getRol() {
		return rol;
	}
	public void setRol(int rol) {
		this.rol = rol;
	}
	public File getAttachment() {
		return attachment;
	}
	public void setAttachment(File attachment) {
		this.attachment = attachment;
	}
	public String getAttachmentFileName() {
		return attachmentFileName;
	}
	public void setAttachmentFileName(String attachmentFileName) {
		this.attachmentFileName = attachmentFileName;
		
	}
	public FileinfoattachmentService getFiaService() {
		return fiaService;
	}
	public void setFiaService(FileinfoattachmentService fiaService) {
		this.fiaService = fiaService;
	}
	public FileinfoAttachment getFia() {
		return fia;
	}
	public void setFia(FileinfoAttachment fia) {
		this.fia = fia;
	}
	public String getMasCode() {
		return masCode;
	}
	public void setMasCode(String masCode) {
		this.masCode = masCode;
	}
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
	public String getAttachmentId() {
		return attachmentId;
	}
	public void setAttachmentId(String attachmentId) {
		this.attachmentId = attachmentId;
	}
}
