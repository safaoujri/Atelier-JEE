package ma.xproce.inventoryservice.service;


import ma.xproce.inventoryservice.dao.entities.Creator;
import org.springframework.data.domain.Page;

import java.util.List;

public interface CreatorManager {
        public Creator addCreator(Creator creator);
        public Creator updateCreator(Creator creator);
        public Page<Creator> searchCreator(String keyword, int page, int taille);

        public boolean deleteCreator(Integer id);
        public List<Creator> getAllCreators();
        public Creator getCreatorById(Integer id);
        public Page<Creator> getAllCreators(int page, int taille);

}
