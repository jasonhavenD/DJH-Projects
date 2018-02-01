package com.model.action;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import alipay.config.AlipayConfig;
import alipay.util.AlipaySubmit;
import com.publicentity.AlipayDetail;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class OnlinePaymentAction extends ActionSupport implements ModelDriven<AlipayDetail> {

	AlipayDetail alipaydetail = new AlipayDetail();
	
	public String alipay() throws Exception{

		Map<String, String> sParaTemp = new HashMap<String, String>();
		sParaTemp.put("service", AlipayConfig.service);
        sParaTemp.put("partner", AlipayConfig.partner);
        sParaTemp.put("seller_id", AlipayConfig.seller_id);
        sParaTemp.put("_input_charset", AlipayConfig.input_charset);
		sParaTemp.put("payment_type", AlipayConfig.payment_type);
		sParaTemp.put("notify_url", AlipayConfig.notify_url);
		sParaTemp.put("return_url", AlipayConfig.return_url);
		sParaTemp.put("anti_phishing_key", AlipayConfig.anti_phishing_key);
		sParaTemp.put("exter_invoke_ip", AlipayConfig.exter_invoke_ip);
		sParaTemp.put("out_trade_no", alipaydetail.getOut_trade_no());
		sParaTemp.put("subject", alipaydetail.getSubject());
		sParaTemp.put("total_fee", alipaydetail.getTotal_fee());
		sParaTemp.put("body", alipaydetail.getBody());
		//其他业务参数根据在线开发文档，添加参数.文档地址:https://doc.open.alipay.com/doc2/detail.htm?spm=a219a.7629140.0.0.O9yorI&treeId=62&articleId=103740&docType=1
        //如sParaTemp.put("参数名","参数值");
		
		//建立请求
		String sHtmlText = AlipaySubmit.buildRequest(sParaTemp,"get","确认");
		HttpServletRequest request = ServletActionContext.getRequest();
		request.setAttribute("sHtmlText", sHtmlText);
		return "success2";
	}
	
	public String execute() throws Exception{

		Map<String, String> sParaTemp = new HashMap<String, String>();
		sParaTemp.put("service", AlipayConfig.service);
        sParaTemp.put("partner", AlipayConfig.partner);
        sParaTemp.put("seller_id", AlipayConfig.seller_id);
        sParaTemp.put("_input_charset", AlipayConfig.input_charset);
		sParaTemp.put("payment_type", AlipayConfig.payment_type);
		sParaTemp.put("notify_url", AlipayConfig.notify_url);
		sParaTemp.put("return_url", AlipayConfig.return_url);
		sParaTemp.put("anti_phishing_key", AlipayConfig.anti_phishing_key);
		sParaTemp.put("exter_invoke_ip", AlipayConfig.exter_invoke_ip);
		sParaTemp.put("out_trade_no", alipaydetail.getOut_trade_no());
		sParaTemp.put("subject", alipaydetail.getSubject());
		sParaTemp.put("total_fee", alipaydetail.getTotal_fee());
		sParaTemp.put("body", alipaydetail.getBody());
		//其他业务参数根据在线开发文档，添加参数.文档地址:https://doc.open.alipay.com/doc2/detail.htm?spm=a219a.7629140.0.0.O9yorI&treeId=62&articleId=103740&docType=1
        //如sParaTemp.put("参数名","参数值");
		
		//建立请求
		String sHtmlText = AlipaySubmit.buildRequest(sParaTemp,"get","确认");
		HttpServletRequest request = ServletActionContext.getRequest();
		request.setAttribute("sHtmlText", sHtmlText);
		return Action.SUCCESS;
	}
	
	public AlipayDetail getAlipaydetail() {
		return alipaydetail;
	}

	public void setAlipaydetail(AlipayDetail alipaydetail) {
		this.alipaydetail = alipaydetail;
	}

	public AlipayDetail getModel() {
		return alipaydetail;
	}

}
