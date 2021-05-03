package com.kurztrip.packages.controller;


import com.kurztrip.packages.model.Package;
import com.kurztrip.packages.requestmodel.RequestPackage;
import com.kurztrip.packages.service.PackageService;
import com.kurztrip.packages.service.PackageServiceHTTP;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
public class PackageController {
    private final PackageService packageService;

    public PackageController(PackageService packageService) {
        this.packageService = packageService;
    }

    @GetMapping(path = "/packages")
    public @ResponseBody ResponseEntity<List<Package>> getAllPackages(){
        List<Package> packages = (List<Package>) this.packageService.findAll();
        return ResponseEntity.ok(packages);
    }

    @GetMapping(path = "/packages/{id}")
    public @ResponseBody ResponseEntity<Package> getPackage(@PathVariable Integer id){
        Optional<Package> optionalPackage =this.packageService.findById(id);
        if(optionalPackage.isEmpty()){
            return ResponseEntity.badRequest().body(null);
        }
        Package pack = optionalPackage.get();
        return ResponseEntity.ok(pack);
    }

    @PutMapping(path = "/packages/update/{id}")
    public ResponseEntity<Package> replacePackage(@PathVariable Integer id, @RequestBody RequestPackage requestPackage){
        Optional<Package> optionalPackage =this.packageService.findById(id);
        if(optionalPackage.isEmpty()){
            return ResponseEntity.badRequest().body(null);
        }
        Package pack = optionalPackage.get();
        pack.setAddress(requestPackage.getAddress());
        pack.setWeight(requestPackage.getWeight());
        pack.setVolume(requestPackage.getVolume());
        pack.setLatitude(requestPackage.getLatitude());
        pack.setLongitude(requestPackage.getLongitude());
        pack.setStoreId(requestPackage.getStoreId());
        pack.setReceiver(requestPackage.getReceiver());
        pack.setIdReceiver(requestPackage.getIdReceiver());
        this.packageService.save(pack);
        return ResponseEntity.ok().body(pack);
    }

    @PostMapping(path = "/packages/add")
    public @ResponseBody ResponseEntity<Package> addNewPackage(@RequestBody RequestPackage requestPackage){
        Package pack = new Package();
        pack.setAddress(requestPackage.getAddress());
        pack.setWeight(requestPackage.getWeight());
        pack.setVolume(requestPackage.getVolume());
        pack.setLatitude(requestPackage.getLatitude());
        pack.setLongitude(requestPackage.getLongitude());
        pack.setStoreId(requestPackage.getStoreId());
        pack.setReceiver(requestPackage.getReceiver());
        pack.setIdReceiver(requestPackage.getIdReceiver());
        Package saved = this.packageService.save(pack);
        return ResponseEntity.ok(saved);
    }

    @DeleteMapping(path = "/packages/delete/{id}")
    public ResponseEntity<Void> deletePackage(@PathVariable Integer id){
        Optional<Package> optionalPackage = this.packageService.findById(id);
        if(optionalPackage.isEmpty()){
            return  new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        this.packageService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }


}
