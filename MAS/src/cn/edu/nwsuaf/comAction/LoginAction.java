package cn.edu.nwsuaf.comAction;

import java.security.MessageDigest;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import cn.edu.nwsuaf.Service.Impl.ExpertService;
import cn.edu.nwsuaf.Service.Impl.SysroleService;
import cn.edu.nwsuaf.Service.Impl.SysrolejuriService;
import cn.edu.nwsuaf.Service.Impl.SysuserinfoService;
import cn.edu.nwsuaf.bean.Expert;
import cn.edu.nwsuaf.bean.Sysrole;
import cn.edu.nwsuaf.bean.Sysrolejuri;
import cn.edu.nwsuaf.bean.Sysuserinfo;
import cn.edu.nwsuaf.util.rsa.RSAUtils;

import com.opensymphony.xwork2.ActionSupport;

/**
 * 1.用户登录（） 2.用户注销
 * 
 */
public class LoginAction extends ActionSupport {
	private static final long serialVersionUID = -2629017292622107950L;

	private SysuserinfoService sysuserinfoService;// 用户基本信息表
	private SysroleService sysroleService;// 角色管理
	private SysrolejuriService sysrolejuriService;// 角色功能
	private ExpertService expertService;// 专家

	private Sysuserinfo sysuserinfo;
	private Sysrolejuri sysrolejuri;
	private Sysrole sysrole;
	private Expert expert;

	private String returnPage;
	private String message;

	private List<Sysrolejuri> funcRoleList;
	private String major;
	private String department;

	private String chknumber;

	private List<Sysrole> sysroles;

	/**
	 * 网站进入登录界面
	 * 
	 * @return
	 */
	public String init() {
		sysroles = sysroleService.findAll(Sysrole.class);
		// 如果已经登录则直接进入系统
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		
		System.out.println("sessionid = "+session.getAttribute("sessionid"));
		
		sysuserinfo = (Sysuserinfo) session.getAttribute("userInfo");
		String userRole = (String) session.getAttribute("rol");
		if (sysuserinfo != null && userRole != null) {
			// 判断角色是否匹配
			if (userRole.equals("1")) {
				returnPage = "/protect/index.jsp";
			} else if (userRole.equals("2")) {
				returnPage = "/protect/Mindex.jsp";
			} else if (userRole.equals("3")) {
				returnPage = "/protect/Dindex.jsp";
			} else if (userRole.equals("4")) {
				returnPage = "/protect/Tindex.jsp";
			} else if (userRole.equals("5")) {//专家
				returnPage = "/protect/Pindex.jsp";
			}else if(userRole.equals("6")){//评估数据使用者
				returnPage = "/protect/Oindex.jsp";
			}
		}else{
			returnPage = "/login.jsp";
		}
		
		System.out.println("LOG: sysroles.size() = " + sysroles.size());
		return "init";
	}

	/**
	 * 用户登录
	 */
	public String login() {
		// 服务器出错，重新登录!
		if (sysuserinfoService == null || sysroleService == null) {
			return "error";
		}
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		// 先判断用户名是否为空
		System.out.println("开始");
		String userId = sysuserinfo.getUserCode();
		System.out.println("用户名：" + userId);
		String userPwd = sysuserinfo.getPassword();
		System.out.println("密码" + userPwd);
		String userRole = sysuserinfo.getSysrole().getRoleCode();
		System.out.println("角色" + userRole);
		boolean loginSuccess = false;
		String code = (String) session.getAttribute("randomCode");

		if (userId != null && !userId.equals("")) {
			// 判断验证码是否正确
			// System.out.println("判断验证码是否正确:前台"+chknumber+"后台："+code+"结果："+code.equals(chknumber));
			Sysuserinfo userinfo = new Sysuserinfo();
			if (code.equals(chknumber)) {

				if (!userRole.equals("5")) {

					userinfo = sysuserinfoService.findById(Sysuserinfo.class,
							userId);

					// 判断用户是否存在
					if (userinfo == null) {
						message = "用户名不存在";
					} else if (userinfo.getPassword().equals(userPwd)) {
						// 判断角色是否匹配
						if (userinfo.getSysrole().getRoleCode()
								.equals(userRole)) {
							String roleName = userinfo.getSysrole()
									.getRoleName();// 获取角色名称
							if (roleName.equals("系统管理员")
									&& encryptedCheck(userId, userPwd)) {
								loginSuccess = true;
								returnPage = "/protect/index.jsp";
							} else if (roleName.equals("专业负责人")
									&& encryptedCheck(userId, userPwd)) {
								loginSuccess = true;
								System.out.println("zhuanyefuzeren" + roleName);
								returnPage = "/protect/Mindex.jsp";
							} else if (roleName.equals("学院负责人")
									&& encryptedCheck(userId, userPwd)) {
								loginSuccess = true;
								returnPage = "/protect/Dindex.jsp";
							} else if (roleName.equals("教务处负责人")
									&& encryptedCheck(userId, userPwd)) {
								loginSuccess = true;
								returnPage = "/protect/Tindex.jsp";
							} else if (roleName.equals("评估数据使用者")
									&& encryptedCheck(userId, userPwd)) {
								loginSuccess = true;
								returnPage = "/protect/Oindex.jsp";
							}
							
							session.setAttribute("sessionid", userId);
							System.out.println("sessionid = "+session.getAttribute("sessionid"));
							
						} else {
							message = "角色不匹配";
							return "error";
						}

					} else {
						message = "密码错误";
						return "error";
					}
				}

				else {
					// 专家登陆
					expert = expertService.findById(Expert.class, userId);
					if (expert == null) {
						message = "用户名不存在！";
						return "error";
					}
					if (expert.getPassword().equals(userPwd)) {
						loginSuccess = true;
						returnPage = "/protect/Pindex.jsp";
					} else {
						message = "密码错误";
						return "error";
					}
				}
			} else {
				message = "验证码错误";
				return "error";
			}
			System.out.println("登录状态：" + loginSuccess);
			// 登陆成功
			if (loginSuccess && !userRole.equals("5")) {
				sysuserinfo = userinfo;
				session.setAttribute("userInfo", sysuserinfo);
				session.setAttribute("rol", userRole);
				session.setAttribute("sessionName", userinfo.getUserName());
				return "login";
			} else if (loginSuccess && userRole.equals("5")) {
				sysuserinfo = new Sysuserinfo();
				sysuserinfo.setUserCode(expert.getExpertId());

				sysuserinfo.setUserName(expert.getExpertName());
				sysuserinfo.setPassword(expert.getPassword());
				session.setAttribute("userInfo", sysuserinfo);
				session.setAttribute("rol", "5");
				session.setAttribute("sessionName", userinfo.getUserName());
				session.setAttribute("sessionid", userId);
				
				System.out.println("sessionid = "+session.getAttribute("sessionid"));
				
				return "login";
			}
		} else {
			message = "用户名不能为空";
			return "error";
		}
		return "error";
	}

	/**
	 * 用户注销
	 * 
	 * @return
	 */
	public String exit() {
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		session.removeAttribute("userInfo");
		session.removeAttribute("randomCode");
		return init();
	}

	public boolean encryptedCheck(String u, String pwd) {
		try {
			Map<String, Object> keyMap = RSAUtils.genKeyPair();
			// 内容摘要
			MessageDigest m = MessageDigest.getInstance("MD5");
			byte s[] = m.digest();
			String result = "";
			for (int i = 0; i < s.length; i++) {
				result += Integer.toHexString((0x000000ff & s[i]) | 0xffffff00)
						.substring(6);
			}
			return RSAUtils.verify(RSAUtils.SIGNATURE_ALGORITHM, u.getBytes(),
					(PublicKey) keyMap.get(RSAUtils.PUBLIC_KEY), RSAUtils.sign(
							"MD5WithRSA", u.getBytes(), (PrivateKey) keyMap
									.get(RSAUtils.PRIVATE_KEY)))
					&& RSAUtils.verify(RSAUtils.SIGNATURE_ALGORITHM, pwd
							.getBytes(), (PublicKey) keyMap
							.get(RSAUtils.PUBLIC_KEY), RSAUtils.sign(
							"MD5WithRSA", pwd.getBytes(), (PrivateKey) keyMap
									.get(RSAUtils.PRIVATE_KEY)));

		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public SysuserinfoService getSysuserinfoService() {
		return sysuserinfoService;
	}

	public void setSysuserinfoService(SysuserinfoService sysuserinfoService) {
		this.sysuserinfoService = sysuserinfoService;
	}

	public SysroleService getSysroleService() {
		return sysroleService;
	}

	public void setSysroleService(SysroleService sysroleService) {
		this.sysroleService = sysroleService;
	}

	public SysrolejuriService getSysrolejuriService() {
		return sysrolejuriService;
	}

	public void setSysrolejuriService(SysrolejuriService sysrolejuriService) {
		this.sysrolejuriService = sysrolejuriService;
	}

	public Sysuserinfo getSysuserinfo() {
		return sysuserinfo;
	}

	public void setSysuserinfo(Sysuserinfo sysuserinfo) {
		this.sysuserinfo = sysuserinfo;
	}

	public Sysrolejuri getSysrolejuri() {
		return sysrolejuri;
	}

	public void setSysrolejuri(Sysrolejuri sysrolejuri) {
		this.sysrolejuri = sysrolejuri;
	}

	public Sysrole getSysrole() {
		return sysrole;
	}

	public void setSysrole(Sysrole sysrole) {
		this.sysrole = sysrole;
	}

	public String getReturnPage() {
		return returnPage;
	}

	public void setReturnPage(String returnPage) {
		this.returnPage = returnPage;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public List<Sysrolejuri> getFuncRoleList() {
		return funcRoleList;
	}

	public void setFuncRoleList(List<Sysrolejuri> funcRoleList) {
		this.funcRoleList = funcRoleList;
	}

	public String getMajor() {
		return major;
	}

	public void setMajor(String major) {
		this.major = major;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getChknumber() {
		return chknumber;
	}

	public void setChknumber(String chknumber) {
		this.chknumber = chknumber;
	}

	public void setExpertService(ExpertService expertService) {
		this.expertService = expertService;
	}

	public List<Sysrole> getSysroles() {
		return sysroles;
	}

	public void setSysroles(List<Sysrole> sysroles) {
		this.sysroles = sysroles;
	}

}
