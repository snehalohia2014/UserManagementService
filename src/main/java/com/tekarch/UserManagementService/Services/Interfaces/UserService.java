package com.tekarch.UserManagementService.Services.Interfaces;

import com.tekarch.UserManagementService.Model.User;

import java.util.List;
import java.util.Optional;

public interface UserService {

    User createUser(User user);

    List<User> getAllUsers();

    Optional<User> getUserById(Long userId);

    User updateUser(Long userId, User updatedUser);

    void deleteUser(Long userId);

//    void addPersonalInfo(Long userId, PersonalInfo personalInfo);
//    PersonalInfo getPersonalInfo(Long userId);
//
//    Account addLinkedAccount(Long userId, Account account);
//    List<Account> getLinkedAccounts(Long userId);
//    Optional<Account> getAccountById(Long userId, Long accountId);
//    Account updateLinkedAccount(Long userId, Long accountId, Account updatedAccount);
//    void deleteLinkedAccount(Long userId, Long accountId);
//
//    void submitKYC(Long userId, KYC kyc);
//    KYC getKYC(Long userId);
//    void updateKYC(Long userId, KYC updatedKYC);
//    void deleteKYC(Long userId);
}
