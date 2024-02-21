package com.cp.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MainController {
	@Autowired
	private MemberService memService;
	@Autowired
	private OfficerService offService;
	@Autowired
	private RequestService reqService;
	@Autowired
	private RecordTransactionService recService;

	@GetMapping("/")
	public String mainMenu(Model model) {
		return "main";
	}

	@GetMapping("/login")
	public String loginPage(Model model) {
		LoginRequest login = new LoginRequest();
		model.addAttribute("login", login);
		return "login";
	}

	@GetMapping("/register")
	public String regPage(Model model) {
		Member member = new Member();
		model.addAttribute("member", member);
		return "register";
	}

	@GetMapping("/request")
	public String reqPage(Model model) {
		if (Session.isLogin) {
			RequestClone request = new RequestClone();
			Member member = memService.findMemberById(Session.memId);
			List<RequestType> listReqT = reqService.findAllRequestType();
			//RequestType reqType = new RequestType();
			model.addAttribute("request", request);
			model.addAttribute("listReqT", listReqT);
			model.addAttribute("member", member);
			//model.addAttribute("reqType", reqType);
			return "request";
		}else {
			return "redirect:/login";
		}
	}
	@GetMapping("/status")
	public String statusPage(Model model) {
		List<Request> requests = reqService.findAllByStatusId(1);
		List<RequestType> requestTypes = reqService.findAllRequestType();
		List<Member> members = memService.findAllMember();
		List<Status> status = reqService.findAllStatus();
		System.out.println(requests.size());
		model.addAttribute("requests", requests);
		model.addAttribute("listReqT", status);
		model.addAttribute("member", members);
		model.addAttribute("reqType", requestTypes);
		return "status";
	}
	@GetMapping("/report")
	public String reportPage(Model model) {
		List<RecordTransaction> records = recService.findAllRecord();
		List<SactionType> sactionType = recService.findAllSactionType();
		List<Member> members = memService.findAllMember();
		List<Request> requests = reqService.findAllRequest();
		List<Officer> officers = offService.findAllOfficer();
		model.addAttribute("requests", requests);
		model.addAttribute("records", records);
		model.addAttribute("member", members);
		model.addAttribute("sactionType", sactionType);
		model.addAttribute("officers", officers);
		return "report";
		
	}
	
	@GetMapping("/contact")
	public String contactPage(Model model) {
		return "contact";
	}
	

}
