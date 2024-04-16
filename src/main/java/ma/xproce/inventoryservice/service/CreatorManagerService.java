package ma.xproce.inventoryservice.service;

import ma.xproce.inventoryservice.dao.entities.Creator;
import ma.xproce.inventoryservice.dao.repositories.CreatorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CreatorManagerService implements CreatorManager {
    private final CreatorRepository creatorRepository;

    @Autowired
    public CreatorManagerService(CreatorRepository creatorRepository) {
        this.creatorRepository = creatorRepository;
    }

    @Override
    public Creator addCreator(Creator creator) {

        return creatorRepository.save(creator);
    }

    @Override
    public Creator updateCreator(Creator creator) {
        return creatorRepository.save(creator);
    }

    @Override
    public boolean deleteCreator(Integer id) {
        try {
            creatorRepository.deleteById(id);
            return true;
        } catch (Exception exception) {
            return false;
        }
    }

    @Override
    public List<Creator> getAllCreators() {
        return creatorRepository.findAll();
    }
    @Override
    public Creator getCreatorById(Integer id) {
        return creatorRepository.findById(id).orElse(null);
    }

    @Override
    public Page<Creator> getAllCreators(int page, int taille) {
            return creatorRepository.findAll(PageRequest.of(page, taille));

    }

    @Override
    public Page<Creator> searchCreator(String keyword, int page, int taille){
        return creatorRepository.findByNomContains(keyword, PageRequest.of(page, taille));

    }

}
