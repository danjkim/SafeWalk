package com.sanpo.sanpo.Controller;

import com.sanpo.sanpo.Model.Region;
import com.sanpo.sanpo.Model.Session;
import com.sanpo.sanpo.Model.User;
import com.sanpo.sanpo.Repository.RegionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/regions")
public class RegionController {

    @Autowired
    RegionRepository repo;

    @GetMapping
    public List<Region> getAll () {
        List<Region> result = new ArrayList<>();
        for (Region r: repo.findAll()) {
            result.add(r);
        }
        return result;
    }

    @GetMapping("/{regionName}")
    public Region getRegion(@PathVariable("regionName") String regionName) {
        Region r = repo.findById(regionName).get();
        return r;
    }

    @PostMapping
    public Region putRegion(@RequestBody Region region) {
        return repo.save(region);
    }

    @PutMapping("/{regionId}")
    public Region addSession(@PathVariable("regionId") String regionId, @RequestBody Session session) {
        Region region = repo.findById(regionId).get();
        List<Session> sLst = region.getSessions();
        sLst.add(session);
        return repo.save(region);

    }
}
