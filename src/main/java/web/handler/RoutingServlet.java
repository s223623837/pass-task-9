package web.handler;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import web.service.LoginService;
import web.service.MathQuestionService;

@Controller
@RequestMapping("/")
public class RoutingServlet {

	@GetMapping("/")
	public String welcome() {
		System.out.println("Welcome ...");
		return "view-welcome";
	}
	

	@GetMapping("/login")
	public String loginView() {
		System.out.println("login view...");
		return "view-login";
	}
	

	@PostMapping("/login")
	public RedirectView login(
			HttpServletRequest request, 
			RedirectAttributes redirectAttributes) {
		System.out.println("login form...");
		String username = request.getParameter("username");
		String password = request.getParameter("passwd");
		String dob = request.getParameter("dob");
		
		System.out.println("Username/password: " + username + ", " + password);
		
		RedirectView redirectView = null;
		if (LoginService.login(username, password, dob)) {
			redirectView = new RedirectView("/q1", true);
		} else {
			// Login failed, stay with login page.
			//
			redirectView = new RedirectView("/login", true);
			// Show error message
			//
			redirectAttributes.addFlashAttribute("message", "Incorrect credentials.");
		}
		
		return redirectView;
	}
	

	@GetMapping("/q1")
	public String q1View() {		
		System.out.println("q1 view...");
		return "view-q1";
	}

	@PostMapping("/q1")
	public RedirectView q1(
			HttpServletRequest request, 
			RedirectAttributes redirectAttributes) {
		System.out.println("q1 form...");
		String number1 = request.getParameter("number1");
		String number2 = request.getParameter("number2");
		String resultUser = request.getParameter("result");
		
		double calculatedResult = MathQuestionService.q1Addition(number1, number2);
		System.out.println(
				"User result: " + resultUser + ", answer: " + calculatedResult);
		
		RedirectView redirectView = null;
		if (calculatedResult == Double.valueOf(resultUser)) {
			redirectView = new RedirectView("/q2", true);
		} else {
			// Q1 wrong.
			//
			redirectView = new RedirectView("/q1", true);
			// Show error message
			//
			redirectAttributes.addFlashAttribute("message", "Wrong answer, try again.");
		}		
		return redirectView;
	}	
	

	@GetMapping("/q2")
	public String q2View() {		
		System.out.println("q2 view...");
		return "view-q2";
	}	


	@PostMapping("/q2")
	public RedirectView q2(HttpServletRequest request, RedirectAttributes redirectAttributes) {
		System.out.println("q1 form...");
		String number1 = request.getParameter("number1");
		String number2 = request.getParameter("number2");
		String resultUser = request.getParameter("result");
		
		double calculatedResult = MathQuestionService.q2Subtraction(number1, number2);
		System.out.println("User result: " + resultUser + ", answer: " + calculatedResult);
		
		RedirectView redirectView = null;
		if (calculatedResult == Double.valueOf(resultUser)) {
			redirectView = new RedirectView("/q3", true);
		} else {
			// Q1 wrong
			//
			redirectView = new RedirectView("/q2", true);
			// Show error message
			//
			redirectAttributes.addFlashAttribute("message", "Wrong answer, try again.");
		}		
		return redirectView;
	}	
	

	@GetMapping("/q3")
	public String q3View() {        
	    System.out.println("q3 view...");
	    return "view-q3";
	}

	@PostMapping("/q3")
	public RedirectView q3(
	        HttpServletRequest request, 
	        RedirectAttributes redirectAttributes) {
	    System.out.println("q3 form...");
	    String number1 = request.getParameter("number1");
	    String number2 = request.getParameter("number2");
	    String resultUser = request.getParameter("result");
	    
	    double result = MathQuestionService.q3Multiplication(number1, number2);
	    System.out.println("User result: " + resultUser + ", answer: " + result);
	    
	    RedirectView redirectView = null;
	    if (result == Double.valueOf(resultUser)) {
	        redirectView = new RedirectView("/q4", true);
	    } else {
	        // Q3 wrong
	        //
	        redirectView = new RedirectView("/q3", true);
	        // Show error message
	        //
	        redirectAttributes.addFlashAttribute("message", "Wrong answer, try again.");
	    }       
	    return redirectView;
	}
	@GetMapping("/q4")
	public String q4View() {        
	    System.out.println("q4 view...");
	    return "view-q4";
	}
	@PostMapping("/q4")
	public RedirectView q4(
	        HttpServletRequest request, 
	        RedirectAttributes redirectAttributes) {
	    System.out.println("q4 form...");
	    String number1Str = request.getParameter("number1");
	    String number2Str = request.getParameter("number2");
	    String resultUserStr = request.getParameter("result");
	    
	    // Parse input strings to double values
	    double resultUser = Double.parseDouble(resultUserStr);
	    
	    // Calculate division result
	    double calculatedResult = MathQuestionService.q4Division(number1Str, number2Str);
	    

	    System.out.println("User result: " + resultUser + ", answer: " + calculatedResult);
	    
	    RedirectView redirectView = null;
	    if (calculatedResult == Double.valueOf(resultUser)) {
	        redirectView = new RedirectView("/q5", true); // Redirect to next question (e.g., q5)
	    } else {
	        // Q4 wrong
	        redirectView = new RedirectView("/q4", true); // Stay on the same question
	        redirectAttributes.addFlashAttribute("message", "Wrong answer, try again.");
	    }       
	    return redirectView;
	}
	@GetMapping("/q5")
	public String q5View() {        
	    System.out.println("q5 view...");
	    return "view-q5";
	}

	@PostMapping("/q5")
	public RedirectView q5(
	        HttpServletRequest request, 
	        RedirectAttributes redirectAttributes) {
	    System.out.println("q5 form...");
	    String number1Str = request.getParameter("number1");
	    String number2Str = request.getParameter("number2");
	    String resultUserStr = request.getParameter("result");
	    
	    double resultUser = Double.parseDouble(resultUserStr);
	    
	    // Calculate multiplication result
	    double calculatedResult = MathQuestionService.q3Multiplication(number1Str, number2Str);

	    System.out.println("User result: " + resultUser + ", answer: " + calculatedResult);
	    
	    RedirectView redirectView = null;
	    if (Math.abs(calculatedResult - resultUser) < 0.001) {
	        redirectView = new RedirectView("/final", true); // Redirect to next question (e.g., q6)
	    } else {
	        // Q5 wrong
	        redirectView = new RedirectView("/q5", true); // Stay on the same question
	        redirectAttributes.addFlashAttribute("message", "Wrong answer, try again.");
	    }       
	    return redirectView;
	}
	@GetMapping("/final")
	public String finalView() {        
	    System.out.println("final view...");
	    return "views-final";
	}
}
