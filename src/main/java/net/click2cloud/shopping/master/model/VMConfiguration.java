/**
 * 
 */
package net.click2cloud.shopping.master.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

/**
 * @author vivek-cropdata
 *
 */
@Entity
@Table(name = "vm_configuration", schema = "ams")
@Data
public class VMConfiguration {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Integer id;

	@Column(name = "VMID")
	private String vmID;

	@Column(name = "OperatingSystem")
	private String osName;

	@Column(name = "Ram")
	private String ram;

	@Column(name = "Cpu")
	private String vcpu;

	@Column(name = "VmType")
	private String vmType;

	@Column(name = "PrivateIP")
	private String privateIp;

	@Column(name = "PublicIP")
	private String publicIp;

}
