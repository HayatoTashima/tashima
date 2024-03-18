package jp.ac.ohara.E.seisaku.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import io.micrometer.common.lang.NonNull;
import jp.ac.ohara.E.seisaku.model.ShifutoHyou;
import jp.ac.ohara.E.seisaku.service.ShifutoService;

@Controller
public class MainController {
	@Autowired
	private ShifutoService ShifutoService;


@GetMapping("/")
  public String index(Model model) {
    model.addAttribute("message", "こんにちは");
    return "top";
  }

@GetMapping("/tashima/")
public String index2(Model model) {
  model.addAttribute("message", "こんにちは");
  return "top2";
}
 
@GetMapping("/touroku/")
public ModelAndView add(ShifutoHyou shifutohyou, ModelAndView model)  {
    model.addObject("shifutomanage", shifutohyou);
    model.setViewName("touroku");
return model;
  }

@PostMapping("/touroku/")
public String gakuseihyou(@Validated @ModelAttribute @NonNull ShifutoHyou shifutohyou, RedirectAttributes result, ModelAndView model,
        RedirectAttributes redirectAttributes) {
    try {
        this.ShifutoService.save(shifutohyou);
        redirectAttributes.addFlashAttribute("exception", "");

    } catch (Exception e) {
        redirectAttributes.addFlashAttribute("exception", e.getMessage());
    }
    return "top2";

  }
}