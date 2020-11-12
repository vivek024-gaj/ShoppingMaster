/**
 * 
 */
package net.click2cloud.shopping.master.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import net.click2cloud.shopping.master.model.DockerContainer;
import net.click2cloud.shopping.master.model.VM;
import net.click2cloud.shopping.master.model.VMConfiguration;
import net.click2cloud.shopping.master.response.ResponseMessage;
import net.click2cloud.shopping.master.service.impl.DevOpsService;

/**
 * @author vivek-cropdata
 *
 */
@RestController
public class DevOpsController {

	@Autowired
	DevOpsService devOpsService;

	@PostMapping("/vm-save")
	public ResponseMessage addVm(@RequestBody VM vm) {
		return this.devOpsService.addNewVM(vm);
	}

	@GetMapping("/vm-all")
	public List<VM> vmList() {
		return this.devOpsService.listOfVms();
	}

	@PostMapping("/vm-config-save")
	public ResponseMessage addVmConfig(VMConfiguration vmConfiguration) {
		return this.devOpsService.addVMConfiguration(vmConfiguration);
	}

	@GetMapping("/vmc-all")
	public List<VMConfiguration> vmCLIst() {
		return this.devOpsService.listOfVmConfigurations();
	}

	@PostMapping("/dc-save")
	public ResponseMessage addContainer(@RequestBody DockerContainer dockerContainer) {
		return this.devOpsService.addDockerContainer(dockerContainer);
	}

	@GetMapping("/dc-all")
	public List<DockerContainer> dcList() {
		return this.devOpsService.listOfDockerContainers();
	}

}
