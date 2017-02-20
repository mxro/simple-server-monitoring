package com.appjangle.servermonitoring.jre;

import com.appjangle.api.Client;
import com.appjangle.api.Node;
import com.appjangle.api.NodeList;
import com.appjangle.api.jre.ClientsGeneralJre;
import com.appjangle.servermonitoring.jre.instructions.ProcessBashInstructions;
import com.appjangle.servermonitoring.types.ServerMonitoringTypes;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import org.eclipse.xtext.xbase.lib.InputOutput;

@SuppressWarnings("all")
public class ServerMonitoring {
  public static void main(final String[] args) {
    int _length = args.length;
    boolean _notEquals = (_length != 2);
    if (_notEquals) {
      throw new RuntimeException("Supply two arguments: Node and Secret");
    }
    final Timer timer = new Timer();
    timer.schedule(new TimerTask() {
      @Override
      public void run() {
        InputOutput.<String>println("Operations not completed within timeout.");
        System.exit(0);
      }
    }, ((1000 * 60) * 3));
    final String uri = args[0];
    final String secret = args[1];
    final Client session = ClientsGeneralJre.createClient();
    final ServerMonitoringTypes t = new ServerMonitoringTypes(session);
    final Node root = session.link(uri, secret).get();
    String _uri = root.uri();
    String _plus = ("Loaded instructions: " + _uri);
    InputOutput.<String>println(_plus);
    final NodeList groups = root.selectAll(t.instructionGroup()).get();
    List<Node> _nodes = groups.nodes();
    for (final Node group : _nodes) {
      {
        String _uri_1 = group.uri();
        String _plus_1 = ("Processing group: " + _uri_1);
        InputOutput.<String>println(_plus_1);
        new ProcessBashInstructions(group).now();
      }
    }
    session.close().get();
    timer.cancel();
  }
}
