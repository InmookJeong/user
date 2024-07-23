package kr.mook.user.list.dao;

import java.util.List;

import kr.mook.user.list.dto.SearchDTO;
import kr.mook.user.list.dto.SearchResultDTO;

/**
 * <strong>ListDao</strong><br/>
 * <em>- Type : Interface</em><br/>
 * <br/>
 * 
 * 1. ListDao에 대한 설명<br/>
 * - ListDao는 회원 목록을 조회하기 위해 데이터베이스와 연동하는 기능을 담당하고 있습니다.<br/>
 * <br/>
 * 
 * 2. ListDao 수정 이력<br/>
 * - 2024. 07. 21 : 회원목록 조회 Data Access Object Interface 작성<br/>
 * <br/>
 * 
 * @since 2024. 07. 21
 * @author In-mook, Jeong
 * @version 1.0.0
 */
public interface ListDao {
	
	/**
	 * <strong>getMembers</strong><br/>
	 * <em>- Type : Method</em><br/>
	 * <br/>
	 * 
	 * 1. getMembers에 대한 설명<br/>
	 * - 사용자 이름과 이메일을 통해 회원가입 시 입력한 아이디(계정)을 조회합니다.<br/>
	 * <br/>
	 * 
	 * 2. getMembers 수정 이력<br/>
	 * - 2024. 07. 21 : Method 작성<br/>
	 * <br/>
	 * 
	 * @param searchDTO
	 * @return
	 * @since 2024. 07. 21
	 * @author In-mook, Jeong
	 * @version 1.0.0
	 */
	public List<SearchResultDTO> getMembers(final SearchDTO searchDTO);
	
}
