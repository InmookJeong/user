package kr.mook.user.common.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import org.springframework.stereotype.Service;

import kr.mook.user.common.dto.LoginDTO;
import kr.mook.user.common.service.UserService;
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
	
	// UserController Logger
	private final Logger _log = Logger.getLogger(UserService.class.getName());

	@Override
	public boolean login(LoginDTO loginDTO) {
		if(loginDTO.getUserId().equals("test") 
			&& loginDTO.getPassword().equals("testPassword")) {
			return true;
		}
		
		return false;
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
