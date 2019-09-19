package com.movie.baisc;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.movie.VO.CinemaVO;
import com.movie.VO.CustomerVO;
import com.movie.VO.MovieVO;
import com.movie.VO.TicketInfoVO;
import com.movie.VO.TicketingVO;
import com.movie.mapper.CinemaMapper;
import com.movie.mapper.CustomerMapper;
import com.movie.mapper.EtcMapper;
import com.movie.mapper.MovieMapper;
import com.movie.mapper.TicketingMapper;


@Controller
@SessionAttributes("mybatisMovie")
public class MainController {
	String sessionid ="";
	
	@Autowired
	MovieMapper moviemappercommand;
	@Autowired
	CinemaMapper cinemamappercommand;
	@Autowired
	TicketingMapper ticketmappercommand;
	@Autowired
	CustomerMapper customermappercommand;
	@Autowired
	EtcMapper etcmappercommand;
	
	PrintWriter out;
	
	@RequestMapping("/main")
	public String main(Model model){	
		ArrayList<CinemaVO> cinemavos = (ArrayList<CinemaVO>) cinemamappercommand.getAllCinemas();
		model.addAttribute("mybatisCinemas", cinemavos);
		
		ArrayList<MovieVO> movievos = (ArrayList<MovieVO>) moviemappercommand.getAllMovies();
		model.addAttribute("mybatisMovies",movievos);
		 
		model.addAttribute("TicketingVO",new TicketingVO());
		model.addAttribute("MovieVO",new MovieVO());
		model.addAttribute("user_name",etcmappercommand.getUser());
		model.addAttribute("sessionid",sessionid);
		
		return "main";		
	}
	
	@RequestMapping("/JoinOK")
	public String JoinOk(@Valid CustomerVO customervo,BindingResult result){		
		System.out.println("회원가입이 되었습니다");
		customermappercommand.insertCustomer(customervo);
		return "login";
	}//insertOk()
	
	
	@RequestMapping(value="loginOK", method=RequestMethod.POST)
	public String checkId(@RequestParam String id,@RequestParam String pw,HttpServletResponse response) throws IOException {
		System.out.println(id+","+pw);
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("id", id); map.put("pw", pw);
		String hi = etcmappercommand.checkLogin(map);
		System.out.println(hi);
		if(hi != null) {
			out = response.getWriter();
			out.println("<script>alert('로그인');</script>");
			System.out.println("로그인 되셨습니다");
			sessionid = id;
			return "redirect:index";
		}
		else {
			out = response.getWriter();
			out.println("<script>alert('없는 회원이거나 잘못 입력하셨습니다.');</script>");
			System.out.println("없는 회원이거나 잘못 입력하셨습니다.");
			return "redirect:login";
		}		
		
	}
	@RequestMapping("logout")
	public String logout() {
		sessionid ="";
		return "redirect:index";
	}

	/*
	@RequestMapping("/idcheck/{id}")
	public String checkId(@PathVariable String id, RedirectAttributes redirectAttributes, HttpServletResponse response) throws IOException {
		
		if(customermappercommand.getCustomer(id) == null) {
			out = response.getWriter();
			out.println("<script>alert('사용할 수 있는 아이디 입니다.');</script>");
			System.out.println("사용할 수 있는 아이디 입니다.");
			return "main";
		}
		else {
			out = response.getWriter();
			out.println("<script>alert('사용할 수 없는 아이디 입니다.');</script>");
			System.out.println("사용할 수  없는 아이디 입니다.");
			return "joinform";
		}		
		
	}
	*/

	
	@RequestMapping("/MovInsertOk")
	public String MovInsertOk(@Valid MovieVO movievo,BindingResult result){		
		System.out.println("영화가 추가되었습니다");
		moviemappercommand.insertMovie(movievo);
		return "redirect:movie";

	}//insertOk()
	@RequestMapping("delMovie/{id}")
	public String deleteMovie(@PathVariable String id, HttpServletResponse response) throws IOException {
		System.out.println("deleteMovok");
		moviemappercommand.deleteMovie(id);
		out = response.getWriter();
		out.println("<script>alert('영화가 삭제되었습니다.');</script>");
		return "redirect:/movie";
	}
	@RequestMapping("/tInsertOk")
	public String insertOk(@Valid TicketingVO ticketvo,BindingResult result){		
		System.out.println("예매에 일단 성공하였습니다.");
		System.out.println("cinema : "+ticketvo.getCinema());
		moviemappercommand.insertTicket(ticketvo);
		return "redirect:ticketcheck/"+ticketvo.getTicketid();
	}//insertOk()
	
	@RequestMapping("checkOk")
	public String checkOk(HttpServletRequest request) {
		System.out.println("checkok");
		String id = request.getParameter("ticketid");
		return "redirect:ticketcheck/"+id;		
	}
	
	@RequestMapping("delTicket/{id}")
	public String delTicket(@PathVariable String id, HttpServletResponse response) throws IOException {
		System.out.println("deleteok");
		
		if(ticketmappercommand.getTicket(id) !=null){ //id 존재하는 경우
			ticketmappercommand.deleteTicket(id);
			out = response.getWriter();
			out.println("<script>alert('예매가 취소되었습니다.');</script>");
		}else{ //id null인 경우
			System.out.println("delfail");
			return "delFail";
		}
		return "redirect:/insertid";
	}
	
	@RequestMapping("/ticketcheck/{id}")
	public String ticketidcheck(@PathVariable String id, RedirectAttributes redirectAttributes, HttpServletResponse response) throws IOException {
		redirectAttributes.addFlashAttribute("viewpage","ticketcheckProc.jsp");
		
		if(ticketmappercommand.getTicket(id) == null) {
			out = response.getWriter();
			out.println("<script>alert('없는 예매입니다.');</script>");
			System.out.println("없는 예매입니다.");
			return "redirect:/insertid";
		}
		else {
			System.out.println("ticket is not null");
			TicketInfoVO ticketvo = ticketmappercommand.getTicket(id);
			redirectAttributes.addFlashAttribute("Ticket", ticketvo);
			System.out.println(ticketvo.getTicketid());
			System.out.println(ticketvo.getMovie());
			return "redirect:/main";
		}		
		
	}
	
	
	/* include */
	@RequestMapping("/joinform")
	public String joinform() {
		return "joinform";
	}
	@RequestMapping("/login")
	public String loginform() {
		return "login";
	}
	@RequestMapping("/insertMovie")
	public String insertmovie(RedirectAttributes redirectAttributes) {
		redirectAttributes.addFlashAttribute("viewpage","insertMovie.jsp");
		return "redirect:/main";
	}
	@RequestMapping("/movie")
	public String movie(RedirectAttributes redirectAttributes) {
		redirectAttributes.addFlashAttribute("viewpage","movieProc.jsp");
		return "redirect:/main";
	}
	@RequestMapping("/ticketing")
	public String ticketing(RedirectAttributes redirectAttributes) {
		
		redirectAttributes.addFlashAttribute("viewpage","ticketingProc.jsp?TicketingVO=${TicketingVO }");
		return "redirect:/main";
	}
	@RequestMapping("/index") 
	public String index(RedirectAttributes redirectAttributes) {
		redirectAttributes.addFlashAttribute("viewpage","ticketingProc.jsp");
		return "redirect:/main";
	}
	@RequestMapping("/insertid") 
	public String insertid(RedirectAttributes redirectAttributes) {
		redirectAttributes.addFlashAttribute("viewpage","insertTid.jsp");
		return "redirect:/main";
	}
	@RequestMapping("/delFail") 
	public String delFail(RedirectAttributes redirectAttributes) {
		redirectAttributes.addFlashAttribute("viewpage","delFail.jsp");
		return "redirect:/main";
	}
}
