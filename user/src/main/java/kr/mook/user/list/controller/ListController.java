package kr.mook.user.list.controller;

import java.util.logging.Logger;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.mook.user.common.dto.UserResultDTO;
import kr.mook.user.constants.UserViewConstatns;
import kr.mook.user.list.dto.SearchDTO;
import kr.mook.user.list.service.ListService;

/**
 * <strong>ListController</strong><br/>
 * <em>- Type : Class</em><br/>
 * <br/>
 * 
 * 1. ListController에 대한 설명<br/>
 * - ListController는 회원 목록을 조회하는 API가 정의되어 있는 Controller입니다.<br/>
 * <br/>
 * 
 * 2. ListController 수정 이력<br/>
 * - 2024. 07. 20 : 회원목록 조회 API 최초 작성<br/>
 * <br/>
 * 
 * @since 2024. 07. 20
 * @author In-mook, Jeong
 * @version 1.0.0
 */
@Controller
@RequestMapping("/list")
public class ListController {
	
	// ListController Logger
	private final Logger _log = Logger.getLogger(ListController.class.getName());
	
	@Autowired
	ListService listService;
	
	/**
	 * <strong>list</strong><br/>
	 * <br/>
	 * 
	 * 1. list에 대한 설명<br/>
	 * - 회원 목록 조회 페이지로 이동하기 위한 기능을 담당합니다.<br/>
	 * <br/>
	 * 
	 * 2. HTTP Method<br/>
	 * - GET<br/>
	 * <br/>
	 * 
	 * 3. list 수정 이력<br/>
	 * - 2024. 07. 20 : Method 작성<br/>	
	 * <br/>
	 * 
	 * @param request
	 * @return
	 * @since 2024. 07. 20
	 * @author In-mook, Jeong
	 * @version 1.0.0
	 */
	@RequestMapping(value = "", method = RequestMethod.GET)
	public String list(HttpServletRequest request) {
		_log.info("##### 회원 목록 조회 페이지로 이동.");
		return UserViewConstatns.ADMIN_LIST;
	}
	
	/**
	 * <strong>findId</strong><br/>
	 * <br/>
	 * 
	 * 1. findId에 대한 설명<br/>
	 * - 회원의 이름과 이메일 주소를 전달받아 데이터베이스에서 아이디를 조회합니다.<br/>
	 * <br/>
	 * 
	 * 2. HTTP Method<br/>
	 * - POST<br/>
	 * <br/>
	 * 
	 * 3. findId 수정 이력<br/>
	 * - 2024. 07. 21 : Method 작성<br/>	
	 * <br/>
	 * 
	 * @param request
	 * @param searchDTO 검색 값을 전달하는 DTO
	 * @return
	 * 		- 성공 시<br/>
	 * 		&emsp;    {<br/>
	 * 		&emsp;&emsp;    "apiTitle" : "User-List",<br/>
	 * 		&emsp;&emsp;    "status" : "USL-200",<br/>
	 * 		&emsp;&emsp;    "statusMessage" : {<br/>
	 * 		&emsp;&emsp;&emsp;    "eng" : "Success search user list",<br/>
	 * 		&emsp;&emsp;&emsp;    "kor" : "사용자 목록 조회 성공"<br/>
	 * 		&emsp;&emsp;    },<br/>
	 * 		&emsp;&emsp;    "contentType" : "OBJECT",<br/>
	 * 		&emsp;&emsp;    "content" : [SearchResultDTO],<br/>
	 * 		&emsp;    }<br/>
	 * 		- 실패 시<br/>
	 * 		&emsp;    {<br/>
	 * 		&emsp;&emsp;    "apiTitle" : "User-List",<br/>
	 * 		&emsp;&emsp;    "status" : "USL-400",<br/>
	 * 		&emsp;&emsp;    "statusMessage" : {<br/>
	 * 		&emsp;&emsp;&emsp;    "eng" : "Failed search user list",<br/>
	 * 		&emsp;&emsp;&emsp;    "kor" : "사용자 목록 조회 실패"<br/>
	 * 		&emsp;&emsp;    },<br/>
	 * 		&emsp;&emsp;    "contentType" : "STRING",<br/>
	 * 		&emsp;&emsp;    "content" : "사용자 목록 조회에 실패하였습니다.",<br/>
	 * 		&emsp;    }<br/> 
	 * @since 2024. 07. 21
	 * @author In-mook, Jeong
	 * @version 1.0.0
	 */
	@RequestMapping(value = "", method = RequestMethod.POST)
	@ResponseBody
	public UserResultDTO list(HttpServletRequest request, @RequestBody SearchDTO searchDTO) {
		_log.info("##### 회원 목록 조회.");
		return listService.searchList(searchDTO);
	}

}
