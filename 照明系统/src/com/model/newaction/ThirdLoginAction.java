package com.model.newaction;

import java.sql.Timestamp;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.entity.Userinfo;
import com.model.newservice.ThirdLoginService;
import com.qq.connect.QQConnectException;
import com.qq.connect.api.OpenID;
import com.qq.connect.javabeans.AccessToken;
import com.qq.connect.oauth.Oauth;

public class ThirdLoginAction {

	HttpServletRequest request = ServletActionContext.getRequest();
	private HashMap<String, Object> hashmap = new HashMap<String, Object>();

	public String QQvalidate() {
		try {
			String url = new Oauth().getAuthorizeURL(request);
			System.out.println(url);
			request.setAttribute("url", url);
			hashmap.put("url", url);
		} catch (QQConnectException e) {
			e.printStackTrace();
		}

		return "success";
	}

	public String QQLogin() {
		Userinfo userinfo = new Userinfo();
		ThirdLoginService thirdloginservice = new ThirdLoginService();
		String accessToken = null;
		String openID = null;
		try {
			AccessToken accessTokenObj = (new Oauth())
					.getAccessTokenByRequest(request);

			if (accessTokenObj.getAccessToken().equals("")) {
				System.out.print("没有获取到响应参数");
				hashmap.put("loginstate", "fail");
				return "fail";
			} else {
				accessToken = accessTokenObj.getAccessToken();// 获取accessToken

				OpenID openIDObj = new OpenID(accessToken);// 获取openID
				openID = openIDObj.getUserOpenID();

				if (thirdloginservice.validateQQ(openID)) {
					userinfo.setQq(openID);
					userinfo.setPassword(openID);
					userinfo.setMembertype(4);
					userinfo.setState(1);

					Timestamp date = new Timestamp(System.currentTimeMillis());
					userinfo.setRegisterdatetime(date);

					hashmap.put("loginstate", "success");
					hashmap.put("userinfo", userinfo);
					System.out.println("未登陆过");
				} else {
					hashmap.put("loginstate", "success");
					hashmap.put("userinfo",
							thirdloginservice.getQQuserinfo(openID));
					System.out.println("登陆过");
				}
				return "success";
			}
		} catch (QQConnectException e) {
			e.printStackTrace();
		}

		return "fail";
	}

	public HashMap<String, Object> getHashmap() {
		return hashmap;
	}

	public void setHashmap(HashMap<String, Object> hashmap) {
		this.hashmap = hashmap;
	}
}
