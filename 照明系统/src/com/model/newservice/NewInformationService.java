package com.model.newservice;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.model.newdao.NewInformationDAO;
import com.newentity.NewInformation;
import com.publicentity.Page;

import java.util.*;

@Service
public class NewInformationService {
	@Resource
	NewInformationDAO newInfoDAO;

	// 根据资讯类别，获取资讯列表
	/**
	 * @param typename
	 *            资讯类别名
	 * @return
	 * @throws Exception
	 */
	public List<NewInformation> getInfoListByTypename(String typename)
			throws Exception {
		return newInfoDAO.getInfoListByTypename(typename);
	}

	// 根据资讯类别，获取资讯列表
	/**
	 * @param typeid
	 *            资讯类别ID
	 * @return
	 * @throws Exception
	 */
	public List<NewInformation> getInfoListByType(Integer typeid)
			throws Exception {
		return newInfoDAO.getInfoListByType(typeid);
	}

	// 根据资讯类别，获取资讯列表
	/**
	 * @param typeid
	 *            资讯类别ID
	 * @param Page
	 *            page pageIndex 初次加载页面为1，点击某页面时，传入当前页面页码 pageSize 当前页面显示条数
	 *            一般设为12。
	 * @return
	 * @throws Exception
	 */
	public List<NewInformation> getInfoListByType(Integer typeid, Page page)
			throws Exception {
		if (page == null || page.getPageIndex() == null
				|| page.getPageSize() == null) {
			throw new Exception("请传入分页参数");
		}
		if (page.getPageIndex() < 0 || page.getPageSize() < 0) {
			throw new Exception("请传入合法分页参数");
		}
		return newInfoDAO.getInfoListByType(typeid, page.getFromIndex(),
				page.getPageSize());
	}
	
	// 根据资讯类别，获取资讯列表
		/**
		 * @param typename
		 *            资讯类别名
		 * @param Page
		 *            page pageIndex 初次加载页面为1，点击某页面时，传入当前页面页码 pageSize 当前页面显示条数
		 *            一般设为12。
		 * @return
		 * @throws Exception
		 */
		public List<NewInformation> getInfoListByTypename(String typename, Page page)
				throws Exception {
			if (page == null || page.getPageIndex() == null
					|| page.getPageSize() == null) {
				throw new Exception("请传入分页参数");
			}
			if (page.getPageIndex() < 0 || page.getPageSize() < 0) {
				throw new Exception("请传入合法分页参数");
			}
			return newInfoDAO.getInfoListByTypename(typename, page.getFromIndex(),
					page.getPageSize());
		}

	// 根据资讯类别，获取该类别资讯的条数
	/**
	 * @param typeid
	 *            资讯类别ID
	 * @return
	 * @throws Exception
	 */
	public Integer getInfoCountByType(Integer typeid) throws Exception {
		return newInfoDAO.getInfoCountByType(typeid);
	}

	// 根据资讯类别，获取该类别资讯的条数
	/**
	 * @param typename
	 *            资讯类别名
	 * @return
	 * @throws Exception
	 */
	public Integer getInfoCountByTypename(String typename) throws Exception {
		return newInfoDAO.getInfoCountByTypename(typename);
	}

	// 根据资讯类别，获取资讯详细信息
	/**
	 * @param typeid
	 *            资讯ID
	 * @return
	 * @throws Exception
	 */
	public NewInformation getInfoDetailById(Integer id) throws Exception {
		return newInfoDAO.findById(id);
	}
}
