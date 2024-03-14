package kr.mook.user.constants;

/**
 * UserViewConstatns manages the page path provided by the user module.<br/>
 * A page path starting with <i>"common"</i> refers to a screen path that can be accessed by users who are not logged in.<br/>
 * The page path starting with <i>"member"</i> refers to the screen path that members can access.<br/>
 * A page path starting with <i>"admin"</i> refers to a screen path that only administrators can access.
 * 
 * @since 2024.03.06
 * @author In-mook, Jeong
 * @version 0.0.1
 */
public class UserViewConstatns {
	
	// COMMON PAGES
	public static final String COMMON_HOME = "common/home";		// home page
	public static final String COMMON_LOGIN = "common/login";	// log-in page
	public static final String COMMON_SIGNUP = "common/sign-up";	// sign-up page
	public static final String COMMON_FIND_ID = "common/find-id";	// find-id page
	public static final String COMMON_FIND_PASSWORD = "common/find-password";	// find-password page

	// ADMIN
	public static final String ADMIN_LIST = "admin/list";	// user list page
}
