package com.yesh.kardex;

import java.util.*;

import org.springframework.beans.factory.annotation.*;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.*;

//import com.yesh.kardex.model.Client;
import com.yesh.kardex.model.Privilege;
import com.yesh.kardex.model.Role;
import com.yesh.kardex.repository.*;

@Component
public class SetupDataLoader implements
  ApplicationListener<ContextRefreshedEvent> {

    boolean alreadySetup = false;

    //@Autowired
    //private ClientRepository clientRepository;
 
    @Autowired
    private RoleRepository roleRepository;
 
    @Autowired
    private PrivilegeRepository privilegeRepository;
 
    @Override
    @Transactional
    public void onApplicationEvent(ContextRefreshedEvent event) {

    	//BCryptPasswordEncoder Encoder = new BCryptPasswordEncoder();
 
        if (alreadySetup)
            return;
        Privilege readPrivilege
          = createPrivilegeIfNotFound("READ_PRIVILEGE");
        Privilege writePrivilege
          = createPrivilegeIfNotFound("WRITE_PRIVILEGE");
 
        List<Privilege> adminPrivileges = Arrays.asList(
          readPrivilege, writePrivilege);        
        createRoleIfNotFound("ROLE_ADMIN", adminPrivileges);
        createRoleIfNotFound("ROLE_USER", Arrays.asList(readPrivilege));
        
        /*
        Role adminRole = roleRepository.findByName("ROLE_ADMIN");
        Client client = new Client();
        client.setName("Test name");
        client.setUsername("test");
        client.setPassword(Encoder.encode("test"));
        client.setEmail("test@test.com");
        client.setRoles(Arrays.asList(adminRole));
        client.setEnabled(true);
        clientRepository.save(client);
        */

        alreadySetup = true;
    }

    @Transactional
    Privilege createPrivilegeIfNotFound(String name) {
 
        Privilege privilege = privilegeRepository.findByName(name);
        if (privilege == null) {
            privilege = new Privilege(name);
            privilegeRepository.save(privilege);
        }
        return privilege;
    }

    @Transactional
    Role createRoleIfNotFound(
      String name, Collection<Privilege> privileges) {
 
        Role role = roleRepository.findByName(name);
        if (role == null) {
            role = new Role(name);
            role.setPrivileges(privileges);
            roleRepository.save(role);
        }
        return role;
    }
}