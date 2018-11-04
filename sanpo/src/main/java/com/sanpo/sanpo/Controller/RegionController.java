package com.sanpo.sanpo.Controller;

import com.sanpo.sanpo.Model.Region;
import com.sanpo.sanpo.Model.Session;
import com.sanpo.sanpo.Model.User;
import com.sanpo.sanpo.Repository.RegionRepository;
import com.sanpo.sanpo.Repository.SessionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/regions")
public class RegionController {

    @Autowired
    RegionRepository repo;
    @Autowired
    SessionRepository repo1;

    @GetMapping
    public List<Region> getAll () {
        List<Region> result = new ArrayList<>();
        for (Region r: repo.findAll()) {
            result.add(r);
        }
        return result;
    }

    @GetMapping("/{regionId}")
    public Region getRegion(@PathVariable("regionId") String regionId) {
        Region r = repo.findById(regionId).get();
        return r;
    }

    @PostMapping
    public Region putRegion(@RequestBody Region region) {
        return repo.save(region);
    }

    @PutMapping("/{regionId}")
    public Region addSession(@PathVariable("regionId") String regionId, @RequestBody String sessionId) {
        Region region = repo.findById(regionId).get();
        List<Session> sLst = region.getSessions();
        Session session = repo1.findById(sessionId).get();
        sLst.add(session);
        return repo.save(region);

    }
}
