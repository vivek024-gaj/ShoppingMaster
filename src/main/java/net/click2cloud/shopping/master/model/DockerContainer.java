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
@Table(name = "docker_container", schema = "ams")
@Data
public class DockerContainer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Integer id;

	@Column(name = "VMID")
	private String vmID;
	
	@Column(name = "Name")
	private String name;
	
	@Column(name = "InternalPort")
	private Integer internalPort;
	
	@Column(name = "ExternalPort")
	private Integer externalPort;
	
	@Column(name = "RegisteryName")
	private String registeryName;
	
	@Column(name = "Status")
	private String status;
	

}
