package googledrive.domain;

import googledrive.infra.AbstractEvent;
import java.util.*;
import lombok.Data;

@Data
public class VideoProdessed extends AbstractEvent {

    private Long id;
    private String fileid;
    private String url;
}
