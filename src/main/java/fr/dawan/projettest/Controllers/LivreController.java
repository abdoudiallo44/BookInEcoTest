package fr.dawan.projettest.Controllers;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Timestamp;
import java.time.LocalDate;
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
	public String gestionLivre(Model model, HttpSession session) {
		Utilisateur user = (Utilisateur) session.getAttribute("user");
		model.addAttribute("listeLivre", livreService.findAllByUser(user.getId(), true));
		return "livres";
	}

	@PostMapping("/livres/ajouterLivre")
	public String ajouter(Model model, HttpSession session, @Valid @ModelAttribute("livreForm") LivreForm livreForm,
			BindingResult bindingResult) {
		Utilisateur user = (Utilisateur) session.getAttribute("user");
		LocalDate date = LocalDate.now();
		Livre l = new Livre(livreForm.getAuteur(), livreForm.getTitre(), livreForm.getDescription(),
				livreForm.getPoids(), livreForm.getFormat(), date, true, livreForm.getEtat(), user);
		if (session.getAttribute("photo") != null) {
			l.setPhoto(session.getAttribute("photo").toString());
		}
		if (bindingResult.hasErrors()) {
			System.out.println("oups");
			return "livres";
		}
		session.setAttribute("livreAjout", l);
		model.addAttribute("ajoutLivre",true);

		return "ajoutLivre";
	}

	@PostMapping("/livres/ajouterLivrePhoto")
	public String ajouter(Model model, HttpSession session, @RequestParam("photo") MultipartFile file) {
		Livre l = (Livre) session.getAttribute("livreAjout");
		LivreForm livreForm = LivreForm.toForm(l);
		model.addAttribute("livreForm",livreForm);
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		if (file != null) {
			model.addAttribute("file", file);
			try {
				String fileName = timestamp.getTime() + "_" + file.getOriginalFilename();
				uploadFile(file, fileName);
				session.setAttribute("photo",fileName);
				l.setPhoto(fileName);
				session.setAttribute("livreAjout", l);
			} catch (IOException e) {
				e.printStackTrace();
				model.addAttribute("erreur", "Erreur lors de l'upload");
			}
		}
		model.addAttribute("photoAjoutee",file.getOriginalFilename());
		return "ajoutLivre";
	}

	@GetMapping("/livres/ajouterLivre")
	public String ajoutPage(HttpSession session,Model model) {
		Livre l = (Livre) session.getAttribute("livreAjout");
		if(l != null && l.isValid()) {
			livreService.create(l, true);
			session.removeAttribute("livreAjout");
			session.removeAttribute("photo");
			model.addAttribute("ajoutFinal",true);
		}
		return "ajoutLivre";
	}

	public void uploadFile(MultipartFile mpFile, String fileName) throws IOException {

		String path = servletContext.getRealPath("/resources/img/");
		File uploadDir = new File(path);
		if (!uploadDir.exists()) {
			uploadDir.mkdirs();
		}

		System.out.println(uploadDir);
		System.out.println(fileName);
		File uploadFile = new File(uploadDir, fileName);

		FileOutputStream stream = new FileOutputStream(uploadFile);
		stream.write(mpFile.getBytes());
		stream.close();
	}

	@RequestMapping(value = "livres/findByKey", method = RequestMethod.POST)
	public String findByKey(Model model, @RequestParam("motCle") String recherche) {

		List<Livre> livres = livreService.findByKey(recherche, true);
		model.addAttribute("listeLivre", livres);

		return "livres";
	}

	@RequestMapping(value = "livres/supprimer/{id}", method = RequestMethod.GET)
	public String deleteById(Model model,HttpSession session, @PathVariable("id") long id) {
		Utilisateur user = (Utilisateur) session.getAttribute("user");
		livreService.deleteById(Livre.class, id, false);
		List<Livre> livres = livreService.findAllByUser(user.getId(), true);
		model.addAttribute("listeLivre", livres);

		return "livres";
	}

	@GetMapping(value = "livres/modifier/{id}")
	public String updateGet(Model model, @PathVariable("id") long id) {
		Livre livre = livreService.findById(Livre.class,id, true);
		LivreForm form = LivreForm.toForm(livre);
		model.addAttribute("livreForm", form);
		return "modifLivre";
	}
	
	@PostMapping(value = "livres/modifier/{id}")
	public String updatePost(Model model, @PathVariable("id") long id,@Valid @ModelAttribute("livreForm") LivreForm livreForm) {
		Livre livre = livreService.findById(Livre.class, id, false);
		livre.updateToLivre(livreForm);
		livreService.update(livre, true);
		model.addAttribute("modifLivre", true);
		return "modifLivre";
	}
	@PostMapping(value = "livres/modifierPhoto/{id}")
	public String updatePost(Model model, @PathVariable("id") long id,@RequestParam("photo") MultipartFile file) {
		Livre livre = livreService.findById(Livre.class, id, false);
		livreService.update(livre, true);
		model.addAttribute("modifLivre", true);
		return "modifLivre";
	}
}
