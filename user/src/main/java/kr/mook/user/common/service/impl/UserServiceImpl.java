package kr.mook.user.common.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import org.springframework.stereotype.Service;

import kr.mook.user.common.dto.LoginDTO;
import kr.mook.user.common.dto.UserResultContentDTO;
import kr.mook.user.common.dto.UserResultDTO;
import kr.mook.user.common.service.UserService;
import kr.mook.user.constants.StatusEnum;
import kr.mook.user.constants.UserMessageConstants;
import kr.mook.user.member.dto.MemberDTO;
import kr.mook.user.util.data.RandomStringUtils;

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

	@Override
	public UserResultDTO login(LoginDTO loginDTO) {
		UserResultDTO userResultDTO = new UserResultDTO("Log-in");
		// password : test1234
		String encryptPw = "937e8d5fbb48bd4949536cd65b8d35c426b80d2f830c5c308e2cdec422ae2244";
		if(loginDTO.getUserId().equals("test") 
			&& loginDTO.getPassword().equals(encryptPw)) {
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
	public boolean existUserId(String userId) {
		if(userId.equals("test")) {
			return true;
		}
		
		return false;
	}

	@Override
	public boolean existEmail(String email) {
		if(email.equals("test@test.com")) {
			return true;
		}
		
		return false;
	}

	@Override
	public boolean existPhoneNumber(String phone) {
		if(phone.equals("010-1234-5678")) {
			return true;
		}
		
		return false;
	}

	@Override
	public boolean signUp(MemberDTO memberDTO) {
		if(memberDTO.getUserId().equals("test")
			&& memberDTO.getEmail().equals("test@gmail.com")) {
			return true;
		}
		
		return false;
	}

	@Override
	public String findId(MemberDTO memberDTO) {
		if(memberDTO.getName().equals("홍길동")
			&& memberDTO.getEmail().equals("test@gmail.com")) {
			return "test";
		}
		
		return "User not found.";
	}

	@Override
	public String findPassword(MemberDTO memberDTO) {
		if(memberDTO.getName().equals("홍길동")
			&& memberDTO.getUserId().equals("test")
			&& memberDTO.getEmail().equals("test@gmail.com")) {
			return RandomStringUtils.getRandomString(10);
		}
		
		return "";
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
