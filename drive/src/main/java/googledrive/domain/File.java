package googledrive.domain;

import googledrive.DriveApplication;
import googledrive.domain.Fileuploaded;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;

@Entity
@Table(name = "File_table")
@Data
public class File {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String filename;

    private String path;

    private Integer size;

    private String type;

    @PostPersist
    public void onPostPersist() {
        Fileuploaded fileuploaded = new Fileuploaded(this);
        fileuploaded.publishAfterCommit();
    }

    public static FileRepository repository() {
        FileRepository fileRepository = DriveApplication.applicationContext.getBean(
            FileRepository.class
        );
        return fileRepository;
    }
}
