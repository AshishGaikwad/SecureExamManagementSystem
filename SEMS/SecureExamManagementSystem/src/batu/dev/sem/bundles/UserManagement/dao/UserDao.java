package batu.dev.sem.bundles.UserManagement.dao;

import java.util.List;

import batu.dev.sem.bundles.UserManagement.entity.UserEntity;

public interface UserDao 
{
	public int createUser(UserEntity pUserEntity);
	public long createUserWithReponse(UserEntity pUserEntity);
	public int updateUser(UserEntity pUserEntity);
	public int deleteUser(UserEntity pUserEntity);
	public List<UserEntity> getUser();
	public UserEntity getUser(long pUserId);
	public UserEntity getUser(String pUserName);
	
	
	
	public int validateUser(String pEmail,String pPassword);
}
