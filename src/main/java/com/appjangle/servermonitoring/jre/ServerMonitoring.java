package com.appjangle.servermonitoring.jre;

@SuppressWarnings("all")
public class ServerMonitoring {
  public static void main(final String[] args) {
    int _length = args.length;
    boolean _notEquals = (_length != 2);
    if (_notEquals) {
      throw new RuntimeException("Supply two arguments: Node and Secret");
    }
  }
}
