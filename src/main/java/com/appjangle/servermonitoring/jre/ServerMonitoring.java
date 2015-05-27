package com.appjangle.servermonitoring.jre;

import com.appjangle.servermonitoring.ProcessBashInstructions;
import com.appjangle.servermonitoring.types.ServerMonitoringTypes;
import io.nextweb.Link;
import io.nextweb.ListQuery;
import io.nextweb.Node;
import io.nextweb.NodeList;
import io.nextweb.Session;
import io.nextweb.jre.Nextweb;
import java.util.List;
import org.eclipse.xtext.xbase.lib.InputOutput;

@SuppressWarnings("all")
public class ServerMonitoring {
  public static void main(final String[] args) {
    int _length = args.length;
    boolean _notEquals = (_length != 2);
    if (_notEquals) {
      throw new RuntimeException("Supply two arguments: Node and Secret");
    }
    final String uri = args[0];
    final String secret = args[1];
    final Session session = Nextweb.createSession();
    final ServerMonitoringTypes t = new ServerMonitoringTypes(session);
    Link _link = session.link(uri, secret);
    final Node root = _link.get();
    String _uri = root.uri();
    String _plus = ("Loaded instructions: " + _uri);
    InputOutput.<String>println(_plus);
    Link _instructionGroup = t.instructionGroup();
    ListQuery _selectAll = root.selectAll(_instructionGroup);
    final NodeList groups = _selectAll.get();
    List<Node> _nodes = groups.nodes();
    for (final Node group : _nodes) {
      {
        String _uri_1 = group.uri();
        String _plus_1 = ("Processing group: " + _uri_1);
        InputOutput.<String>println(_plus_1);
        ProcessBashInstructions _processBashInstructions = new ProcessBashInstructions(group);
        _processBashInstructions.now();
      }
    }
  }
}
