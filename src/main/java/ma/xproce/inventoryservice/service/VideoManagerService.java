package ma.xproce.inventoryservice.service;

import ma.xproce.inventoryservice.dao.entities.Creator;
import ma.xproce.inventoryservice.dao.entities.Video;
import ma.xproce.inventoryservice.dao.repositories.VideoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VideoManagerService implements VideoManager {

    private final VideoRepository videoRepository;

    @Autowired
    public VideoManagerService(VideoRepository videoRepository) {
        this.videoRepository = videoRepository;
    }


    @Override
    public Video addVideo(Video video) {

        return videoRepository.save(video);
    }

    @Override
    public Video updateVideo(Video video) {
        return videoRepository.save(video);
    }

    @Override
    public boolean deleteVideo(Integer id) {
        videoRepository.deleteById(id);
        return true;
    }

    @Override
    public List<Video> getAllVideos() {
        return videoRepository.findAll();
    }
    public Video getVideoById(Integer id) {
        return videoRepository.findById(id).get();
    }


}









