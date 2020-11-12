/**
 * 
 */
package net.click2cloud.shopping.master.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import net.click2cloud.shopping.master.model.DockerContainer;
import net.click2cloud.shopping.master.model.VM;
import net.click2cloud.shopping.master.model.VMConfiguration;
import net.click2cloud.shopping.master.repository.DockerContainerRepository;
import net.click2cloud.shopping.master.repository.VMConfigurationRepository;
import net.click2cloud.shopping.master.repository.VMRepository;
import net.click2cloud.shopping.master.response.ResponseMessage;
import net.click2cloud.shopping.master.utils.ResponseMessageUtil;

/**
 * @author vivek-cropdata
 *
 */
@Service
public class DevOpsService {

	@Autowired
	VMRepository vmRepository;

	@Autowired
	VMConfigurationRepository vmConfigurationRepository;

	@Autowired
	DockerContainerRepository dockerContainerRepository;

	@Autowired
	ResponseMessageUtil responseMessageUtil;
	
	
	@Autowired
	PasswordEncoder passwordEncoder;

	public ResponseMessage addNewVM(VM vm) {
		
		String vmPassword = passwordEncoder.encode(vm.getPassword());
		vm.setPassword(vmPassword);
		VM vMsave = this.vmRepository.save(vm);
		if (vMsave != null) {
			return responseMessageUtil.sendResponse(true, vm.getName() + " vm added", "");
		} else {
			return responseMessageUtil.sendResponse(true, vm.getName(), "something wrong");
		}
	}

	public List<VM> listOfVms() {
		return this.vmRepository.findAll();
	}

	public ResponseMessage addVMConfiguration(VMConfiguration vmConfiguration) {
		VMConfiguration vMCsave = this.vmConfigurationRepository.save(vmConfiguration);
		if (vMCsave != null) {
			return responseMessageUtil.sendResponse(true, " vm configuration added", "");
		} else {
			return responseMessageUtil.sendResponse(true, "", "something wrong");
		}
	}

	public List<VMConfiguration> listOfVmConfigurations() {
		return this.vmConfigurationRepository.findAll();
	}

	public ResponseMessage addDockerContainer(DockerContainer dockerContainer) {
		DockerContainer dCsave = this.dockerContainerRepository.save(dockerContainer);
		if (dCsave != null) {
			return responseMessageUtil.sendResponse(true, " docker container added", "");
		} else {
			return responseMessageUtil.sendResponse(true, "", "something wrong");
		}
	}

	public List<DockerContainer> listOfDockerContainers() {
		return this.dockerContainerRepository.findAll();
	}

}
