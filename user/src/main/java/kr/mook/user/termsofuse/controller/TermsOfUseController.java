package kr.mook.user.termsofuse.controller;

import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import kr.mook.user.constants.UserViewConstatns;
import kr.mook.user.termsofuse.service.TermsOfUseService;

/**
 * <strong>TermsOfUseController</strong><br/>
 * <em>- Type : Class</em><br/>
 * <br/>
 * 
 * 1. TermsOfUseController에 대한 설명<br/>
 * - TermsOfUseController는 약관 동의 화면으로 이동하기 위한 API가 정의되어 있는 Controller입니다.<br/>
 * - 화면으로 이동하기 전 데이터베이스에 저장되어 있는 '약관' 목록을 조회한 후 화면으로 전달합니다.<br/>
 * <br/>
 * 
 * 2. 반환 결과<br/>
 * - 회원가입 실패 시 아래 데이터를 반환<br/>
 * <pre style="padding-left:1rem;">
 * {
 *     "apiTitle" : "Sign-up",
 *     "status" : "SNU-400",
 *     "statusMessage" : {
 *         "eng" : "Failed SignUp",
 *         "kor" : "회원가입 실패"
 *     },
 *     "contentType" : "STRING",
 *     "content" : "회원가입이 되지 않았습니다. 관리자에게 문의해주세요.",
 * }
 * </pre>
 * 
 * 4. TermsOfUseController 수정 이력<br/>
 * - 2024. 07. 06 : 약관동의 API 최초 작성<br/>
 * <br/>
 * 
 * @since 2024. 07. 06
 * @author In-mook, Jeong
 * @version 1.0.0
 */
@Controller
@RequestMapping("/terms-of-use")
public class TermsOfUseController {
	
	// TermsOfUseController Logger
	private final Logger _log = Logger.getLogger(TermsOfUseController.class.getName());
	
	@Autowired
	private TermsOfUseService termsOfUseService;
	
	/**
	 * <strong>termsOfUse</strong><br/>
	 * <em>- Type : Method</em><br/>
	 * <br/>
	 * 
	 * 1. termsOfUse에 대한 설명<br/>
	 * - 회원가입에 앞서 홈페이지 이용 약관, 개인정보 제공 동의 약관 등 사이트 전반에 대한 이용 약관 정보를 사용자에게 제공합니다.<br/>
	 * - 사용자가 이용 약관에 동의함으로써 사이트 이용에 대한 법률적 근거를 얻을 수 있습니다.<br/>
	 * <br/>
	 * 
	 * 2. HTTP Method<br/>
	 * - GET<br/>
	 * <br/>
	 * 
	 * 3. termsOfUse 수정 이력<br/>
	 * - 2024. 07. 08 : Method 작성<br/>
	 * <br/>
	 * 
	 * @return ModelAndView
	 * - Model : 약관 목록
	 * - View : 약관 동의 페이지
	 * @since 2024. 07. 08
	 * @author In-mook, Jeong
	 * @version 1.0.0
	 */
	@RequestMapping(value = "", method = RequestMethod.GET)
	public ModelAndView termsOfUse() {
		_log.info("##### 사이트 이용 약관 페이지로 이동.");
		ModelAndView mv = new ModelAndView();
		mv.addObject("list", this.termsOfUseService.listTermsOfUseInUse());
		mv.setViewName(UserViewConstatns.TERMS_OF_USE);
		return mv;
	}

}
