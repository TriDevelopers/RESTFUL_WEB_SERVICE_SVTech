package tri.dev.restful_cam.repository;

import tri.dev.restful_cam.model.infoGathered;
import java.util.List;

import org.springframework.stereotype.Component;

import java.util.LinkedList;

@Component
public class infoGatheredRepository {
    private List<infoGathered> information = new LinkedList<infoGathered>();

    public List<infoGathered> returnAll() {
        return information;
    }

    public void add(infoGathered info) {
        information.add(info);
    }

    public void reset() {
        information = new LinkedList<infoGathered>();
    }
}