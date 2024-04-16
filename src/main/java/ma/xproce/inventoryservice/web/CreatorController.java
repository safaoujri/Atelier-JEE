package ma.xproce.inventoryservice.web;

import ma.xproce.inventoryservice.dao.entities.Creator;
import ma.xproce.inventoryservice.dao.entities.Video;
import ma.xproce.inventoryservice.service.CreatorManager;
import ma.xproce.inventoryservice.service.CreatorManagerService;
import ma.xproce.inventoryservice.service.VideoManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

@Controller
public class CreatorController {
    @Autowired
    private CreatorManager creatorManager;

    @Autowired
    private VideoManager videoManager;


    @GetMapping("/creator")
    public String listCreator(Model model) {
        model.addAttribute("listcreator", creatorManager.getAllCreators());
        return "creatorlayout";
    }

    @GetMapping("/ajoutercreator")
    public String addCreatorForm(Model model) {
        return "addCreator";
    }



    @PostMapping("/ajoutercreator")
    public String addCreator(Model model, @RequestParam(name = "name") String name,
                             @RequestParam(name = "mail") String mail,
                             @RequestParam(name = "videoName") String videoName,
                             @RequestParam(name = "videoUrl") String videoUrl,
                             @RequestParam(name = "videodesc") String videodesc)


    {
        Creator creator = new Creator();
        creator.setNom(name);
        creator.setEmail(mail);

        Video video = new Video();
        video.setName(videoName);
        video.setUrl(videoUrl);
        video.setDatePublication(new Date());
        video.setDescription(videodesc);

        creator.addVideo(video);
        creatorManager.addCreator(creator);
        video.setCreator(creator);
        videoManager.addVideo(video);

        return "redirect:/indexpage";
    }
    @GetMapping("/deleteCreator")
    public String deleteCreatorAction(@RequestParam(name = "id") Integer id) {
        // Supprimer le créateur et récupérer la liste de ses vidéos
        Creator creatorToDelete = creatorManager.getCreatorById(id);
        Collection<Video> videosToDelete = creatorToDelete.getVideo();

        // Supprimer chaque vidéo associée au créateur
        for (Video video : videosToDelete) {
            videoManager.deleteVideo(video.getId());
        }

        // Supprimer le créateur
        boolean deletionResult = creatorManager.deleteCreator(id);

        // Rediriger en fonction du résultat de la suppression
        if (deletionResult) {
            return "redirect:/indexpage";
        } else {
            return "error"; // Gérer l'erreur si la suppression échoue
        }
    }
    @GetMapping("/editCreator")
    public String editCreatorForm(Model model, @RequestParam(name = "id") Integer id) {
        Creator creator = creatorManager.getCreatorById(id);
        if (creator != null) {
            model.addAttribute("creatorToBeUpdated", creator);
            List<Video> videos = new ArrayList<>(creator.getVideo());
            model.addAttribute("videosToBeUpdated", videos);
            return "updateCreator"; // Assurez-vous que "updateCreator" est le nom de votre vue pour la page d'édition
        } else {
            return "error"; // Gérer l'erreur si le créateur n'est pas trouvé
        }
    }

    @PostMapping("/modifiercreator")
    public String updateCreator(Model model, @RequestParam(name = "id") Integer id,
                                @RequestParam(name = "name") String name,
                                @RequestParam(name = "mail") String mail,
                                @RequestParam(name = "videoName") String[] videoNames,
                                @RequestParam(name = "videoUrl") String[] videoUrls,
                                @RequestParam(name = "videodesc") String[] videoDescriptions) {
        Creator creatorToUpdate = creatorManager.getCreatorById(id);
        if (creatorToUpdate != null) {
            creatorToUpdate.setNom(name);
            creatorToUpdate.setEmail(mail);

            List<Video> updatedVideos = new ArrayList<>();
            for (int i = 0; i < videoNames.length; i++) {
                Video video = new Video();
                video.setName(videoNames[i]);
                video.setUrl(videoUrls[i]);
                video.setDescription(videoDescriptions[i]);
                updatedVideos.add(video);
            }
            creatorToUpdate.setVideo(updatedVideos);
            creatorManager.updateCreator(creatorToUpdate);
            return "redirect:/indexpage";
        } else {
            return "error";
        }
    }
    @GetMapping("/indexpage")
    public String listProduitsAction(Model model,
                                     @RequestParam(name = "page", defaultValue = "0") int page,
                                     @RequestParam(name = "taille", defaultValue = "3") int taille,
                                     @RequestParam(name = "search", defaultValue = "") String search) {
        Page<Creator> creators;
        creators = creatorManager.searchCreator(search, page, taille);

        model.addAttribute("listcreator", creators.getContent());
        model.addAttribute("pages", new int[creators.getTotalPages()]);
        model.addAttribute("currentPage", page);
        model.addAttribute("search", search);
        return "creatorlayout";
    }






}