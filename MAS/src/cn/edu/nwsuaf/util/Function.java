package cn.edu.nwsuaf.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import cn.edu.nwsuaf.dao.Impl.QueryUtilDaoImpl;

public class Function {
	private static Map<String, Double> Params=new HashMap<String,Double>();
	
	@SuppressWarnings("unchecked")
	public static Map<String, Double> loadParams(){
		String hql = "SELECT new map(F.funName as fName,F.funValue as fValue) FROM Funtionargs F";
		List<Map> mapList = (List<Map>) QueryUtilDaoImpl.executeQuery(hql, null);
		for(Map map:mapList){ 
			String fName=(String) map.get("fName");
			double fValue=(Double) map.get("fValue");
			System.out.println("fName-->"+fName+"  fValue--->"+fValue);
			Params.put(fName, fValue);
		}
		return Params;
	}
	//7、计算年度计划调整次数得分，参数有：调整次数N，分值F
	public static double CalculatePlanChangeNum(int N ,double F){
		return 100-F*N;
	}
	
	//11、计算博士教师比例，参数有：M博士教师人数，教职工人数P;   
	//17、行业教师比例 ，参数有：行业教师人数，教职工人数
	//19、中青年教师比例，参数有：中青年教师人数，教职工人数
	//20、中青年参加培训比例，参数有：中青年参加培训教师人数，教职工人数
	//43、计算课程开出率，参数有：开出课程数，专业总课程数
	//44、计算优质课程率，参数有：优质课程数，专业总课程数
	//59、计算学生参与科创比例，首先计算国家级、省级、校级三者总人数作为M,
	//61、现阶段调用此函数只计算了挑战杯参与比例，后边几项数据未量化，没用
	//63、质量标准建设完成比例
	//74、学生主持科创项目数生均值
	//75、近三年学生获得奖励次数，需要先计算国家级、省级、校级综合
	//76、学生获得专利生均值
	//77、学术论文生均值
	public static double CalculateDoctorRate(int M ,int P){
		double a=Double.valueOf(M);
		double b=Double.valueOf(P);
		if(b!=0){
			return a/b;
		}else{
			return 0;
		}	
	}
	
	//12、13、14、计算人才得分，参数有：P1国家级人才数，P2省级人才数，P3校级人才数，F1国家级人才数得分，F2省级人才数得分，F3校级人才数得分，    
	//21、一二三类论文得分，输入数三类论文的数量和分别的计分
	//24、25、26 近三年教师主持的国家级、校级、省级科研课题计算，输入是三个等级的数量和分别的计分
	//27、近三年教师发表的A类，B类,C类论文，输入是三个等级的数量和分别的计分
	//28、29近三年教师主编、副主编、参编教材数量，输入是三个等级的数量和分别的计分
	//30、31、32教师主持的国家级、省级、校级教改项目数量，输入是三个等级的数量和分别的计分
	//35、36、37历年教学工程项目数量 ,输入是三个等级的数量和分别的计分
	public static double CalculateTalents(int P1,int P2 ,int P3, double F1,double F2,double F3){
		return P1*F1+P2*F2+P3*F3;
	}
	public static double CalculateTalentsPart(int P1, double F1){
		return P1*F1;
	}
	
	//计算教授授课学时所占比例,参数有：Tp教授授课总学时，T专业总学时     ，16、高职授课比例
	public static double CalculateProfessorTeachTimeRate(double Tp,double T ){
		return Tp/T;
	}
	
	/*//计算高职授课学时所占比例,参数有：Tg高职授课总学时，T专业总学时
	public double CalculateGaoTeachTimeRate(double Tg,double T ){
		return Tg/T;
	}
	
	//计算行业教师比例，参数有：Ph行业教师人数，P专业教师总人数
	public double CalculateInnerTeacherRate(double Ph,double P ){
		return Ph/P;
	}
	
	//计算中青年教师比例，参数有：Pz中青年教师人数，P专业教师总人数
	public double CalculateYoungTeacherRate(double Pz,double P ){
		return Pz/P;
	}*/
	//22、计算国家科研奖项，参数有：P1国家级数(P11,一等奖第一名)，F1一等奖得分，F2二等奖得分，F3三等奖得分，   R1，R2,R3排名一二三附加分，
	//23、省级科研奖励，参数有：省级级数(P11,一等奖第一名)，F1一等奖得分，F2二等奖得分，F3三等奖得分，   R1，R2,R3排名一二三附加分，
	//38、计算国家级教学成果奖，参数输入国家级成国奖的一等价第一、二、三名的人数
	//39、计算省级教学成果奖
	//40、计算校级教学成果奖
	public static  double CalculateProjectContest(int P11,int P12 ,int P13 ,int P21,int P22,int P23,int P31,int P32,int P33,double F1,double F2,double F3,double R1,double R2,double R3 ){
		return 	P11*(F1+R1)+P12*(F1+R2)+P13*(F1+R3)+//一等奖一二三名得分
				P21*(F2+R1)+P22*(F2+R2)+P23*(F2+R3)+//二等奖一二三名得分
				P31*(F3+R1)+P32*(F3+R2)+P33*(F3+R3);//三等奖一二三名得分
	}
	
	//41、计算教学经费的生均值，参数有：N 专业总教学经费，专业学生数M
	//42、实验经费生均值、实习经费生均值、毕设经费生均值，调用三次函数

	public static double CalculateTeachCost(double N,int M){
		return N/M;
	}
	
	
	//60、计算时间教学开出率、完成率,参数为：开出率，完成率，各自权重
	public static double CaculateTeachOpenRate(double openRate,double finishRate,double F1,double F2){
		return openRate*F1+finishRate*F2;
	}
	//61、计算时间人文与科学素质教育及育人情况-挑战杯学生参与人数比例 、报告会举办次数 、报告会参与次数 、其他教育类项目,参数为：挑战杯学生参与人数比例 、报告会举办次数 、报告会参与次数 、其他教育类项目，各自权重
	public static double CaculateEffectofqualityeducation(double cupRate,Integer hostReportCount,Integer partiCount,Integer otherProject,double F1,double F2,double F3,double F4){
		return cupRate*F1+hostReportCount*F2+partiCount*F3+otherProject*F4;
	}
	//62 、计算交流项目,参数参与交流项目数目(量化后)N1,参与交流人数N2,专业学生人数N,参与比例的权重分F2,量化后的项目数N1的权重F1
	public static double CalculateCommunication(int N1,int N2,int N,double F1,double F2){
		return N2/N*F2+N1*F1;
	}
	
	//量化函数，参数有：Y数据集合，A值表示量化后指标下限，B值表示量化后指标上限,flag=0表示是一个正比例函数，flag=1表示是一个反比例函数
	public static double[] Standard(double y[],double A,double B,int flag){
		double Max=y[0];
		double Min=y[0];
		for(int i=1;i<y.length;i++){
			if(y[i]>Max){
				Max=y[i];
			}
			if(y[i]<Min){
				Min=y[i];
			}
		}
		System.out.println("最大值："+Max+"\n"+"最小值："+Min);
		double a,b;
		if(flag==0){//正比例函数
			 a=(B-A)/(Max-Min);
			 b=B-a*Max;
		}
		else{ //反比例函数
			 a=(A-B)/(Max-Min);
			 b=B-a*Min;
		}
		int length=y.length;
		double array[]=new double[length];
		for(int i=0;i<y.length;i++){
			array[i]=a*y[i]+b;
		}
		return array;
	}
	//注意，输入参数直接从数据库中获取Map<专业代码，指标Y值>
	//把专业代码和Y值绑定在一起进行量化，参数有：Map<专业代码，Y值>数据集合，A值表示量化后指标下限，B值表示量化后指标上限,flag=0表示是一个正比例函数，flag=1表示是一个反比例函数
	public static Map<String, Float> Standard(Map<String, Float> majorValue,float A,float B,int flag){
		List<Float> valueList=new ArrayList<Float>();
		for(float value:majorValue.values()){
			valueList.add(value);//获取Y值集合
		}
		float Max= valueList.get(0);
		float Min= valueList.get(0);
		for(int i=1;i<valueList.size();i++){
			if(Max<valueList.get(i)){
				Max=valueList.get(i);
			}
			if(Min>valueList.get(i)){
				Min=valueList.get(i);
			}
		}
		//System.out.println("最大值："+Max+"\n"+"最小值："+Min);
		float a,b;
		if(flag==0){//正比例函数
			 a=(B-A)/(Max-Min);
			 b=B-a*Max;
		}
		else{ //反比例函数
			 a=(A-B)/(Max-Min);
			 b=B-a*Min;
		}
		
		for(Map.Entry<String, Float>values:majorValue.entrySet()){
			
			String majorNoString=values.getKey();
			Float value=values.getValue();
			//System.out.println("专业—————》"+majorNoString+"    "+"得分————》"+value);
			values.setValue(a*value+b);
		}
		  
		
		return majorValue;
	}
	//把专业代码和Y值绑定在一起进行量化，参数有：Map<专业代码，Y值>数据集合，A值表示量化后指标下限，B值表示量化后指标上限,flag=0表示是一个正比例函数，flag=1表示是一个反比例函数
	public static List<Map> Standard(List<Map>mapList,String funName,double A,double B,int flag){
		List<Double> valueList=new ArrayList<Double>();
		for(Map map:mapList){
			Double value=(Double) map.get(funName);
			valueList.add(value);//获取Y值集合
	    }
		
		Double Max= valueList.get(0);
		Double Min= valueList.get(0);
		for(int i=1;i<valueList.size();i++){
			if(Max<valueList.get(i)){
				Max=valueList.get(i);
			}
			if(Min>valueList.get(i)){
				Min=valueList.get(i);
			}
		}
		//System.out.println("最大值："+Max+"\n"+"最小值："+Min);线性拟合，正反比例是加减分，
		Double a,b;
		if(flag==0){//正比例函数
			if(Max!=Min){
				 a=(B-A)/(Max-Min);
				 b=B-a*Max;
			}else{
				a=0.00;
				b=B;
			}
			
		}
		else{ //反比例函数
			if(Max==Min){
				a=0.00;
				b=B;
			}else{
				 a=(A-B)/(Max-Min);
				 b=B-a*Min;
			}
			
		}
		
		/*for(Map.Entry<String, Float>values:majorValue.entrySet()){
			
			String majorNoString=values.getKey();
			Float value=values.getValue();
			System.out.println("专业—————》"+majorNoString+"    "+"得分————》"+value);
			values.setValue(a*value+b);
		}*/
		for(Map map:mapList){
			Double value=(Double) map.get(funName);
			map.put(funName, a*value+b);//获取Y值集合
			//mapList.add(map);
	    }
		
		return mapList;
	}
	
	
}
