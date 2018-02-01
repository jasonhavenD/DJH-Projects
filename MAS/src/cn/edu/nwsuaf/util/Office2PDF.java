package cn.edu.nwsuaf.util;

import java.io.File;

import org.artofsolving.jodconverter.OfficeDocumentConverter;
import org.artofsolving.jodconverter.office.DefaultOfficeManagerConfiguration;
import org.artofsolving.jodconverter.office.OfficeManager;

public class Office2PDF {

	private static OfficeManager officeManager;
	//private static String OPEN_OFFICE_HOME = "C:/Program Files (x86)/OpenOffice 4/";
	private static String OPEN_OFFICE_HOME = "/opt/openoffice4/";
	private static int OPEN_OFFICE_PORT[] = { 8100 };
	private static long timeout=60000; //单位：毫秒，默认1分钟
	public static void main(String[] args) throws java.io.IOException {
		if (args.length < 2) {
			System.out
					.println("输入参数错误,必须指定至少2个参数.\n  office2pdf \"office路径\" \"pdf保存路径\" -env; \n -env 显示当前java运行环境;\n 目前你输入的参数个数是"
							+ args.length);
			return;
		}

		if ((args.length > 2) && args[2].equalsIgnoreCase("-env")) {// 查看java运行环境参数
			System.getProperties().storeToXML(System.out, "java 运行环境", "UTF-8");// 输出内容是utf8,所以,本java源代码也必须是utf8来保存
			System.out.println("\n\n\n");
		}

		String inputFile = args[0];
		String pdfFile = args[1];
		String r=convert(inputFile,pdfFile);
		if (r.equals("")){
			System.out.println("转换完成.\n");
		}
		else{
			System.out.println("转换失败:"+r+".\n");
		}
	}
	public static void setOfficeHome(String path){
		OPEN_OFFICE_HOME=path;
	}
	
	public static void setTimeout(long ms){
		timeout=ms;
	}
	public static String convert(String inputFile,String pdfFile)  {

		if (inputFile.isEmpty()) {
			return "待转换office路径不允许留空";
		}

		if (!pdfFile.toLowerCase().endsWith(".pdf")) {
			return "输出pdf路径必须以.pdf结尾";
		}

		try {
			System.out.println("进行文档转换转换:" + inputFile + " --> " + pdfFile);
			long startTime = System.currentTimeMillis();
			starService();
			OfficeDocumentConverter converter = new OfficeDocumentConverter(
					officeManager);
			converter.convert(new File(inputFile), new File(pdfFile));
			System.out.println("转换完成.耗时"
					+ ((System.currentTimeMillis() - startTime) /1000.0) + "秒");
			stopService();
			System.out.println("运行结束");
		} catch (Exception e) {
			e.printStackTrace();
			stopService();
			return e.getMessage();
		} 
		return "";
	}

	public static void stopService() {
		System.out.println("关闭office转换服务....");

		if (officeManager != null) {
			officeManager.stop();
		}

		System.out.println("关闭office转换成功!");
	}

	public static void starService(){
		DefaultOfficeManagerConfiguration configuration = new DefaultOfficeManagerConfiguration();

		try {
			System.out.println("准备启动安装在" + OPEN_OFFICE_HOME
					+ "目录下的openoffice服务....");
			configuration.setOfficeHome(OPEN_OFFICE_HOME);// 设置OpenOffice.org安装目录
			configuration.setPortNumbers(OPEN_OFFICE_PORT); // 设置转换端口，默认为8100
			configuration.setTaskExecutionTimeout(timeout);// 设置任务执行超时为1分钟
			configuration.setTaskQueueTimeout(1000 * 60 * 60 * 1L);// 设置任务队列超时为1小时

			officeManager = configuration.buildOfficeManager();
			officeManager.start(); // 启动服务
			System.out.println("office转换服务启动成功!");
		} catch (Exception ce) {
			System.out.println("office转换服务启动失败!详细信息:" + ce);
		}
	}
}
