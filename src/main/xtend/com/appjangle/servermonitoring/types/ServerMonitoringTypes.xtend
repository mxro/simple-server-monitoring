package com.appjangle.servermonitoring.types

import io.nextweb.Session

class ServerMonitoringTypes {
	
	Session session;
	
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
	
	new(Session session) {
		this.session = session;
	}
	
	
	
}