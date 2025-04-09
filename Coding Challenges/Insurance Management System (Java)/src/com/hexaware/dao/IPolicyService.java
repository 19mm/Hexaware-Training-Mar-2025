package com.hexaware.dao;

import com.hexaware.entity.*;
import java.util.Collection;

public interface IPolicyService {
	//Declaration of required methods
    boolean createPolicy(Policy policy) ;
    Policy getPolicy(int policyId) throws Exception;
    Collection<Policy> getAllPolicies() throws Exception;
    boolean updatePolicy(Policy policy) throws Exception;
    boolean deletePolicy(int policyId) throws Exception;
}
