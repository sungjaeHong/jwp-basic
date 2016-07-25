package next.controller.qna;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import core.mvc.AbstractController;
import core.mvc.ModelAndView;
import next.controller.UserSessionUtils;
import next.dao.QuestionDao;
import next.model.Question;
import next.model.User;

public class AddQuestionController extends AbstractController {
	private static final Logger log = LoggerFactory.getLogger(AddQuestionController.class);
	private QuestionDao questionDao = new QuestionDao();

	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession();
		if(session!=null && !UserSessionUtils.isLogined(session)){
			return jspView("redirect:/users/loginForm");
		}else{
			User user = UserSessionUtils.getUserFromSession(session);
			
			Question quesion = new Question(user.getName(), 
					request.getParameter("title"), 
					request.getParameter("contents"));

			questionDao.insert(quesion);
			return jspView("redirect:/");
		}
	}
}
