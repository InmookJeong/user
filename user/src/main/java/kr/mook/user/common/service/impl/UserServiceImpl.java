package kr.mook.user.common.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import kr.mook.user.common.dto.LoginDTO;
import kr.mook.user.common.dto.UserResultContentDTO;
import kr.mook.user.common.dto.UserResultDTO;
import kr.mook.user.common.service.UserService;
import kr.mook.user.constants.StatusEnum;
import kr.mook.user.constants.UserMessageConstants;
import kr.mook.user.member.dao.MemberDao;
import kr.mook.user.member.dto.MemberDTO;

/**
 * This is a class that implements user-related business logic.
 * 
 * @since 2024.03.07
 * @author In-mook, Jeong
 * @version 0.0.1
 */
@Service
public class UserServiceImpl implements UserService {
	
	// UserService Logger
	private final Logger _log = Logger.getLogger(UserService.class.getName());
	
	@Value("${Crypto.AES.SecretKey}")
	private String AES_SECRET_KEY;
	
	@Value("${Crypto.AES.IV}")
	private String AES_IV;
	
	@Autowired
	private MemberDao memberDao;

	@Override
	public UserResultDTO login(LoginDTO loginDTO) {
		UserResultDTO userResultDTO = new UserResultDTO("Log-in");
		if(this.memberDao.countByLoginDto(loginDTO) > 0) {
			userResultDTO.setStatus(
				StatusEnum.LOGIN_SUCCESS.getStatus(),
				StatusEnum.LOGIN_SUCCESS.getStatusEngMessage(),
				StatusEnum.LOGIN_SUCCESS.getStatusKorMessage()
			);
			
			UserResultContentDTO userResultContentDTO = new UserResultContentDTO();
			userResultContentDTO.setTitle("로그인 성공");
			userResultContentDTO.setContent("12345667");
			userResultContentDTO.setMessage("OOO님 환영합니다.");
			userResultDTO.setContent("OBJECT", userResultContentDTO);
		} else {
			userResultDTO.setStatus(
				StatusEnum.LOGIN_FAILED.getStatus(),
				StatusEnum.LOGIN_FAILED.getStatusEngMessage(),
				StatusEnum.LOGIN_FAILED.getStatusKorMessage()
			);
			
			userResultDTO.setContent("STRING", UserMessageConstants.MESSAGE_LOGIN_FAILED);
		}
		
		return userResultDTO;
	}
	
	@Override
	public UserResultDTO logout() {
		UserResultDTO userResultDTO = new UserResultDTO("Log-out");
//		userResultDTO.setStatus(
//			StatusEnum.LOGOUT_SUCCESS.getStatus(),
//			StatusEnum.LOGOUT_SUCCESS.getStatusEngMessage(),
//			StatusEnum.LOGOUT_SUCCESS.getStatusKorMessage()
//		);
		userResultDTO.setStatus(
				StatusEnum.LOGOUT_FAILED.getStatus(),
				StatusEnum.LOGOUT_FAILED.getStatusEngMessage(),
				StatusEnum.LOGOUT_FAILED.getStatusKorMessage()
				);
		
//		userResultDTO.setContent("STRING", UserMessageConstants.MESSAGE_LOGOUT_SUCCESS);
		userResultDTO.setContent("STRING", UserMessageConstants.MESSAGE_LOGOUT_FAILED);
		
		return userResultDTO;
	}

	@Override
	public UserResultDTO getUserId(MemberDTO memberDTO) {
		UserResultDTO userResultDTO = new UserResultDTO("Find-ID");
		String userId = this.memberDao.selectUserId(memberDTO);
		if(userId != null && !userId.isEmpty()) {
			userResultDTO.setStatus(
				StatusEnum.FIND_ID_SUCCESS.getStatus(),
				StatusEnum.FIND_ID_SUCCESS.getStatusEngMessage(),
				StatusEnum.FIND_ID_SUCCESS.getStatusKorMessage()
			);
			
			userResultDTO.setContent("STRING", userId);
		} else {
			userResultDTO.setStatus(
					StatusEnum.FIND_ID_FAILED.getStatus(),
					StatusEnum.FIND_ID_FAILED.getStatusEngMessage(),
					StatusEnum.FIND_ID_FAILED.getStatusKorMessage()
					);
			
			userResultDTO.setContent("STRING", UserMessageConstants.MESSAGE_FIND_ID_FAILED);
		}
		
		return userResultDTO;
	}

	@Override
	public List<MemberDTO> list(MemberDTO memberDTO) {
		List<MemberDTO> memberList = new ArrayList<MemberDTO>();
		MemberDTO member1 = new MemberDTO();
		member1.setUserId("test");
		member1.setName("홍길동");
		member1.setEmail("test@gmail.com");
		memberList.add(member1);
		
		MemberDTO member2 = new MemberDTO();
		member2.setUserId("korean");
		member2.setName("한국인");
		member2.setEmail("korean@korea.com");
		memberList.add(member2);
		
		MemberDTO member3 = new MemberDTO();
		member3.setUserId("userTest");
		member3.setName("사용자");
		member3.setEmail("userTest@gmail.com");
		memberList.add(member3);
		
		return memberList;
	}
}
