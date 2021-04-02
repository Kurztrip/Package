package com.kurztrip.packages.service;

import com.kurztrip.packages.model.Package;
import com.kurztrip.packages.repository.PackageRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PackageService {
    private final PackageRepository packageRepository;

    public PackageService(PackageRepository packageRepository) {
        this.packageRepository = packageRepository;
    }

    public Iterable<Package> findAll(){ return packageRepository.findAll();}

    public Optional<Package> findById(Integer id){ return packageRepository.findById(id);}

    public Package save(Package pack){ return packageRepository.save(pack);}

    public void deleteById(Integer id){ packageRepository.deleteById(id);}


}
