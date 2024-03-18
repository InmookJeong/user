package kr.mook.user.common.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Logger;

import org.springframework.stereotype.Service;

import kr.mook.user.common.service.UserAnalysisService;

@Service
public class UserAnalysisServiceImpl implements UserAnalysisService {
	
	// UserAnalysisService Logger
	private final Logger _log = Logger.getLogger(UserAnalysisService.class.getName());

	@Override
	public HashMap<String, Object> countMembers() {
		HashMap<String, Object> returnMap = new HashMap<String, Object>();
		returnMap.put("members", 100);
		returnMap.put("male", 59);
		returnMap.put("female", 41);
		return returnMap;
	}

	@Override
	public HashMap<String, Object> countOfMemberRegister() {
		HashMap<String, Object> returnMap = new HashMap<String, Object>();
		List<HashMap<String, Object>> yealyList = new ArrayList<HashMap<String,Object>>();
		for(int i=0; i<3; i++) {
			HashMap<String, Object> yearlyMap = new HashMap<String, Object>();
			yearlyMap.put("202"+(i+1)+"년", (i+1)+"00");
			yealyList.add(yearlyMap);
		}
		returnMap.put("yearly", yealyList);
		
		List<HashMap<String, Object>> monthlyList = new ArrayList<HashMap<String,Object>>();
		for(int i=0; i<12; i++) {
			HashMap<String, Object> monthlyMap = new HashMap<String, Object>();
			monthlyMap.put((i+1)+"월", (i+1));
			monthlyList.add(monthlyMap);
		}
		returnMap.put("monthly", monthlyList);
		List<HashMap<String, Object>> dailyList = new ArrayList<HashMap<String,Object>>();
		for(int i=0; i<10; i++) {
			HashMap<String, Object> dailyMap = new HashMap<String, Object>();
			dailyMap.put((i+1)+"일", (i+1));
			dailyList.add(dailyMap);
		}
		returnMap.put("daily", dailyList);
		return returnMap;
	}

}
