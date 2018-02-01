package cn.edu.nwsuaf.Service.Impl;

import java.util.Calendar;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.ss.formula.functions.T;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import cn.edu.nwsuaf.Model.BaseModel;
import cn.edu.nwsuaf.bean.Practicecoursesummary;
import cn.edu.nwsuaf.bean.Studentculturesummary;
import cn.edu.nwsuaf.bean.Teacherinfosummary;
import cn.edu.nwsuaf.bean.Teacherresearchsummary;
import cn.edu.nwsuaf.dao.Impl.QueryUtilDaoImpl;
import cn.edu.nwsuaf.dao.Interface.IBaseDao;
import cn.edu.nwsuaf.exception.ServiceException;
import cn.edu.nwsuaf.util.HibernateUtil;

public class SummaryService extends BaseServiceImpl<Teacherinfosummary> {
	/*private List<Teacher> teacherList;
	private TeacherService teacherService=new TeacherService();*/
	// 统计信息
	public void summary() {
		System.out.println("开始更新统计数据,更新teacherinfosummary");
		teacherinfosummary();
		System.out.println("开始更新统计数据,更新teacherresearchsummary");
		teacherresearchsummary();//代码已校验
		System.out.println("开始更新统计数据,更新studentculturesummary");
		studentculturesummary();
		System.out.println("开始更新统计数据,更新PracticeCourseSummary");
		PracticeCourseSummary();
		fileinfo_attachmentsummary();
	}
	//专业教师基本情况统计
	public void teacherinfosummary() {
		//Calendar moth=Calendar.getInstance();
		//插入每个学院有学籍的学生的专业和年份
		//String sql0="insert into teacherinfosummary(Mno,year) select distinct Mno,year from student where isRoll='有学籍'order by Mno,year";
		//String sql01 ="delete from teacherinfosummary where teacherinfosummary.year=''";
		//String sql00="update teacherinfosummary set year=(year+1)";
		//String sql000="insert into teacherinfosummary (Mno)  select mno from major where mno not in (select distinct mno from teacherinfosummary )";
		//String sql000="insert into teacherinfosummary (Mno)  select mno from major where mno not in (select distinct mno from teacherinfosummary where teacherinfosummary.year=(select MAX(year) from teacherinfosummary))";
		//String sql0001="update teacherinfosummary t set t.year =(select c.max from (select MAX(year)as max from teacherinfosummary)c) where t.year is null";
		
		
		String sql = "delete from teacherinfosummary";
		//调用存储过程，使每个专业都有近3年的年份
		String sqlCall="call  _init_t_summary()";
		
		//教职工数
		String sql1 = "update teacherinfosummary set FacultyNumber =(select a.num from " +
					  "(select teacher.Mno,teacherinfosummary.`year`,count(*) num from teacherinfosummary,teacher where " +
					  "teacherinfosummary.Mno=teacher.Mno and date_format(teacher.EntryDate,'%Y')<=teacherinfosummary.`year`  and date_format(teacher.EntryDate,'%Y')<>''  and teacher.InServiceState='在职' " +
					  "group by teacher.Mno,teacherinfosummary.`year`) a  " +
					  "where a.Mno= teacherinfosummary.Mno and a.`year`= teacherinfosummary.year)";
		String sql1_null="update teacherinfosummary t set t.FacultyNumber=0 where t.FacultyNumber is null";
		
		//专任教师数
		String sql2 ="update teacherinfosummary set ProfessionaTteacherNumbers =" +
		 "(select a.num from " +
		 "(select teacher.Mno,teacherinfosummary.`year`,count(*) num " +
		 "from teacherinfosummary,teacher,teacherscategory where " +
		 "teacherinfosummary.Mno=teacher.Mno and teacher.TeachersCategoryNo=teacherscategory.TeachersCategoryNo  and date_format(teacher.EntryDate,'%Y')<=teacherinfosummary.`year`  and date_format(teacher.EntryDate,'%Y')<>''  " +
		 "and teacher.InServiceState='在职' and teacherscategory.TeachersCategoryNo='01' "+
		 "group by teacher.Mno,teacherinfosummary.`year`) a  " +
		 "where a.Mno= teacherinfosummary.Mno and a.`year`= teacherinfosummary.year)";
		String sql2_null="update teacherinfosummary t set t.ProfessionaTteacherNumbers=0 where t.ProfessionaTteacherNumbers is null";

		
		//学生人数
		String sql13="update teacherinfosummary set stuNumber = (SELECT COUNT(*) FROM student WHERE teacherinfosummary.Mno=student.Mno AND CAST(student.year AS SIGNED INTEGER) <= cast(teacherinfosummary.year as signed INTEGER)  AND  CAST(student.year AS SIGNED INTEGER) >= CAST(teacherinfosummary.year AS SIGNED INTEGER) - 3 AND student.grade<>'' GROUP BY student.Mno,teacherinfosummary.`year`)";
		String sql13_null="update teacherinfosummary t set t.stuNumber=0 where t.stuNumber is null";

		
		//师生比
		/*String sql3="update teacherinfosummary set StudentsTeachersRatio =(select t.tsnum from " +
					"(select Mno,year,FacultyNumber/stuNumber as tsnum from teacherinfosummary where stuNumber<>'' group by teacherinfosummary.Mno,teacherinfosummary.`year`) t  " +
					"where t.Mno=teacherinfosummary.Mno and t.year=teacherinfosummary.year)";*/
		String sql3_null="update teacherinfosummary t set t.StudentsTeachersRatio=0.00 where t.StudentsTeachersRatio is null";

		
		//博士人数
		String sql4 ="UPDATE teacherinfosummary SET DoctorNumber = ( SELECT COUNT(*) FROM teacher,degree WHERE teacher.Mno = teacherinfosummary.Mno AND degree.DegreeNo = teacher.DegreeNo AND DATE_FORMAT(teacher.EntryDate,'%Y')<=teacherinfosummary.`year`  AND DATE_FORMAT(teacher.EntryDate,'%Y')<>''  AND teacher.InServiceState='在职' AND degree.DegreeName = '博士研究生' GROUP BY teacher.Mno,teacherinfosummary.`year`)";
		String sql4_null="update teacherinfosummary t set t.DoctorNumber=0 where t.DoctorNumber is null";

		
		//教授人数
		String sql5 ="update teacherinfosummary set ProfessorNuber =" +
		 "(select a.num from " +
		 "(select teacher.Mno,teacherinfosummary.`year`,count(*) num " +
		 "from teacherinfosummary,teacher,professionaltitle where " +
		 "teacherinfosummary.Mno=teacher.Mno and teacher.ProfessionalTitleNo=professionaltitle.ProfessionalTitleNo and date_format(teacher.EntryDate,'%Y')<=teacherinfosummary.`year`  and date_format(teacher.EntryDate,'%Y')<>''  and teacher.InServiceState='在职' and professionaltitle.ProfessionalTitleName = '教授' " +
		 "group by teacher.Mno,teacherinfosummary.`year`) a  " +
		 "where a.Mno= teacherinfosummary.Mno and a.`year`= teacherinfosummary.year)";
		String sql5_null="update teacherinfosummary t set t.ProfessorNuber=0 where t.ProfessorNuber is null";

		
		//副教授人数
		String sql6 ="update teacherinfosummary set AssociateProfessorNumber =" +
		 "(select a.num from " +
		 "(select teacher.Mno,teacherinfosummary.`year`,count(*) num " +
		 "from teacherinfosummary,teacher,professionaltitle where " +
		 "teacherinfosummary.Mno=teacher.Mno and teacher.ProfessionalTitleNo=professionaltitle.ProfessionalTitleNo and date_format(teacher.EntryDate,'%Y')<=teacherinfosummary.`year`  and date_format(teacher.EntryDate,'%Y')<>''  and teacher.InServiceState='在职' and professionaltitle.ProfessionalTitleName = '副教授' " +
		 "group by teacher.Mno,teacherinfosummary.`year`) a  " +
		 "where a.Mno= teacherinfosummary.Mno and a.`year`= teacherinfosummary.year)";
		String sql6_null="update teacherinfosummary t set t.AssociateProfessorNumber=0 where t.AssociateProfessorNumber is null";

		
		//国家级人才数
		String sql7 ="update teacherinfosummary set Talentnuber1 =" +
		 "(select a.num from " +
		 "(select teacher.Mno,teacherinfosummary.`year`,count(*) num " +
		 "from teacherinfosummary,teacher,highleveltalent where " +
		 "teacherinfosummary.Mno=teacher.Mno and teacher.Tno=highleveltalent.Tno and date_format(teacher.EntryDate,'%Y')<=teacherinfosummary.`year`  and date_format(teacher.EntryDate,'%Y')<>''  and teacher.InServiceState='在职' and highleveltalent.TalentLevel='国家级' " +
		 "group by teacher.Mno,teacherinfosummary.`year`) a  " +
		 "where a.Mno= teacherinfosummary.Mno and a.`year`= teacherinfosummary.year)";
		String sql7_null="update teacherinfosummary t set t.Talentnuber1=0 where t.Talentnuber1 is null";

		
		//省级人才数
		String sql8 ="update teacherinfosummary set Talentnuber2 =" +
		 "(select a.num from " +
		 "(select teacher.Mno,teacherinfosummary.`year`,count(*) num " +
		 "from teacherinfosummary,teacher,highleveltalent where " +
		 "teacherinfosummary.Mno=teacher.Mno and teacher.Tno=highleveltalent.Tno and date_format(teacher.EntryDate,'%Y')<=teacherinfosummary.`year`  and date_format(teacher.EntryDate,'%Y')<>''  and teacher.InServiceState='在职' and highleveltalent.TalentLevel='省级' " +
		 "group by teacher.Mno,teacherinfosummary.`year`) a  " +
		 "where a.Mno= teacherinfosummary.Mno and a.`year`= teacherinfosummary.year)";
		String sql8_null="update teacherinfosummary t set t.Talentnuber2=0 where t.Talentnuber2 is null";

		
		//校级人才数
		String sql9 ="update teacherinfosummary set Talentnuber3 =" +
		 "(select a.num from " +
		 "(select teacher.Mno,teacherinfosummary.`year`,count(*) num " +
		 "from teacherinfosummary,teacher,highleveltalent where " +
		 "teacherinfosummary.Mno=teacher.Mno and teacher.Tno=highleveltalent.Tno and date_format(teacher.EntryDate,'%Y')<=teacherinfosummary.`year`  and date_format(teacher.EntryDate,'%Y')<>''  and teacher.InServiceState='在职' and highleveltalent.TalentLevel='校级' " +
		 "group by teacher.Mno,teacherinfosummary.`year`) a  " +
		 "where a.Mno= teacherinfosummary.Mno and a.`year`= teacherinfosummary.year)";
		String sql9_null="update teacherinfosummary t set t.Talentnuber3=0 where t.Talentnuber3 is null";

		
		
		//行业经历人数
		String sql10 ="update teacherinfosummary set industryExperienceNumber =" +
		 "(select a.num from " +
		 "(select teacher.Mno,teacherinfosummary.`year`,count(*) num " +
		 "from teacherinfosummary,teacher where " +
		 "teacherinfosummary.Mno=teacher.Mno  and date_format(teacher.EntryDate,'%Y')<=teacherinfosummary.`year`  and date_format(teacher.EntryDate,'%Y')<>''  and teacher.InServiceState='在职' and teacher.IsIndustryBackground = '是' " +
		 "group by teacher.Mno,teacherinfosummary.`year`) a  " +
		 "where a.Mno= teacherinfosummary.Mno and a.`year`= teacherinfosummary.year)";
		String sql10_null="update teacherinfosummary t set t.industryExperienceNumber=0 where t.industryExperienceNumber is null";

		
		//中青年专业教师人数
		String sql11 ="update teacherinfosummary set youngTeacherNumber =" +
		 "(select a.num from " +
		 "(select teacher.Mno,teacherinfosummary.`year`,count(*) num " +
		 "from teacherinfosummary,teacher,teacherscategory where " +
		 "teacherinfosummary.Mno=teacher.Mno and teacher.TeachersCategoryNo=teacherscategory.TeachersCategoryNo  and date_format(teacher.EntryDate,'%Y')<=teacherinfosummary.`year`  and date_format(teacher.EntryDate,'%Y')<>''  " +
		 "and teacher.InServiceState='在职' and teacherscategory.TeachersCategoryNo='01' and  " +
		 Calendar.getInstance().get(Calendar.YEAR)+ " - year(Birthday)<45 "+
		 "group by teacher.Mno,teacherinfosummary.`year`) a  " +
		 "where a.Mno= teacherinfosummary.Mno and a.`year`= teacherinfosummary.year)";
		String sql11_null="update teacherinfosummary t set t.youngTeacherNumber=0 where t.youngTeacherNumber is null";

		
		//中青年专业教师参加培训人数
		String sql12 ="update teacherinfosummary set trainTeacherNumber =" +
		 "(select a.num from " +
		 "(select teacher.Mno,teacherinfosummary.`year`,count(*) num " +
		 "from teacherinfosummary,teacher,teacherscategory where " +
		 "teacherinfosummary.Mno=teacher.Mno and teacher.TeachersCategoryNo=teacherscategory.TeachersCategoryNo  and date_format(teacher.EntryDate,'%Y')<=teacherinfosummary.`year`  and teacher.year<>''  " +
		 "and teacher.InServiceState='在职' and teacherscategory.TeachersCategoryNo='01' and  teacher.IsPracticeTeachTraining='是' and " +
		 Calendar.getInstance().get(Calendar.YEAR)+ " - year(Birthday)<45 "+
		 "group by teacher.Mno,teacherinfosummary.`year`) a  " +
		 "where a.Mno= teacherinfosummary.Mno and a.`year`= teacherinfosummary.year)";
		String sql12_null="update teacherinfosummary t set t.trainTeacherNumber=0 where t.trainTeacherNumber is null";
		
		//把所有的属性Null值设置为0
		
		
		try {
			this.execute(sql);
			this.execute(sqlCall);
			
			/*this.execute(sql0);
			if(moth.get(Calendar.MONTH)<9){
				this.execute(sql00);
			}
			this.execute(sql000);
			this.execute(sql0001);*/
			//this.execute(sql01);
			this.execute(sql1);
			this.execute(sql1_null);
			this.execute(sql2);
			this.execute(sql2_null);
			//this.execute(sql3);
			this.execute(sql3_null);
			this.execute(sql4);
			this.execute(sql4_null);
			this.execute(sql5);
			this.execute(sql5_null);
			this.execute(sql6);
			this.execute(sql6_null);
			this.execute(sql7);
			this.execute(sql7_null);
			this.execute(sql8);
			this.execute(sql8_null);
			this.execute(sql9);
			this.execute(sql9_null);
			this.execute(sql10);
			this.execute(sql10_null);
			this.execute(sql11);
			this.execute(sql11_null);
			this.execute(sql12);
			this.execute(sql12_null);
			this.execute(sql13);
			this.execute(sql13_null);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	//教学科研情况统计
	public void teacherresearchsummary() {
		//Calendar moth=Calendar.getInstance();
		// 先插入专业号和年份，专业号和年份的对应是根据八个基础数据表中存在的所有的专业号和年份
		/*String sql0 = "insert into teacherresearchsummary(Mno,year)"
				+ "select teacher.Mno,publicshedaacademicpapers.`year` from teacher,publicshedaacademicpapers where teacher.Tno=publicshedaacademicpapers.Tno "
				+ "union select teacher.Mno,presidedoverscientificresearchproject.year from teacher,presidedoverscientificresearchproject where teacher.Tno=presidedoverscientificresearchproject.Tno "
				+ "union select teacher.Mno,publicshedarevolutionpapers.year from teacher,publicshedarevolutionpapers where teacher.Tno=publicshedarevolutionpapers.Tno "
				+ "union select teacher.Mno,presidedoverrevolutionresearchproject.year from teacher,presidedoverrevolutionresearchproject where teacher.Tno=presidedoverrevolutionresearchproject.Tno "
				+ "union select teacher.Mno,teachingbooks.year from teacher,teachingbooks ,teachbook where teacher.Tno=teachbook.Tno and teachbook.TBno=teachingbooks.TBno "
				+ "union select teacher.Mno,teachproject.year from teacher,teachproject,teachprojectuser where teacher.Tno=teachprojectuser.Tno and  teachprojectuser.TProjectNo=teachproject.TProjectNo "
				+ "union select teacher.Mno,teachresultbaseinfo.year from teacher,teachresultbaseinfo,teachresult where teacher.Tno=teachresult.Tno and teachresult.TResultBaseNo=teachresultbaseinfo.TResultBaseNo "
				+ "union select teacher.Mno,achievements.certificateDate from teacher,achievements, teacherachievements where teacher.Tno=teacherachievements.Tno and teacherachievements.CertificateNo=achievements.CertificateNo ";
		String sql00="update teacherresearchsummary set year=(year+1)";
		//String sql000="insert into teacherresearchsummary (mno)  select mno from major where mno not in (select distinct mno from teacherresearchsummary )";
		String sql000="insert into teacherresearchsummary (Mno)  select mno from major where mno not in (select distinct mno from teacherresearchsummary where teacherresearchsummary.year=(select MAX(year) from teacherresearchsummary))";
		String sql0001="update teacherresearchsummary t set t.year =(select c.max from (select MAX(year)as max from teacherresearchsummary)c) where t.year is null";*/
		
		
		//已放到存储过程中
		//String sql = "delete from teacherresearchsummary"; 
		
		//调用存储过程，使每个专业都有近3年的年份
		String sqlCall="call  _init_tr_summary()";
		
		// 科研学术论文
		String sql1 = "update teacherresearchsummary set researchPaperNumber1 = (select count(*) from teacher,publicshedaacademicpapers where teacher.Tno=publicshedaacademicpapers.tno and publicshedaacademicpapers.periodicalType in('EI','SCI','SSCI') and teacherresearchsummary.Mno = teacher.Mno and  teacherresearchsummary.year= publicshedaacademicpapers.year group by teacher.Mno,publicshedaacademicpapers.year )";
		String sql1_null="update teacherresearchsummary t set t.ResearchPaperNumber1=0 where t.ResearchPaperNumber1 is null";

		String sql2 = "update teacherresearchsummary set researchPaperNumber2 = (select count(*) from teacher,publicshedaacademicpapers where teacher.Tno=publicshedaacademicpapers.tno and publicshedaacademicpapers.periodicalType ='A类' and teacherresearchsummary.Mno = teacher.Mno and  teacherresearchsummary.year= publicshedaacademicpapers.year group by teacher.Mno,publicshedaacademicpapers.year )";
		String sql2_null="update teacherresearchsummary t set t.ResearchPaperNumber2=0 where t.ResearchPaperNumber2 is null";

		String sql3 = "update teacherresearchsummary set researchPaperNumber3 = (select count(*) from teacher,publicshedaacademicpapers where teacher.Tno=publicshedaacademicpapers.tno and publicshedaacademicpapers.periodicalType ='B类' and teacherresearchsummary.Mno = teacher.Mno and  teacherresearchsummary.year= publicshedaacademicpapers.year group by teacher.Mno,publicshedaacademicpapers.year )";
		String sql3_null="update teacherresearchsummary t set t.ResearchPaperNumber3=0 where t.ResearchPaperNumber3 is null";

		// 科研项目数

		String sql4 = "update teacherresearchsummary set researchProjectNumber1 = (select count(*) from teacher,presidedoverscientificresearchproject where teacher.Tno=presidedoverscientificresearchproject.tno and presidedoverscientificresearchproject.ProjecJibie ='国家级' and teacherresearchsummary.Mno = teacher.Mno and  teacherresearchsummary.year= presidedoverscientificresearchproject.year group by teacher.Mno,presidedoverscientificresearchproject.year )";
		String sql4_null="update teacherresearchsummary t set t.researchProjectNumber1=0 where t.researchProjectNumber1 is null";

		String sql5 = "update teacherresearchsummary set researchProjectNumber2 = (select count(*) from teacher,presidedoverscientificresearchproject where teacher.Tno=presidedoverscientificresearchproject.tno and presidedoverscientificresearchproject.ProjecJibie like '省%' and teacherresearchsummary.Mno = teacher.Mno and  teacherresearchsummary.year= presidedoverscientificresearchproject.year group by teacher.Mno,presidedoverscientificresearchproject.year )";
		String sql5_null="update teacherresearchsummary t set t.researchProjectNumber2=0 where t.researchProjectNumber2 is null";

		String sql6 = "update teacherresearchsummary set researchProjectNumber3 = (select count(*) from teacher,presidedoverscientificresearchproject where teacher.Tno=presidedoverscientificresearchproject.tno and presidedoverscientificresearchproject.ProjecJibie not in('国家级','省级','省部级','省部级委托') and teacherresearchsummary.Mno = teacher.Mno and  teacherresearchsummary.year= presidedoverscientificresearchproject.year group by teacher.Mno,presidedoverscientificresearchproject.year )";
		String sql6_null="update teacherresearchsummary t set t.researchProjectNumber3=0 where t.researchProjectNumber3 is null";
/**********************************************************************/
		// 不是科研奖励
		//是教改论文数量
		String sql7 = "update teacherresearchsummary set educationProjectNumber1 = (select count(*) from teacher,publicshedarevolutionpapers where teacher.Tno=publicshedarevolutionpapers.tno and publicshedarevolutionpapers.PeriodicalType = 'A类' and teacherresearchsummary.Mno = teacher.Mno and  teacherresearchsummary.year= publicshedarevolutionpapers.year group by teacher.Mno,publicshedarevolutionpapers.year )";
		String sql7_null="update teacherresearchsummary t set t.educationProjectNumber1=0 where t.educationProjectNumber1 is null";

		String sql8 = "update teacherresearchsummary set educationProjectNumber2 = (select count(*) from teacher,publicshedarevolutionpapers where teacher.Tno=publicshedarevolutionpapers.tno and publicshedarevolutionpapers.PeriodicalType = 'B类' and teacherresearchsummary.Mno = teacher.Mno and  teacherresearchsummary.year= publicshedarevolutionpapers.year group by teacher.Mno,publicshedarevolutionpapers.year )";
		String sql8_null="update teacherresearchsummary t set t.educationProjectNumber2=0 where t.educationProjectNumber2 is null";

		String sql9 = "update teacherresearchsummary set educationProjectNumber3 = (select count(*) from teacher,publicshedarevolutionpapers where teacher.Tno=publicshedarevolutionpapers.tno and publicshedarevolutionpapers.PeriodicalType = '公开发表' and teacherresearchsummary.Mno = teacher.Mno and  teacherresearchsummary.year= publicshedarevolutionpapers.year group by teacher.Mno,publicshedarevolutionpapers.year )";
		String sql9_null="update teacherresearchsummary t set t.educationProjectNumber3=0 where t.educationProjectNumber3 is null";

		// 教改项目
		String sql10 = "update teacherresearchsummary set educationPaperNumber1 = (select count(*) from teacher,presidedoverrevolutionresearchproject where teacher.Tno=presidedoverrevolutionresearchproject.tno and presidedoverrevolutionresearchproject.RProjecJibie = '省级' and teacherresearchsummary.Mno = teacher.Mno and  teacherresearchsummary.year= presidedoverrevolutionresearchproject.year group by presidedoverrevolutionresearchproject.RProjecJibie,teacher.Mno,presidedoverrevolutionresearchproject.year )";
		String sql10_null="update teacherresearchsummary t set t.educationPaperNumber1=0 where t.educationPaperNumber1 is null";

		String sql11 = "update teacherresearchsummary set educationPaperNumber2 = (select count(*) from teacher,presidedoverrevolutionresearchproject where teacher.Tno=presidedoverrevolutionresearchproject.tno and presidedoverrevolutionresearchproject.RProjecJibie = '校级' and teacherresearchsummary.Mno = teacher.Mno and  teacherresearchsummary.year= presidedoverrevolutionresearchproject.year group by presidedoverrevolutionresearchproject.RProjecJibie,teacher.Mno,presidedoverrevolutionresearchproject.year )";
		String sql11_null="update teacherresearchsummary t set t.educationPaperNumber2=0 where t.educationPaperNumber2 is null";

		String sql12 = "update teacherresearchsummary set educationPaperNumber3 = (select count(*) from teacher,presidedoverrevolutionresearchproject where teacher.Tno=presidedoverrevolutionresearchproject.tno and presidedoverrevolutionresearchproject.RProjecJibie not in('省级','校级') and teacherresearchsummary.Mno = teacher.Mno and  teacherresearchsummary.year= presidedoverrevolutionresearchproject.year group by teacher.Mno,presidedoverrevolutionresearchproject.year )";
		String sql12_null="update teacherresearchsummary t set t.educationPaperNumber3=0 where t.educationPaperNumber3 is null";

		// 教材编写

		String sql13 = "update teacherresearchsummary set textbookNumber1 = (select count(*) from teacher,teachbook,teachingbooks where teacher.Tno=teachbook.tno and teachbook.TBno=teachingbooks.TBno  and teachbook.AuthorJuese = '主编' and teacherresearchsummary.Mno = teacher.Mno and  teacherresearchsummary.year= teachingbooks.year group by teachbook.AuthorJuese,teacher.Mno,teachingbooks.year )";
		String sql13_null="update teacherresearchsummary t set t.textbookNumber1=0 where t.textbookNumber1 is null";

		String sql14 = "update teacherresearchsummary set textbookNumber2 = (select count(*) from teacher,teachbook,teachingbooks where teacher.Tno=teachbook.tno and teachbook.TBno=teachingbooks.TBno  and teachbook.AuthorJuese = '副主编' and teacherresearchsummary.Mno = teacher.Mno and  teacherresearchsummary.year= teachingbooks.year group by teachbook.AuthorJuese,teacher.Mno,teachingbooks.year )";
		String sql14_null="update teacherresearchsummary t set t.textbookNumber2=0 where t.textbookNumber2 is null";

		String sql15 = "update teacherresearchsummary set textbookNumber3 = (select count(*) from teacher,teachbook,teachingbooks where teacher.Tno=teachbook.tno and teachbook.TBno=teachingbooks.TBno  and teachbook.AuthorJuese = '参编' and teacherresearchsummary.Mno = teacher.Mno and  teacherresearchsummary.year= teachingbooks.year group by teachbook.AuthorJuese,teacher.Mno,teachingbooks.year )";
		String sql15_null="update teacherresearchsummary t set t.textbookNumber3=0 where t.textbookNumber3 is null";

		// 质量工程数

		String sql16 = "update teacherresearchsummary set qualitylEngineeringNumber1 = (select count(*) from teacher,teachproject,teachprojectuser where teacher.Tno=teachprojectuser.tno and teachprojectuser.TProjectNo=teachproject.TProjectNo  and teachproject.TProjecJibie = '国家级' and teacherresearchsummary.Mno = teacher.Mno and  teacherresearchsummary.year= teachproject.year group by teacher.Mno,teachproject.year )";
		String sql16_null="update teacherresearchsummary t set t.qualitylEngineeringNumber1=0 where t.qualitylEngineeringNumber1 is null";

		String sql17 = "update teacherresearchsummary set qualitylEngineeringNumber2 = (select count(*) from teacher,teachproject,teachprojectuser where teacher.Tno=teachprojectuser.tno and teachprojectuser.TProjectNo=teachproject.TProjectNo  and teachproject.TProjecJibie like '%省%' and teacherresearchsummary.Mno = teacher.Mno and  teacherresearchsummary.year= teachproject.year group by teacher.Mno,teachproject.year )";
		String sql17_null="update teacherresearchsummary t set t.qualitylEngineeringNumber2=0 where t.qualitylEngineeringNumber2 is null";

		String sql18 = "update teacherresearchsummary set qualitylEngineeringNumber3 = (select count(*) from teacher,teachproject,teachprojectuser where teacher.Tno=teachprojectuser.tno and teachprojectuser.TProjectNo=teachproject.TProjectNo  and teachproject.TProjecJibie = '校级' and teacherresearchsummary.Mno = teacher.Mno and  teacherresearchsummary.year= teachproject.year group by teacher.Mno,teachproject.year )";
		String sql18_null="update teacherresearchsummary t set t.qualitylEngineeringNumber3=0 where t.qualitylEngineeringNumber3 is null";

		// 教学成果奖

		String sql19 = "update teacherresearchsummary set teachingAchievementNumber11 = (select count(*) from teacher,teachresult,teachresultbaseinfo where teacher.Tno=teachresult.tno and  teachresultbaseinfo.TResultBaseNo=teachresult.TResultBaseNo  and teachresultbaseinfo.TResultJibie = '国家级' and teachresultbaseinfo.TResultClass='特等奖' and  teacherresearchsummary.Mno = teacher.Mno and  teacherresearchsummary.year= teachresultbaseinfo.year group by teachresultbaseinfo.TResultJibie,teachresultbaseinfo.TResultClass,teacher.Mno,teachresultbaseinfo.year )";
		String sql19_null="update teacherresearchsummary t set t.teachingAchievementNumber11=0 where t.teachingAchievementNumber11 is null";

		String sql20 = "update teacherresearchsummary set teachingAchievementNumber12 = (select count(*) from teacher,teachresult,teachresultbaseinfo where teacher.Tno=teachresult.tno and  teachresultbaseinfo.TResultBaseNo=teachresult.TResultBaseNo  and teachresultbaseinfo.TResultJibie = '省级' and teachresultbaseinfo.TResultClass='特等奖' and  teacherresearchsummary.Mno = teacher.Mno and  teacherresearchsummary.year= teachresultbaseinfo.year group by teachresultbaseinfo.TResultJibie,teachresultbaseinfo.TResultClass,teacher.Mno,teachresultbaseinfo.year )";
		String sql20_null="update teacherresearchsummary t set t.teachingAchievementNumber12=0 where t.teachingAchievementNumber12 is null";

		String sql21 = "update teacherresearchsummary set teachingAchievementNumber13 = (select count(*) from teacher,teachresult,teachresultbaseinfo where teacher.Tno=teachresult.tno and  teachresultbaseinfo.TResultBaseNo=teachresult.TResultBaseNo  and teachresultbaseinfo.TResultJibie = '校级' and teachresultbaseinfo.TResultClass='特等奖' and  teacherresearchsummary.Mno = teacher.Mno and  teacherresearchsummary.year= teachresultbaseinfo.year group by teachresultbaseinfo.TResultJibie,teachresultbaseinfo.TResultClass,teacher.Mno,teachresultbaseinfo.year )";
		String sql21_null="update teacherresearchsummary t set t.teachingAchievementNumber13=0 where t.teachingAchievementNumber13 is null";

		String sql22 = "update teacherresearchsummary set teachingAchievementNumber21 = (select count(*) from teacher,teachresult,teachresultbaseinfo where teacher.Tno=teachresult.tno and  teachresultbaseinfo.TResultBaseNo=teachresult.TResultBaseNo  and teachresultbaseinfo.TResultJibie = '国家级' and teachresultbaseinfo.TResultClass='一等奖' and  teacherresearchsummary.Mno = teacher.Mno and  teacherresearchsummary.year= teachresultbaseinfo.year group by teachresultbaseinfo.TResultJibie,teachresultbaseinfo.TResultClass,teacher.Mno,teachresultbaseinfo.year )";
		String sql22_null="update teacherresearchsummary t set t.teachingAchievementNumber21=0 where t.teachingAchievementNumber21 is null";

		String sql23 = "update teacherresearchsummary set teachingAchievementNumber22 = (select count(*) from teacher,teachresult,teachresultbaseinfo where teacher.Tno=teachresult.tno and  teachresultbaseinfo.TResultBaseNo=teachresult.TResultBaseNo  and teachresultbaseinfo.TResultJibie = '省级' and teachresultbaseinfo.TResultClass='一等奖' and  teacherresearchsummary.Mno = teacher.Mno and  teacherresearchsummary.year= teachresultbaseinfo.year group by teachresultbaseinfo.TResultJibie,teachresultbaseinfo.TResultClass,teacher.Mno,teachresultbaseinfo.year )";
		String sql23_null="update teacherresearchsummary t set t.teachingAchievementNumber22=0 where t.teachingAchievementNumber22 is null";

		String sql24 = "update teacherresearchsummary set teachingAchievementNumber23 = (select count(*) from teacher,teachresult,teachresultbaseinfo where teacher.Tno=teachresult.tno and  teachresultbaseinfo.TResultBaseNo=teachresult.TResultBaseNo  and teachresultbaseinfo.TResultJibie = '校级' and teachresultbaseinfo.TResultClass='一等奖' and  teacherresearchsummary.Mno = teacher.Mno and  teacherresearchsummary.year= teachresultbaseinfo.year group by teachresultbaseinfo.TResultJibie,teachresultbaseinfo.TResultClass,teacher.Mno,teachresultbaseinfo.year )";
		String sql24_null="update teacherresearchsummary t set t.teachingAchievementNumber23=0 where t.teachingAchievementNumber23 is null";

		String sql25 = "UPDATE teacherresearchsummary SET teachingAchievementNumber31 = ( SELECT COUNT(*) FROM teacher,teachresult,teachresultbaseinfo WHERE teacher.Tno = teachresult.Tno AND teachresult.TResultBaseNo = teachresultbaseinfo.TResultBaseNo AND teacherresearchsummary.Mno = teacher.Mno AND teacherresearchsummary.year = teachresultbaseinfo.year AND TResultJibie = '国家级'AND teachresultbaseinfo.TResultClass='二等奖' group by teachresultbaseinfo.TResultClass,teacher.Mno,teachresultbaseinfo.year)";
		String sql25_null="update teacherresearchsummary t set t.teachingAchievementNumber31=0 where t.teachingAchievementNumber31 is null";

		String sql26 = "update teacherresearchsummary set teachingAchievementNumber32 = (select count(*) from teacher,teachresult,teachresultbaseinfo where teacher.Tno=teachresult.tno and  teachresultbaseinfo.TResultBaseNo=teachresult.TResultBaseNo  and teachresultbaseinfo.TResultJibie = '省级' and teachresultbaseinfo.TResultClass='二等奖' and  teacherresearchsummary.Mno = teacher.Mno and  teacherresearchsummary.year= teachresultbaseinfo.year group by teachresultbaseinfo.TResultJibie,teachresultbaseinfo.TResultClass,teacher.Mno,teachresultbaseinfo.year )";
		String sql26_null="update teacherresearchsummary t set t.teachingAchievementNumber32=0 where t.teachingAchievementNumber32 is null";

		String sql27 = "update teacherresearchsummary set teachingAchievementNumber33 = (select count(*) from teacher,teachresult,teachresultbaseinfo where teacher.Tno=teachresult.tno and  teachresultbaseinfo.TResultBaseNo=teachresult.TResultBaseNo  and teachresultbaseinfo.TResultJibie = '校级' and teachresultbaseinfo.TResultClass='二等奖' and  teacherresearchsummary.Mno = teacher.Mno and  teacherresearchsummary.year= teachresultbaseinfo.year group by teachresultbaseinfo.TResultJibie,teachresultbaseinfo.TResultClass,teacher.Mno,teachresultbaseinfo.year )";
		String sql27_null="update teacherresearchsummary t set t.teachingAchievementNumber33=0 where t.teachingAchievementNumber33 is null";

		// 科研奖励

		String sql28 = "update teacherresearchsummary set researchAwardNumber111 = (select count(*) from teacher,teacherachievements,achievements where teacher.Tno=teacherachievements.tno and  achievements.CertificateNo=teacherachievements.CertificateNo  and achievements.CertificateJibie = '国家级' and achievements.CertificateClass='一等奖' and  teacherachievements.TeachRank='1' and teacherresearchsummary.Mno = teacher.Mno and  teacherresearchsummary.year= achievements.certificateDate group by  teacherresearchsummary.Mno, teacherresearchsummary.`year`,achievements.CertificateJibie,achievements.CertificateClass, teacherachievements.TeachRank )";
		String sql28_null="update teacherresearchsummary t set t.researchAwardNumber111=0 where t.researchAwardNumber111 is null";

		String sql29 = "update teacherresearchsummary set researchAwardNumber112 = (select count(*) from teacher,teacherachievements,achievements where teacher.Tno=teacherachievements.tno and  achievements.CertificateNo=teacherachievements.CertificateNo  and achievements.CertificateJibie = '省级' and achievements.CertificateClass='一等奖' and  teacherachievements.TeachRank='1' and teacherresearchsummary.Mno = teacher.Mno and  teacherresearchsummary.year= achievements.certificateDate group by teacherresearchsummary.Mno,  teacherresearchsummary.`year`,achievements.CertificateJibie,achievements.CertificateClass, teacherachievements.TeachRank )";
		String sql29_null="update teacherresearchsummary t set t.researchAwardNumber112=0 where t.researchAwardNumber112 is null";

		String sql30 = "update teacherresearchsummary set researchAwardNumber113 = (select count(*) from teacher,teacherachievements,achievements where teacher.Tno=teacherachievements.tno and  achievements.CertificateNo=teacherachievements.CertificateNo  and achievements.CertificateJibie = '校级' and achievements.CertificateClass='一等奖' and  teacherachievements.TeachRank='1' and teacherresearchsummary.Mno = teacher.Mno and  teacherresearchsummary.year= achievements.certificateDate group by  teacherresearchsummary.Mno, teacherresearchsummary.`year`,achievements.CertificateJibie,achievements.CertificateClass, teacherachievements.TeachRank )";
		String sql30_null="update teacherresearchsummary t set t.researchAwardNumber113=0 where t.researchAwardNumber113 is null";

		String sql31 = "update teacherresearchsummary set researchAwardNumber121 = (select count(*) from teacher,teacherachievements,achievements where teacher.Tno=teacherachievements.tno and  achievements.CertificateNo=teacherachievements.CertificateNo  and achievements.CertificateJibie = '国家级' and achievements.CertificateClass='二等奖' and  teacherachievements.TeachRank='1' and teacherresearchsummary.Mno = teacher.Mno and  teacherresearchsummary.year= achievements.certificateDate group by  teacherresearchsummary.Mno, teacherresearchsummary.`year`,achievements.CertificateJibie,achievements.CertificateClass, teacherachievements.TeachRank )";
		String sql31_null="update teacherresearchsummary t set t.researchAwardNumber121=0 where t.researchAwardNumber121 is null";

		String sql32 = "update teacherresearchsummary set researchAwardNumber122 = (select count(*) from teacher,teacherachievements,achievements where teacher.Tno=teacherachievements.tno and  achievements.CertificateNo=teacherachievements.CertificateNo  and achievements.CertificateJibie = '省级' and achievements.CertificateClass='二等奖' and  teacherachievements.TeachRank='1' and teacherresearchsummary.Mno = teacher.Mno and  teacherresearchsummary.year= achievements.certificateDate group by  teacherresearchsummary.Mno, teacherresearchsummary.`year`,achievements.CertificateJibie,achievements.CertificateClass, teacherachievements.TeachRank )";
		String sql32_null="update teacherresearchsummary t set t.researchAwardNumber122=0 where t.researchAwardNumber122 is null";

		String sql33 = "update teacherresearchsummary set researchAwardNumber123 = (select count(*) from teacher,teacherachievements,achievements where teacher.Tno=teacherachievements.tno and  achievements.CertificateNo=teacherachievements.CertificateNo  and achievements.CertificateJibie = '校级' and achievements.CertificateClass='二等奖' and  teacherachievements.TeachRank='1' and teacherresearchsummary.Mno = teacher.Mno and  teacherresearchsummary.year= achievements.certificateDate group by  teacherresearchsummary.Mno, teacherresearchsummary.`year`,achievements.CertificateJibie,achievements.CertificateClass, teacherachievements.TeachRank )";
		String sql33_null="update teacherresearchsummary t set t.researchAwardNumber123=0 where t.researchAwardNumber123 is null";

		String sql34 = "update teacherresearchsummary set researchAwardNumber131 = (select count(*) from teacher,teacherachievements,achievements where teacher.Tno=teacherachievements.tno and  achievements.CertificateNo=teacherachievements.CertificateNo  and achievements.CertificateJibie = '国家级' and achievements.CertificateClass='三等奖' and  teacherachievements.TeachRank='1' and teacherresearchsummary.Mno = teacher.Mno and  teacherresearchsummary.year= achievements.certificateDate group by  teacherresearchsummary.Mno, teacherresearchsummary.`year`,achievements.CertificateJibie,achievements.CertificateClass, teacherachievements.TeachRank )";
		String sql34_null="update teacherresearchsummary t set t.researchAwardNumber131=0 where t.researchAwardNumber131 is null";

		String sql35 = "update teacherresearchsummary set researchAwardNumber132 = (select count(*) from teacher,teacherachievements,achievements where teacher.Tno=teacherachievements.tno and  achievements.CertificateNo=teacherachievements.CertificateNo  and achievements.CertificateJibie = '省级' and achievements.CertificateClass='三等奖' and  teacherachievements.TeachRank='1' and teacherresearchsummary.Mno = teacher.Mno and  teacherresearchsummary.year= achievements.certificateDate group by  teacherresearchsummary.Mno, teacherresearchsummary.`year`,achievements.CertificateJibie,achievements.CertificateClass, teacherachievements.TeachRank )";
		String sql35_null="update teacherresearchsummary t set t.researchAwardNumber132=0 where t.researchAwardNumber132 is null";

		String sql36 = "update teacherresearchsummary set researchAwardNumber133 = (select count(*) from teacher,teacherachievements,achievements where teacher.Tno=teacherachievements.tno and  achievements.CertificateNo=teacherachievements.CertificateNo  and achievements.CertificateJibie = '校级' and achievements.CertificateClass='三等奖' and  teacherachievements.TeachRank='1' and teacherresearchsummary.Mno = teacher.Mno and  teacherresearchsummary.year= achievements.certificateDate group by  teacherresearchsummary.Mno, teacherresearchsummary.`year`,achievements.CertificateJibie,achievements.CertificateClass, teacherachievements.TeachRank )";
		String sql36_null="update teacherresearchsummary t set t.researchAwardNumber133=0 where t.researchAwardNumber133 is null";
		
		String sql37 = "update teacherresearchsummary set researchAwardNumber211 = (select count(*) from teacher,teacherachievements,achievements where teacher.Tno=teacherachievements.tno and  achievements.CertificateNo=teacherachievements.CertificateNo  and achievements.CertificateJibie = '国家级' and achievements.CertificateClass='一等奖' and  teacherachievements.TeachRank='2' and teacherresearchsummary.Mno = teacher.Mno and  teacherresearchsummary.year= achievements.certificateDate group by  teacherresearchsummary.Mno, teacherresearchsummary.`year`,achievements.CertificateJibie,achievements.CertificateClass, teacherachievements.TeachRank )";
		String sql37_null="update teacherresearchsummary t set t.researchAwardNumber211=0 where t.researchAwardNumber211 is null";

		String sql38 = "update teacherresearchsummary set researchAwardNumber212 = (select count(*) from teacher,teacherachievements,achievements where teacher.Tno=teacherachievements.tno and  achievements.CertificateNo=teacherachievements.CertificateNo  and achievements.CertificateJibie = '省级' and achievements.CertificateClass='一等奖' and  teacherachievements.TeachRank='2' and teacherresearchsummary.Mno = teacher.Mno and  teacherresearchsummary.year= achievements.certificateDate group by  teacherresearchsummary.Mno, teacherresearchsummary.`year`,achievements.CertificateJibie,achievements.CertificateClass, teacherachievements.TeachRank )";
		String sql38_null="update teacherresearchsummary t set t.researchAwardNumber212=0 where t.researchAwardNumber212 is null";

		String sql39 = "update teacherresearchsummary set researchAwardNumber213 = (select count(*) from teacher,teacherachievements,achievements where teacher.Tno=teacherachievements.tno and  achievements.CertificateNo=teacherachievements.CertificateNo  and achievements.CertificateJibie = '校级' and achievements.CertificateClass='一等奖' and  teacherachievements.TeachRank='2' and teacherresearchsummary.Mno = teacher.Mno and  teacherresearchsummary.year= achievements.certificateDate group by  teacherresearchsummary.Mno, teacherresearchsummary.`year`,achievements.CertificateJibie,achievements.CertificateClass, teacherachievements.TeachRank )";
		String sql39_null="update teacherresearchsummary t set t.researchAwardNumber213=0 where t.researchAwardNumber213 is null";

		String sql40 = "update teacherresearchsummary set researchAwardNumber221 = (select count(*) from teacher,teacherachievements,achievements where teacher.Tno=teacherachievements.tno and  achievements.CertificateNo=teacherachievements.CertificateNo  and achievements.CertificateJibie = '国家级' and achievements.CertificateClass='二等奖' and  teacherachievements.TeachRank='2' and teacherresearchsummary.Mno = teacher.Mno and  teacherresearchsummary.year= achievements.certificateDate group by  teacherresearchsummary.Mno, teacherresearchsummary.`year`,achievements.CertificateJibie,achievements.CertificateClass, teacherachievements.TeachRank )";
		String sql40_null="update teacherresearchsummary t set t.researchAwardNumber221=0 where t.researchAwardNumber221 is null";

		String sql41 = "update teacherresearchsummary set researchAwardNumber222 = (select count(*) from teacher,teacherachievements,achievements where teacher.Tno=teacherachievements.tno and  achievements.CertificateNo=teacherachievements.CertificateNo  and achievements.CertificateJibie = '省级' and achievements.CertificateClass='二等奖' and  teacherachievements.TeachRank='2' and teacherresearchsummary.Mno = teacher.Mno and  teacherresearchsummary.year= achievements.certificateDate group by  teacherresearchsummary.Mno, teacherresearchsummary.`year`,achievements.CertificateJibie,achievements.CertificateClass, teacherachievements.TeachRank )";
		String sql41_null="update teacherresearchsummary t set t.researchAwardNumber222=0 where t.researchAwardNumber222 is null";

		String sql42 = "update teacherresearchsummary set researchAwardNumber223 = (select count(*) from teacher,teacherachievements,achievements where teacher.Tno=teacherachievements.tno and  achievements.CertificateNo=teacherachievements.CertificateNo  and achievements.CertificateJibie = '校级' and achievements.CertificateClass='二等奖' and  teacherachievements.TeachRank='2' and teacherresearchsummary.Mno = teacher.Mno and  teacherresearchsummary.year= achievements.certificateDate group by  teacherresearchsummary.Mno, teacherresearchsummary.`year`,achievements.CertificateJibie,achievements.CertificateClass, teacherachievements.TeachRank )";
		String sql42_null="update teacherresearchsummary t set t.researchAwardNumber223=0 where t.researchAwardNumber223 is null";

		String sql43 = "update teacherresearchsummary set researchAwardNumber231 = (select count(*) from teacher,teacherachievements,achievements where teacher.Tno=teacherachievements.tno and  achievements.CertificateNo=teacherachievements.CertificateNo  and achievements.CertificateJibie = '国家级' and achievements.CertificateClass='三等奖' and  teacherachievements.TeachRank='2' and teacherresearchsummary.Mno = teacher.Mno and  teacherresearchsummary.year= achievements.certificateDate group by  teacherresearchsummary.Mno, teacherresearchsummary.`year`,achievements.CertificateJibie,achievements.CertificateClass, teacherachievements.TeachRank )";
		String sql43_null="update teacherresearchsummary t set t.researchAwardNumber231=0 where t.researchAwardNumber231 is null";

		String sql44 = "update teacherresearchsummary set researchAwardNumber232 = (select count(*) from teacher,teacherachievements,achievements where teacher.Tno=teacherachievements.tno and  achievements.CertificateNo=teacherachievements.CertificateNo  and achievements.CertificateJibie = '省级' and achievements.CertificateClass='三等奖' and  teacherachievements.TeachRank='2' and teacherresearchsummary.Mno = teacher.Mno and  teacherresearchsummary.year= achievements.certificateDate group by  teacherresearchsummary.Mno, teacherresearchsummary.`year`,achievements.CertificateJibie,achievements.CertificateClass, teacherachievements.TeachRank )";
		String sql44_null="update teacherresearchsummary t set t.researchAwardNumber232=0 where t.researchAwardNumber232 is null";

		String sql45 = "update teacherresearchsummary set researchAwardNumber233 = (select count(*) from teacher,teacherachievements,achievements where teacher.Tno=teacherachievements.tno and  achievements.CertificateNo=teacherachievements.CertificateNo  and achievements.CertificateJibie = '校级' and achievements.CertificateClass='三等奖' and  teacherachievements.TeachRank='2' and teacherresearchsummary.Mno = teacher.Mno and  teacherresearchsummary.year= achievements.certificateDate group by  teacherresearchsummary.Mno, teacherresearchsummary.`year`,achievements.CertificateJibie,achievements.CertificateClass, teacherachievements.TeachRank )";
		String sql45_null="update teacherresearchsummary t set t.researchAwardNumber233=0 where t.researchAwardNumber233 is null";
		
		String sql46 = "update teacherresearchsummary set researchAwardNumber311 = (select count(*) from teacher,teacherachievements,achievements where teacher.Tno=teacherachievements.tno and  achievements.CertificateNo=teacherachievements.CertificateNo  and achievements.CertificateJibie = '国家级' and achievements.CertificateClass='一等奖' and  teacherachievements.TeachRank ='3' and teacherresearchsummary.Mno = teacher.Mno and  teacherresearchsummary.year= achievements.certificateDate group by  teacherresearchsummary.Mno, teacherresearchsummary.`year`,achievements.CertificateJibie,achievements.CertificateClass, teacherachievements.TeachRank )";
		String sql46_null="update teacherresearchsummary t set t.researchAwardNumber311=0 where t.researchAwardNumber311 is null";

		String sql47 = "update teacherresearchsummary set researchAwardNumber312 = (select count(*) from teacher,teacherachievements,achievements where teacher.Tno=teacherachievements.tno and  achievements.CertificateNo=teacherachievements.CertificateNo  and achievements.CertificateJibie = '省级' and achievements.CertificateClass='一等奖' and  teacherachievements.TeachRank ='3' and teacherresearchsummary.Mno = teacher.Mno and  teacherresearchsummary.year= achievements.certificateDate group by  teacherresearchsummary.Mno, teacherresearchsummary.`year`,achievements.CertificateJibie,achievements.CertificateClass, teacherachievements.TeachRank )";
		String sql47_null="update teacherresearchsummary t set t.researchAwardNumber312=0 where t.researchAwardNumber312 is null";

		String sql48 = "update teacherresearchsummary set researchAwardNumber313 = (select count(*) from teacher,teacherachievements,achievements where teacher.Tno=teacherachievements.tno and  achievements.CertificateNo=teacherachievements.CertificateNo  and achievements.CertificateJibie = '校级' and achievements.CertificateClass='一等奖' and  teacherachievements.TeachRank ='3' and teacherresearchsummary.Mno = teacher.Mno and  teacherresearchsummary.year= achievements.certificateDate group by  teacherresearchsummary.Mno, teacherresearchsummary.`year`,achievements.CertificateJibie,achievements.CertificateClass, teacherachievements.TeachRank )";
		String sql48_null="update teacherresearchsummary t set t.researchAwardNumber313=0 where t.researchAwardNumber313 is null";

		String sql49 = "update teacherresearchsummary set researchAwardNumber321 = (select count(*) from teacher,teacherachievements,achievements where teacher.Tno=teacherachievements.tno and  achievements.CertificateNo=teacherachievements.CertificateNo  and achievements.CertificateJibie = '国家级' and achievements.CertificateClass='二等奖' and  teacherachievements.TeachRank='3' and teacherresearchsummary.Mno = teacher.Mno and  teacherresearchsummary.year= achievements.certificateDate group by  teacherresearchsummary.Mno, teacherresearchsummary.`year`,achievements.CertificateJibie,achievements.CertificateClass, teacherachievements.TeachRank )";
		String sql49_null="update teacherresearchsummary t set t.researchAwardNumber321=0 where t.researchAwardNumber321 is null";

		String sql50 = "update teacherresearchsummary set researchAwardNumber322 = (select count(*) from teacher,teacherachievements,achievements where teacher.Tno=teacherachievements.tno and  achievements.CertificateNo=teacherachievements.CertificateNo  and achievements.CertificateJibie = '省级' and achievements.CertificateClass='二等奖' and  teacherachievements.TeachRank='3' and teacherresearchsummary.Mno = teacher.Mno and  teacherresearchsummary.year= achievements.certificateDate group by  teacherresearchsummary.Mno, teacherresearchsummary.`year`,achievements.CertificateJibie,achievements.CertificateClass, teacherachievements.TeachRank )";
		String sql50_null="update teacherresearchsummary t set t.researchAwardNumber322=0 where t.researchAwardNumber322 is null";

		String sql51 = "update teacherresearchsummary set researchAwardNumber323 = (select count(*) from teacher,teacherachievements,achievements where teacher.Tno=teacherachievements.tno and  achievements.CertificateNo=teacherachievements.CertificateNo  and achievements.CertificateJibie = '校级' and achievements.CertificateClass='二等奖' and  teacherachievements.TeachRank='3' and teacherresearchsummary.Mno = teacher.Mno and  teacherresearchsummary.year= achievements.certificateDate group by  teacherresearchsummary.Mno, teacherresearchsummary.`year`,achievements.CertificateJibie,achievements.CertificateClass, teacherachievements.TeachRank )";
		String sql51_null="update teacherresearchsummary t set t.researchAwardNumber323=0 where t.researchAwardNumber323 is null";

		String sql52 = "update teacherresearchsummary set researchAwardNumber331 = (select count(*) from teacher,teacherachievements,achievements where teacher.Tno=teacherachievements.tno and  achievements.CertificateNo=teacherachievements.CertificateNo  and achievements.CertificateJibie = '国家级' and achievements.CertificateClass='三等奖' and  teacherachievements.TeachRank='3' and teacherresearchsummary.Mno = teacher.Mno and  teacherresearchsummary.year= achievements.certificateDate group by  teacherresearchsummary.`year`,achievements.CertificateJibie,achievements.CertificateClass, teacherachievements.TeachRank )";
		String sql52_null="update teacherresearchsummary t set t.researchAwardNumber331=0 where t.researchAwardNumber331 is null";

		String sql53 = "update teacherresearchsummary set researchAwardNumber332 = (select count(*) from teacher,teacherachievements,achievements where teacher.Tno=teacherachievements.tno and  achievements.CertificateNo=teacherachievements.CertificateNo  and achievements.CertificateJibie = '省级' and achievements.CertificateClass='三等奖' and  teacherachievements.TeachRank='3' and teacherresearchsummary.Mno = teacher.Mno and  teacherresearchsummary.year= achievements.certificateDate group by  teacherresearchsummary.`year`,achievements.CertificateJibie,achievements.CertificateClass, teacherachievements.TeachRank )";
		String sql53_null="update teacherresearchsummary t set t.researchAwardNumber332=0 where t.researchAwardNumber332 is null";

		String sql54 = "update teacherresearchsummary set researchAwardNumber333 = (select count(*) from teacher,teacherachievements,achievements where teacher.Tno=teacherachievements.tno and  achievements.CertificateNo=teacherachievements.CertificateNo  and achievements.CertificateJibie = '校级' and achievements.CertificateClass='三等奖' and  teacherachievements.TeachRank='3' and teacherresearchsummary.Mno = teacher.Mno and  teacherresearchsummary.year= achievements.certificateDate group by  teacherresearchsummary.`year`,achievements.CertificateJibie,achievements.CertificateClass, teacherachievements.TeachRank )";
		String sql54_null="update teacherresearchsummary t set t.researchAwardNumber333=0 where t.researchAwardNumber333 is null";

		try {
			//this.execute(sql);
			this.execute(sqlCall);
			/*this.execute(sql0);
			if(moth.get(Calendar.MONTH)<9){
				this.execute(sql00);
			}
			this.execute(sql000);
			this.execute(sql0001);*/
			this.execute(sql1);
			this.execute(sql1_null);
			this.execute(sql2);
			this.execute(sql2_null);
			this.execute(sql3);
			this.execute(sql3_null);

			this.execute(sql4);
			this.execute(sql4_null);
			this.execute(sql5);
			this.execute(sql5_null);
			this.execute(sql6);
			this.execute(sql6_null);

			this.execute(sql7);
			this.execute(sql7_null);
			this.execute(sql8);
			this.execute(sql8_null);
			this.execute(sql9);
			this.execute(sql9_null);

			this.execute(sql10);
			this.execute(sql10_null);
			this.execute(sql11);
			this.execute(sql11_null);
			this.execute(sql12);
			this.execute(sql12_null);

			this.execute(sql13);
			this.execute(sql13_null);
			this.execute(sql14);
			this.execute(sql14_null);
			this.execute(sql15);
			this.execute(sql15_null);

			this.execute(sql16);
			this.execute(sql16_null);
			this.execute(sql17);
			this.execute(sql17_null);
			this.execute(sql18);
			this.execute(sql18_null);

			this.execute(sql19);
			this.execute(sql19_null);
			this.execute(sql20);
			this.execute(sql20_null);
			this.execute(sql21);
			this.execute(sql21_null);
			this.execute(sql22);
			this.execute(sql22_null);
			this.execute(sql23);
			this.execute(sql23_null);
			this.execute(sql24);
			this.execute(sql24_null);
			this.execute(sql25);
			this.execute(sql25_null);
			this.execute(sql26);
			this.execute(sql26_null);
			this.execute(sql27);
			this.execute(sql27_null);

			this.execute(sql28);
			this.execute(sql28_null);
			this.execute(sql29);
			this.execute(sql29_null);
			this.execute(sql30);
			this.execute(sql30_null);
			this.execute(sql31);
			this.execute(sql31_null);
			this.execute(sql32);
			this.execute(sql32_null);
			this.execute(sql33);
			this.execute(sql33_null);
			this.execute(sql34);
			this.execute(sql34_null);
			this.execute(sql35);
			this.execute(sql35_null);
			this.execute(sql36);
			this.execute(sql36_null);
			
			this.execute(sql37);
			this.execute(sql37_null);
			this.execute(sql38);
			this.execute(sql38_null);
			this.execute(sql39);
			this.execute(sql39_null);
			this.execute(sql40);
			this.execute(sql40_null);
			this.execute(sql41);
			this.execute(sql41_null);
			this.execute(sql42);
			this.execute(sql42_null);
			this.execute(sql43);
			this.execute(sql43_null);
			this.execute(sql44);
			this.execute(sql44_null);
			this.execute(sql45);
			this.execute(sql45_null);
			
			this.execute(sql46);
			this.execute(sql46_null);
			this.execute(sql47);
			this.execute(sql47_null);
			this.execute(sql48);
			this.execute(sql48_null);
			this.execute(sql49);
			this.execute(sql49_null);
			this.execute(sql50);
			this.execute(sql50_null);
			this.execute(sql51);
			this.execute(sql51_null);
			this.execute(sql52);
			this.execute(sql52_null);
			this.execute(sql53);
			this.execute(sql53_null);
			this.execute(sql54);
			this.execute(sql54_null);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// 学生培养情况统计计算
	public void studentculturesummary() {
		//Calendar moth=Calendar.getInstance();
		/*//String sql01 ="delete from studentculturesummary where studentculturesummary.year=''";
		//插入每个学院有学籍的学生的专业和年份
		String sql0="insert into studentculturesummary(Mno,year) select distinct Mno,year from student where isRoll='有学籍'order by Mno,year";
		String sql00="update studentculturesummary set year=(year+1)";
		//String sql000="insert into studentculturesummary (mno)  select mno from major where mno not in (select distinct mno from studentculturesummary )";
		String sql000="insert into studentculturesummary (Mno)  select mno from major where mno not in (select distinct mno from studentculturesummary where studentculturesummary.year=(select MAX(year) from studentculturesummary))";
		String sql0001="update studentculturesummary t set t.year =(select c.max from (select MAX(year)as max from studentculturesummary)c) where t.year is null";*/
		
		
		//String sql = "delete from studentculturesummary";
		//调用存储过程，使每个专业都有近3年的年份
		String sqlCall="call  _init_s_summary()";
		
		//在籍学生人数
		String sql1 = "UPDATE studentculturesummary SET studentNumber =(SELECT COUNT(*) FROM student WHERE student.Mno=studentculturesummary.mno AND  CAST(student.year AS SIGNED INTEGER) <= CAST(studentculturesummary.year AS SIGNED INTEGER)  AND CAST(student.year AS SIGNED INTEGER) >= CAST(studentculturesummary.year AS SIGNED INTEGER) - 3 GROUP BY studentculturesummary.mno,studentculturesummary.year)";
		String sql1_null="update studentculturesummary t set t.studentNumber=0 where t.studentNumber is null";

		//学术论文数
		String sql2 = "update studentculturesummary set ResearchPaperNumber =(select count(*) from student,stuthesis where student.stuNumber=stuthesis.stuNumber " +
				"and student.Mno=studentculturesummary.mno and studentculturesummary.`year`=stuthesis.`year` group by student.mno,stuthesis.year)";
		String sql2_null="update studentculturesummary t set t.ResearchPaperNumber=0 where t.ResearchPaperNumber is null";

		
		//专利数
		String sql3 = "update studentculturesummary set PatentNumber =(select count(*) from student,stupatent where student.stuNumber=stupatent.stuNumber " +
				"and student.Mno=studentculturesummary.mno and studentculturesummary.`year`=stupatent.`year` group by student.mno,stupatent.year)";
		String sql3_null="update studentculturesummary t set t.PatentNumber=0 where t.PatentNumber is null";

		

		//国家级竞赛人数
		String sql4 = "update studentculturesummary set RaceNumber1 =(select count(*) from student,studentcoepetition,competition where " +
				"student.stuNumber=studentcoepetition.stuNumber  and studentcoepetition.comNumber = competition.comNumber and competition.comType = '国家级' " +
				"and studentcoepetition.rank='1' and student.Mno=studentculturesummary.mno and studentculturesummary.`year`=competition.`year` " +
				"group by competition.comType,studentcoepetition.rank='1',student.mno,competition.year)";
		String sql4_null="update studentculturesummary t set t.RaceNumber1=0 where t.RaceNumber1 is null";

		//省级竞赛人数
		String sql5 = "update studentculturesummary set RaceNumber2 =(select count(*) from student,studentcoepetition,competition where " +
				"student.stuNumber=studentcoepetition.stuNumber  and studentcoepetition.comNumber = competition.comNumber and competition.comType = '省级' " +
				"and studentcoepetition.rank='1' and student.Mno=studentculturesummary.mno and studentculturesummary.`year`=competition.`year` " +
				"group by competition.comType,studentcoepetition.rank='1',student.mno,competition.year)";
		String sql5_null="update studentculturesummary t set t.RaceNumber2=0 where t.RaceNumber2 is null";

		//校级竞赛人数
		String sql6 = "update studentculturesummary set RaceNumber3 =(select count(*) from student,studentcoepetition,competition where " +
				"student.stuNumber=studentcoepetition.stuNumber  and studentcoepetition.comNumber = competition.comNumber and competition.comType = '校级' " +
				"and studentcoepetition.rank='1' and student.Mno=studentculturesummary.mno and studentculturesummary.`year`=competition.`year` " +
				"group by competition.comType,studentcoepetition.rank='1',student.mno,competition.year)";
		String sql6_null="update studentculturesummary t set t.RaceNumber3=0 where t.RaceNumber3 is null";
		//国家级科创人数
		String sql7 = "update studentculturesummary set StudentInnovationNumber11 =(select count(*) from student,innovationmember,innovationproject where " +
				"student.stuNumber=innovationmember.stuNumber  and innovationmember.innoNumber = innovationproject.innoNumber and innovationproject.level = '国家级' " +
				"and student.Mno=studentculturesummary.mno and studentculturesummary.`year`=innovationproject.`year` " +
				"group by student.mno,innovationproject.year)";
		String sql7_null="update studentculturesummary t set t.StudentInnovationNumber11=0 where t.StudentInnovationNumber11 is null";

		//省级科创人数
		String sql8 = "update studentculturesummary set StudentInnovationNumber12 =(select count(*) from student,innovationmember,innovationproject where " +
				"student.stuNumber=innovationmember.stuNumber  and innovationmember.innoNumber = innovationproject.innoNumber and innovationproject.level = '省级' " +
				"and student.Mno=studentculturesummary.mno and studentculturesummary.`year`=innovationproject.`year` " +
				"group by student.mno,innovationproject.year)";
		String sql8_null="update studentculturesummary t set t.StudentInnovationNumber12=0 where t.StudentInnovationNumber12 is null";

		//校级科创人数
		//为了使用索引一般不要出现%chars%
		String sql9 = "update studentculturesummary set StudentInnovationNumber13 =(select count(*) from student,innovationmember,innovationproject where " +
				"student.stuNumber=innovationmember.stuNumber  and innovationmember.innoNumber = innovationproject.innoNumber and innovationproject.level like '%校%' " +
				"and student.Mno=studentculturesummary.mno and studentculturesummary.`year`=innovationproject.`year` " +
				"group by student.mno,innovationproject.year)";
		String sql9_null="update studentculturesummary t set t.StudentInnovationNumber13=0 where t.StudentInnovationNumber13 is null";

		//专业第一志愿率
		String sql10 = "update studentculturesummary set FirstVolunteerRate =(select firstChoice from addmissions where " +
		"addmissions.Mno=studentculturesummary.mno and studentculturesummary.`year`=addmissions.addmYear " +
		"group by addmissions.mno,addmissions.addmYear)";
		String sql10_null="update studentculturesummary t set t.FirstVolunteerRate=0.00 where t.FirstVolunteerRate is null";

		
		//专业热门度
		String sql11 = "update studentculturesummary set PopularityRate =(select hotDeggree from addmissions where " +
		"addmissions.Mno=studentculturesummary.mno and studentculturesummary.`year`=addmissions.addmYear " +
		"group by addmissions.mno,addmissions.addmYear)";
		String sql11_null="update studentculturesummary t set t.PopularityRate=0.00 where t.PopularityRate is null";

		//初次就业率
		String sql12 = "update studentculturesummary set Initialemploymentrate =(select fEmpCount/graduCount from employment where " +
		"employment.Mno=studentculturesummary.mno and studentculturesummary.`year`=employment.`year` " +
		"group by employment.mno,employment.year)";
		String sql12_null="update studentculturesummary t set t.Initialemploymentrate=0.00 where t.Initialemploymentrate is null";

		
		//就业率
		String sql13 = "update studentculturesummary set Employmentrate =(select empCount/graduCount from employment where " +
		"employment.Mno=studentculturesummary.mno and studentculturesummary.`year`=employment.`year` " +
		"group by employment.mno,employment.year)";
		String sql13_null="update studentculturesummary t set t.Employmentrate=0.00 where t.Employmentrate is null";

		//国内外交流项目项目数
		String sql14 = "update studentculturesummary set exchangeprojects =(select projCounts from communicationsitu where " +
		"communicationsitu.Mno=studentculturesummary.mno and studentculturesummary.`year`=communicationsitu.`year` " +
		"group by communicationsitu.mno,communicationsitu.year)";
		String sql14_null="update studentculturesummary t set t.exchangeprojects=0 where t.exchangeprojects is null";

		//国内外交流项目学生人数
		String sql15 = "update studentculturesummary set exchangepeople =(select stuCount from communicationsitu where " +
		"communicationsitu.Mno=studentculturesummary.mno and studentculturesummary.`year`=communicationsitu.`year` " +
		"group by communicationsitu.mno,communicationsitu.year)";
		String sql15_null="update studentculturesummary t set t.exchangepeople=0 where t.exchangepeople is null";

		try {
			//this.execute(sql);
			this.execute(sqlCall);
			/*this.execute(sql0);
			//this.execute(sql01);
			if(moth.get(Calendar.MONTH)<9){
				this.execute(sql00);
			}
			
			this.execute(sql000);
			this.execute(sql0001);*/
			this.execute(sql1);
			this.execute(sql1_null);
			this.execute(sql2);
			this.execute(sql2_null);
			this.execute(sql3);
			this.execute(sql3_null);
			this.execute(sql4);
			this.execute(sql4_null);
			this.execute(sql5);
			this.execute(sql5_null);
			this.execute(sql6);
			this.execute(sql6_null);
			this.execute(sql7);
			this.execute(sql7_null);
			this.execute(sql8);
			this.execute(sql8_null);
			this.execute(sql9);
			this.execute(sql9_null);
			this.execute(sql10);
			this.execute(sql10_null);
			this.execute(sql11);
			this.execute(sql11_null);
			this.execute(sql12);
			this.execute(sql12_null);
			this.execute(sql13);
			this.execute(sql13_null);
			this.execute(sql14);
			this.execute(sql14_null);
			this.execute(sql15);
			this.execute(sql15_null);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// 实践课程情况统计计算
	public void PracticeCourseSummary() {
		//Calendar moth=Calendar.getInstance();
		/*String sql0 = "insert into practicecoursesummary(Mno,year) select distinct Mno,year from student where isRoll='有学籍'order by Mno,year";
		//String sql0 = "insert into practicecoursesummary(Mno,year) select distinct Mno,year from student order by Mno,year";
		//String sql01 ="delete from practicecoursesummary where practicecoursesummary.year=''";
		String sql00="update practicecoursesummary set year=(year+1)";
		//String sql000="insert into practicecoursesummary (mno)  select mno from major where mno not in (select distinct mno from practicecoursesummary )";
		String sql000="insert into practicecoursesummary (Mno)  select mno from major where mno not in (select distinct mno from practicecoursesummary where practicecoursesummary.year=(select MAX(year) from practicecoursesummary))";
		String sql0001="update practicecoursesummary t set t.year =(select c.max from (select MAX(year)as max from practicecoursesummary)c) where t.year is null";*/
		
		
		//String sql = "delete from practicecoursesummary";
		//调用存储过程，使每个专业都有近3年的年份
		String sqlCall="call  _init_p_summary()";
		
		//年度调整计划
		String sql1= "update practicecoursesummary set planChangeNumber =(select count(*) from teachingplanchange where  " +
					"teachingplanchange.adjustNature is null and teachingplanchange.Mno=practicecoursesummary.Mno and practicecoursesummary.`year`=teachingplanchange.`year` group by mno,year)";
		//String sql1_null= "update practicecoursesummary t set t.planChangeNumber =0 where t.planChangeNumber is null";
		
		//教授授课总学时
		String sql2= "update practicecoursesummary set professorTeachTime =(select sum(CourseHours) from majorcourse where  " +
					"majorcourse.ProfessionalTitleName = '教授' and majorcourse.Mno=practicecoursesummary.Mno and practicecoursesummary.`year`=majorcourse.`year` group by mno,year)";
		//String sql2_null= "update practicecoursesummary t set t.professorTeachTime =0 where t.professorTeachTime is null";

		//高职授课总学时
		String sql3= "update practicecoursesummary set inprofessorTteachTime =(select sum(CourseHours) from majorcourse where  " +
					"majorcourse.ProfessionalTitleName in ('教授','副教授') and majorcourse.Mno=practicecoursesummary.Mno and practicecoursesummary.`year`=majorcourse.`year` group by mno,year)";
		//String sql3_null= "update practicecoursesummary t set t.inprofessorTteachTime =0 where t.inprofessorTteachTime is null";

		//课程总学时
		String sql4= "update practicecoursesummary set teachTotalTime =(select sum(CourseHours) from majorcourse where  " +
					"majorcourse.Mno=practicecoursesummary.Mno and practicecoursesummary.`year`=majorcourse.`year` group by mno,year)";
		//String sql4_null= "update practicecoursesummary t set t.teachTotalTime =0 where t.teachTotalTime is null";

		//总教学经费
		String sql5= "update practicecoursesummary set totalTeachCost =(select sum(teachingcost.cost) from teachingcost where  " +
					" teachingcost.Mno=practicecoursesummary.Mno and practicecoursesummary.`year`=teachingcost.`year` group by mno,year)";
		//String sql5_null= "update practicecoursesummary t set totalTeachCost =0.00 where t.totalTeachCost is null";

		//课程总数
		String sql6= "update practicecoursesummary set courseTotaoNum =(select count(*) from majorcourse where practicecoursesummary.Mno=majorcourse.Mno  and practicecoursesummary.`year`=majorcourse.`year` group by majorcourse.Mno,majorcourse.`year`)";
		String sql6_null= "update practicecoursesummary t set courseTotaoNum =0 where t.courseTotaoNum is null";

		//课程开出数
		String sql7= "update practicecoursesummary set openCourseTotaoNum =(select count(*) from curriculumresource,majorcourse where  " +
					"majorcourse.mno=curriculumresource.Mno and majorcourse.cno=curriculumresource.cno and majorcourse.year=curriculumresource.year and  curriculumresource.Mno=practicecoursesummary.Mno and curriculumresource.isOpen = 'Y' and practicecoursesummary.`year`=curriculumresource.`year` group by curriculumresource.mno,curriculumresource.year)";
		//String sql7_null= "update practicecoursesummary t set openCourseTotaoNum =0 where t.openCourseTotaoNum is null";

		//优质课程数
		String sql8= "update practicecoursesummary set goodCourseTotaoNum =(select count(*) from curriculumresource,majorcourse where  " +
					"majorcourse.mno=curriculumresource.Mno and majorcourse.cno=curriculumresource.cno and majorcourse.year=curriculumresource.year and curriculumresource.Mno=practicecoursesummary.Mno and curriculumresource.isExcellent = 'Y' and practicecoursesummary.`year`=curriculumresource.`year` group by curriculumresource.mno,curriculumresource.year)";
		//String sql8_null= "update practicecoursesummary t set goodCourseTotaoNum =0 where t.goodCourseTotaoNum is null";

		//实习基地总数
		
		String sql9= "update practicecoursesummary set practiceBaseTotalNum =(select traininguseinginformation.SchooBaseNumber+traininguseinginformation.OutBaseNumber from traininguseinginformation where  " +
					"traininguseinginformation.Mno=practicecoursesummary.Mno  and practicecoursesummary.`year`=traininguseinginformation.`year` group by mno,year)";
		//String sql9_null= "update practicecoursesummary t set practiceBaseTotalNum =0 where t.practiceBaseTotalNum is null";

		//学生科创主持项目数
		String sql10= "update practicecoursesummary set studentPersistProjectNum =(select count(*)  from innovationmember,student ,innovationproject where " +
					"innovationmember.stuNumber=student.stuNumber and innovationmember.innoNumber=innovationproject.innoNumber and student.Mno=practicecoursesummary.Mno " +
					"and innovationmember.rank='1'  and practicecoursesummary.`year`=innovationproject.year  group by student.Mno,innovationproject.`year`)";
		//String sql10_null= "update practicecoursesummary t set studentPersistProjectNum =0 where t.studentPersistProjectNum is null";


		try {
			//this.execute(sql);
			this.execute(sqlCall);
			/*this.execute(sql0);
			//this.execute(sql01);
			if(moth.get(Calendar.MONTH)<9){
				this.execute(sql00);
			}
			this.execute(sql000);
			this.execute(sql0001);*/
			//this.execute(sql1_null);
			this.execute(sql1);
			this.execute(sql2);
			//this.execute(sql2_null);
			this.execute(sql3);
			//this.execute(sql3_null);
			this.execute(sql4);
			//this.execute(sql4_null);
			this.execute(sql5);
			//this.execute(sql5_null);
			this.execute(sql6);
			this.execute(sql6_null);
			this.execute(sql7);
			//this.execute(sql7_null);
			this.execute(sql8);
			//this.execute(sql8_null);
			this.execute(sql9);
			//this.execute(sql9_null);
			this.execute(sql10);
			//this.execute(sql10_null);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// 附件均值计算
	public void fileinfo_attachmentsummary() {
		String sql = "update fileinfo_attachment set AsseisingValue = (select avg(expertscore.AsseisingValue) from expertscore where fileinfo_attachment.attachment_id = expertscore.attachment_id group by expertscore.attachment_id ) WHERE fileinfo_attachment.MasCode IN (SELECT MasCode FROM mas WHERE AssessingNeedTargetNo IN (SELECT AssessingNeedTargetNo FROM assessingneedtarget WHERE MASProjectNo IN(SELECT MASProjectNo FROM assessingproject WHERE tag=1)))";
		try {
			this.execute(sql);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	//================================================changed by KJ 1201=================================================
	//分页获取全部专业教师信息统计情况
	@SuppressWarnings("unchecked")
	public List<Teacherinfosummary> getAllTeacherinfosummaryList(
			Teacherinfosummary teacherinfosummary, int page, int rows,String mno,String dno)
			throws ServiceException {
		String hql = "";
		
		// 专业负责人
		if (!mno.equals("000000")) {
			hql = "from Teacherinfosummary t where t.major.mno="
					+ "'" + mno + "'";
			// 学院负责人
		} else if (!dno.equals("00000") && mno.equals("000000")) {
			hql = "from Teacherinfosummary t where t.major.department.dno='"
					+ dno+"'";
			// 系统管理员
		} else {
			hql = "from Teacherinfosummary ";
		}
		hql += "order by major.mno,year DESC";
		List<Teacherinfosummary> list = null;
		list = (List<Teacherinfosummary>) QueryUtilDaoImpl.executeQueryByPage(
				hql, null, page, rows);
		return list;
	}
	
	
	//条件查找专业教师信息统计情况--图形显示
	@SuppressWarnings("unchecked")
	public List<?> findSummaryCountList(String major,String coll,String year,String table){
		
		List<?> list = null;
		try {
			String hql = "from "+table+" as t where t.year like :tpno";
			System.out.println(year+" "+major+" "+coll);
			Map mapParam = new HashMap();           
			mapParam.put("tpno", "%" + year + "%");
			// 专业
			if (major != null
					&& !"".equals(major)&& !"%".equals(major)) {
				hql += " and t.major.mno= '" + major + "'";
				System.out.println(" "+major);
			}
			// 学院
			if (coll != null
					&& !"".endsWith(coll)) {
				System.out.println(" "+coll);
				hql += " and t.major.department.dno= '"
						+ coll + "'";
			}
			hql+=" order by t.major.mno,t.year desc";
			System.out.println("majorId=="+major);
			System.out.println(hql);
			list = (List<?>) QueryUtilDaoImpl.executeQuery(hql, null, mapParam);
					
		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}

	//================================================changed by KJ 1201=================================================
	public int countTeacherinfosummaryList(Teacherinfosummary teacherinfosummary ,String mno,String dno)
			throws ServiceException {
		String hql = "";
		
		// 专业负责人
		if (!mno.equals("000000")) {
			hql = "select count(*) from Teacherinfosummary t where t.major.mno="
					+ "'" + mno + "'";
			// 学院负责人
		} else if (!dno.equals("00000") && mno.equals("000000")) {
			hql = "select count(*) from Teacherinfosummary t where t.major.department.dno='"
					+ dno+"'";
			// 系统管理员
		} else {
			hql = "select count(*) from Teacherinfosummary ";
		}
		
		int count = 0;
		count = QueryUtilDaoImpl.getResultCountForHql(hql, null);
		return count;
	}

	// 分页查找所有教师科研信息统计数据
	@SuppressWarnings("unchecked")
	public List<Teacherresearchsummary> getAllTeacherresearchsummaryList(
			Teacherresearchsummary teacherresearchsummary, int page, int rows)
			throws ServiceException {
		String hql = "from Teacherresearchsummary order by major.mno,year DESC";
		List<Teacherresearchsummary> list = null;
		list = (List<Teacherresearchsummary>) QueryUtilDaoImpl
				.executeQueryByPage(hql, null, page, rows);
		return list;
	}

	// 按条件导出统计数据
	@SuppressWarnings("unchecked")
	public List<?> exportSTableList(
			BaseModel basemodel,String table) throws ServiceException {

		List<?> list = null;
		try {
			String hql = "from "+table+" as t where t.year like :tpno";

			Map mapParam = new HashMap();           
			mapParam.put("tpno", "%" + basemodel.getYear() + "%");
			// 专业
			if (basemodel.getMajorId() != null
					&& !"".equals(basemodel.getMajorId())&& !"%".equals(basemodel.getMajorId())) {

				hql += " and t.major.mno= '" + basemodel.getMajorId() + "'";
			}
			// 学院
			if (basemodel.getDepartmentId() != null
					&& !"".endsWith(basemodel.getDepartmentId())) {

				hql += " and t.major.department.dno= '"
						+ basemodel.getDepartmentId() + "'";
			}
			hql+=" order by t.major.mno,t.year desc";
			System.out.println("majorId=="+basemodel.getMajorId());
			System.out.println(hql);
			list = (List<?>) QueryUtilDaoImpl
					.executeQuery(hql, null, mapParam);
		} catch (Exception e) {
			e.printStackTrace();
			throw new ServiceException("多条件查询失败", e);
		}

		return list;
	}
	// 按条件查找统计信息表统计数据
	public List<?> findSTableList(
			BaseModel basemodel,String table, int page, int rows) throws ServiceException {

		List<?> list = null;
		try {
			String hql = "from "+table+" as t where t.year like :tpno";

			Map mapParam = new HashMap();           
			mapParam.put("tpno", "%" + basemodel.getYear() + "%");
			// 专业
			if (basemodel.getMajorId() != null
					&& !"".equals(basemodel.getMajorId())&& !"%".equals(basemodel.getMajorId())) {

				hql += " and t.major.mno= '" + basemodel.getMajorId() + "'";
			}
			// 学院
			if (basemodel.getDepartmentId() != null
					&& !"".endsWith(basemodel.getDepartmentId())) {

				hql += " and t.major.department.dno= '"
						+ basemodel.getDepartmentId() + "'";
			}
			hql+=" order by t.major.mno,t.year desc";
			System.out.println("majorId=="+basemodel.getMajorId());
			System.out.println(hql);
			list = (List<?>) QueryUtilDaoImpl
					.executeQueryByPage(hql, null, mapParam, page, rows);
		} catch (Exception e) {

			throw new ServiceException("多条件查询失败", e);
		}

		return list;
	}
	// 获取按条件查找的条数
	@SuppressWarnings("unchecked")
	public int countFindSTeacherresearchsummary(BaseModel basemodel,String table)
			throws ServiceException {
		int count = 0;
		String hql = "select count(*) from "+table+" as t where "
				+ "t.year like :tpno ";

		try {
			Map mapParam = new HashMap();

			mapParam.put("tpno", "%" + basemodel.getYear() + "%");
			
			// 专业
			if (basemodel.getMajorId() != null
					&& !"".equals(basemodel.getMajorId())&& !"%".equals(basemodel.getMajorId())) {

				hql += " and t.major.mno= '" + basemodel.getMajorId() + "'";
			}
			// 学院
			if (basemodel.getDepartmentId() != null
					&& !"".endsWith(basemodel.getDepartmentId())) {

				hql += " and t.major.department.dno= '"
						+ basemodel.getDepartmentId() + "'";
			}
			count = QueryUtilDaoImpl.getResultCountForHql(hql, null, mapParam);
		} catch (Exception e) {

			throw new ServiceException("查询结果条数失败", e);
		}
		System.out.println("count==" + count);
		return count;

	}
	//================================================changed by K.J 1201=================================================
	//教学科研情况 初始化查询 结果数量统计
	public int countTeacherresearchsummaryList(
			Teacherresearchsummary teacherresearchsummary ,String mno,String dno)
			throws ServiceException {
		//String hql = "select count(*) from Teacherresearchsummary";
		
		String hql = "";
		
		// 专业负责人
		if (!mno.equals("000000")) {
			hql = "select count(*) from Teacherresearchsummary t where t.major.mno="
					+ "'" + mno + "'";
			// 学院负责人
		} else if (!dno.equals("00000") && mno.equals("000000")) {
			hql = "select count(*) from Teacherresearchsummary t where t.major.department.dno='"
					+ dno+"'";
			// 系统管理员
		} else {
			hql = "select count(*) from Teacherresearchsummary ";
		}
		
		int count = 0;
		count = QueryUtilDaoImpl.getResultCountForHql(hql, null);
		return count;
	}
	//================================================changed by K.J 1201=================================================
	//学生培养情况 初始化查询
	@SuppressWarnings("unchecked")
	public List<Studentculturesummary> getAllStudentculturesummaryList(
			Studentculturesummary studentculturesummary, int page, int rows,String mno,String dno)
			throws ServiceException {
		
		String hql = "";
		
		// 专业负责人
		if (!mno.equals("000000")) {
			hql = "from Studentculturesummary t where t.major.mno="
					+ "'" + mno + "'";
			// 学院负责人
		} else if (!dno.equals("00000") && mno.equals("000000")) {
			hql = "from Studentculturesummary t where t.major.department.dno='"
					+ dno+"'";
			// 系统管理员
		} else {
			hql = "from Studentculturesummary ";
		}
		hql += "order by major.mno,year DESC";
		
		//String hql = "from Studentculturesummary order by major.mno,year desc";
		List<Studentculturesummary> list = null;
		list = (List<Studentculturesummary>) QueryUtilDaoImpl
				.executeQueryByPage(hql, null, page, rows);
		return list;
	}


	//================================================changed by K.J 1201=================================================
	// 分页查找所有教师科研信息统计数据 教学科研情况 初始化查询 
	@SuppressWarnings("unchecked")
	public List<Teacherresearchsummary> getAllTeacherresearchsummaryList(
			Teacherresearchsummary teacherresearchsummary, int page, int rows,String mno,String dno)
			throws ServiceException {
		
		String hql = "";
		
		// 专业负责人
		if (!mno.equals("000000")) {
			hql = "from Teacherresearchsummary t where t.major.mno="
					+ "'" + mno + "'";
			// 学院负责人
		} else if (!dno.equals("00000") && mno.equals("000000")) {
			hql = "from Teacherresearchsummary t where t.major.department.dno='"
					+ dno+"'";
			// 系统管理员
		} else {
			hql = "from Teacherresearchsummary ";
		}
		hql += "order by major.mno,year DESC";
		//String hql = "from Teacherresearchsummary order by major.mno,year DESC";
		List<Teacherresearchsummary> list = null;
		list = (List<Teacherresearchsummary>) QueryUtilDaoImpl
				.executeQueryByPage(hql, null, page, rows);
		return list;
	}

	// 获取全部学生统计信息列表
	@SuppressWarnings("unchecked")
	public List<Studentculturesummary> getAllStudentculturesummaryList()
			throws ServiceException {
		String hql = "from Studentculturesummary order by major.mno,year desc";
		List<Studentculturesummary> list = null;
		list = (List<Studentculturesummary>) QueryUtilDaoImpl.executeQuery(hql,
				null);
		return list;
	}

	// 获取专业教师基本情况列表
	@SuppressWarnings("unchecked")
	public List<Teacherinfosummary> getAllTeacherinfosummaryList()
			throws ServiceException {
		String hql = "from Teacherinfosummary order by major.mno,year desc";
		List<Teacherinfosummary> list = null;
		list = (List<Teacherinfosummary>) QueryUtilDaoImpl.executeQuery(hql,
				null);
		return list;
	}

	//================================================changed by K.J 1201=================================================
	//学生培养情况统计 
	public int countStudentculturesummaryList(
			Studentculturesummary studentculturesummary,String mno,String dno)
			throws ServiceException {
		
		String hql = "";
		
		// 专业负责人
		if (!mno.equals("000000")) {
			hql = "select count(*) from Studentculturesummary t where t.major.mno="
					+ "'" + mno + "'";
			// 学院负责人
		} else if (!dno.equals("00000") && mno.equals("000000")) {
			hql = "select count(*) from Studentculturesummary t where t.major.department.dno='"
					+ dno+"'";
			// 系统管理员
		} else {
			hql = "select count(*) from Studentculturesummary ";
		}
		//String hql = "select count(*) from Studentculturesummary";
		int count = 0;
		count = QueryUtilDaoImpl.getResultCountForHql(hql, null);
		return count;
	}

	//================================================changed by K.J 1201=================================================
	// 实践教学情况统计 
	@SuppressWarnings("unchecked")
	public List<Practicecoursesummary> getAllPracticecoursesummaryList(
			Practicecoursesummary practicecoursesummary, int page, int rows,String mno,String dno)
			throws ServiceException {
		
		String hql = "";
		
		// 专业负责人
		if (!mno.equals("000000")) {
			hql = "from Practicecoursesummary t where t.major.mno="
					+ "'" + mno + "'";
			// 学院负责人
		} else if (!dno.equals("00000") && mno.equals("000000")) {
			hql = "from Practicecoursesummary t where t.major.department.dno='"
					+ dno+"'";
			// 系统管理员
		} else {
			hql = "from Practicecoursesummary ";
		}
		hql += "order by major.mno,year DESC";
		
		//String hql = "from Practicecoursesummary order by major.mno,year desc";
		System.out.println("=========================================================test at service 1201================");
		
		List<Practicecoursesummary> list = null;
		list = (List<Practicecoursesummary>) QueryUtilDaoImpl
				.executeQueryByPage(hql, null, page, rows);
		System.out.println("size: "+list.size());
		return list;
	}

	//================================================changed by K.J 1201=================================================
	// 返回条数
	public int countPracticecoursesummaryList(
			Practicecoursesummary practicecoursesummary,String mno,String dno)
			throws ServiceException {
		
		String hql = "";
		
		// 专业负责人
		if (!mno.equals("000000")) {
			hql = "select count(*) from Practicecoursesummary t where t.major.mno="
					+ "'" + mno + "'";
			// 学院负责人
		} else if (!dno.equals("00000") && mno.equals("000000")) {
			hql = "select count(*) from Practicecoursesummary t where t.major.department.dno='"
					+ dno+"'";
			// 系统管理员
		} else {
			hql = "select count(*) from Practicecoursesummary ";
		}
		//String hql = "select count(*) from Practicecoursesummary";
		int count = 0;
		count = QueryUtilDaoImpl.getResultCountForHql(hql, null);
		return count;
	}

	// 返回年份
	@SuppressWarnings("unchecked")
	public List<String> findYearList(String table) throws ServiceException {
		List list = null;
		try {
			String hql = "SELECT DISTINCT t.year FROM " + table + " AS t order by t.year desc";

			System.out.println("summaryService_findYearList==" + hql);
			list = (List<String>) QueryUtilDaoImpl.executeQuery(hql, null);
				Collections.sort(list);
			
			

		} catch (Exception e) {
			e.printStackTrace();
			throw new ServiceException("查询年份列表失败", e);

		}
		return list;
	}
	@SuppressWarnings("unchecked")
	public List<Teacherresearchsummary> findAllTR(
			Class<Teacherresearchsummary> c) {
		Session session = null;
		Transaction tx = null;
		List<Teacherresearchsummary> list = null;
		try{
			session = HibernateUtil.getSession();
			tx = session.beginTransaction();
			Query query = session.createQuery("from "+c.getName());
			list = query.list();
			tx.commit();
		}catch(Exception e){
			e.printStackTrace();
			if(tx != null){
				tx.rollback();
			}
			throw new RuntimeException(e.getMessage());
		}finally{
			if(session != null && session.isOpen()){
				session.close();
			}
		}
		return list;
	}
	
}
