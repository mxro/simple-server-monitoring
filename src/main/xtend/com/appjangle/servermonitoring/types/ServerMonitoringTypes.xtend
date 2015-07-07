package com.appjangle.servermonitoring.types

import com.appjangle.api.Client

class ServerMonitoringTypes {
	
	Client session;
	
	def instructionGroup() {
		session.link("https://ajadmin.nxweb.de/admin1/admin1/.n/Monitoring_and_Logging/.n/Types/.n/Instruction_Group")
	}
	
	def bashInstruction() {
		session.link("https://ajadmin.nxweb.de/admin1/admin1/.n/Monitoring_and_Logging/.n/Types/.n/Bash_Instruction")
	}
	
	def bashScript() {
		session.link("https://ajadmin.nxweb.de/admin1/admin1/.n/Monitoring_and_Logging/.n/Types/.n/Bash_Script");
	}
	
	def result() {
		session.link("https://ajadmin.nxweb.de/admin1/admin1/.n/Monitoring_and_Logging/.n/Types/.n/Result");
	}
	
	new(Client session) {
		this.session = session;
	}
	
	
	
}