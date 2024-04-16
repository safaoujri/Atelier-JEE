package ma.xproce.inventoryservice.service;

import ma.xproce.inventoryservice.dao.entities.Creator;
import ma.xproce.inventoryservice.dao.entities.Video;
import org.springframework.data.domain.Page;

import java.util.List;

public interface VideoManager {
    public Video addVideo(Video video);
    public Video updateVideo(Video video);
    public boolean deleteVideo(Integer id);
    public List<Video> getAllVideos();
    public Video getVideoById(Integer id);


}
