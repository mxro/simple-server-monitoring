package com.appjangle.servermonitoring.types

import io.nextweb.Session

class ServerMonitoringTypes {
	
	Session session;
	
	def instructionGroup() {
		return session.link("https://ajadmin.nxweb.de/admin1/admin1/.n/Monitoring_and_Logging/.n/Types/.n/Instruction_Group")
	}
	
	def bashInstruction() {
		return session.link("https://ajadmin.nxweb.de/admin1/admin1/.n/Monitoring_and_Logging/.n/Types/.n/Bash_Instruction")
	}
	
	def bashScript() {
		return session.link("https://ajadmin.nxweb.de/admin1/admin1/.n/Monitoring_and_Logging/.n/Types/.n/Bash_Script");
	}
	
	def result() {
		session.link("https://ajadmin.nxweb.de/admin1/admin1/.n/Monitoring_and_Logging/.n/Types/.n/Result");
	}
	
	
	
	
}