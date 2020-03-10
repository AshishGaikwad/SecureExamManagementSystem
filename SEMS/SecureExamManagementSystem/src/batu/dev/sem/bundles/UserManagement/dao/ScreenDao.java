package batu.dev.sem.bundles.UserManagement.dao;

import java.util.List;

import batu.dev.sem.bundles.UserManagement.entity.ScreenEntity;

public interface ScreenDao {
	public List<ScreenEntity> getScreenForUser(long pUserId);
	public List<ScreenEntity> getScreenAll(String lCommand) ;
}
