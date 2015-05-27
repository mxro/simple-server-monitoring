package com.appjangle.servermonitoring.jre

class ServerMonitoring {
	
	def static main(String[] args) {
		if (args.length != 2) {
			throw new RuntimeException("Supply two arguments: Node and Secret")
		}
		
		val uri = args.get(0)
		val secret = args.get(1)
		
		
	}
	
}