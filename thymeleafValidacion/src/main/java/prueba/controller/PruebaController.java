package prueba.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;



import prueba.entidad.PruebaEntity;
import prueba.service.PruebaService;
import prueba.validador.PruebaValidador;
 
@Controller
@RequestMapping("/")
public class PruebaController {
 
  @Autowired 
  private PruebaService pruebaSvc;
  
  

	@InitBinder
	protected void initBinder(WebDataBinder binder) {
		
		binder.setValidator(new PruebaValidador()); // registramos el validador
	
	}
  
   
  /**
   * Requests to http://localhost:8080/prueba will be mapped here.
   * Everytime invoked, we pass list of all persons to view
   */
  @RequestMapping(method = RequestMethod.GET)
  public String listAll(Model model) {
    model.addAttribute("pruebas", pruebaSvc.getAll());
    model.addAttribute("pruebaDTO",new PruebaEntity());
    return "prueba";
  }
   
  /**
   * POST requests to http://localhost:8080/prueba/addPerson goes here.
   * The new person data is passed from HTML from and bound into the
   * Person object.
   */
  @RequestMapping(value = "/addPrueba", method = RequestMethod.POST)
  public String addPerson(Model model,@ModelAttribute("pruebaDTO") @Validated PruebaEntity prueba,final BindingResult result) {
	  if (result.hasErrors()) { 
	        model.addAttribute("pruebaDTO", prueba);  
	        return "prueba"; 
	    }else{
	    	 //pruebaSvc.add(prueba);
	    	    return "redirect:/";
	    }
	  
	 
  }
}