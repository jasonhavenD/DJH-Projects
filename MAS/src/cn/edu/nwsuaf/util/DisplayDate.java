package cn.edu.nwsuaf.util;

import java.util.TimerTask;

/*import cn.edu.nwsuaf.service.ContestApplyService;
import cn.edu.nwsuaf.service.impl.ContestApplyServiceImpl;*/

public class DisplayDate extends TimerTask{
	//ContestApplyService contestApplyService = new ContestApplyServiceImpl();
	
	@Override
	public void run(){
		try{
//			//每隔一天检查执行一次赛项报名设置后“开始报名”的状态
//			contestApplyService.contestStuRegSDate();
//			//每隔一天检查执行一次赛项开始报名后“报名结束”的状态
//			contestApplyService.contestStuRegEDate();
//			//每隔一天检查执行一次赛项报名结束后“竞赛结束”的状态
//			contestApplyService.contestEDate();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
