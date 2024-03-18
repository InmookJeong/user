package kr.mook.user.common.service;

import java.util.HashMap;

/**
 * This is an interface for implementing business logic related to user analysis.
 * 
 * @since 2024.03.18
 * @author In-mook, Jeong
 * @version 0.0.1
 */
public interface UserAnalysisService {
	
	/**
	 * This method implements the logic to query the total number of members and the number of members by gender.<br/>
	 * 'countAll' refers to the total number of members.<br/>
	 * 'countByMale' refers to the number of male members, and 'countByFemale' refers to the number of female members.
	 * 
	 * @return
	 * @since 2024.03.18
	 * @author In-mook, Jeong
	 */
	public HashMap<String, Object> countMembers();
	
	/**
	 * This method implements the logic to query the number of member registrations by year, month, and day.<br/>
	 * 'yearly' means the number of subscribers by year, 'monthly' means the number of subscribers by month, and 'daily' means the number of subscribers by day.<br/>
	 * 'yearly' refers to the last 3 years, and 'monthly' refers to the last 12 months.<br/>
	 * 'daily' retrieves data from the last 30 days.
	 * 
	 * @return
	 * @since 2024.03.18
	 * @author In-mook, Jeong
	 */
	public HashMap<String, Object> countOfMemberRegister();
}
