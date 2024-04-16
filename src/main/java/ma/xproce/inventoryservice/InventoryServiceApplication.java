package ma.xproce.inventoryservice;

import ma.xproce.inventoryservice.dao.entities.Creator;
import ma.xproce.inventoryservice.dao.entities.Video;
import ma.xproce.inventoryservice.dao.repositories.CreatorRepository;
import ma.xproce.inventoryservice.dao.repositories.VideoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@SpringBootApplication
public class InventoryServiceApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(InventoryServiceApplication.class, args);
    }
    @Autowired
    CreatorRepository creatorRepository;
    @Autowired
    VideoRepository videoRepository;

    @Override
    public void run(String... args) throws Exception {
        //Creator c1=new Creator();
        /*c1.setEmail("c1@gmail.com");
        c1.setNom("Creator1");
        creatorRepository.save(c1);
        Video v1=new Video();
        v1.setUrl("URL1");
        v1.setName("Video1");
        v1.setDescription("Description1");
        v1.setDatePublication(new Date(11,07,2023));
        videoRepository.save(v1);
        List<Video>videos=new ArrayList<>();
        videos.add(v1);
        c1.setVideo(videos);
        creatorRepository.save(c1);
        v1.setCreator(c1);
        videoRepository.save(v1);
// Afficher les informations
        System.out.println("Voici le Creator");
        List<Creator> creators = creatorRepository.findAll();
        creators.forEach(creatorFromList -> {
            System.out.println(creatorFromList.toString());
        });
        System.out.println("Voici les videos");
        List<Video>videos1=videoRepository.findAll();
        videos1.forEach(videoFromList->{
            System.out.println(videoFromList.toString());
        });*/


    }
}
