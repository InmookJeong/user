package kr.mook.user.common.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.mook.user.common.dto.LoginDTO;
import kr.mook.user.common.dto.SignUpDTO;
import kr.mook.user.common.dto.UserResultContentDTO;
import kr.mook.user.common.dto.UserResultDTO;
import kr.mook.user.common.service.UserService;
import kr.mook.user.constants.StatusEnum;
import kr.mook.user.constants.UserMessageConstants;
import kr.mook.user.member.dao.MemberDao;
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
	
	@Autowired
	private MemberDao memberDao;

	@Override
	public UserResultDTO login(LoginDTO loginDTO) {
		UserResultDTO userResultDTO = new UserResultDTO("Log-in");
		System.out.println("user count : " + this.memberDao.countByLoginDto(loginDTO));
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
		if(this.memberDao.countByUserId(userId) > 0) {
			return true;
		}
		
		return false;
	}

	@Override
	public boolean existEmail(String email) {
		if(this.memberDao.countByEmail(email) > 0) {
			return true;
		}
		
		return false;
	}

	@Override
	public boolean existPhoneNumber(String phone) {
		if(this.memberDao.countByPhone(phone) > 0) {
			return true;
		}
		
		return false;
	}

	@Override
	public UserResultDTO signUp(SignUpDTO signUpDTO) {
		UserResultDTO userResultDTO = new UserResultDTO("Sign-up");
		int id = this.memberDao.getNextId();
		signUpDTO.setId(id);
		
		try {
			this.memberDao.insertMember(signUpDTO);
			userResultDTO.setStatus(
				StatusEnum.SIGNUP_SUCCESS.getStatus(),
				StatusEnum.SIGNUP_SUCCESS.getStatusEngMessage(),
				StatusEnum.SIGNUP_SUCCESS.getStatusKorMessage()
			);
			
			userResultDTO.setContent("STRING", UserMessageConstants.MESSAGE_SIGN_UP_SUCCESS);
		} catch (Exception e) {
			userResultDTO.setStatus(
				StatusEnum.SIGNUP_FAILED.getStatus(),
				StatusEnum.SIGNUP_FAILED.getStatusEngMessage(),
				StatusEnum.SIGNUP_FAILED.getStatusKorMessage()
			);
			
			userResultDTO.setContent("STRING", UserMessageConstants.MESSAGE_SIGN_UP_FAILED);
		}
		
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
