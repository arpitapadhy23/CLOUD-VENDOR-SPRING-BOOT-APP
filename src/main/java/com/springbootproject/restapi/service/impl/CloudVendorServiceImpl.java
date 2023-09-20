package com.springbootproject.restapi.service.impl;

import com.springbootproject.restapi.exception.CloudVendorNotFoundException;
import com.springbootproject.restapi.model.CloudVendor;
import com.springbootproject.restapi.repository.CloudVendorRepository;
import com.springbootproject.restapi.service.CloudVendorService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class CloudVendorServiceImpl implements CloudVendorService {


    CloudVendorRepository cloudVendorRepository;
    public CloudVendorServiceImpl(CloudVendorRepository cloudVendorRepository) {
        this.cloudVendorRepository = cloudVendorRepository;
    }



    @Override
    public String createCloudVendor(CloudVendor cloudVendor) {
        cloudVendorRepository.save(cloudVendor);
        return "Successfully done";
    }

    @Override
    public String updateCloudVendor(CloudVendor cloudVendor) {
        cloudVendorRepository.save(cloudVendor);
        return "Success";
    }

    @Override
    public String deleteCloudVendor(String cloudVendorId) {
        cloudVendorRepository.deleteById(cloudVendorId);
        return "successfully deleted";
    }

    @Override
    public CloudVendor getCloudVendor(String cloudVendorId) {

        if(cloudVendorRepository.findById(cloudVendorId).isEmpty()){
            throw new CloudVendorNotFoundException("Requested Cloud Vendor does not exsist");
        }
        return cloudVendorRepository.findById(cloudVendorId).get();
    }

    @Override
    public List<CloudVendor> getALlCloudVendors() {
        return cloudVendorRepository.findAll();
    }
}
