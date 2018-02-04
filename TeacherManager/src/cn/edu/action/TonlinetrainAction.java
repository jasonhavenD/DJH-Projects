package cn.edu.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.struts2.ServletActionContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cn.edu.entity.json.TonlinetrainJson;
import cn.edu.hib.dao.OnlinetrainDAO;
import cn.edu.hib.entity.Tonlinetrain;
import cn.edu.hib.service.TonlinetrainService;
import cn.edu.model.Pager;

import com.opensymphony.xwork2.ActionSupport;

public class TonlinetrainAction extends ActionSupport {

	private static final Logger log = LoggerFactory
			.getLogger(OnlinetrainDAO.class);
	@Resource
	TonlinetrainService tonlinetrainService;

	private Pager pager;

	private List<Object> rows = new ArrayList();
	private List<Tonlinetrain> tonlinetrains;
	private Map<String, Object> results = new HashMap<String, Object>();

	private String rowIds;// a,b
	private TonlinetrainJson editJson;// edit
	private TonlinetrainJson addJson;// addJson

	private String trainno;// 条件查询
	private Map<String, Object> results2 = new HashMap<String, Object>();

	private boolean isExists;// 判断老师是否存在

	public String look() {
		log.error("TonlinetrainAction-look");
		return "look";
	}

	public String getUser() {
		log.error("TonlinetrainAction-getUser");
		tonlinetrains = tonlinetrainService.findAll();
		if (pager == null) {
			pager = new Pager();
			pager.setTotalPages(tonlinetrains.size() / pager.getPageSize() + 1);
		}
		pager.setTotalRows(tonlinetrains.size());
		tonlinetrains = tonlinetrainService.getUsers(pager);
		rows.clear();
		for (Tonlinetrain iter : tonlinetrains) {
			rows.add(new TonlinetrainJson(iter));
		}
		// 设置result
		results.put("pager", pager);
		results.put("rows", rows);
		return "getUser";
	}

	/**
	 * 根据页面获取数据，并且返回results
	 * 
	 * @return
	 */
	public String getUsersOfPager() {
		log.error("TonlinetrainAction-getUsersOfPager");
		tonlinetrains = tonlinetrainService.getUsers(pager);
		pager.setTotalRows(tonlinetrainService.getTotalRows());
		rows.clear();
		for (Tonlinetrain iter : tonlinetrains) {
			rows.add(new TonlinetrainJson(iter));
		}
		// 设置result
		results.put("pager", pager);
		results.put("rows", rows);
		return "getUsersOfPager";
	}

	public String getUser2() {
		log.error("TonlinetrainAction-getUser2");
		if (trainno == null) {
			System.out.println("trainno==null");
		} else {
			tonlinetrains = tonlinetrainService.findAllByContidtion(trainno);
			if (tonlinetrains == null) {
				System.out.println("tonlinetrains==null");
			} else {
				if (pager == null) {
					pager = new Pager();
					pager.setTotalPages(tonlinetrains.size()
							/ pager.getPageSize() + 1);
				}
				pager.setTotalRows(tonlinetrains.size());
				tonlinetrains = tonlinetrainService.getUsersByCondition(pager,
						trainno);
				rows.clear();
				for (Tonlinetrain iter : tonlinetrains) {
					rows.add(new TonlinetrainJson(iter));
				}
				// 设置result
				results2.put("pager", pager);
				results2.put("rows", rows);
			}
		}
		return "getUser2";
	}

	/**
	 * 根据页面获取数据，并且返回results
	 * 
	 * @return
	 */
	public String getUsersOfPager2() {
		log.error("TonlinetrainAction-getUsersOfPager2");

		if (pager == null) {
			System.out.println("pager==null");
		} else if (trainno == null) {
			System.out.println("trainno==null");
		} else {
			tonlinetrains = tonlinetrainService.getUsersByCondition(pager,
					trainno);
			if (tonlinetrains == null) {
				System.out.println("tonlinetrains==null");
			} else {
				pager.setTotalRows(tonlinetrainService.getTotalRows());
				rows.clear();
				for (Tonlinetrain iter : tonlinetrains) {
					rows.add(new TonlinetrainJson(iter));
				}
				// 设置result
				results2.put("pager", pager);
				results2.put("rows", rows);
			}
		}
		return "getUsersOfPager2";
	}

	public String delRows() {
		log.error("TonlinetrainAction-delRows");
		if (rowIds == null) {
			System.out.println("rowIds==null");
		} else {
			List<String> idList = convertToString(rowIds.split(","));
			System.out.println(idList);
			tonlinetrainService.delTonlinetrains(idList);
		}
		return "delRows";
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

	public String getOne() {
		log.error("TonlinetrainAction-getOne");
		if (rowIds == null || rowIds.length() == 0) {
			System.out.println("rowids== null");
		} else {

			Tonlinetrain tonlinetrain = tonlinetrainService
					.getTonlinetrain(rowIds);
			if (tonlinetrain != null) {
				editJson = new TonlinetrainJson(tonlinetrain);
				isExists = true;
			} else {
				editJson = new TonlinetrainJson();
				isExists = false;
			}
		}

		System.out.println("editJson=" + editJson);

		return "getOne";
	}

	public String addRow() {
		log.error("TonlinetrainAction-addRow");
		if (addJson == null) {
			System.out.println("addJson== null");
		} else {
			System.out.println(addJson);
			// System.out.println("暂时关闭添加！");
			tonlinetrainService.addTonlineTrain(addJson);
		}
		return "addRow";
	}

	public String editRow() {
		log.error("TonlinetrainAction-editRow");
		if (editJson == null) {
			System.out.println("editJson== null");
		} else {
			tonlinetrainService.editTonlineTrain(editJson);
		}
		return "editRow";
	}

	public String editRow2() {
		log.error("TonlinetrainAction-editRow2");
		if (editJson == null) {
			System.out.println("editJson== null");
		} else {
			System.out.println(editJson);
			tonlinetrainService.editTonlineTrain(editJson);
		}
		return "editRow2";
	}

	public Pager getPager() {
		return pager;
	}

	public void setPager(Pager pager) {
		this.pager = pager;
	}

	public List<Object> getRows() {
		return rows;
	}

	public void setRows(List<Object> rows) {
		this.rows = rows;
	}

	public List<Tonlinetrain> getTonlinetrains() {
		return tonlinetrains;
	}

	public void setTonlinetrains(List<Tonlinetrain> tonlinetrains) {
		this.tonlinetrains = tonlinetrains;
	}

	public Map<String, Object> getResults() {
		return results;
	}

	public void setResults(Map<String, Object> results) {
		this.results = results;
	}

	public String getRowIds() {
		return rowIds;
	}

	public void setRowIds(String rowIds) {
		this.rowIds = rowIds;
	}

	public TonlinetrainService getTonlinetrainService() {
		return tonlinetrainService;
	}

	public void setTonlinetrainService(TonlinetrainService tonlinetrainService) {
		this.tonlinetrainService = tonlinetrainService;
	}

	public TonlinetrainJson getEditJson() {
		return editJson;
	}

	public void setEditJson(TonlinetrainJson editJson) {
		this.editJson = editJson;
	}

	public TonlinetrainJson getAddJson() {
		return addJson;
	}

	public void setAddJson(TonlinetrainJson addJson) {
		this.addJson = addJson;
	}

	public String getTrainno() {
		return trainno;
	}

	public void setTrainno(String trainno) {
		this.trainno = trainno;
	}

	public Map<String, Object> getResults2() {
		return results2;
	}

	public void setResults2(Map<String, Object> results2) {
		this.results2 = results2;
	}

	public boolean isExists() {
		return isExists;
	}

	public void setExists(boolean isExists) {
		this.isExists = isExists;
	}
}
