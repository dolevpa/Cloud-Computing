package users.Data;


import org.springframework.data.repository.PagingAndSortingRepository;


public interface UserDao extends PagingAndSortingRepository<UserEntity, String>{
	
//	@Query(value = "SELECT * FROM USER_TBL WHERE email LIKE %domain%")
//	public List<UserEntity> findAllByEmailContainDomain(
//			@Param("domain")String domain,
//			Pageable pageable);

}
