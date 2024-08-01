package com.apirest.autorentax;

import com.apirest.autorentax.models.dao.IUserDao;
import com.apirest.autorentax.models.entity.Permission;
import com.apirest.autorentax.models.entity.Role;
import com.apirest.autorentax.models.entity.RoleEnum;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Set;

@SpringBootApplication
public class AutorentaxApplication {

	public static void main(String[] args) {
		SpringApplication.run(AutorentaxApplication.class, args);
		System.out.println("Autorentax running...");
	}

//	@Bean
//	CommandLineRunner init(IUserDao userDao){
//		return args -> {
//			Permission createPermission = Permission.builder()
//					.name("CREATE")
//					.build();
//			Permission readPermission = Permission.builder()
//					.name("CREATE")
//					.build();
//			Permission updatePermission = Permission.builder()
//					.name("CREATE")
//					.build();
//			Permission deletePermission = Permission.builder()
//					.name("CREATE")
//					.build();
//
//			Role roleAdmin = Role.builder()
//					.roleEnum(RoleEnum.ADMIN)
//					.permissionList(Set.of(createPermission, readPermission, updatePermission, deletePermission))
//					.build;
//
//			Role roleUser = Role.builder()
//					.roleEnum(RoleEnum.USER)
//					.permissionList(Set.of(createPermission, readPermission, updatePermission))
//					.build;
//
//			Role roleVisit = Role.builder()
//					.roleEnum(RoleEnum.VISIT)
//					.permissionList(Set.of(readPermission))
//					.build;
//		};
//	}
}
