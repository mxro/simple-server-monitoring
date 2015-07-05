package com.appjangle.servermonitoring.jre;

@SuppressWarnings("all")
public class TestRun {
  public static void main(final String[] args) {
    ServerMonitoring.main(
      new String[] { "https://ajadmin.nxweb.de/admin1/admin1/.n/Monitoring_and_Logging/.n/Nodes/.n/minivps1/.n/Instructions", "7zuatt3ma4u3ow29" });
    Runtime _runtime = Runtime.getRuntime();
    final long heapSize = _runtime.totalMemory();
    System.out.println(("Heap Size = " + Long.valueOf(heapSize)));
  }
}
