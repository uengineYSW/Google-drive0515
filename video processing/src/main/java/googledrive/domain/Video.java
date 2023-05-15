package googledrive.domain;

import googledrive.VideoProcessingApplication;
import googledrive.domain.VideoProdessed;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;

@Entity
@Table(name = "Video_table")
@Data
public class Video {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String fileid;

    private String url;

    @PostPersist
    public void onPostPersist() {
        VideoProdessed videoProdessed = new VideoProdessed(this);
        videoProdessed.publishAfterCommit();
    }

    public static VideoRepository repository() {
        VideoRepository videoRepository = VideoProcessingApplication.applicationContext.getBean(
            VideoRepository.class
        );
        return videoRepository;
    }

    public static void processVideo(Fileuploaded fileuploaded) {
        /** Example 1:  new item 
        Video video = new Video();
        repository().save(video);

        VideoProdessed videoProdessed = new VideoProdessed(video);
        videoProdessed.publishAfterCommit();
        */

        /** Example 2:  finding and process
        
        repository().findById(fileuploaded.get???()).ifPresent(video->{
            
            video // do something
            repository().save(video);

            VideoProdessed videoProdessed = new VideoProdessed(video);
            videoProdessed.publishAfterCommit();

         });
        */

    }
}
