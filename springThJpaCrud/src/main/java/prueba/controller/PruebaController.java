package prueba.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import prueba.entidad.PruebaEntity;
import prueba.service.PruebaService;
 
@Controller
@RequestMapping("/")
public class PruebaController {
 
  @Autowired 
  private PruebaService pruebaSvc;
   
  /**
   * Requests to http://localhost:8080/prueba will be mapped here.
   * Everytime invoked, we pass list of all persons to view
   */
  @RequestMapping(method = RequestMethod.GET)
  public String listAll(Model model) {
    model.addAttribute("pruebas", pruebaSvc.getAll());
    model.addAttribute("prueba",new PruebaEntity());
    return "prueba";
  }
   
  /**
   * POST requests to http://localhost:8080/prueba/addPerson goes here.
   * The new person data is passed from HTML from and bound into the
   * Person object.
   */
  @RequestMapping(value = "/addPrueba", method = RequestMethod.POST)
  public String addPrueba(@ModelAttribute PruebaEntity prueba) {
	  pruebaSvc.add(prueba);
    return "redirect:/";
  }


@RequestMapping(value = "/removePrueba", method = RequestMethod.POST)
public String removePrueba(@ModelAttribute PruebaEntity prueba) {
	  pruebaSvc.remove(prueba);
  return "redirect:/";
}

@RequestMapping(value = "/updatePrueba", method = RequestMethod.POST)
public String updatePrueba(@ModelAttribute PruebaEntity prueba) {
	  pruebaSvc.updatePrueba(prueba);
  return "redirect:/";
}

}
