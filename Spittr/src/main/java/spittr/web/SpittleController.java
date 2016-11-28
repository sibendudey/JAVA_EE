package spittr.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import spittr.data.SpittleRepository;

@Controller
@RequestMapping( "/Spittle")
public class SpittleController {
	SpittleRepository spittleRepository;
	private static final String LONG_MAX = "99999";
	
	@Autowired
	public SpittleController(SpittleRepository spittleRepository)	{
		this.spittleRepository = spittleRepository;
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public String spittle(Model model , @RequestParam(value="max" , defaultValue=LONG_MAX ) int max , @RequestParam(value="count" , defaultValue="20") int count){
		model.addAttribute("spittleList" , spittleRepository.findSpittles(max, count));
		return "spittles";
	}
}
