package kr.mook.user.signup.dao;

import java.util.List;

import kr.mook.user.common.dto.SignUpDTO;
import kr.mook.user.common.dto.TermsOfUseMemberDTO;

/**
 * <strong>SignUpDao</strong><br/>
 * <em>- Type : Interface</em><br/>
 * <br/>
 * 
 * 1. SignUpDao에 대한 설명<br/>
 * - SignUpDao는 회원 가입 시 입력하는 아이디/이메일/휴대전화번호의 중복 여부를 확인하거나 회원 가입 정보를 저장하기 위해 데이터베이스와 연동하는 기능을 담당하고 있습니다.<br/>
 * <br/>
 * 
 * 2. SignUpDao 수정 이력<br/>
 * - 2024. 07. 11 : 회원가입 Data Access Object Interface 작성<br/>
 * - 2024. 07. 14 : 회원가입 Method 작성<br/>
 * <br/>
 * 
 * @since 2024. 07. 11
 * @author In-mook, Jeong
 * @version 1.0.0
 */
public interface SignUpDao {
	
	/**
	 * <strong>countByUserId</strong><br/>
	 * <em>- Type : Method</em><br/>
	 * <br/>
	 * 
	 * 1. countByUserId에 대한 설명<br/>
	 * - 회원가입 시 사용자가 입력한 아이디(계정)가 데이터베이스에서 몇 개가 조회되는지 확인합니다.<br/>
	 * <br/>
	 * 
	 * 2. countByUserId 수정 이력<br/>
	 * - 2024. 07. 11 : Method 작성<br/>
	 * <br/>
	 * 
	 * @param userId 회원가입 시 사용자가 입력한 아이디(계정)
	 * @return 데이터베이스에서 조회한 사용자 아이디(계정) 갯수 반환
	 * @since 2024. 07. 11
	 * @author In-mook, Jeong
	 * @version 1.0.0
	 */
	public int countByUserId(String userId);
	
	/**
	 * <strong>countByPhone</strong><br/>
	 * <em>- Type : Method</em><br/>
	 * <br/>
	 * 
	 * 1. countByPhone에 대한 설명<br/>
	 * - 회원가입 시 사용자가 입력한 휴대전화번호가 데이터베이스에서 몇 개가 조회되는지 확인합니다.<br/>
	 * <br/>
	 * 
	 * 2. countByPhone 수정 이력<br/>
	 * - 2024. 07. 11 : Method 작성<br/>
	 * <br/>
	 * 
	 * @param email 회원가입 시 사용자가 입력한 휴대전화번호
	 * @return 데이터베이스에서 조회한 휴대전화번호 갯수 반환
	 * @since 2024. 07. 11
	 * @author In-mook, Jeong
	 * @version 1.0.0
	 */
	public int countByPhone(String phone);
	
	/**
	 * <strong>countByEmail</strong><br/>
	 * <em>- Type : Method</em><br/>
	 * <br/>
	 * 
	 * 1. countByEmail에 대한 설명<br/>
	 * - 회원가입 시 사용자가 입력한 이메일이 데이터베이스에서 몇 개가 조회되는지 확인합니다.<br/>
	 * <br/>
	 * 
	 * 2. countByEmail 수정 이력<br/>
	 * - 2024. 07. 11 : Method 작성<br/>
	 * <br/>
	 * 
	 * @param email 회원가입 시 사용자가 입력한 이메일
	 * @return 데이터베이스에서 조회한 이메일 갯수 반환
	 * @since 2024. 07. 11
	 * @author In-mook, Jeong
	 * @version 1.0.0
	 */
	public int countByEmail(String email);
	
	/**
	 * <strong>insertMember</strong><br/>
	 * <em>- Type : Method</em><br/>
	 * <br/>
	 * 
	 * 1. insertMember에 대한 설명<br/>
	 * - 사용자가 입력한 회원 가입 정보를 데이터베이스에 저장합니다.<br/>
	 * <br/>
	 * 
	 * 2. insertMember 수정 이력<br/>
	 * - 2024. 07. 14 : Method 작성<br/>
	 * <br/>
	 * 
	 * @param signUpDto
	 * @return
	 * @since 2024. 07. 14
	 * @author In-mook, Jeong
	 * @version 1.0.0
	 */
	public int insertMember(SignUpDTO signUpDto);
	
	/**
	 * <strong>selectIdByUserId</strong><br/>
	 * <em>- Type : Method</em><br/>
	 * <br/>
	 * 
	 * 1. selectIdByUserId에 대한 설명<br/>
	 * - 사용자가 입력한 아이디(계정)를 통해 사용자 아이디(숫자 형식)를 조회합니다.<br/>
	 * <br/>
	 * 
	 * 2. selectIdByUserId 수정 이력<br/>
	 * - 2024. 07. 14 : Method 작성<br/>
	 * <br/>
	 * 
	 * @param userId : 사용자 계정(아이디)
	 * @return
	 * @since 2024. 07. 14
	 * @author In-mook, Jeong
	 * @version 1.0.0
	 */
	public int selectIdByUserId(String userId);
	
	/**
	 * <strong>insertTermsOfUseMembers</strong><br/>
	 * <em>- Type : Method</em><br/>
	 * <br/>
	 * 
	 * 1. insertTermsOfUseMembers에 대한 설명<br/>
	 * - 사용자가 회원 가입을 위해 동의한 약관 정보를 데이터베이스에 저장합니다.<br/>
	 * <br/>
	 * 
	 * 2. insertTermsOfUseMembers 수정 이력<br/>
	 * - 2024. 07. 14 : Method 작성<br/>
	 * <br/>
	 * 
	 * @param termsOfUseMembers
	 * @return
	 * @since 2024. 07. 14
	 * @author In-mook, Jeong
	 * @version 1.0.0
	 */
	public int insertTermsOfUseMembers(TermsOfUseMemberDTO termsOfUseMember);
}
