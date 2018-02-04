package cn.edu.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.struts2.ServletActionContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cn.edu.entity.json.OnlinetrainJson;
import cn.edu.hib.dao.OnlinetrainDAO;
import cn.edu.hib.entity.Onlinetrain;
import cn.edu.hib.entity.Teacherinfo;
import cn.edu.hib.service.OnlinetrainService;
import cn.edu.model.Pager;

import com.opensymphony.xwork2.ActionSupport;

public class OnlinetrainAction extends ActionSupport {

	private static final Logger log = LoggerFactory
			.getLogger(OnlinetrainDAO.class);
	@Resource
	private OnlinetrainService onlineTrainService;
	private Pager pager;
	private List<Object> rows = new ArrayList();
	private List<Onlinetrain> onlinetrains;
	private Map<String, Object> results = new HashMap<String, Object>();// pager,onlinetrainJsons

	private String trainnos;// ids
	private OnlinetrainJson editJson;// edit
	private OnlinetrainJson addJson;// add

	public String look() {
		log.error("OnlinetrainAction-look");
		return "look";
	}

	public String sign_look() {
		log.error("OnlinetrainAction-sign_look");
		return "sign_look";
	}

	public String getUser() {
		log.error("OnlinetrainAction-getUser");
		onlinetrains = onlineTrainService.findAll();
		if (pager == null) {
			pager = new Pager();
			pager.setTotalPages(onlinetrains.size() / pager.getPageSize() + 1);
		}
		pager.setTotalRows(onlinetrains.size());
		onlinetrains = onlineTrainService.getUsers(pager);
		rows.clear();
		for (Onlinetrain iter : onlinetrains) {
			rows.add(new OnlinetrainJson(iter));
		}

		// 设置result
		results.put("pager", pager);
		results.put("rows", rows);

		// 添加一条标记，是否已经参加在线培训
		List<Boolean> enrollFlags = null;
		enrollFlags = onlineTrainService.getEnrollFlags();
		results.put("enrollFlags", enrollFlags);
		return "getUser";
	}

	/**
	 * 根据页面获取数据，并且返回results
	 * 
	 * @return
	 */
	public String getUsersOfPager() {
		log.error("OnlinetrainAction-getUsersOfPager");
		onlinetrains = onlineTrainService.getUsers(pager);
		pager.setTotalRows(onlineTrainService.getTotalRows());
		rows.clear();
		for (Onlinetrain iter : onlinetrains) {
			if (iter != null)
				rows.add(new OnlinetrainJson(iter));
		}
		// 设置result
		results.put("pager", pager);
		results.put("rows", rows);

		// 添加一条标记，是否已经参加在线培训
		List<Boolean> enrollFlags = null;
		enrollFlags = onlineTrainService.getEnrollFlags();
		results.put("enrollFlags", enrollFlags);
		return "getUsersOfPager";
	}

	public String delRows() {
		log.error("OnlinetrainAction-delRows");
		if (trainnos == null) {
			System.out.println("trainnos==null");
		} else {
			List<String> idList = convertToString(trainnos.split(","));
			System.out.println(idList);
			// System.out.println("暂时关闭删除功能！");
			onlineTrainService.delOnlineTrains(idList);
		}
		return "delRows";
	}

	public String editRow() {
		log.error("OnlinetrainAction-editRow");
		if (editJson == null) {
			System.out.println("editJson== null");
		} else {
			System.out.println(editJson);
			onlineTrainService.editOnlineTrain(editJson);
		}
		return "editRow";
	}

	public String addRow() {
		log.error("OnlinetrainAction-addRow");
		if (addJson == null) {
			System.out.println("addJson== null");
		} else {
			System.out.println(addJson);
			// System.out.println("暂时关闭添加！");
			onlineTrainService.addOnlineTrain(addJson);
		}
		return "addRow";
	}

	public String getOne() {
		log.error("OnlinetrainAction-getOne");
		if (trainnos == null) {
			System.out.println("trainnos== null");
		} else {
			Onlinetrain onlinetrain = onlineTrainService
					.getOnlinetrain(trainnos);
			if (onlinetrain != null) {
				editJson = new OnlinetrainJson(onlinetrain);
			} else {
				editJson = new OnlinetrainJson();
			}
			System.out.println(editJson);
		}
		return "getOne";
	}

	public String enroll() {
		log.error("OnlinetrainAction-enroll");
		if (trainnos == null) {
			System.out.println("trainnos==null");
		} else {
			Teacherinfo u = (Teacherinfo) ServletActionContext.getRequest()
					.getSession().getAttribute("loginedUser");
			onlineTrainService.enroll(u, trainnos);
		}
		return "enroll";
	}
	
	public String cancel() {
		log.error("OnlinetrainAction-cancel");
		if (trainnos == null) {
			System.out.println("trainnos==null");
		} else {
			Teacherinfo u = (Teacherinfo) ServletActionContext.getRequest()
					.getSession().getAttribute("loginedUser");
			onlineTrainService.cancel(u, trainnos);
		}
		return "cancel";
	}

	private List<String> convertToString(String[] ids) {
		List<String> result = new ArrayList<String>();
		if (ids == null || ids.length < 1) {
			return null;
		}
		for (String id : ids) {
			result.add(String.valueOf(id));
		}
		return result;
	}

	public Pager getPager() {
		return pager;
	}

	public void setPager(Pager pager) {
		this.pager = pager;
	}

	public List<Onlinetrain> getOnlinetrains() {
		return onlinetrains;
	}

	public void setOnlinetrains(List<Onlinetrain> onlinetrains) {
		this.onlinetrains = onlinetrains;
	}

	public List<Object> getRows() {
		return rows;
	}

	public void setRows(List<Object> rows) {
		this.rows = rows;
	}

	public Map<String, Object> getResults() {
		return results;
	}

	public void setResults(Map<String, Object> results) {
		this.results = results;
	}

	public OnlinetrainService getOnlineTrainService() {
		return onlineTrainService;
	}

	public void setOnlineTrainService(OnlinetrainService onlineTrainService) {
		this.onlineTrainService = onlineTrainService;
	}

	public String getTrainnos() {
		return trainnos;
	}

	public void setTrainnos(String trainnos) {
		this.trainnos = trainnos;
	}

	public OnlinetrainJson getEditJson() {
		return editJson;
	}

	public void setEditJson(OnlinetrainJson editJson) {
		this.editJson = editJson;
	}

	public OnlinetrainJson getAddJson() {
		return addJson;
	}

	public void setAddJson(OnlinetrainJson addJson) {
		this.addJson = addJson;
	}
}