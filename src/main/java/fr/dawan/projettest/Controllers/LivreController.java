package fr.dawan.projettest.Controllers;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import fr.dawan.projettest.Beans.LivreForm;
import fr.dawan.projettest.entite.Livre;
import fr.dawan.projettest.entite.Utilisateur;
import fr.dawan.projettest.service.LivreService;

@Controller
public class LivreController {
	
	@Autowired
	LivreService livreService;
	
	@Autowired
	ServletContext servletContext;
	
	@GetMapping("/gestionLivre")
	public String gestionLivre(Model model,HttpSession session) {
		Utilisateur user = (Utilisateur) session.getAttribute("user");
		model.addAttribute("listeLivre", livreService.findAllByUser(user.getId(), true));
		return "livres";
	}
	
	@PostMapping("/livres/ajouterLivre")
	public String ajouter(Model model,HttpSession session, @Valid @ModelAttribute("livreForm") LivreForm livreForm,
			BindingResult bindingResult,@RequestParam("photo2") MultipartFile file) {
		model.addAttribute("file", file);
		Utilisateur user = (Utilisateur) session.getAttribute("user");

		Livre l = new Livre(livreForm.getAuteur(), livreForm.getTitre(), livreForm.getDescription(), livreForm.getPoids(), livreForm.getFormat(), true);
		l.setProprietaire(user);
		l.setPhoto(livreForm.getPhoto());
		if (bindingResult.hasErrors()) {
			//model.addAttribute("livreForm", livreService.findById(livreForm.getId()));
			//model.addAttribute("listeLivre", livreService.readAll());
			System.out.println("oups");
			return "livres";
		}
//		if (l.getId() != 0) {
//			livreService.update(l,false);
//		} else {
			livreService.create(l,false);
		//}
		model.addAttribute("listeLivre", livreService.findAllByUser(user.getId(), true));
		
		try {
			String fileName = file.getOriginalFilename();
			uploadFile(file, fileName);
		} catch (IOException e) {
			e.printStackTrace();
			model.addAttribute("erreur", "Erreur lors de l'upload");
		}
		
		return "livres";
	}
	
	@GetMapping("/livres/ajouterLivre")
	public String ajoutPage() {
		return "ajoutLivre";
	}
	public void uploadFile(MultipartFile mpFile, String fileName) throws IOException {

		String path = servletContext.getRealPath("/resources/img/");
		File uploadDir = new File(path);
		if (!uploadDir.exists()) {
			uploadDir.mkdirs();
		}
		
		File uploadFile = new File(uploadDir, fileName);
		byte[] bytes = mpFile.getBytes();
		FileOutputStream stream = new FileOutputStream(uploadFile);
		stream.write(bytes);
		stream.close();
	}
	
	@RequestMapping(value="livres/findByKey",method=RequestMethod.POST)
	public String findByKey(Model model,@RequestParam("motCle") String recherche) {

		List<Livre> livres = livreService.findByKey(recherche,true);
		model.addAttribute("listeLivre", livres);

		return "livres";
	}
	
	@RequestMapping(value="livres/supprimer/{id}",method=RequestMethod.GET)
	public String deleteById(Model model,@PathVariable("id") long id) {

		livreService.deleteById(Livre.class, id, false);
		List<Livre> livres = livreService.findAll(Livre.class,true);
		model.addAttribute("listeLivre", livres);

		return "livres";
	}
	
	@RequestMapping(value="livres/modifier/{id}",method=RequestMethod.GET)
	public String update(Model model,@PathVariable("id") long id) {
		List<Livre> livres = livreService.findAll(Livre.class,true);
		model.addAttribute("listeLivre", livres);

		return "livres";
	}
}
