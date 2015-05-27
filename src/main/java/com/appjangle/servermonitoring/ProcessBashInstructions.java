package com.appjangle.servermonitoring;

import com.appjangle.servermonitoring.types.ServerMonitoringTypes;
import io.nextweb.Link;
import io.nextweb.ListQuery;
import io.nextweb.Node;
import io.nextweb.NodeList;
import io.nextweb.Session;

@SuppressWarnings("all")
public class ProcessBashInstructions {
  private Node node;
  
  public void now() {
    Session _session = this.node.session();
    ServerMonitoringTypes t = new ServerMonitoringTypes(_session);
    Link _bashInstruction = t.bashInstruction();
    ListQuery _selectAll = this.node.selectAll(_bashInstruction);
    final NodeList bashInstructions = _selectAll.get();
    for (final Node bashInstruction : bashInstructions) {
    }
  }
  
  public ProcessBashInstructions(final Node node) {
    this.node = node;
  }
}
