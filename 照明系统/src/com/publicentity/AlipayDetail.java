package com.publicentity;

public class AlipayDetail {
    private String out_trade_no;//商户订单号，商户网站订单系统中唯一订单号，必填
    private String subject;//订单名称，必填
    private String total_fee;//付款金额，必填
    private String body;//商品描述，可空
	public String getOut_trade_no() {
		return out_trade_no;
	}
	public void setOut_trade_no(String out_trade_no) {
		this.out_trade_no = out_trade_no;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getTotal_fee() {
		return total_fee;
	}
	public void setTotal_fee(String total_fee) {
		this.total_fee = total_fee;
	}
	public String getBody() {
		return body;
	}
	public void setBody(String body) {
		this.body = body;
	}
    
    
}
