package cn.edu.nwsuaf.Service.Impl;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import net.sf.json.JSONArray;
import cn.edu.nwsuaf.Model.TeachBooksModel;
import cn.edu.nwsuaf.bean.Teachingbooks;
import cn.edu.nwsuaf.dao.Impl.QueryUtilDaoImpl;
import cn.edu.nwsuaf.exception.ServiceException;

public class TeachBooksService extends BaseServiceImpl<Teachingbooks> {
	@SuppressWarnings("unchecked")
	public List<Teachingbooks> findallTeachingbooksList(int page, int rows,
			String mno, String dno) {
		String hql = "from Teachingbooks tBooks ";
		List<Teachingbooks> list = null;
		if (!mno.equals("000000")) {
			hql += "where tBooks.tbno in(select tBook.teachingbooks.tbno from Teachbook tBook where tBook.teacher.major.mno=?)";
			String param[] = { mno };
			list = (List<Teachingbooks>) QueryUtilDaoImpl.executeQueryByPage(
					hql, param, page, rows);
		} else if (!dno.equals("00000") && mno.equals("000000")) {
			hql += "where tBooks.tbno in(select tBook.teachingbooks.tbno from Teachbook tBook where tBook.teacher.major.department.dno=?)";
			String param[] = { dno };
			list = (List<Teachingbooks>) QueryUtilDaoImpl.executeQueryByPage(
					hql, param, page, rows);
		} else {
			list = (List<Teachingbooks>) QueryUtilDaoImpl.executeQueryByPage(
					hql, null, page, rows);
		}
		return list;
	}

	public int count(String mno, String dno) throws ServiceException {
		int count = 0;
		String hql = "";
		if (!mno.equals("000000")) {
			hql = "select count(*) from  Teachingbooks tBooks where tBooks.tbno in(select tBook.teachingbooks.tbno from Teachbook tBook where tBook.teacher.major.mno=?)";
			String param[] = { mno };
			count = QueryUtilDaoImpl.getResultCountForHql(hql, param);
		} else if (!dno.equals("00000") && mno.equals("000000")) {
			hql = "select count(*) from Teachingbooks tBooks where tBooks.tbno in(select tBook.teachingbooks.tbno from Teachbook tBook where tBook.teacher.major.department.dno=?)";
			String param[] = { dno };
			count = QueryUtilDaoImpl.getResultCountForHql(hql, param);
		} else {
			hql = "select count(*) from Teachingbooks";
			count = QueryUtilDaoImpl.getResultCountForHql(hql, null);
		}
		return count;
	}

	@SuppressWarnings( { "unchecked" })
	// 多条件查询（教材编号、教材名称、出版时间、出版社、级别、优秀教材级别、优秀教材奖项级别、专业、学院）
	public List<Teachingbooks> findTBooksList(TeachBooksModel teachBooksModel,
			int page, int rows) throws UnsupportedEncodingException {

		String hql = "from Teachingbooks as tBooks where "
				+ "tBooks.tbname like :tbn";
		Map mapParam = new HashMap();
		// 专利名称
		teachBooksModel.setName(java.net.URLDecoder.decode(teachBooksModel.getName(),"UTF-8"));
		mapParam.put("tbn", "%" + teachBooksModel.getName() + "%");
		
		// IBSN
		if (teachBooksModel.getIsbn() != null
				&& !"".equals(teachBooksModel.getIsbn())) {
			hql += " and tBooks.isbn like :tbIS";
			mapParam.put("tbIS", "%" + teachBooksModel.getIsbn() + "%");
		}
		// 年份
		if (teachBooksModel.getYear() != null
				&& !"".equals(teachBooksModel.getYear())) {
			hql += " and tBooks.year like :tbY";
			mapParam.put("tbY", "%" + teachBooksModel.getYear() + "%");
		}
		// 出版社
		if (teachBooksModel.getPublisher() != null
				&& !"".equals(teachBooksModel.getPublisher())) {
			teachBooksModel.setPublisher(java.net.URLDecoder.decode(teachBooksModel.getPublisher(),"UTF-8"));
			hql += " and tBooks.publisher like :tbP";
			mapParam.put("tbP", "%" + teachBooksModel.getPublisher() + "%");
		}
		// 级别
		if (teachBooksModel.getTbookJibie() != null
				&& !"".equals(teachBooksModel.getTbookJibie())) {
			teachBooksModel.setTbookJibie(java.net.URLDecoder.decode(teachBooksModel.getTbookJibie(),"UTF-8"));
			hql += " and tBooks.tbookJibie like :tbJ";
			mapParam.put("tbJ", "%" + teachBooksModel.getTbookJibie() + "%");
		}
		// 优秀教材级别
		if (teachBooksModel.getTbookClass() != null
				&& !"".equals(teachBooksModel.getTbookClass())) {
			teachBooksModel.setTbookClass(java.net.URLDecoder.decode(teachBooksModel.getTbookClass(),"UTF-8"));
			hql += " and tBooks.tbookClass like :tbC";
			mapParam.put("tbC", "%" + teachBooksModel.getTbookClass() + "%");
		}
		// 优秀教材奖项级别
		if (teachBooksModel.getTbookRewardClass() != null
				&& !"".equals(teachBooksModel.getTbookRewardClass())) {
			teachBooksModel.setTbookRewardClass(java.net.URLDecoder.decode(teachBooksModel.getTbookRewardClass(),"UTF-8"));
			hql += " and tBooks.tbookRewardClass like :tbRC";
			mapParam.put("tbRC", "%" + teachBooksModel.getTbookRewardClass()
					+ "%");
		}
		// 学院
		if (teachBooksModel.getDepartmentId() != null
				&& !"".equals(teachBooksModel.getDepartmentId())) {
			hql += " and tBooks.tbno in(select tBook.teachingbooks.tbno from Teachbook tBook where tBook.teacher.major.department.dno like :dn)";
			mapParam.put("dn", "%" + teachBooksModel.getDepartmentId() + "%");
		}
		// 专业
		if (teachBooksModel.getMajorId() != null
				&& !"".equals(teachBooksModel.getMajorId())&& !"%".equals(teachBooksModel.getMajorId())) {
			hql += " and tBooks.tbno in(select tBook.teachingbooks.tbno from Teachbook tBook where tBook.teacher.major.mno like :mn)";
			mapParam.put("mn", "%" + teachBooksModel.getMajorId() + "%");
		}

		List<Teachingbooks> list = (List<Teachingbooks>) QueryUtilDaoImpl
				.executeQueryByPage(hql, null, mapParam, page, rows);
		return list;
	}

	// 查询结果条数
	@SuppressWarnings( { "unchecked" })
	public int countFindTBooks(TeachBooksModel teachBooksModel) {
		int count = 0;
		String hql = "select count(*) from Teachingbooks as tBooks where "
				+ "tBooks.tbname like :tbn";

		Map mapParam = new HashMap();
		// 专利名称
		mapParam.put("tbn", "%" + teachBooksModel.getName() + "%");
		// IBSN
		if (teachBooksModel.getIsbn() != null
				&& !"".equals(teachBooksModel.getIsbn())) {
			hql += " and tBooks.isbn like :tbIS";
			mapParam.put("tbIS", "%" + teachBooksModel.getIsbn() + "%");
		}
		// 年份
		if (teachBooksModel.getYear() != null
				&& !"".equals(teachBooksModel.getYear())) {
			hql += " and tBooks.year like :tbY";
			mapParam.put("tbY", "%" + teachBooksModel.getYear() + "%");
		}
		// 出版社
		if (teachBooksModel.getPublisher() != null
				&& !"".equals(teachBooksModel.getPublisher())) {
			hql += " and tBooks.publisher like :tbP";
			mapParam.put("tbP", "%" + teachBooksModel.getPublisher() + "%");
		}
		// 级别
		if (teachBooksModel.getTbookJibie() != null
				&& !"".equals(teachBooksModel.getTbookJibie())) {
			hql += " and tBooks.tbookJibie like :tbJ";
			mapParam.put("tbJ", "%" + teachBooksModel.getTbookJibie() + "%");
		}
		// 优秀教材级别
		if (teachBooksModel.getTbookClass() != null
				&& !"".equals(teachBooksModel.getTbookClass())) {
			hql += " and tBooks.tbookClass like :tbC";
			mapParam.put("tbC", "%" + teachBooksModel.getTbookClass() + "%");
		}
		// 优秀教材奖项级别
		if (teachBooksModel.getTbookRewardClass() != null
				&& !"".equals(teachBooksModel.getTbookRewardClass())) {
			hql += " and tBooks.tbookRewardClass like :tbRC";
			mapParam.put("tbRC", "%" + teachBooksModel.getTbookRewardClass()
					+ "%");
		}
		// 学院
		if (teachBooksModel.getDepartmentId() != null
				&& !"".equals(teachBooksModel.getDepartmentId())) {
			hql += " and tBooks.tbno in(select tBook.teachingbooks.tbno from Teachbook tBook where tBook.teacher.major.department.dno like :dn)";
			mapParam.put("dn", "%" + teachBooksModel.getDepartmentId() + "%");
		}
		// 专业
		if (teachBooksModel.getMajorId() != null
				&& !"".equals(teachBooksModel.getMajorId())&& !"%".equals(teachBooksModel.getMajorId())) {
			hql += " and tBooks.tbno in(select tBook.teachingbooks.tbno from Teachbook tBook where tBook.teacher.major.mno like :mn)";
			mapParam.put("mn", "%" + teachBooksModel.getMajorId() + "%");
		}

		count = QueryUtilDaoImpl.getResultCountForHql(hql, null, mapParam);
		System.out.println("count=======" + count);
		return count;

	}

	@SuppressWarnings( { "unchecked" })
	// 导出
	public List<Teachingbooks> exportTBooksList(TeachBooksModel teachBooksModel) {
		String hql = "from Teachingbooks as tBooks where "
				+ "tBooks.tbname like :tbn";
		Map mapParam = new HashMap();

		// 专利名称
		mapParam.put("tbn", "%" + teachBooksModel.getName() + "%");
		// IBSN
		if (teachBooksModel.getIsbn() != null
				&& !"".equals(teachBooksModel.getIsbn())) {
			hql += " and tBooks.isbn like :tbIS";
			mapParam.put("tbIS", "%" + teachBooksModel.getIsbn() + "%");
		}
		// 年份
		if (teachBooksModel.getYear() != null
				&& !"".equals(teachBooksModel.getYear())) {
			hql += " and tBooks.year like :tbY";
			mapParam.put("tbY", "%" + teachBooksModel.getYear() + "%");
		}
		// 出版社
		if (teachBooksModel.getPublisher() != null
				&& !"".equals(teachBooksModel.getPublisher())) {
			hql += " and tBooks.publisher like :tbP";
			mapParam.put("tbP", "%" + teachBooksModel.getPublisher() + "%");
		}
		// 级别
		if (teachBooksModel.getTbookJibie() != null
				&& !"".equals(teachBooksModel.getTbookJibie())) {
			hql += " and tBooks.tbookJibie like :tbJ";
			mapParam.put("tbJ", "%" + teachBooksModel.getTbookJibie() + "%");
		}
		// 优秀教材级别
		if (teachBooksModel.getTbookClass() != null
				&& !"".equals(teachBooksModel.getTbookClass())) {
			hql += " and tBooks.tbookClass like :tbC";
			mapParam.put("tbC", "%" + teachBooksModel.getTbookClass() + "%");
			System.out.println(teachBooksModel.getTbookClass());
		}
		// 优秀教材奖项级别
		if (teachBooksModel.getTbookRewardClass() != null
				&& !"".equals(teachBooksModel.getTbookRewardClass())) {
			hql += " and tBooks.tbookRewardClass like :tbRC";
			mapParam.put("tbRC", "%" + teachBooksModel.getTbookRewardClass()
					+ "%");
		}

		// 学院
		if (teachBooksModel.getDepartmentId() != null
				&& !"".equals(teachBooksModel.getDepartmentId())) {
			hql += " and tBooks.tbno in(select tBook.teachingbooks.tbno from Teachbook tBook where tBook.teacher.major.department.dno like :dn)";
			mapParam.put("dn", "%" + teachBooksModel.getDepartmentId() + "%");
		}
		// 专业
		if (teachBooksModel.getMajorId() != null
				&& !"".equals(teachBooksModel.getMajorId())&& !"%".equals(teachBooksModel.getMajorId())) {
			hql += " and tBooks.tbno in(select tBook.teachingbooks.tbno from Teachbook tBook where tBook.teacher.major.mno like :mn)";
			mapParam.put("mn", "%" + teachBooksModel.getMajorId() + "%");
		}

		List<Teachingbooks> list = (List<Teachingbooks>) QueryUtilDaoImpl
				.executeQuery(hql, null, mapParam);
		//System.out.println(list.toString());
		//System.out.println("list---------" + list);
		return list;
	}

	// 根据学院Id查专业，用于下拉列表====待完善
	public JSONArray findMajorByDno(String dno) {
		JSONArray jsonArray = QueryUtilDaoImpl.findMajorByDno(dno);
		return jsonArray;
	}

	// 返回年份列表
	@SuppressWarnings("unchecked")
	public List<String> findYearList() {
		String hql = "SELECT DISTINCT tBooks.year FROM Teachingbooks AS tBooks";
		List list = (List<String>) QueryUtilDaoImpl.executeQuery(hql, null);
		System.out.println("年份=============" + list.size());
		return list;
	}

	// 返回获奖级别
	@SuppressWarnings("unchecked")
	public List<String> findTbookJibieList() {
		String hql = "SELECT DISTINCT tBooks.tbookJibie FROM Teachingbooks AS tBooks";
		List list = (List<String>) QueryUtilDaoImpl.executeQuery(hql, null);
		System.out.println("级别=============" + list.size());
		return list;
	}

	// 返回获奖类别
	@SuppressWarnings("unchecked")
	public List<String> findTBookClassList() {
		String hql = "SELECT DISTINCT tBooks.tbookClass FROM Teachingbooks AS tBooks";
		List list = (List<String>) QueryUtilDaoImpl.executeQuery(hql, null);
		System.out.println("类别=============" + list.size());
		return list;
	}

	// 返回获奖等级
	@SuppressWarnings("unchecked")
	public List<String> findTBookRewardClassList() {
		String hql = "SELECT DISTINCT tBooks.tbookRewardClass FROM Teachingbooks AS tBooks";
		List list = (List<String>) QueryUtilDaoImpl.executeQuery(hql, null);
		System.out.println("获奖等级============" + list.size());
		return list;
	}

	// 返回出版类型
	@SuppressWarnings("unchecked")
	public List<String> findPublishTypeList() {
		String hql = "SELECT DISTINCT tBooks.publishType FROM Teachingbooks AS tBooks";
		List list = (List<String>) QueryUtilDaoImpl.executeQuery(hql, null);
		System.out.println("出版类型=============" + list.size());
		return list;
	}
	// 教材编号是否存在
	public int isExist(String isbn) {
		int count = 0;
		String hql = "select count(*) from Teachingbooks as a where "
				+ "a.isbn='"+isbn+"'";
    	count = QueryUtilDaoImpl.getResultCountForHql(hql, null,null);
		return count;
	}
	//验证ISBN是否规范
	public boolean isISBN(String isbn)
    {
		if(isbn==""){
			isbn="12";
		}
        String frontStr = isbn.substring(0, isbn.length()-1);
        String backStr = isbn.substring(isbn.length() - 1);
        boolean isNum = frontStr.matches("[0-9]+");
        if (!isNum || !(frontStr.length() == 9 || frontStr.length() == 12))
        {
            return false;
        }
       /* char[] tmp = frontStr.toCharArray();
        int sum = 0;
        int count = 10;
        if (frontStr.length() == 9)
        {//验证10位的ISBN
            for (int i = 0; i < 9; i++)
            {

                int dd = Integer.parseInt(tmp[i] + "");

                sum = sum + count * dd;

                count--;

            }
            int n = 11 - sum % 11;
            String s = "";
            if (n == 11)
            {
                s = "0";
            }
            else if (n == 10)
            {
                s = "x";
            }
            else
            {
                s = "" + n;
            }

            if (backStr.toLowerCase().equals(s))
            {
                return true;
            }
            else
            {
                return false;
            }
        }
        else if (frontStr.length() == 12)
        {//验证13位的ISBN
            String str = isbn.substring(0,3);
            if(!(str.equals("979")||str.equals("978"))){
                return false;
            }
            for (int i = 0; i < 12; i++)
            {
                int dd = Integer.parseInt(tmp[i] + "");
                if(i%2==0){
                    sum = sum +1*dd;
                }else{
                    sum = sum +3*dd;
                }
            }
            String s = ""+(10-sum%10);

            if (backStr.equals(s))
            {
                return true;
            }
            else
            {
                return false;
            }
        }*/
        else
        {
            return true;
        }

    }
}
