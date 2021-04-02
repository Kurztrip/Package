package com.kurztrip.packages.repository;

import com.kurztrip.packages.model.Package;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PackageRepository extends CrudRepository<Package, Integer> {

}
