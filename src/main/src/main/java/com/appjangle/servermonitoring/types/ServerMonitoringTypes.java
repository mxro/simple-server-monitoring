package com.appjangle.servermonitoring.types;

import io.nextweb.Link;
import io.nextweb.Session;

@SuppressWarnings("all")
public class ServerMonitoringTypes {
  private Session session;
  
  public Link instructionGroup() {
    return this.session.link("https://ajadmin.nxweb.de/admin1/admin1/.n/Monitoring_and_Logging/.n/Types/.n/Instruction_Group");
  }
  
  public Link bashInstruction() {
    return this.session.link("https://ajadmin.nxweb.de/admin1/admin1/.n/Monitoring_and_Logging/.n/Types/.n/Bash_Instruction");
  }
  
  public Link bashScript() {
    return this.session.link("https://ajadmin.nxweb.de/admin1/admin1/.n/Monitoring_and_Logging/.n/Types/.n/Bash_Script");
  }
  
  public Link result() {
    return this.session.link("https://ajadmin.nxweb.de/admin1/admin1/.n/Monitoring_and_Logging/.n/Types/.n/Result");
  }
  
  public ServerMonitoringTypes(final Session session) {
    this.session = session;
  }
}
