package googledrive.domain;

import googledrive.domain.*;
import googledrive.infra.AbstractEvent;
import java.util.*;
import lombok.*;

@Data
@ToString
public class VideoProdessed extends AbstractEvent {

    private Long id;
    private String fileid;
    private String url;

    public VideoProdessed(Video aggregate) {
        super(aggregate);
    }

    public VideoProdessed() {
        super();
    }
}
