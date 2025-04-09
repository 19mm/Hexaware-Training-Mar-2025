package com.hexaware.dao;

import com.hexaware.entity.Policy;
import com.hexaware.exception.PolicyNotFoundException;
import com.hexaware.util.DBConnUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;

public class InsuranceServiceImpl implements IPolicyService {

	// Create Policy Method Defination
    @Override
    public boolean createPolicy(Policy policy) {
        String sql = "INSERT INTO POLICY (policyId, policyNumber, policyType, premium) VALUES (?, ?, ?, ?)";
        try {
            Connection conn = DBConnUtil.getConnection();
            try (PreparedStatement ps = conn.prepareStatement(sql)) {
                ps.setInt(1, policy.getPolicyId());
                ps.setString(2, policy.getPolicyNumber());
                ps.setString(3, policy.getPolicyType());
                ps.setDouble(4, policy.getPremium());
                int rows = ps.executeUpdate();
                return rows > 0;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    
    //Get Policy By "Id" method Defination
    @Override
    public Policy getPolicy(int policyId) throws Exception {
        String sql = "SELECT * FROM POLICY WHERE policyId = ?";
        Connection conn = DBConnUtil.getConnection();
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, policyId);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    Policy policy = new Policy();
                    policy.setPolicyId(rs.getInt("policyId"));
                    policy.setPolicyNumber(rs.getString("policyNumber"));
                    policy.setPolicyType(rs.getString("policyType"));
                    policy.setPremium(rs.getDouble("premium"));
                    return policy;
                } else {
                    throw new PolicyNotFoundException("Policy with id " + policyId + " not found.");
                }
            }
        }
    }

    //Retrive All policies method Defination
    @Override
    public Collection<Policy> getAllPolicies() throws Exception {
        Collection<Policy> policies = new ArrayList<>();
        String sql = "SELECT * FROM POLICY";
        Connection conn = DBConnUtil.getConnection();
        try (Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Policy policy = new Policy();
                policy.setPolicyId(rs.getInt("policyId"));
                policy.setPolicyNumber(rs.getString("policyNumber"));
                policy.setPolicyType(rs.getString("policyType"));
                policy.setPremium(rs.getDouble("premium"));
                policies.add(policy);
            }
        }
        return policies;
    }

    //Update Policy method Defination
    @Override
    public boolean updatePolicy(Policy policy) throws Exception {
        String sql = "UPDATE POLICY SET policyNumber = ?, policyType = ?, premium = ? WHERE policyId = ?";
        Connection conn = DBConnUtil.getConnection();
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, policy.getPolicyNumber());
            ps.setString(2, policy.getPolicyType());
            ps.setDouble(3, policy.getPremium());
            ps.setInt(4, policy.getPolicyId());
            int rows = ps.executeUpdate();
            if (rows == 0) {
                throw new PolicyNotFoundException("Policy with id " + policy.getPolicyId() + " not found for update.");
            }
            return rows > 0;
        }
    }

    //Delete Policy Method Defination
    @Override
    public boolean deletePolicy(int policyId) throws Exception {
        String sql = "DELETE FROM POLICY WHERE policyId = ?";
        Connection conn = DBConnUtil.getConnection();
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, policyId);
            int rows = ps.executeUpdate();
            if (rows == 0) {
                throw new PolicyNotFoundException("Policy with id " + policyId + " not found for deletion.");
            }
            return rows > 0;
        }
    }
}
