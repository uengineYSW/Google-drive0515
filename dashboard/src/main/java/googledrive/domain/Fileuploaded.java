package googledrive.domain;

import googledrive.infra.AbstractEvent;
import java.util.*;
import lombok.Data;

@Data
public class Fileuploaded extends AbstractEvent {

    private Long id;
    private String filename;
    private String path;
    private Integer size;
    private String type;
}
