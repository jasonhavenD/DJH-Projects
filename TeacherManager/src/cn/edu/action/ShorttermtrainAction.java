package cn.edu.action;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;

import org.apache.struts2.ServletActionContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.opensymphony.xwork2.ActionSupport;

import cn.edu.entity.json.ShorttermtrainJson;
import cn.edu.hib.dao.OnlinetrainDAO;
import cn.edu.hib.entity.Shorttermtrain;
import cn.edu.hib.entity.Teacherinfo;
import cn.edu.model.Pager;
import cn.edu.hib.service.ShorttermtrainService;

public class ShorttermtrainAction extends ActionSupport {
	/**
	 * 
	 */
	private static final Logger log = LoggerFactory
			.getLogger(OnlinetrainDAO.class);
	private static final long serialVersionUID = 1L;
	@Resource
	private ShorttermtrainService shorttermtrainService;
	private Pager pager;
	private List<ShorttermtrainJson> list = new ArrayList<ShorttermtrainJson>();
	private List<Shorttermtrain> shorttermtrains;
	private HashMap<String, Object> hashmap = new HashMap<String, Object>();
	private int tno;
	private String trainnos;//trainno + tno
	private ShorttermtrainJson shorttermtrainJson;

	public String delRows() {
		System.out.println("ShorttermtrainAction_delRows");
		if (trainnos == null)
			System.out.println("trainno=null");
		else {
			List<String> idList = converToString(trainnos.split(","));
			System.out.println(idList);
			shorttermtrainService.deleteShorttermtrain(idList);
		}
		return null;
	}
	
	public String editShorttermtrain() {
		if (shorttermtrainJson == null) 
			System.out.println("shorttermtrainJson = null");
		else {
			System.out.println("shorttermtrainJson = " + shorttermtrainJson);
			shorttermtrainService.editshorttermtrain(shorttermtrainJson);
		}		
		return "look";
	}
	public String addShorttermtrain() {
		if(shorttermtrainJson == null)
			System.out.println("shorttermtrainJson = null");
		else {
			System.out.println("shorttermtrainJson + " + shorttermtrainJson);
			shorttermtrainService.addShorttermtrain(shorttermtrainJson);
		}
		return "look";
	}

	// public String onDelete() {
	// hashmap.put("status", "delete success");
	// System.out.println(tno);
	// return "success1";
	// }

	public String findItems() {
		log.error("findItems");
		if (pager == null) {
			pager = new Pager();
		}
		shorttermtrains = shorttermtrainService.findByPager(pager);
		list.clear();
		for (Shorttermtrain iter : shorttermtrains) {
			list.add(convertToJson(iter));
		}
		hashmap.put("pager", pager);
		hashmap.put("rows", list);
		// hashmap.put("message", "success");
		return "success1";
	}
	public String findByTno(){
		System.out.println("action_findbytno");
		if (pager == null) {
			pager = new Pager();
		}
		Teacherinfo u = (Teacherinfo) ServletActionContext.getRequest()
				.getSession().getAttribute("loginedUser");
		System.out.println(u.getTno());
		shorttermtrains = shorttermtrainService.findByTno(pager,u);
		list.clear();
		for(Shorttermtrain iter : shorttermtrains) {
			list.add(convertToJson(iter));
		}
		hashmap.put("pager", pager);
		hashmap.put("rows",list);
		return"success1";
	}

	public String findById() {
		System.out.println("shorttermtrain-findbyid");
		if(trainnos == null || trainnos.length() < 1) {
			System.out.println("rowids == null");
		}else {
			Shorttermtrain shorttermtrain = shorttermtrainService.findById(trainnos);//trainno + tno
			if(shorttermtrain != null)
				shorttermtrainJson = new ShorttermtrainJson(shorttermtrain);
			else
				shorttermtrainJson = new ShorttermtrainJson();
		}
		System.out.println("editJson = "+shorttermtrainJson);
		return "findById";
	}
	
	private List<String> converToString(String[] ids) {
		// TODO Auto-generated method stub
		List<String> result = new ArrayList<String>();
		if (ids == null || ids.length < 1) {
			return null;
		}
		for (String id : ids) {
			result.add(id);
		}
		return result;
	}

	public ShorttermtrainJson convertToJson(Shorttermtrain data) {
		ShorttermtrainJson json = new ShorttermtrainJson();
		json.setTrainno(data.getId().getTrainno());
		json.setTno(data.getId().getTno());
		json.setTname(data.getTname());
		json.setTunit(data.getTunit());
		json.setAge(data.getAge());
		json.setRank(data.getRank());
		json.setEducation(data.getEducation());
		json.setDegree(data.getDegree());
		json.setTrainaddr(data.getTrainaddr());
		json.setPeriod(data.getPeriod());
		json.setNote(data.getNote());

		if (data.getStarttime() != null) {
			SimpleDateFormat datefmt = new SimpleDateFormat("yy-MM-dd");
			json.setStarttime(datefmt.format(data.getStarttime()).toString());
		} else {
			json.setStarttime("");
		}
		if (data.getEndtime() != null) {
			SimpleDateFormat datefmt = new SimpleDateFormat("yy-MM-dd");
			json.setEndtime(datefmt.format(data.getEndtime()).toString());
		} else {
			json.setEndtime("");
		}

		return json;

	}
	
	public String look() {
		log.error("ShorttermtrainAction-look");
		return "look";
	}
	public String sign_look(){
		return "sign_look";
	}

	public Pager getPager() {
		return pager;
	}

	public void setPager(Pager pager) {
		this.pager = pager;
	}

	public List<ShorttermtrainJson> getList() {
		return list;
	}

	public void setList(List<ShorttermtrainJson> list) {
		this.list = list;
	}

	public List<Shorttermtrain> getShorttermtrains() {
		return shorttermtrains;
	}

	public void setShorttermtrains(List<Shorttermtrain> shorttermtrains) {
		this.shorttermtrains = shorttermtrains;
	}

	public HashMap<String, Object> getHashmap() {
		return hashmap;
	}

	public void setHashmap(HashMap<String, Object> hashmap) {
		this.hashmap = hashmap;
	}

	public ShorttermtrainService getShorttermtrainService() {
		return shorttermtrainService;
	}

	public void setShorttermtrainService(
			ShorttermtrainService shorttermtrainService) {
		this.shorttermtrainService = shorttermtrainService;
	}

	public int getTno() {
		return tno;
	}

	public void setTno(int tno) {
		this.tno = tno;
	}

	public String getTrainnos() {
		return trainnos;
	}

	public void setTrainnos(String trainnos) {
		this.trainnos = trainnos;
	}

	public ShorttermtrainJson getShorttermtrainJson() {
		return shorttermtrainJson;
	}

	public void setShorttermtrainJson(ShorttermtrainJson shorttermtrainJson) {
		this.shorttermtrainJson = shorttermtrainJson;
	}



}
